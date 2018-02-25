package in.co.youngman.rest;

import in.co.youngman.pojo.LeadActivity;
import in.co.youngman.pojo.LeadNote;
import in.co.youngman.pojo.LeadTask;
import in.co.youngman.pojo.Leads;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by vikasmahato on 23/02/18.
 */

public interface LeadsAPI {
    String BASE_URL = "http://ec2-35-154-163-176.ap-south-1.compute.amazonaws.com/";

    @GET("/leads")
    Call<ListWrapper<Leads>> getLeads();

    @GET("/leads/{id}")
    Call<Leads> getLeadWithId(@Path("id") int id);

    @GET("leadsTask/{id}")
    Call<ListWrapper<LeadTask>> getLeadTasks(@Path("id") int id);

    @GET("leadsActivity/{id}")
    Call<ListWrapper<LeadActivity>> getLeadActivity(@Path("id") int id);

    @GET("leadsNote/{id}")
    Call<ListWrapper<LeadNote>> getLeadNotes(@Path("id") int id);

    @POST("leadsNote/")
    Call<LeadTask> createUser(@Body LeadTask task);

}