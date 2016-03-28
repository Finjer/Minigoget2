package com.example.dennis.minigoget.Presenter;

import com.example.dennis.minigoget.Event.LoginFailureEvent;
import com.example.dennis.minigoget.Event.LoginSuccessEvent;
import com.example.dennis.minigoget.LoginView;
import com.example.dennis.minigoget.Service.MiniGoGetService;
import com.example.dennis.minigoget.model.user;
import com.example.dennis.minigoget.model.userContainer;

import org.greenrobot.eventbus.Subscribe;

import org.greenrobot.eventbus.EventBus;

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

    public userContainer createLoginContainer(String userEmail, String userPassword){

        user user = new user();
        user.setEmail(userEmail);
        user.setPassword(userPassword);

        userContainer container = new userContainer();
        container.setUser(user);

        return container;
    }
    public void loginAttempt(String userEmail, String userPassword){

        MiniGoGetService.loginAttempt(createLoginContainer(userEmail, userPassword));

    }
    @Subscribe
    public void onEvent(LoginSuccessEvent ev){

        view.loginSuccess(ev.getAuthen_token());

    }
    @Subscribe
    public void onEvent(LoginFailureEvent ev){

        view.loginFailure(ev.getError(), ev.isNetworkError());

    }

}
