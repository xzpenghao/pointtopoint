package com.ztgeo.pointtopoint.handle.middleEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 登记图属关联
 */
public class DJ_TSGL {
    private String glbm;
    private String slbh;//受理编号
    private String bdclx;//不动产类型
    private String tstybm;//图属统一编码
    private String bdcdyh;//不动产单元号
    private String djzl;//登记种类
    private String glms;
    private Date cssj;
    private BigDecimal lifecycle;
    private String slbh1;
    private String zslx;
    private String slbh2;
    private BigDecimal tszt;
    private String mark;
    private Date xsqsrq;
    private Date xsjzrq;
    private Short transnum;
    private String importname;
    private String ybdcdyh;
    private Date transnum2;
    private String transwh;
    private String fdgjlx;

    public DJ_TSGL() {
    }

    public DJ_TSGL(String glbm, String slbh, String bdclx, String tstybm, String bdcdyh, String djzl, String glms, Date cssj, BigDecimal lifecycle, String slbh1, String zslx, String slbh2, BigDecimal tszt, String mark, Date xsqsrq, Date xsjzrq, Short transnum, String importname, String ybdcdyh, Date transnum2, String transwh, String fdgjlx) {
        this.glbm = glbm;
        this.slbh = slbh;
        this.bdclx = bdclx;
        this.tstybm = tstybm;
        this.bdcdyh = bdcdyh;
        this.djzl = djzl;
        this.glms = glms;
        this.cssj = cssj;
        this.lifecycle = lifecycle;
        this.slbh1 = slbh1;
        this.zslx = zslx;
        this.slbh2 = slbh2;
        this.tszt = tszt;
        this.mark = mark;
        this.xsqsrq = xsqsrq;
        this.xsjzrq = xsjzrq;
        this.transnum = transnum;
        this.importname = importname;
        this.ybdcdyh = ybdcdyh;
        this.transnum2 = transnum2;
        this.transwh = transwh;
        this.fdgjlx = fdgjlx;
    }

    public String getGlbm() {
        return glbm;
    }

    public void setGlbm(String glbm) {
        this.glbm = glbm;
    }

    public String getSlbh() {
        return slbh;
    }

    public void setSlbh(String slbh) {
        this.slbh = slbh;
    }

    public String getBdclx() {
        return bdclx;
    }

    public void setBdclx(String bdclx) {
        this.bdclx = bdclx;
    }

    public String getTstybm() {
        return tstybm;
    }

    public void setTstybm(String tstybm) {
        this.tstybm = tstybm;
    }

    public String getBdcdyh() {
        return bdcdyh;
    }

    public void setBdcdyh(String bdcdyh) {
        this.bdcdyh = bdcdyh;
    }

    public String getDjzl() {
        return djzl;
    }

    public void setDjzl(String djzl) {
        this.djzl = djzl;
    }

    public String getGlms() {
        return glms;
    }

    public void setGlms(String glms) {
        this.glms = glms;
    }

    public Date getCssj() {
        return cssj;
    }

    public void setCssj(Date cssj) {
        this.cssj = cssj;
    }

    public BigDecimal getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(BigDecimal lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getSlbh1() {
        return slbh1;
    }

    public void setSlbh1(String slbh1) {
        this.slbh1 = slbh1;
    }

    public String getZslx() {
        return zslx;
    }

    public void setZslx(String zslx) {
        this.zslx = zslx;
    }

    public String getSlbh2() {
        return slbh2;
    }

    public void setSlbh2(String slbh2) {
        this.slbh2 = slbh2;
    }

    public BigDecimal getTszt() {
        return tszt;
    }

    public void setTszt(BigDecimal tszt) {
        this.tszt = tszt;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getXsqsrq() {
        return xsqsrq;
    }

    public void setXsqsrq(Date xsqsrq) {
        this.xsqsrq = xsqsrq;
    }

    public Date getXsjzrq() {
        return xsjzrq;
    }

    public void setXsjzrq(Date xsjzrq) {
        this.xsjzrq = xsjzrq;
    }

    public Short getTransnum() {
        return transnum;
    }

    public void setTransnum(Short transnum) {
        this.transnum = transnum;
    }

    public String getImportname() {
        return importname;
    }

    public void setImportname(String importname) {
        this.importname = importname;
    }

    public String getYbdcdyh() {
        return ybdcdyh;
    }

    public void setYbdcdyh(String ybdcdyh) {
        this.ybdcdyh = ybdcdyh;
    }

    public Date getTransnum2() {
        return transnum2;
    }

    public void setTransnum2(Date transnum2) {
        this.transnum2 = transnum2;
    }

    public String getTranswh() {
        return transwh;
    }

    public void setTranswh(String transwh) {
        this.transwh = transwh;
    }

    public String getFdgjlx() {
        return fdgjlx;
    }

    public void setFdgjlx(String fdgjlx) {
        this.fdgjlx = fdgjlx;
    }
}