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

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by park on 2016-03-22.
 */
public class MiniGoGetService {

    public static void loginAttempt(UserContainer container){
        GoGetRetrofitService loginTesting = ServiceGenerator.createService(GoGetRetrofitService.class);
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
                LoginFailureEvent loginEvent = new LoginFailureEvent("Network Error",true);
                EventBus.getDefault().post(loginEvent);
            }

        });
    }
    public static void requestJobList(String authenToken){

        //Service to retrieve current user's available jobs
        GoGetRetrofitService generateJobs = ServiceGenerator.createService(GoGetRetrofitService.class, authenToken);
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
        GoGetRetrofitService generateJobs = ServiceGenerator.createService(GoGetRetrofitService.class, authenToken);
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

