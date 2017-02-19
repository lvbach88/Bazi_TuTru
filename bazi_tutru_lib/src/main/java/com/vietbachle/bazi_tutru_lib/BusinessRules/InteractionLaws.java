package com.vietbachle.bazi_tutru_lib.BusinessRules;

import com.vietbachle.bazi_tutru_lib.Data.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vietbachle on 2/13/2017.
 */

public class InteractionLaws {

    private List<Tru> TatcaTru; // { get; private set; }

    private List<Tru> TuTru; // { get; private set; }

    public InteractionLaws() {
    }

    public InteractionLaws(TuTruMap ttm) {
        this.Init(ttm);
    }

    public void setAllLaws() {
        setThienCanNguHop();
        setDiaChiLucHop();
        setDiaChiLucXung();
    }

    private void Init(TuTruMap ttm) {
        LaSo laso = ttm.LaSoCuaToi;
        TatcaTru = new ArrayList<>();
        TuTru = new ArrayList<>();

        TuTru.addAll(laso.TuTru.values());

        TatcaTru.addAll(laso.TuTru.values());
        TatcaTru.add(laso.CungMenh);
        TatcaTru.add(laso.ThaiNguyen);
        TatcaTru.add(ttm.DaiVanHienTai);
        TatcaTru.add(ttm.LuuNien);
    }


    private boolean containCan(CanEnum canEnum) {
        for (Tru tru :
                TatcaTru) {
            if (tru.ThienCan.Can == canEnum) return true;
        }
        return false;
    }

    private boolean containChi(ChiEnum chiEnum) {
        for (Tru tru :
                TatcaTru) {
            if (tru.DiaChi.Ten == chiEnum) return true;
        }
        return false;
    }

    private void setThienCanNguHop() {
        setThienCanNguHop(CanEnum.Giap, CanEnum.Ky);
        setThienCanNguHop(CanEnum.At, CanEnum.Canh);
        setThienCanNguHop(CanEnum.Binh, CanEnum.Tan);
        setThienCanNguHop(CanEnum.Dinh, CanEnum.Nham);
        setThienCanNguHop(CanEnum.Mau, CanEnum.Quy);
    }

    private void setThienCanNguHop(CanEnum canEnum1, CanEnum canEnum2) {
        if (containCan(canEnum1) && containCan(canEnum2)) {
            List<CanEnum> giapKy = new ArrayList<>(Arrays.asList(CanEnum.Giap, CanEnum.Ky));
            List<CanEnum> atCanh = new ArrayList<>(Arrays.asList(CanEnum.At, CanEnum.Canh)); // { CanEnum.At, CanEnum.Canh };
            List<CanEnum> binhTan = new ArrayList<>(Arrays.asList(CanEnum.Binh, CanEnum.Tan)); // { CanEnum.Binh, CanEnum.Tan };
            List<CanEnum> dinhNham = new ArrayList<>(Arrays.asList(CanEnum.Dinh, CanEnum.Nham)); // { CanEnum.Dinh, CanEnum.Nham };
            List<CanEnum> mauQuy = new ArrayList<>(Arrays.asList(CanEnum.Mau, CanEnum.Quy)); // { CanEnum.Mau, CanEnum.Quy };

            if (giapKy.contains(canEnum1)) {
//                SetNguHop(can1, NguHanhEnum.Tho);
//                SetNguHop(can2, NguHanhEnum.Tho);
                TongHopCanChi.getThienCanByEnum(canEnum1).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Tho);
                TongHopCanChi.getThienCanByEnum(canEnum2).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Tho);
            }

            if (atCanh.contains(canEnum1)) {
//                SetNguHop(can1, NguHanhEnum.Kim);
//                SetNguHop(can2, NguHanhEnum.Kim);
                TongHopCanChi.getThienCanByEnum(canEnum1).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Kim);
                TongHopCanChi.getThienCanByEnum(canEnum2).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Kim);
            }

            if (binhTan.contains(canEnum1)) {
//                SetNguHop(can1, NguHanhEnum.Thuy);
//                SetNguHop(can2, NguHanhEnum.Thuy);
                TongHopCanChi.getThienCanByEnum(canEnum1).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Thuy);
                TongHopCanChi.getThienCanByEnum(canEnum2).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Thuy);
            }

            if (dinhNham.contains(canEnum1)) {
//                SetNguHop(can1, NguHanhEnum.Moc);
//                SetNguHop(can2, NguHanhEnum.Moc);
                TongHopCanChi.getThienCanByEnum(canEnum1).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Moc);
                TongHopCanChi.getThienCanByEnum(canEnum2).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Moc);
            }

            if (mauQuy.contains(canEnum1)) {
//                SetNguHop(can1, NguHanhEnum.Hoa);
//                SetNguHop(can2, NguHanhEnum.Hoa);
                TongHopCanChi.getThienCanByEnum(canEnum1).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Hoa);
                TongHopCanChi.getThienCanByEnum(canEnum2).AddThuocTinh(Constants.ThuocTinh.THIEN_CAN_NGU_HOP, NguHanhEnum.Hoa);
            }

        }
    }

    private void setDiaChiLucHop() {
        setDiaChiLucHop(ChiEnum.Ti, ChiEnum.Suu);
        setDiaChiLucHop(ChiEnum.Dan, ChiEnum.Hoi);
        setDiaChiLucHop(ChiEnum.Mao, ChiEnum.Tuat);

        setDiaChiLucHop(ChiEnum.Thin, ChiEnum.Dau);
        setDiaChiLucHop(ChiEnum.Ty, ChiEnum.Than);
        setDiaChiLucHop(ChiEnum.Ngo, ChiEnum.Mui);
    }

    private void setDiaChiLucHop(ChiEnum chiEnum1, ChiEnum chiEnum2) {
        if (containChi(chiEnum1) && containChi(chiEnum2)) {
            DiaChi diaChi1 = TongHopCanChi.getDiaChiByEnum(chiEnum1);
            DiaChi diaChi2 = TongHopCanChi.getDiaChiByEnum(chiEnum2);
            NguHanhEnum nguHanhChi1 = diaChi1.BanKhi.NguHanh;
            NguHanhEnum nguHanhChi2 = diaChi2.BanKhi.NguHanh;

            NguHanhEnum[] sinhKhac = LookUpTable.NguHanhSinhKhac.get(nguHanhChi1);
            NguHanhEnum nhSinh = sinhKhac[0];
            NguHanhEnum nhDuocSinh = sinhKhac[1];
            NguHanhEnum nhKhac = sinhKhac[2];
            NguHanhEnum nhBiKhac = sinhKhac[3];

            String thuocTinh = "";
            if (nguHanhChi2 == nhSinh || nguHanhChi2 == nhDuocSinh) {
                thuocTinh = Constants.ThuocTinh.LUC_HOP_SINH;
            } else if (nguHanhChi2 == nhKhac || nguHanhChi2 == nhBiKhac) {
                thuocTinh = Constants.ThuocTinh.LUC_HOP_KHAC;
            }

            NguHanhEnum lucHop = NguHanhEnum.None;
            List<ChiEnum> lucHopTho = new ArrayList<>(Arrays.asList(ChiEnum.Ti, ChiEnum.Suu, ChiEnum.Ngo, ChiEnum.Mui)); // { ChiEnum.Ti, ChiEnum.Suu, ChiEnum.Ngo, ChiEnum.Mui} ;
            List<ChiEnum> lucHopMoc = new ArrayList<>(Arrays.asList(ChiEnum.Dan, ChiEnum.Hoi));
            List<ChiEnum> lucHopHoa = new ArrayList<>(Arrays.asList(ChiEnum.Mao, ChiEnum.Tuat));
            List<ChiEnum> lucHopKim = new ArrayList<>(Arrays.asList(ChiEnum.Thin, ChiEnum.Dau));
            List<ChiEnum> lucHopThuy = new ArrayList<>(Arrays.asList(ChiEnum.Ty, ChiEnum.Than));


            if (lucHopTho.contains(chiEnum1)) {
                lucHop = NguHanhEnum.Tho;
            } else if (lucHopMoc.contains(chiEnum1)) {
                lucHop = NguHanhEnum.Moc;
            } else if (lucHopHoa.contains(chiEnum1)) {
                lucHop = NguHanhEnum.Hoa;
            } else if (lucHopKim.contains(chiEnum1)) {
                lucHop = NguHanhEnum.Kim;
            } else if (lucHopThuy.contains(chiEnum1)) {
                lucHop = NguHanhEnum.Thuy;
            }
            diaChi1.AddThuocTinh(thuocTinh, lucHop);
            diaChi2.AddThuocTinh(thuocTinh, lucHop);

        }

    }

    private void setDiaChiLucXung() {
        setDiaChiLucXung(ChiEnum.Ti, ChiEnum.Ngo);
        setDiaChiLucXung(ChiEnum.Suu, ChiEnum.Mui);
        setDiaChiLucXung(ChiEnum.Dan, ChiEnum.Than);

        setDiaChiLucXung(ChiEnum.Mao, ChiEnum.Dau);
        setDiaChiLucXung(ChiEnum.Thin, ChiEnum.Tuat);
        setDiaChiLucXung(ChiEnum.Ty, ChiEnum.Hoi);
    }

    private void setDiaChiLucXung(ChiEnum chiEnum1, ChiEnum chiEnum2) {
        if (containChi(chiEnum1) && containChi(chiEnum2)) {
            DiaChi diaChi1 = TongHopCanChi.getDiaChiByEnum(chiEnum1);
            DiaChi diaChi2 = TongHopCanChi.getDiaChiByEnum(chiEnum2);

            String thuocTinh = Constants.ThuocTinh.LUC_XUNG;

            String lucXung = "";
            List<ChiEnum> tiNgo = new ArrayList<>(Arrays.asList(ChiEnum.Ti, ChiEnum.Ngo)); // List<ChiEnum> {ChiEnum.Ti, ChiEnum.Ngo} ;
            List<ChiEnum> suuMui = new ArrayList<>(Arrays.asList(ChiEnum.Suu, ChiEnum.Mui));// List<ChiEnum> {ChiEnum.Suu, ChiEnum.Mui} ;
            List<ChiEnum> danThan = new ArrayList<>(Arrays.asList(ChiEnum.Dan, ChiEnum.Than));// List<ChiEnum> {ChiEnum.Dan, ChiEnum.Than} ;

            List<ChiEnum> maoDau = new ArrayList<>(Arrays.asList(ChiEnum.Mao, ChiEnum.Dau));// List<ChiEnum> {ChiEnum.Mao, ChiEnum.Dau} ;
            List<ChiEnum> thinTuat = new ArrayList<>(Arrays.asList(ChiEnum.Thin, ChiEnum.Tuat));// List<ChiEnum> {ChiEnum.Thin, ChiEnum.Tuat} ;
            List<ChiEnum> tyHoi = new ArrayList<>(Arrays.asList(ChiEnum.Ty, ChiEnum.Hoi));// List<ChiEnum> {ChiEnum.Ty, ChiEnum.Hoi} ;

            if (tiNgo.contains(chiEnum1)) {
                lucXung = Constants.DiaChiLucXung.TI_NGO;
            } else if (suuMui.contains(chiEnum1)) {
                lucXung = Constants.DiaChiLucXung.SUU_MUI;
            } else if (danThan.contains(chiEnum1)) {
                lucXung = Constants.DiaChiLucXung.DAN_THAN;
            } else if (maoDau.contains(chiEnum1)) {
                lucXung = Constants.DiaChiLucXung.MAO_DAU;
            } else if (thinTuat.contains(chiEnum1)) {
                lucXung = Constants.DiaChiLucXung.THIN_TUAT;
            } else if (tyHoi.contains(chiEnum1)) {
                lucXung = Constants.DiaChiLucXung.TY_HOI;
            }
            diaChi1.AddThuocTinh(thuocTinh, lucXung);
            diaChi2.AddThuocTinh(thuocTinh, lucXung);
        }
    }
}

//public class DiaChiLucHai : TruCollection
//        {
//public DiaChiLucHai(TuTruMap ttm)
//        {
//        base.Init(ttm);
//        }
//
//public override void SetLaw()
//        {
//        this.CheckLucHai(ChiEnum.Ti, ChiEnum.Mui);
//        this.CheckLucHai(ChiEnum.Suu, ChiEnum.Ngo);
//        this.CheckLucHai(ChiEnum.Dan, ChiEnum.Ty);
//
//        this.CheckLucHai(ChiEnum.Mao, ChiEnum.Thin);
//        this.CheckLucHai(ChiEnum.Than, ChiEnum.Hoi);
//        this.CheckLucHai(ChiEnum.Dau, ChiEnum.Tuat);
//        }
//
//private void CheckLucHai(ChiEnum chi1, ChiEnum chi2)
//        {
//        var chi1Id = TatcaTru.FindIndex(u => u.DiaChi.Ten == chi1);
//        var chi2Id = TatcaTru.FindIndex(u => u.DiaChi.Ten == chi2);
//
//        if (chi1Id != -1 && chi2Id != -1)
//        {
//        var diaChi1 = TongHopCanChi.MuoiHaiDiaChi.Find(u => u.Ten == chi1);
//        var diaChi2 = TongHopCanChi.MuoiHaiDiaChi.Find(u => u.Ten == chi2);
//
//        string thuocTinh = Constants.ThuocTinh.LUC_HAI;
//
//        var lucHai = string.Empty;
//        var tiMui = new List<ChiEnum> { ChiEnum.Ti, ChiEnum.Mui };
//        var suuNgo = new List<ChiEnum> { ChiEnum.Suu, ChiEnum.Ngo };
//        var danTy = new List<ChiEnum> { ChiEnum.Dan, ChiEnum.Ty };
//
//        var maoThin = new List<ChiEnum> { ChiEnum.Mao, ChiEnum.Thin };
//        var dauTuat = new List<ChiEnum> { ChiEnum.Dau, ChiEnum.Tuat };
//        var thanHoi = new List<ChiEnum> { ChiEnum.Than, ChiEnum.Hoi };
//
//        if (tiMui.Contains(chi1))
//        {
//        lucHai = Constants.DiaChiLucHai.TI_MUI;
//        }
//        else if (suuNgo.Contains(chi1))
//        {
//        lucHai = Constants.DiaChiLucHai.SUU_NGO;
//        }
//        else if (danTy.Contains(chi1))
//        {
//        lucHai = Constants.DiaChiLucHai.DAN_TY;
//        }
//        else if (maoThin.Contains(chi1))
//        {
//        lucHai = Constants.DiaChiLucHai.MAO_THIN;
//        }
//        else if (dauTuat.Contains(chi1))
//        {
//        lucHai = Constants.DiaChiLucHai.DAU_TUAT;
//        }
//        else if (thanHoi.Contains(chi1))
//        {
//        lucHai = Constants.DiaChiLucHai.THAN_HOI;
//        }
//        diaChi1.AddThuocTinh(thuocTinh, lucHai);
//        diaChi2.AddThuocTinh(thuocTinh, lucHai);
//        }
//        }
//        }
//
//public class DiaChiTamHoi : TruCollection
//        {
//public DiaChiTamHoi(TuTruMap ttm)
//        {
//        base.Init(ttm);
//        }
//
//public override void SetLaw()
//        {
//        //throw new NotImplementedException();
//        this.CheckTamHoi(ChiEnum.Dan, ChiEnum.Mao, ChiEnum.Thin);
//        this.CheckTamHoi(ChiEnum.Ty, ChiEnum.Ngo, ChiEnum.Mui);
//        this.CheckTamHoi(ChiEnum.Than, ChiEnum.Dau, ChiEnum.Tuat);
//        this.CheckTamHoi(ChiEnum.Hoi, ChiEnum.Ti, ChiEnum.Suu);
//        }
//
//private void CheckTamHoi(ChiEnum chi1, ChiEnum chi2, ChiEnum chi3)
//        {
//        int count = 0;
//        DiaChi dc1 = null, dc2 = null, dc3 = null;
//        var chi1Id = TatcaTru.FindIndex(u => u.DiaChi.Ten == chi1);
//        var chi2Id = TatcaTru.FindIndex(u => u.DiaChi.Ten == chi2);
//        var chi3Id = TatcaTru.FindIndex(u => u.DiaChi.Ten == chi3);
//
//        if (chi1Id != -1)
//        {
//        count++;
//        dc1 = TongHopCanChi.MuoiHaiDiaChi.Find(u => u.Ten == chi1);
//        }
//
//        if (chi2Id != -1)
//        {
//        count++;
//        dc2 = TongHopCanChi.MuoiHaiDiaChi.Find(u => u.Ten == chi2);
//        }
//
//        if (chi3Id != -1)
//        {
//        count++;
//        dc3 = TongHopCanChi.MuoiHaiDiaChi.Find(u => u.Ten == chi3);
//        }
//
//        string thuocTinh = string.Empty;
//        if (count == 2)
//        {
//        thuocTinh = Constants.ThuocTinh.BAN_TAM_HOI;
//        }
//
//        if (count == 3)
//        {
//        thuocTinh = Constants.ThuocTinh.TAM_HOI;
//        }
//
//        if (dc1 != null)
//        {
//        this.SetThuocTinh(dc1, thuocTinh);
//        }
//
//        if (dc2 != null)
//        {
//        this.SetThuocTinh(dc2, thuocTinh);
//        }
//
//        if (dc3 != null)
//        {
//        this.SetThuocTinh(dc3, thuocTinh);
//        }
//        }
//
//private void SetThuocTinh(DiaChi dc, string thuocTinh)
//        {
//        var xuan = new List<ChiEnum> { ChiEnum.Dan, ChiEnum.Mao, ChiEnum.Thin };
//        var ha = new List<ChiEnum> { ChiEnum.Ty, ChiEnum.Ngo, ChiEnum.Mui };
//        var thu = new List<ChiEnum> { ChiEnum.Than, ChiEnum.Dau, ChiEnum.Tuat };
//        var dong = new List<ChiEnum> { ChiEnum.Hoi, ChiEnum.Ti, ChiEnum.Suu };
//
//        if (xuan.Contains(dc.Ten))
//        {
//        dc.AddThuocTinh(thuocTinh, NguHanhEnum.Moc);
//        }
//        else if (ha.Contains(dc.Ten))
//        {
//        dc.AddThuocTinh(thuocTinh, NguHanhEnum.Hoa);
//        }
//        else if (thu.Contains(dc.Ten))
//        {
//        dc.AddThuocTinh(thuocTinh, NguHanhEnum.Kim);
//        }
//        else if (dong.Contains(dc.Ten))
//        {
//        dc.AddThuocTinh(thuocTinh, NguHanhEnum.Thuy);
//        }
//        }
//        }
//
//public class DiaChiTamHop : TruCollection
//        {
//public DiaChiTamHop(TuTruMap ttm)
//        {
//        base.Init(ttm);
//        }
//
//public override void SetLaw()
//        {
//        //throw new NotImplementedException();
//        this.CheckTamHop(ChiEnum.Dan, ChiEnum.Ngo, ChiEnum.Tuat);
//        this.CheckTamHop(ChiEnum.Ty, ChiEnum.Dau, ChiEnum.Suu);
//        this.CheckTamHop(ChiEnum.Than, ChiEnum.Ti, ChiEnum.Thin);
//        this.CheckTamHop(ChiEnum.Hoi, ChiEnum.Mao, ChiEnum.Mui);
//        }
//
//private void CheckTamHop(ChiEnum chi1, ChiEnum chi2, ChiEnum chi3)
//        {
//        int count = 0;
//        DiaChi dc1 = null, dc2 = null, dc3 = null;
//        var chi1Id = TatcaTru.FindIndex(u => u.DiaChi.Ten == chi1);
//        var chi2Id = TatcaTru.FindIndex(u => u.DiaChi.Ten == chi2);
//        var chi3Id = TatcaTru.FindIndex(u => u.DiaChi.Ten == chi3);
//
//        if (chi1Id != -1)
//        {
//        count++;
//        dc1 = TongHopCanChi.MuoiHaiDiaChi.Find(u => u.Ten == chi1);
//        }
//
//        if (chi2Id != -1)
//        {
//        count++;
//        dc2 = TongHopCanChi.MuoiHaiDiaChi.Find(u => u.Ten == chi2);
//        }
//
//        if (chi3Id != -1)
//        {
//        count++;
//        dc3 = TongHopCanChi.MuoiHaiDiaChi.Find(u => u.Ten == chi3);
//        }
//
//        string thuocTinh = string.Empty;
//        if (count == 2)
//        {
//        thuocTinh = Constants.ThuocTinh.BAN_TAM_HOP;
//        }
//
//        if (count == 3)
//        {
//        thuocTinh = Constants.ThuocTinh.TAM_HOP;
//        }
//
//        if (dc1 != null)
//        {
//        this.SetThuocTinh(dc1, thuocTinh);
//        }
//
//        if (dc2 != null)
//        {
//        this.SetThuocTinh(dc2, thuocTinh);
//        }
//
//        if (dc3 != null)
//        {
//        this.SetThuocTinh(dc3, thuocTinh);
//        }
//        }
//
//private void SetThuocTinh(DiaChi dc, string thuocTinh)
//        {
//        var hoa = new List<ChiEnum> { ChiEnum.Dan, ChiEnum.Ngo, ChiEnum.Tuat };
//        var kim = new List<ChiEnum> { ChiEnum.Ty, ChiEnum.Dau, ChiEnum.Suu };
//        var thuy = new List<ChiEnum> { ChiEnum.Than, ChiEnum.Ti, ChiEnum.Thin };
//        var moc = new List<ChiEnum> { ChiEnum.Hoi, ChiEnum.Mao, ChiEnum.Mui };
//
//        if (hoa.Contains(dc.Ten))
//        {
//        dc.AddThuocTinh(thuocTinh, NguHanhEnum.Hoa);
//        }
//        else if (kim.Contains(dc.Ten))
//        {
//        dc.AddThuocTinh(thuocTinh, NguHanhEnum.Kim);
//        }
//        else if (thuy.Contains(dc.Ten))
//        {
//        dc.AddThuocTinh(thuocTinh, NguHanhEnum.Thuy);
//        }
//        else if (moc.Contains(dc.Ten))
//        {
//        dc.AddThuocTinh(thuocTinh, NguHanhEnum.Moc);
//        }
//        }
//        }
//
//public class DiaChiTuongHinh : TruCollection
//        {
//public DiaChiTuongHinh(TuTruMap ttm)
//        {
//        base.Init(ttm);
//        }
//
//public override void SetLaw()
//        {
//        //throw new NotImplementedException();
//
//        this.CheckTuHinh();
//        this.CheckNhiHinh();
//        this.CheckTamHinh();
//        }
//
//        #region Tu Hinh
///// <summary>
///// Tu Hinh belongs to ThuocTinh of Tru
///// </summary>
//private void CheckTuHinh()
//        {
//        this.CheckTuHinhTheoChi(ChiEnum.Thin);
//        this.CheckTuHinhTheoChi(ChiEnum.Ngo);
//        this.CheckTuHinhTheoChi(ChiEnum.Dau);
//        this.CheckTuHinhTheoChi(ChiEnum.Hoi);
//        }
//
//private void CheckTuHinhTheoChi(ChiEnum chi)
//        {
//        for (int i = 0; i < this.TuTru.Count-1; i++)
//        {
//        var currTru = this.TuTru[i];
//        var nextTru = this.TuTru[i + 1];
//        if (currTru.DiaChi.Ten == chi && nextTru.DiaChi.Ten == chi)
//        {
//        //Tu Hinh se la thuoc tinh cua Tru.
//        //This is a work-around.
//        currTru.AddThuocTinh(Constants.ThuocTinh.TU_HINH, Constants.DiaChiTuongHinh.TU_HINH);
//        nextTru.AddThuocTinh(Constants.ThuocTinh.TU_HINH, Constants.DiaChiTuongHinh.TU_HINH);
//        }
//        }
//        }
//
//        #endregion Tu Hinh
//
//        #region Nhi Hinh
//private void CheckNhiHinh()
//        {
//        var tiId = this.TuTru.FindIndex(u => u.DiaChi.Ten == ChiEnum.Ti);
//        var maoId = this.TuTru.FindIndex(u => u.DiaChi.Ten == ChiEnum.Mao);
//
//        DiaChi ti = null, mao = null;
//        if (tiId != -1 && maoId != -1)
//        {
//        ti = this.TuTru[tiId].DiaChi;
//        mao = this.TuTru[maoId].DiaChi;
//        var thuocTinh = Constants.ThuocTinh.NHI_HINH;
//        ti.AddThuocTinh(thuocTinh, Constants.DiaChiTuongHinh.NHI_HINH);
//        mao.AddThuocTinh(thuocTinh, Constants.DiaChiTuongHinh.NHI_HINH);
//        }
//        }
//
//        #endregion Nhi Hinh
//
//        #region Tam Hinh
//private void CheckTamHinh()
//        {
//        this.CheckTamHinhTheoChi(ChiEnum.Dan, ChiEnum.Ty, ChiEnum.Than);
//        this.CheckTamHinhTheoChi(ChiEnum.Suu, ChiEnum.Tuat, ChiEnum.Mui);
//        }
//
//private void CheckTamHinhTheoChi(ChiEnum chi1, ChiEnum chi2, ChiEnum chi3)
//        {
//        var chi1Id = this.TuTru.FindIndex(u => u.DiaChi.Ten == chi1);
//        var chi2Id = this.TuTru.FindIndex(u => u.DiaChi.Ten == chi2);
//        var chi3Id = this.TuTru.FindIndex(u => u.DiaChi.Ten == chi3);
//
//        if (chi1Id != -1 && chi2Id != -1 && chi3Id != -1)
//        {
//        var dc1 = this.TuTru[chi1Id].DiaChi;
//        var dc2 = this.TuTru[chi2Id].DiaChi;
//        var dc3 = this.TuTru[chi3Id].DiaChi;
//
//        var dantythan = new List<ChiEnum> {ChiEnum.Dan, ChiEnum.Ty, ChiEnum.Than };
//        var suutuatmui = new List<ChiEnum> { ChiEnum.Suu, ChiEnum.Tuat, ChiEnum.Mui };
//
//        if (dantythan.Contains(chi1))
//        {
//        dc1.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.DAN_TY_THAN);
//        dc2.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.DAN_TY_THAN);
//        dc3.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.DAN_TY_THAN);
//        }
//        else if (suutuatmui.Contains(chi1))
//        {
//        dc1.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.SUU_TUAT_MUI);
//        dc2.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.SUU_TUAT_MUI);
//        dc3.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.SUU_TUAT_MUI);
//        }
//
//        }
//
//        }
//
//        #endregion Tam Hinh
//        }
//
//public class DiaChiTuongLien : TruCollection
//        {
//public DiaChiTuongLien(TuTruMap ttm)
//        {
//        base.Init(ttm);
//        }
//
//public override void SetLaw()
//        {
//        //throw new NotImplementedException();
//        var chiList = new List<ChiEnum> {ChiEnum.Ti, ChiEnum.Suu, ChiEnum.Dan,
//        ChiEnum.Mao, ChiEnum.Ty, ChiEnum.Ngo,
//        ChiEnum.Mui, ChiEnum.Than, ChiEnum.Dau, ChiEnum.Hoi};
//        foreach (var chi in chiList)
//        {
//        this.CheckTuongLien(chi);
//        }
//        }
//
//private void CheckTuongLien(ChiEnum chi)
//        {
//        int count = 0;
//        foreach (var item in this.TuTru)
//        {
//        if (item.DiaChi.Ten == chi)
//        {
//        count++;
//        }
//        }
//
//        if (count == Constants.DiaChiTuongLien.SO_TUONG_LIEN)
//        {
//        var dc = this.TuTru.Find(u => u.DiaChi.Ten == chi);
//        var thuocTinh = Constants.ThuocTinh.TUONG_LIEN;
//        switch (chi)
//        {
//        case ChiEnum.None:
//        break;
//        case ChiEnum.Ti:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_TI);
//        break;
//        case ChiEnum.Suu:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_SUU);
//        break;
//        case ChiEnum.Dan:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_DAN);
//        break;
//        case ChiEnum.Mao:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_MAO);
//        break;
//        case ChiEnum.Thin:
//        break;
//        case ChiEnum.Ty:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_TY);
//        break;
//        case ChiEnum.Ngo:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_NGO);
//        break;
//        case ChiEnum.Mui:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_MUI);
//        break;
//        case ChiEnum.Than:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_THAN);
//        break;
//        case ChiEnum.Dau:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_DAU);
//        break;
//        case ChiEnum.Tuat:
//        break;
//        case ChiEnum.Hoi:
//        dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_HOI);
//        break;
//default:
//        break;
//        }
//        }
//        }
//        }



