package com.example.kqxs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KQXSMBAdapter extends RecyclerView.Adapter<KQXSMBAdapter.RssViewHolder> {

    private ArrayList<KQSXMB> rssItems;

    public KQXSMBAdapter(ArrayList<KQSXMB> rssItems) {
        this.rssItems = rssItems;
    }

    @NonNull
    @Override
    public RssViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kqxsmb, parent, false);
        return new RssViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RssViewHolder holder, int position) {
        KQSXMB rssItem = rssItems.get(position);
        holder.textViewTitle.setText(rssItem.getTitle());
        holder.textViewDate.setText(rssItem.getDate());
        holder.textViewDB.setText(getDBString(rssItem.getDescription()));
        holder.textViewG1.setText(getG1String(rssItem.getDescription()));
        holder.textViewG2.setText(getG2String(rssItem.getDescription()));
        holder.textViewG3.setText(getG3String(rssItem.getDescription()));
        holder.textViewG4.setText(getG4String(rssItem.getDescription()));
        holder.textViewG5.setText(getG5String(rssItem.getDescription()));
        holder.textViewG6.setText(getG6String(rssItem.getDescription()));
        holder.textViewG7.setText(getG7String(rssItem.getDescription()));
    }

    private String getDBString(String description) {
        GetKQXSMB parser = new GetKQXSMB(description);
        String DB = String.valueOf(parser.getSpecialPrize());
        return  DB;
    }
    private String getG1String(String description) {
        GetKQXSMB parser = new GetKQXSMB(description);
        String G1 = String.valueOf(parser.getFirstPrize());
        return  G1;
    }
    private String getG2String(String description) {
        GetKQXSMB parser = new GetKQXSMB(description);
        int[] g2 = parser.getSecondPrize();
        return  g2[0] + " - " + g2[1];
    }
    private String getG3String(String description) {
        GetKQXSMB parser = new GetKQXSMB(description);
        int[] g3 = parser.getThirdPrize();
        return  g3[0] + " - " + g3[1] + " - " + g3[2] + " - " + g3[3] + " - " + g3[4] + " " + g3[5];
    }
    private String getG4String(String description) {
        GetKQXSMB parser = new GetKQXSMB(description);
        int[] g4 = parser.getFourthPrize();
        return  g4[0] + " - " + g4[1] + " - " + g4[2] + " - " + g4[3];
    }
    private String getG5String(String description) {
        GetKQXSMB parser = new GetKQXSMB(description);
        int[] g5 = parser.getFifthPrize();
        return  g5[0] + " - " + g5[1] + " - " + g5[2] + " - " + g5[3] + " - " + g5[4] + " - " + g5[5];
    }
    private String getG6String(String description) {
        GetKQXSMB parser = new GetKQXSMB(description);
        int[] g6 = parser.getSixthPrize();
        return  g6[0] + " - " + g6[1] + " - " + g6[2];
    }
    private String getG7String(String description) {
        GetKQXSMB parser = new GetKQXSMB(description);
        int[] g7 = parser.getSeventhPrize();
        return  g7[0] + " - " + g7[1] + " - " + g7[2] + " - " + g7[3];
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

        RssViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewDB = itemView.findViewById(R.id.textViewDB);
            textViewG1 = itemView.findViewById(R.id.textViewG1);
            textViewG2 = itemView.findViewById(R.id.textViewG2);
            textViewG3 = itemView.findViewById(R.id.textViewG3);
            textViewG4 = itemView.findViewById(R.id.textViewG4);
            textViewG5 = itemView.findViewById(R.id.textViewG5);
            textViewG6 = itemView.findViewById(R.id.textViewG6);
            textViewG7 = itemView.findViewById(R.id.textViewG7);
        }
    }
}

