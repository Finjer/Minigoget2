package com.example.dennis.minigoget.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class gogetLogin {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("data")
    @Expose
    private com.example.dennis.minigoget.model.data data;

    /**
     *
     * @return
     * The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The info
     */
    public String getInfo() {
        return info;
    }

    /**
     *
     * @param info
     * The info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     *
     * @return
     * The data
     */
    public com.example.dennis.minigoget.model.data getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(com.example.dennis.minigoget.model.data data) {
        this.data = data;
    }

}