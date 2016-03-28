package com.example.dennis.minigoget.Event;

/**
 * Created by park on 2016-03-21.
 */
public class LoginFailureEvent {

    String error;
    boolean networkError;

    public LoginFailureEvent(String error, boolean networkError){
        this.error = error;
        this.networkError = networkError;
    }
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    public boolean isNetworkError() {
        return networkError;
    }

    public void setNetworkError(boolean networkError) {
        this.networkError = networkError;
    }
}
