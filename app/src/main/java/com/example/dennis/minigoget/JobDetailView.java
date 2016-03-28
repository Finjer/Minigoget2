package com.example.dennis.minigoget;

import com.example.dennis.minigoget.model.availableJobs;

/**
 * Created by park on 2016-03-25.
 */
public interface JobDetailView {
    void requestSingleJob();
    void invokeSingleJob(availableJobs job, float scale);
    void onNetworkFailure(String errorBody);
}
