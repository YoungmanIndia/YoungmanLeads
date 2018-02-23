package in.co.youngman.views.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import in.co.youngman.R;
import in.co.youngman.adapters.LeadsAdapter;
import in.co.youngman.interfaces.LeadsInterfaceMVP;
import in.co.youngman.pojo.Leads;
import in.co.youngman.presenters.LeadsPresenter;
import in.co.youngman.rest.ListWrapper;
import in.co.youngman.rest.LeadsAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeadsFragment extends Fragment implements LeadsInterfaceMVP.View, View.OnClickListener{
    private static final String TAG = LeadsFragment.class.getSimpleName();

    private final static String API_KEY = "";
    private LeadsPresenter presenter;
    private String token;

    private Button authenticateButton;

    private RecyclerView recyclerView;
    private LeadsAPI leadsAPI;


    public LeadsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leads, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createUI(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        fillUI();
    }

    private void fillUI() {



    }

    @Override
    public void onResume() {
        super.onResume();
        if (token != null) {
            authenticateButton.setEnabled(false);
        }
    }

    private void createUI(View view) {

        authenticateButton = (Button) view.findViewById(R.id.authenticate_button);



        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        createStackoverflowAPI();
        leadsAPI.getLeads().enqueue(leadsCallback);

       // recycler.setItemAnimator(new DefaultItemAnimator());

       // mProgressbar = view.findViewById(R.id.newspaginateprogbar);

        //presenter = new LeadsPresenter(this);
        //presenter.request();


    }

    private void createStackoverflowAPI() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LeadsAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        leadsAPI = retrofit.create(LeadsAPI.class);
    }


    Callback<ListWrapper<Leads>> leadsCallback = new Callback<ListWrapper<Leads>>() {
        @Override
        public void onResponse(Call<ListWrapper<Leads>> call, Response<ListWrapper<Leads>> response) {
            if (response.isSuccessful()) {
                ListWrapper<Leads> questions = response.body();
                List<Leads> data = new ArrayList<>();
                data.addAll(questions.data);

               getLeads(data);
            } else {
                Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<ListWrapper<Leads>> call, Throwable t) {
            t.printStackTrace();
        }
    };



    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void getLeads(List<Leads> data) {
        recyclerView.setAdapter(new LeadsAdapter(data, getContext()));
    }

    @Override
    public void addLead() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case android.R.id.text1:
                if (token != null) {
                    // TODO
                } else {
                    Toast.makeText(getContext(), "You need to authenticate first", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.authenticate_button:
                // TODO
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1) {
            token = data.getStringExtra("token");
        }
    }
}
