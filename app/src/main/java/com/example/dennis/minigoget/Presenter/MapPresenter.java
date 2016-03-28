package com.example.dennis.minigoget.Presenter;

import android.util.Log;

import com.example.dennis.minigoget.Event.NetworkFailureEvent;
import com.example.dennis.minigoget.Event.OnReceiveJobListEvent;
import com.example.dennis.minigoget.MapView;
import com.example.dennis.minigoget.R;
import com.example.dennis.minigoget.Service.MiniGoGetService;
import com.example.dennis.minigoget.model.availableJobs;
import com.example.dennis.minigoget.submainactivity;
import com.example.dennis.minigoget.view.custom_infowindow;
import com.example.dennis.minigoget.view.marker_dialogfragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by park on 2016-03-23.
 */
public class MapPresenter implements IMapPresenter {

    MapView view;
    submainactivity currentClass;
    String authen_token;

    public MapPresenter(MapView view, String authen_token){

        this.view = view;
        this.authen_token = authen_token;

    }

    public String getAuthen_token() {
        return authen_token;
    }

    public void setAuthen_token(String authen_token) {
        this.authen_token = authen_token;
    }

    @Override
    public void requestJobList() {
        MiniGoGetService.requestJobList(authen_token);
    }

    @Override
    public void setCustomInfoWindowAdapter(GoogleMap gMap,submainactivity invokedClass) {
        gMap.setInfoWindowAdapter(new custom_infowindow(invokedClass.getLayoutInflater(), invokedClass));
    }

    @Override
    public void setMarker(GoogleMap gMap) {

        List<availableJobs> joblists = Realm.getDefaultInstance().where(availableJobs.class).findAll();

        for(int i=0;i<joblists.size();i++){
            for(int j=0;j<joblists.get(i).getTasks().size();j++){
                if( (joblists.get(i).getTasks().get(j).getLocationLat() != null) && (joblists.get(i).getTasks().get(j).getLocationLong()!=null) ){
                    LatLng latlng = new LatLng(joblists.get(i).getTasks().get(j).getLocationLat(),joblists.get(i).getTasks().get(j).getLocationLong());
                    gMap.addMarker(new MarkerOptions().position(latlng).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).snippet(Integer.toString(i)));
                    break;
                }
            }

        }

    }

    @Override
    public void setMarkerListener(GoogleMap gMap, submainactivity invokedClass) {

        currentClass = invokedClass;

        gMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                marker_dialogfragment dialog = new marker_dialogfragment();
                dialog.setJoblist(Realm.getDefaultInstance().where(availableJobs.class).findAll());
                dialog.setCurrentClasst(currentClass);
                dialog.setAuthenToken(authen_token);
                dialog.setPosition(Integer.parseInt(marker.getSnippet()));
                dialog.show(currentClass.getFragmentManager(), "test");
                marker.remove();
            }
        });

    }
    @Override
    public void unRegisterEventBus() {

        if(EventBus.getDefault().isRegistered(this))
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void registerEventBus() {

        if(!EventBus.getDefault().isRegistered(this))
        EventBus.getDefault().register(this);
    }
    @Override
    public void clearRealmData() {
        RealmResults<availableJobs> jobList = Realm.getDefaultInstance().where(availableJobs.class).findAll();
        Realm.getDefaultInstance().beginTransaction();
        jobList.clear();
        Realm.getDefaultInstance().commitTransaction();
    }
    @Subscribe
    public void onEvent(OnReceiveJobListEvent ev){

        Realm.getDefaultInstance().beginTransaction();

        Realm.getDefaultInstance().copyToRealm(ev.getJobList().body());

        Realm.getDefaultInstance().commitTransaction();

        view.requestMapAsync();

    }
    @Subscribe
    public void onEvent(NetworkFailureEvent ev){

        view.onNetworkFailure(ev.getError().toString());

    }

}
