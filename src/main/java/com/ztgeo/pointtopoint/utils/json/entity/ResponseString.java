package com.ztgeo.pointtopoint.utils.json.entity;

public class ResponseString {
	public String head;
	public String data;
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseString [head=" + head + ", data=" + data + "]";
	}
	
	
}
