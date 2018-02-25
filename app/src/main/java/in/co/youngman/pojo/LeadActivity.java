package in.co.youngman.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vikasmahato on 22/02/18.
 */

public class LeadActivity {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("leads_id")
    @Expose
    private Integer leadsId;
    @SerializedName("activity")
    @Expose
    private String activity;
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
    public LeadActivity() {
    }

    /**
     *
     * @param updatedAt
     * @param leadsId
     * @param id
     * @param createdAt
     * @param activity
     */
    public LeadActivity(Integer id, Integer leadsId, String activity, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.leadsId = leadsId;
        this.activity = activity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
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

