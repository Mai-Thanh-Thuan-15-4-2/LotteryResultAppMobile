package com.example.kqxs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KQXSDBAdapter extends RecyclerView.Adapter<KQXSDBAdapter.KQXSViewHolder> {
    private List<XSDB> kqxsList;

    public KQXSDBAdapter(List<XSDB> kqxsList) {
        this.kqxsList = kqxsList;
    }

    @NonNull
    @Override
    public KQXSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kqxs_item, parent, false);
        return new KQXSViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KQXSViewHolder holder, int position) {
        XSDB kqxs = kqxsList.get(position);
        holder.bind(kqxs);
    }

    @Override
    public int getItemCount() {
        return kqxsList.size();
    }

    static class KQXSViewHolder extends RecyclerView.ViewHolder {
        private TextView idTextView;
        private TextView valueTextView;

        KQXSViewHolder(View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.id_text_view);
            valueTextView = itemView.findViewById(R.id.value_text_view);
        }

        void bind(XSDB kqxs) {
            idTextView.setText(String.valueOf(kqxs.getId()));
            valueTextView.setText(kqxs.getValue());
        }
    }
}
