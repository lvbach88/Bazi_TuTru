package com.vietbachle.bazi_tutru_lib.BusinessRules;

import android.util.Pair;

import com.vietbachle.bazi_tutru_lib.Data.*;

import java.util.Calendar;
import java.util.Hashtable;

/**
 * Created by vietbachle on 2/8/2017.
 */

public final class LookUpTable {

    private LookUpTable(){}

    /// <summary>
    /// To be used for Tru
    /// Return NguHanh given Can and Chi
    /// </summary>
    public static Hashtable<Pair<CanEnum, ChiEnum>, NguHanhEnum> NapAm;

    /// <summary>
    /// To be used for Ngu Hanh Tuong Sinh Tuong Khac
    /// Return Sinh, Duoc Sinh, Khac, Bi Khac respectively
    /// </summary>
//    public static Hashtable<NguHanhEnum, Tuple<NguHanhEnum, NguHanhEnum, NguHanhEnum, NguHanhEnum>> NguHanhSinhKhac;

    //NguHanhEnum[] contains 4 elements: Sinh, Duoc Sinh, Khac, Bi Khac respectively
    public static Hashtable<NguHanhEnum, NguHanhEnum[]> NguHanhSinhKhac;

    public static void Init()
    {
        napAm_Init();
        nguHanhSinhKhac_Init();
    }


    /// <summary>
    /// Return the phase of Vong Truong Sinh given "can ngay" and "chi can tim"
    /// </summary>
    /// <param name="canNgay">"can ngay"</param>
    /// <param name="chi">"chi can tim"</param>
    /// <returns></returns>
    public static GiaiDoanTruongSinhEnum VongTruongSinh(CanEnum canNgay, ChiEnum chi)
    {
        int direction = 1; //1: forward, -1: backward
        int start = 0;

        switch (canNgay)
        {
            case None:
                break;
            case Giap:
                start = TongHopCanChi.getIndexoOfDiaChiByEnum(ChiEnum.Hoi); //11; //Hoi
                direction = 1;
                break;
            case At:
                start = TongHopCanChi.getIndexoOfDiaChiByEnum(ChiEnum.Ngo); //6; //Ngo
                direction = -1;
                break;
            case Binh:
            case Mau:
                start = TongHopCanChi.getIndexoOfDiaChiByEnum(ChiEnum.Dan); //2; //Dan
                direction = 1;
                break;
            case Dinh:
            case Ky:
                start = TongHopCanChi.getIndexoOfDiaChiByEnum(ChiEnum.Dau); //9; //Dau
                direction = -1;
                break;
            case Canh:
                start = TongHopCanChi.getIndexoOfDiaChiByEnum(ChiEnum.Ty); //5; //Ty
                direction = 1;
                break;
            case Tan:
                start = TongHopCanChi.getIndexoOfDiaChiByEnum(ChiEnum.Ti); //0; //Ti
                direction = -1;
                break;
            case Nham:
                start = TongHopCanChi.getIndexoOfDiaChiByEnum(ChiEnum.Than); //8; //Than
                direction = 1;
                break;
            case Quy:
                start = TongHopCanChi.getIndexoOfDiaChiByEnum(ChiEnum.Mao); //3; //Mao
                direction = -1;
                break;
            default:
                break;
        }

        int dest = TongHopCanChi.getIndexoOfDiaChiByEnum(chi);
        int n = TongHopCanChi.MuoiHaiDiaChi.size();

        int steps = (direction * (dest - start) + n) % n;

        return GiaiDoanTruongSinhEnum.fromInteger(steps + 1); //GiaiDoanTruongSinh starts with 1
    }

    /// <summary>
    /// NguHoDon: Find the correct Tru with Can and Chi
    /// </summary>
    /// <param name="canNam">finding is based on canNam</param>
    /// <param name="chiToBeFound">to-be-found Chi</param>
    /// <returns>Tru with Can and Chi</returns>
    public static Tru NguHoDon(CanEnum canNam, ChiEnum chiToBeFound)
    {
        CanEnum canStart = CanEnum.None;
        ChiEnum chiStart = ChiEnum.Dan;

        switch (canNam)
        {
            case None:
                break;
            case Giap:
            case Ky:
                canStart = CanEnum.Binh;
                break;
            case At:
            case Canh:
                canStart = CanEnum.Mau;
                break;
            case Binh:
            case Tan:
                canStart = CanEnum.Canh;
                break;
            case Dinh:
            case Nham:
                canStart = CanEnum.Nham;
                break;
            case Mau:
            case Quy:
                canStart = CanEnum.Giap;
                break;
            default:
                break;
        }

        int nChi = TongHopCanChi.MuoiHaiDiaChi.size();
        int chiStartIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(chiStart);
        int chiDestIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(chiToBeFound);
        int steps = (chiDestIndex - chiStartIndex + nChi) % nChi;

        int canStartIndex = TongHopCanChi.getIndexoOfThienCanByEnum(canStart);
        int nCan = TongHopCanChi.MuoiThienCan.size();
        int canDestIndex = (canStartIndex + steps) % nCan;


        ThienCan thienCan = TongHopCanChi.MuoiThienCan.get(canDestIndex);
        DiaChi diaChi = TongHopCanChi.MuoiHaiDiaChi.get(chiDestIndex);


        return new Tru(thienCan, diaChi);
    }

    /// <summary>
    /// NguThuDon: Find the correct Tru with Can and Chi
    /// </summary>
    /// <param name="canNgay">Finding is based on canNgay</param>
    /// <param name="chiToBeFound">to-be-found chi</param>
    /// <returns>Tru with Can and Chi</returns>
    public static Tru NguThuDon(CanEnum canNgay, ChiEnum chiToBeFound)
    {
        CanEnum canStart = CanEnum.None;
        ChiEnum chiStart = ChiEnum.Ti;

        switch (canNgay)
        {
            case None:
                break;
            case Giap:
            case Ky:
                canStart = CanEnum.Giap;
                break;
            case At:
            case Canh:
                canStart = CanEnum.Binh;
                break;
            case Binh:
            case Tan:
                canStart = CanEnum.Mau;
                break;
            case Dinh:
            case Nham:
                canStart = CanEnum.Canh;
                break;
            case Mau:
            case Quy:
                canStart = CanEnum.Nham;
                break;
            default:
                break;
        }

        int nChi = TongHopCanChi.MuoiHaiDiaChi.size();
        int chiStartIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(chiStart);
        int chiDestIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(chiToBeFound);
        int steps = (chiDestIndex - chiStartIndex + nChi) % nChi;

        int canStartIndex = TongHopCanChi.getIndexoOfThienCanByEnum(canStart);
        int nCan = TongHopCanChi.MuoiThienCan.size();
        int canDestIndex = (canStartIndex + steps) % nCan;


        ThienCan thienCan = TongHopCanChi.MuoiThienCan.get(canDestIndex);
        DiaChi diaChi = TongHopCanChi.MuoiHaiDiaChi.get(chiDestIndex);


        return new Tru(thienCan, diaChi);
    }

    /// <summary>
    /// Return Tru of a year
    /// </summary>
    /// <param name="year">if not passed, current year is used.</param>
    /// <returns></returns>
    public static Tru TruOfTheYear(int year)
    {
        if (year == Integer.MIN_VALUE)
        {
            year = Calendar.getInstance().get(Calendar.YEAR);
        }

        int direction = 0;

        if (year >= Constants.SEEDING_YEAR)
        {
            direction = 1;
        }
        else
        {
            direction = -1;
        }

        int diff = Math.abs(year - Constants.SEEDING_YEAR);

        int canIndex = TongHopCanChi.getIndexoOfThienCanByEnum(Constants.SEEDING_CAN);
        int chiIndex = TongHopCanChi.getIndexoOfDiaChiByEnum(Constants.SEEDING_CHI);

        int nCan = TongHopCanChi.MuoiThienCan.size();
        int nChi = TongHopCanChi.MuoiHaiDiaChi.size();

        for (int i = 0; i < diff; i++)
        {
            canIndex = (canIndex + nCan + direction) % nCan;
            chiIndex = (chiIndex + nChi + direction) % nChi;
        }

        return new Tru(TongHopCanChi.MuoiThienCan.get(canIndex), TongHopCanChi.MuoiHaiDiaChi.get(chiIndex));
    }

    public static Tru TruOfTheYear(){
        return TruOfTheYear(Integer.MIN_VALUE);
    }

    public static boolean IsTruMatched(Tru t, CanEnum can, ChiEnum chi)
    {
        return t.ThienCan.Can == can && t.DiaChi.Ten == chi;
    }

    /// <summary>
    /// Create NapAm dictionary
    /// </summary>
    private static void napAm_Init()
    {
        Hashtable<Pair<CanEnum, ChiEnum>, NguHanhEnum> napAm = new Hashtable<>();

        //this method will create NapAm table which contains invalid Tru, e.g. At Thin...
        for (DiaChi diaChi : TongHopCanChi.MuoiHaiDiaChi)
        {
            for (ThienCan thienCan : TongHopCanChi.MuoiThienCan)
            {
                switch (diaChi.Ten)
                {
                    case Ti:
                    case Ngo:
                    case Suu:
                    case Mui:

                        if (thienCan.Can == CanEnum.Giap || thienCan.Can == CanEnum.At)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Kim);
                        }

                        if (thienCan.Can == CanEnum.Binh || thienCan.Can == CanEnum.Dinh)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Thuy);
                        }

                        if (thienCan.Can == CanEnum.Mau || thienCan.Can == CanEnum.Ky)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Hoa);
                        }

                        if (thienCan.Can == CanEnum.Canh || thienCan.Can == CanEnum.Tan)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Tho);
                        }

                        if (thienCan.Can == CanEnum.Nham || thienCan.Can == CanEnum.Quy)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Moc);
                        }

                        break;

                    case Dan:
                    case Than:
                    case Mao:
                    case Dau:

                        if (thienCan.Can == CanEnum.Giap || thienCan.Can == CanEnum.At)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Thuy);
                        }

                        if (thienCan.Can == CanEnum.Binh || thienCan.Can == CanEnum.Dinh)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Hoa);
                        }

                        if (thienCan.Can == CanEnum.Mau || thienCan.Can == CanEnum.Ky)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Tho);
                        }

                        if (thienCan.Can == CanEnum.Canh || thienCan.Can == CanEnum.Tan)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Moc);
                        }

                        if (thienCan.Can == CanEnum.Nham || thienCan.Can == CanEnum.Quy)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Kim);
                        }

                        break;

                    case Thin:
                    case Tuat:
                    case Ty:
                    case Hoi:

                        if (thienCan.Can == CanEnum.Giap || thienCan.Can == CanEnum.At)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Hoa);
                        }

                        if (thienCan.Can == CanEnum.Binh || thienCan.Can == CanEnum.Dinh)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Tho);
                        }

                        if (thienCan.Can == CanEnum.Mau || thienCan.Can == CanEnum.Ky)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Moc);
                        }

                        if (thienCan.Can == CanEnum.Canh || thienCan.Can == CanEnum.Tan)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Kim);
                        }

                        if (thienCan.Can == CanEnum.Nham || thienCan.Can == CanEnum.Quy)
                        {
                            napAm.put(new Pair<>(thienCan.Can, diaChi.Ten), NguHanhEnum.Thuy);
                        }

                        break;
                    default:
                        break;
                }
            }
        }

        NapAm = napAm;
    }

    private static void nguHanhSinhKhac_Init()
    {
        NguHanhSinhKhac = new Hashtable<>();
        NguHanhEnum[] kim = new NguHanhEnum[]{NguHanhEnum.Thuy, NguHanhEnum.Tho, NguHanhEnum.Moc, NguHanhEnum.Hoa};
        NguHanhSinhKhac.put(NguHanhEnum.Kim, kim);

        NguHanhEnum[] thuy = new NguHanhEnum[]{NguHanhEnum.Moc, NguHanhEnum.Kim, NguHanhEnum.Hoa, NguHanhEnum.Tho};
        NguHanhSinhKhac.put(NguHanhEnum.Thuy, thuy);

        NguHanhEnum[] moc = new NguHanhEnum[]{NguHanhEnum.Hoa, NguHanhEnum.Thuy, NguHanhEnum.Tho, NguHanhEnum.Kim};
        NguHanhSinhKhac.put(NguHanhEnum.Moc, moc);

        NguHanhEnum[] hoa = new NguHanhEnum[]{NguHanhEnum.Tho, NguHanhEnum.Moc, NguHanhEnum.Kim, NguHanhEnum.Thuy};
        NguHanhSinhKhac.put(NguHanhEnum.Hoa, hoa);

        NguHanhEnum[] tho = new NguHanhEnum[]{NguHanhEnum.Kim, NguHanhEnum.Hoa, NguHanhEnum.Thuy, NguHanhEnum.Moc};
        NguHanhSinhKhac.put(NguHanhEnum.Tho, tho);
    }


}
