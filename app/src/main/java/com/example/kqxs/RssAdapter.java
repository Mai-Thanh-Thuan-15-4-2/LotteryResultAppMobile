package com.example.kqxs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RssAdapter extends RecyclerView.Adapter<RssAdapter.RssViewHolder> {

    private ArrayList<RssItem> rssItems;

    public RssAdapter(ArrayList<RssItem> rssItems) {
        this.rssItems = rssItems;
    }

    @NonNull
    @Override
    public RssViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rss, parent, false);
        return new RssViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RssViewHolder holder, int position) {
        RssItem rssItem = rssItems.get(position);
        holder.textViewTitle.setText(rssItem.getTitle());
        holder.textViewDate.setText(rssItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return rssItems.size();
    }

    static class RssViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDate;

        RssViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
        }
    }
}

