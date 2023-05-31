package com.example.kqxs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BanVSOnlineAdapter extends RecyclerView.Adapter<BanVSOnlineAdapter.BanvesoViewHolder> {
    private List<VesoModel> vesoList;

    public BanVSOnlineAdapter(List<VesoModel> vesoList) {
        this.vesoList = vesoList;
    }


    @NonNull
    @Override
    public BanvesoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vs_items, parent, false);
        return new BanvesoViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BanvesoViewHolder holder, int position) {
        VesoModel veso = vesoList.get(position);
        holder.bind(veso);
    }

    @Override
    public int getItemCount() {
        return vesoList.size();
    }

    static class BanvesoViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView dayso;
        private TextView tentinh;
        private TextView ngayxo;
        private TextView soluong;

        BanvesoViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_vs);
            dayso = itemView.findViewById(R.id.value_dayso);
            tentinh = itemView.findViewById(R.id.value_tentinh);
            ngayxo = itemView.findViewById(R.id.value_ngayxo);
            soluong = itemView.findViewById(R.id.value_soluong);
        }

        void bind(VesoModel veso) {
            id.setText(String.valueOf(veso.getMavs()));
            dayso.setText(veso.getDayso());
            tentinh.setText(veso.getTentinh());
            ngayxo.setText(veso.getNgayxo());
            soluong.setText(String.valueOf(veso.getSoluong()));

        }
    }
}
