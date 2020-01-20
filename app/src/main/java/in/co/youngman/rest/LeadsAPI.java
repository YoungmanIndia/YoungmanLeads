package in.co.youngman.rest;

import in.co.youngman.BuildConfig;
import in.co.youngman.pojo.LeadActivity;
import in.co.youngman.pojo.LeadNote;
import in.co.youngman.pojo.LeadTask;
import in.co.youngman.pojo.Leads;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by vikasmahato on 23/02/18.
 */

public interface LeadsAPI {
    String BASE_URL = BuildConfig.YOUNGMANBETA_SERVER_URL;

    @GET("/leads")
    Call<ListWrapper<Leads>> getLeads();

    @GET("/deals")
    Call<ListWrapper<Leads>> getDeals();

    @GET("/leads/{id}")
    Call<Leads> getLeadWithId(@Path("id") int id);

    @GET("leadsTask/{id}")
    Call<ListWrapper<LeadTask>> getLeadTasks(@Path("id") int id);

    @GET("leadsActivity/{id}")
    Call<ListWrapper<LeadActivity>> getLeadActivity(@Path("id") int id);

    @GET("leadsNote/{id}")
    Call<ListWrapper<LeadNote>> getLeadNotes(@Path("id") int id);

    @PUT("/leads/{id}")
    Call<LeadNote> createLeadNote(@Path("id") int id, @Body LeadNote note);

    @PUT("/leads/{id}")
    Call<LeadTask> createLeadTask(@Path("id") int id, @Body LeadTask task);

}