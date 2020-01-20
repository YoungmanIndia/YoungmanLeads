package in.co.youngman.rest;

import in.co.youngman.pojo.AccessToken;
import in.co.youngman.pojo.ClientCreds;
import in.co.youngman.pojo.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by vikasmahato on 23/02/18.
 */

public interface UserClient {


    /*Call<AccessToken> getToken(@Body ClientCreds clientCreds);*/
    //@FormUrlEncoded
    @Headers({"Accept: application/json"})
    @POST("apilogin")
    Call<AccessToken> getToken(@Body ClientCreds clientCreds);
}
