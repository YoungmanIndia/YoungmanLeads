package in.co.youngman.models;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import in.co.youngman.interfaces.LeadsInterfaceMVP;
import in.co.youngman.pojo.Leads;
import in.co.youngman.presenters.LeadsPresenter;
import in.co.youngman.rest.LeadsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by vikasmahato on 22/02/18.
 */

public class LeadsModel implements LeadsInterfaceMVP.Model,Callback<List<Leads>> {

    private static String TAG = "LeadsModel";

    static final String BASE_URL = "http://ec2-35-154-163-176.ap-south-1.compute.amazonaws.com/";

    public LeadsModel(LeadsPresenter leadsPresenter) {
    }

    @Override
    public void requestLeads() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        LeadsApi gerritAPI = retrofit.create(LeadsApi.class);

        Call<List<Leads>> call = gerritAPI.loadChanges("status:open");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Leads>> call, Response<List<Leads>> response) {
        if(response.isSuccessful()) {
            List<Leads> leadsListList = response.body();
            for (Leads lead:leadsListList
                 ) {
                Log.e(TAG, lead.getCompanyName());
            }
        } else {
            Log.e(TAG, response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<List<Leads>> call, Throwable t) {
        t.printStackTrace();
    }
}
