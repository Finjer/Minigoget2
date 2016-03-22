package com.example.dennis.minigoget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import com.example.dennis.minigoget.API.GoGetService;
import com.example.dennis.minigoget.Service.ServiceGenerator;
import com.example.dennis.minigoget.model.availableJobs;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by park on 2016-03-10.
 */
public class Job_Detail_Activity extends Activity {

    private TextView detail,tip,description,gogetter_name;
    private ImageView gogetter_image;
    private Button claim;
    private int id;
    private String authen_token;
    private int e_money;
    private boolean auto_approve, meet_at_car;
    private Job_Detail_Activity currentClass;
    private float scale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.goget_job_detail);
        currentClass = this;

        Intent intent = this.getIntent();
        id = intent.getIntExtra("goget_id",id);
        authen_token = intent.getStringExtra("authen_token");

        //Get current Activity's dp scale
        scale = getCurrentContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (52 * scale + 0.5f);
        Log.d("aaa",""+pixels);
        //For error message for loading info
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


        if(authen_token!=null){

            GoGetService generateJobs = ServiceGenerator.createService(GoGetService.class, authen_token);
            Call<availableJobs> call = generateJobs.getSingleJob(id);

            call.enqueue(new Callback<availableJobs>() {
                @Override
                public void onResponse(Call<availableJobs> call, Response<availableJobs> response) {

                    if (response.isSuccess()) {


                        //First Part of configuration of Job Detail , Upper layer, which to configure Tip and notable element of the job
                        LinearLayout layout = (LinearLayout) findViewById(R.id.singlejob_upper_layout);

                        //receiving available jobs to this activity
                        tip = (TextView) findViewById(R.id.singlejob_tip);
                        tip.setText(""+((response.body().getAdminTip())+(response.body().getPosterTip())));
                        tip.setTextColor(Color.parseColor("#6D6D6D"));

                        //temporary ids for objects
                        int temp_Id = 0;
                        //adding alerting details
                        if(!response.body().getAutoApprove()){
                            TextView tv = new TextView(getCurrentContext());
                            tv.setText("   This job requires the Poster's Approval");
                            tv.setTextColor(Color.parseColor("#FFC90E"));

                            tv.setId(temp_Id + 5);
                            temp_Id++;

                            layout.addView(tv);
                        }
                        if(response.body().getAdminTip()>0){
                            TextView tv = new TextView(getCurrentContext());
                            tv.setText("   Some of this tip is paid by GoGet Admin electronically");
                            tv.setTextColor(Color.parseColor("#0080FF"));


                            tv.setId(temp_Id + 5);
                            temp_Id++;

                            layout.addView(tv);
                        }
                        if(response.body().getItemPriceRange()==null){
                            TextView tv = new TextView(getCurrentContext());
                            tv.setText("   CASH REQUIRED: NONE");
                            tv.setTextColor(Color.parseColor("#0080FF"));


                            tv.setId(temp_Id + 5);
                            temp_Id++;

                            layout.addView(tv);
                        }


                        //Second Part of configuration of Job Detail , Middle layer, which to generate Tasks dynamically
                        LinearLayout middle_layout = (LinearLayout) findViewById(R.id.singlejob_middle_layout);

                        //int pixels = (int) (dps * scale + 0.5f);
                        for(int i=0;i<response.body().getTasks().size();i++){
                            //Container layout to include both image and tasks
                            LinearLayout middle_layout_container = new LinearLayout(getCurrentContext());
                            middle_layout_container.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

                            //Layout to contain Task flag with its background as image
                            LinearLayout task_Image_layout = new LinearLayout(getCurrentContext());
                            task_Image_layout.setLayoutParams(new LayoutParams((int) (52 * scale + 0.5f), (int) (52 * scale + 0.5f)));
                            task_Image_layout.setBackgroundResource(R.drawable.marker);
                            task_Image_layout.setId(temp_Id + 5);
                            temp_Id++;

                            //putting text A,B,C,D... to show task sequence
                            TextView task_image = new TextView(getCurrentContext());
                            LinearLayout.LayoutParams task_image_lp = new LinearLayout.LayoutParams((int) (52 * scale + 0.5f),(int) (52 * scale + 0.5f));
                            task_image_lp.setMargins((int) (32 * scale + 0.5f), (int) (5.7 * scale + 0.5f), 0, 0);
                            task_image.setLayoutParams(task_image_lp);
                            task_image.setText("" + (char) (65 + i));
                            task_image.setTextColor(Color.BLACK);
                            task_image.setTypeface(null, Typeface.BOLD);
                            task_image.setId(temp_Id + 5);
                            temp_Id++;
                            task_Image_layout.addView(task_image);

                            //add image to container
                            middle_layout_container.addView(task_Image_layout);



                            //Create container for Task description
                            LinearLayout task_layout = new LinearLayout(getCurrentContext());
                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                            lp.setMargins((int) (5 * scale + 0.5f),0,  (int) (20 * scale + 0.5f), 0);
                            task_layout.setLayoutParams(lp);
                            task_layout.setOrientation(LinearLayout.VERTICAL);
                            task_layout.setId(temp_Id + 5);
                            temp_Id++;

                            //Setting title/description of single task
                            TextView task_title = new TextView(getCurrentContext());
                            task_title.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                            task_title.setText(response.body().getTasks().get(i).getName());
                            task_title.setTypeface(null, Typeface.BOLD);
                            task_title.setId(temp_Id + 5);
                            temp_Id++;
                            task_layout.addView(task_title);




                            //Setting Location of single task
                            LinearLayout task_location_layout = new LinearLayout(getCurrentContext());
                            task_location_layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                            task_location_layout.setOrientation(LinearLayout.HORIZONTAL);
                            task_location_layout.setGravity(Gravity.CENTER_VERTICAL);
                            task_location_layout.setId(temp_Id + 5);
                            temp_Id++;

                            ImageView location_image = new ImageView(getCurrentContext());
                            location_image.setLayoutParams(new LayoutParams((int) (20 * scale + 0.5f), (int) (20 * scale + 0.5f)));
                            location_image.setPadding(5, 5, 5, 5);
                            location_image.setImageResource(R.drawable.marker);
                            location_image.setId(temp_Id + 5);
                            temp_Id++;
                            task_location_layout.addView(location_image);

                            TextView location_detail= new TextView(getCurrentContext());
                            location_detail.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            location_detail.setText(response.body().getTasks().get(i).getLocation());
                            location_detail.setId(temp_Id + 5);
                            temp_Id++;
                            task_location_layout.addView(location_detail);

                            task_layout.addView(task_location_layout);

                            //Setting Time of single task
                            LinearLayout task_time_layout = new LinearLayout(getCurrentContext());
                            task_time_layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                            task_time_layout.setOrientation(LinearLayout.HORIZONTAL);
                            task_time_layout.setGravity(Gravity.TOP);
                            task_time_layout.setId(temp_Id + 5);
                            temp_Id++;

                            ImageView time_image = new ImageView(getCurrentContext());
                            time_image.setLayoutParams(new LayoutParams((int) (20 * scale + 0.5f), (int) (20 * scale + 0.5f)));
                            time_image.setPadding(5, 5, 5, 5);
                            time_image.setImageResource(R.drawable.marker);
                            time_image.setId(temp_Id + 5);
                            temp_Id++;
                            task_time_layout.addView(time_image);

                            TextView time_detail= new TextView(getCurrentContext());
                            time_detail.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            time_detail.setText(response.body().getTasks().get(i).getUpdatedAt());
                            time_detail.setId(temp_Id + 5);
                            temp_Id++;
                            task_time_layout.addView(time_detail);

                            task_layout.addView(task_time_layout);



                            middle_layout_container.addView(task_layout);
                            //add Container to middle layout
                            middle_layout.addView(middle_layout_container);
                        }

                        //Third Part of configuration of Job Detail , Bottom layer, which to write in additional notes and poster's detail.
                        description = (TextView) findViewById(R.id.singlejob_description);
                        description.setText(response.body().getNotes());

                        gogetter_name = (TextView) findViewById(R.id.singlejob_gogetter_name);
                        gogetter_name.setText(response.body().getPosters().get(0).getName());
                        gogetter_name.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialogBuilder.setTitle("Testing of gogetter Text Click");
                                alertDialogBuilder.setMessage("will be used for future purpose if needed");
                                alertDialogBuilder.show();
                            }
                        });

                        gogetter_image = (ImageView) findViewById(R.id.singlejob_gogetter_image);
                        gogetter_image.setImageResource(R.drawable.runningman_tale_color_01);
                        gogetter_image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialogBuilder.setTitle("Testing of gogetter Image Click");
                                alertDialogBuilder.setMessage("will be used for future purpose if needed");
                                alertDialogBuilder.show();
                            }
                        });

                        claim = (Button)findViewById(R.id.singlejob_claim);
                        claim.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialogBuilder.setTitle("Testing of claming job click");
                                alertDialogBuilder.setMessage("will be used for future purpose if needed");
                                alertDialogBuilder.show();
                            }
                        });

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
