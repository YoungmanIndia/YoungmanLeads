package in.co.youngman.rest;

import in.co.youngman.BuildConfig;
import in.co.youngman.UnsafeOkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit getRetrofitClient() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.YOUNGMANBETA_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
                .build();
    }
}
