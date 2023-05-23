package com.example.kqxs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class KQXSDT636Adapter extends RecyclerView.Adapter<KQXSDT636Adapter.RssViewHolder> {

    private ArrayList<KQXSModel> rssItems;

    public KQXSDT636Adapter(ArrayList<KQXSModel> rssItems) {
        this.rssItems = rssItems;
    }

    @NonNull
    @Override
    public RssViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kqxsdt636, parent, false);
        return new RssViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RssViewHolder holder, int position) {
        KQXSModel kqxsModel = rssItems.get(position);
        holder.textViewTitle.setText(kqxsModel.getTitle());
        holder.textViewDate.setText(kqxsModel.getDate());
        holder.textViewSet1.setText(getSet1String(kqxsModel.getDescription()));
        holder.textViewSet2.setText(getSet2String(kqxsModel.getDescription()));
        holder.textViewSet3.setText(getSet3String(kqxsModel.getDescription()));
        holder.textViewSet4.setText(getSet4String(kqxsModel.getDescription()));
        holder.textViewSet5.setText(getSet5String(kqxsModel.getDescription()));
        holder.textViewSet6.setText(getSet6String(kqxsModel.getDescription()));
    }

    private String getSet1String(String description) {
        GetKQXSDT636 parser = new GetKQXSDT636(description);
        String set1 = String.valueOf(parser.getSet1Prize());
        return  set1;
    }
    private String getSet2String(String description) {
        GetKQXSDT636 parser = new GetKQXSDT636(description);
        String set2 = String.valueOf(parser.getSet2Prize());
        return  set2;
    }
    private String getSet3String(String description) {
        GetKQXSDT636 parser = new GetKQXSDT636(description);
        String set3 = String.valueOf(parser.getSet3Prize());
        return  set3;
    }
    private String getSet4String(String description) {
        GetKQXSDT636 parser = new GetKQXSDT636(description);
        String set4 = String.valueOf(parser.getSet4Prize());
        return  set4;
    }
    private String getSet5String(String description) {
        GetKQXSDT636 parser = new GetKQXSDT636(description);
        String set5 = String.valueOf(parser.getSet5Prize());
        return  set5;
    }
    private String getSet6String(String description) {
        GetKQXSDT636 parser = new GetKQXSDT636(description);
        String set6 = String.valueOf(parser.getSet6Prize());
        return  set6;
    }
    @Override
    public int getItemCount() {
        return rssItems.size();
    }

    static class RssViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDate;
        TextView textViewSet1;
        TextView textViewSet2;
        TextView textViewSet3;
        TextView textViewSet4;
        TextView textViewSet5;
        TextView textViewSet6;

        RssViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewSet1 = itemView.findViewById(R.id.textViewSet1);
            textViewSet2 = itemView.findViewById(R.id.textViewSet2);
            textViewSet3 = itemView.findViewById(R.id.textViewSet3);
            textViewSet4 = itemView.findViewById(R.id.textViewSet4);
            textViewSet5 = itemView.findViewById(R.id.textViewSet5);
            textViewSet6 = itemView.findViewById(R.id.textViewSet6);
        }
    }
}



