package com.example.dennis.minigoget.Service;

import android.util.Log;

import com.example.dennis.minigoget.API.GoGetService;
import com.example.dennis.minigoget.Event.LoginFailureEvent;
import com.example.dennis.minigoget.Event.LoginSuccessEvent;
import com.example.dennis.minigoget.Event.NetworkFailureEvent;
import com.example.dennis.minigoget.Event.OnReceiveJobListEvent;
import com.example.dennis.minigoget.Event.OnSingleJobRetrieveEvent;
import com.example.dennis.minigoget.model.availableJobs;
import com.example.dennis.minigoget.model.gogetLogin;
import com.example.dennis.minigoget.model.userContainer;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by park on 2016-03-22.
 */
public class MiniGoGetService {

    public static void loginAttempt(userContainer container){
        GoGetService loginTesting = ServiceGenerator.createService(GoGetService.class);
        Call<gogetLogin> call = loginTesting.login(container);
        call.enqueue(new Callback<gogetLogin>() {
            @Override
            public void onResponse(Call<gogetLogin> call, Response<gogetLogin> response) {
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
            public void onFailure(Call<gogetLogin> call, Throwable t) {
                LoginFailureEvent loginEvent = new LoginFailureEvent("Network Error",true);
                EventBus.getDefault().post(loginEvent);
            }

        });
    }
    public static void requestJobList(String authen_token){

        //Service to retrieve current user's available jobs
        GoGetService generateJobs = ServiceGenerator.createService(GoGetService.class, authen_token);
        Call<List<availableJobs>> call = generateJobs.getJobs();

        call.enqueue(new Callback<List<availableJobs>>() {
            @Override
            public void onResponse(Call<List<availableJobs>> call, Response<List<availableJobs>> response) {
                if (response.isSuccess()) {
                    OnReceiveJobListEvent onReceiveJobListEvent = new OnReceiveJobListEvent(response);
                    EventBus.getDefault().post(onReceiveJobListEvent);

                }
                else {
                }

            }

            //occurs when network error( most likely no network) happens
            @Override
            public void onFailure(Call<List<availableJobs>> call, Throwable t) {
                NetworkFailureEvent networkFailureEvent = new NetworkFailureEvent(t.getMessage());
                EventBus.getDefault().post(networkFailureEvent);
            }
        });
    }
    public static void requestSingleJob(String authen_token, int jobId){

        //Service to retrieve current user's available jobs
        GoGetService generateJobs = ServiceGenerator.createService(GoGetService.class, authen_token);
        Call<availableJobs> call = generateJobs.getSingleJob(jobId);

        call.enqueue(new Callback<availableJobs>() {
            @Override
            public void onResponse(Call<availableJobs> call, Response<availableJobs> response) {
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
            public void onFailure(Call<availableJobs> call, Throwable t) {
                Log.d("requestJobRetrieve: ","Failure");
                NetworkFailureEvent networkFailureEvent = new NetworkFailureEvent(t.getMessage());
                EventBus.getDefault().post(networkFailureEvent);
            }
        });
    }

}

