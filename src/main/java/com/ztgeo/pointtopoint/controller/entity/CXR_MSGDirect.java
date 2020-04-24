package com.ztgeo.pointtopoint.controller.entity;

import java.util.Date;

/**
 * 存储网络直接查询接口的实体类
 */
public class CXR_MSGDirect {
    private String cxjgbs;//查询机构标识
    private String openid;//openid，验证查询的真实性，验证通过才给与查询
    private String cxsqdh;//查询申请单号
    private String xz;//查询类型
    private String xm;//姓名
    private int zjzl;//证件种类
    private String zjhm;//证件号码
    private String bdcqzh;//不动产权证号
    private String bdcdyh;//不动产单元号
    private String zl;//坐落
    private String cxqy;//查询区域
    private int cxfw;//查询范围
    private String wsbh;//文书编号
    private String zt;//状态
    private Date cxsj;//查询时间
    private String qqccdz;//请求存储地址

    public CXR_MSGDirect() {
    }

    public CXR_MSGDirect(String cxjgbs, String openid, String cxsqdh, String xz, String xm, int zjzl, String zjhm, String bdcqzh, String bdcdyh, String zl, String cxqy, int cxfw, String wsbh, String zt, Date cxsj, String qqccdz) {
        this.cxjgbs = cxjgbs;
        this.openid = openid;
        this.cxsqdh = cxsqdh;
        this.xz = xz;
        this.xm = xm;
        this.zjzl = zjzl;
        this.zjhm = zjhm;
        this.bdcqzh = bdcqzh;
        this.bdcdyh = bdcdyh;
        this.zl = zl;
        this.cxqy = cxqy;
        this.cxfw = cxfw;
        this.wsbh = wsbh;
        this.zt = zt;
        this.cxsj = cxsj;
        this.qqccdz = qqccdz;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getQqccdz() {
        return qqccdz;
    }

    public void setQqccdz(String qqccdz) {
        this.qqccdz = qqccdz;
    }

    public String getCxjgbs() {
        return cxjgbs;
    }

    public void setCxjgbs(String cxjgbs) {
        this.cxjgbs = cxjgbs;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCxsqdh() {
        return cxsqdh;
    }

    public void setCxsqdh(String cxsqdh) {
        this.cxsqdh = cxsqdh;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getBdcqzh() {
        return bdcqzh;
    }

    public void setBdcqzh(String bdcqzh) {
        this.bdcqzh = bdcqzh;
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

    public String getCxqy() {
        return cxqy;
    }

    public void setCxqy(String cxqy) {
        this.cxqy = cxqy;
    }

    public String getWsbh() {
        return wsbh;
    }

    public void setWsbh(String wsbh) {
        this.wsbh = wsbh;
    }

    public int getZjzl() {
        return zjzl;
    }

    public void setZjzl(int zjzl) {
        this.zjzl = zjzl;
    }

    public int getCxfw() {
        return cxfw;
    }

    public void setCxfw(int cxfw) {
        this.cxfw = cxfw;
    }

    public Date getCxsj() {
        return cxsj;
    }

    public void setCxsj(Date cxsj) {
        this.cxsj = cxsj;
    }

    @Override
    public String toString() {
        return "CXR_MSGDirect{" +
                "cxjgbs='" + cxjgbs + '\'' +
                ", openid='" + openid + '\'' +
                ", cxsqdh='" + cxsqdh + '\'' +
                ", xz='" + xz + '\'' +
                ", xm='" + xm + '\'' +
                ", zjzl='" + zjzl + '\'' +
                ", zjhm='" + zjhm + '\'' +
                ", bdcqzh='" + bdcqzh + '\'' +
                ", bdcdyh='" + bdcdyh + '\'' +
                ", zl='" + zl + '\'' +
                ", cxqy='" + cxqy + '\'' +
                ", cxfw='" + cxfw + '\'' +
                ", wsbh='" + wsbh + '\'' +
                ", zt='" + zt + '\'' +
                ", cxsj='" + cxsj + '\'' +
                ", qqccdz='" + qqccdz + '\'' +
                '}';
    }
}
