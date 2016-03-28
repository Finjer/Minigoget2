package com.example.dennis.minigoget.Event;

import com.example.dennis.minigoget.model.availableJobs;

/**
 * Created by park on 2016-03-25.
 */
public class OnSingleJobRetrieveEvent {

    availableJobs singleJob;

    public OnSingleJobRetrieveEvent(availableJobs singleJob){
        this.singleJob = singleJob;
    }
    public availableJobs getSingleJob() {
        return singleJob;
    }

    public void setSingleJob(availableJobs singleJob) {
        this.singleJob = singleJob;
    }

}
