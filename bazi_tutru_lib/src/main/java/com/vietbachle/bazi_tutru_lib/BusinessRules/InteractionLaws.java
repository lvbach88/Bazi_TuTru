package com.vietbachle.bazi_tutru_lib.BusinessRules;

import com.vietbachle.bazi_tutru_lib.Data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vietbachle on 2/13/2017.
 */

public class InteractionLaws {

    private List<Tru> TatcaTru; // { get; private set; }

    private List<Tru> TuTru; // { get; private set; }

    public InteractionLaws()
    {
    }

    public InteractionLaws(TuTruMap ttm)
    {
        this.Init(ttm);
    }

    private void Init(TuTruMap ttm)
    {
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

    private void setNguHop(){

    }

//    private void setNguHop

}
