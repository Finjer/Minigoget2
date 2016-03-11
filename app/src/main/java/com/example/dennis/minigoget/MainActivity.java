package com.example.dennis.minigoget;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dennis.minigoget.API.GoGetService;
import com.example.dennis.minigoget.Service.ServiceGenerator;
import com.example.dennis.minigoget.model.user;
import com.example.dennis.minigoget.model.gogetLogin;
import com.example.dennis.minigoget.model.userContainer;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends ActionBarActivity {

    //Interactable Components
    EditText minigoget_email,minigoget_password;
    Button minigoget_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Input retrieving point.
        minigoget_email = (EditText) findViewById(R.id.mainmenu_edittext_email);
        minigoget_password = (EditText) findViewById(R.id.mainmenu_edittext_password);
        minigoget_login = (Button) findViewById(R.id.mainmenu_button_login);

        //For error message for pressing login
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        View.OnClickListener loginListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //set up service of retrofit.
                GoGetService loginTesting = ServiceGenerator.createService(GoGetService.class);

                //create container object to pass it on server through retrofit.
                user user = new user();
                user.setEmail(minigoget_email.getText().toString());
                user.setPassword(minigoget_password.getText().toString());
                userContainer container = new userContainer();
                container.setUser(user);

                //create call and start request
                Call<gogetLogin> call = loginTesting.login(container);
                call.enqueue(new Callback<gogetLogin>() {
                    @Override
                    public void onResponse(Call<gogetLogin> call, Response<gogetLogin> response) {
                        if (response.isSuccess() == true) {

                            //case of login success
                            alertDialogBuilder.setTitle("Login Success");
                            alertDialogBuilder.setMessage("Your Email and Password is valid.");
                            alertDialogBuilder.show();

                            //Intent to go to next activity (googlemap)
                            Intent intent=new Intent(MainActivity.this,submainactivity.class);
                            intent.putExtra("authen_token", response.body().getData().getAuthToken());
                            startActivity(intent);
                        }
                        else {

                            //case of network interaction error
                            alertDialogBuilder.setTitle("Login Error");
                            try {
                                alertDialogBuilder.setMessage("Your Email and Password may be invalid, please check again. \n" + response.errorBody().string() + ".");
                                alertDialogBuilder.show();
                            }
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<gogetLogin> call, Throwable t) {
                        //case of network interaction error
                        alertDialogBuilder.setTitle("Network Error");
                        alertDialogBuilder.setMessage("Please check your Network to further proceed.");
                        alertDialogBuilder.show();
                    }

                });
            }
        };

        //setting up button on click listener
        minigoget_login.setOnClickListener(loginListener);

    }

}
