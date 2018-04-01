package in.co.youngman.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import in.co.youngman.views.activity.LeadsDetail;
import in.co.youngman.R;
import in.co.youngman.pojo.Leads;
import in.co.youngman.views.activity.NewCustomerActivity;
import in.co.youngman.views.activity.SearchCustomer;


/**
 * Created by vikasmahato on 23/02/18.
 */

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {
    private List<Leads> data;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView buttonViewOption;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            buttonViewOption = (ImageView) itemView.findViewById(R.id.textViewOptions);
        }
    }

    public DealsAdapter(List<Leads> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public DealsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final DealsAdapter.ViewHolder holder, int position) {
        final Leads answer = ((Leads) data.get(position));
        holder.textViewHead.setText(answer.company_name);
        holder.textViewDesc.setText(answer.stage);
        holder.itemView.setTag(answer.leadId);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, LeadsDetail.class);
                intent.putExtra(LeadsDetail.EXTRA_LEAD_ID, answer.leadId);
                intent.putExtra(LeadsDetail.EXTRA_LEAD_NAME, answer.company_name);
                context.startActivity(intent);
            }
        });

        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, holder.buttonViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                context.startActivity(new Intent(context, SearchCustomer.class));
                                break;
                            case R.id.menu2:
                                context.startActivity(new Intent(context, NewCustomerActivity.class));
                                break;
                            case R.id.menu3:
                                //handle menu3 click
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}