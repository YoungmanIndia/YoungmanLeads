package in.co.youngman.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vikasmahato on 22/02/18.
 */

public class Leads {

    @SerializedName("id")
    private int id;

    @SerializedName("created_by")
    private int createdBy;

    @SerializedName("company_name")
    private String companyName;

    @SerializedName("email")
    private String email;

    @SerializedName("phone_number")
    private long phoneNumber;

    @SerializedName("stage")
    private String stage;

    @SerializedName("assigned_to")
    private int assignedTo;

    public Leads(int id, int createdBy, String companyName, String email, long phoneNumber, String stage, int assignedTo) {
        this.id = id;
        this.createdBy = createdBy;
        this.companyName = companyName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.stage = stage;
        this.assignedTo = assignedTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }
}
