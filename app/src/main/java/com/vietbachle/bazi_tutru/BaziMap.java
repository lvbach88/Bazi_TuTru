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
import com.vietbachle.bazi_tutru_lib.Data.CanEnum;
import com.vietbachle.bazi_tutru_lib.Data.ChiEnum;
import com.vietbachle.bazi_tutru_lib.Data.Constants;
import com.vietbachle.bazi_tutru_lib.Data.DiaChi;
import com.vietbachle.bazi_tutru_lib.Data.ThienCan;
import com.vietbachle.bazi_tutru_lib.Data.TongHopCanChi;
import com.vietbachle.bazi_tutru_lib.Data.Tru;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaziMap extends AppCompatActivity {

    private void populate_Can(View canView, ThienCan can){
        if (canView == null || can == null){
            return;
        }
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

    private void populate_DiaChi_Tru(View chiView, Tru tru){
        TextView txt_dc_nap_am = (TextView)chiView.findViewById(R.id.txt_dc_nap_am);
        txt_dc_nap_am.setText(LookUpTable.NapAm.get(new Pair<>(tru.ThienCan.Can, tru.DiaChi.Ten)).toString());


        TextView txt_dc_truong_sinh = (TextView)chiView.findViewById(R.id.txt_dc_truong_sinh);
        txt_dc_truong_sinh.setText(tru.DiaChi.VongTruongSinh.toString());


        List<String> thuocTinh = Collections.list(tru.DiaChi.ThuocTinh.keys());
        thuocTinh.addAll(Collections.list(tru.ThuocTinh.keys()));
        ArrayAdapter<String> thuocTinh_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thuocTinh);
        ((ListView)chiView.findViewById(R.id.lv_dc_attr)).setAdapter(thuocTinh_Adapter);


        TextView txt_dc_name = (TextView)chiView.findViewById(R.id.txt_dc_name);
        txt_dc_name.setText(tru.DiaChi.Ten.toString());


        TextView txt_dc_5_elements = (TextView)chiView.findViewById(R.id.txt_dc_5_elements);
        txt_dc_5_elements.setText(tru.DiaChi.AmDuong.toString() + " " + tru.DiaChi.BanKhi.NguHanh.toString());


        List<String> thanSat = Collections.list(tru.DiaChi.ThanSat.keys());
        ArrayAdapter<String> thanSat_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thanSat);
        ((ListView)chiView.findViewById(R.id.lv_dc_than_sat)).setAdapter(thanSat_Adapter);

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

        InteractionLaws laws = new InteractionLaws(mybiz);
        laws.setAllLaws();
        ///////// mock data

        populate_Can(findViewById(R.id.tc_gio), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_GIO).ThienCan);
        populate_DiaChi_Tru(findViewById(R.id.dc_gio), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_GIO));
        populate_Can(findViewById(R.id.dc_gio_ban_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_GIO).DiaChi.BanKhi);
        populate_Can(findViewById(R.id.dc_gio_trung_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_GIO).DiaChi.TrungKhi);
        populate_Can(findViewById(R.id.dc_gio_tap_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_GIO).DiaChi.TapKhi);


        populate_Can(findViewById(R.id.tc_ngay), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan);
        populate_DiaChi_Tru(findViewById(R.id.dc_ngay), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY));
        populate_Can(findViewById(R.id.dc_ngay_ban_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).DiaChi.BanKhi);
        populate_Can(findViewById(R.id.dc_ngay_trung_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).DiaChi.TrungKhi);
        populate_Can(findViewById(R.id.dc_ngay_tap_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).DiaChi.TapKhi);


        populate_Can(findViewById(R.id.tc_thang), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).ThienCan);
        populate_DiaChi_Tru(findViewById(R.id.dc_thang), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_THANG));
        populate_Can(findViewById(R.id.dc_thang_ban_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).DiaChi.BanKhi);
        populate_Can(findViewById(R.id.dc_thang_trung_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).DiaChi.TrungKhi);
        populate_Can(findViewById(R.id.dc_thang_tap_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).DiaChi.TapKhi);


        populate_Can(findViewById(R.id.tc_nam), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan);
        populate_DiaChi_Tru(findViewById(R.id.dc_nam), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NAM));
        populate_Can(findViewById(R.id.dc_nam_ban_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).DiaChi.BanKhi);
        populate_Can(findViewById(R.id.dc_nam_trung_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).DiaChi.TrungKhi);
        populate_Can(findViewById(R.id.dc_nam_tap_khi), mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).DiaChi.TapKhi);



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
