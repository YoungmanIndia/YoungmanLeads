package in.co.youngman.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.co.youngman.LeadsDetail;
import in.co.youngman.pojo.Leads;


/**
 * Created by vikasmahato on 23/02/18.
 */

public class LeadsAdapter extends RecyclerView.Adapter<LeadsAdapter.ViewHolder> {
    private List<Leads> data;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(android.R.id.text1);
        }
    }

    public LeadsAdapter(List<Leads> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public LeadsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LeadsAdapter.ViewHolder holder, int position) {
        final Leads answer = ((Leads) data.get(position));
        holder.text.setText(answer.company_name);
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
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}