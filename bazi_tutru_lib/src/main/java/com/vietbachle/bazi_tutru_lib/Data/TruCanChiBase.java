package com.vietbachle.bazi_tutru_lib.Data;

import java.util.Hashtable;

/**
 * Created by vietbachle on 2/5/2017.
 */

public class TruCanChiBase
{
    public Hashtable<String, Object> ThuocTinh; //{ get; set; }
    public Hashtable<String, Object> ThanSat; // { get; set; }

    public TruCanChiBase()
    {
        this.ThuocTinh = new Hashtable<String, Object>();
        this.ThanSat = new Hashtable<String, Object>();
    }

    public void AddThanSat(String thansat)
    {
        if (!this.ThanSat.containsKey(thansat))
        {
            this.ThanSat.put(thansat, thansat);
        }
    }

    public void ClearThanSat(){
        this.ThanSat.clear();
    }

    public void AddThuocTinh(String tenThuocTinh)
    {
        if (!this.ThuocTinh.containsKey(tenThuocTinh))
        {
            this.ThuocTinh.put(tenThuocTinh, tenThuocTinh);
        }
    }

    public void AddThuocTinh(String tenThuocTinh, Object thuocTinh)
    {
        if (!this.ThuocTinh.containsKey(tenThuocTinh))
        {
            this.ThuocTinh.put(tenThuocTinh, thuocTinh);
        }
    }

    public void ClearThuocTinh(){
        this.ThuocTinh.clear();
    }
}