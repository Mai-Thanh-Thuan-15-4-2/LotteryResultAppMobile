package com.example.kqxs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class radioListAdapter extends ArrayAdapter<radioModel> {
    private Context context;
    private List<radioModel> radioList;
    public radioListAdapter(Context context, List<radioModel> stationList) {
        super(context, 0, stationList);
        this.context = context;
        this.radioList = stationList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_radio_result, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.btnView = convertView.findViewById(R.id.kqxsdai);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        radioModel radio = radioList.get(position);

        viewHolder.btnView.setText(radio.getNameRadio());
        viewHolder.btnView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, radioResultController.class);
                intent.putExtra("rss", radio.getLinkRss());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        Button btnView;
    }
}
