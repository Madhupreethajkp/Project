package com.pack.model;

public class Vendor {
private int stock;
private int req;
private int buffer;
private int pending;
private int vid;

public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getReq() {
	return req;
}
public Vendor(int stock, int req, int buffer, int pending,int vid) {
	super();
	this.stock = stock;
	this.req = req;
	this.buffer = buffer;
	this.pending = pending;
	this.vid=vid;
}
public Vendor() {
	// TODO Auto-generated constructor stub
}
public void setReq(int req) {
	this.req = req;
}
public int getBuffer() {
	return buffer;
}
public void setBuffer(int buffer) {
	this.buffer = buffer;
}
public int getPending() {
	return pending;
}
public void setPending(int pending) {
	this.pending = pending;
}
public int getVid() {
	return vid;
}
public void setVid(int vid) {
	this.vid = vid;
}

}
