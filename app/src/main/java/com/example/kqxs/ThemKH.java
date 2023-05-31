package com.example.kqxs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ThemKH extends AppCompatActivity {
    private EditText edtHoten, edtSdt, edtDc, edtSlm, edtSm;
    private Button btnDathang;
    private DatabaseCus databaseCus;
    FloatingActionButton fab;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cus_items);

        edtHoten = findViewById(R.id.value_hoten);
        edtSdt = findViewById(R.id.value_sdt);
        edtDc = findViewById(R.id.value_dc);
        edtSlm = findViewById(R.id.value_slm);
        edtSm = findViewById(R.id.value_sm);
        fab = findViewById(R.id.dhBackHome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemKH.this, Home.class);
                startActivity(intent);
            }
        });

        btnDathang = findViewById(R.id.button_tt);
        btnDathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoten.getText().toString().trim();
                String sdt = edtSdt.getText().toString().trim();
                String diachi = edtDc.getText().toString().trim();
                String soluongmua = edtSlm.getText().toString().trim();
                String sodatmua = edtSm.getText().toString().trim();

                // Kiểm tra các trường dữ liệu có bị bỏ trống hay không trước khi chèn dữ liệu vào CSDL
                if (TextUtils.isEmpty(hoten)) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập họ tên", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(sdt)) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(diachi)) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập địa chỉ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(soluongmua)) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập số lượng mua", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(sodatmua)) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập số đất mua", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Thực hiện chèn dữ liệu vào CSDL
                databaseCus = new DatabaseCus(ThemKH.this);
                SQLiteDatabase db = databaseCus.getWritableDatabase();
                databaseCus.insertData(db, hoten, sdt, diachi, soluongmua, sodatmua);
                Toast.makeText(getApplicationContext(), "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                databaseCus.close();
                finish();
            }
        });
    }
}
