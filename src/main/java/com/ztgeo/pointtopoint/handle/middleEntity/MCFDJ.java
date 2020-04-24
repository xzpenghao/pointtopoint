package com.ztgeo.pointtopoint.handle.middleEntity;

/**
 * 查封登记
 */
public class MCFDJ {
	private String tstybm;//图属统一编码
	private String bdclx;//不动产类型
	private String bdcdyh;//不动产单元号
	private String cfjg;//查封机构
	private String cflx;//查封类型
	private String cfwh;//查封文号
	private String cfqssj;//查封起始时间
	private String cfjssj;//查封结束时间
	private String djjg;//登记机构
	private String djsj;//登记时间
	private String ywh;//业务号
	private String qszt;//权属状态
	private String cffw;//解封范围
	public MCFDJ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MCFDJ(String tstybm, String bdclx, String bdcdyh, String cfjg, String cflx, String cfwh, String cfqssj, String cfjssj, String djjg, String djsj, String ywh, String qszt, String cffw) {
		this.tstybm = tstybm;
		this.bdclx = bdclx;
		this.bdcdyh = bdcdyh;
		this.cfjg = cfjg;
		this.cflx = cflx;
		this.cfwh = cfwh;
		this.cfqssj = cfqssj;
		this.cfjssj = cfjssj;
		this.djjg = djjg;
		this.djsj = djsj;
		this.ywh = ywh;
		this.qszt = qszt;
		this.cffw = cffw;
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

	public String getCfjg() {
		return cfjg;
	}

	public void setCfjg(String cfjg) {
		this.cfjg = cfjg;
	}

	public String getCflx() {
		return cflx;
	}

	public void setCflx(String cflx) {
		this.cflx = cflx;
	}

	public String getCfwh() {
		return cfwh;
	}

	public void setCfwh(String cfwh) {
		this.cfwh = cfwh;
	}

	public String getCffw() {
		return cffw;
	}

	public void setCffw(String cffw) {
		this.cffw = cffw;
	}

	public String getCfqssj() {
		return cfqssj;
	}

	public void setCfqssj(String cfqssj) {
		this.cfqssj = cfqssj;
	}

	public String getCfjssj() {
		return cfjssj;
	}

	public void setCfjssj(String cfjssj) {
		this.cfjssj = cfjssj;
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

	@Override
	public String toString() {
		return "MCFDJ{" +
				"tstybm='" + tstybm + '\'' +
				", bdclx='" + bdclx + '\'' +
				", bdcdyh='" + bdcdyh + '\'' +
				", cfjg='" + cfjg + '\'' +
				", cflx='" + cflx + '\'' +
				", cfwh='" + cfwh + '\'' +
				", cfqssj='" + cfqssj + '\'' +
				", cfjssj='" + cfjssj + '\'' +
				", djjg='" + djjg + '\'' +
				", djsj='" + djsj + '\'' +
				", ywh='" + ywh + '\'' +
				", qszt='" + qszt + '\'' +
				", cffw='" + cffw + '\'' +
				'}';
	}
}
