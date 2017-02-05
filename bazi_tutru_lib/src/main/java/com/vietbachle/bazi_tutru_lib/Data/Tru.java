package com.vietbachle.bazi_tutru_lib.Data;

/**
 * Created by vietbachle on 2/5/2017.
 */

/// <summary>
/// Represent one Tru
/// </summary>
public class Tru extends TruCanChiBase {
    public ThienCan ThienCan; // { get; private set; }
    public DiaChi DiaChi; // { get; private set; }

    public Tru(ThienCan can, DiaChi chi) {
        super();
        this.ThienCan = can;
        this.DiaChi = chi;
    }
}

