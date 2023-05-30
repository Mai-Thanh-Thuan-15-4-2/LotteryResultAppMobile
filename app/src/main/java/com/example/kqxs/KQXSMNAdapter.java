package com.example.kqxs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KQXSMNAdapter extends RecyclerView.Adapter<KQXSMNAdapter.RssViewHolder> {

    private ArrayList<KQXSModel> rssItems;

    public KQXSMNAdapter(ArrayList<KQXSModel> rssItems) {
        this.rssItems = rssItems;
    }

    @NonNull
    @Override
    public RssViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_xsmn, parent, false);
        return new RssViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RssViewHolder holder, int position) {
        KQXSModel kqxsModel = rssItems.get(position);
        holder.textViewTitle.setText(kqxsModel.getTitle());
        holder.textViewDate.setText(kqxsModel.getDate());

        XSMNService xsmnService = new XSMNService(kqxsModel.getDescription());
        xsmnService.prepareData();

        holder.textViewNameTinh1.setText(xsmnService.getNameTinh1());
        holder.textViewNameTinh2.setText(xsmnService.getNameTinh2());

        holder.textViewNameTinh3.setText(xsmnService.getNameTinh3());

        if(xsmnService.getNameTinh3().equals("")){
            holder.textViewNameTinh3.setVisibility(View.GONE);
            holder.textViewDBTinh3.setVisibility(View.GONE);
            holder.textViewG1Tinh3.setVisibility(View.GONE);
            holder.textViewG2Tinh3.setVisibility(View.GONE);
            holder.textViewG3Tinh3.setVisibility(View.GONE);
            holder.textViewG4Tinh3.setVisibility(View.GONE);
            holder.textViewG5Tinh3.setVisibility(View.GONE);
            holder.textViewG6Tinh3.setVisibility(View.GONE);
            holder.textViewG7Tinh3.setVisibility(View.GONE);
            holder.textViewG8Tinh3.setVisibility(View.GONE);
        }

        holder.textViewDBTinh1.setText(xsmnService.getSpecialPrizeTinh1());
        holder.textViewG1Tinh1.setText(xsmnService.getFirstPrizeTinh1());
        holder.textViewG2Tinh1.setText(xsmnService.getSecondPrizeTinh1());
        holder.textViewG3Tinh1.setText(xsmnService.getThirdPrizeTinh1());
        holder.textViewG4Tinh1.setText(xsmnService.getFourthPrizeTinh1());
        holder.textViewG5Tinh1.setText(xsmnService.getFifthPrizeTinh1());
        holder.textViewG6Tinh1.setText(xsmnService.getSixthPrizeTinh1());
        holder.textViewG7Tinh1.setText(xsmnService.getSeventhPrizeTinh1());
        holder.textViewG8Tinh1.setText(xsmnService.getEighthPrizeTinh1());

        holder.textViewDBTinh2.setText(xsmnService.getSpecialPrizeTinh2());
        holder.textViewG1Tinh2.setText(xsmnService.getFirstPrizeTinh2());
        holder.textViewG2Tinh2.setText(xsmnService.getSecondPrizeTinh2());
        holder.textViewG3Tinh2.setText(xsmnService.getThirdPrizeTinh2());
        holder.textViewG4Tinh2.setText(xsmnService.getFourthPrizeTinh2());
        holder.textViewG5Tinh2.setText(xsmnService.getFifthPrizeTinh2());
        holder.textViewG6Tinh2.setText(xsmnService.getSixthPrizeTinh2());
        holder.textViewG7Tinh2.setText(xsmnService.getSeventhPrizeTinh2());
        holder.textViewG8Tinh2.setText(xsmnService.getEighthPrizeTinh2());

        holder.textViewDBTinh3.setText(xsmnService.getSpecialPrizeTinh3());
        holder.textViewG1Tinh3.setText(xsmnService.getFirstPrizeTinh3());
        holder.textViewG2Tinh3.setText(xsmnService.getSecondPrizeTinh3());
        holder.textViewG3Tinh3.setText(xsmnService.getThirdPrizeTinh3());
        holder.textViewG4Tinh3.setText(xsmnService.getFourthPrizeTinh3());
        holder.textViewG5Tinh3.setText(xsmnService.getFifthPrizeTinh3());
        holder.textViewG6Tinh3.setText(xsmnService.getSixthPrizeTinh3());
        holder.textViewG7Tinh3.setText(xsmnService.getSeventhPrizeTinh3());
        holder.textViewG8Tinh3.setText(xsmnService.getEighthPrizeTinh3());
    }


    @Override
    public int getItemCount() {
        return rssItems.size();
    }

    static class RssViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDate;
        TextView textViewNameTinh1;
        TextView textViewNameTinh2;
        TextView textViewNameTinh3;
        TextView textViewDBTinh1;
        TextView textViewG1Tinh1;
        TextView textViewG2Tinh1;
        TextView textViewG3Tinh1;
        TextView textViewG4Tinh1;
        TextView textViewG5Tinh1;
        TextView textViewG6Tinh1;
        TextView textViewG7Tinh1;
        TextView textViewG8Tinh1;

        TextView textViewDBTinh2;
        TextView textViewG1Tinh2;
        TextView textViewG2Tinh2;
        TextView textViewG3Tinh2;
        TextView textViewG4Tinh2;
        TextView textViewG5Tinh2;
        TextView textViewG6Tinh2;
        TextView textViewG7Tinh2;
        TextView textViewG8Tinh2;

        TextView textViewDBTinh3;
        TextView textViewG1Tinh3;
        TextView textViewG2Tinh3;
        TextView textViewG3Tinh3;
        TextView textViewG4Tinh3;
        TextView textViewG5Tinh3;
        TextView textViewG6Tinh3;
        TextView textViewG7Tinh3;
        TextView textViewG8Tinh3;

        RssViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitleXSMN);
            textViewDate = itemView.findViewById(R.id.textViewDateXSMN);

            textViewNameTinh1 =  itemView.findViewById(R.id.textViewNameTinh1);
            textViewNameTinh2 =  itemView.findViewById(R.id.textViewNameTinh2);
            textViewNameTinh3 =  itemView.findViewById(R.id.textViewNameTinh3);

            textViewDBTinh1 = itemView.findViewById(R.id.textViewDBTinh1);
            textViewG1Tinh1 = itemView.findViewById(R.id.textViewG1Tinh1);
            textViewG2Tinh1 = itemView.findViewById(R.id.textViewG2Tinh1);
            textViewG3Tinh1 = itemView.findViewById(R.id.textViewG3Tinh1);
            textViewG4Tinh1 = itemView.findViewById(R.id.textViewG4Tinh1);
            textViewG5Tinh1 = itemView.findViewById(R.id.textViewG5Tinh1);
            textViewG6Tinh1 = itemView.findViewById(R.id.textViewG6Tinh1);
            textViewG7Tinh1 = itemView.findViewById(R.id.textViewG7Tinh1);
            textViewG8Tinh1 = itemView.findViewById(R.id.textViewG8Tinh1);

            textViewDBTinh2 = itemView.findViewById(R.id.textViewDBTinh2);
            textViewG1Tinh2 = itemView.findViewById(R.id.textViewG1Tinh2);
            textViewG2Tinh2 = itemView.findViewById(R.id.textViewG2Tinh2);
            textViewG3Tinh2 = itemView.findViewById(R.id.textViewG3Tinh2);
            textViewG4Tinh2 = itemView.findViewById(R.id.textViewG4Tinh2);
            textViewG5Tinh2 = itemView.findViewById(R.id.textViewG5Tinh2);
            textViewG6Tinh2 = itemView.findViewById(R.id.textViewG6Tinh2);
            textViewG7Tinh2 = itemView.findViewById(R.id.textViewG7Tinh2);
            textViewG8Tinh2 = itemView.findViewById(R.id.textViewG8Tinh2);

            textViewDBTinh3 = itemView.findViewById(R.id.textViewDBTinh3);
            textViewG1Tinh3 = itemView.findViewById(R.id.textViewG1Tinh3);
            textViewG2Tinh3 = itemView.findViewById(R.id.textViewG2Tinh3);
            textViewG3Tinh3 = itemView.findViewById(R.id.textViewG3Tinh3);
            textViewG4Tinh3 = itemView.findViewById(R.id.textViewG4Tinh3);
            textViewG5Tinh3 = itemView.findViewById(R.id.textViewG5Tinh3);
            textViewG6Tinh3 = itemView.findViewById(R.id.textViewG6Tinh3);
            textViewG7Tinh3 = itemView.findViewById(R.id.textViewG7Tinh3);
            textViewG8Tinh3 = itemView.findViewById(R.id.textViewG8Tinh3);
        }
    }
}

