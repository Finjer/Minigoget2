package com.example.dennis.minigoget.Event;

/**
 * Created by park on 2016-03-21.
 */
public class LoginSuccessEvent {

    String authenToken;

    public LoginSuccessEvent(String authenToken){
        this.authenToken = authenToken;
    }

    public String getAuthenToken() {
        return authenToken;
    }

    public void setAuthenToken(String authenToken) {
        this.authenToken = authenToken;
    }
}
