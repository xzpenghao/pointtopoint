package com.ztgeo.pointtopoint.handle.entity;

/**
 * 异议登记
 */
public class YYDJ {
    private String id;
    private String cxrid;
    private String bdcdyh;//不动产单元号
    private String zl;//坐落
    private String yysx;//异议事项
    private String bdcdjzmh;//不动产证明号
    private String djjg;//登记机构
    private String djsj;//登记时间
    private String qszt;//权属状态 新增
    private String ywh;//业务号 新增
    private String zxsj;//注销时间 新增
    private String qxdm;//区县代码 新增

    public YYDJ() {
        super();
        // TODO Auto-generated constructor stub
    }

    public YYDJ(String id, String cxrid, String bdcdyh, String zl, String yysx, String bdcdjzmh, String djjg, String djsj, String qszt, String ywh, String zxsj, String qxdm) {
        this.id = id;
        this.cxrid = cxrid;
        this.bdcdyh = bdcdyh;
        this.zl = zl;
        this.yysx = yysx;
        this.bdcdjzmh = bdcdjzmh;
        this.djjg = djjg;
        this.djsj = djsj;
        this.qszt = qszt;
        this.ywh = ywh;
        this.zxsj = zxsj;
        this.qxdm = qxdm;
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

    public String getYysx() {
        return yysx;
    }

    public void setYysx(String yysx) {
        this.yysx = yysx;
    }

    public String getBdcdjzmh() {
        return bdcdjzmh;
    }

    public void setBdcdjzmh(String bdcdjzmh) {
        this.bdcdjzmh = bdcdjzmh;
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

    public String getZxsj() {
        return zxsj;
    }

    public void setZxsj(String zxsj) {
        this.zxsj = zxsj;
    }

    public String getQxdm() {
        return qxdm;
    }

    public void setQxdm(String qxdm) {
        this.qxdm = qxdm;
    }

    @Override
    public String toString() {
        return "YYDJ{" +
                "id='" + id + '\'' +
                ", cxrid='" + cxrid + '\'' +
                ", bdcdyh='" + bdcdyh + '\'' +
                ", zl='" + zl + '\'' +
                ", yysx='" + yysx + '\'' +
                ", bdcdjzmh='" + bdcdjzmh + '\'' +
                ", djjg='" + djjg + '\'' +
                ", djsj='" + djsj + '\'' +
                ", qszt='" + qszt + '\'' +
                ", ywh='" + ywh + '\'' +
                ", zxsj='" + zxsj + '\'' +
                ", qxdm='" + qxdm + '\'' +
                '}';
    }
}