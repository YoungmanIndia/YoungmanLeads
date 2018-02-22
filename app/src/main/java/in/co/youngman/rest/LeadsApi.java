package in.co.youngman.rest;

import java.util.List;

import in.co.youngman.pojo.Leads;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vikasmahato on 23/02/18.
 */

public interface LeadsApi {
    @GET("leads/")
    Call<List<Leads>> loadChanges(@Query("q") String status);
}
