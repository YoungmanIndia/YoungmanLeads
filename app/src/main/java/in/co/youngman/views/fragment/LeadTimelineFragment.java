package in.co.youngman.views.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import in.co.youngman.views.activity.LeadsDetail;
import in.co.youngman.R;
import in.co.youngman.adapters.ActivityAdapter;
import in.co.youngman.pojo.LeadActivity;
import in.co.youngman.rest.LeadsAPI;
import in.co.youngman.rest.ListWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeadTimelineFragment extends Fragment {
    private static final String TAG = LeadTaskFragment.class.getSimpleName();

    private LeadsAPI leadsAPI;
    private RecyclerView recyclerView;
    private Integer leadId;

    public LeadTimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        leadId = Integer.parseInt(getArguments().getString("leadKey"));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lead_timeline, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createUI(view);
    }

    private void createUI(View view) {

        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        createLeadsAPI();
        leadsAPI.getLeadActivity(((LeadsDetail) getActivity()).getLeadId()).enqueue(leadsCallback);

    }

    private void createLeadsAPI() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LeadsAPI.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        leadsAPI = retrofit.create(LeadsAPI.class);
    }

    Callback<ListWrapper<LeadActivity>> leadsCallback = new Callback<ListWrapper<LeadActivity>>() {
        @Override
        public void onResponse(Call<ListWrapper<LeadActivity>> call, Response<ListWrapper<LeadActivity>> response) {
            if (response.isSuccessful()) {
                ListWrapper<LeadActivity> activity = response.body();
                List<LeadActivity> data = new ArrayList<>();
                data.addAll(activity .data);

                getLeadActivity(data);
            } else {
                Log.d("TasksCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<ListWrapper<LeadActivity>> call, Throwable t) {
            t.printStackTrace();
        }
    };

    public void getLeadActivity(List<LeadActivity> data) {
      //  for(int i = 0; i<data.size(); i++){
      //      Log.e("data", data.get(i).getActivity());
      //  }
        ActivityAdapter activityAdapter = new ActivityAdapter(data, getContext());
        recyclerView.setAdapter(activityAdapter);
    }

}

