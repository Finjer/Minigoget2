package com.example.dennis.minigoget.Event;

/**
 * Created by park on 2016-03-24.
 */
public class NetworkFailureEvent {
    String error;

    public NetworkFailureEvent(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
