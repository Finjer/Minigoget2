package com.example.dennis.minigoget;

/**
 * Created by park on 2016-03-23.
 */
public interface MapView {

    void onNetworkFailure(String errorBody);

    void requestMapAsync();

}
