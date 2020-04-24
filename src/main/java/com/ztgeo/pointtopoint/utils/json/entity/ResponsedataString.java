package com.ztgeo.pointtopoint.utils.json.entity;

public class ResponsedataString {
	private String cxsqdh;//查询申请单号
	private String cxjgbs;//查询机构标识
	private String cxywlb;//查询业务类别
	private String cxfw;//查询范围
	private String cxywcs;//查询参数字符串
	public String getCxsqdh() {
		return cxsqdh;
	}
	public void setCxsqdh(String cxsqdh) {
		this.cxsqdh = cxsqdh;
	}
	public String getCxjgbs() {
		return cxjgbs;
	}
	public void setCxjgbs(String cxjgbs) {
		this.cxjgbs = cxjgbs;
	}
	public String getCxywlb() {
		return cxywlb;
	}
	public void setCxywlb(String cxywlb) {
		this.cxywlb = cxywlb;
	}

	public String getCxfw() {
		return cxfw;
	}

	public void setCxfw(String cxfw) {
		this.cxfw = cxfw;
	}

	public String getCxywcs() {
		return cxywcs;
	}
	public void setCxywcs(String cxywcs) {
		this.cxywcs = cxywcs;
	}

	@Override
	public String toString() {
		return "ResponsedataString{" +
				"cxsqdh='" + cxsqdh + '\'' +
				", cxjgbs='" + cxjgbs + '\'' +
				", cxywlb='" + cxywlb + '\'' +
				", cxfw='" + cxfw + '\'' +
				", cxywcs='" + cxywcs + '\'' +
				'}';
	}
}
