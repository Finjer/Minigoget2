package com.example.dennis.minigoget.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Poster {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone_num")
    @Expose
    private String phoneNum;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("friends_count")
    @Expose
    private Object friendsCount;
    @SerializedName("last_location")
    @Expose
    private Object lastLocation;
    @SerializedName("last_location_lat")
    @Expose
    private Double lastLocationLat;
    @SerializedName("last_location_long")
    @Expose
    private Double lastLocationLong;
    @SerializedName("fb_friends")
    @Expose
    private Object fbFriends;
    @SerializedName("fb_likes")
    @Expose
    private Object fbLikes;
    @SerializedName("fb_flag")
    @Expose
    private Boolean fbFlag;
    @SerializedName("phone_verified")
    @Expose
    private Boolean phoneVerified;
    @SerializedName("phone_confirm_code")
    @Expose
    private Object phoneConfirmCode;
    @SerializedName("location_updated_at")
    @Expose
    private String locationUpdatedAt;
    @SerializedName("authentication_token")
    @Expose
    private String authenticationToken;
    @SerializedName("current_role")
    @Expose
    private String currentRole;
    @SerializedName("default_location")
    @Expose
    private Object defaultLocation;
    @SerializedName("default_location_lat")
    @Expose
    private Object defaultLocationLat;
    @SerializedName("default_location_long")
    @Expose
    private Object defaultLocationLong;
    @SerializedName("avatar_uploader")
    @Expose
    private AvatarUploader avatarUploader;
    @SerializedName("new_job_notifications_enabled")
    @Expose
    private Boolean newJobNotificationsEnabled;
    @SerializedName("email_notifications_enabled")
    @Expose
    private Boolean emailNotificationsEnabled;
    @SerializedName("v1id")
    @Expose
    private Object v1id;
    @SerializedName("banned")
    @Expose
    private Boolean banned;
    @SerializedName("business_id")
    @Expose
    private Object businessId;
    @SerializedName("phone_verified_num")
    @Expose
    private String phoneVerifiedNum;
    @SerializedName("intercom_id")
    @Expose
    private Object intercomId;
    @SerializedName("student")
    @Expose
    private Boolean student;
    @SerializedName("credit")
    @Expose
    private Integer credit;
    @SerializedName("referral_code")
    @Expose
    private String referralCode;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     *
     * @param avatar
     * The avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     *
     * @param phoneNum
     * The phone_num
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     *
     * @return
     * The about
     */
    public String getAbout() {
        return about;
    }

    /**
     *
     * @param about
     * The about
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The friendsCount
     */
    public Object getFriendsCount() {
        return friendsCount;
    }

    /**
     *
     * @param friendsCount
     * The friends_count
     */
    public void setFriendsCount(Object friendsCount) {
        this.friendsCount = friendsCount;
    }

    /**
     *
     * @return
     * The lastLocation
     */
    public Object getLastLocation() {
        return lastLocation;
    }

    /**
     *
     * @param lastLocation
     * The last_location
     */
    public void setLastLocation(Object lastLocation) {
        this.lastLocation = lastLocation;
    }

    /**
     *
     * @return
     * The lastLocationLat
     */
    public Double getLastLocationLat() {
        return lastLocationLat;
    }

    /**
     *
     * @param lastLocationLat
     * The last_location_lat
     */
    public void setLastLocationLat(Double lastLocationLat) {
        this.lastLocationLat = lastLocationLat;
    }

    /**
     *
     * @return
     * The lastLocationLong
     */
    public Double getLastLocationLong() {
        return lastLocationLong;
    }

    /**
     *
     * @param lastLocationLong
     * The last_location_long
     */
    public void setLastLocationLong(Double lastLocationLong) {
        this.lastLocationLong = lastLocationLong;
    }

    /**
     *
     * @return
     * The fbFriends
     */
    public Object getFbFriends() {
        return fbFriends;
    }

    /**
     *
     * @param fbFriends
     * The fb_friends
     */
    public void setFbFriends(Object fbFriends) {
        this.fbFriends = fbFriends;
    }

    /**
     *
     * @return
     * The fbLikes
     */
    public Object getFbLikes() {
        return fbLikes;
    }

    /**
     *
     * @param fbLikes
     * The fb_likes
     */
    public void setFbLikes(Object fbLikes) {
        this.fbLikes = fbLikes;
    }

    /**
     *
     * @return
     * The fbFlag
     */
    public Boolean getFbFlag() {
        return fbFlag;
    }

    /**
     *
     * @param fbFlag
     * The fb_flag
     */
    public void setFbFlag(Boolean fbFlag) {
        this.fbFlag = fbFlag;
    }

    /**
     *
     * @return
     * The phoneVerified
     */
    public Boolean getPhoneVerified() {
        return phoneVerified;
    }

    /**
     *
     * @param phoneVerified
     * The phone_verified
     */
    public void setPhoneVerified(Boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    /**
     *
     * @return
     * The phoneConfirmCode
     */
    public Object getPhoneConfirmCode() {
        return phoneConfirmCode;
    }

    /**
     *
     * @param phoneConfirmCode
     * The phone_confirm_code
     */
    public void setPhoneConfirmCode(Object phoneConfirmCode) {
        this.phoneConfirmCode = phoneConfirmCode;
    }

    /**
     *
     * @return
     * The locationUpdatedAt
     */
    public String getLocationUpdatedAt() {
        return locationUpdatedAt;
    }

    /**
     *
     * @param locationUpdatedAt
     * The location_updated_at
     */
    public void setLocationUpdatedAt(String locationUpdatedAt) {
        this.locationUpdatedAt = locationUpdatedAt;
    }

    /**
     *
     * @return
     * The authenticationToken
     */
    public String getAuthenticationToken() {
        return authenticationToken;
    }

    /**
     *
     * @param authenticationToken
     * The authentication_token
     */
    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    /**
     *
     * @return
     * The currentRole
     */
    public String getCurrentRole() {
        return currentRole;
    }

    /**
     *
     * @param currentRole
     * The current_role
     */
    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

    /**
     *
     * @return
     * The defaultLocation
     */
    public Object getDefaultLocation() {
        return defaultLocation;
    }

    /**
     *
     * @param defaultLocation
     * The default_location
     */
    public void setDefaultLocation(Object defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    /**
     *
     * @return
     * The defaultLocationLat
     */
    public Object getDefaultLocationLat() {
        return defaultLocationLat;
    }

    /**
     *
     * @param defaultLocationLat
     * The default_location_lat
     */
    public void setDefaultLocationLat(Object defaultLocationLat) {
        this.defaultLocationLat = defaultLocationLat;
    }

    /**
     *
     * @return
     * The defaultLocationLong
     */
    public Object getDefaultLocationLong() {
        return defaultLocationLong;
    }

    /**
     *
     * @param defaultLocationLong
     * The default_location_long
     */
    public void setDefaultLocationLong(Object defaultLocationLong) {
        this.defaultLocationLong = defaultLocationLong;
    }

    /**
     *
     * @return
     * The avatarUploader
     */
    public AvatarUploader getAvatarUploader() {
        return avatarUploader;
    }

    /**
     *
     * @param avatarUploader
     * The avatar_uploader
     */
    public void setAvatarUploader(AvatarUploader avatarUploader) {
        this.avatarUploader = avatarUploader;
    }

    /**
     *
     * @return
     * The newJobNotificationsEnabled
     */
    public Boolean getNewJobNotificationsEnabled() {
        return newJobNotificationsEnabled;
    }

    /**
     *
     * @param newJobNotificationsEnabled
     * The new_job_notifications_enabled
     */
    public void setNewJobNotificationsEnabled(Boolean newJobNotificationsEnabled) {
        this.newJobNotificationsEnabled = newJobNotificationsEnabled;
    }

    /**
     *
     * @return
     * The emailNotificationsEnabled
     */
    public Boolean getEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    /**
     *
     * @param emailNotificationsEnabled
     * The email_notifications_enabled
     */
    public void setEmailNotificationsEnabled(Boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
    }

    /**
     *
     * @return
     * The v1id
     */
    public Object getV1id() {
        return v1id;
    }

    /**
     *
     * @param v1id
     * The v1id
     */
    public void setV1id(Object v1id) {
        this.v1id = v1id;
    }

    /**
     *
     * @return
     * The banned
     */
    public Boolean getBanned() {
        return banned;
    }

    /**
     *
     * @param banned
     * The banned
     */
    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    /**
     *
     * @return
     * The businessId
     */
    public Object getBusinessId() {
        return businessId;
    }

    /**
     *
     * @param businessId
     * The business_id
     */
    public void setBusinessId(Object businessId) {
        this.businessId = businessId;
    }

    /**
     *
     * @return
     * The phoneVerifiedNum
     */
    public String getPhoneVerifiedNum() {
        return phoneVerifiedNum;
    }

    /**
     *
     * @param phoneVerifiedNum
     * The phone_verified_num
     */
    public void setPhoneVerifiedNum(String phoneVerifiedNum) {
        this.phoneVerifiedNum = phoneVerifiedNum;
    }

    /**
     *
     * @return
     * The intercomId
     */
    public Object getIntercomId() {
        return intercomId;
    }

    /**
     *
     * @param intercomId
     * The intercom_id
     */
    public void setIntercomId(Object intercomId) {
        this.intercomId = intercomId;
    }

    /**
     *
     * @return
     * The student
     */
    public Boolean getStudent() {
        return student;
    }

    /**
     *
     * @param student
     * The student
     */
    public void setStudent(Boolean student) {
        this.student = student;
    }

    /**
     *
     * @return
     * The credit
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     *
     * @param credit
     * The credit
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    /**
     *
     * @return
     * The referralCode
     */
    public String getReferralCode() {
        return referralCode;
    }

    /**
     *
     * @param referralCode
     * The referral_code
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

}