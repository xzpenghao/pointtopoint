package com.ztgeo.pointtopoint.entity;

import java.util.Date;

public class RESULT {
    /**
     *
     */
    private String id;

    /**
     *
     */
    private String code;

    /**
     *
     */
    private String msg;

    /**
     *
     */
    private String cxsqdh;

    /**
     *
     */
    private Date fksj;

    public RESULT() {
    }

    public RESULT(String id, String code, String msg, String cxsqdh, Date fksj) {
        this.id = id;
        this.code = code;
        this.msg = msg;
        this.cxsqdh = cxsqdh;
        this.fksj = fksj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCxsqdh() {
        return cxsqdh;
    }

    public void setCxsqdh(String cxsqdh) {
        this.cxsqdh = cxsqdh;
    }

    public Date getFksj() {
        return fksj;
    }

    public void setFksj(Date fksj) {
        this.fksj = fksj;
    }
}