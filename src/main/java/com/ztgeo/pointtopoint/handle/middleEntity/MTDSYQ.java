package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 土地所有权
 */
public class MTDSYQ {
	private String bdcdyh;//不动产单元号
	private String zl;//坐落
	private String zdmj;//宗地面积
	private String yt;//用途
	private String qlxz;//权力性质
	private String bdcqzh;//不动产权证号
	private String djjg;//登记机构
	private String djsj;//登记时间
	private String gyfs;//共有方式 新增
	private String qszt;//权属状态  新增
	private String ywh;// 业务号  新增
	private String qllx;//权力类型  新增
	private String tstybm;//图属统一编码

	public MTDSYQ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MTDSYQ(String bdcdyh, String zl, String zdmj, String yt, String qlxz, String bdcqzh, String djjg, String djsj, String gyfs, String qszt, String ywh, String qllx, String tstybm) {
		this.bdcdyh = bdcdyh;
		this.zl = zl;
		this.zdmj = zdmj;
		this.yt = yt;
		this.qlxz = qlxz;
		this.bdcqzh = bdcqzh;
		this.djjg = djjg;
		this.djsj = djsj;
		this.gyfs = gyfs;
		this.qszt = qszt;
		this.ywh = ywh;
		this.qllx = qllx;
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

	public String getZdmj() {
		return zdmj;
	}

	public void setZdmj(String zdmj) {
		this.zdmj = zdmj;
	}

	public String getYt() {
		return yt;
	}

	public void setYt(String yt) {
		this.yt = yt;
	}

	public String getQlxz() {
		return qlxz;
	}

	public void setQlxz(String qlxz) {
		this.qlxz = qlxz;
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

	public String getQllx() {
		return qllx;
	}

	public void setQllx(String qllx) {
		this.qllx = qllx;
	}

	public String getTstybm() {
		return tstybm;
	}

	public void setTstybm(String tstybm) {
		this.tstybm = tstybm;
	}

	@Override
	public String toString() {
		return "MTDSYQ{" +
				"bdcdyh='" + bdcdyh + '\'' +
				", zl='" + zl + '\'' +
				", zdmj='" + zdmj + '\'' +
				", yt='" + yt + '\'' +
				", qlxz='" + qlxz + '\'' +
				", bdcqzh='" + bdcqzh + '\'' +
				", djjg='" + djjg + '\'' +
				", djsj='" + djsj + '\'' +
				", gyfs='" + gyfs + '\'' +
				", qszt='" + qszt + '\'' +
				", ywh='" + ywh + '\'' +
				", qllx='" + qllx + '\'' +
				", tstybm='" + tstybm + '\'' +
				'}';
	}
}
