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
    public GiaiDoanTruongSinhEnum VongTruongSinh;
    public AmDuongEnum AmDuong;

    public DiaChi(ChiEnum chi, ThienCan bankhi, ThienCan trungkhi, ThienCan tapkhi)
    {
        super();
        this.Ten = chi;
        this.BanKhi = bankhi;
        this.TrungKhi = trungkhi;
        this.TapKhi = tapkhi;
        this.VongTruongSinh = GiaiDoanTruongSinhEnum.None;
        initAmDuong();
    }

    private void initAmDuong(){
        switch (this.Ten){
            case Ti:
            case Dan:
            case Thin:
            case Ngo:
            case Than:
            case Tuat:
                this.AmDuong = AmDuongEnum.Duong;
                break;
            case Suu:
            case Hoi:
            case Dau:
            case Mui:
            case Ty:
            case Mao:
                this.AmDuong = AmDuongEnum.Am;
                break;
            default:
                this.AmDuong = AmDuongEnum.None;
        }

    }

}