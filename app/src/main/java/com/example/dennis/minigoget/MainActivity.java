package com.example.dennis.minigoget;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.dennis.minigoget.API.GoGetService;
import com.example.dennis.minigoget.Service.ServiceGenerator;
import com.example.dennis.minigoget.model.availableJobs;
import com.example.dennis.minigoget.model.user;
import com.example.dennis.minigoget.model.gogetLogin;
import com.example.dennis.minigoget.model.userContainer;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends ActionBarActivity {

    EditText retro_Input;
    EditText index;
    TextView retro_Result;
    Button retro_Connect;
    Button retrofit_Generate;
    Button viewJobs;

    String authen_token=null;
    gogetLogin authen_object = new gogetLogin();
    List<availableJobs> joblists;
    String API = "https://api.github.com";                         //BASE URL
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retro_Input = (EditText) findViewById(R.id.retrofitInput);
        retro_Connect = (Button) findViewById(R.id.retrofitConnect);
        retro_Result = (TextView) findViewById(R.id.retrofitResult);
        retrofit_Generate = (Button) findViewById(R.id.retrofitGenerate);
        index = (EditText) findViewById(R.id.jobIndexNumber);
        viewJobs = (Button) findViewById(R.id.viewJob);


        View.OnClickListener viewJobListener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(joblists!=null){
                    Log.d("viewJob: "," joblist exist");
                    Log.d("viewJob: ", " " + joblists.get(Integer.parseInt(index.getText().toString())).getId());
                }
                else
                    Log.d("viewJob: "," joblist null");
            }
        };

        View.OnClickListener generateListender = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(authen_token!=null){
                    Log.d("Generate: ","authen_token success " +authen_token);
                    GoGetService generateJobs = ServiceGenerator.createService(GoGetService.class, authen_token);
                    Call<List<availableJobs>> call = generateJobs.getJobs();

                    Log.d("before callQueue: ", "before call Queue");
                    call.enqueue(new Callback<List<availableJobs>>() {
                        @Override
                        public void onResponse(Call<List<availableJobs>> call, Response<List<availableJobs>> response) {
                            Log.d("in callQueue: ","response call Queue1");
                            if (response.isSuccess()) {
                                Log.d("generateResponse: ", "success"+response.body().get(1).getId());
                                joblists = response.body();
                            } else {
                                try {
                                    Log.d("generateResponse: ", "failed: " + response.errorBody().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<List<availableJobs>> call, Throwable t) {
                            Log.d("in callQueue: ","failure call Queue1");
                        }
                    });
                    Log.d("after callQueue: ", "after call Queue");

                }

            }
        };
        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                GoGetService loginTesting = ServiceGenerator.createService(GoGetService.class);
                user user = new user();
                user.setEmail("finjer@naver.com");
                user.setPassword("finjer1215");
                userContainer container = new userContainer();
                container.setUser(user);
                Call<gogetLogin> call = loginTesting.login(container);
                call.enqueue(new Callback<gogetLogin>() {
                    @Override
                    public void onResponse(Call<gogetLogin> call, Response<gogetLogin> response) {
                        if (response.isSuccess()) {
                            Log.d("response", "auth:  " + response.body().getData().getAuthToken());
                            authen_token = response.body().getData().getAuthToken();
                            authen_object.setData(response.body().getData());
                            authen_object.setInfo(response.body().getInfo());
                            authen_object.setSuccess(response.body().getSuccess());
                            Log.d("AAA", "auth:  " + authen_object.getData().getAuthToken() + " - " + authen_object.getInfo() + " - " + authen_object.getSuccess());
                        } else {
                            Log.d("Error Raw.toString: ", response.raw().toString());
                            try {
                                Log.d("Error ErrorBody.string:", response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }


                    }

                    @Override
                    public void onFailure(Call<gogetLogin> call, Throwable t) {

                    }

                });
               // if(authen_object!=null)                    Log.d("AAA", "auth:  " + authen_object.getData().getAuthToken() + " - "+authen_object.getInfo()+" - "+ authen_object.getSuccess() );
                Log.d("AAA", "auth:  " + authen_token);
                /*
                try {
                    System.out.println("test1: ");
                    gogetLogin login = call.execute().body();
                    System.out.println("test2: " + login.getSuccess());
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

                /*
                //when button pressed get Edit text detail
                //String input = retro_Input.getText().toString();

                //set API url first for which stie we are getting first
                //String api_url = "https://api.github.com"; <-testing purpose only
                String api_url =  "https://staging.goget.my";

                OkHttpClient.Builder httpclient = new OkHttpClient.Builder();

                httpclient.addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        String credential = "finjer@naver.com:finjer1215";
                        String basic = "Basic " + Base64.encodeToString(credential.getBytes(),Base64.NO_WRAP);
                        Request original = chain.request();

                        Request.Builder requestBuilder  = original.newBuilder().header("Authorization", basic)
                        .header("Accept", "application/json").header("Content-Type",  "application/json")
                                .method(original.method(), original.body());
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                });

                //prepare to receive data in Gson format

                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Date.class, new DateTypeAdapter()).create();

                //OkHttpClient httpclient = new OkHttpClient();

                //set session for retrofit
                Retrofit retrofit = new Retrofit.Builder().baseUrl(api_url).addConverterFactory(GsonConverterFactory.create(gson)).client(httpclient.build()).build();

                Call<gogetLogin> loginService = retrofit.create(GitHubService.class).basicLogin();
                gogetLogin login = null;
                System.out.println(loginService.toString());

                try {
                    login = loginService.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(login.getSuccess());*/
                 /* <- testing purpose only
                Call<gogetLogin> model = retrofit.create(GitHubService.class).getUser(input);<-testing purpose only

                model.enqueue(new Callback<retrofitModel>() {
                    @Override
                    public void onResponse(Call<retrofitModel> call, Response<retrofitModel> response) {
                        retrofitModel m = response.body();
                        if(m == null ){
                            System.out.println("failure");

                        }
                        else{
                            System.out.println("calling: " + m.getName() + "  test: "+m.getCompany());
                            retro_Result.setText("Name: " + m.getName() + " Company: "+ m.getCompany());

                        }

                    }

                    @Override
                    public void onFailure(Call<retrofitModel> call, Throwable t) {
                        System.out.println("failed");
                    }
                });
                */

                /*       <- not working gotta test
                Call<gogetLogin> model = retrofit.create(GitHubService.class).loginPost("finjer@naver.com","finjer1215");

                model.enqueue(new Callback<gogetLogin>() {
                    @Override
                    public void onResponse(Call<gogetLogin> call, Response<gogetLogin> response) {
                        gogetLogin m = response.body();
                        if(m == null ){
                            System.out.println("failure");

                        }
                        else{
                            System.out.println("success: " + m.getSuccess() + "  info: "+m.getInfo() + " D ata:" + m.getD ata().toString());
                            retro_Result.setText("success: " + m.getSuccess() + "  info: "+m.getInfo() + " Da ta:" + m.getD ata().toString());

                        }

                    }

                    @Override
                    public void onFailure(Call<gogetLogin> call, Throwable t) {
                        System.out.println("failed");
                    }
                });

                */

            }
        };
        retrofit_Generate.setOnClickListener(generateListender);
        retro_Connect.setOnClickListener(listener);
        viewJobs.setOnClickListener(viewJobListener);
    }

}
