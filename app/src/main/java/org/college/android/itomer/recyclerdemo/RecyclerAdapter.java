package org.college.android.itomer.recyclerdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DemoViewHolder> implements ItemClickSupport.OnItemClickListener {
    private final List<Note> data;
    private final Context context;
    private final LayoutInflater inflater;

    public RecyclerAdapter(ArrayList<Note> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.rv_demo_item, parent, false);
        return new DemoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DemoViewHolder holder, int position) {
        Note item = data.get(position);
        holder.textView.setText(item.getTitle());
        holder.imageView.setImageResource(item.getImageResId());
        holder.imageView.setVisibility(item.getImageState() == Note.ImageState.NONE ?
                View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onItemClicked(RecyclerView recyclerView, int position, RecyclerView.ViewHolder holder) {
        Note note = data.get(position);
        note.setImageState(note.getImageState() == Note.ImageState.NONE ? Note.ImageState.DROID : Note.ImageState.NONE);
        notifyItemChanged(position);
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;

        public DemoViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.itemImage);
            this.textView = (TextView) itemView.findViewById(R.id.tvContent);
        }
    }
}
