package com.ztgeo.pointtopoint.utils.json.entity;

public class Responsehead {
	private String code;//编码
	private String msg;//信息
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
	@Override
	public String toString() {
		return "Head [code=" + code + ", msg=" + msg + "]";
	}
	
}
