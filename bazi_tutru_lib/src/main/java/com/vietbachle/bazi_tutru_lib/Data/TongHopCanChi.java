package com.vietbachle.bazi_tutru_lib.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vietbachle on 2/5/2017.
 */

/// <summary>
/// This class contains only 2 sets
/// one is MuoiHaiDiaChi
/// the other is MuoiThienCan
/// </summary>
public final class TongHopCanChi
{
    public static List<DiaChi> MuoiHaiDiaChi;
    public static List<ThienCan> MuoiThienCan;

    private TongHopCanChi(){}

    public static void Init()
    {
//        #region MuoiThienCan

        MuoiThienCan = new ArrayList<ThienCan>();

        MuoiThienCan.add(new ThienCan(CanEnum.Giap));
        MuoiThienCan.add(new ThienCan(CanEnum.At));

        MuoiThienCan.add(new ThienCan(CanEnum.Binh));
        MuoiThienCan.add(new ThienCan(CanEnum.Dinh));

        MuoiThienCan.add(new ThienCan(CanEnum.Mau));
        MuoiThienCan.add(new ThienCan(CanEnum.Ky));

        MuoiThienCan.add(new ThienCan(CanEnum.Canh));
        MuoiThienCan.add(new ThienCan(CanEnum.Tan));

        MuoiThienCan.add(new ThienCan(CanEnum.Nham));
        MuoiThienCan.add(new ThienCan(CanEnum.Quy));
//        #endregion MuoiThienCan

//        #region MuoiHaiDiaChi

        MuoiHaiDiaChi = new ArrayList<DiaChi>();

        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Ti,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Quy),//new ThienCan(CanEnum.Quy),
                getThienCan(CanEnum.Quy),
                null,
                null));
        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Suu,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Ky), //new ThienCan(CanEnum.Ky),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Quy), //new ThienCan(CanEnum.Quy),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Tan) //new ThienCan(CanEnum.Tan)
                getThienCan(CanEnum.Ky),
                getThienCan(CanEnum.Quy),
                getThienCan(CanEnum.Tan)
        ));
        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Dan,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Giap),//new ThienCan(CanEnum.Giap),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Binh),//new ThienCan(CanEnum.Binh),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Mau)//new ThienCan(CanEnum.Mau)
                getThienCan(CanEnum.Giap),
                getThienCan(CanEnum.Binh),
                getThienCan(CanEnum.Mau)
        ));
        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Mao,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.At), //new ThienCan(CanEnum.At),
                getThienCan(CanEnum.At),
                null,
                null));

        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Thin,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Mau), //new ThienCan(CanEnum.Mau),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.At), //new ThienCan(CanEnum.At),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Quy) //new ThienCan(CanEnum.Quy)
                getThienCan(CanEnum.Mau),
                getThienCan(CanEnum.At),
                getThienCan(CanEnum.Quy)
        ));
        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Ty,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Binh), //new ThienCan(CanEnum.Binh),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Canh), //new ThienCan(CanEnum.Canh),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Mau) //, new ThienCan(CanEnum.Mau)
                getThienCan(CanEnum.Binh),
                getThienCan(CanEnum.Canh),
                getThienCan(CanEnum.Mau)
        ));
        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Ngo,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Dinh), //new ThienCan(CanEnum.Dinh),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Ky), //new ThienCan(CanEnum.Ky),
                getThienCan(CanEnum.Dinh),
                getThienCan(CanEnum.Ky),
                null));
        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Mui,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Ky), //new ThienCan(CanEnum.Ky),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Dinh), //new ThienCan(CanEnum.Dinh),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.At) //, new ThienCan(CanEnum.At)
                getThienCan(CanEnum.Ky),
                getThienCan(CanEnum.Dinh),
                getThienCan(CanEnum.At)
        ));

        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Than,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Canh), //new ThienCan(CanEnum.Canh),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Nham), //new ThienCan(CanEnum.Nham),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Mau) //, new ThienCan(CanEnum.Mau)
                getThienCan(CanEnum.Canh),
                getThienCan(CanEnum.Nham),
                getThienCan(CanEnum.Mau)
        ));
        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Dau,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Tan), //new ThienCan(CanEnum.Tan),
                getThienCan(CanEnum.Tan),
                null,
                null));
        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Tuat,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Mau), //new ThienCan(CanEnum.Mau),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Tan), //new ThienCan(CanEnum.Tan),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Dinh) //, new ThienCan(CanEnum.Dinh)
                getThienCan(CanEnum.Mau),
                getThienCan(CanEnum.Tan),
                getThienCan(CanEnum.Dinh)
        ));
        MuoiHaiDiaChi.add(new DiaChi(ChiEnum.Hoi,
//                        MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Nham), //new ThienCan(CanEnum.Nham),
//                MuoiThienCan.Single<ThienCan>(u => u.Can == CanEnum.Giap), //new ThienCan(CanEnum.Giap),
                getThienCan(CanEnum.Nham),
                getThienCan(CanEnum.Giap),
                null));
//        #endregion MuoiHaiDiaChi

    }

    public static ThienCan getThienCan(CanEnum canEnum){
        for (ThienCan tc :
                MuoiThienCan) {
            if (tc.Can == canEnum){
                return tc;
            }
        }

        return null;

    }

    public static int getIndexoOfThienCan(CanEnum canEnum){
        for (int i = 0; i < MuoiThienCan.size(); i++){
            if (MuoiThienCan.get(i).Can == canEnum) return i;
        }

        return -1;
    }

    public static DiaChi getDiaChi(ChiEnum chiEnum){
        for (DiaChi dc :
                MuoiHaiDiaChi) {
            if (dc.Ten == chiEnum) return dc;
        }

        return null;
    }

    public static int getIndexoOfDiaChi(ChiEnum chiEnum){
        for (int i = 0; i < MuoiHaiDiaChi.size(); i++){
            if (MuoiHaiDiaChi.get(i).Ten == chiEnum) return i;
        }

        return -1;
    }
}

