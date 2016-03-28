package com.example.dennis.minigoget.Event;

/**
 * Created by park on 2016-03-21.
 */
public class LoginSuccessEvent {

    String authen_token;

    public LoginSuccessEvent(String authen_token){
        this.authen_token = authen_token;
    }

    public String getAuthen_token() {
        return authen_token;
    }

    public void setAuthen_token(String authen_token) {
        this.authen_token = authen_token;
    }
}
