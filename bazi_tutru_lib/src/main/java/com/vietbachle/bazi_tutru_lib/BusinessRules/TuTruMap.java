package com.vietbachle.bazi_tutru_lib.BusinessRules;

import android.util.Pair;

import com.vietbachle.bazi_tutru_lib.Data.*;

/**
 * Created by vietbachle on 2/12/2017.
 */

public class TuTruMap {
    public LaSo LaSoCuaToi; // { get; set; }
    public Tru DaiVanHienTai; // { get; private set; }
    public Tru LuuNien; // { get; private set; }

    public void InitLaSo( String gioiTinh,
                          String canNam, String chiNam,
                          String canThang, String chiThang,
                          String canNgay, String chiNgay,
                          String canGio, String chiGio,
                          int tuoi, int tuoiDV)
    {
        // to call all create/set methods.
        // 1. create tu tru
        // 2. create dai van
        // 3. create tieu van
        // 4. create cung menh
        // 5. create thai nguyen
        CreateTuTru(gioiTinh, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio);
        CreateDaiVan(tuoi, tuoiDV);
        CreateTieuVan();
        CreateCungMenh();
        CreateThaiNguyen();

        Tru truNgay = this.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY);

//        #region Set Thap Than
        int n = Constants.THIEN_CAN_SIZE;
        for (int i = 0; i < n; i++)
        {
            SetThapThan(null, TongHopCanChi.MuoiThienCan.get(i));
        }
//        #endregion Set Thap Than

//        #region Set Nap Am, Vong Truong Sinh
        for (Tru tru : this.LaSoCuaToi.TuTru.values())
        {
            SetNapAm(tru);
            tru.AddThuocTinh(Constants.VONG_TRUONG_SINH, LookUpTable.VongTruongSinh(truNgay.ThienCan.Can, tru.DiaChi.Ten));
        }

        Tru cm = this.LaSoCuaToi.CungMenh;
        Tru tn = this.LaSoCuaToi.ThaiNguyen;
        SetNapAm(cm);
        cm.AddThuocTinh(Constants.VONG_TRUONG_SINH, LookUpTable.VongTruongSinh(truNgay.ThienCan.Can, cm.DiaChi.Ten));
        SetNapAm(tn);
        tn.AddThuocTinh(Constants.VONG_TRUONG_SINH, LookUpTable.VongTruongSinh(truNgay.ThienCan.Can, tn.DiaChi.Ten));

        for (Tru tru : this.LaSoCuaToi.DaiVan)
        {
            SetNapAm(tru);
            tru.AddThuocTinh(Constants.VONG_TRUONG_SINH, LookUpTable.VongTruongSinh(truNgay.ThienCan.Can, tru.DiaChi.Ten));
        }

        // Tieu Van starts at 1
        for (int i = 1; i < this.LaSoCuaToi.TieuVan.size(); i++)
        {
            Tru tru = this.LaSoCuaToi.TieuVan.get(i);
            SetNapAm(tru);
            tru.AddThuocTinh(Constants.VONG_TRUONG_SINH, LookUpTable.VongTruongSinh(truNgay.ThienCan.Can, tru.DiaChi.Ten));
        }

//        #endregion Set Nap Am, Vong Truong Sinh


    }

    public void InitLaSo( String gioiTinh,
                          String canNam, String chiNam,
                          String canThang, String chiThang,
                          String canNgay, String chiNgay,
                          String canGio, String chiGio,
                          int tuoi){
        InitLaSo(gioiTinh, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, Integer.MIN_VALUE);
    }

    public void CreateTuTru( String gioiTinh,
                             String canNam, String chiNam,
                             String canThang, String chiThang,
                             String canNgay, String chiNgay,
                             String canGio, String chiGio)
    {
        CanEnum e_canNam, e_canThang, e_canNgay, e_canGio;
        ChiEnum e_chiNam, e_chiThang, e_chiNgay, e_chiGio;
        GioiTinhEnum e_gt;

        try{
            e_gt = GioiTinhEnum.valueOf(gioiTinh.substring(0, 1).toUpperCase() + gioiTinh.substring(1).toLowerCase());

            e_canNam = CanEnum.valueOf(canNam.substring(0, 1).toUpperCase() + canNam.substring(1).toLowerCase());
            e_chiNam = ChiEnum.valueOf(chiNam.substring(0, 1).toUpperCase() + chiNam.substring(1).toLowerCase());

            e_canThang = CanEnum.valueOf(canThang.substring(0, 1).toUpperCase() + canThang.substring(1).toLowerCase());
            e_chiThang = ChiEnum.valueOf(chiThang.substring(0, 1).toUpperCase() + chiThang.substring(1).toLowerCase());

            e_canNgay = CanEnum.valueOf(canNgay.substring(0, 1).toUpperCase() + canNgay.substring(1).toLowerCase());
            e_chiNgay = ChiEnum.valueOf(chiNgay.substring(0, 1).toUpperCase() + chiNgay.substring(1).toLowerCase());

            e_canGio = CanEnum.valueOf(canGio.substring(0, 1).toUpperCase() + canGio.substring(1).toLowerCase());
            e_chiGio = ChiEnum.valueOf(chiGio.substring(0, 1).toUpperCase() + chiGio.substring(1).toLowerCase());

            this.LaSoCuaToi = new LaSo();
            Tru truNam = new Tru(TongHopCanChi.getThienCanByEnum(e_canNam), TongHopCanChi.getDiaChiByEnum(e_chiNam));
            Tru truThang = new Tru(TongHopCanChi.getThienCanByEnum(e_canThang), TongHopCanChi.getDiaChiByEnum(e_chiThang));
            Tru truNgay = new Tru(TongHopCanChi.getThienCanByEnum(e_canNgay), TongHopCanChi.getDiaChiByEnum(e_chiNgay));
            Tru truGio = new Tru(TongHopCanChi.getThienCanByEnum(e_canGio), TongHopCanChi.getDiaChiByEnum(e_chiGio));

            this.LaSoCuaToi.TuTru.put(Constants.TRU_NAM, truNam);
            this.LaSoCuaToi.TuTru.put(Constants.TRU_THANG, truThang);
            this.LaSoCuaToi.TuTru.put(Constants.TRU_NGAY, truNgay);
            this.LaSoCuaToi.TuTru.put(Constants.TRU_GIO, truGio);

            this.LaSoCuaToi.GioiTinh = e_gt;

        } catch (Exception e){
            this.LaSoCuaToi = null;
        }

    }

    public void CreateDaiVan(int age, int daiVanHienTai)
    {

        int direction = 1;

        if ((this.LaSoCuaToi.GioiTinh == GioiTinhEnum.Nam && this.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong == AmDuongEnum.Duong)
                || (this.LaSoCuaToi.GioiTinh == GioiTinhEnum.Nu && this.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong == AmDuongEnum.Am))
        {
            direction = 1;
        }
        else if ((this.LaSoCuaToi.GioiTinh == GioiTinhEnum.Nam && this.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong == AmDuongEnum.Am)
                || (this.LaSoCuaToi.GioiTinh == GioiTinhEnum.Nu && this.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong == AmDuongEnum.Duong))
        {
            direction = -1;
        }

        CanEnum canThang = this.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).ThienCan.Can;
        ChiEnum chiThang = this.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).DiaChi.Ten;

        int canIndex = TongHopCanChi.getIndexoOfThienCanByEnum(canThang);
        int chiIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(chiThang);

        int nCan = TongHopCanChi.MuoiThienCan.size();
        int nChi = TongHopCanChi.MuoiHaiDiaChi.size();

        for (int i = 0; i < Constants.SO_DAI_VAN; i++)
        {
            canIndex = (canIndex + nCan + direction) % nCan;
            chiIndex = (chiIndex + nChi + direction) % nChi;
            this.LaSoCuaToi.DaiVan.add(new Tru(TongHopCanChi.MuoiThienCan.get(canIndex), TongHopCanChi.MuoiHaiDiaChi.get(chiIndex)));
        }

        int _daiVanHienTai = 0;

        //populate ages
        if (age != Integer.MIN_VALUE)
        {
            for (int i = 0; i < Constants.SO_DAI_VAN; i++)
            {
                this.LaSoCuaToi.TuoiDaiVan.add(age);
                if (daiVanHienTai != Integer.MIN_VALUE && daiVanHienTai == age) _daiVanHienTai = age;
                age += Constants.NAM_DAI_VAN;
            }
        }

        this.DaiVanHienTai = this.LaSoCuaToi.DaiVan.get(_daiVanHienTai);

//        Tru cua Dai Van hien tai
//        if (daiVanHienTai != Integer.MIN_VALUE)
//        {
//            this.DaiVanHienTai = this.LaSoCuaToi.DaiVan.get(_daiVanHienTai);
//        }
//        else
//        {
//            this.DaiVanHienTai = this.LaSoCuaToi.DaiVan.get(0);
//        }

        this.LuuNien = LookUpTable.TruOfTheYear();
    }

    public void CreateDaiVan(){
        CreateDaiVan(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public void CreateTieuVan()
    {

        int direction = 1;

        if ((this.LaSoCuaToi.GioiTinh == GioiTinhEnum.Nam && this.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong == AmDuongEnum.Duong)
                || (this.LaSoCuaToi.GioiTinh == GioiTinhEnum.Nu && this.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong == AmDuongEnum.Am))
        {
            direction = 1;
        }
        else if ((this.LaSoCuaToi.GioiTinh == GioiTinhEnum.Nam && this.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong == AmDuongEnum.Am)
                || (this.LaSoCuaToi.GioiTinh == GioiTinhEnum.Nu && this.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong == AmDuongEnum.Duong))
        {
            direction = -1;
        }

        CanEnum canGio = this.LaSoCuaToi.TuTru.get(Constants.TRU_GIO).ThienCan.Can;
        ChiEnum chiGio = this.LaSoCuaToi.TuTru.get(Constants.TRU_GIO).DiaChi.Ten;

        int canIndex = TongHopCanChi.getIndexoOfThienCanByEnum(canGio);
        int chiIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(chiGio);

        int nCan = TongHopCanChi.MuoiThienCan.size();
        int nChi = TongHopCanChi.MuoiHaiDiaChi.size();

        // make sure TieuVan starts from 1 year-old.
        // index of the TieuVan list (from 1 onward) is the age of TieuVan.
        this.LaSoCuaToi.TieuVan.add(null);
        for (int i = 0; i < Constants.SO_DAI_VAN; i++)
        {
            canIndex = (canIndex + nCan + direction) % nCan;
            chiIndex = (chiIndex + nChi + direction) % nChi;
            this.LaSoCuaToi.TieuVan.add(new Tru(TongHopCanChi.MuoiThienCan.get(canIndex), TongHopCanChi.MuoiHaiDiaChi.get(chiIndex)));
        }


    }

    public void CreateCungMenh()
    {
        int thangIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(this.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).DiaChi.Ten);
        int gioIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(this.LaSoCuaToi.TuTru.get(Constants.TRU_GIO).DiaChi.Ten);
        thangIndex += Constants.CUNG_MENH_SHIFT;
        gioIndex += Constants.CUNG_MENH_SHIFT;

        int n = TongHopCanChi.MuoiHaiDiaChi.size();
        int soThang = thangIndex > 0 ? thangIndex : thangIndex + n;
        int soGio = gioIndex > 0 ? gioIndex : gioIndex + n;

        int sum = soThang + soGio;
        int soCungMenh;

        if (sum < Constants.CUNG_MENH_LOWER_BOUND)
        {
            soCungMenh = Constants.CUNG_MENH_LOWER_BOUND - sum;
        }
        else
        {
            soCungMenh = Constants.CUNG_MENH_UPPER_BOUND - sum;
        }

        int cungMenhIndex = (soCungMenh - Constants.CUNG_MENH_SHIFT + n) % n;
        DiaChi cungMenhChi = TongHopCanChi.MuoiHaiDiaChi.get(cungMenhIndex);

        Tru cungMenh = LookUpTable.NguHoDon(this.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.Can, cungMenhChi.Ten);

        switch (cungMenh.DiaChi.Ten)
        {
            case None:
                break;
            case Ti:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_QUY);
                break;
            case Suu:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_ACH);
                break;
            case Dan:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_QUYEN);
                break;
            case Mao:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_XICH);
                break;
            case Thin:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_NHU);
                break;
            case Ty:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_VAN);
                break;
            case Ngo:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_PHUC);
                break;
            case Mui:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_LAO);
                break;
            case Than:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_QUA);
                break;
            case Dau:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_BI);
                break;
            case Tuat:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_NGHE);
                break;
            case Hoi:
                cungMenh.AddThuocTinh(Constants.CungMenhSao.CUNG_MENH_SAO, Constants.CungMenhSao.THIEN_THO);
                break;
            default:
                break;
        }
        this.LaSoCuaToi.CungMenh = cungMenh;
        //this.LaSoCuaToi.TuTru.Add(Constants.CUNG_MENH, cungMenh);
    }

    public void CreateThaiNguyen()
    {
        int canThangIndex = TongHopCanChi.getIndexoOfThienCanByEnum(this.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).ThienCan.Can);
        int chiThangIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(this.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).DiaChi.Ten);

        int nCan = Constants.THIEN_CAN_SIZE; // TongHopCanChi.MuoiThienCan.size();
        int nChi = Constants.DIA_CHI_SIZE; // TongHopCanChi.MuoiHaiDiaChi.size();

        int thaiNguyenCanIndex = (canThangIndex + Constants.THAI_NGUYEN_CAN_SHIFT + nCan) % nCan;
        int thaiNguyenChiIndex = (chiThangIndex + Constants.THAI_NGUYEN_CHI_SHIFT + nChi) % nChi;

        Tru thaiNguyen = new Tru(TongHopCanChi.MuoiThienCan.get(thaiNguyenCanIndex), TongHopCanChi.MuoiHaiDiaChi.get(thaiNguyenChiIndex));
        this.LaSoCuaToi.ThaiNguyen = thaiNguyen;
        //this.LaSoCuaToi.TuTru.Add(Constants.THAI_NGUYEN, thaiNguyen);
    }

    /// <summary>
    /// Set Thap Than based on "can ngay"
    /// </summary>
    /// <param name="canNgay">to be based on</param>
    /// <param name="can">to set Thap Than property</param>
    public void SetThapThan(ThienCan canNgay, ThienCan can)
    {
        if (canNgay == null)
        {
            canNgay = this.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan;
        }

        NguHanhEnum[] sinhKhac = LookUpTable.NguHanhSinhKhac.get(canNgay.NguHanh);
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

    public void SetThapThan(){
        SetThapThan(null, null);
    }

    public void SetNapAm(Tru tru)
    {
        NguHanhEnum nguHanh = LookUpTable.NapAm.get(new Pair<>(tru.ThienCan.Can, tru.DiaChi.Ten));
        tru.AddThuocTinh(Constants.NAP_AM, nguHanh);
    }



}
