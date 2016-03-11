package com.example.dennis.minigoget.model;

/**
 * Created by park on 2016-02-29.
 * A class to contain user email and password which will be sub_object of userContainer class
 * it will be used for goget server connectivity with using retrofit and
 * expect to receive authentication token or error message with different format.
 */
public class user {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
