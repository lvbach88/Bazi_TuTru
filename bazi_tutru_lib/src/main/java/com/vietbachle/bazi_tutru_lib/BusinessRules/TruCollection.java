package com.vietbachle.bazi_tutru_lib.BusinessRules;

import com.vietbachle.bazi_tutru_lib.Data.CanEnum;
import com.vietbachle.bazi_tutru_lib.Data.ChiEnum;
import com.vietbachle.bazi_tutru_lib.Data.Constants;
import com.vietbachle.bazi_tutru_lib.Data.LaSo;
import com.vietbachle.bazi_tutru_lib.Data.Tru;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vietbachle on 2/26/2017.
 */

public class TruCollection {
    public List<Tru> TatcaTru; // { get; private set; }

    public List<Tru> TuTru; // { get; private set; }

    public TruCollection() {
    }

    public TruCollection(TuTruMap ttm) {
        this.Init(ttm);
    }

    protected void Init(TuTruMap ttm) {
        LaSo laso = ttm.LaSoCuaToi;
        TatcaTru = new ArrayList<>();
        TuTru = new ArrayList<>();

        TuTru.add(laso.TuTru.get(Constants.TRU_NAM));
        TuTru.add(laso.TuTru.get(Constants.TRU_THANG));
        TuTru.add(laso.TuTru.get(Constants.TRU_NGAY));
        TuTru.add(laso.TuTru.get(Constants.TRU_GIO));

        TatcaTru.add(laso.TuTru.get(Constants.TRU_NAM));
        TatcaTru.add(laso.TuTru.get(Constants.TRU_THANG));
        TatcaTru.add(laso.TuTru.get(Constants.TRU_NGAY));
        TatcaTru.add(laso.TuTru.get(Constants.TRU_GIO));
        TatcaTru.add(laso.CungMenh);
        TatcaTru.add(laso.ThaiNguyen);
        TatcaTru.add(ttm.DaiVanHienTai);
        TatcaTru.add(ttm.LuuNien);
    }

    protected boolean containCan(CanEnum canEnum) {
        for (Tru tru :
                TatcaTru) {
            if (tru.ThienCan.Can == canEnum) return true;
        }
        return false;
    }

    protected boolean containChi(ChiEnum chiEnum) {
        for (Tru tru :
                TatcaTru) {
            if (tru.DiaChi.Ten == chiEnum) return true;
        }
        return false;
    }
}
