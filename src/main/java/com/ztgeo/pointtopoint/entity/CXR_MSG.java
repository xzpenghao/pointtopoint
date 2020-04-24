package com.ztgeo.pointtopoint.entity;

public class CXR_MSG {
    /**
     *
     */
    private String id;

    /**
     *
     */
    private String cxsqdhId;

    /**
     *
     */
    private String qlrmc;

    /**
     *
     */
    private String qlrzjh;

    private String cxqy;
    /**
     *
     */
    private int qlrzjlx;

    /**
     *
     */
    private String wsbh;

    /**
     *
     */


    public CXR_MSG() {
    }

    public CXR_MSG(String id, String cxsqdhId, String qlrmc, String qlrzjh, String cxqy, int qlrzjlx, String wsbh) {
        this.id = id;
        this.cxsqdhId = cxsqdhId;
        this.qlrmc = qlrmc;
        this.qlrzjh = qlrzjh;
        this.cxqy = cxqy;
        this.qlrzjlx = qlrzjlx;
        this.wsbh = wsbh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCxsqdhId() {
        return cxsqdhId;
    }

    public void setCxsqdhId(String cxsqdhId) {
        this.cxsqdhId = cxsqdhId;
    }

    public String getQlrmc() {
        return qlrmc;
    }

    public void setQlrmc(String qlrmc) {
        this.qlrmc = qlrmc;
    }

    public String getQlrzjh() {
        return qlrzjh;
    }

    public void setQlrzjh(String qlrzjh) {
        this.qlrzjh = qlrzjh;
    }

    public int getQlrzjlx() {
        return qlrzjlx;
    }

    public void setQlrzjlx(int qlrzjlx) {
        this.qlrzjlx = qlrzjlx;
    }

    public String getWsbh() {
        return wsbh;
    }

    public void setWsbh(String wsbh) {
        this.wsbh = wsbh;
    }

    @Override
    public String toString() {
        return "CXR_MSG{" +
                "id='" + id + '\'' +
                ", cxsqdhId='" + cxsqdhId + '\'' +
                ", qlrmc='" + qlrmc + '\'' +
                ", qlrzjh='" + qlrzjh + '\'' +
                ", cxqy='" + cxqy + '\'' +
                ", qlrzjlx=" + qlrzjlx +
                ", wsbh='" + wsbh + '\'' +
                '}';
    }
}