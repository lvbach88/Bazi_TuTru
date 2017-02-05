package com.vietbachle.bazi_tutru_lib.Data;

/**
 * Created by vietbachle on 2/5/2017.
 */

/// <summary>
/// ThienCan with name and NguHanh, Am Duong
/// </summary>
class ThienCan extends TruCanChiBase
{
    public CanEnum Can; // { get; private set; }
    public NguHanhEnum NguHanh; // { get; private set; }
    public AmDuongEnum AmDuong; // { get; private set; }
    public ThapThanEnum ThapThan; // { get; set; }

    public ThienCan(CanEnum can)
    {
        super();
        this.Can = can;
        Init();
    }

    private void Init()
    {
        switch (this.Can)
        {
            case None:
                break;
            case Giap:
                this.NguHanh = NguHanhEnum.Moc;
                this.AmDuong = AmDuongEnum.Duong;
                break;
            case At:
                this.NguHanh = NguHanhEnum.Moc;
                this.AmDuong = AmDuongEnum.Am;
                break;
            case Binh:
                this.NguHanh = NguHanhEnum.Hoa;
                this.AmDuong = AmDuongEnum.Duong;
                break;
            case Dinh:
                this.NguHanh = NguHanhEnum.Hoa;
                this.AmDuong = AmDuongEnum.Am;
                break;
            case Mau:
                this.NguHanh = NguHanhEnum.Tho;
                this.AmDuong = AmDuongEnum.Duong;
                break;
            case Ky:
                this.NguHanh = NguHanhEnum.Tho;
                this.AmDuong = AmDuongEnum.Am;
                break;
            case Canh:
                this.NguHanh = NguHanhEnum.Kim;
                this.AmDuong = AmDuongEnum.Duong;
                break;
            case Tan:
                this.NguHanh = NguHanhEnum.Kim;
                this.AmDuong = AmDuongEnum.Am;
                break;
            case Nham:
                this.NguHanh = NguHanhEnum.Thuy;
                this.AmDuong = AmDuongEnum.Duong;
                break;
            case Quy:
                this.NguHanh = NguHanhEnum.Thuy;
                this.AmDuong = AmDuongEnum.Am;
                break;
            default:
                break;
        }

        this.ThapThan = ThapThanEnum.None;
    }
}