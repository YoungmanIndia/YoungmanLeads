package in.co.youngman.views.fragment;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import in.co.youngman.LeadsDetail;
import in.co.youngman.R;
import in.co.youngman.adapters.TasksAdapter;
import in.co.youngman.pojo.LeadTask;
import in.co.youngman.rest.LeadsAPI;
import in.co.youngman.rest.ListWrapper;
import in.co.youngman.views.fragment.dialogs.FullscreenDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeadTaskFragment extends Fragment implements FullscreenDialog.AddTaskLListener {
    private static final String TAG = LeadTaskFragment.class.getSimpleName();

    private LeadsAPI leadsAPI;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    public LeadTaskFragment() {
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
        return inflater.inflate(R.layout.fragment_lead_task, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createUI(view);
    }

    private void createUI(View view) {
        fab = view.findViewById(R.id.fab);

        final Fragment thisFragment = this;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // FullscreenDialog dialog = new FullscreenDialog();
               // FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
               // dialog.show(ft, FullscreenDialog.TAG);

                FragmentManager fm = getActivity().getSupportFragmentManager();
                FullscreenDialog dialog = new FullscreenDialog();
                dialog.setTargetFragment(thisFragment, 0);
                dialog.show(fm, "add_friend_dialog");

            }
        });
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        createLeadsAPI();
        leadsAPI.getLeadTasks(((LeadsDetail) getActivity()).getLeadId()).enqueue(leadsCallback);

    }

    private void createLeadsAPI() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LeadsAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        leadsAPI = retrofit.create(LeadsAPI.class);
    }

    Callback<ListWrapper<LeadTask>> leadsCallback = new Callback<ListWrapper<LeadTask>>() {
        @Override
        public void onResponse(Call<ListWrapper<LeadTask>> call, Response<ListWrapper<LeadTask>> response) {
            if (response.isSuccessful()) {
                ListWrapper<LeadTask> tasks = response.body();
                List<LeadTask> data = new ArrayList<>();
                data.addAll(tasks.data);

                getLeadTask(data);
            } else {
                Log.d("TasksCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<ListWrapper<LeadTask>> call, Throwable t) {
            t.printStackTrace();
        }
    };

    public void getLeadTask(List<LeadTask> data) {
        recyclerView.setAdapter(new TasksAdapter(data, getContext()));
    }

    @Override
    public void onFinishTaskDialog(LeadTask leadTask) {
        Toast.makeText(getContext(), "Hello, " + leadTask.getTask() + leadTask.getRemindAt(), Toast.LENGTH_SHORT).show();
    }
}
