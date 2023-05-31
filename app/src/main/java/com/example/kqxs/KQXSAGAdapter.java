package com.example.kqxs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class KQXSAGAdapter extends RecyclerView.Adapter<KQXSAGAdapter.RssViewHolder> {

    private ArrayList<KQXSModel> rssItems;




    public KQXSAGAdapter(ArrayList<KQXSModel> rssItems) {
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
        KQXSModel kqxsModel = rssItems.get(position);
        holder.textViewTitle.setText(kqxsModel.getTitle());
        holder.textViewDate.setText(kqxsModel.getDate());
        holder.textViewDB.setText(getDBString(kqxsModel.getDescription(), new DatabaseSX(holder.itemView.getContext())));
        holder.textViewG1.setText(getG1String(kqxsModel.getDescription()));
        holder.textViewG2.setText(getG2String(kqxsModel.getDescription()));
        holder.textViewG3.setText(getG3_1String(kqxsModel.getDescription()) + " - " + getG3_2String(kqxsModel.getDescription()));
        holder.textViewG4.setText(getG4_1String(kqxsModel.getDescription()) + " - " + getG4_2String(kqxsModel.getDescription()) + " - " + getG4_3String(kqxsModel.getDescription())+ " - " + getG4_4String(kqxsModel.getDescription())+ " - " + getG4_5String(kqxsModel.getDescription())+ "  " + getG4_6String(kqxsModel.getDescription())+ " - " + getG4_6String(kqxsModel.getDescription()));
        holder.textViewG5.setText(getG5String(kqxsModel.getDescription()));
        holder.textViewG6.setText(getG6_1String(kqxsModel.getDescription())+ " - " + getG6_2String(kqxsModel.getDescription()) + " - " + getG6_3String(kqxsModel.getDescription()));
        holder.textViewG7.setText(getG7String(kqxsModel.getDescription()));
        holder.textViewG8.setText(getG8String(kqxsModel.getDescription()));

    }
    private String getDBString(String description, DatabaseSX databaseSX) {
        GetKQXS parser = new GetKQXS(description);
        String DB = String.valueOf(parser.getSpecialPrize());
       databaseSX.insertData(DB);
        return  DB;
    }
    public static String getG1String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String G1 = String.valueOf(parser.getFirstPrize());
        return  G1;
    }
    private String getG2String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String G2 = String.valueOf(parser.getSecondPrize());
        return  G2;
    }
    private String getG3_1String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g3 = parser.getThirdPrize();
        return  g3[0];
    }
    private String getG3_2String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g3 = parser.getThirdPrize();
        return g3[1];
    }
    private String getG4_1String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g4 = parser.getFourthPrize();
        return  g4[0];
    }
    private String getG4_2String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g4 = parser.getFourthPrize();
        return  g4[1];
    }
    private String getG4_3String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g4 = parser.getFourthPrize();
        return  g4[2];
    }
    private String getG4_4String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g4 = parser.getFourthPrize();
        return g4[3];
    }
    private String getG4_5String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g4 = parser.getFourthPrize();
        return  g4[4];
    }
    private String getG4_6String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g4 = parser.getFourthPrize();
        return g4[5];
    }
    private String getG4_7String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g4 = parser.getFourthPrize();
        return g4[6];
    }
    private String getG5String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String g5 = parser.getFifthPrize();
        return  g5;
    }
    private String getG6_1String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g6 = parser.getSixthPrize();
        return  g6[0];
    }
    private String getG6_2String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g6 = parser.getSixthPrize();
        return  g6[1];
    }
    private String getG6_3String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String[] g6 = parser.getSixthPrize();
        return g6[2];
    }
    private String getG7String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String g7 = parser.getSeventhPrize();
        return  g7;
    }
    private String getG8String(String description) {
        GetKQXS parser = new GetKQXS(description);
        String g8 = parser.getEightthPrize();
        return  g8;
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


