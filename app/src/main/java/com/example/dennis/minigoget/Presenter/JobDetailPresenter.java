package com.example.dennis.minigoget.Presenter;

import com.example.dennis.minigoget.Event.NetworkFailureEvent;
import com.example.dennis.minigoget.Event.OnSingleJobRetrieveEvent;
import com.example.dennis.minigoget.View.Interface.JobDetailView;
import com.example.dennis.minigoget.Service.MiniGoGetService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by park on 2016-03-25.
 */
public class JobDetailPresenter implements IJobDetailPresenter {

    String authenToken;
    int jobId;
    float scale;
    JobDetailView view;

    public JobDetailPresenter(JobDetailView view, String authenToken,int jobId, float scale){
        this.view = view;
        this.authenToken = authenToken;
        this.jobId = jobId;
        this.scale = scale;
    }

    public String getAuthenToken() {
        return authenToken;
    }

    public void setAuthenToken(String authenToken) {
        this.authenToken = authenToken;
    }
    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
    public void requestSingleJob(){

        MiniGoGetService.requestSingleJob(authenToken,jobId);
    }

    @Override
    public void unRegisterEventBus() {

        if(EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }

    @Override
    public void registerEventBus() {

        if(!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }
    @Subscribe
    public void onEvent(OnSingleJobRetrieveEvent ev){
        view.invokeSingleJob(ev.getSingleJob(), scale);
    }
    @Subscribe
    public void onEvent(NetworkFailureEvent ev){

        view.onNetworkFailure(ev.getError().toString());

    }
}
