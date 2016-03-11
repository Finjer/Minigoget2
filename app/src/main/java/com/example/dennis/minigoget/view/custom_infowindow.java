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

/**
 * Created by park on 2016-03-04.
 */
public class custom_infowindow implements InfoWindowAdapter {
    private final LayoutInflater mInflater;
    private final List<availableJobs> joblists;
    private final submainactivity current_class;
    TextView job_type, job_tip, job_starttime, job_endtime;
    Button job_detail;
    public custom_infowindow(LayoutInflater i){
        mInflater = i;
        joblists = null;
        current_class = null;
    }
    public custom_infowindow(LayoutInflater i, List<availableJobs> jobs, submainactivity upperclass) {
        mInflater = i;
        joblists = jobs;
        current_class = upperclass;

    }
    @Override
    public View getInfoWindow(Marker marker) {
        View v = mInflater.inflate(R.layout.joblist_info,null);
        Log.d("aaa", marker.getSnippet());
        Log.d("bbb",joblists.get(0).getId()+"");
        Log.d("ccc",joblists.get(Integer.parseInt(marker.getSnippet())).getJobType());
        job_type = (TextView) v.findViewById(R.id.jobTypeInfo);
        job_type.setText(joblists.get(Integer.parseInt(marker.getSnippet())).getJobType());
        //job_type.setText(joblists.get(Integer.parseInt(marker.getSnippet())).getJobType());
        job_tip = (TextView) v.findViewById(R.id.tipInfo);
        job_tip.setText("Tip: "+(joblists.get(Integer.parseInt(marker.getSnippet())).getAdminTip() + joblists.get(Integer.parseInt(marker.getSnippet())).getPosterTip()));
        job_starttime = (TextView) v.findViewById(R.id.startTimeInfo);
        job_starttime.setText("Start Time: \n"+joblists.get(Integer.parseInt(marker.getSnippet())).getStartAt());
        job_endtime = (TextView) v.findViewById(R.id.endTimeInfo);
        job_endtime.setText("End Time: \n"+joblists.get(Integer.parseInt(marker.getSnippet())).getExpireAt());

        job_detail = (Button) v.findViewById(R.id.viewJobDetail);
        job_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(current_class,Job_Detail_Activity.class);
                current_class.startActivity(intent);
            }
        });
        marker.setInfoWindowAnchor((float)1.9,(float)1.6);

        return v;
    }


    @Override
    public View getInfoContents(Marker marker) {
/*
        View v = mInflater.inflate(R.layout.joblist_info,null);

        TextView text = (TextView) v.findViewById(R.id.textView);
        //text.setText("testing:1");



        return v;*/ return null;
    }
}
