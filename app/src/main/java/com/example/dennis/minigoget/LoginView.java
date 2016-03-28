package com.example.dennis.minigoget;

/**
 * Created by park on 2016-03-21.
 */
public interface LoginView {

     void loginSuccess(String authen_token);

     void loginFailure(String errorbody, boolean networkerror);

}
