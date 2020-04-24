package com.ztgeo.pointtopoint.utils.json.entity;

import java.util.ArrayList;

public class Responsedata {
	private String cxsqdh;//查询申请单号
	private String cxjgbs;//查询结构标识
	private String cxywlb;//查询业务类别
	private int cxfw;//查询范围
	private ArrayList<CXYWCS> cxywcss;//查询参数实体
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

	public int getCxfw() {
		return cxfw;
	}

	public void setCxfw(int cxfw) {
		this.cxfw = cxfw;
	}

	public ArrayList<CXYWCS> getCxywcss() {
		return cxywcss;
	}
	public void setCxywcss(ArrayList<CXYWCS> cxywcss) {
		this.cxywcss = cxywcss;
	}

	@Override
	public String toString() {
		return "Responsedata{" +
				"cxsqdh='" + cxsqdh + '\'' +
				", cxjgbs='" + cxjgbs + '\'' +
				", cxywlb='" + cxywlb + '\'' +
				", cxfw='" + cxfw + '\'' +
				", cxywcss=" + cxywcss +
				'}';
	}
}
