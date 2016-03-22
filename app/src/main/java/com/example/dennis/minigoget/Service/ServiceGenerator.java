package com.example.dennis.minigoget.Service;

import android.util.Base64;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import io.realm.RealmObject;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by park on 2016-02-29.
 */
public class ServiceGenerator {

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
            public Response intercept(Interceptor.Chain chain) throws IOException {

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
        // }

        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
       // return createService(serviceClass, null, null);
    }
    public static <S> S createService(Class<S> serviceClass, final String authen_token){

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {

                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        //.header("Authorization", basic)
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Token token="+authen_token)
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
    public static <S> S createService(Class<S> serviceClass, String user_id, String user_password){

            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {

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
       // }

        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
