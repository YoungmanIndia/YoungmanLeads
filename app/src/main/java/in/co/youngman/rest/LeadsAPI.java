package in.co.youngman.rest;

import in.co.youngman.pojo.Leads;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vikasmahato on 23/02/18.
 */

public interface LeadsAPI {
    String BASE_URL = "http://ec2-35-154-163-176.ap-south-1.compute.amazonaws.com/";

    @GET("/leads")
    Call<ListWrapper<Leads>> getLeads();

}