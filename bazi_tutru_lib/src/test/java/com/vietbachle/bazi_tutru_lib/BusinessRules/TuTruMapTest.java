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



}