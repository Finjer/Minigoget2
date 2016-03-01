
package com.example.dennis.minigoget.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvatarUploader {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("big_thumb")
    @Expose
    private BigThumb bigThumb;
    @SerializedName("medium_thumb")
    @Expose
    private MediumThumb mediumThumb;
    @SerializedName("thumb")
    @Expose
    private Thumb thumb;

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The bigThumb
     */
    public BigThumb getBigThumb() {
        return bigThumb;
    }

    /**
     *
     * @param bigThumb
     * The big_thumb
     */
    public void setBigThumb(BigThumb bigThumb) {
        this.bigThumb = bigThumb;
    }

    /**
     *
     * @return
     * The mediumThumb
     */
    public MediumThumb getMediumThumb() {
        return mediumThumb;
    }

    /**
     *
     * @param mediumThumb
     * The medium_thumb
     */
    public void setMediumThumb(MediumThumb mediumThumb) {
        this.mediumThumb = mediumThumb;
    }

    /**
     *
     * @return
     * The thumb
     */
    public Thumb getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb
     * The thumb
     */
    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

}