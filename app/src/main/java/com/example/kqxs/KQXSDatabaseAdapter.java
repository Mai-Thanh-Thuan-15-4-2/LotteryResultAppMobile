package com.example.kqxs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KQXSDatabaseAdapter extends RecyclerView.Adapter<KQXSDatabaseAdapter.KQXSViewHolder> {
    private static List<XSDB> kqxsList;
    private static ArrayAdapter<CharSequence> spinnerAdapter;

    public KQXSDatabaseAdapter(List<XSDB> kqxsList, Context context) {
        this.kqxsList = kqxsList;
        spinnerAdapter = ArrayAdapter.createFromResource(
                context,
                R.array.spinner_values,
                android.R.layout.simple_spinner_item
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
        private TextView thongke;
        private Spinner spinner;
        private Button ok;

        KQXSViewHolder(View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.id_text_view);
            valueTextView = itemView.findViewById(R.id.value_text_view);
            thongke = itemView.findViewById(R.id.result);
            ok = itemView.findViewById(R.id.button);
            spinner = itemView.findViewById(R.id.spinner);
            spinner.setAdapter(spinnerAdapter);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    XSDB kqxs = kqxsList.get(getAdapterPosition());
                    String value = kqxs.getValue();
                    int count = 0;
                    int selectedValue = Integer.parseInt(spinner.getSelectedItem().toString());
                    for(int i = 0; i < value.length(); i++){
                        if(Integer.parseInt(String.valueOf(value.charAt(i))) == selectedValue){
                            count++;
                        }
                    }
                    int result = 0;
                    if(value.length() > 0){
                        result = (int) ((count * 100.0) / value.length());
                    }

                    thongke.setText(result + "%");
                }
            });
        }

        void bind(XSDB kqxs) {
            idTextView.setText(String.valueOf(kqxs.getId()));
            valueTextView.setText(kqxs.getValue());
        }
    }
}
