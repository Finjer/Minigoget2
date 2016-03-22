package com.example.dennis.minigoget.model;

/**
 * Created by park on 2016-02-29.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class data extends RealmObject {

    @SerializedName("auth_token")
    @Expose
    private String authToken;

    /**
     *
     * @return
     * The authToken
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     *
     * @param authToken
     * The auth_token
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

}