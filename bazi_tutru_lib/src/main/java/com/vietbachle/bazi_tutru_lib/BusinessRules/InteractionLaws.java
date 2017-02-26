package com.vietbachle.bazi_tutru_lib.BusinessRules;

import com.vietbachle.bazi_tutru_lib.Data.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vietbachle on 2/13/2017.
 */

public class InteractionLaws extends TruCollection {

//    private List<Tru> TatcaTru; // { get; private set; }
//
//    private List<Tru> TuTru; // { get; private set; }

    public InteractionLaws() {
    }

    public InteractionLaws(TuTruMap ttm) {
        //this.Init(ttm);
        super(ttm);
    }

    public void setAllLaws() {
        setThienCanNguHop();

        setDiaChiLucHop();
        setDiaChiLucXung();
        setDiaChiLucHai();

        setDiaChiTamHoi();
        setDiaChiTamHop();

        setDiaChiTuongHinh();
        setDiaChiTuongLien();
    }

//    private void Init(TuTruMap ttm) {
//        LaSo laso = ttm.LaSoCuaToi;
//        TatcaTru = new ArrayList<>();
//        TuTru = new ArrayList<>();
//
//        TuTru.addAll(laso.TuTru.values());
//
//        TatcaTru.addAll(laso.TuTru.values());
//        TatcaTru.add(laso.CungMenh);
//        TatcaTru.add(laso.ThaiNguyen);
//        TatcaTru.add(ttm.DaiVanHienTai);
//        TatcaTru.add(ttm.LuuNien);
//    }

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

    private void setDiaChiLucHai() {
        setDiaChiLucHai(ChiEnum.Ti, ChiEnum.Mui);
        setDiaChiLucHai(ChiEnum.Suu, ChiEnum.Ngo);
        setDiaChiLucHai(ChiEnum.Dan, ChiEnum.Ty);

        setDiaChiLucHai(ChiEnum.Mao, ChiEnum.Thin);
        setDiaChiLucHai(ChiEnum.Than, ChiEnum.Hoi);
        setDiaChiLucHai(ChiEnum.Dau, ChiEnum.Tuat);
    }

    private void setDiaChiLucHai(ChiEnum chiEnum1, ChiEnum chiEnum2) {
        if (containChi(chiEnum1) && containChi(chiEnum2)) {
            DiaChi diaChi1 = TongHopCanChi.getDiaChiByEnum(chiEnum1);
            DiaChi diaChi2 = TongHopCanChi.getDiaChiByEnum(chiEnum2);

            String thuocTinh = Constants.ThuocTinh.LUC_HAI;

            String lucHai = "";
            List<ChiEnum> tiMui = new ArrayList<>(Arrays.asList(ChiEnum.Ti, ChiEnum.Mui));//List<ChiEnum> {ChiEnum.Ti, ChiEnum.Mui} ;
            List<ChiEnum> suuNgo = new ArrayList<>(Arrays.asList(ChiEnum.Suu, ChiEnum.Ngo));//List<ChiEnum> {ChiEnum.Suu, ChiEnum.Ngo} ;
            List<ChiEnum> danTy = new ArrayList<>(Arrays.asList(ChiEnum.Dan, ChiEnum.Ty));//List<ChiEnum> {ChiEnum.Dan, ChiEnum.Ty} ;

            List<ChiEnum> maoThin = new ArrayList<>(Arrays.asList(ChiEnum.Mao, ChiEnum.Thin));//List<ChiEnum> {ChiEnum.Mao, ChiEnum.Thin} ;
            List<ChiEnum> dauTuat = new ArrayList<>(Arrays.asList(ChiEnum.Dau, ChiEnum.Tuat));//List<ChiEnum> {ChiEnum.Dau, ChiEnum.Tuat} ;
            List<ChiEnum> thanHoi = new ArrayList<>(Arrays.asList(ChiEnum.Than, ChiEnum.Hoi));//List<ChiEnum> {ChiEnum.Than, ChiEnum.Hoi} ;

            if (tiMui.contains(chiEnum1)) {
                lucHai = Constants.DiaChiLucHai.TI_MUI;
            } else if (suuNgo.contains(chiEnum1)) {
                lucHai = Constants.DiaChiLucHai.SUU_NGO;
            } else if (danTy.contains(chiEnum1)) {
                lucHai = Constants.DiaChiLucHai.DAN_TY;
            } else if (maoThin.contains(chiEnum1)) {
                lucHai = Constants.DiaChiLucHai.MAO_THIN;
            } else if (dauTuat.contains(chiEnum1)) {
                lucHai = Constants.DiaChiLucHai.DAU_TUAT;
            } else if (thanHoi.contains(chiEnum1)) {
                lucHai = Constants.DiaChiLucHai.THAN_HOI;
            }
            diaChi1.AddThuocTinh(thuocTinh, lucHai);
            diaChi2.AddThuocTinh(thuocTinh, lucHai);
        }
    }

    private void setDiaChiTamHoi() {
        setDiaChiTamHoi(ChiEnum.Dan, ChiEnum.Mao, ChiEnum.Thin);
        setDiaChiTamHoi(ChiEnum.Ty, ChiEnum.Ngo, ChiEnum.Mui);
        setDiaChiTamHoi(ChiEnum.Than, ChiEnum.Dau, ChiEnum.Tuat);
        setDiaChiTamHoi(ChiEnum.Hoi, ChiEnum.Ti, ChiEnum.Suu);
    }

    private void setDiaChiTamHoi(ChiEnum chiEnum1, ChiEnum chiEnum2, ChiEnum chiEnum3) {
        int count = 0;
        DiaChi dc1 = null, dc2 = null, dc3 = null;

        if (containChi(chiEnum1)) {
            count++;
            dc1 = TongHopCanChi.getDiaChiByEnum(chiEnum1);
        }

        if (containChi(chiEnum2)) {
            count++;
            dc2 = TongHopCanChi.getDiaChiByEnum(chiEnum2);
        }

        if (containChi(chiEnum3)) {
            count++;
            dc3 = TongHopCanChi.getDiaChiByEnum(chiEnum3);
        }

        String thuocTinh = "";
        if (count == 2) {
            thuocTinh = Constants.ThuocTinh.BAN_TAM_HOI;
        }

        if (count == 3) {
            thuocTinh = Constants.ThuocTinh.TAM_HOI;
        }

        if (dc1 != null) {
            this.setThuocTinhDiaChiTamHoi(dc1, thuocTinh);
        }

        if (dc2 != null) {
            this.setThuocTinhDiaChiTamHoi(dc2, thuocTinh);
        }

        if (dc3 != null) {
            this.setThuocTinhDiaChiTamHoi(dc3, thuocTinh);
        }
    }

    private void setThuocTinhDiaChiTamHoi(DiaChi dc, String thuocTinh) {
        List<ChiEnum> xuan = new ArrayList<>(Arrays.asList(ChiEnum.Dan, ChiEnum.Mao, ChiEnum.Thin));//List<ChiEnum> {ChiEnum.Dan, ChiEnum.Mao, ChiEnum.Thin} ;
        List<ChiEnum> ha = new ArrayList<>(Arrays.asList(ChiEnum.Ty, ChiEnum.Ngo, ChiEnum.Mui));//List<ChiEnum> {ChiEnum.Ty, ChiEnum.Ngo, ChiEnum.Mui} ;
        List<ChiEnum> thu = new ArrayList<>(Arrays.asList(ChiEnum.Than, ChiEnum.Dau, ChiEnum.Tuat));//List<ChiEnum> {ChiEnum.Than, ChiEnum.Dau, ChiEnum.Tuat} ;
        List<ChiEnum> dong = new ArrayList<>(Arrays.asList(ChiEnum.Hoi, ChiEnum.Ti, ChiEnum.Suu));//List<ChiEnum> {ChiEnum.Hoi, ChiEnum.Ti, ChiEnum.Suu} ;

        if (xuan.contains(dc.Ten)) {
            dc.AddThuocTinh(thuocTinh, NguHanhEnum.Moc);
        } else if (ha.contains(dc.Ten)) {
            dc.AddThuocTinh(thuocTinh, NguHanhEnum.Hoa);
        } else if (thu.contains(dc.Ten)) {
            dc.AddThuocTinh(thuocTinh, NguHanhEnum.Kim);
        } else if (dong.contains(dc.Ten)) {
            dc.AddThuocTinh(thuocTinh, NguHanhEnum.Thuy);
        }
    }

    private void setDiaChiTamHop() {
        setDiaChiTamHop(ChiEnum.Dan, ChiEnum.Ngo, ChiEnum.Tuat);
        setDiaChiTamHop(ChiEnum.Ty, ChiEnum.Dau, ChiEnum.Suu);
        setDiaChiTamHop(ChiEnum.Than, ChiEnum.Ti, ChiEnum.Thin);
        setDiaChiTamHop(ChiEnum.Hoi, ChiEnum.Mao, ChiEnum.Mui);
    }

    private void setDiaChiTamHop(ChiEnum chiEnum1, ChiEnum chiEnum2, ChiEnum chiEnum3) {
        int count = 0;
        DiaChi dc1 = null, dc2 = null, dc3 = null;

        if (containChi(chiEnum1)) {
            count++;
            dc1 = TongHopCanChi.getDiaChiByEnum(chiEnum1);
        }

        if (containChi(chiEnum2)) {
            count++;
            dc2 = TongHopCanChi.getDiaChiByEnum(chiEnum2);
        }

        if (containChi(chiEnum3)) {
            count++;
            dc3 = TongHopCanChi.getDiaChiByEnum(chiEnum3);
        }

        String thuocTinh = "";
        if (count == 2) {
            thuocTinh = Constants.ThuocTinh.BAN_TAM_HOP;
        }

        if (count == 3) {
            thuocTinh = Constants.ThuocTinh.TAM_HOP;
        }

        if (dc1 != null) {
            this.setThuocTinhDiaChiTamHop(dc1, thuocTinh);
        }

        if (dc2 != null) {
            this.setThuocTinhDiaChiTamHop(dc2, thuocTinh);
        }

        if (dc3 != null) {
            this.setThuocTinhDiaChiTamHop(dc3, thuocTinh);
        }
    }

    private void setThuocTinhDiaChiTamHop(DiaChi dc, String thuocTinh) {
        List<ChiEnum> hoa = new ArrayList<>(Arrays.asList(ChiEnum.Dan, ChiEnum.Ngo, ChiEnum.Tuat));
        List<ChiEnum> kim = new ArrayList<>(Arrays.asList(ChiEnum.Ty, ChiEnum.Dau, ChiEnum.Suu));
        List<ChiEnum> thuy = new ArrayList<>(Arrays.asList(ChiEnum.Than, ChiEnum.Ti, ChiEnum.Thin));
        List<ChiEnum> moc = new ArrayList<>(Arrays.asList(ChiEnum.Hoi, ChiEnum.Mao, ChiEnum.Mui));

        if (hoa.contains(dc.Ten)) {
            dc.AddThuocTinh(thuocTinh, NguHanhEnum.Hoa);
        } else if (kim.contains(dc.Ten)) {
            dc.AddThuocTinh(thuocTinh, NguHanhEnum.Kim);
        } else if (thuy.contains(dc.Ten)) {
            dc.AddThuocTinh(thuocTinh, NguHanhEnum.Thuy);
        } else if (moc.contains(dc.Ten)) {
            dc.AddThuocTinh(thuocTinh, NguHanhEnum.Tho);
        }
    }

    private void setDiaChiTuongHinh() {
        setDiaChiTuHinh();
        setDiaChiNhiHinh();
        setDiaChiTamHinh();
    }

    ////
    // Tu Hinh belongs to ThuocTinh of Tru
    ////
    private void setDiaChiTuHinh() {
        setDiaChiTuHinh(ChiEnum.Thin);
        setDiaChiTuHinh(ChiEnum.Ngo);
        setDiaChiTuHinh(ChiEnum.Dau);
        setDiaChiTuHinh(ChiEnum.Hoi);
    }

    private void setDiaChiTuHinh(ChiEnum chi) {
        for (int i = 0; i < this.TuTru.size() - 1; i++) {
            Tru currTru = this.TuTru.get(i);
            Tru nextTru = this.TuTru.get(i + 1);
            if (currTru.DiaChi.Ten == chi && nextTru.DiaChi.Ten == chi) {
                //Tu Hinh se la thuoc tinh cua Tru.
                //This is a work-around.
                currTru.AddThuocTinh(Constants.ThuocTinh.TU_HINH, Constants.DiaChiTuongHinh.TU_HINH);
                nextTru.AddThuocTinh(Constants.ThuocTinh.TU_HINH, Constants.DiaChiTuongHinh.TU_HINH);
            }
        }
    }

    //// Nhi Hinh includes 10-year and year.
    private void setDiaChiNhiHinh() {
        DiaChi ti = null, mao = null;
        if (containChi(ChiEnum.Ti) && containChi(ChiEnum.Mao)) {
            ti = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti);
            mao = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao);
            String thuocTinh = Constants.ThuocTinh.NHI_HINH;
            ti.AddThuocTinh(thuocTinh, Constants.DiaChiTuongHinh.NHI_HINH);
            mao.AddThuocTinh(thuocTinh, Constants.DiaChiTuongHinh.NHI_HINH);
        }
    }

    private void setDiaChiTamHinh() {
        setDiaChiTamHinh(ChiEnum.Dan, ChiEnum.Ty, ChiEnum.Than);
        setDiaChiTamHinh(ChiEnum.Suu, ChiEnum.Tuat, ChiEnum.Mui);
    }

    ////Tam Hinh includes 10-year and year
    private void setDiaChiTamHinh(ChiEnum chiEnum1, ChiEnum chiEnum2, ChiEnum chiEnum3) {
        if (containChi(chiEnum1) && containChi(chiEnum2) && containChi(chiEnum3)) {
            DiaChi dc1 = TongHopCanChi.getDiaChiByEnum(chiEnum1);
            DiaChi dc2 = TongHopCanChi.getDiaChiByEnum(chiEnum2);
            DiaChi dc3 = TongHopCanChi.getDiaChiByEnum(chiEnum3);

            List<ChiEnum> dantythan = new ArrayList<>(Arrays.asList(ChiEnum.Dan, ChiEnum.Ty, ChiEnum.Than));//List<ChiEnum> {ChiEnum.Dan, ChiEnum.Ty, ChiEnum.Than} ;
            List<ChiEnum> suutuatmui = new ArrayList<>(Arrays.asList(ChiEnum.Suu, ChiEnum.Tuat, ChiEnum.Mui));//List<ChiEnum> {ChiEnum.Suu, ChiEnum.Tuat, ChiEnum.Mui} ;

            if (dantythan.contains(chiEnum1)) {
                dc1.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.DAN_TY_THAN);
                dc2.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.DAN_TY_THAN);
                dc3.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.DAN_TY_THAN);
            } else if (suutuatmui.contains(chiEnum1)) {
                dc1.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.SUU_TUAT_MUI);
                dc2.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.SUU_TUAT_MUI);
                dc3.AddThuocTinh(Constants.ThuocTinh.TAM_HINH, Constants.DiaChiTuongHinh.SUU_TUAT_MUI);
            }
        }
    }

    private void setDiaChiTuongLien() {
        List<ChiEnum> chiList = new ArrayList<>(Arrays.asList(ChiEnum.Ti, ChiEnum.Suu, ChiEnum.Dan,ChiEnum.Mao, ChiEnum.Ty, ChiEnum.Ngo,ChiEnum.Mui, ChiEnum.Than, ChiEnum.Dau, ChiEnum.Hoi));
        for(ChiEnum chi : chiList)
        {
            setDiaChiTuongLien(chi);
        }
    }

    private void setDiaChiTuongLien(ChiEnum chiEnum){
        int count = 0;
        for(Tru tru : this.TuTru)
        {
            if (tru.DiaChi.Ten == chiEnum) {
                count++;
            }
        }

        if (count == Constants.DiaChiTuongLien.SO_TUONG_LIEN) {
            DiaChi dc = TongHopCanChi.getDiaChiByEnum(chiEnum); ////this will include 10-year and year
            String thuocTinh = Constants.ThuocTinh.TUONG_LIEN;
            switch (chiEnum) {
                case None:
                    break;
                case Ti:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_TI);
                    break;
                case Suu:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_SUU);
                    break;
                case Dan:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_DAN);
                    break;
                case Mao:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_MAO);
                    break;
                case Thin:
                    break;
                case Ty:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_TY);
                    break;
                case Ngo:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_NGO);
                    break;
                case Mui:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_MUI);
                    break;
                case Than:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_THAN);
                    break;
                case Dau:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_DAU);
                    break;
                case Tuat:
                    break;
                case Hoi:
                    dc.AddThuocTinh(thuocTinh, Constants.DiaChiTuongLien.TAM_HOI);
                    break;
                default:
                    break;
            }
        }
    }

}

