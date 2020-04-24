package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 异议登记
 */
public class MYYDJ {
	private String tstybm;//图属统一编码
	private String bdcdyh;//不动产单元号
	private String bdclx;//不动产类型
	private String yysx;//异议事项
	private String bdcdjzmh;//不动产证明号
	private String djjg;//登记机构
	private String djsj;//登记时间
	private String qszt;//权属状态 新增
	private String ywh;//业务号 新增
	public MYYDJ() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MYYDJ(String tstybm, String bdcdyh, String bdclx, String yysx, String bdcdjzmh, String djjg, String djsj, String qszt, String ywh) {
		this.tstybm = tstybm;
		this.bdcdyh = bdcdyh;
		this.bdclx = bdclx;
		this.yysx = yysx;
		this.bdcdjzmh = bdcdjzmh;
		this.djjg = djjg;
		this.djsj = djsj;
		this.qszt = qszt;
		this.ywh = ywh;
	}

	public String getBdclx() {
		return bdclx;
	}

	public void setBdclx(String bdclx) {
		this.bdclx = bdclx;
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

	public String getYysx() {
		return yysx;
	}

	public void setYysx(String yysx) {
		this.yysx = yysx;
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

	@Override
	public String toString() {
		return "MYYDJ{" +
				"tstybm='" + tstybm + '\'' +
				", bdcdyh='" + bdcdyh + '\'' +
				", bdclx='" + bdclx + '\'' +
				", yysx='" + yysx + '\'' +
				", bdcdjzmh='" + bdcdjzmh + '\'' +
				", djjg='" + djjg + '\'' +
				", djsj='" + djsj + '\'' +
				", qszt='" + qszt + '\'' +
				", ywh='" + ywh + '\'' +
				'}';
	}
}