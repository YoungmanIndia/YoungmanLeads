package in.co.youngman.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vikasmahato on 22/02/18.
 */

public class LeadNote {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("leads_id")
    @Expose
    private Integer leadsId;
    @SerializedName("note_type")
    @Expose
    private String noteType;
    @SerializedName("note_url")
    @Expose
    private Object noteUrl;
    @SerializedName("note_value")
    @Expose
    private String noteValue;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public LeadNote() {
    }

    /**
     *
     * @param updatedAt
     * @param leadsId
     * @param id
     * @param noteUrl
     * @param noteType
     * @param createdAt
     * @param noteValue
     */
    public LeadNote(Integer id, Integer leadsId, String noteType, Object noteUrl, String noteValue, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.leadsId = leadsId;
        this.noteType = noteType;
        this.noteUrl = noteUrl;
        this.noteValue = noteValue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.type = "note";
    }

    public LeadNote(Integer leadsId, String noteValue){
        this.leadsId = leadsId;
        this.noteType = "test";
        this.noteValue = noteValue;
        this.type = "note";
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

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public Object getNoteUrl() {
        return noteUrl;
    }

    public void setNoteUrl(Object noteUrl) {
        this.noteUrl = noteUrl;
    }

    public String getNoteValue() {
        return noteValue;
    }

    public void setNoteValue(String noteValue) {
        this.noteValue = noteValue;
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

