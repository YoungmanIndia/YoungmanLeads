package in.co.youngman.interfaces;

import java.util.List;

import in.co.youngman.pojo.Leads;

/**
 * Created by vikasmahato on 22/02/18.
 */

public interface LeadsInterfaceMVP {

    interface View {
        void onError();
        void onSuccess();
        void showProgressBar();
        void hideProgressBar();
        void getLeads(List<Leads> data);
        void addLead();
    }

    interface Presenter {
        void request();
        void onDestroy();
    }

    interface Model {
        void requestLeads();
    }
}
