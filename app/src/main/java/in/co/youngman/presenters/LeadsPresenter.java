package in.co.youngman.presenters;

import java.util.List;

import in.co.youngman.interfaces.LeadsInterfaceMVP;
import in.co.youngman.models.LeadsModel;
import in.co.youngman.pojo.LeadsResponse;
import in.co.youngman.views.fragment.LeadsFragment;

/**
 * Created by vikasmahato on 22/02/18.
 */

public class LeadsPresenter implements LeadsInterfaceMVP.Presenter {

    private LeadsInterfaceMVP.View leadsView;
    private final LeadsInterfaceMVP.Model leadsModel;


    public LeadsPresenter(LeadsFragment leadsFragment) {
        this.leadsView = leadsFragment;
        this.leadsModel = new LeadsModel(this);
    }


    @Override
    public void request() {
        leadsModel.requestLeads();
    }

    @Override
    public void onDestroy() {
        leadsView = null;
    }

    @Override
    public void getChildren(List<LeadsResponse> leadsResponses) {

    }
}
