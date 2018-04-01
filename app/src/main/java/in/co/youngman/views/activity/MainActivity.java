package in.co.youngman.views.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.co.youngman.R;
import in.co.youngman.views.fragment.DealsFragment;
import in.co.youngman.views.fragment.LeadsFragment;
import in.co.youngman.views.fragment.QuotationFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_FRAGMENT_LEADS = "tag_frag_leads";
    private static final String TAG_FRAGMENT_DEALS = "tag_frag_deals";
    private static final String TAG_FRAGMENT_QUOTATIONS = "tag_frag_quotations";

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView mTextMessage;
    private final List<Fragment> fragments = new ArrayList<>(3);

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(0, TAG_FRAGMENT_LEADS);
                    return true;
                case R.id.navigation_dashboard:
                    switchFragment(1, TAG_FRAGMENT_DEALS);
                    return true;
                case R.id.navigation_notifications:
                    switchFragment(2, TAG_FRAGMENT_QUOTATIONS);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);

        buildFragmentsList();
        switchFragment(0, TAG_FRAGMENT_LEADS);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, fragments.get(pos), tag)
                .commit();
    }


    private void buildFragmentsList() {
        LeadsFragment leadsFragment = new LeadsFragment();
        DealsFragment dealsFragment = new DealsFragment();
        QuotationFragment quotationFragment = new QuotationFragment();

        fragments.add(leadsFragment);
        fragments.add(dealsFragment);
        fragments.add(quotationFragment);
    }
}
