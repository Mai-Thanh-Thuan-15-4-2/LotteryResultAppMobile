package com.example.kqxs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListXSTheoDai extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_xstheodai);
        FloatingActionButton fab = findViewById(R.id.xstheodaiBackHome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, Home.class);
                startActivity(intent);
            }
        });
        Button btn_ag = findViewById(R.id.kqxsag);
        btn_ag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSAG.class);
                startActivity(intent);
            }
        });
        Button btn_tn = findViewById(R.id.kqxstn);
        btn_tn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSTNh.class);
                startActivity(intent);
            }
        });
        Button btn_tth = findViewById(R.id.kqxstth);
        btn_tth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSTTH.class);
                startActivity(intent);
            }
        });
        Button btn_tv = findViewById(R.id.kqxstv);
        btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSTV.class);
                startActivity(intent);
            }
        });
        Button btn_vl = findViewById(R.id.kqxsvl);
        btn_vl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSVL.class);
                startActivity(intent);
            }
        });
        Button btn_vt = findViewById(R.id.kqxsvt);
        btn_vt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSVT.class);
                startActivity(intent);
            }
        });
        Button btn_kt = findViewById(R.id.kqxskt);
        btn_kt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSKT.class);
                startActivity(intent);
            }
        });
        Button btn_la = findViewById(R.id.kqxsla);
        btn_la.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSLA.class);
                startActivity(intent);
            }
        });
//      XS TIEN GIANG
        Button btn_tg = findViewById(R.id.kqxstg);
        btn_tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSTG.class);
                startActivity(intent);
            }
        });
//        XS SOC TRANG
        Button btn_soc = findViewById(R.id.kqxssoc);
        btn_soc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSSOC.class);
                startActivity(intent);
            }
        });
//        xo so quang tri
        Button btn_qt= findViewById(R.id.kqxsqt);
        btn_qt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSQT.class);
                startActivity(intent);
            }
        });
//        XO SO QUANG NAM
        Button btn_qnam= findViewById(R.id.kqxsqnam);
        btn_qnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSQNAM.class);
                startActivity(intent);
            }
        });
//      xo so quang ngai
        Button btn_qn= findViewById(R.id.kqxsqn);
        btn_qn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSQN.class);
                startActivity(intent);
            }
        });
//        xo số quang binh
        Button btn_qb= findViewById(R.id.kqxsqb);
        btn_qb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSQB.class);
                startActivity(intent);
            }
        });
//        xo so phu yen
        Button btn_py= findViewById(R.id.kqxspy);
        btn_py.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSPY.class);
                startActivity(intent);
            }
        });
//        xo so ninh thuan
        Button btn_nt= findViewById(R.id.kqxsnt);
        btn_nt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSNT.class);
                startActivity(intent);
            }
        });
//        xo so lam dong
        Button btn_lamdong= findViewById(R.id.kqxslamdong);
        btn_lamdong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSLAMDONG.class);
                startActivity(intent);
            }
        });
        Button btn_bd= findViewById(R.id.kqxsbd);
        btn_bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSBD.class);
                startActivity(intent);
            }
        });
        Button btn_bdh= findViewById(R.id.kqxsbdh);
        btn_bdh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSBDH.class);
                startActivity(intent);
            }
        });
        Button btn_bl= findViewById(R.id.kqxsbl);
        btn_bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSBL.class);
                startActivity(intent);
            }
        });
        Button btn_bp= findViewById(R.id.kqxsbp);
        btn_bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSBP.class);
                startActivity(intent);
            }
        });
        Button btn_bt= findViewById(R.id.kqxsbt);
        btn_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSBT.class);
                startActivity(intent);
            }
        });
        Button btn_bth= findViewById(R.id.kqxsbth);
        btn_bth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSBTH.class);
                startActivity(intent);
            }
        });
        Button btn_cm= findViewById(R.id.kqxscm);
        btn_cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListXSTheoDai.this, ShowKQXSCM.class);
                startActivity(intent);
            }
        });
    }
}
