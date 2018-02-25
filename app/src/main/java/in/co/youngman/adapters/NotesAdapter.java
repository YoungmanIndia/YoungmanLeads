package in.co.youngman.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.co.youngman.pojo.LeadNote;

/**
 * Created by vikasmahato on 24/02/18.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<LeadNote> data;
    private Context context;

    public NotesAdapter(List<LeadNote> data, Context context) {
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
    public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item, parent, false);
        return new NotesAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NotesAdapter.ViewHolder holder, int position) {
        final LeadNote note = ((LeadNote) data.get(position));
        holder.text.setText(note.getNoteValue());
        holder.itemView.setTag(note.getId());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

