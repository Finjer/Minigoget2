package com.example.dennis.minigoget;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.dennis.minigoget.API.GoGetService;
import com.example.dennis.minigoget.Presenter.IMapPresenter;
import com.example.dennis.minigoget.Presenter.MapPresenter;
import com.example.dennis.minigoget.Service.ServiceGenerator;
import com.example.dennis.minigoget.model.availableJobs;
import com.example.dennis.minigoget.view.custom_infowindow;
import com.example.dennis.minigoget.view.marker_dialogfragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class submainactivity extends FragmentActivity implements OnMapReadyCallback, MapView {

    private OnMapReadyCallback callback;
    protected submainactivity thisclass;
    private List<availableJobs> joblists;
    boolean joblist_ready=true;
    private String authen_token;
    private IMapPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goget_map);

        callback = this;
        thisclass = submainactivity.this;
        presenter = new MapPresenter(this);
        presenter.registerEventBus();

        //getting intent data authentication token;
        Intent intent = this.getIntent();
        authen_token = intent.getExtras().getString("authen_token");
        Log.d("Token:",authen_token );
        presenter.requestJobList(authen_token);


        //For error message for pressing login
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

    }

    public void onViewDetailPressed(){
        Intent intent = new Intent(this, Job_Detail_Activity.class);
        startActivity(intent);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        presenter.setCustomInfoWindowAdapter(googleMap,thisclass);
        presenter.setMarker(googleMap);
        presenter.setMarkerListener(googleMap,thisclass,authen_token);
        LatLng goget = new LatLng(3.1598359,101.6587536);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(goget, 10));
    }


    @Override
    public void onNetworkFailure(String errorBody) {
        //For error message for pressing login
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //case of network interaction error
        alertDialogBuilder.setTitle("Network Error");
        alertDialogBuilder.setMessage("Please check your Network to further proceed. \n" + errorBody);
        alertDialogBuilder.show();
    }

    @Override
    public void requestMapAsync() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(callback);
    }
    @Override
    protected void onDestroy() {
        presenter.clearRealmData();
        presenter.unRegisterEventBus();
        super.onDestroy();


    }
}
