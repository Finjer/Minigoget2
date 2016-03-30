package com.example.dennis.minigoget.View.Widget;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.dennis.minigoget.Service.MiniGoGetService;
import com.example.dennis.minigoget.View.Activity.SingleJobDetailActivity;
import com.example.dennis.minigoget.R;
import com.example.dennis.minigoget.Model.AvailableJobs;
import com.example.dennis.minigoget.View.Activity.MapActivity;

import java.util.List;

/**
 * Created by park on 2016-03-10.
 */
public class MarkerDialogFragment extends DialogFragment {

    //list of jobs passed to show the job info.
    private List<AvailableJobs> joblists=null;
    //Activity class that called up current dialog.
    private MapActivity currentClass=null;
    //Finding position of job within availablejobs
    private int position;
    //Authentication Token to be used for Intent
    private String authenToken;

    //list of textview and buttons that used in current dialog
    TextView jobType, jobTip, jobStartTime, jobEndTime;
    Button jobDetail;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        //which layout to use
        View view = inflater.inflate(R.layout.joblist_info_dialog, container);

        //set up texts
        jobType = (TextView) view.findViewById(R.id.jobTypeInfo_dialog);
        jobType.setText(joblists.get(position).getJobType());
        jobTip = (TextView) view.findViewById(R.id.tipInfo_dialog);
        jobTip.setText("Tip: "+(joblists.get(position).getAdminTip() + joblists.get(position).getPosterTip()));
        jobStartTime = (TextView) view.findViewById(R.id.startTimeInfo_dialog);
        jobStartTime.setText("Start Time: \n"+joblists.get(position).getStartAt());
        jobEndTime = (TextView) view.findViewById(R.id.endTimeInfo_dialog);
        jobEndTime.setText("End Time: \n"+joblists.get(position).getExpireAt());

        //set up button and its listener to be called
        jobDetail = (Button) view.findViewById(R.id.viewJobDetail_dialog);
        jobDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(currentClass, SingleJobDetailActivity.class);
                intent.putExtra("gogetId",joblists.get(position).getId());
                intent.putExtra(MiniGoGetService.AUTHENTICATION_TOKEN, authenToken);
                currentClass.startActivity(intent);
                dismiss();
            }
        });

        return view;
    }

    public void setJoblist(List<AvailableJobs> jobs){
        joblists = jobs;
    }
    public void setCurrentClass(MapActivity currentClass){
        this.currentClass = currentClass;
    }
    public void setPosition (int number){
        position = number;
    }
    public void setAuthenToken(String authenToken){
        this.authenToken = authenToken;
    }

}
