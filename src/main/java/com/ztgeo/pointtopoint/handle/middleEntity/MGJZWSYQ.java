package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 构建筑物所有权
 */
public class MGJZWSYQ {
	private String tstybm;//图属统一编码
	private String bdcdyh;//不动产单元号
	private String zl;//坐落
	private String gjzwghyt;//构建筑物规划用途
	private String gjzwmj;//构建筑物面积
	private String tdhysyqssj;//土地海域使用起始时间
	private String tdhysyjssj;//土地海域使用结束时间
	private String bdcqzh;//不动产权证号
	private String djjg;//登记机构
	private String djsj;//登记时间
	private String gyfs;//共有方式
	private String qszt;//权属状态 新增
	private String ywh;//业务号 新增
	private String gjzwlx;//构建筑物类型 新增
	private String qllx;//权力类型 新增
	private String tdhysyqr;//土地/海域使用权人 新增
	private String tdhysymj;//土地/海域使用面积 新增

	public MGJZWSYQ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MGJZWSYQ(String tstybm, String bdcdyh, String zl, String gjzwghyt, String gjzwmj, String tdhysyqssj, String tdhysyjssj, String bdcqzh, String djjg, String djsj, String gyfs, String qszt, String ywh, String gjzwlx, String qllx, String tdhysyqr, String tdhysymj) {
		this.tstybm = tstybm;
		this.bdcdyh = bdcdyh;
		this.zl = zl;
		this.gjzwghyt = gjzwghyt;
		this.gjzwmj = gjzwmj;
		this.tdhysyqssj = tdhysyqssj;
		this.tdhysyjssj = tdhysyjssj;
		this.bdcqzh = bdcqzh;
		this.djjg = djjg;
		this.djsj = djsj;
		this.gyfs = gyfs;
		this.qszt = qszt;
		this.ywh = ywh;
		this.gjzwlx = gjzwlx;
		this.qllx = qllx;
		this.tdhysyqr = tdhysyqr;
		this.tdhysymj = tdhysymj;
	}

	public String getTstybm() {
		return tstybm;
	}

	public void setTstybm(String tstybm) {
		this.tstybm = tstybm;
	}

	public String getBdcdyh() {
		return bdcdyh;
	}

	public void setBdcdyh(String bdcdyh) {
		this.bdcdyh = bdcdyh;
	}

	public String getZl() {
		return zl;
	}

	public void setZl(String zl) {
		this.zl = zl;
	}

	public String getGjzwghyt() {
		return gjzwghyt;
	}

	public void setGjzwghyt(String gjzwghyt) {
		this.gjzwghyt = gjzwghyt;
	}

	public String getGjzwmj() {
		return gjzwmj;
	}

	public void setGjzwmj(String gjzwmj) {
		this.gjzwmj = gjzwmj;
	}

	public String getTdhysyqssj() {
		return tdhysyqssj;
	}

	public void setTdhysyqssj(String tdhysyqssj) {
		this.tdhysyqssj = tdhysyqssj;
	}

	public String getTdhysyjssj() {
		return tdhysyjssj;
	}

	public void setTdhysyjssj(String tdhysyjssj) {
		this.tdhysyjssj = tdhysyjssj;
	}

	public String getBdcqzh() {
		return bdcqzh;
	}

	public void setBdcqzh(String bdcqzh) {
		this.bdcqzh = bdcqzh;
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

	public String getGyfs() {
		return gyfs;
	}

	public void setGyfs(String gyfs) {
		this.gyfs = gyfs;
	}

	public String getQszt() {
		return qszt;
	}

	public void setQszt(String qszt) {
		this.qszt = qszt;
	}

	public String getYwh() {
		return ywh;
	}

	public void setYwh(String ywh) {
		this.ywh = ywh;
	}

	public String getGjzwlx() {
		return gjzwlx;
	}

	public void setGjzwlx(String gjzwlx) {
		this.gjzwlx = gjzwlx;
	}

	public String getQllx() {
		return qllx;
	}

	public void setQllx(String qllx) {
		this.qllx = qllx;
	}

	public String getTdhysyqr() {
		return tdhysyqr;
	}

	public void setTdhysyqr(String tdhysyqr) {
		this.tdhysyqr = tdhysyqr;
	}

	public String getTdhysymj() {
		return tdhysymj;
	}

	public void setTdhysymj(String tdhysymj) {
		this.tdhysymj = tdhysymj;
	}

	@Override
	public String toString() {
		return "MGJZWSYQ{" +
				"tstybm='" + tstybm + '\'' +
				", bdcdyh='" + bdcdyh + '\'' +
				", zl='" + zl + '\'' +
				", gjzwghyt='" + gjzwghyt + '\'' +
				", gjzwmj='" + gjzwmj + '\'' +
				", tdhysyqssj='" + tdhysyqssj + '\'' +
				", tdhysyjssj='" + tdhysyjssj + '\'' +
				", bdcqzh='" + bdcqzh + '\'' +
				", djjg='" + djjg + '\'' +
				", djsj='" + djsj + '\'' +
				", gyfs='" + gyfs + '\'' +
				", qszt='" + qszt + '\'' +
				", ywh='" + ywh + '\'' +
				", gjzwlx='" + gjzwlx + '\'' +
				", qllx='" + qllx + '\'' +
				", tdhysyqr='" + tdhysyqr + '\'' +
				", tdhysymj='" + tdhysymj + '\'' +
				'}';
	}
}
