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

/**
 * Created by iTomer on 14/02/2016.
 * Licence GPLv3
 * Copyright (C) 2016  iTomer
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DemoViewHolder> {
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
        holder.textView.setText(item.title);
        holder.imageView.setImageResource(item.imageResId);
        holder.itemView.setOnClickListener(holder.listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = DemoViewHolder.this.getAdapterPosition();
                imageView.setVisibility(View.INVISIBLE);
            }
        };


        private final ImageView imageView;
        private final TextView textView;

        public DemoViewHolder(View itemView) {
            super(itemView);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = DemoViewHolder.this.getAdapterPosition();
//                    imageView.setVisibility(View.INVISIBLE);
//                    Toast.makeText(context, "Hello" + position, Toast.LENGTH_SHORT).show();
//                }
//            });
            this.imageView = (ImageView) itemView.findViewById(R.id.itemImage);
            this.textView = (TextView) itemView.findViewById(R.id.tvContent);
        }
    }
}
