package com.example.dennis.minigoget.Presenter;

import com.example.dennis.minigoget.Event.NetworkFailureEvent;
import com.example.dennis.minigoget.Event.OnReceiveJobListEvent;
import com.example.dennis.minigoget.View.Interface.MapView;
import com.example.dennis.minigoget.R;
import com.example.dennis.minigoget.Service.MiniGoGetService;
import com.example.dennis.minigoget.Model.AvailableJobs;
import com.example.dennis.minigoget.View.Activity.MapActivity;
import com.example.dennis.minigoget.View.Widget.CustomInfoWindow;
import com.example.dennis.minigoget.View.Widget.MarkerDialogFragment;
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
    MapActivity currentClass;
    String authenToken;

    public MapPresenter(MapView view, String authenToken){

        this.view = view;
        this.authenToken = authenToken;

    }

    public String getAuthenToken() {
        return authenToken;
    }

    public void setAuthenToken(String authenToken) {
        this.authenToken = authenToken;
    }

    @Override
    public void requestJobList() {
        MiniGoGetService.requestJobList(authenToken);
    }

    @Override
    public void setCustomInfoWindowAdapter(GoogleMap gMap,MapActivity invokedClass) {
        gMap.setInfoWindowAdapter(new CustomInfoWindow(invokedClass.getLayoutInflater(), invokedClass));
    }

    @Override
    public void setMarker(GoogleMap gMap) {

        List<AvailableJobs> joblists = Realm.getDefaultInstance().where(AvailableJobs.class).findAll();

        for(int i=0;i<joblists.size();i++){
            for(int j=0;j<joblists.get(i).getTasks().size();j++){
                if( (joblists.get(i).getTasks().get(j).getLocationLat() != null) && (joblists.get(i).getTasks().get(j).getLocationLong()!=null) ){
                    LatLng latLng = new LatLng(joblists.get(i).getTasks().get(j).getLocationLat(),joblists.get(i).getTasks().get(j).getLocationLong());
                    gMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).snippet(Integer.toString(i)));
                    break;
                }
            }

        }

    }

    @Override
    public void setMarkerListener(GoogleMap gMap, MapActivity invokedClass) {

        currentClass = invokedClass;

        gMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                MarkerDialogFragment dialog = new MarkerDialogFragment();
                dialog.setJoblist(Realm.getDefaultInstance().where(AvailableJobs.class).findAll());
                dialog.setCurrentClass(currentClass);
                dialog.setAuthenToken(authenToken);
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
        RealmResults<AvailableJobs> jobList = Realm.getDefaultInstance().where(AvailableJobs.class).findAll();
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
