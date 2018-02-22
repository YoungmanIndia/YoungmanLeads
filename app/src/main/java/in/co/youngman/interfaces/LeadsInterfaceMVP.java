package in.co.youngman.interfaces;

import java.util.List;

import in.co.youngman.pojo.LeadsResponse;

/**
 * Created by vikasmahato on 22/02/18.
 */

public interface LeadsInterfaceMVP {

    interface View {
        void onError();
        void onSuccess();
        void showProgressBar();
        void hideProgressBar();
        void getLeads();
        void addLead();
    }

    interface Presenter {
        void request();
        void onDestroy();
        void getChildren(List<LeadsResponse> leadsResponses);
    }

    interface Model {
        void requestLeads();
    }
}
