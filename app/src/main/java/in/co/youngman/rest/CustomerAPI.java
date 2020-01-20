package in.co.youngman.rest;

import in.co.youngman.BuildConfig;
import in.co.youngman.pojo.Customer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by vikasmahato on 01/04/18.
 */

public interface CustomerAPI {
    String BASE_URL = BuildConfig.YOUNGMANBETA_SERVER_URL;

    @GET("/customers_api")
    Call<ListWrapper<Customer>> getCustomers();

    @POST("/customers_api")
    Call<Customer> createCustomer(@Body Customer customer);
}
