package in.co.youngman.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("credit_limit")
    @Expose
    private String creditLimit;
    @SerializedName("billing_address_line")
    @Expose
    private String billingAddressLine;
    @SerializedName("billing_address_city")
    @Expose
    private String billingAddressCity;
    @SerializedName("billing_address_pincode")
    @Expose
    private String billingAddressPincode;
    @SerializedName("mailing_address_line")
    @Expose
    private String mailingAddressLine;
    @SerializedName("mailing_address_city")
    @Expose
    private String mailingAddressCity;
    @SerializedName("mailing_address_pincode")
    @Expose
    private String mailingAddressPincode;
    @SerializedName("gstn")
    @Expose
    private String gstn;
    @SerializedName("quickbooks_id")
    @Expose
    private String quickbooksId;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * No args constructor for use in serialization
     *
     */
    public Customer() {
    }

    /**
     *
     * @param lastName
     * @param quickbooksId
     * @param creditLimit
     * @param billingAddressCity
     * @param mailingAddressPincode
     * @param id
     * @param updatedAt
     * @param billingAddressLine
     * @param phoneNumber
     * @param mailingAddressLine
     * @param mailingAddressCity
     * @param email
     * @param createdAt
     * @param company
     * @param billingAddressPincode
     * @param gstn
     * @param firstName
     */
    public Customer(String firstName, String lastName, String company, String email, String phoneNumber, String creditLimit, String billingAddressLine, String billingAddressCity, String billingAddressPincode, String mailingAddressLine, String mailingAddressCity, String mailingAddressPincode, String gstn, String quickbooksId, String updatedAt, String createdAt, Integer id) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.creditLimit = creditLimit;
        this.billingAddressLine = billingAddressLine;
        this.billingAddressCity = billingAddressCity;
        this.billingAddressPincode = billingAddressPincode;
        this.mailingAddressLine = mailingAddressLine;
        this.mailingAddressCity = mailingAddressCity;
        this.mailingAddressPincode = mailingAddressPincode;
        this.gstn = gstn;
        this.quickbooksId = quickbooksId;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.id = id;
    }

    /**
     *
     * @param lastName
     * @param creditLimit
     * @param billingAddressCity
     * @param mailingAddressPincode
     * @param billingAddressLine
     * @param phoneNumber
     * @param mailingAddressLine
     * @param mailingAddressCity
     * @param email
     * @param company
     * @param billingAddressPincode
     * @param gstn
     * @param firstName
     */
    public Customer(String firstName, String lastName, String company, String email, String phoneNumber, String creditLimit, String billingAddressLine, String billingAddressCity, String billingAddressPincode, String mailingAddressLine, String mailingAddressCity, String mailingAddressPincode, String gstn) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.creditLimit = creditLimit;
        this.billingAddressLine = billingAddressLine;
        this.billingAddressCity = billingAddressCity;
        this.billingAddressPincode = billingAddressPincode;
        this.mailingAddressLine = mailingAddressLine;
        this.mailingAddressCity = mailingAddressCity;
        this.mailingAddressPincode = mailingAddressPincode;
        this.gstn = gstn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getBillingAddressLine() {
        return billingAddressLine;
    }

    public void setBillingAddressLine(String billingAddressLine) {
        this.billingAddressLine = billingAddressLine;
    }

    public String getBillingAddressCity() {
        return billingAddressCity;
    }

    public void setBillingAddressCity(String billingAddressCity) {
        this.billingAddressCity = billingAddressCity;
    }

    public String getBillingAddressPincode() {
        return billingAddressPincode;
    }

    public void setBillingAddressPincode(String billingAddressPincode) {
        this.billingAddressPincode = billingAddressPincode;
    }

    public String getMailingAddressLine() {
        return mailingAddressLine;
    }

    public void setMailingAddressLine(String mailingAddressLine) {
        this.mailingAddressLine = mailingAddressLine;
    }

    public String getMailingAddressCity() {
        return mailingAddressCity;
    }

    public void setMailingAddressCity(String mailingAddressCity) {
        this.mailingAddressCity = mailingAddressCity;
    }

    public String getMailingAddressPincode() {
        return mailingAddressPincode;
    }

    public void setMailingAddressPincode(String mailingAddressPincode) {
        this.mailingAddressPincode = mailingAddressPincode;
    }

    public String getGstn() {
        return gstn;
    }

    public void setGstn(String gstn) {
        this.gstn = gstn;
    }

    public String getQuickbooksId() {
        return quickbooksId;
    }

    public void setQuickbooksId(String quickbooksId) {
        this.quickbooksId = quickbooksId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
