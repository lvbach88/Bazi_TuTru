package com.vietbachle.bazi_tutru_lib.BusinessRules;

import com.vietbachle.bazi_tutru_lib.Data.*;

/**
 * Created by vietbachle on 2/9/2017.
 */

public final class SettingRules {

    private SettingRules(){}

    /// <summary>
    /// Set Thap Than based on "can ngay"
    /// </summary>
    /// <param name="canNgay">to be based on</param>
    /// <param name="can">to set Thap Than property</param>
    public static void SetThapThan(ThienCan canNgay, ThienCan can)
    {
        NguHanhEnum[] sinhKhac = LookUpTable.NguHanhSinhKhac.get(canNgay.NguHanh); // [canNgay.NguHanh];
        NguHanhEnum nhSinh = sinhKhac[0];
        NguHanhEnum nhDuocSinh = sinhKhac[1];
        NguHanhEnum nhKhac = sinhKhac[2];
        NguHanhEnum nhBiKhac = sinhKhac[3];

        if (can.NguHanh == nhSinh)
        {
            if (canNgay.AmDuong == can.AmDuong)
            {
                can.ThapThan = ThapThanEnum.ThucThan;
            }
            else
            {
                can.ThapThan = ThapThanEnum.ThuongQuan;
            }
        }
        else if (can.NguHanh == nhDuocSinh)
        {
            if (canNgay.AmDuong == can.AmDuong)
            {
                can.ThapThan = ThapThanEnum.ThienAn;
            }
            else
            {
                can.ThapThan = ThapThanEnum.ChinhAn;
            }
        }
        else if (can.NguHanh == nhKhac)
        {
            if (canNgay.AmDuong == can.AmDuong)
            {
                can.ThapThan = ThapThanEnum.ThienTai;
            }
            else
            {
                can.ThapThan = ThapThanEnum.ChinhTai;
            }
        }
        else if (can.NguHanh == nhBiKhac)
        {
            if (canNgay.AmDuong == can.AmDuong)
            {
                can.ThapThan = ThapThanEnum.ThienQuan;
            }
            else
            {
                can.ThapThan = ThapThanEnum.ChinhQuan;
            }
        }
        else //same Ngu Hanh
        {
            if (canNgay.AmDuong == can.AmDuong)
            {
                can.ThapThan = ThapThanEnum.TyKien;
            }
            else
            {
                can.ThapThan = ThapThanEnum.KiepTai;
            }
        }
    }
}
