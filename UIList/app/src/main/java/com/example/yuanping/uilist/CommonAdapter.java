package com.example.yuanping.uilist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @created by PingYuan at 8/2/18
 * @email: husteryp@gmail.com
 * @description:
 * Common Adapter
 */

public class CommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> titles;
    private List<Class> listeners;
    private Context mContext;

    public CommonAdapter(List<String> titles, List<Class> listeners, Context context) {
        this.titles = titles;
        this.listeners = listeners;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, parent, false);
        return new RvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((RvViewHolder)holder).tvItem.setText(titles.get(position));
        ((RvViewHolder)holder).tvItem.setClickable(true);
        ((RvViewHolder)holder).tvItem.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Application.sAppContext, listeners.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class RvViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItem;

        public RvViewHolder(View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item_main);
        }
    }
}
