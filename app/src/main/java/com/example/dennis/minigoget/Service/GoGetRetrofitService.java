package com.example.dennis.minigoget.Service;

import com.example.dennis.minigoget.Model.AvailableJobs;
import com.example.dennis.minigoget.Model.GoGetLogin;
import com.example.dennis.minigoget.Model.UserContainer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by park on 2016-03-01.
 */
public interface GoGetRetrofitService {

    //Service to request user information.
    @POST("v1/sessions")
    Call<GoGetLogin> login(@Body UserContainer user);
    @GET("v1/gogetters/jobs/available")
    Call<List<AvailableJobs>> getJobs();
    @GET("v1/gogetters/jobs/{jobId}")
    Call<AvailableJobs> getSingleJob(@Path("jobId") int currentId);

}
