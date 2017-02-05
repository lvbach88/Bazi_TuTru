package com.vietbachle.bazi_tutru_lib.Data;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by vietbachle on 2/5/2017.
 */

public class LaSo
{
    public GioiTinhEnum GioiTinh; // { get; set; }
    public Hashtable<String, Tru> TuTru; // { get; set; }
    public List<Tru> DaiVan; // { get; set; }
    public List<Tru> TieuVan; // { get; set; }
    public List<Integer> TuoiDaiVan; // { get; set; }
    public Tru CungMenh; // { get; set; }
    public Tru ThaiNguyen; // { get; set; }

    public LaSo()
    {
        GioiTinh = GioiTinhEnum.None;
        TuTru = new Hashtable<String, Tru>();
        DaiVan = new ArrayList<Tru>();
        TieuVan = new ArrayList<Tru>();
        TuoiDaiVan = new ArrayList<Integer>();
    }
}
