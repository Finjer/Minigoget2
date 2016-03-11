package com.example.dennis.minigoget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dennis.minigoget.API.GoGetService;
import com.example.dennis.minigoget.Service.ServiceGenerator;
import com.example.dennis.minigoget.model.availableJobs;
import com.google.android.gms.maps.SupportMapFragment;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by park on 2016-03-10.
 */
public class Job_Detail_Activity extends Activity {

    TextView detail,tip;
    private int id;
    private String authen_token;
    private int e_money;
    private boolean auto_approve, meet_at_car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.goget_job_detail);

        Intent intent = this.getIntent();
        id = intent.getIntExtra("goget_id",id);
        authen_token = intent.getStringExtra("authen_token");

        //For error message for loading info
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


        if(authen_token!=null){

            GoGetService generateJobs = ServiceGenerator.createService(GoGetService.class, authen_token);
            Call<availableJobs> call = generateJobs.getSingleJob(id);

            call.enqueue(new Callback<availableJobs>() {
                @Override
                public void onResponse(Call<availableJobs> call, Response<availableJobs> response) {

                    if (response.isSuccess()) {

                        LinearLayout layout = (LinearLayout) findViewById(R.id.singlejob_upper_layout);

                        //receiving available jobs to this activity
                        tip = (TextView) findViewById(R.id.singlejob_tip);
                        tip.setText(""+((response.body().getAdminTip())+(response.body().getPosterTip())));
                        tip.setTextColor(Color.parseColor("#6D6D6D"));

                        //temporary ids for objects
                        int i = 0;
                        //adding alerting details
                        if(!response.body().getAutoApprove()){
                            TextView tv = new TextView(getCurrentContext());
                            tv.setText("   This job requires the Poster's Approval");
                            tv.setTextColor(Color.parseColor("#FFC90E"));

                            tv.setId(i + 5);
                            i++;

                            layout.addView(tv);
                        }
                        if(response.body().getAdminTip()>0){
                            TextView tv = new TextView(getCurrentContext());
                            tv.setText("   Some of this tip is paid by GoGet Admin electronically");
                            tv.setTextColor(Color.parseColor("#0080FF"));


                            tv.setId(i + 5);
                            i++;

                            layout.addView(tv);
                        }
                        if(response.body().getItemPriceRange()==null){
                            TextView tv = new TextView(getCurrentContext());
                            tv.setText("   CASH REQUIRED: NONE");
                            tv.setTextColor(Color.parseColor("#0080FF"));


                            tv.setId(i + 5);
                            i++;

                            layout.addView(tv);
                        }

                    }
                    else {

                        //to know where error occurs
                        try {
                            Log.d("generateResponse: ", "failed: " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

                //occurs when network error( most likely no network) happens
                @Override
                public void onFailure(Call<availableJobs> call, Throwable t) {
                    alertDialogBuilder.setTitle("Network Error");
                    alertDialogBuilder.setMessage("Please check your Network to further proceed.");
                    alertDialogBuilder.show();
                }
            });
        }
    }

    protected Context getCurrentContext(){
        return this;
    }
}
