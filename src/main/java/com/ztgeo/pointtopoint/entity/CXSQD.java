package com.ztgeo.pointtopoint.entity;

import java.util.Date;

public class CXSQD {
    /**
     *
     */
    private String id;

    /**
     *
     */
    private String cxsqdh;

    /**
     *
     */
    private Date hqsj;

    /**
     *
     */
    private String zt;

    /**
     *
     */
    private String cxywlb;

    /**
     *
     */
    private int cxfw;

    /**
     *
     */
    private Date updatetime;

    /**
     *
     */
    private String cxjgbs;

    public CXSQD() {
    }

    public CXSQD(String id, String cxsqdh, Date hqsj, String zt, String cxywlb, int cxfw, Date updatetime, String cxjgbs) {
        this.id = id;
        this.cxsqdh = cxsqdh;
        this.hqsj = hqsj;
        this.zt = zt;
        this.cxywlb = cxywlb;
        this.cxfw = cxfw;
        this.updatetime = updatetime;
        this.cxjgbs = cxjgbs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCxsqdh() {
        return cxsqdh;
    }

    public void setCxsqdh(String cxsqdh) {
        this.cxsqdh = cxsqdh;
    }

    public Date getHqsj() {
        return hqsj;
    }

    public void setHqsj(Date hqsj) {
        this.hqsj = hqsj;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getCxywlb() {
        return cxywlb;
    }

    public void setCxywlb(String cxywlb) {
        this.cxywlb = cxywlb;
    }

    public int getCxfw() {
        return cxfw;
    }

    public void setCxfw(int cxfw) {
        this.cxfw = cxfw;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCxjgbs() {
        return cxjgbs;
    }

    public void setCxjgbs(String cxjgbs) {
        this.cxjgbs = cxjgbs;
    }

    @Override
    public String toString() {
        return "CXSQD{" +
                "id='" + id + '\'' +
                ", cxsqdh='" + cxsqdh + '\'' +
                ", hqsj=" + hqsj +
                ", zt='" + zt + '\'' +
                ", cxywlb='" + cxywlb + '\'' +
                ", cxfw=" + cxfw +
                ", updatetime=" + updatetime +
                ", cxjgbs='" + cxjgbs + '\'' +
                '}';
    }
}