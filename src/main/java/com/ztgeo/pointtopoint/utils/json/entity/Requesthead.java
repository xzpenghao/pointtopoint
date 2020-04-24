package com.ztgeo.pointtopoint.utils.json.entity;

public class Requesthead {
	private String xzqdm;//行政区代码
	private String token;//token
	public String getXzqdm() {
		return xzqdm;
	}
	public void setXzqdm(String xzqdm) {
		this.xzqdm = xzqdm;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "Head [xzqdm=" + xzqdm + ", token=" + token + "]";
	}
	
}
