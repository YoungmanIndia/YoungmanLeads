package in.co.youngman.views.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.co.youngman.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeadTaskFragment extends Fragment {


    public LeadTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lead_task, container, false);
    }

}
