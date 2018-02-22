package in.co.youngman.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vikasmahato on 23/02/18.
 */

public class Leads {
    public String company_name;
    public String body;

    @SerializedName("id")
    public String questionId;

    @Override
    public String toString() {
        return(company_name);
    }
}
