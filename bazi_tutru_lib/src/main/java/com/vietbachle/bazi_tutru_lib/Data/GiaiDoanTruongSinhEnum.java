package com.vietbachle.bazi_tutru_lib.Data;

/**
 * Created by vietbachle on 2/5/2017.
 */

public enum GiaiDoanTruongSinhEnum {
//    None = 0,
//    TruongSinh = 1,
//    MocDuc = 2,
//    QuanDoi = 3,
//    LamQuan = 4,
//    DeVuong = 5,
//    Suy = 6,
//    Benh = 7,
//    Tu = 8,
//    Mo = 9,
//    Tuyet = 10,
//    Thai = 11,
//    Duong = 12

    None,
    TruongSinh,
    MocDuc,
    QuanDoi,
    LamQuan,
    DeVuong,
    Suy,
    Benh,
    Tu,
    Mo,
    Tuyet,
    Thai,
    Duong;

    public static GiaiDoanTruongSinhEnum fromInteger(int x) {
        switch(x) {
            case 0:
                return None;
            case 1:
                return TruongSinh;
            case 2:
                return MocDuc;
            case 3:
                return QuanDoi;
            case 4:
                return LamQuan;
            case 5:
                return DeVuong;
            case 6:
                return Suy;
            case 7:
                return Benh;
            case 8:
                return Tu;
            case 9:
                return Mo;
            case 10:
                return Tuyet;
            case 11:
                return Thai;
            case 12:
                return Duong;
        }
        return None;
    }

}