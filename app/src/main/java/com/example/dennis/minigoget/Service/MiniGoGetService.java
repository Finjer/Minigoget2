package com.example.dennis.minigoget.Service;

import android.util.Log;

import com.example.dennis.minigoget.Event.LoginFailureEvent;
import com.example.dennis.minigoget.Event.LoginSuccessEvent;
import com.example.dennis.minigoget.Event.NetworkFailureEvent;
import com.example.dennis.minigoget.Event.OnReceiveJobListEvent;
import com.example.dennis.minigoget.Event.OnSingleJobRetrieveEvent;
import com.example.dennis.minigoget.Model.AvailableJobs;
import com.example.dennis.minigoget.Model.GoGetLogin;
import com.example.dennis.minigoget.Model.UserContainer;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import io.realm.RealmObject;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by park on 2016-03-22.
 */
public class MiniGoGetService {

    public static final String AUTHENTICATION_TOKEN = "authenToken";

    public static final String NET_ERROR_TITLE ="Network Error";
    public static final String LOGIN_ERROR_TITLE ="Login Error";
    public static final String API_URL = "https://staging.goget.my/api/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    //Format to set receiving gson.
    private static Gson mGson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat(DATE_FORMAT)
            .setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getDeclaringClass().equals(RealmObject.class);
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            })
            .create();

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create(mGson));

    public static <S> S createService(Class<S> serviceClass){

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        //.header("Authorization", basic)
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });


        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
        // return createService(serviceClass, null, null);
    }
    public static <S> S createService(Class<S> serviceClass, final String authenToken){

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {

                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        //.header("Authorization", basic)
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Token token="+authenToken)
                        .method(original.method(), original.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        // }

        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
        // return createService(serviceClass, null, null);
    }

    public static void loginAttempt(UserContainer container){
        GoGetRetrofitService loginTesting = createService(GoGetRetrofitService.class);
        Call<GoGetLogin> call = loginTesting.login(container);
        call.enqueue(new Callback<GoGetLogin>() {
            @Override
            public void onResponse(Call<GoGetLogin> call, Response<GoGetLogin> response) {
                if (response.isSuccess() == true) {
                    LoginSuccessEvent loginEvent = new LoginSuccessEvent(response.body().getData().getAuthToken());
                    EventBus.getDefault().post(loginEvent);
                    //token = response.body().getData().getAuthToken();
                } else {
                    LoginFailureEvent loginEvent = new LoginFailureEvent(response.errorBody().toString(),false);
                    EventBus.getDefault().post(loginEvent);
                }
            }
            @Override
            public void onFailure(Call<GoGetLogin> call, Throwable t) {
                LoginFailureEvent loginEvent = new LoginFailureEvent(NET_ERROR_TITLE,true);
                EventBus.getDefault().post(loginEvent);
            }

        });
    }
    public static void requestJobList(String authenToken){

        //Service to retrieve current user's available jobs
        GoGetRetrofitService generateJobs = createService(GoGetRetrofitService.class, authenToken);
        Call<List<AvailableJobs>> call = generateJobs.getJobs();

        call.enqueue(new Callback<List<AvailableJobs>>() {
            @Override
            public void onResponse(Call<List<AvailableJobs>> call, Response<List<AvailableJobs>> response) {
                if (response.isSuccess()) {
                    OnReceiveJobListEvent onReceiveJobListEvent = new OnReceiveJobListEvent(response);
                    EventBus.getDefault().post(onReceiveJobListEvent);
                }
                else {
                }

            }

            //occurs when network error( most likely no network) happens
            @Override
            public void onFailure(Call<List<AvailableJobs>> call, Throwable t) {
                Log.d("numberformat?: ",t.toString());
                NetworkFailureEvent networkFailureEvent = new NetworkFailureEvent(t.getMessage());
                EventBus.getDefault().post(networkFailureEvent);
            }
        });
    }
    public static void requestSingleJob(String authenToken, int jobId){

        //Service to retrieve current user's available jobs
        GoGetRetrofitService generateJobs = createService(GoGetRetrofitService.class, authenToken);
        Call<AvailableJobs> call = generateJobs.getSingleJob(jobId);

        call.enqueue(new Callback<AvailableJobs>() {
            @Override
            public void onResponse(Call<AvailableJobs> call, Response<AvailableJobs> response) {
                if (response.isSuccess()) {
                    Log.d("requestJobRetrieve: ","Sucess if");
                    OnSingleJobRetrieveEvent onReceiveJobListEvent = new OnSingleJobRetrieveEvent(response.body());
                    EventBus.getDefault().post(onReceiveJobListEvent);
                }
                else {
                    Log.d("requestJobRetrieve: ","Sucess else");
                }

            }

            //occurs when network error( most likely no network) happens
            @Override
            public void onFailure(Call<AvailableJobs> call, Throwable t) {
                Log.d("requestJobRetrieve: ","Failure");
                NetworkFailureEvent networkFailureEvent = new NetworkFailureEvent(t.getMessage());
                EventBus.getDefault().post(networkFailureEvent);
            }
        });
    }

}

