package com.example.dennis.minigoget.View.Widget;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dennis.minigoget.View.Activity.SingleJobDetailActivity;
import com.example.dennis.minigoget.R;
import com.example.dennis.minigoget.Model.AvailableJobs;
import com.example.dennis.minigoget.View.Activity.MapActivity;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

import io.realm.Realm;

/**
 * Created by park on 2016-03-04.
 */
public class CustomInfoWindow implements InfoWindowAdapter {

    private final LayoutInflater mInflater;
    private final MapActivity currentClass;

    public CustomInfoWindow(LayoutInflater i){
        mInflater = i;
        currentClass = null;
    }
    public CustomInfoWindow(LayoutInflater i, MapActivity upperClass) {
        mInflater = i;
        currentClass = upperClass;

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
        View v = mInflater.inflate(R.layout.joblist_info, null);

        //Withdraw InfoWindowRealm data
        List<AvailableJobs> joblists = Realm.getDefaultInstance().where(AvailableJobs.class).findAll();

        TextView jobType = (TextView) v.findViewById(R.id.jobTypeInfo);
        jobType.setText(joblists.get(Integer.parseInt(currentMarker.getSnippet())).getJobType());
        TextView jobTip = (TextView) v.findViewById(R.id.tipInfo);
        jobTip.setText("Tip: "+(joblists.get(Integer.parseInt(currentMarker.getSnippet())).getAdminTip() + joblists.get(Integer.parseInt(currentMarker.getSnippet())).getPosterTip()));
        TextView  jobStartTime = (TextView) v.findViewById(R.id.startTimeInfo);
        jobStartTime.setText("Start Time: \n" + joblists.get(Integer.parseInt(currentMarker.getSnippet())).getStartAt());
        TextView jobEndTime = (TextView) v.findViewById(R.id.endTimeInfo);
        jobEndTime.setText("End Time: \n" + joblists.get(Integer.parseInt(currentMarker.getSnippet())).getExpireAt());

        Button jobDetail = (Button) v.findViewById(R.id.viewJobDetail);
        jobDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(currentClass, SingleJobDetailActivity.class);
                currentClass.startActivity(intent);
            }
        });
        currentMarker.setInfoWindowAnchor((float)1.9,(float)1.6);
        return v;
    }
}
