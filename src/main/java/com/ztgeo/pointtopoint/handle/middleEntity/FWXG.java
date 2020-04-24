package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 房屋相关
 */
public class FWXG {
	/*qsdc.zl,qsdc.bdcdyh,fwxg.ghyt,fwxg.jzmj,tsgl.tstybm*/
	private String zl;//坐落
	private String bdcdyh;//不动产单元号
	private String ghyt;//规划用途
	private String jzmj;//建筑面积
	private String tstybm;//图属统一编号
	public FWXG() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FWXG(String zl, String bdcdyh, String ghyt, String jzmj, String tstybm) {
		super();
		this.zl = zl;
		this.bdcdyh = bdcdyh;
		this.ghyt = ghyt;
		this.jzmj = jzmj;
		this.tstybm = tstybm;
	}
	public String getZl() {
		return zl;
	}
	public void setZl(String zl) {
		this.zl = zl;
	}
	public String getBdcdyh() {
		return bdcdyh;
	}
	public void setBdcdyh(String bdcdyh) {
		this.bdcdyh = bdcdyh;
	}
	public String getGhyt() {
		return ghyt;
	}
	public void setGhyt(String ghyt) {
		this.ghyt = ghyt;
	}
	public String getJzmj() {
		return jzmj;
	}
	public void setJzmj(String jzmj) {
		this.jzmj = jzmj;
	}
	public String getTstybm() {
		return tstybm;
	}
	public void setTstybm(String tstybm) {
		this.tstybm = tstybm;
	}
	@Override
	public String toString() {
		return "FWXG [zl=" + zl + ", bdcdyh=" + bdcdyh + ", ghyt=" + ghyt + ", jzmj=" + jzmj + ", tstybm=" + tstybm
				+ "]";
	}
	
}
