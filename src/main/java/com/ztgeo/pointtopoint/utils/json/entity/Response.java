package com.ztgeo.pointtopoint.utils.json.entity;

import java.util.ArrayList;

public class Response {
	private Responsehead head;//返回头
	private ArrayList<Responsedata> datas;//返回数据
	public Responsehead getHead() {
		return head;
	}
	public void setHead(Responsehead head) {
		this.head = head;
	}
	public ArrayList<Responsedata> getDatas() {
		return datas;
	}
	public void setDatas(ArrayList<Responsedata> datas) {
		this.datas = datas;
	}
	@Override
	public String toString() {
		return "Response [head=" + head + ", datas=" + datas + "]";
	}
	
}
