package com.vietbachle.bazi_tutru_lib.BusinessRules;

import com.vietbachle.bazi_tutru_lib.Data.CanEnum;
import com.vietbachle.bazi_tutru_lib.Data.ChiEnum;
import com.vietbachle.bazi_tutru_lib.Data.Constants;
import com.vietbachle.bazi_tutru_lib.Data.DiaChi;
import com.vietbachle.bazi_tutru_lib.Data.GiaiDoanTruongSinhEnum;
import com.vietbachle.bazi_tutru_lib.Data.NguHanhEnum;
import com.vietbachle.bazi_tutru_lib.Data.ThapThanEnum;
import com.vietbachle.bazi_tutru_lib.Data.TongHopCanChi;
import com.vietbachle.bazi_tutru_lib.Data.Tru;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vietbachle on 3/1/2017.
 */
public class TuTruMapTest {
    @Before
    public void setUp() throws Exception {
        TongHopCanChi.Init();
        LookUpTable.Init();
    }

    @Test
    public void Check_CreateTuTru_NotNull()
    {
        String canNam = "Ky", chiNam = "Ty", canThang = "Dinh", chiThang = "Suu",
                canNgay = "Nham", chiNgay = "Than", canGio = "At", chiGio = "Ty",
                gt = "Nam";
        TuTruMap mybiz = new TuTruMap();
        mybiz.CreateTuTru(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio);

        assertNotNull(mybiz.LaSoCuaToi);
    }

    @Test
    public void Check_CreateTuTru_Null()
    {
        String canNam = "", chiNam = "Ty", canThang = "Dinh", chiThang = "Suu",
                canNgay = "Nham", chiNgay = "Than", canGio = "At", chiGio = "Ty",
                gt = "Nu";
        TuTruMap mybiz = new TuTruMap();
        mybiz.CreateTuTru(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio);

        assertNull(mybiz.LaSoCuaToi);
    }

    @Test
    public void Check_CreateDaiVan_AmNu()
    {
        String canNam = "Ky", chiNam = "Ty", canThang = "Dinh", chiThang = "Suu",
                canNgay = "Nham", chiNgay = "Than", canGio = "At", chiGio = "Ty",
                gt = "Nu";
        int tuoi = 9;
        TuTruMap mybiz = new TuTruMap();
        mybiz.CreateTuTru(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio);
        mybiz.CreateDaiVan(tuoi);
        CanEnum can = mybiz.LaSoCuaToi.DaiVan.get(4).ThienCan.Can;
        ChiEnum chi = mybiz.LaSoCuaToi.DaiVan.get(4).DiaChi.Ten;
        int t = mybiz.LaSoCuaToi.TuoiDaiVan.get(4);
        assertEquals(CanEnum.Nham, can);
        assertEquals(ChiEnum.Ngo, chi);
        assertEquals(49, t);
    }

    @Test
    public void Check_CreateDaiVan_AmNam()
    {
        String canNam = "Dinh", chiNam = "Mao", canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui", canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4;
        TuTruMap mybiz = new TuTruMap();
        mybiz.CreateTuTru(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio);
        mybiz.CreateDaiVan(tuoi);
        CanEnum can = mybiz.LaSoCuaToi.DaiVan.get(4).ThienCan.Can;
        ChiEnum chi = mybiz.LaSoCuaToi.DaiVan.get(4).DiaChi.Ten;
        int t = mybiz.LaSoCuaToi.TuoiDaiVan.get(4);
        assertEquals(CanEnum.Mau, can);
        assertEquals(ChiEnum.Than, chi);
        assertEquals(44, t);
    }

    @Test
    public void Check_CreateCungMenh_AmNam()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4;
        TuTruMap mybiz = new TuTruMap();
        mybiz.CreateTuTru(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio);
        mybiz.CreateDaiVan(tuoi);
        mybiz.CreateCungMenh();
        assertEquals(CanEnum.At, mybiz.LaSoCuaToi.CungMenh.ThienCan.Can);
        assertEquals(ChiEnum.Ty, mybiz.LaSoCuaToi.CungMenh.DiaChi.Ten);

    }

    @Test
    public void Check_CreateThaiNguyen_AmNam()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4;
        TuTruMap mybiz = new TuTruMap();
        mybiz.CreateTuTru(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio);
        mybiz.CreateDaiVan(tuoi);
        mybiz.CreateThaiNguyen();
        assertEquals(CanEnum.Giap, mybiz.LaSoCuaToi.ThaiNguyen.ThienCan.Can);
        assertEquals(ChiEnum.Thin, mybiz.LaSoCuaToi.ThaiNguyen.DiaChi.Ten);
    }

    @Test
    public void Check_InitLaSo_AmNam()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi);

        Tru truNam = mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NAM);
        Tru truThang = mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_THANG);
        Tru truNgay = mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY);
        Tru truGio = mybiz.LaSoCuaToi.TuTru.get(Constants.TRU_GIO);
        Tru cungMenh = mybiz.LaSoCuaToi.CungMenh;
        Tru thaiNguyen = mybiz.LaSoCuaToi.ThaiNguyen;
        Tru tru44 = mybiz.LaSoCuaToi.DaiVan.get(4);

        // check Thap Than
        assertEquals(ThapThanEnum.ThienQuan, truNam.ThienCan.ThapThan);
        assertEquals(ThapThanEnum.ThucThan, truThang.ThienCan.ThapThan);
        assertEquals(ThapThanEnum.ThienAn, truGio.ThienCan.ThapThan);
        assertEquals(ThapThanEnum.ThienTai, truNgay.DiaChi.TapKhi.ThapThan);

        assertEquals(ThapThanEnum.ChinhTai, thaiNguyen.ThienCan.ThapThan);
        assertEquals(ThapThanEnum.ChinhQuan, cungMenh.DiaChi.BanKhi.ThapThan);

        // check Nap Am
        assertEquals(NguHanhEnum.Hoa, (NguHanhEnum)cungMenh.ThuocTinh.get(Constants.NAP_AM));
        assertEquals(NguHanhEnum.Moc, (NguHanhEnum)truGio.ThuocTinh.get(Constants.NAP_AM));

        // check Vong Truong Sinh
        assertEquals(GiaiDoanTruongSinhEnum.DeVuong, (GiaiDoanTruongSinhEnum)tru44.ThuocTinh.get(Constants.VONG_TRUONG_SINH));

        assertEquals(GiaiDoanTruongSinhEnum.Mo, (GiaiDoanTruongSinhEnum)thaiNguyen.ThuocTinh.get(Constants.VONG_TRUONG_SINH));

        // check Cung Menh Sao
        assertEquals(Constants.CungMenhSao.THIEN_VAN, (String)cungMenh.ThuocTinh.get(Constants.CungMenhSao.CUNG_MENH_SAO));
    }


//    #region Dia Chi Luc Hop
    @Test
    public void Check_LucHop_Tho1()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 4;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi ti = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti);
        DiaChi suu = TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu);

        assertTrue(ti.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_KHAC));
        assertTrue(((NguHanhEnum)ti.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_KHAC)) == NguHanhEnum.Tho);

        assertTrue(suu.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_KHAC));
        assertTrue(((NguHanhEnum)suu.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_KHAC)) == NguHanhEnum.Tho);
    }

    @Test
    public void Check_LucHop_Tho2()
    {
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

        DiaChi ngo = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo);
        DiaChi mui = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui);

        assertTrue(ngo.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_SINH));
        assertTrue(((NguHanhEnum)ngo.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_SINH)) == NguHanhEnum.Tho);

        assertTrue(mui.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_SINH));
        assertTrue(((NguHanhEnum)mui.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_SINH)) == NguHanhEnum.Tho);
    }

    @Test
    public void Check_LucHop_Moc()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 4;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.TatcaTru.add(LookUpTable.TruOfTheYear(2010));
        dclh.setAllLaws();

        DiaChi dan = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan);
        DiaChi hoi = TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi);

        assertTrue(dan.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_SINH));
        assertTrue(((NguHanhEnum)dan.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_SINH)) == NguHanhEnum.Moc);

        assertTrue(hoi.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_SINH));
        assertTrue(((NguHanhEnum)hoi.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_SINH)) == NguHanhEnum.Moc);
    }

    @Test
    public void Check_LucHop_Hoa()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 24;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi mao = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao);
        DiaChi tuat = TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat);

        assertTrue(mao.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_KHAC));
        assertTrue(((NguHanhEnum)mao.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_KHAC)) == NguHanhEnum.Hoa);

        assertTrue(tuat.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_KHAC));
        assertTrue(((NguHanhEnum)tuat.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_KHAC)) == NguHanhEnum.Hoa);
    }

    @Test
    public void Check_LucHop_Kim()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 34;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi thin = TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin);
        DiaChi dau = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau);

        assertTrue(thin.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_SINH));
        assertTrue(((NguHanhEnum)thin.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_SINH)) == NguHanhEnum.Kim);

        assertTrue(dau.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_SINH));
        assertTrue(((NguHanhEnum)dau.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_SINH)) == NguHanhEnum.Kim);
    }

    @Test
    public void Check_LucHop_Thuy()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi ty = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty);
        DiaChi than = TongHopCanChi.getDiaChiByEnum(ChiEnum.Than);

        assertTrue(ty.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_KHAC));
        assertTrue(((NguHanhEnum)ty.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_KHAC)) == NguHanhEnum.Thuy);

        assertTrue(than.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HOP_KHAC));
        assertTrue(((NguHanhEnum)than.ThuocTinh.get(Constants.ThuocTinh.LUC_HOP_KHAC)) == NguHanhEnum.Thuy);
    }

//    #endregion Dia Chi Luc Hop


//    #region Dia Chi Tam Hoi
    @Test
    public void Check_TamHoi_DanMaoThin()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Binh", chiThang = "Dan",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Nham", chiGio = "Thin",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi dan = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan);
        DiaChi mao = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao);
        DiaChi thin = TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin);

        assertTrue(dan.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)dan.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Moc);

        assertTrue(mao.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)mao.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Moc);

        assertTrue(thin.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)thin.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Moc);
    }

    @Test
    public void Check_TamHoi_TyNgoMui()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Binh", chiThang = "Ngo",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Ty",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi ty = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty);
        DiaChi ngo = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo);
        DiaChi mui = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui);

        assertTrue(ty.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)ty.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Hoa);

        assertTrue(ngo.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)ngo.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Hoa);

        assertTrue(mui.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)mui.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Hoa);
    }

    @Test
    public void Check_TamHoi_ThanDauTuat()
    {
        String canNam = "Dinh", chiNam = "Dau",
                canThang = "Binh", chiThang = "Than",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Canh", chiGio = "Tuat",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi than = TongHopCanChi.getDiaChiByEnum(ChiEnum.Than);
        DiaChi dau = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau);
        DiaChi tuat = TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat);

        assertTrue(than.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)than.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Kim);

        assertTrue(dau.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)dau.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Kim);

        assertTrue(tuat.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)tuat.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Kim);
    }

    @Test
    public void Check_TamHoi_HoiTiSuu()
    {
        String canNam = "Dinh", chiNam = "Hoi",
                canThang = "Binh", chiThang = "Ti",
                canNgay = "Tan", chiNgay = "Suu",
                canGio = "Canh", chiGio = "Tuat",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi hoi = TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi);
        DiaChi ti = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti);
        DiaChi suu = TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu);

        assertTrue(hoi.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)hoi.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Thuy);

        assertTrue(ti.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)ti.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Thuy);

        assertTrue(suu.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOI));
        assertTrue(((NguHanhEnum)suu.ThuocTinh.get(Constants.ThuocTinh.TAM_HOI)) == NguHanhEnum.Thuy);
    }

//    #endregion Dia Chi Tam Hoi

//    #region Dia Chi Tam Hop
    @Test
    public void Check_TamHop_DanNgoTuat()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Binh", chiThang = "Dan",
                canNgay = "Canh", chiNgay = "Tuat",
                canGio = "Nham", chiGio = "Ngo",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi dan = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan);
        DiaChi ngo = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo);
        DiaChi tuat = TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat);

        assertTrue(dan.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)dan.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Hoa);

        assertTrue(ngo.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)ngo.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Hoa);

        assertTrue(tuat.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)tuat.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Hoa);
    }

    @Test
    public void Check_TamHop_TyDauSuu()
    {
        String canNam = "Dinh", chiNam = "Suu",
                canThang = "Binh", chiThang = "Ngo",
                canNgay = "Tan", chiNgay = "Dau",
                canGio = "Ky", chiGio = "Ty",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi ty = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty);
        DiaChi dau = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau);
        DiaChi suu = TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu);

        assertTrue(ty.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)ty.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Kim);

        assertTrue(dau.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)dau.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Kim);

        assertTrue(suu.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)suu.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Kim);
    }

    @Test
    public void Check_TamHop_ThanTiThin()
    {
        String canNam = "Binh", chiNam = "Ti",
                canThang = "Binh", chiThang = "Than",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Canh", chiGio = "Thin",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi than = TongHopCanChi.getDiaChiByEnum(ChiEnum.Than);
        DiaChi ti = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti);
        DiaChi thin = TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin);

        assertTrue(than.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)than.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Thuy);

        assertTrue(ti.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)ti.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Thuy);

        assertTrue(thin.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)thin.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Thuy);
    }

    @Test
    public void Check_TamHop_HoiMaoMui()
    {
        String canNam = "Dinh", chiNam = "Hoi",
                canThang = "Binh", chiThang = "Ti",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Mao",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi hoi = TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi);
        DiaChi mao = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao);
        DiaChi mui = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui);

        assertTrue(hoi.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)hoi.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Moc);

        assertTrue(mao.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)mao.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Moc);

        assertTrue(mui.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HOP));
        assertTrue(((NguHanhEnum)mui.ThuocTinh.get(Constants.ThuocTinh.TAM_HOP)) == NguHanhEnum.Moc);
    }

//    #endregion Dia Chi Tam Hop


//    #region Dia Chi Luc Xung
    @Test
    public void Check_LucXung_TiNgo()
    {
        String canNam = "Binh", chiNam = "Ti",
                canThang = "Canh", chiThang = "Ngo",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclx = new InteractionLaws(mybiz);
        dclx.setAllLaws();

        DiaChi ti = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti);
        DiaChi ngo = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo);

        assertTrue(ti.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(ti.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.TI_NGO);

        assertTrue(ngo.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(ngo.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.TI_NGO);
    }

    @Test
    public void Check_LucXung_SuuMui()
    {
        String canNam = "Binh", chiNam = "Ti",
                canThang = "Ky", chiThang = "Suu",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclx = new InteractionLaws(mybiz);
        dclx.setAllLaws();

        DiaChi suu = TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu);
        DiaChi mui = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui);

        assertTrue(suu.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(suu.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.SUU_MUI);

        assertTrue(mui.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(mui.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.SUU_MUI);
    }

    @Test
    public void Check_LucXung_DanThan()
    {
        String canNam = "Binh", chiNam = "Dan",
                canThang = "Ky", chiThang = "Suu",
                canNgay = "Nham", chiNgay = "Than",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclx = new InteractionLaws(mybiz);
        dclx.setAllLaws();

        DiaChi dan = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan);
        DiaChi than = TongHopCanChi.getDiaChiByEnum(ChiEnum.Than);

        assertTrue(dan.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(dan.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.DAN_THAN);

        assertTrue(than.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(than.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.DAN_THAN);
    }

    @Test
    public void Check_LucXung_MaoDau()
    {
        String canNam = "Dinh", chiNam = "Mao",
                canThang = "Ky", chiThang = "Suu",
                canNgay = "Nham", chiNgay = "Than",
                canGio = "Dinh", chiGio = "Dau",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclx = new InteractionLaws(mybiz);
        dclx.setAllLaws();

        DiaChi mao = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao);
        DiaChi dau = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau);

        assertTrue(mao.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(mao.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.MAO_DAU);

        assertTrue(dau.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(dau.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.MAO_DAU);
    }

    @Test
    public void Check_LucXung_ThinTuat()
    {
        String canNam = "Binh", chiNam = "Dan",
                canThang = "Ky", chiThang = "Suu",
                canNgay = "Nham", chiNgay = "Thin",
                canGio = "Canh", chiGio = "Tuat",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclx = new InteractionLaws(mybiz);
        dclx.setAllLaws();

        DiaChi thin = TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin);
        DiaChi tuat = TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat);

        assertTrue(thin.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(thin.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.THIN_TUAT);

        assertTrue(tuat.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(tuat.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.THIN_TUAT);
    }

    @Test
    public void Check_LucXung_TyHoi()
    {
        String canNam = "Binh", chiNam = "Dan",
                canThang = "Quy", chiThang = "Ty",
                canNgay = "Nham", chiNgay = "Than",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclx = new InteractionLaws(mybiz);
        dclx.setAllLaws();

        DiaChi ty = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty);
        DiaChi hoi = TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi);

        assertTrue(ty.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(ty.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.TY_HOI);

        assertTrue(hoi.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_XUNG));
        assertTrue(hoi.ThuocTinh.get(Constants.ThuocTinh.LUC_XUNG) == Constants.DiaChiLucXung.TY_HOI);
    }

//    #endregion Dia Chi Luc Xung

//    #region Dia Chi Luc Hai
    @Test
    public void Check_LucHai_TiMui()
    {
        String canNam = "Binh", chiNam = "Ti",
                canThang = "Canh", chiThang = "Ngo",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi ti = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti);
        DiaChi mui = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui);

        assertTrue(ti.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(ti.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.TI_MUI);

        assertTrue(mui.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(mui.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.TI_MUI);
    }

    @Test
    public void Check_LucHai_SuuNgo()
    {
        String canNam = "Binh", chiNam = "Ti",
                canThang = "Ky", chiThang = "Suu",
                canNgay = "Canh", chiNgay = "Ngo",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi suu = TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu);
        DiaChi ngo = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo);

        assertTrue(suu.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(suu.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.SUU_NGO);

        assertTrue(ngo.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(ngo.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.SUU_NGO);
    }

    @Test
    public void Check_LucHai_MaoThin()
    {
        String canNam = "Ky", chiNam = "Mao",
                canThang = "Ky", chiThang = "Suu",
                canNgay = "Nham", chiNgay = "Thin",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi mao = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao);
        DiaChi thin = TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin);

        assertTrue(mao.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(mao.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.MAO_THIN);

        assertTrue(thin.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(thin.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.MAO_THIN);
    }

    @Test
    public void Check_LucHai_TyDan()
    {
        String canNam = "Dinh", chiNam = "Ty",
                canThang = "Ky", chiThang = "Suu",
                canNgay = "Nham", chiNgay = "Dan",
                canGio = "Dinh", chiGio = "Dau",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi ty = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty);
        DiaChi dan = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan);

        assertTrue(ty.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(ty.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.DAN_TY);

        assertTrue(dan.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(dan.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.DAN_TY);
    }

    @Test
    public void Check_LucHai_DauTuat()
    {
        String canNam = "Binh", chiNam = "Dan",
                canThang = "Ky", chiThang = "Dau",
                canNgay = "Nham", chiNgay = "Thin",
                canGio = "Canh", chiGio = "Tuat",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi dau = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau);
        DiaChi tuat = TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat);

        assertTrue(dau.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(dau.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.DAU_TUAT);

        assertTrue(tuat.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(tuat.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.DAU_TUAT);
    }

    @Test
    public void Check_LucHai_ThanHoi()
    {
        String canNam = "Binh", chiNam = "Than",
                canThang = "Quy", chiThang = "Ty",
                canNgay = "Nham", chiNgay = "Than",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dclh = new InteractionLaws(mybiz);
        dclh.setAllLaws();

        DiaChi than = TongHopCanChi.getDiaChiByEnum(ChiEnum.Than);
        DiaChi hoi = TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi);

        assertTrue(than.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(than.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.THAN_HOI);

        assertTrue(hoi.ThuocTinh.containsKey(Constants.ThuocTinh.LUC_HAI));
        assertTrue(hoi.ThuocTinh.get(Constants.ThuocTinh.LUC_HAI) == Constants.DiaChiLucHai.THAN_HOI);
    }

//    #endregion Dia Chi Luc Hai

//    #region Dia Chi Tu Hinh
    @Test
    public void Check_TuHinh_Thin()
    {
        String canNam = "Nham", chiNam = "Thin",
                canThang = "Giap", chiThang = "Thin",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        Tru thin = null; //mybiz.LaSoCuaToi.TuTru.Values.ToList<Tru>().Find(u => u.DiaChi.Ten == ChiEnum.Thin);
        for (Tru tru : mybiz.LaSoCuaToi.TuTru.values()){
            if (tru.DiaChi.Ten == ChiEnum.Thin) thin = tru;
        }

        assertTrue(thin.ThuocTinh.containsKey(Constants.ThuocTinh.TU_HINH));
        assertTrue(thin.ThuocTinh.get(Constants.ThuocTinh.TU_HINH) == Constants.DiaChiTuongHinh.TU_HINH);

    }

    @Test
    public void Check_TuHinh_Thin_False()
    {
        String canNam = "Nham", chiNam = "Thin",
                canThang = "Tan", chiThang = "Mui",
                canNgay = "Giap", chiNgay = "Thin",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        Tru thin = null; //mybiz.LaSoCuaToi.TuTru.Values.ToList<Tru>().Find(u => u.DiaChi.Ten == ChiEnum.Thin);
        for (Tru tru : mybiz.LaSoCuaToi.TuTru.values()){
            if (tru.DiaChi.Ten == ChiEnum.Thin) thin = tru;
        }


        assertFalse(thin.ThuocTinh.containsKey(Constants.ThuocTinh.TU_HINH));
    }

    @Test
    public void Check_TuHinh_Ngo()
    {
        String canNam = "Nham", chiNam = "Thin",
                canThang = "Giap", chiThang = "Thin",
                canNgay = "Binh", chiNgay = "Ngo",
                canGio = "Mau", chiGio = "Ngo",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

//        DiaChi ngo = mybiz.LaSoCuaToi.TuTru.Values.ToList<Tru>().Find(u => u.DiaChi.Ten == ChiEnum.Ngo);
        Tru ngo = null;
        for (Tru tru : mybiz.LaSoCuaToi.TuTru.values()){
            if (tru.DiaChi.Ten == ChiEnum.Ngo) ngo = tru;
        }

        assertTrue(ngo.ThuocTinh.containsKey(Constants.ThuocTinh.TU_HINH));
        assertTrue(ngo.ThuocTinh.get(Constants.ThuocTinh.TU_HINH) == Constants.DiaChiTuongHinh.TU_HINH);
    }

    @Test
    public void Check_TuHinh_Ngo_False()
    {
        String canNam = "Mau", chiNam = "Ngo",
                canThang = "Giap", chiThang = "Thin",
                canNgay = "Binh", chiNgay = "Ngo",
                canGio = "Nham", chiGio = "Thin",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

//        DiaChi ngo = mybiz.LaSoCuaToi.TuTru.Values.ToList<Tru>().Find(u => u.DiaChi.Ten == ChiEnum.Ngo);
        Tru ngo = null;
        for (Tru tru : mybiz.LaSoCuaToi.TuTru.values()){
            if (tru.DiaChi.Ten == ChiEnum.Ngo) ngo = tru;
        }

        assertFalse(ngo.ThuocTinh.containsKey(Constants.ThuocTinh.TU_HINH));
    }

    @Test
    public void Check_TuHinh_Dau()
    {
        String canNam = "Nham", chiNam = "Thin",
                canThang = "Giap", chiThang = "Thin",
                canNgay = "Tan", chiNgay = "Dau",
                canGio = "Ky", chiGio = "Dau",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        Tru dau = null;
        for (Tru tru : mybiz.LaSoCuaToi.TuTru.values()){
            if (tru.DiaChi.Ten == ChiEnum.Dau) dau = tru;
        }

        assertTrue(dau.ThuocTinh.containsKey(Constants.ThuocTinh.TU_HINH));
        assertTrue(dau.ThuocTinh.get(Constants.ThuocTinh.TU_HINH) == Constants.DiaChiTuongHinh.TU_HINH);
    }

    @Test
    public void Check_TuHinh_Dau_False()
    {
        String canNam = "Tan", chiNam = "Dau",
                canThang = "Giap", chiThang = "Thin",
                canNgay = "Tan", chiNgay = "Dau",
                canGio = "Nham", chiGio = "Thin",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        Tru dau = null;
        for (Tru tru : mybiz.LaSoCuaToi.TuTru.values()){
            if (tru.DiaChi.Ten == ChiEnum.Dau) dau = tru;
        }

        assertFalse(dau.ThuocTinh.containsKey(Constants.ThuocTinh.TU_HINH));
    }

    @Test
    public void Check_TuHinh_Hoi()
    {
        String canNam = "Nham", chiNam = "Thin",
                canThang = "Quy", chiThang = "Hoi",
                canNgay = "Tan", chiNgay = "Hoi",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        Tru hoi = null;
        for (Tru tru : mybiz.LaSoCuaToi.TuTru.values()){
            if (tru.DiaChi.Ten == ChiEnum.Hoi) hoi = tru;
        }

        assertTrue(hoi.ThuocTinh.containsKey(Constants.ThuocTinh.TU_HINH));
        assertTrue(hoi.ThuocTinh.get(Constants.ThuocTinh.TU_HINH) == Constants.DiaChiTuongHinh.TU_HINH);

    }

    @Test
    public void Check_TuHinh_Hoi_False()
    {
        String canNam = "Nham", chiNam = "Thin",
                canThang = "Quy", chiThang = "Hoi",
                canNgay = "Tan", chiNgay = "Mui",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        Tru hoi = null;
        for (Tru tru : mybiz.LaSoCuaToi.TuTru.values()){
            if (tru.DiaChi.Ten == ChiEnum.Hoi) hoi = tru;
        }

        assertFalse(hoi.ThuocTinh.containsKey(Constants.ThuocTinh.TU_HINH));
    }

//    #endregion Dia Chi Tu Hinh

//    #region Dia Chi Nhi Hinh
    @Test
    public void Check_NhiHinh_TiMao()
    {
        String canNam = "Nham", chiNam = "Ti",
                canThang = "Quy", chiThang = "Hoi",
                canNgay = "Dinh", chiNgay = "Mao",
                canGio = "Ky", chiGio = "Hoi",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        DiaChi ti = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti);

        DiaChi mao = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao);

        assertTrue(ti.ThuocTinh.containsKey(Constants.ThuocTinh.NHI_HINH));
        assertTrue(ti.ThuocTinh.get(Constants.ThuocTinh.NHI_HINH) == Constants.DiaChiTuongHinh.NHI_HINH);

        assertTrue(mao.ThuocTinh.containsKey(Constants.ThuocTinh.NHI_HINH));
        assertTrue(mao.ThuocTinh.get(Constants.ThuocTinh.NHI_HINH) == Constants.DiaChiTuongHinh.NHI_HINH);

    }
//    #endregion Dia Chi Nhi Hinh

//    #region Dia Chi Tam Hinh
    @Test
    public void Check_TamHinh_DanTyThan()
    {
        String canNam = "Nham", chiNam = "Dan",
                canThang = "Quy", chiThang = "Hoi",
                canNgay = "Dinh", chiNgay = "Ty",
                canGio = "Canh", chiGio = "Than",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        DiaChi dan = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan);

        DiaChi than = TongHopCanChi.getDiaChiByEnum(ChiEnum.Than);

        DiaChi ty = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty);

        assertTrue(dan.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HINH));
        assertTrue(dan.ThuocTinh.get(Constants.ThuocTinh.TAM_HINH) == Constants.DiaChiTuongHinh.DAN_TY_THAN);

        assertTrue(than.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HINH));
        assertTrue(than.ThuocTinh.get(Constants.ThuocTinh.TAM_HINH) == Constants.DiaChiTuongHinh.DAN_TY_THAN);

        assertTrue(ty.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HINH));
        assertTrue(ty.ThuocTinh.get(Constants.ThuocTinh.TAM_HINH) == Constants.DiaChiTuongHinh.DAN_TY_THAN);
    }

    @Test
    public void Check_TamHinh_SuuTuatMui()
    {
        String canNam = "Nham", chiNam = "Tuat",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Dinh", chiNgay = "Mui",
                canGio = "Canh", chiGio = "Than",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        DiaChi suu = TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu);

        DiaChi tuat = TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat);

        DiaChi mui = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui);

        assertTrue(suu.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HINH));
        assertTrue(suu.ThuocTinh.get(Constants.ThuocTinh.TAM_HINH) == Constants.DiaChiTuongHinh.SUU_TUAT_MUI);

        assertTrue(tuat.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HINH));
        assertTrue(tuat.ThuocTinh.get(Constants.ThuocTinh.TAM_HINH) == Constants.DiaChiTuongHinh.SUU_TUAT_MUI);

        assertTrue(mui.ThuocTinh.containsKey(Constants.ThuocTinh.TAM_HINH));
        assertTrue(mui.ThuocTinh.get(Constants.ThuocTinh.TAM_HINH) == Constants.DiaChiTuongHinh.SUU_TUAT_MUI);
    }
//    #endregion Dia Chi Tam Hinh

//    #region Dia Chi Tuong Lien
    @Test
    public void Check_TuongLien_TamTi()
    {
        String canNam = "Nham", chiNam = "Ti",
                canThang = "Quy", chiThang = "Suu",
                canNgay = "Mau", chiNgay = "Ti",
                canGio = "Canh", chiGio = "Ti",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        DiaChi ti = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti);

        assertTrue(ti.ThuocTinh.containsKey(Constants.ThuocTinh.TUONG_LIEN));
        assertTrue(ti.ThuocTinh.get(Constants.ThuocTinh.TUONG_LIEN) == Constants.DiaChiTuongLien.TAM_TI);
    }

    @Test
    public void Check_TuongLien_TamHoi()
    {
        String canNam = "Quy", chiNam = "Hoi",
                canThang = "Dinh", chiThang = "Hoi",
                canNgay = "Tan", chiNgay = "Hoi",
                canGio = "Canh", chiGio = "Ti",
                gt = "Nam";
        int tuoi = 4, tuoiDV = 44;
        TuTruMap mybiz = new TuTruMap();
        mybiz.InitLaSo(gt, canNam, chiNam, canThang, chiThang, canNgay, chiNgay, canGio, chiGio, tuoi, tuoiDV);

        InteractionLaws dcth = new InteractionLaws(mybiz);
        dcth.setAllLaws();

        DiaChi hoi = TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi);

        assertTrue(hoi.ThuocTinh.containsKey(Constants.ThuocTinh.TUONG_LIEN));
        assertTrue(hoi.ThuocTinh.get(Constants.ThuocTinh.TUONG_LIEN) == Constants.DiaChiTuongLien.TAM_HOI);
    }

//    #endregion Dia Chi Tuong Lien




}