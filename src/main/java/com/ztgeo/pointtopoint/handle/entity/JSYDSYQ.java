package com.ztgeo.pointtopoint.handle.entity;

/**
 * 建设用地使用权
 */
public class JSYDSYQ {
    private String id;
    private String cxrid;
    private String bdcdyh;//不动产单元号
    private String zl;//坐落
    private String yt;//用途
    private String syqmj;//使用权面积
    private String qlxz;//权力性质
    private String syqqssj;//使用权起始时间
    private String syqjssj;//使用权结束时间
    private String bdcqzh;//不动产权证号
    private String djjg;//登记机构
    private String djsj;//登记时间
    private String gyfs;//共有方式
    private String gyr;//共有人
    private String gyqk;//共有情况
    private String qszt;//权属状态
    private String ywh;//业务号
    private String qlrdh;//权利人电话
    private String qxdm;//区县代码
    private String qllx;//权力类型
    private String sfdy;//是否抵押
    private String sfcf;//是否查封
    private String qdjg;//取得价格

    public JSYDSYQ() {
        super();
        // TODO Auto-generated constructor stub
    }

    public JSYDSYQ(String id, String cxrid, String bdcdyh, String zl, String yt, String syqmj, String qlxz, String syqqssj, String syqjssj, String bdcqzh, String djjg, String djsj, String gyfs, String gyr, String gyqk, String qszt, String ywh, String qlrdh, String qxdm, String qllx, String sfdy, String sfcf, String qdjg) {
        this.id = id;
        this.cxrid = cxrid;
        this.bdcdyh = bdcdyh;
        this.zl = zl;
        this.yt = yt;
        this.syqmj = syqmj;
        this.qlxz = qlxz;
        this.syqqssj = syqqssj;
        this.syqjssj = syqjssj;
        this.bdcqzh = bdcqzh;
        this.djjg = djjg;
        this.djsj = djsj;
        this.gyfs = gyfs;
        this.gyr = gyr;
        this.gyqk = gyqk;
        this.qszt = qszt;
        this.ywh = ywh;
        this.qlrdh = qlrdh;
        this.qxdm = qxdm;
        this.qllx = qllx;
        this.sfdy = sfdy;
        this.sfcf = sfcf;
        this.qdjg = qdjg;
    }

    public String getCxrid() {
        return cxrid;
    }

    public void setCxrid(String cxrid) {
        this.cxrid = cxrid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBdcdyh() {
        return bdcdyh;
    }

    public void setBdcdyh(String bdcdyh) {
        this.bdcdyh = bdcdyh;
    }

    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public String getSyqmj() {
        return syqmj;
    }

    public void setSyqmj(String syqmj) {
        this.syqmj = syqmj;
    }

    public String getQlxz() {
        return qlxz;
    }

    public void setQlxz(String qlxz) {
        this.qlxz = qlxz;
    }

    public String getSyqqssj() {
        return syqqssj;
    }

    public void setSyqqssj(String syqqssj) {
        this.syqqssj = syqqssj;
    }

    public String getSyqjssj() {
        return syqjssj;
    }

    public void setSyqjssj(String syqjssj) {
        this.syqjssj = syqjssj;
    }

    public String getBdcqzh() {
        return bdcqzh;
    }

    public void setBdcqzh(String bdcqzh) {
        this.bdcqzh = bdcqzh;
    }

    public String getDjjg() {
        return djjg;
    }

    public void setDjjg(String djjg) {
        this.djjg = djjg;
    }

    public String getDjsj() {
        return djsj;
    }

    public void setDjsj(String djsj) {
        this.djsj = djsj;
    }

    public String getGyfs() {
        return gyfs;
    }

    public void setGyfs(String gyfs) {
        this.gyfs = gyfs;
    }

    public String getGyr() {
        return gyr;
    }

    public void setGyr(String gyr) {
        this.gyr = gyr;
    }

    public String getGyqk() {
        return gyqk;
    }

    public void setGyqk(String gyqk) {
        this.gyqk = gyqk;
    }

    public String getQszt() {
        return qszt;
    }

    public void setQszt(String qszt) {
        this.qszt = qszt;
    }

    public String getYwh() {
        return ywh;
    }

    public void setYwh(String ywh) {
        this.ywh = ywh;
    }

    public String getQlrdh() {
        return qlrdh;
    }

    public void setQlrdh(String qlrdh) {
        this.qlrdh = qlrdh;
    }

    public String getQxdm() {
        return qxdm;
    }

    public void setQxdm(String qxdm) {
        this.qxdm = qxdm;
    }

    public String getQllx() {
        return qllx;
    }

    public void setQllx(String qllx) {
        this.qllx = qllx;
    }

    public String getSfdy() {
        return sfdy;
    }

    public void setSfdy(String sfdy) {
        this.sfdy = sfdy;
    }

    public String getSfcf() {
        return sfcf;
    }

    public void setSfcf(String sfcf) {
        this.sfcf = sfcf;
    }

    public String getQdjg() {
        return qdjg;
    }

    public void setQdjg(String qdjg) {
        this.qdjg = qdjg;
    }

    @Override
    public String toString() {
        return "JSYDSYQ{" +
                "id='" + id + '\'' +
                ", cxrid='" + cxrid + '\'' +
                ", bdcdyh='" + bdcdyh + '\'' +
                ", zl='" + zl + '\'' +
                ", yt='" + yt + '\'' +
                ", syqmj='" + syqmj + '\'' +
                ", qlxz='" + qlxz + '\'' +
                ", syqqssj='" + syqqssj + '\'' +
                ", syqjssj='" + syqjssj + '\'' +
                ", bdcqzh='" + bdcqzh + '\'' +
                ", djjg='" + djjg + '\'' +
                ", djsj='" + djsj + '\'' +
                ", gyfs='" + gyfs + '\'' +
                ", gyr='" + gyr + '\'' +
                ", gyqk='" + gyqk + '\'' +
                ", qszt='" + qszt + '\'' +
                ", ywh='" + ywh + '\'' +
                ", qlrdh='" + qlrdh + '\'' +
                ", qxdm='" + qxdm + '\'' +
                ", qllx='" + qllx + '\'' +
                ", sfdy='" + sfdy + '\'' +
                ", sfcf='" + sfcf + '\'' +
                ", qdjg='" + qdjg + '\'' +
                '}';
    }
}
