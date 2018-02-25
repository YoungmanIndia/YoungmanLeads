package in.co.youngman.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.co.youngman.pojo.LeadTask;

/**
 * Created by vikasmahato on 24/02/18.
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private List<LeadTask> data;
    private Context context;

    public TasksAdapter(List<LeadTask> data, Context context) {
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
    public TasksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item, parent, false);
        return new TasksAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TasksAdapter.ViewHolder holder, int position) {
        final LeadTask task = ((LeadTask) data.get(position));
        holder.text.setText(task.getTask());
        holder.itemView.setTag(task.getId());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
