package com.example.dennis.minigoget;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.dennis.minigoget.Presenter.IMapPresenter;
import com.example.dennis.minigoget.Presenter.MapPresenter;
import com.example.dennis.minigoget.model.availableJobs;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;


public class submainactivity extends FragmentActivity implements OnMapReadyCallback, MapView {

    private OnMapReadyCallback callback;
    protected submainactivity thisclass;
    private List<availableJobs> joblists;
    boolean joblist_ready=true;
    private IMapPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goget_map);

        callback = this;
        thisclass = submainactivity.this;

        //getting intent data authentication token;
        Intent intent = this.getIntent();
        presenter = new MapPresenter(this,intent.getExtras().getString("authen_token"));

    }

    public void onViewDetailPressed(){
        Intent intent = new Intent(this, SingleJobDetailActivity.class);
        startActivity(intent);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        presenter.setCustomInfoWindowAdapter(googleMap,thisclass);
        presenter.setMarker(googleMap);
        presenter.setMarkerListener(googleMap,thisclass);
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
    @Override
    protected void onResume() {
        presenter.clearRealmData();
        presenter.registerEventBus();
        presenter.requestJobList();
        super.onResume();

    }
    @Override
    protected void onStop() {
        presenter.unRegisterEventBus();
        super.onStop();
    }
    @Override
    public void onBackPressed() {
        presenter.clearRealmData();
        presenter.unRegisterEventBus();
        super.onBackPressed();
        finish();
    }

}
