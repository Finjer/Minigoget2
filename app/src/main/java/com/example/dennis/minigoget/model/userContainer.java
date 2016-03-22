package com.example.dennis.minigoget.model;

import io.realm.RealmObject;

/**
 * Created by park on 2016-03-01.
 * a class that contains user class that stores user email and password which will be sub_object of userContainer class
 * it will be used for goget server connectivity with using retrofit and
 * expect to receive authentication token or error message with different format.
 */
public class userContainer {
    public com.example.dennis.minigoget.model.user getUser() {
        return user;
    }

    public void setUser(com.example.dennis.minigoget.model.user user) {
        this.user = user;
    }

    private user user;
}
