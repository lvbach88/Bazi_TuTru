package com.vietbachle.bazi_tutru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.vietbachle.bazi_tutru_lib.BusinessRules.InteractionLaws;
import com.vietbachle.bazi_tutru_lib.BusinessRules.LookUpTable;
import com.vietbachle.bazi_tutru_lib.BusinessRules.TuTruMap;
import com.vietbachle.bazi_tutru_lib.Data.Constants;
import com.vietbachle.bazi_tutru_lib.Data.ThienCan;
import com.vietbachle.bazi_tutru_lib.Data.TongHopCanChi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaziMap extends AppCompatActivity {

    private void populateCan(View canView, ThienCan can){
        TextView txt_tc_10_gods = (TextView)canView.findViewById(R.id.txt_tc_10_gods);
        txt_tc_10_gods.setText(can.ThapThan.toString());



        List<String> thuocTinh = Collections.list(can.ThuocTinh.keys());
        ArrayAdapter<String> thuocTinh_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thuocTinh);
        ((ListView)canView.findViewById(R.id.lv_tc_attr)).setAdapter(thuocTinh_Adapter);



        TextView txt_tc_name = (TextView)canView.findViewById(R.id.txt_tc_name);
        txt_tc_name.setText(can.Can.toString());


        TextView txt_tc_5_elements = (TextView)canView.findViewById(R.id.txt_tc_5_elements);
        txt_tc_5_elements.setText(can.NguHanh.toString());


        List<String> thanSat = Collections.list(can.ThanSat.keys());
        ArrayAdapter<String> thanSat_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thanSat);
        ((ListView)canView.findViewById(R.id.lv_tc_than_sat)).setAdapter(thanSat_Adapter);





    }

    private void populateView(){
        TongHopCanChi.Init();
        LookUpTable.Init();


        //mock data, this should be from InfoGathering
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 64;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();
        ///////// mock data

        populateCan(findViewById(R.id.tc_gio), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_GIO).ThienCan);


    }

    private void hide_Tang_Can_ListView(){
        List<View> tangCan = new ArrayList<>();
        tangCan.add(findViewById(R.id.dc_gio_ban_khi));
        tangCan.add(findViewById(R.id.dc_gio_trung_khi));
        tangCan.add(findViewById(R.id.dc_gio_tap_khi));

        tangCan.add(findViewById(R.id.dc_ngay_ban_khi));
        tangCan.add(findViewById(R.id.dc_ngay_trung_khi));
        tangCan.add(findViewById(R.id.dc_ngay_tap_khi));

        tangCan.add(findViewById(R.id.dc_thang_ban_khi));
        tangCan.add(findViewById(R.id.dc_thang_trung_khi));
        tangCan.add(findViewById(R.id.dc_thang_tap_khi));

        tangCan.add(findViewById(R.id.dc_nam_ban_khi));
        tangCan.add(findViewById(R.id.dc_nam_trung_khi));
        tangCan.add(findViewById(R.id.dc_nam_tap_khi));

        for (View can : tangCan){
            View lv_tc_attr = can.findViewById(R.id.lv_tc_attr);
            View lv_tc_than_sat = can.findViewById(R.id.lv_tc_than_sat);

            lv_tc_attr.setVisibility(View.GONE);
            lv_tc_than_sat.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazi_map);

        populateView();

        hide_Tang_Can_ListView();
    }


    public void onClick(View view){
//        int x = 0;
//        View canView = findViewById(R.id.tc1);
//        TextView txt_can_upper = (TextView)canView.findViewById(R.id.txt_tc_name);
//        txt_can_upper.setText("txt_tc_name accessed!");
//
//        View chiView = findViewById(R.id.tc2);
//        TextView txt_chi_lower = (TextView)chiView.findViewById(R.id.txt_tc_5_elements);
//        txt_chi_lower.setText("txt_tc_5_elements accessed!");
        return;
    }
}
