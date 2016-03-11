package com.example.dennis.minigoget.API;

import com.example.dennis.minigoget.model.availableJobs;
import com.example.dennis.minigoget.model.user;
import com.example.dennis.minigoget.model.gogetLogin;
import com.example.dennis.minigoget.model.userContainer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by park on 2016-03-01.
 */
public interface GoGetService {

    //Service to request user information.
    @POST("v1/sessions")
    Call<gogetLogin> login(@Body userContainer user);
    @GET("v1/gogetters/jobs/available")
    Call<List<availableJobs>> getJobs();
    @GET("v1/gogetters/jobs/{jobId}")
    Call<availableJobs> getSingleJob(@Path("jobId") int currentId);

}
