package com.example.dennis.minigoget.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class availableJobs{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("promo_id")
    @Expose
    private Object promoId;
    @SerializedName("poster_tip")
    @Expose
    private Integer posterTip;
    @SerializedName("admin_tip")
    @Expose
    private Integer adminTip;
    @SerializedName("partner_tip")
    @Expose
    private Integer partnerTip;
    @SerializedName("item_price_range")
    @Expose
    private String itemPriceRange;
    @SerializedName("auto_approve")
    @Expose
    private Boolean autoApprove;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("fav_gogetters")
    @Expose
    private Boolean favGogetters;
    @SerializedName("ride_id")
    @Expose
    private Integer rideId;
    @SerializedName("category")
    @Expose
    private Object category;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("posted_at")
    @Expose
    private String postedAt;
    @SerializedName("approved_at")
    @Expose
    private Object approvedAt;
    @SerializedName("expired_at")
    @Expose
    private Object expiredAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("cancel_reason")
    @Expose
    private Object cancelReason;
    @SerializedName("cancel_user_id")
    @Expose
    private Object cancelUserId;
    @SerializedName("started_at")
    @Expose
    private Object startedAt;
    @SerializedName("distance_covered")
    @Expose
    private Integer distanceCovered;
    @SerializedName("cancelled_at")
    @Expose
    private Object cancelledAt;
    @SerializedName("deactivated")
    @Expose
    private Boolean deactivated;
    @SerializedName("expire_at")
    @Expose
    private String expireAt;
    @SerializedName("start_at")
    @Expose
    private String startAt;
    @SerializedName("admin_paid_at")
    @Expose
    private Object adminPaidAt;
    @SerializedName("paid_by_id")
    @Expose
    private Object paidById;
    @SerializedName("meet_at_car")
    @Expose
    private Boolean meetAtCar;
    @SerializedName("fragile")
    @Expose
    private Boolean fragile;
    @SerializedName("labour")
    @Expose
    private Boolean labour;
    @SerializedName("poster_review_id")
    @Expose
    private Object posterReviewId;
    @SerializedName("gogetter_review_id")
    @Expose
    private Object gogetterReviewId;
    @SerializedName("job_type")
    @Expose
    private String jobType;
    @SerializedName("dispatch_item")
    @Expose
    private Object dispatchItem;
    @SerializedName("dispatch_item_others")
    @Expose
    private Object dispatchItemOthers;
    @SerializedName("completed_at")
    @Expose
    private Object completedAt;
    @SerializedName("suggested_tip")
    @Expose
    private Integer suggestedTip;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("dry_run")
    @Expose
    private Boolean dryRun;
    @SerializedName("disable_promo_pickup")
    @Expose
    private Boolean disablePromoPickup;
    @SerializedName("disable_promo_time")
    @Expose
    private Boolean disablePromoTime;
    @SerializedName("hide_promo_cost")
    @Expose
    private Boolean hidePromoCost;
    @SerializedName("disable_promo_task_name")
    @Expose
    private Boolean disablePromoTaskName;
    @SerializedName("tasks")
    @Expose
    private List<Task> tasks = new ArrayList<Task>();
    @SerializedName("posters")
    @Expose
    private List<Poster> posters = new ArrayList<Poster>();

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
     * The promoId
     */
    public Object getPromoId() {
        return promoId;
    }

    /**
     *
     * @param promoId
     * The promo_id
     */
    public void setPromoId(Object promoId) {
        this.promoId = promoId;
    }

    /**
     *
     * @return
     * The posterTip
     */
    public Integer getPosterTip() {
        return posterTip;
    }

    /**
     *
     * @param posterTip
     * The poster_tip
     */
    public void setPosterTip(Integer posterTip) {
        this.posterTip = posterTip;
    }

    /**
     *
     * @return
     * The adminTip
     */
    public Integer getAdminTip() {
        return adminTip;
    }

    /**
     *
     * @param adminTip
     * The admin_tip
     */
    public void setAdminTip(Integer adminTip) {
        this.adminTip = adminTip;
    }

    /**
     *
     * @return
     * The partnerTip
     */
    public Integer getPartnerTip() {
        return partnerTip;
    }

    /**
     *
     * @param partnerTip
     * The partner_tip
     */
    public void setPartnerTip(Integer partnerTip) {
        this.partnerTip = partnerTip;
    }

    /**
     *
     * @return
     * The itemPriceRange
     */
    public String getItemPriceRange() {
        return itemPriceRange;
    }

    /**
     *
     * @param itemPriceRange
     * The item_price_range
     */
    public void setItemPriceRange(String itemPriceRange) {
        this.itemPriceRange = itemPriceRange;
    }

    /**
     *
     * @return
     * The autoApprove
     */
    public Boolean getAutoApprove() {
        return autoApprove;
    }

    /**
     *
     * @param autoApprove
     * The auto_approve
     */
    public void setAutoApprove(Boolean autoApprove) {
        this.autoApprove = autoApprove;
    }

    /**
     *
     * @return
     * The notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     * The notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     * The favGogetters
     */
    public Boolean getFavGogetters() {
        return favGogetters;
    }

    /**
     *
     * @param favGogetters
     * The fav_gogetters
     */
    public void setFavGogetters(Boolean favGogetters) {
        this.favGogetters = favGogetters;
    }

    /**
     *
     * @return
     * The rideId
     */
    public Integer getRideId() {
        return rideId;
    }

    /**
     *
     * @param rideId
     * The ride_id
     */
    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

    /**
     *
     * @return
     * The category
     */
    public Object getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    public void setCategory(Object category) {
        this.category = category;
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
     * The postedAt
     */
    public String getPostedAt() {
        return postedAt;
    }

    /**
     *
     * @param postedAt
     * The posted_at
     */
    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }

    /**
     *
     * @return
     * The approvedAt
     */
    public Object getApprovedAt() {
        return approvedAt;
    }

    /**
     *
     * @param approvedAt
     * The approved_at
     */
    public void setApprovedAt(Object approvedAt) {
        this.approvedAt = approvedAt;
    }

    /**
     *
     * @return
     * The expiredAt
     */
    public Object getExpiredAt() {
        return expiredAt;
    }

    /**
     *
     * @param expiredAt
     * The expired_at
     */
    public void setExpiredAt(Object expiredAt) {
        this.expiredAt = expiredAt;
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
     * The cancelReason
     */
    public Object getCancelReason() {
        return cancelReason;
    }

    /**
     *
     * @param cancelReason
     * The cancel_reason
     */
    public void setCancelReason(Object cancelReason) {
        this.cancelReason = cancelReason;
    }

    /**
     *
     * @return
     * The cancelUserId
     */
    public Object getCancelUserId() {
        return cancelUserId;
    }

    /**
     *
     * @param cancelUserId
     * The cancel_user_id
     */
    public void setCancelUserId(Object cancelUserId) {
        this.cancelUserId = cancelUserId;
    }

    /**
     *
     * @return
     * The startedAt
     */
    public Object getStartedAt() {
        return startedAt;
    }

    /**
     *
     * @param startedAt
     * The started_at
     */
    public void setStartedAt(Object startedAt) {
        this.startedAt = startedAt;
    }

    /**
     *
     * @return
     * The distanceCovered
     */
    public Integer getDistanceCovered() {
        return distanceCovered;
    }

    /**
     *
     * @param distanceCovered
     * The distance_covered
     */
    public void setDistanceCovered(Integer distanceCovered) {
        this.distanceCovered = distanceCovered;
    }

    /**
     *
     * @return
     * The cancelledAt
     */
    public Object getCancelledAt() {
        return cancelledAt;
    }

    /**
     *
     * @param cancelledAt
     * The cancelled_at
     */
    public void setCancelledAt(Object cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    /**
     *
     * @return
     * The deactivated
     */
    public Boolean getDeactivated() {
        return deactivated;
    }

    /**
     *
     * @param deactivated
     * The deactivated
     */
    public void setDeactivated(Boolean deactivated) {
        this.deactivated = deactivated;
    }

    /**
     *
     * @return
     * The expireAt
     */
    public String getExpireAt() {
        return expireAt;
    }

    /**
     *
     * @param expireAt
     * The expire_at
     */
    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
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
     * The adminPaidAt
     */
    public Object getAdminPaidAt() {
        return adminPaidAt;
    }

    /**
     *
     * @param adminPaidAt
     * The admin_paid_at
     */
    public void setAdminPaidAt(Object adminPaidAt) {
        this.adminPaidAt = adminPaidAt;
    }

    /**
     *
     * @return
     * The paidById
     */
    public Object getPaidById() {
        return paidById;
    }

    /**
     *
     * @param paidById
     * The paid_by_id
     */
    public void setPaidById(Object paidById) {
        this.paidById = paidById;
    }

    /**
     *
     * @return
     * The meetAtCar
     */
    public Boolean getMeetAtCar() {
        return meetAtCar;
    }

    /**
     *
     * @param meetAtCar
     * The meet_at_car
     */
    public void setMeetAtCar(Boolean meetAtCar) {
        this.meetAtCar = meetAtCar;
    }

    /**
     *
     * @return
     * The fragile
     */
    public Boolean getFragile() {
        return fragile;
    }

    /**
     *
     * @param fragile
     * The fragile
     */
    public void setFragile(Boolean fragile) {
        this.fragile = fragile;
    }

    /**
     *
     * @return
     * The labour
     */
    public Boolean getLabour() {
        return labour;
    }

    /**
     *
     * @param labour
     * The labour
     */
    public void setLabour(Boolean labour) {
        this.labour = labour;
    }

    /**
     *
     * @return
     * The posterReviewId
     */
    public Object getPosterReviewId() {
        return posterReviewId;
    }

    /**
     *
     * @param posterReviewId
     * The poster_review_id
     */
    public void setPosterReviewId(Object posterReviewId) {
        this.posterReviewId = posterReviewId;
    }

    /**
     *
     * @return
     * The gogetterReviewId
     */
    public Object getGogetterReviewId() {
        return gogetterReviewId;
    }

    /**
     *
     * @param gogetterReviewId
     * The gogetter_review_id
     */
    public void setGogetterReviewId(Object gogetterReviewId) {
        this.gogetterReviewId = gogetterReviewId;
    }

    /**
     *
     * @return
     * The jobType
     */
    public String getJobType() {
        return jobType;
    }

    /**
     *
     * @param jobType
     * The job_type
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     *
     * @return
     * The dispatchItem
     */
    public Object getDispatchItem() {
        return dispatchItem;
    }

    /**
     *
     * @param dispatchItem
     * The dispatch_item
     */
    public void setDispatchItem(Object dispatchItem) {
        this.dispatchItem = dispatchItem;
    }

    /**
     *
     * @return
     * The dispatchItemOthers
     */
    public Object getDispatchItemOthers() {
        return dispatchItemOthers;
    }

    /**
     *
     * @param dispatchItemOthers
     * The dispatch_item_others
     */
    public void setDispatchItemOthers(Object dispatchItemOthers) {
        this.dispatchItemOthers = dispatchItemOthers;
    }

    /**
     *
     * @return
     * The completedAt
     */
    public Object getCompletedAt() {
        return completedAt;
    }

    /**
     *
     * @param completedAt
     * The completed_at
     */
    public void setCompletedAt(Object completedAt) {
        this.completedAt = completedAt;
    }

    /**
     *
     * @return
     * The suggestedTip
     */
    public Integer getSuggestedTip() {
        return suggestedTip;
    }

    /**
     *
     * @param suggestedTip
     * The suggested_tip
     */
    public void setSuggestedTip(Integer suggestedTip) {
        this.suggestedTip = suggestedTip;
    }

    /**
     *
     * @return
     * The platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     *
     * @param platform
     * The platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     *
     * @return
     * The dryRun
     */
    public Boolean getDryRun() {
        return dryRun;
    }

    /**
     *
     * @param dryRun
     * The dry_run
     */
    public void setDryRun(Boolean dryRun) {
        this.dryRun = dryRun;
    }

    /**
     *
     * @return
     * The disablePromoPickup
     */
    public Boolean getDisablePromoPickup() {
        return disablePromoPickup;
    }

    /**
     *
     * @param disablePromoPickup
     * The disable_promo_pickup
     */
    public void setDisablePromoPickup(Boolean disablePromoPickup) {
        this.disablePromoPickup = disablePromoPickup;
    }

    /**
     *
     * @return
     * The disablePromoTime
     */
    public Boolean getDisablePromoTime() {
        return disablePromoTime;
    }

    /**
     *
     * @param disablePromoTime
     * The disable_promo_time
     */
    public void setDisablePromoTime(Boolean disablePromoTime) {
        this.disablePromoTime = disablePromoTime;
    }

    /**
     *
     * @return
     * The hidePromoCost
     */
    public Boolean getHidePromoCost() {
        return hidePromoCost;
    }

    /**
     *
     * @param hidePromoCost
     * The hide_promo_cost
     */
    public void setHidePromoCost(Boolean hidePromoCost) {
        this.hidePromoCost = hidePromoCost;
    }

    /**
     *
     * @return
     * The disablePromoTaskName
     */
    public Boolean getDisablePromoTaskName() {
        return disablePromoTaskName;
    }

    /**
     *
     * @param disablePromoTaskName
     * The disable_promo_task_name
     */
    public void setDisablePromoTaskName(Boolean disablePromoTaskName) {
        this.disablePromoTaskName = disablePromoTaskName;
    }

    /**
     *
     * @return
     * The tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     *
     * @param tasks
     * The tasks
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     *
     * @return
     * The posters
     */
    public List<Poster> getPosters() {
        return posters;
    }

    /**
     *
     * @param posters
     * The posters
     */
    public void setPosters(List<Poster> posters) {
        this.posters = posters;
    }

}