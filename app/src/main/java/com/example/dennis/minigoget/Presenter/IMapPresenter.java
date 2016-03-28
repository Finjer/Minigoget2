package com.example.dennis.minigoget.Presenter;

import com.example.dennis.minigoget.submainactivity;
import com.google.android.gms.maps.GoogleMap;

/**
 * Created by park on 2016-03-23.
 */
public interface IMapPresenter {

    void requestJobList();
    void setCustomInfoWindowAdapter(GoogleMap gMap,submainactivity invokedClass);
    void setMarker(GoogleMap gMap);
    void setMarkerListener(GoogleMap gMap, submainactivity invokedClass);
    void clearRealmData();
    void unRegisterEventBus();
    void registerEventBus();
    String getAuthen_token();

}
