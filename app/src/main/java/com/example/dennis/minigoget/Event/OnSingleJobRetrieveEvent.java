package com.example.dennis.minigoget.Event;

import com.example.dennis.minigoget.Model.AvailableJobs;

/**
 * Created by park on 2016-03-25.
 */
public class OnSingleJobRetrieveEvent {

    AvailableJobs singleJob;

    public OnSingleJobRetrieveEvent(AvailableJobs singleJob){
        this.singleJob = singleJob;
    }
    public AvailableJobs getSingleJob() {
        return singleJob;
    }

    public void setSingleJob(AvailableJobs singleJob) {
        this.singleJob = singleJob;
    }

}
