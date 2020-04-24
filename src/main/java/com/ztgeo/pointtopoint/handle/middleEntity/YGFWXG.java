package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 预告房屋相关
 */
public class YGFWXG {
    private String zl;//坐落
    private String ghyt;//规划用途
    private String jzmj;//建筑面积
    private String bdcdyh;//不动产单元号
    private String tstybm;//图属统一编码
    private String tdsyqr;//土地使用权人
    private String fwxz;//房屋性质
    private String fwjg;//房屋结构
    private String qdjg;//取得价格

    public YGFWXG() {
    }

    public YGFWXG(String zl, String ghyt, String jzmj, String bdcdyh, String tstybm, String tdsyqr, String fwxz, String fwjg, String qdjg) {
        this.zl = zl;
        this.ghyt = ghyt;
        this.jzmj = jzmj;
        this.bdcdyh = bdcdyh;
        this.tstybm = tstybm;
        this.tdsyqr = tdsyqr;
        this.fwxz = fwxz;
        this.fwjg = fwjg;
        this.qdjg = qdjg;
    }

    public String getQdjg() {
        return qdjg;
    }

    public void setQdjg(String qdjg) {
        this.qdjg = qdjg;
    }

    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl;
    }

    public String getGhyt() {
        return ghyt;
    }

    public void setGhyt(String ghyt) {
        this.ghyt = ghyt;
    }

    public String getJzmj() {
        return jzmj;
    }

    public void setJzmj(String jzmj) {
        this.jzmj = jzmj;
    }

    public String getBdcdyh() {
        return bdcdyh;
    }

    public void setBdcdyh(String bdcdyh) {
        this.bdcdyh = bdcdyh;
    }

    public String getTstybm() {
        return tstybm;
    }

    public void setTstybm(String tstybm) {
        this.tstybm = tstybm;
    }

    public String getTdsyqr() {
        return tdsyqr;
    }

    public void setTdsyqr(String tdsyqr) {
        this.tdsyqr = tdsyqr;
    }

    public String getFwxz() {
        return fwxz;
    }

    public void setFwxz(String fwxz) {
        this.fwxz = fwxz;
    }

    public String getFwjg() {
        return fwjg;
    }

    public void setFwjg(String fwjg) {
        this.fwjg = fwjg;
    }

    @Override
    public String toString() {
        return "YGFWXG{" +
                "zl='" + zl + '\'' +
                ", ghyt='" + ghyt + '\'' +
                ", jzmj='" + jzmj + '\'' +
                ", bdcdyh='" + bdcdyh + '\'' +
                ", tstybm='" + tstybm + '\'' +
                ", tdsyqr='" + tdsyqr + '\'' +
                ", fwxz='" + fwxz + '\'' +
                ", fwjg='" + fwjg + '\'' +
                ", qdjg='" + qdjg + '\'' +
                '}';
    }
}
