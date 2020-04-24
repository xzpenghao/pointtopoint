package com.ztgeo.pointtopoint.entity;

/**
 * 发送请求的请求报文的head部分
 */
public class Resulthead {
	private String xzqdm; //行政区代码
	private String token; //token
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
