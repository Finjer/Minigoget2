package com.example.dennis.minigoget.Presenter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dennis.minigoget.API.GoGetService;
import com.example.dennis.minigoget.Event.NetworkFailureEvent;
import com.example.dennis.minigoget.Event.OnSingleJobRetrieveEvent;
import com.example.dennis.minigoget.JobDetailView;
import com.example.dennis.minigoget.R;
import com.example.dennis.minigoget.Service.MiniGoGetService;
import com.example.dennis.minigoget.Service.ServiceGenerator;
import com.example.dennis.minigoget.model.availableJobs;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import retrofit2.Call;

/**
 * Created by park on 2016-03-25.
 */
public class JobDetailPresenter implements IJobDetailPresenter {

    String authen_token;
    int jobId;
    float scale;
    JobDetailView view;

    public JobDetailPresenter(JobDetailView view, String authen_token,int jobId, float scale){
        this.view = view;
        this.authen_token = authen_token;
        this.jobId = jobId;
        this.scale = scale;
    }

    public String getAuthen_token() {
        return authen_token;
    }

    public void setAuthen_token(String authen_token) {
        this.authen_token = authen_token;
    }
    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
    public void requestSingleJob(){

        MiniGoGetService.requestSingleJob(authen_token,jobId);
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
