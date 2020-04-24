package com.ztgeo.pointtopoint.handle.entity;

/**
 * 抵押权
 */
public class DYAQ {
    private String id;
    private String cxrid;
    private String bdcdyh;//不动产单元号
    private String dybdclx;//抵押不动产类型
    private String zl;//坐落
    private String dyr;//抵押人
    private String dyfs;//抵押方式
    private String bdbzzqse;//被担保主债权数额
    private String zwlxqssj;//债务履行起始时间
    private String zwlxjssj;//债务履行结束时间
    private String bdcdjzmh;//不动产登记证明号
    private String djjg;//登记机构
    private String djsj;//登记时间
    private String dyqr;//抵押权人
    private String zxsj;//注销时间 新增
    private String ywh;//业务号 新增
    private String qszt;//权属状态 新增
    private String qxdm;//区县代码 新增
    private String zjjzwzl;//在建建筑物坐落 新增
    private String zjjzwdyfw;//在建建筑物抵押范围
    private String zgzqse;//最高债权数额

    public DYAQ() {
        super();
    }

    public DYAQ(String id, String cxrid, String bdcdyh, String dybdclx, String zl, String dyr, String dyfs, String bdbzzqse, String zwlxqssj, String zwlxjssj, String bdcdjzmh, String djjg, String djsj, String dyqr, String zxsj, String ywh, String qszt, String qxdm, String zjjzwzl, String zjjzwdyfw, String zgzqse) {
        this.id = id;
        this.cxrid = cxrid;
        this.bdcdyh = bdcdyh;
        this.dybdclx = dybdclx;
        this.zl = zl;
        this.dyr = dyr;
        this.dyfs = dyfs;
        this.bdbzzqse = bdbzzqse;
        this.zwlxqssj = zwlxqssj;
        this.zwlxjssj = zwlxjssj;
        this.bdcdjzmh = bdcdjzmh;
        this.djjg = djjg;
        this.djsj = djsj;
        this.dyqr = dyqr;
        this.zxsj = zxsj;
        this.ywh = ywh;
        this.qszt = qszt;
        this.qxdm = qxdm;
        this.zjjzwzl = zjjzwzl;
        this.zjjzwdyfw = zjjzwdyfw;
        this.zgzqse = zgzqse;
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

    public String getDybdclx() {
        return dybdclx;
    }

    public void setDybdclx(String dybdclx) {
        this.dybdclx = dybdclx;
    }

    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl;
    }

    public String getDyr() {
        return dyr;
    }

    public void setDyr(String dyr) {
        this.dyr = dyr;
    }

    public String getDyfs() {
        return dyfs;
    }

    public void setDyfs(String dyfs) {
        this.dyfs = dyfs;
    }

    public String getBdbzzqse() {
        return bdbzzqse;
    }

    public void setBdbzzqse(String bdbzzqse) {
        this.bdbzzqse = bdbzzqse;
    }

    public String getZwlxqssj() {
        return zwlxqssj;
    }

    public void setZwlxqssj(String zwlxqssj) {
        this.zwlxqssj = zwlxqssj;
    }

    public String getZwlxjssj() {
        return zwlxjssj;
    }

    public void setZwlxjssj(String zwlxjssj) {
        this.zwlxjssj = zwlxjssj;
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

    public String getDyqr() {
        return dyqr;
    }

    public void setDyqr(String dyqr) {
        this.dyqr = dyqr;
    }

    public String getZxsj() {
        return zxsj;
    }

    public void setZxsj(String zxsj) {
        this.zxsj = zxsj;
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

    public String getZjjzwzl() {
        return zjjzwzl;
    }

    public void setZjjzwzl(String zjjzwzl) {
        this.zjjzwzl = zjjzwzl;
    }

    public String getZjjzwdyfw() {
        return zjjzwdyfw;
    }

    public void setZjjzwdyfw(String zjjzwdyfw) {
        this.zjjzwdyfw = zjjzwdyfw;
    }

    public String getZgzqse() {
        return zgzqse;
    }

    public void setZgzqse(String zgzqse) {
        this.zgzqse = zgzqse;
    }

    @Override
    public String toString() {
        return "DYAQ{" +
                "id='" + id + '\'' +
                ", cxrid='" + cxrid + '\'' +
                ", bdcdyh='" + bdcdyh + '\'' +
                ", dybdclx='" + dybdclx + '\'' +
                ", zl='" + zl + '\'' +
                ", dyr='" + dyr + '\'' +
                ", dyfs='" + dyfs + '\'' +
                ", bdbzzqse='" + bdbzzqse + '\'' +
                ", zwlxqssj='" + zwlxqssj + '\'' +
                ", zwlxjssj='" + zwlxjssj + '\'' +
                ", bdcdjzmh='" + bdcdjzmh + '\'' +
                ", djjg='" + djjg + '\'' +
                ", djsj='" + djsj + '\'' +
                ", dyqr='" + dyqr + '\'' +
                ", zxsj='" + zxsj + '\'' +
                ", ywh='" + ywh + '\'' +
                ", qszt='" + qszt + '\'' +
                ", qxdm='" + qxdm + '\'' +
                ", zjjzwzl='" + zjjzwzl + '\'' +
                ", zjjzwdyfw='" + zjjzwdyfw + '\'' +
                ", zgzqse='" + zgzqse + '\'' +
                '}';
    }
}
