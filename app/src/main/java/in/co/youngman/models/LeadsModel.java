package in.co.youngman.models;

import in.co.youngman.interfaces.LeadsInterfaceMVP;
import in.co.youngman.presenters.LeadsPresenter;


/**
 * Created by vikasmahato on 22/02/18.
 */

public class LeadsModel implements LeadsInterfaceMVP.Model {

    private static String TAG = "LeadsModel";

    static final String BASE_URL = "http://ec2-35-154-163-176.ap-south-1.compute.amazonaws.com/";

    public LeadsModel(LeadsPresenter leadsPresenter) {
    }

    @Override
    public void requestLeads() {

    }

}
