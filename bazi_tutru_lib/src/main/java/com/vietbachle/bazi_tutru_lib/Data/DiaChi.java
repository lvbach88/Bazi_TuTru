package com.vietbachle.bazi_tutru_lib.Data;

/**
 * Created by vietbachle on 2/5/2017.
 */

/// <summary>
/// DiaChi with name and hidden Can
/// </summary>
public class DiaChi extends TruCanChiBase
{
    public ChiEnum Ten; // { get; private set; }
    public ThienCan BanKhi; // { get; private set; }
    public ThienCan TrungKhi; // { get; private set; }
    public ThienCan TapKhi; // { get; private set; }

    public DiaChi(ChiEnum chi, ThienCan bankhi, ThienCan trungkhi, ThienCan tapkhi)
    {
        super();
        this.Ten = chi;
        this.BanKhi = bankhi;
        this.TrungKhi = trungkhi;
        this.TapKhi = tapkhi;
    }

}