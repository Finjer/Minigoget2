package com.example.dennis.minigoget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.dennis.minigoget.Presenter.ILoginPresenter;
import com.example.dennis.minigoget.Presenter.LoginPresenter;


public class MainActivity extends Activity implements LoginView {

    ILoginPresenter presenter;

    //Interactable Components
    EditText minigoget_email,minigoget_password;
    Button minigoget_login;
    //private EventBus eventbus = new EventBus().getDefault();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //eventbus.register(this);
        //EventBus.getDefault().register(this);

        presenter = new LoginPresenter(this);

        presenter.registerEventBus();

        //Input retrieving point.
        minigoget_email = (EditText) findViewById(R.id.mainmenu_edittext_email);
        minigoget_password = (EditText) findViewById(R.id.mainmenu_edittext_password);
        minigoget_login = (Button) findViewById(R.id.mainmenu_button_login);


        View.OnClickListener loginListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            presenter.loginAttempt(minigoget_email.getText().toString(),minigoget_password.getText().toString());

            }
        };

        //setting up button on click listener
        minigoget_login.setOnClickListener(loginListener);

    }

    @Override
    protected void onDestroy() {
        //eventbus.unregister(this);
        presenter.unRegisterEventBus();
        Log.d("Lastest","testing");
        super.onDestroy();


    }

    @Override
    public void loginSuccess(String authen_token) {

        //Intent to go to next activity (googlemap)
        Intent intent = new Intent(MainActivity.this, submainactivity.class);
        intent.putExtra("authen_token", authen_token);
        startActivity(intent);
        finish();

    }

    @Override
    public void loginFailure(String errorbody, boolean networkerror) {

        if(networkerror){

            //For error message for pressing login
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            //case of network interaction error
            alertDialogBuilder.setTitle("Network Error");
            alertDialogBuilder.setMessage("Please check your Network to further proceed.");
            alertDialogBuilder.show();
        }
        else{

            //For error message for pressing login
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

            //case of network interaction error
            alertDialogBuilder.setTitle("Login Error");
            alertDialogBuilder.setMessage("Your Email and Password may be invalid, please check again. \n" + errorbody + ".");
            alertDialogBuilder.show();
        }

    }
}
