package com.example.dennis.minigoget.Presenter;

/**
 * Created by park on 2016-03-22.
 */
public interface ILoginPresenter {
    void loginAttempt(String Email, String Password);
    void unRegisterEventBus();
    void registerEventBus();
}
