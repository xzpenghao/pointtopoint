package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 共有人
 */
public class GYR {
    private String gyfe;//共有份额
    private String qlrmc;//权利人名称
    private String zjhm;//证件号码
    private String dh;//电话

    public GYR() {
    }

    public GYR(String gyfe, String qlrmc, String zjhm, String dh) {
        this.gyfe = gyfe;
        this.qlrmc = qlrmc;
        this.zjhm = zjhm;
        this.dh = dh;
    }

    public String getGyfe() {
        return gyfe;
    }

    public void setGyfe(String gyfe) {
        this.gyfe = gyfe;
    }

    public String getQlrmc() {
        return qlrmc;
    }

    public void setQlrmc(String qlrmc) {
        this.qlrmc = qlrmc;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }
}
