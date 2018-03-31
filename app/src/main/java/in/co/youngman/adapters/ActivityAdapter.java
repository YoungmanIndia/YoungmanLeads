package in.co.youngman.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import in.co.youngman.pojo.LeadActivity;

/**
 * Created by vikasmahato on 24/02/18.
 */

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {

    private List<LeadActivity> data;
    private Context context;

    public ActivityAdapter(List<LeadActivity> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(android.R.id.text1);
        }
    }

    @Override
    public ActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item, parent, false);
        return new ActivityAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ActivityAdapter.ViewHolder holder, int position) {
        final LeadActivity note = ((LeadActivity) data.get(position));
        Toast.makeText(context, "called", Toast.LENGTH_SHORT).show();
        Toast.makeText(context, note.getActivity(), Toast.LENGTH_SHORT).show();
        holder.text.setText(note.getActivity());
        holder.itemView.setTag(note.getId());

    }

    @Override
    public int getItemCount() {
        //Toast.makeText(context, String.valueOf(data.size()), Toast.LENGTH_SHORT).show();
        return data.size();
    }
}
