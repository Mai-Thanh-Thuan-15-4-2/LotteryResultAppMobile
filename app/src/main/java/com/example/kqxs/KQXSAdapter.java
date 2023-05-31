package com.example.kqxs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KQXSAdapter extends RecyclerView.Adapter<KQXSAdapter.RssViewHolder> {

    private ArrayList<KQXSModel> rssItems;

    public KQXSAdapter(ArrayList<KQXSModel> rssItems) {
        this.rssItems = rssItems;
    }

    @NonNull
    @Override
    public RssViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kqxs, parent, false);
        return new RssViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RssViewHolder holder, int position) {
        KQXSModel rssItem = rssItems.get(position);
        String title = rssItem.getTitle() != null ? rssItem.getTitle() : "Không xác định";
        holder.textViewTitle.setText(title);
        holder.textViewDate.setText(rssItem.getDate());
        holder.textViewDB.setText(getDBString(rssItem.getDescription()));
        holder.textViewG1.setText(getG1String(rssItem.getDescription()));
        holder.textViewG2.setText(getG2String(rssItem.getDescription()));
        holder.textViewG3.setText(getG3String(rssItem.getDescription()));
        holder.textViewG4.setText(getG4String(rssItem.getDescription()));
        holder.textViewG5.setText(getG5String(rssItem.getDescription()));
        holder.textViewG6.setText(getG6String(rssItem.getDescription()));
        holder.textViewG7.setText(getG7String(rssItem.getDescription()));
        holder.textViewG8.setText(getG8String(rssItem.getDescription()));
    }

    private String getDBString(String description) {
        GetRadioResult parser = new GetRadioResult(description);
        return  parser.getSpecialPrize();
    }
    private String getG1String(String description) {
        GetRadioResult parser = new GetRadioResult(description);
        return  parser.getFirstPrize();
    }
    private String getG2String(String description) {
        GetRadioResult parser = new GetRadioResult(description);
        return  parser.getSecondPrize();
    }
    private String getG3String(String description) {
        GetRadioResult parser = new GetRadioResult(description);
        return parser.getThirdPrize();
    }
    private String getG4String(String description) {
        GetRadioResult parser = new GetRadioResult(description);
        return   parser.getFourthPrize();
    }
    private String getG5String(String description) {
        GetRadioResult parser = new GetRadioResult(description);
        return parser.getFifthPrize();
    }
    private String getG6String(String description) {
        GetRadioResult parser = new GetRadioResult(description);
        return  parser.getSixthPrize();
    }
    private String getG7String(String description) {
        GetRadioResult parser = new GetRadioResult(description);
        return  parser.getSeventhPrize();
    }
    private String getG8String(String description) {
        GetRadioResult parser = new GetRadioResult(description);
        return  parser.getEighthPrize();
    }

    @Override
    public int getItemCount() {
        return rssItems.size();
    }

    static class RssViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDate;
        TextView textViewDB;
        TextView textViewG1;
        TextView textViewG2;
        TextView textViewG3;
        TextView textViewG4;
        TextView textViewG5;
        TextView textViewG6;
        TextView textViewG7;
        TextView textViewG8;
        RssViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewDB = itemView.findViewById(R.id.textViewGDB);
            textViewG1 = itemView.findViewById(R.id.textViewG1);
            textViewG2 = itemView.findViewById(R.id.textViewG2);
            textViewG3 = itemView.findViewById(R.id.textViewG3);
            textViewG4 = itemView.findViewById(R.id.textViewG4);
            textViewG5 = itemView.findViewById(R.id.textViewG5);
            textViewG6 = itemView.findViewById(R.id.textViewG6);
            textViewG7 = itemView.findViewById(R.id.textViewG7);
            textViewG8 = itemView.findViewById(R.id.textViewG8);
        }
    }
}

