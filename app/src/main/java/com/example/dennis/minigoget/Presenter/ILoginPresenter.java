package com.example.dennis.minigoget.Presenter;

/**
 * Created by park on 2016-03-22.
 */
public interface ILoginPresenter {
    void loginAttempt(String email, String password);
    void unRegisterEventBus();
    void registerEventBus();
}
