package com.example.dennis.minigoget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.dennis.minigoget.API.GoGetService;
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

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class submainactivity extends FragmentActivity implements OnMapReadyCallback {

    private OnMapReadyCallback callback;
    protected submainactivity thisclass;
    protected Context thiscontext;
    private GoogleMap mMap;
    private List<availableJobs> joblists;
    boolean joblist_ready=true;
    private String authen_token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goget_map);
        callback = this;
        thisclass = submainactivity.this;
        thiscontext = this;
        //getting intent data authentication token;
        Intent intent = this.getIntent();
        authen_token = intent.getExtras().getString("authen_token");

        //For error message for pressing login
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //Service to retrieve current user's available jobs
        if(authen_token!=null){

            GoGetService generateJobs = ServiceGenerator.createService(GoGetService.class, authen_token);
            Call<List<availableJobs>> call = generateJobs.getJobs();

            call.enqueue(new Callback<List<availableJobs>>() {
                @Override
                public void onResponse(Call<List<availableJobs>> call, Response<List<availableJobs>> response) {

                    if (response.isSuccess()) {

                        //receiving available jobs to this activity
                        joblists = response.body();
                        joblist_ready=false;
                        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                                .findFragmentById(R.id.map);
                        mapFragment.getMapAsync(callback);

                    }
                    else {

                        //to know where error occurs
                        try {
                            Log.d("generateResponse: ", "failed: " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    joblist_ready=false;

                }

                //occurs when network error( most likely no network) happens
                @Override
                public void onFailure(Call<List<availableJobs>> call, Throwable t) {
                    alertDialogBuilder.setTitle("Network Error");
                    alertDialogBuilder.setMessage("Please check your Network to further proceed.");
                    alertDialogBuilder.show();
                }
            });
        }
        /*
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //cannot use this
        /*
        while(true){
            if(joblist_ready==false){
                break;
            }
            Log.d("test", "test"+joblist_ready);
        }*/

    }

        //String s=intent.getStringExtra(“text”);

        /*
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();
        Marker seoul = map.addMarker(new MarkerOptions().position(SEOUL)
                .title("Seoul"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom( SEOUL, 15));

        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        */
    public void onViewDetailPressed(){
        Intent intent = new Intent(this, Job_Detail_Activity.class);
        startActivity(intent);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setInfoWindowAdapter( new custom_infowindow(getLayoutInflater(),joblists,thisclass));
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng goget = new LatLng(3.1598359,101.6587536);
        for(int i=0;i<joblists.size();i++){

            for(int j=0;j<joblists.get(i).getTasks().size();j++){
                if( (joblists.get(i).getTasks().get(j).getLocationLat() != null) && (joblists.get(i).getTasks().get(j).getLocationLong()!=null) ){
                    LatLng latlng = new LatLng(joblists.get(i).getTasks().get(j).getLocationLat(),joblists.get(i).getTasks().get(j).getLocationLong());
                    mMap.addMarker(new MarkerOptions().position(latlng).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).snippet(Integer.toString(i)));
                    break;
                }
            }

        }
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                marker_dialogfragment dialog = new marker_dialogfragment();
                dialog.setJoblist(joblists);
                dialog.setCurrentClasst(thisclass);
                dialog.setAuthenToken(authen_token);
                dialog.setPosition(Integer.parseInt(marker.getSnippet()));
                dialog.show(getFragmentManager(), "test");
            }
        });

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(goget, 10));
    }
}
