package in.co.youngman.rest;

import in.co.youngman.pojo.AccessToken;
import in.co.youngman.pojo.ClientCreds;
import in.co.youngman.pojo.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by vikasmahato on 23/02/18.
 */

public interface UserClient {

    @POST("oauth/token")
    Call<AccessToken> getToken(@Body ClientCreds clientCreds);
}
