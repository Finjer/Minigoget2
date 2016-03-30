package com.example.dennis.minigoget.Event;

import com.example.dennis.minigoget.Model.AvailableJobs;

import java.util.List;

import retrofit2.Response;

/**
 * Created by park on 2016-03-24.
 */
public class OnReceiveJobListEvent {

    Response<List<AvailableJobs>> jobList;

    public OnReceiveJobListEvent(Response<List<AvailableJobs>> jobList){
        this.jobList = jobList;
    }

    public Response<List<AvailableJobs>> getJobList() {
        return jobList;
    }

    public void setJobList(Response<List<AvailableJobs>> jobList) {
        this.jobList = jobList;
    }


}
