package com.example.kqxs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListResultTicketAdapter extends ArrayAdapter<TicketModel> {

    public ListResultTicketAdapter(Context context, List<TicketModel> tickets) {
        super(context, 0, tickets);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_check_ticket_result, parent, false);
        }

        // Lấy dữ liệu vé số ở vị trí position
        TicketModel ticket = getItem(position);

        // Hiển thị thông tin của vé số trong item
        TextView tvSoTrungThuong = convertView.findViewById(R.id.idTicketCheck);
        TextView tvSoLuong = convertView.findViewById(R.id.textViewAmount);
        TextView tvNgayXo = convertView.findViewById(R.id.textViewDate);
        TextView tvKetQua = convertView.findViewById(R.id.textViewResult);

        tvSoTrungThuong.setText(ticket.getSoTrungThuong()+ "");
        tvSoLuong.setText(ticket.getSoLuongVe() + "");
        tvNgayXo.setText(ticket.getNgayXoString() + "");
        tvKetQua.setText(ticket.getKetQuaXo() + "");
        return convertView;
    }
}
