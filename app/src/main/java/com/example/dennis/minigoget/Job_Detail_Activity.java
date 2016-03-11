package com.example.dennis.minigoget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by park on 2016-03-10.
 */
public class Job_Detail_Activity extends Activity {

    TextView detail;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.goget_job_detail);

        Intent intent = this.getIntent();
        id = intent.getIntExtra("goget_id",id);
        detail = (TextView) findViewById(R.id.textView);
        detail.setText("hihi: "+ ""+id);

    }
}
