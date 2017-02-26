package com.vietbachle.bazi_tutru_lib.BusinessRules;

import com.vietbachle.bazi_tutru_lib.Data.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vietbachle on 2/25/2017.
 */

public class ThanSat {

    private TuTruMap TTM = null;

    public ThanSat(TuTruMap ttm)
    {
        this.TTM = ttm;
    }

    private void SetThanSatTru(CanEnum can, ChiEnum chi, String thansat)
    {
        TruCollection law = new TruCollection(this.TTM);

        for (Tru item : law.TatcaTru)
        {
            if (item.ThienCan.Can == can && item.DiaChi.Ten == chi)
            {
                item.AddThanSat(thansat);
            }
        }
    }

    private void ThienAtQuyNhan()
    {
        List<CanEnum> namNgay = new ArrayList<>(Arrays.asList(TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.Can, TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can));

        if (namNgay.contains(CanEnum.Giap) || namNgay.contains(CanEnum.Mau))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
        }

        if (namNgay.contains(CanEnum.At) || namNgay.contains(CanEnum.Ky))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
        }

        if (namNgay.contains(CanEnum.Binh) || namNgay.contains(CanEnum.Dinh))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
        }

        if (namNgay.contains(CanEnum.Canh) || namNgay.contains(CanEnum.Tan))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
        }

        if (namNgay.contains(CanEnum.Nham) || namNgay.contains(CanEnum.Quy))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.THIEN_AT_QUY_NHAN);
        }

    }

    private void ThienNguyetDucQuyNhan()
    {
        ChiEnum thang = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).DiaChi.Ten;

        switch (thang)
        {
            case None:
                break;
            case Ti:

                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Nham).AddThanSat(Constants.ThanSat.NGUYET_DUC);
                break;
            case Suu:
                TongHopCanChi.getThienCanByEnum(CanEnum.Canh).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Canh).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Dan:

                TongHopCanChi.getThienCanByEnum(CanEnum.Dinh).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Binh).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Mao:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Giap).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Thin:
                TongHopCanChi.getThienCanByEnum(CanEnum.Nham).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Nham).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Ty:
                TongHopCanChi.getThienCanByEnum(CanEnum.Tan).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Canh).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Ngo:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Binh).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Mui:
                TongHopCanChi.getThienCanByEnum(CanEnum.Giap).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Giap).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Than:
                TongHopCanChi.getThienCanByEnum(CanEnum.Quy).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Nham).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Dau:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Canh).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Tuat:
                TongHopCanChi.getThienCanByEnum(CanEnum.Binh).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Binh).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            case Hoi:
                TongHopCanChi.getThienCanByEnum(CanEnum.At).AddThanSat(Constants.ThanSat.THIEN_DUC);

                TongHopCanChi.getThienCanByEnum(CanEnum.Giap).AddThanSat(Constants.ThanSat.NGUYET_DUC);

                break;
            default:
                break;
        }
    }

    private void KhoiCanhQuyNhan()
    {
        Tru truNgay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY);

        if (LookUpTable.IsTruMatched(truNgay, CanEnum.Nham, ChiEnum.Thin)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Canh, ChiEnum.Thin)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Mau, ChiEnum.Tuat)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Canh, ChiEnum.Tuat))
        {
            truNgay.AddThanSat(Constants.ThanSat.KHOI_CANH_QUY_NHAN);
        }
    }

    private void LocThan()
    {
        CanEnum canNgay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can;

        switch (canNgay)
        {
            case None:
                break;
            case Giap:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case At:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Binh:
            case Mau:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Dinh:
            case Ky:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Canh:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Tan:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Nham:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Quy:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            default:
                break;
        }
    }

    private void KinhDuong()
    {
        CanEnum canNgay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can;
        switch (canNgay)
        {
            case None:
                break;
            case Giap:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case At:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Binh:
            case Mau:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Dinh:
            case Ky:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Canh:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Tan:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Nham:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            case Quy:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.LOC_THAN);
                break;
            default:
                break;
        }
    }

    private void KimDu()
    {
        CanEnum canNgay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can;

        DiaChi dc = null;
        switch (canNgay)
        {
            case None:
                break;
            case Giap:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin);
                break;
            case At:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty);
                break;
            case Binh:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui);
                break;
            case Dinh:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Than);
                break;
            case Mau:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui);
                break;
            case Ky:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Than);
                break;
            case Canh:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat);
                break;
            case Tan:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi);
                break;
            case Nham:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu);
                break;
            case Quy:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan);
                break;
            default:
                break;
        }
        if (dc != null)
        {
            dc.AddThanSat(Constants.ThanSat.KIM_DU);
        }
    }

    private void VanXuong()
    {
        List<CanEnum> ngayNam = new ArrayList<>(Arrays.asList(this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can, this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.Can));
        //List<CanEnum> {this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NGAY].ThienCan.Can, this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NAM].ThienCan.Can};

        DiaChi dc = null;
        if (ngayNam.contains(CanEnum.Giap))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }
        if (ngayNam.contains(CanEnum.At))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }
        if (ngayNam.contains(CanEnum.Binh))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }
        if (ngayNam.contains(CanEnum.Dinh))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }
        if (ngayNam.contains(CanEnum.Mau))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }
        if (ngayNam.contains(CanEnum.Ky))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }
        if (ngayNam.contains(CanEnum.Canh))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }
        if (ngayNam.contains(CanEnum.Tan))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }
        if (ngayNam.contains(CanEnum.Nham))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }
        if (ngayNam.contains(CanEnum.Quy))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao).AddThanSat(Constants.ThanSat.VAN_XUONG);
        }

    }

    private void ThienY()
    {
        ChiEnum chiThang = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).DiaChi.Ten;
        DiaChi dc = null;

        switch (chiThang)
        {
            case None:
                break;
            case Ti:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi);
                break;
            case Suu:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti);
                break;
            case Dan:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu);
                break;
            case Mao:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan);
                break;
            case Thin:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao);
                break;
            case Ty:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin);
                break;
            case Ngo:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty);
                break;
            case Mui:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo);
                break;
            case Than:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui);
                break;
            case Dau:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Than);
                break;
            case Tuat:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau);
                break;
            case Hoi:
                dc = TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat);
                break;
            default:
                break;
        }

        if (dc != null)
        {
            dc.AddThanSat(Constants.ThanSat.THIEN_Y);
        }
    }

    private void DichMa_HoaCai_TuongTinh_KiepSat()
    {
        List<ChiEnum> chiNamNgay = new ArrayList<>(Arrays.asList(this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).DiaChi.Ten, this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).DiaChi.Ten));

        //List<ChiEnum> {this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NAM].DiaChi.Ten, this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NGAY].DiaChi.Ten};

        if (chiNamNgay.contains(ChiEnum.Dan)
                || chiNamNgay.contains(ChiEnum.Ngo)
                || chiNamNgay.contains(ChiEnum.Tuat))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.DICH_MA);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat).AddThanSat(Constants.ThanSat.HOA_CAI);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo).AddThanSat(Constants.ThanSat.TUONG_TINH);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.KIEP_SAT);

        }

        if (chiNamNgay.contains(ChiEnum.Ty)
                || chiNamNgay.contains(ChiEnum.Dau)
                || chiNamNgay.contains(ChiEnum.Suu))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.DICH_MA);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu).AddThanSat(Constants.ThanSat.HOA_CAI);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau).AddThanSat(Constants.ThanSat.TUONG_TINH);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.KIEP_SAT);

        }

        if (chiNamNgay.contains(ChiEnum.Than)
                || chiNamNgay.contains(ChiEnum.Ti)
                || chiNamNgay.contains(ChiEnum.Thin))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.DICH_MA);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin).AddThanSat(Constants.ThanSat.HOA_CAI);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti).AddThanSat(Constants.ThanSat.TUONG_TINH);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.KIEP_SAT);

        }

        if (chiNamNgay.contains(ChiEnum.Hoi)
                || chiNamNgay.contains(ChiEnum.Mao)
                || chiNamNgay.contains(ChiEnum.Mui))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.DICH_MA);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui).AddThanSat(Constants.ThanSat.HOA_CAI);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao).AddThanSat(Constants.ThanSat.TUONG_TINH);

            TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.KIEP_SAT);

        }
    }

    private void Dao_Hoa()
    {
        List<ChiEnum> chiNamGio = new ArrayList<>(Arrays.asList(this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).DiaChi.Ten, this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_GIO).DiaChi.Ten));

        //{this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NAM].DiaChi.Ten, this.TTM.LaSoCuaToi.TuTru[Constants.TRU_GIO].DiaChi.Ten};

        if (chiNamGio.contains(ChiEnum.Dan)
                || chiNamGio.contains(ChiEnum.Ngo)
                || chiNamGio.contains(ChiEnum.Tuat))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao).AddThanSat(Constants.ThanSat.DAO_HOA);
        }

        if (chiNamGio.contains(ChiEnum.Ty)
                || chiNamGio.contains(ChiEnum.Dau)
                || chiNamGio.contains(ChiEnum.Suu))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo).AddThanSat(Constants.ThanSat.DAO_HOA);
        }

        if (chiNamGio.contains(ChiEnum.Than)
                || chiNamGio.contains(ChiEnum.Ti)
                || chiNamGio.contains(ChiEnum.Thin))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau).AddThanSat(Constants.ThanSat.DAO_HOA);
        }

        if (chiNamGio.contains(ChiEnum.Hoi)
                || chiNamGio.contains(ChiEnum.Mao)
                || chiNamGio.contains(ChiEnum.Mui))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti).AddThanSat(Constants.ThanSat.DAO_HOA);
        }
    }

    private void Dao_Hoa_Sat()
    {
        CanEnum canNgay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can;

        switch (canNgay)
        {
            case None:
                break;
            case Giap:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            case At:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            case Binh:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            case Dinh:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            case Mau:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            case Ky:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            case Canh:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            case Tan:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            case Nham:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            case Quy:
                TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.DAO_HOA_SAT);
                break;
            default:
                break;
        }
    }

    private void KhongVong()
    {
        Tru ngay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY);

        int canNgayId = TongHopCanChi.getIndexoOfThienCanByEnum(ngay.ThienCan.Can);
        int quyId = TongHopCanChi.getIndexoOfThienCanByEnum(CanEnum.Quy);

        int steps = quyId - canNgayId;
        int chiNgayId = TongHopCanChi.getIndexoOfDiaChiByEnum(ngay.DiaChi.Ten);
        int n = Constants.DIA_CHI_SIZE;

        int kv1 = (chiNgayId + steps + 1) % n;
        int kv2 = (chiNgayId + steps + 2) % n;

        TongHopCanChi.MuoiHaiDiaChi.get(kv1).AddThanSat(Constants.ThanSat.KHONG_VONG);
        TongHopCanChi.MuoiHaiDiaChi.get(kv2).AddThanSat(Constants.ThanSat.KHONG_VONG);
    }

    private void ThienXa()
    {
        ChiEnum chiThang = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_THANG).DiaChi.Ten;

        switch (chiThang)
        {
            case None:
                break;
            case Dan:
            case Mao:
            case Thin:
                SetThanSatTru(CanEnum.Mau, ChiEnum.Dan, Constants.ThanSat.THIEN_XA);
                break;
            case Ty:
            case Ngo:
            case Mui:
                SetThanSatTru(CanEnum.Giap, ChiEnum.Ngo, Constants.ThanSat.THIEN_XA);
                break;
            case Than:
            case Dau:
            case Tuat:
                SetThanSatTru(CanEnum.Mau, ChiEnum.Than, Constants.ThanSat.THIEN_XA);
                break;
            case Hoi:
            case Ti:
            case Suu:
                SetThanSatTru(CanEnum.Giap, ChiEnum.Ti, Constants.ThanSat.THIEN_XA);
                break;
            default:
                break;
        }
    }

    private void HocDuong()
    {
        CanEnum ngay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can;

        ChiEnum chi = ChiEnum.None;
        switch (ngay)
        {
            case None:
                break;
            case Giap:
            case At:
                chi = ChiEnum.Hoi;
                break;
            case Binh:
            case Dinh:
            case Mau:
            case Ky:
                chi = ChiEnum.Dan;
                break;
            case Canh:
            case Tan:
                chi = ChiEnum.Ty;
                break;
            case Nham:
            case Quy:
                chi = ChiEnum.Than;
                break;
            default:
                break;
        }

        if (chi != ChiEnum.None)
        {
            TongHopCanChi.getDiaChiByEnum(chi).AddThanSat(Constants.ThanSat.HOC_DUONG);
        }
    }

    private void TuQuan()
    {
        List<CanEnum> ngayNam = new ArrayList<>(Arrays.asList(this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can, this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.Can));

        //List<CanEnum>{ this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NGAY].ThienCan.Can, this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NAM].ThienCan.Can};

        if (ngayNam.contains(CanEnum.Giap))
        {
            SetThanSatTru(CanEnum.Canh, ChiEnum.Dan, Constants.ThanSat.TU_QUAN);
        }

        if (ngayNam.contains(CanEnum.At))
        {
            SetThanSatTru(CanEnum.Tan, ChiEnum.Mao, Constants.ThanSat.TU_QUAN);
        }

        if (ngayNam.contains(CanEnum.Binh))
        {
            SetThanSatTru(CanEnum.At, ChiEnum.Ty, Constants.ThanSat.TU_QUAN);
        }

        if (ngayNam.contains(CanEnum.Dinh))
        {
            SetThanSatTru(CanEnum.Mau, ChiEnum.Ngo, Constants.ThanSat.TU_QUAN);
        }

        if (ngayNam.contains(CanEnum.Mau))
        {
            SetThanSatTru(CanEnum.Dinh, ChiEnum.Ty, Constants.ThanSat.TU_QUAN);
        }

        if (ngayNam.contains(CanEnum.Ky))
        {
            SetThanSatTru(CanEnum.Canh, ChiEnum.Ngo, Constants.ThanSat.TU_QUAN);
        }

        if (ngayNam.contains(CanEnum.Canh))
        {
            SetThanSatTru(CanEnum.Nham, ChiEnum.Than, Constants.ThanSat.TU_QUAN);
        }

        if (ngayNam.contains(CanEnum.Tan))
        {
            SetThanSatTru(CanEnum.Quy, ChiEnum.Dau, Constants.ThanSat.TU_QUAN);
        }

        if (ngayNam.contains(CanEnum.Nham))
        {
            SetThanSatTru(CanEnum.Quy, ChiEnum.Hoi, Constants.ThanSat.TU_QUAN);
        }

        if (ngayNam.contains(CanEnum.Quy))
        {
            SetThanSatTru(CanEnum.Binh, ChiEnum.Ti, Constants.ThanSat.TU_QUAN);
        }

    }

    private void KimThan()
    {
        List<Tru> ngayGio = new ArrayList<>(Arrays.asList(this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY), this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_GIO)));
                //List<Tru>{this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NGAY], this.TTM.LaSoCuaToi.TuTru[Constants.TRU_GIO]};

        for (Tru tru : ngayGio)
        {
            CanEnum can = tru.ThienCan.Can;
            ChiEnum chi = tru.DiaChi.Ten;
            if ((can == CanEnum.Tan && chi == ChiEnum.Ty)
                    || (can == CanEnum.Quy && chi == ChiEnum.Dau)
                    || (can == CanEnum.At && chi == ChiEnum.Suu))
            {
                tru.AddThanSat(Constants.ThanSat.KIM_THAN);
            }
        }

    }

    private void NguyenThan()
    {
        ChiEnum nam = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).DiaChi.Ten;
        AmDuongEnum amDuong = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong;
        GioiTinhEnum gioi = this.TTM.LaSoCuaToi.GioiTinh;

        int namId = TongHopCanChi.getIndexoOfDiaChiByEnum(nam);
        int n = Constants.DIA_CHI_SIZE;

        int nguyenthanId = -1;
        if ((gioi == GioiTinhEnum.Nam && amDuong == AmDuongEnum.Duong)
                || (gioi == GioiTinhEnum.Nu && amDuong == AmDuongEnum.Am))
        {
            nguyenthanId = (namId + 7) % n;
        }
        else
        {
            nguyenthanId = (namId + 5) % n;
        }

        TongHopCanChi.MuoiHaiDiaChi.get(nguyenthanId).AddThanSat(Constants.ThanSat.NGUYEN_THAN);
    }

    private void TaiSat()
    {
        ChiEnum nam = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).DiaChi.Ten;

        ChiEnum taisat = ChiEnum.None;
        switch (nam)
        {
            case None:
                break;

            case Dan:
            case Ngo:
            case Tuat:
                taisat = ChiEnum.Ti;
                break;

            case Ty:
            case Dau:
            case Suu:
                taisat = ChiEnum.Mao;
                break;

            case Than:
            case Ti:
            case Thin:
                taisat = ChiEnum.Ngo;
                break;

            case Hoi:
            case Mao:
            case Mui:
                taisat = ChiEnum.Dau;
                break;

            default:
                break;
        }
        if (taisat != ChiEnum.None)
        {
            TongHopCanChi.getDiaChiByEnum(taisat).AddThanSat(Constants.ThanSat.TAI_SAT);
        }
    }

    private void QuocAn()
    {
        List<CanEnum> namNgay = new ArrayList<>(Arrays.asList(this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.Can, this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can));

        //List<CanEnum>{this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NAM].ThienCan.Can,this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NGAY].ThienCan.Can};

        if (namNgay.contains(CanEnum.Giap))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat).AddThanSat(Constants.ThanSat.QUOC_AN);
        }

        if (namNgay.contains(CanEnum.At))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.QUOC_AN);
        }

        if (namNgay.contains(CanEnum.Binh)
                || namNgay.contains(CanEnum.Mau))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu).AddThanSat(Constants.ThanSat.QUOC_AN);
        }

        if (namNgay.contains(CanEnum.Dinh)
                || namNgay.contains(CanEnum.Ky))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.QUOC_AN);
        }

        if (namNgay.contains(CanEnum.Canh))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin).AddThanSat(Constants.ThanSat.QUOC_AN);
        }

        if (namNgay.contains(CanEnum.Tan))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.QUOC_AN);
        }

        if (namNgay.contains(CanEnum.Nham))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui).AddThanSat(Constants.ThanSat.QUOC_AN);
        }

        if (namNgay.contains(CanEnum.Quy))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.QUOC_AN);
        }

    }

    private void ThienLaDiaVong()
    {
        TruCollection law = new TruCollection(this.TTM);
        boolean thinId = law.containChi(ChiEnum.Thin);
        boolean tyId = law.containChi(ChiEnum.Ty);
        boolean tuatId = law.containChi(ChiEnum.Tuat);
        boolean hoiId = law.containChi(ChiEnum.Hoi);

        if (thinId && tyId)
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin).AddThanSat(Constants.ThanSat.DIA_VONG);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.DIA_VONG);
        }

        if (tuatId && hoiId)
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat).AddThanSat(Constants.ThanSat.THIEN_LA);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.THIEN_LA);
        }
    }

    private void CauGiao()
    {
        AmDuongEnum amduong = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.AmDuong;
        ChiEnum chiNam = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).DiaChi.Ten;
        GioiTinhEnum gt = this.TTM.LaSoCuaToi.GioiTinh;

        int chiNamId = TongHopCanChi.getIndexoOfDiaChiByEnum(chiNam);
        int n = Constants.DIA_CHI_SIZE;

        if ((gt == GioiTinhEnum.Nam && amduong == AmDuongEnum.Duong)
                || (gt == GioiTinhEnum.Nu && amduong == AmDuongEnum.Am))
        {
            TongHopCanChi.MuoiHaiDiaChi.get((chiNamId + 3) % n).AddThanSat(Constants.ThanSat.CAU);
            TongHopCanChi.MuoiHaiDiaChi.get((chiNamId - 3 + n) % n).AddThanSat(Constants.ThanSat.GIAO);
        }
        else
        {
            TongHopCanChi.MuoiHaiDiaChi.get((chiNamId + 3) % n).AddThanSat(Constants.ThanSat.GIAO);
            TongHopCanChi.MuoiHaiDiaChi.get((chiNamId - 3 + n) % n).AddThanSat(Constants.ThanSat.CAU);
        }
    }

    private void CoThanQuaTu()
    {
        ChiEnum chiNam = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).DiaChi.Ten;

        ChiEnum co = ChiEnum.None, qua = ChiEnum.None;

        switch (chiNam)
        {
            case None:
                break;
            case Hoi:
            case Ti:
            case Suu:
                co = ChiEnum.Dan;
                qua = ChiEnum.Tuat;
                break;
            case Dan:
            case Mao:
            case Thin:
                co = ChiEnum.Ty;
                qua = ChiEnum.Suu;
                break;
            case Ty:
            case Ngo:
            case Mui:
                co = ChiEnum.Than;
                qua = ChiEnum.Thin;
                break;
            case Than:
            case Dau:
            case Tuat:
                co = ChiEnum.Hoi;
                qua = ChiEnum.Mui;
                break;
            default:
                break;
        }

        if (co != ChiEnum.None)
        {
            TongHopCanChi.getDiaChiByEnum(co).AddThanSat(Constants.ThanSat.CO_THAN);
        }

        if (qua != ChiEnum.None)
        {
            TongHopCanChi.getDiaChiByEnum(qua).AddThanSat(Constants.ThanSat.QUA_TU);
        }
    }

    private void ThapAcDaiBai()
    {
        Tru truNgay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY);
        boolean isThapAc = LookUpTable.IsTruMatched(truNgay, CanEnum.Giap, ChiEnum.Thin)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.At, ChiEnum.Ty)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Binh, ChiEnum.Than)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Dinh, ChiEnum.Hoi)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Mau, ChiEnum.Tuat)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Ky, ChiEnum.Suu)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Canh, ChiEnum.Thin)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Tan, ChiEnum.Ty)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Nham, ChiEnum.Than)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Quy, ChiEnum.Hoi)
                ;
        if (isThapAc)
        {
            truNgay.AddThanSat(Constants.ThanSat.THAP_AC_DAI_BAI);
        }
    }

    private void AmDuongSaiThac()
    {
        Tru truNgay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY);
        boolean isADXL = LookUpTable.IsTruMatched(truNgay, CanEnum.Binh, ChiEnum.Ti)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Dinh, ChiEnum.Suu)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Mau, ChiEnum.Dan)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Tan, ChiEnum.Mao)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Nham, ChiEnum.Thin)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Quy, ChiEnum.Ty)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Binh, ChiEnum.Ngo)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Dinh, ChiEnum.Mui)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Mau, ChiEnum.Than)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Tan, ChiEnum.Dau)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Nham, ChiEnum.Tuat)
                || LookUpTable.IsTruMatched(truNgay, CanEnum.Quy, ChiEnum.Hoi)
                ;
        if (isADXL)
        {
            truNgay.AddThanSat(Constants.ThanSat.AM_DUONG_SAI_THAC);
        }
    }

    private void ThaiCucQuyNhan()
    {
        List<CanEnum> ngayNam = new ArrayList<>(Arrays.asList(this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).ThienCan.Can, this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.Can));

        //List<CanEnum>{ this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NGAY].ThienCan.Can, this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NAM].ThienCan.Can};

        if (ngayNam.contains(CanEnum.Giap)
                || ngayNam.contains(CanEnum.At))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ti).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ngo).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
        }

        if (ngayNam.contains(CanEnum.Binh)
                || ngayNam.contains(CanEnum.Dinh))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dau).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Mao).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
        }

        if (ngayNam.contains(CanEnum.Mau)
                || ngayNam.contains(CanEnum.Ky))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Thin).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Tuat).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Suu).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Mui).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
        }

        if (ngayNam.contains(CanEnum.Canh)
                || ngayNam.contains(CanEnum.Tan))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
        }

        if (ngayNam.contains(CanEnum.Nham)
                || ngayNam.contains(CanEnum.Quy))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.THAI_CUC_QUY_NHAN);
        }
    }

    private void DucThan()
    {
        List<CanEnum> canNam = new ArrayList<>(Arrays.asList(this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NAM).ThienCan.Can));

        //List<CanEnum>{this.TTM.LaSoCuaToi.TuTru[Constants.TRU_NAM].ThienCan.Can};

        if (canNam.contains(CanEnum.Giap)
                || canNam.contains(CanEnum.Ky))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Dan).AddThanSat(Constants.ThanSat.DUC_THAN);
        }

        if (canNam.contains(CanEnum.At)
                || canNam.contains(CanEnum.Canh))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Than).AddThanSat(Constants.ThanSat.DUC_THAN);
        }

        if (canNam.contains(CanEnum.Binh)
                || canNam.contains(CanEnum.Tan))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.DUC_THAN);
        }

        if (canNam.contains(CanEnum.Dinh)
                || canNam.contains(CanEnum.Nham))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Hoi).AddThanSat(Constants.ThanSat.DUC_THAN);
        }

        if (canNam.contains(CanEnum.Mau)
                || canNam.contains(CanEnum.Quy))
        {
            TongHopCanChi.getDiaChiByEnum(ChiEnum.Ty).AddThanSat(Constants.ThanSat.DUC_THAN);
        }
    }

    private void CachGiac()
    {
        ChiEnum chiNgay = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_NGAY).DiaChi.Ten;
        Tru truGio = this.TTM.LaSoCuaToi.TuTru.get(Constants.TRU_GIO);

        int ngayId = TongHopCanChi.getIndexoOfDiaChiByEnum(chiNgay);
        int gioId = TongHopCanChi.getIndexoOfDiaChiByEnum(truGio.DiaChi.Ten);
        int n = Constants.DIA_CHI_SIZE;

        if ((ngayId + 2) % n == gioId)
        {
            truGio.AddThanSat(Constants.ThanSat.CACH_GIAC);
        }
    }

    public void SetThanSat()
    {
        ThienAtQuyNhan();
        ThienNguyetDucQuyNhan();
        KhoiCanhQuyNhan();
        LocThan();
        KinhDuong();
        KimDu();
        VanXuong();
        ThienY();
        DichMa_HoaCai_TuongTinh_KiepSat();
        Dao_Hoa();
        Dao_Hoa_Sat();
        KhongVong();
        ThienXa();
        HocDuong();
        TuQuan();
        KimThan();
        NguyenThan();
        TaiSat();
        QuocAn();
        ThienLaDiaVong();
        CauGiao();
        CoThanQuaTu();
        ThapAcDaiBai();
        AmDuongSaiThac();
        ThaiCucQuyNhan();
        DucThan();
        CachGiac();
    }
}
