package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 注销登记
 */
public class ZX {
    private String djsj;//登记时间
    private String xgwh;//相关证号

    public ZX() {
    }

    public ZX(String djsj, String xgwh) {
        this.djsj = djsj;
        this.xgwh = xgwh;
    }

    public String getXgwh() {
        return xgwh;
    }

    public void setXgwh(String xgwh) {
        this.xgwh = xgwh;
    }

    public String getDjsj() {
        return djsj;
    }

    public void setDjsj(String djsj) {
        this.djsj = djsj;
    }

    @Override
    public String toString() {
        return "ZX{" +
                "djsj='" + djsj + '\'' +
                ", xgwh='" + xgwh + '\'' +
                '}';
    }
}
