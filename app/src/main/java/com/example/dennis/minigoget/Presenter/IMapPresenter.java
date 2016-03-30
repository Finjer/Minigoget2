package com.example.dennis.minigoget.Presenter;

import com.example.dennis.minigoget.View.Activity.MapActivity;
import com.google.android.gms.maps.GoogleMap;

/**
 * Created by park on 2016-03-23.
 */
public interface IMapPresenter {

    void requestJobList();
    void setCustomInfoWindowAdapter(GoogleMap gMap,MapActivity invokedClass);
    void setMarker(GoogleMap gMap);
    void setMarkerListener(GoogleMap gMap, MapActivity invokedClass);
    void clearRealmData();
    void unRegisterEventBus();
    void registerEventBus();
    String getAuthenToken();

}
