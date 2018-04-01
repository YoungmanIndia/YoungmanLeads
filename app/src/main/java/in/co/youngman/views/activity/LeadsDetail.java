package in.co.youngman.views.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import in.co.youngman.R;
import in.co.youngman.pojo.Leads;
import in.co.youngman.rest.LeadsAPI;
import in.co.youngman.views.fragment.LeadNotesFragment;
import in.co.youngman.views.fragment.LeadTaskFragment;
import in.co.youngman.views.fragment.LeadTimelineFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeadsDetail extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_LEAD_ID = "hello";
    public static final String EXTRA_LEAD_NAME = "";

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private String leadKey;
    private String leadName;

    public static final String BASE_URL = "http://ec2-35-154-163-176.ap-south-1.compute.amazonaws.com/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leads_detail);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        leadKey = getIntent().getStringExtra(EXTRA_LEAD_ID);
        leadName = getIntent().getStringExtra(EXTRA_LEAD_NAME);

        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(leadName);
        }

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("New");
        categories.add("Hone wala h");
        categories.add("Bas ho gya samjho");
        categories.add("Deal pakki");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter <String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        LeadsAPI apiService = retrofit.create(LeadsAPI.class);;
        Call<Leads> call = apiService.getLeadWithId(Integer.parseInt(leadKey));
        call.enqueue(new Callback<Leads>() {
            @Override
            public void onResponse(Call<Leads> call, Response<Leads> response) {

                if(response.code() == 200){
                    Log.e("LEAD", new GsonBuilder().setPrettyPrinting().create().toJson(response));
                    //Toast.makeText(LeadsDetail.this, response.body().company_name, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LeadsDetail.this, "Some error occurred", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Leads> call, Throwable t) {
                Toast.makeText(LeadsDetail.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void setupViewPager(ViewPager viewPager) {
        Bundle bundle = new Bundle();
        bundle.putString("leadKey", leadKey);

        LeadNotesFragment leadNotesFragment = new LeadNotesFragment();
        leadNotesFragment.setArguments(bundle);

        LeadTaskFragment leadTaskFragment = new LeadTaskFragment();
        leadTaskFragment.setArguments(bundle);

        LeadTimelineFragment leadTimelineFragment = new LeadTimelineFragment();
        leadTimelineFragment.setArguments(bundle);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(leadTaskFragment, "Task");
        adapter.addFragment(leadNotesFragment, "Notes");
        adapter.addFragment(leadTimelineFragment, "Timeline");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void setLead(Leads lead){
       // Log.e("Lead", lead.leadId);
    }

    public int getLeadId(){
        return Integer.parseInt(leadKey);
    }
}
