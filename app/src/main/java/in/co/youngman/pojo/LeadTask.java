package in.co.youngman.pojo;

/**
 * Created by vikasmahato on 22/02/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeadTask {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("leads_id")
    @Expose
    private Integer leadsId;
    @SerializedName("task")
    @Expose
    private String task;
    @SerializedName("remind_at")
    @Expose
    private String remindAt;
    @SerializedName("completed")
    @Expose
    private Integer completed;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    /**
     * No args constructor for use in serialization
     *
     */
    public LeadTask() {
    }

    /**
     *
     * @param updatedAt
     * @param leadsId
     * @param id
     * @param remindAt
     * @param createdAt
     * @param task
     * @param completed
     */
    public LeadTask(Integer id, Integer leadsId, String task, String remindAt, Integer completed, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.leadsId = leadsId;
        this.task = task;
        this.remindAt = remindAt;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LeadTask(String task, String remindAt) {
        this.task = task;
        this.remindAt = remindAt;
        this.completed = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeadsId() {
        return leadsId;
    }

    public void setLeadsId(Integer leadsId) {
        this.leadsId = leadsId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getRemindAt() {
        return remindAt;
    }

    public void setRemindAt(String remindAt) {
        this.remindAt = remindAt;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}

