package com.example.dennis.minigoget.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.dennis.minigoget.Job_Detail_Activity;
import com.example.dennis.minigoget.R;
import com.example.dennis.minigoget.model.availableJobs;
import com.example.dennis.minigoget.submainactivity;

import java.util.List;

/**
 * Created by park on 2016-03-10.
 */
public class marker_dialogfragment extends DialogFragment {

    //list of jobs passed to show the job info.
    private List<availableJobs> joblists=null;
    //Activity class that called up current dialog.
    private submainactivity current_class=null;
    //Finding position of job within availablejobs
    private int position;
    //Authentication Token to be used for Intent
    private String authen_token;

    //list of textview and buttons that used in current dialog
    TextView job_type, job_tip, job_starttime, job_endtime;
    Button job_detail;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        //which layout to use
        View view = inflater.inflate(R.layout.joblist_info_dialog, container);

        //set up texts
        job_type = (TextView) view.findViewById(R.id.jobTypeInfo_dialog);
        job_type.setText(joblists.get(position).getJobType());
        job_tip = (TextView) view.findViewById(R.id.tipInfo_dialog);
        job_tip.setText("Tip: "+(joblists.get(position).getAdminTip() + joblists.get(position).getPosterTip()));
        job_starttime = (TextView) view.findViewById(R.id.startTimeInfo_dialog);
        job_starttime.setText("Start Time: \n"+joblists.get(position).getStartAt());
        job_endtime = (TextView) view.findViewById(R.id.endTimeInfo_dialog);
        job_endtime.setText("End Time: \n"+joblists.get(position).getExpireAt());

        //set up button and its listener to be called
        job_detail = (Button) view.findViewById(R.id.viewJobDetail_dialog);
        job_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(current_class, Job_Detail_Activity.class);
                intent.putExtra("goget_id",joblists.get(position).getId());
                intent.putExtra("authen_token",authen_token);
                current_class.startActivity(intent);
                dismiss();
            }
        });

        return view;
    }

    public void setJoblist(List<availableJobs> jobs){
        joblists = jobs;
    }
    public void setCurrentClasst(submainactivity currentclass){
        current_class = currentclass;
    }
    public void setPosition (int number){
        position = number;
    }
    public void setAuthenToken(String authen){
        authen_token = authen;
    }

}
