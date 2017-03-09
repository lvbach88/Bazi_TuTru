package com.vietbachle.bazi_tutru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class InfoGathering extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener */ {

    private Spinner spn_can_nam;
    private Spinner spn_chi_nam;

    private Spinner spn_can_thang;
    private Spinner spn_chi_thang;

    private Spinner spn_can_ngay;
    private Spinner spn_chi_ngay;

    private Spinner spn_can_gio;
    private Spinner spn_chi_gio;

    private Spinner spn_tuoi_bat_dau;
    private Spinner spn_tuoi_dai_van;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_gathering);

        spn_can_nam = (Spinner) findViewById(R.id.spn_can_nam);
        setThienCanSpinner(spn_can_nam);
        spn_chi_nam = (Spinner) findViewById(R.id.spn_chi_nam);
        setDiaChiSpinner(spn_chi_nam);

        spn_can_thang = (Spinner) findViewById(R.id.spn_can_thang);
        setThienCanSpinner(spn_can_thang);
        spn_chi_thang = (Spinner) findViewById(R.id.spn_chi_thang);
        setDiaChiSpinner(spn_chi_thang);

        spn_can_ngay = (Spinner) findViewById(R.id.spn_can_ngay);
        setThienCanSpinner(spn_can_ngay);
        spn_chi_ngay = (Spinner) findViewById(R.id.spn_chi_ngay);
        setDiaChiSpinner(spn_chi_ngay);

        spn_can_gio = (Spinner) findViewById(R.id.spn_can_gio);
        setThienCanSpinner(spn_can_gio);
        spn_chi_gio = (Spinner) findViewById(R.id.spn_chi_gio);
        setDiaChiSpinner(spn_chi_gio);

        spn_tuoi_bat_dau = (Spinner) findViewById(R.id.spn_tuoi_bat_dau);
        spn_tuoi_dai_van = (Spinner) findViewById(R.id.spn_tuoi_dai_van);
        setTuoiBatDau_TuoiDaiVan();
    }

    private void setThienCanSpinner(Spinner spinner){
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.thien_can, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
    }

    private void setDiaChiSpinner(Spinner spinner){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dia_chi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    private void setTuoiBatDau_TuoiDaiVan(){
        ArrayAdapter<String> dataAdapter;
        List<String> tuoiBatDau = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            tuoiBatDau.add(String.valueOf(i));
        }
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tuoiBatDau);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_tuoi_bat_dau.setAdapter(dataAdapter);


        List<String> tuoiDaiVan = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            tuoiDaiVan.add(String.valueOf(i));
        }
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tuoiDaiVan);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_tuoi_dai_van.setAdapter(dataAdapter);




    }

//spinner item selected
//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        // An item was selected. You can retrieve the selected item using
//        // parent.getItemAtPosition(pos)
//        int _t = pos;
//    }

//spinner nothing selected
//    public void onNothingSelected(AdapterView<?> parent) {
//        // Another interface callback
//        int x = 0;
//    }

    public void onSubmit(View view){
        String canNam = String.valueOf(spn_can_nam.getSelectedItem());
    }
}
