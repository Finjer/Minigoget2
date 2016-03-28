package com.example.dennis.minigoget;

import android.app.Application;
import android.content.res.Configuration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class app extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        setRealm();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    //Realm instantiation & initialization method
    private void setRealm(){
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(this)
                .name("miniGoget.realm").deleteRealmIfMigrationNeeded()
                .build());
    }

}
