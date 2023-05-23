package com.example.kqxs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class KQXSTT4Adapter extends RecyclerView.Adapter<KQXSTT4Adapter.RssViewHolder> {

    private ArrayList<KQXSModel> rssItems;

    public KQXSTT4Adapter(ArrayList<KQXSModel> rssItems) {
        this.rssItems = rssItems;
    }

    @NonNull
    @Override
    public RssViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kqxstt4, parent, false);
        return new RssViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RssViewHolder holder, int position) {
        KQXSModel kqxsModel = rssItems.get(position);
        holder.textViewTitle.setText(kqxsModel.getTitle());
        holder.textViewDate.setText(kqxsModel.getDate());
        holder.textViewSet1.setText(getSet1String(kqxsModel.getDescription()));
    }

    private String getSet1String(String description) {
        GetKQXSTT4 parser = new GetKQXSTT4(description);
        String set1 = String.valueOf(parser.getSet1Prize());
        return  set1;
    }

    @Override
    public int getItemCount() {
        return rssItems.size();
    }

    static class RssViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDate;
        TextView textViewSet1;

        RssViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewSet1 = itemView.findViewById(R.id.textViewSet1);
        }
    }
}



