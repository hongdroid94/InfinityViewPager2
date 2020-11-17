package com.innodep.infinityviewpager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.innodep.infinityviewpager.R;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    private Context mContext;
    private List<String> list;

    public ViewPagerAdapter(Context mContext, List<String> list) {
        this.mContext   = mContext;
        this.list       = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_setup, parent, false);
        return new ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int index = position % list.size();
        String item = list.get(index);
        holder.tv_name.setText(String.format("%s", item));

        if(position % 2 == 0) {
            holder.root_view.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.root_view.setBackgroundColor(Color.GREEN);
        }

    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView tv_name;
        protected ConstraintLayout root_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            root_view = itemView.findViewById(R.id.root_view);
            tv_name   = itemView.findViewById(R.id.tv_name);
        }
    }

}
