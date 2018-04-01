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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import in.co.youngman.views.activity.LeadsDetail;
import in.co.youngman.R;
import in.co.youngman.adapters.NotesAdapter;
import in.co.youngman.pojo.LeadNote;
import in.co.youngman.rest.LeadsAPI;
import in.co.youngman.rest.ListWrapper;
import in.co.youngman.views.fragment.dialogs.NewNoteDialog;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeadNotesFragment extends Fragment implements NewNoteDialog.AddNoteLListener {
    private static final String TAG = LeadTaskFragment.class.getSimpleName();

    private LeadsAPI leadsAPI;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private Integer leadId;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public LeadNotesFragment() {
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
        return inflater.inflate(R.layout.fragment_lead_notes, container, false);
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


                FragmentManager fm = getActivity().getSupportFragmentManager();
                NewNoteDialog dialog = new NewNoteDialog();
                dialog.setTargetFragment(thisFragment, 0);
                dialog.show(fm, "add_friend_dialog");

            }
        });
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        createLeadsAPI();
        leadsAPI.getLeadNotes(((LeadsDetail) getActivity()).getLeadId()).enqueue(leadsCallback);

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

    Callback<ListWrapper<LeadNote>> leadsCallback = new Callback<ListWrapper<LeadNote>>() {
        @Override
        public void onResponse(Call<ListWrapper<LeadNote>> call, Response<ListWrapper<LeadNote>> response) {
            if (response.isSuccessful()) {
                ListWrapper<LeadNote> notes = response.body();
                List<LeadNote> data = new ArrayList<>();
                data.addAll(notes.data);

                getLeadNotes(data);
            } else {
                Log.d("TasksCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<ListWrapper<LeadNote>> call, Throwable t) {
            t.printStackTrace();
        }
    };

    public void getLeadNotes(List<LeadNote> data) {
        recyclerView.setAdapter(new NotesAdapter(data, getContext()));
    }

    @Override
    public void onFinishTaskDialog(String note) {
        LeadNote leadNote = new LeadNote(leadId , note);
            leadsAPI.createLeadNote(leadId, leadNote).enqueue(new Callback<LeadNote>() {
                @Override
                public void onResponse(Call<LeadNote> call, Response<LeadNote> response) {

                }

                @Override
                public void onFailure(Call<LeadNote> call, Throwable t) {

                }

            });
    }
}
