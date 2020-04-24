package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 义务人
 */
public class YWR {
    private String qlrmc;//权利人名称
    private String zjhm;//证件号码
    private String zjzl;//证件种类

    public YWR() {
    }

    public YWR(String qlrmc, String zjhm, String zjzl) {
        this.qlrmc = qlrmc;
        this.zjhm = zjhm;
        this.zjzl = zjzl;
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

    public String getZjzl() {
        return zjzl;
    }

    public void setZjzl(String zjzl) {
        this.zjzl = zjzl;
    }

    @Override
    public String toString() {
        return "YWR{" +
                "qlrmc='" + qlrmc + '\'' +
                ", zjhm='" + zjhm + '\'' +
                ", zjzl='" + zjzl + '\'' +
                '}';
    }
}
