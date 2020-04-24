package com.ztgeo.pointtopoint.handle.entity;

import io.swagger.models.auth.In;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 查封登记
 */
public class CFDJ {
    private String id;
    private String cxrid;
    private String bdcdyh;//不动产单元号
    private String zl;//坐落
    private String cfjg;//查封机构
    private String cflx;//查封类型
    private String cfwh;//查封文号
    private String cfqssj;//查封起始时间
    private String cfjssj;//查封结束时间
    private String djjg;//登记机构
    private Integer xh;//序号
    private String djsj;//登记时间
    private String jfdjsj;//解封登记时间
    private String ywh;//业务号
    private String qszt;//权属状态
    private String qxdm;//区县代码
    private String cffw;//查封范围
    private String jfwh;//解封文号

    public CFDJ() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CFDJ(String id, String cxrid, String bdcdyh, String zl, String cfjg, String cflx, String cfwh, String cfqssj, String cfjssj, String djjg, Integer xh, String djsj, String jfdjsj, String ywh, String qszt, String qxdm, String cffw, String jfwh) {
        this.id = id;
        this.cxrid = cxrid;
        this.bdcdyh = bdcdyh;
        this.zl = zl;
        this.cfjg = cfjg;
        this.cflx = cflx;
        this.cfwh = cfwh;
        this.cfqssj = cfqssj;
        this.cfjssj = cfjssj;
        this.djjg = djjg;
        this.xh = xh;
        this.djsj = djsj;
        this.jfdjsj = jfdjsj;
        this.ywh = ywh;
        this.qszt = qszt;
        this.qxdm = qxdm;
        this.cffw = cffw;
        this.jfwh = jfwh;
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

    public String getCfjg() {
        return cfjg;
    }

    public void setCfjg(String cfjg) {
        this.cfjg = cfjg;
    }

    public String getCflx() {
        return cflx;
    }

    public void setCflx(String cflx) {
        this.cflx = cflx;
    }

    public String getCfwh() {
        return cfwh;
    }

    public void setCfwh(String cfwh) {
        this.cfwh = cfwh;
    }

    public String getCfqssj() {
        return cfqssj;
    }

    public void setCfqssj(String cfqssj) {
        this.cfqssj = cfqssj;
    }

    public String getCfjssj() {
        return cfjssj;
    }

    public void setCfjssj(String cfjssj) {
        this.cfjssj = cfjssj;
    }

    public String getDjjg() {
        return djjg;
    }

    public void setDjjg(String djjg) {
        this.djjg = djjg;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getDjsj() {
        return djsj;
    }

    public void setDjsj(String djsj) {
        this.djsj = djsj;
    }

    public String getJfdjsj() {
        return jfdjsj;
    }

    public void setJfdjsj(String jfdjsj) {
        this.jfdjsj = jfdjsj;
    }

    public String getYwh() {
        return ywh;
    }

    public void setYwh(String ywh) {
        this.ywh = ywh;
    }

    public String getQszt() {
        return qszt;
    }

    public void setQszt(String qszt) {
        this.qszt = qszt;
    }

    public String getQxdm() {
        return qxdm;
    }

    public void setQxdm(String qxdm) {
        this.qxdm = qxdm;
    }

    public String getJfwh() {
        return jfwh;
    }

    public void setJfwh(String jfwh) {
        this.jfwh = jfwh;
    }

    public String getCffw() {
        return cffw;
    }

    public void setCffw(String cffw) {
        this.cffw = cffw;
    }

    @Override
    public String toString() {
        return "CFDJ{" +
                "id='" + id + '\'' +
                ", cxrid='" + cxrid + '\'' +
                ", bdcdyh='" + bdcdyh + '\'' +
                ", zl='" + zl + '\'' +
                ", cfjg='" + cfjg + '\'' +
                ", cflx='" + cflx + '\'' +
                ", cfwh='" + cfwh + '\'' +
                ", cfqssj='" + cfqssj + '\'' +
                ", cfjssj='" + cfjssj + '\'' +
                ", djjg='" + djjg + '\'' +
                ", xh=" + xh +
                ", djsj='" + djsj + '\'' +
                ", jfdjsj='" + jfdjsj + '\'' +
                ", ywh='" + ywh + '\'' +
                ", qszt='" + qszt + '\'' +
                ", qxdm='" + qxdm + '\'' +
                ", cffw='" + cffw + '\'' +
                ", jfwh='" + jfwh + '\'' +
                '}';
    }
}
