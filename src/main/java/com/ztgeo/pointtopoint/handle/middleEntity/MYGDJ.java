package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 预告登记
 */
public class MYGDJ {
	private String tstybm;//图属统一编码
	private String ygdjzl;//预告登记种类
	private String bdcdjzmh;//不动产登记证明号
	private String djjg;//登记机构
	private String djsj;//登记时间
	private String zxsj;//注销时间 新增
	private String ywh;//业务号 新增
	private String qszt;//权属状态 新增
	private String gyfs;//共有方式 新增

	public MYGDJ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MYGDJ(String tstybm, String ygdjzl, String bdcdjzmh, String djjg, String djsj, String zxsj, String ywh, String qszt, String gyfs) {
		this.tstybm = tstybm;
		this.ygdjzl = ygdjzl;
		this.bdcdjzmh = bdcdjzmh;
		this.djjg = djjg;
		this.djsj = djsj;
		this.zxsj = zxsj;
		this.ywh = ywh;
		this.qszt = qszt;
		this.gyfs = gyfs;
	}

	public String getTstybm() {
		return tstybm;
	}

	public void setTstybm(String tstybm) {
		this.tstybm = tstybm;
	}

	public String getYgdjzl() {
		return ygdjzl;
	}

	public void setYgdjzl(String ygdjzl) {
		this.ygdjzl = ygdjzl;
	}

	public String getBdcdjzmh() {
		return bdcdjzmh;
	}

	public void setBdcdjzmh(String bdcdjzmh) {
		this.bdcdjzmh = bdcdjzmh;
	}

	public String getDjjg() {
		return djjg;
	}

	public void setDjjg(String djjg) {
		this.djjg = djjg;
	}

	public String getDjsj() {
		return djsj;
	}

	public void setDjsj(String djsj) {
		this.djsj = djsj;
	}

	public String getZxsj() {
		return zxsj;
	}

	public void setZxsj(String zxsj) {
		this.zxsj = zxsj;
	}

	public String getYwh() {
		return ywh;
	}

	public void setYwh(String ywh) {
		this.ywh = ywh;
	}

	public String getQszt() {
		return qszt;
	}

	public void setQszt(String qszt) {
		this.qszt = qszt;
	}

	public String getGyfs() {
		return gyfs;
	}

	public void setGyfs(String gyfs) {
		this.gyfs = gyfs;
	}

	@Override
	public String toString() {
		return "MYGDJ{" +
				"tstybm='" + tstybm + '\'' +
				", ygdjzl='" + ygdjzl + '\'' +
				", bdcdjzmh='" + bdcdjzmh + '\'' +
				", djjg='" + djjg + '\'' +
				", djsj='" + djsj + '\'' +
				", zxsj='" + zxsj + '\'' +
				", ywh='" + ywh + '\'' +
				", qszt='" + qszt + '\'' +
				", gyfs='" + gyfs + '\'' +
				'}';
	}
}
