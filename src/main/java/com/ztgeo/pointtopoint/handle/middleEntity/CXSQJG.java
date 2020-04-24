package com.ztgeo.pointtopoint.handle.middleEntity;

import com.ztgeo.pointtopoint.controller.entity.*;
import com.ztgeo.pointtopoint.handle.entity.*;

import java.util.List;

/**
 * 查询申请结果
 */
public class CXSQJG {
	private String wsbh;//文书编号
	private List<DirectTDSYQ> tdsyq;//土地使用权
	private List<DirectJSYDSYQ> jsydsyq;//建设用地使用权
	private List<DirectFDCQ> fdcq;//房地产权
	private List<DirectDYAQ> dyaq;//抵押权
	private List<DirectYGDJ> ygdj;//预告登记
	private List<DirectCFDJ> cfdj;//查封登记
	private List<DirectHYSYQ> hysyq;//海域使用权
	private List<DirectLQ> lq;//林权
	private List<DirectGJZWSYQ> gjzwsyq;//构建筑物使用权
	private List<DirectYYDJ> yydj;//异议登记
	private List<DirectNYDSYQ> nydsyq;//农用地使用权
	public CXSQJG() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CXSQJG(String wsbh, List<DirectTDSYQ> tdsyq, List<DirectJSYDSYQ> jsydsyq, List<DirectFDCQ> fdcq, List<DirectDYAQ> dyaq, List<DirectYGDJ> ygdj, List<DirectCFDJ> cfdj, List<DirectHYSYQ> hysyq, List<DirectLQ> lq, List<DirectGJZWSYQ> gjzwsyq, List<DirectYYDJ> yydj, List<DirectNYDSYQ> nydsyq) {
		this.wsbh = wsbh;
		this.tdsyq = tdsyq;
		this.jsydsyq = jsydsyq;
		this.fdcq = fdcq;
		this.dyaq = dyaq;
		this.ygdj = ygdj;
		this.cfdj = cfdj;
		this.hysyq = hysyq;
		this.lq = lq;
		this.gjzwsyq = gjzwsyq;
		this.yydj = yydj;
		this.nydsyq = nydsyq;
	}

	public List<DirectYYDJ> getYydj() {
		return yydj;
	}
	public void setYydj(List<DirectYYDJ> yydj) {
		this.yydj = yydj;
	}
	public List<DirectTDSYQ> getTdsyq() {
		return tdsyq;
	}
	public void setTdsyq(List<DirectTDSYQ> tdsyq) {
		this.tdsyq = tdsyq;
	}
	public List<DirectJSYDSYQ> getJsydsyq() {
		return jsydsyq;
	}
	public void setJsydsyq(List<DirectJSYDSYQ> jsydsyq) {
		this.jsydsyq = jsydsyq;
	}
	public List<DirectFDCQ> getFdcq() {
		return fdcq;
	}
	public void setFdcq(List<DirectFDCQ> fdcq) {
		this.fdcq = fdcq;
	}
	public List<DirectDYAQ> getDyaq() {
		return dyaq;
	}
	public void setDyaq(List<DirectDYAQ> dyaq) {
		this.dyaq = dyaq;
	}
	public List<DirectYGDJ> getYgdj() {
		return ygdj;
	}
	public void setYgdj(List<DirectYGDJ> ygdj) {
		this.ygdj = ygdj;
	}
	public List<DirectCFDJ> getCfdj() {
		return cfdj;
	}
	public void setCfdj(List<DirectCFDJ> cfdj) {
		this.cfdj = cfdj;
	}
	public List<DirectHYSYQ> getHysyq() {
		return hysyq;
	}
	public void setHysyq(List<DirectHYSYQ> hysyq) {
		this.hysyq = hysyq;
	}
	public List<DirectLQ> getLq() {
		return lq;
	}
	public void setLq(List<DirectLQ> lq) {
		this.lq = lq;
	}
	public List<DirectGJZWSYQ> getGjzwsyq() {
		return gjzwsyq;
	}
	public void setGjzwsyq(List<DirectGJZWSYQ> gjzwsyq) {
		this.gjzwsyq = gjzwsyq;
	}
	public String getWsbh() {
		return wsbh;
	}
	public void setWsbh(String wsbh) {
		this.wsbh = wsbh;
	}

	public List<DirectNYDSYQ> getNydsyq() {
		return nydsyq;
	}

	public void setNydsyq(List<DirectNYDSYQ> nydsyq) {
		this.nydsyq = nydsyq;
	}

	@Override
	public String toString() {
		return "CXSQJG{" +
				"wsbh='" + wsbh + '\'' +
				", tdsyq=" + tdsyq +
				", jsydsyq=" + jsydsyq +
				", fdcq=" + fdcq +
				", dyaq=" + dyaq +
				", ygdj=" + ygdj +
				", cfdj=" + cfdj +
				", hysyq=" + hysyq +
				", lq=" + lq +
				", gjzwsyq=" + gjzwsyq +
				", yydj=" + yydj +
				", nydsyq=" + nydsyq +
				'}';
	}
}
