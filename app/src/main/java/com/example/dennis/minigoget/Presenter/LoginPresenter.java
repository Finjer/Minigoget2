package com.example.dennis.minigoget.Presenter;

import com.example.dennis.minigoget.Event.LoginFailureEvent;
import com.example.dennis.minigoget.Event.LoginSuccessEvent;
import com.example.dennis.minigoget.Model.AvailableJobs;
import com.example.dennis.minigoget.View.Interface.LoginView;
import com.example.dennis.minigoget.Service.MiniGoGetService;
import com.example.dennis.minigoget.Model.User;
import com.example.dennis.minigoget.Model.UserContainer;

import org.greenrobot.eventbus.Subscribe;

import org.greenrobot.eventbus.EventBus;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by park on 2016-03-21.
 */
public class LoginPresenter implements ILoginPresenter{

    LoginView view;


    public LoginPresenter(LoginView view){

        this.view = view;
    }
    public void unRegisterEventBus(){

        if(EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }
    public void registerEventBus(){

        if(!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    public UserContainer createLoginContainer(String userEmail, String userPassword){

        User user = new User();
        user.setEmail(userEmail);
        user.setPassword(userPassword);

        UserContainer container = new UserContainer();
        container.setUser(user);

        return container;
    }
    public void loginAttempt(String userEmail, String userPassword){
        RealmResults<AvailableJobs> jobList = Realm.getDefaultInstance().where(AvailableJobs.class).findAll();
        Realm.getDefaultInstance().beginTransaction();
        jobList.clear();
        Realm.getDefaultInstance().commitTransaction();
        MiniGoGetService.loginAttempt(createLoginContainer(userEmail, userPassword));

    }
    @Subscribe
    public void onEvent(LoginSuccessEvent ev){

        view.loginSuccess(ev.getAuthenToken());

    }
    @Subscribe
    public void onEvent(LoginFailureEvent ev){

        view.loginFailure(ev.getError(), ev.isNetworkError());

    }

}
