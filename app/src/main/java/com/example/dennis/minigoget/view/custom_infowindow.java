package com.example.dennis.minigoget.view;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dennis.minigoget.Job_Detail_Activity;
import com.example.dennis.minigoget.MainActivity;
import com.example.dennis.minigoget.R;
import com.example.dennis.minigoget.model.availableJobs;
import com.example.dennis.minigoget.submainactivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

import io.realm.Realm;

/**
 * Created by park on 2016-03-04.
 */
public class custom_infowindow implements InfoWindowAdapter {

    private final LayoutInflater mInflater;
    private final submainactivity current_class;

    public custom_infowindow(LayoutInflater i){
        mInflater = i;
        current_class = null;
    }
    public custom_infowindow(LayoutInflater i, submainactivity upperclass) {
        mInflater = i;
        current_class = upperclass;

    }


    @Override
    public View getInfoWindow(Marker marker) {

        return infoWindowSetup(marker);
    }
    @Override
    public View getInfoContents(Marker marker) {
         return null;
    }



    private View infoWindowSetup(Marker currentMarker){

        //initialize target infowindow layout
        View v = mInflater.inflate(R.layout.joblist_info,null);

        //Withdraw InfoWindowRealm data
        List<availableJobs> joblists = Realm.getDefaultInstance().where(availableJobs.class).findAll();

        TextView job_type = (TextView) v.findViewById(R.id.jobTypeInfo);
        job_type.setText(joblists.get(Integer.parseInt(currentMarker.getSnippet())).getJobType());
        TextView job_tip = (TextView) v.findViewById(R.id.tipInfo);
        job_tip.setText("Tip: "+(joblists.get(Integer.parseInt(currentMarker.getSnippet())).getAdminTip() + joblists.get(Integer.parseInt(currentMarker.getSnippet())).getPosterTip()));
        TextView  job_starttime = (TextView) v.findViewById(R.id.startTimeInfo);
        job_starttime.setText("Start Time: \n"+joblists.get(Integer.parseInt(currentMarker.getSnippet())).getStartAt());
        TextView job_endtime = (TextView) v.findViewById(R.id.endTimeInfo);
        job_endtime.setText("End Time: \n" + joblists.get(Integer.parseInt(currentMarker.getSnippet())).getExpireAt());

        Button job_detail = (Button) v.findViewById(R.id.viewJobDetail);
        job_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(current_class, Job_Detail_Activity.class);
                current_class.startActivity(intent);
            }
        });
        currentMarker.setInfoWindowAnchor((float)1.9,(float)1.6);

        return v;
    }
}
