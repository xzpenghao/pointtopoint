package com.ztgeo.pointtopoint.utils.json.entity;

/**
 *
 * @author Administrator
 *
 */

public class CXYWCS {
	
	private String qlrmc;//权利人名称
	private String qlrzjh;//证件号码
	private int qlrzjlx;//证件类型
	private String wsbh;//文书编号
	private String cxqy;//查询区域
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
	public String getCxqy() {
		return cxqy;
	}
	public void setCxqy(String cxqy) {
		this.cxqy = cxqy;
	}

	@Override
	public String toString() {
		return "CXYWCS{" +
				"qlrmc='" + qlrmc + '\'' +
				", qlrzjh='" + qlrzjh + '\'' +
				", qlrzjlx=" + qlrzjlx +
				", wsbh='" + wsbh + '\'' +
				", cxqy='" + cxqy + '\'' +
				'}';
	}
}
