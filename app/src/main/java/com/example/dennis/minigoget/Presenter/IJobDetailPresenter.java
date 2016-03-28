package com.example.dennis.minigoget.Presenter;

import com.example.dennis.minigoget.model.availableJobs;

/**
 * Created by park on 2016-03-25.
 */
public interface IJobDetailPresenter {
    void unRegisterEventBus();
    void registerEventBus();
    void requestSingleJob();
}
