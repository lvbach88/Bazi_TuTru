package com.vietbachle.bazi_tutru_lib.BusinessRules;

import org.javatuples.Pair;

import com.vietbachle.bazi_tutru_lib.Data.CanEnum;
import com.vietbachle.bazi_tutru_lib.Data.ChiEnum;
import com.vietbachle.bazi_tutru_lib.Data.GiaiDoanTruongSinhEnum;
import com.vietbachle.bazi_tutru_lib.Data.NguHanhEnum;
import com.vietbachle.bazi_tutru_lib.Data.TongHopCanChi;
import com.vietbachle.bazi_tutru_lib.Data.Tru;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by vietbachle on 2/27/2017.
 */
public class LookUpTableTest {

    @Before
    public void init() {
        TongHopCanChi.Init();
        LookUpTable.Init();
    }

    //    #region Nap Am
    @Test
    public void Check_NapAm_DinhMao() throws Exception {
//        NguHanhEnum nguHanh;
//
//        LookUpTable.NapAm.TryGetValue(new Tuple<CanEnum, ChiEnum>(CanEnum.Dinh, ChiEnum.Mao), out nguHanh);
//
//        Assert.AreEqual<NguHanhEnum>(NguHanhEnum.Hoa, nguHanh);
        NguHanhEnum nguHanh = LookUpTable.NapAm.get(new Pair<>(CanEnum.Dinh, ChiEnum.Mao));
        assertEquals(NguHanhEnum.Hoa, nguHanh);
    }

    @Test
    public void Check_NapAm_QuySuu() throws Exception {
//        NguHanhEnum nguHanh;
//
//        LookUpTable.NapAm.TryGetValue(new Tuple<CanEnum, ChiEnum>(CanEnum.Quy, ChiEnum.Suu), out nguHanh);
//
//        Assert.AreEqual<NguHanhEnum>(NguHanhEnum.Moc, nguHanh);
        NguHanhEnum nguHanh = LookUpTable.NapAm.get(new Pair<>(CanEnum.Quy, ChiEnum.Suu));
        assertEquals(NguHanhEnum.Moc, nguHanh);
    }

    @Test
    public void Check_NapAm_TanMui() throws Exception {
//        NguHanhEnum nguHanh;
//
//        LookUpTable.NapAm.TryGetValue(new Tuple<CanEnum, ChiEnum>(CanEnum.Tan, ChiEnum.Mui), out nguHanh);
//
//        Assert.AreEqual<NguHanhEnum>(NguHanhEnum.Tho, nguHanh);
        NguHanhEnum nguHanh = LookUpTable.NapAm.get(new Pair<>(CanEnum.Tan, ChiEnum.Mui));
        assertEquals(NguHanhEnum.Tho, nguHanh);
    }

    @Test
    public void Check_NapAm_KyHoi() throws Exception {
//        NguHanhEnum nguHanh;
//
//        LookUpTable.NapAm.TryGetValue(new Tuple<CanEnum, ChiEnum>(CanEnum.Ky, ChiEnum.Hoi), out nguHanh);
//
//        Assert.AreEqual<NguHanhEnum>(NguHanhEnum.Moc, nguHanh);
        NguHanhEnum nguHanh = LookUpTable.NapAm.get(new Pair<>(CanEnum.Ky, ChiEnum.Hoi));
        assertEquals(NguHanhEnum.Moc, nguHanh);
    }
//    #endregion Nap Am

    //    #region Vong Truong Sinh
    @Test
    public void Check_VongTruongSinh_Giap_Ty() throws Exception {
        GiaiDoanTruongSinhEnum ts = LookUpTable.VongTruongSinh(CanEnum.Giap, ChiEnum.Ty);

        assertEquals(GiaiDoanTruongSinhEnum.Benh, ts);

    }

    @Test
    public void Check_VongTruongSinh_Dinh_Suu() throws Exception {
        GiaiDoanTruongSinhEnum ts = LookUpTable.VongTruongSinh(CanEnum.Dinh, ChiEnum.Suu);

        assertEquals(GiaiDoanTruongSinhEnum.Mo, ts);
    }

    @Test
    public void Check_VongTruongSinh_Canh_Mui() throws Exception {
        GiaiDoanTruongSinhEnum ts = LookUpTable.VongTruongSinh(CanEnum.Canh, ChiEnum.Mui);

        assertEquals(GiaiDoanTruongSinhEnum.QuanDoi, ts);
    }

    @Test
    public void Check_VongTruongSinh_Nham_Ti() throws Exception {
        GiaiDoanTruongSinhEnum ts = LookUpTable.VongTruongSinh(CanEnum.Nham, ChiEnum.Ti);

        assertEquals(GiaiDoanTruongSinhEnum.DeVuong, ts);
    }
//    #endregion Vong Truong Sinh

    //    #region Ngu Ho Don
    @Test
    public void Check_NguHoDon_Giap_Mao() throws Exception {
        Tru tru = LookUpTable.NguHoDon(CanEnum.Giap, ChiEnum.Mao);

        assertEquals(CanEnum.Dinh, tru.ThienCan.Can);
        assertEquals(ChiEnum.Mao, tru.DiaChi.Ten);
    }

    @Test
    public void Check_NguHoDon_At_Than() throws Exception {
        Tru tru = LookUpTable.NguHoDon(CanEnum.At, ChiEnum.Than);

        assertEquals(CanEnum.Giap, tru.ThienCan.Can);
        assertEquals(ChiEnum.Than, tru.DiaChi.Ten);
    }

    @Test
    public void Check_NguHoDon_Binh_Suu() throws Exception {
        Tru tru = LookUpTable.NguHoDon(CanEnum.Binh, ChiEnum.Suu);

        assertEquals(CanEnum.Tan, tru.ThienCan.Can);
        assertEquals(ChiEnum.Suu, tru.DiaChi.Ten);
    }

    @Test
    public void Check_NguHoDon_Dinh_Dan() throws Exception {
        Tru tru = LookUpTable.NguHoDon(CanEnum.Dinh, ChiEnum.Dan);

        assertEquals(CanEnum.Nham, tru.ThienCan.Can);
        assertEquals(ChiEnum.Dan, tru.DiaChi.Ten);
    }

    @Test
    public void Check_NguHoDon_Mau_Hoi() throws Exception {
        Tru tru = LookUpTable.NguHoDon(CanEnum.Mau, ChiEnum.Hoi);

        assertEquals(CanEnum.Quy, tru.ThienCan.Can);
        assertEquals(ChiEnum.Hoi, tru.DiaChi.Ten);
    }
//    #endregion Ngu Ho Don


//    #region Ngu Thu Don
    @Test
    public void Check_NguThuDon_Giap_Mao() throws Exception
    {
        Tru tru = LookUpTable.NguThuDon(CanEnum.Giap, ChiEnum.Mao);

        assertEquals(CanEnum.Dinh, tru.ThienCan.Can);
        assertEquals(ChiEnum.Mao, tru.DiaChi.Ten);
    }

    @Test
    public void Check_NguThuDon_At_Than() throws Exception
    {
        Tru tru = LookUpTable.NguThuDon(CanEnum.At, ChiEnum.Than);

        assertEquals(CanEnum.Giap, tru.ThienCan.Can);
        assertEquals(ChiEnum.Than, tru.DiaChi.Ten);
    }

    @Test
    public void Check_NguThuDon_Binh_Suu() throws Exception
    {
        Tru tru = LookUpTable.NguThuDon(CanEnum.Binh, ChiEnum.Suu);

        assertEquals(CanEnum.Ky, tru.ThienCan.Can);
        assertEquals(ChiEnum.Suu, tru.DiaChi.Ten);
    }

    @Test
    public void Check_NguThuDon_Dinh_Dan() throws Exception
    {
        Tru tru = LookUpTable.NguThuDon(CanEnum.Dinh, ChiEnum.Dan);

        assertEquals(CanEnum.Nham, tru.ThienCan.Can);
        assertEquals(ChiEnum.Dan, tru.DiaChi.Ten);
    }

    @Test
    public void Check_NguThuDon_Mau_Hoi() throws Exception
    {
        Tru tru = LookUpTable.NguThuDon(CanEnum.Mau, ChiEnum.Hoi);

        assertEquals(CanEnum.Quy, tru.ThienCan.Can);
        assertEquals(ChiEnum.Hoi, tru.DiaChi.Ten);
    }
//    #endregion Ngu Thu Don


    @Test
    public void truOfTheYear_1987() throws Exception {
        Tru tru = LookUpTable.TruOfTheYear(1987);

        assertEquals(CanEnum.Dinh, tru.ThienCan.Can);
        assertEquals(ChiEnum.Mao, tru.DiaChi.Ten);
    }

    @Test
    public void truOfTheYear_2017() throws Exception {
        Tru tru = LookUpTable.TruOfTheYear(2017);

        assertEquals(CanEnum.Dinh, tru.ThienCan.Can);
        assertEquals(ChiEnum.Dau, tru.DiaChi.Ten);
    }

    @Test
    public void truOfTheYear_1992() throws Exception {
        Tru tru = LookUpTable.TruOfTheYear(1992);

        assertEquals(CanEnum.Nham, tru.ThienCan.Can);
        assertEquals(ChiEnum.Than, tru.DiaChi.Ten);
    }

//    @Test
//    public void isTruMatched() throws Exception {
//
//    }

}