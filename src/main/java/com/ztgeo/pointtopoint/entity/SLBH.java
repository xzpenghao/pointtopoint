package com.ztgeo.pointtopoint.entity;

/**
 * 查找查询人的受理编号时，查出不动产类型以便区分并去除部分非本人的宗地业务受理编号
 */
public class SLBH {
	private String slbh; //受理编号
	private String bdclx; //不动产类型
	
	public SLBH(String slbh, String bdclx) {
		super();
		this.slbh = slbh;
		this.bdclx = bdclx;
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

	@Override
	public String toString() {
		return "SLBH{" +
				"slbh='" + slbh + '\'' +
				", bdclx='" + bdclx + '\'' +
				'}';
	}
}
