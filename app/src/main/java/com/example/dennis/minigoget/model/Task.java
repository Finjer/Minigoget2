package com.example.dennis.minigoget.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Task extends RealmObject {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("job_id")
    @Expose
    private Integer jobId;
    @SerializedName("gogetter_id")
    @Expose
    private Integer gogetterId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("location_lat")
    @Expose
    private Double locationLat;
    @SerializedName("location_long")
    @Expose
    private Double locationLong;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("start_at")
    @Expose
    private String startAt;
    @SerializedName("end_at")
    @Expose
    private String endAt;
    @SerializedName("ended_at")
    @Expose
    private String endedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("linked_job_id")
    @Expose
    private Integer linkedJobId;

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
     * The jobId
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     *
     * @param jobId
     * The job_id
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     *
     * @return
     * The gogetterId
     */
    public Integer getGogetterId() {
        return gogetterId;
    }

    /**
     *
     * @param gogetterId
     * The gogetter_id
     */
    public void setGogetterId(Integer gogetterId) {
        this.gogetterId = gogetterId;
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
     * The location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The locationLat
     */
    public Double getLocationLat() {
        return locationLat;
    }

    /**
     *
     * @param locationLat
     * The location_lat
     */
    public void setLocationLat(Double locationLat) {
        this.locationLat = locationLat;
    }

    /**
     *
     * @return
     * The locationLong
     */
    public Double getLocationLong() {
        return locationLong;
    }

    /**
     *
     * @param locationLong
     * The location_long
     */
    public void setLocationLong(Double locationLong) {
        this.locationLong = locationLong;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The startAt
     */
    public String getStartAt() {
        return startAt;
    }

    /**
     *
     * @param startAt
     * The start_at
     */
    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    /**
     *
     * @return
     * The endAt
     */
    public String getEndAt() {
        return endAt;
    }

    /**
     *
     * @param endAt
     * The end_at
     */
    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    /**
     *
     * @return
     * The endedAt
     */
    public String getEndedAt() {
        return endedAt;
    }

    /**
     *
     * @param endedAt
     * The ended_at
     */
    public void setEndedAt(String endedAt) {
        this.endedAt = endedAt;
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
     * The order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     *
     * @param order
     * The order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     *
     * @return
     * The linkedJobId
     */
    public Integer getLinkedJobId() {
        return linkedJobId;
    }

    /**
     *
     * @param linkedJobId
     * The linked_job_id
     */
    public void setLinkedJobId(Integer linkedJobId) {
        this.linkedJobId = linkedJobId;
    }

}