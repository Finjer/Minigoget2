package com.example.dennis.minigoget.Event;

import com.example.dennis.minigoget.model.availableJobs;

import java.util.List;

import retrofit2.Response;

/**
 * Created by park on 2016-03-24.
 */
public class OnReceiveJobListEvent {

    Response<List<availableJobs>> jobList;

    public OnReceiveJobListEvent(Response<List<availableJobs>> jobList){
        this.jobList = jobList;
    }

    public Response<List<availableJobs>> getJobList() {
        return jobList;
    }

    public void setJobList(Response<List<availableJobs>> jobList) {
        this.jobList = jobList;
    }


}
