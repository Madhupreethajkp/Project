package com.pack.form;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="type",schema="project")
public class Type {
	@Id
	private Integer requestId;
private Integer serviceId;
private Float cost;
private Float cost1;
private Float cost2;
public Type() {
	super();
}
public Type(Integer requestId,Integer serviceId, Float cost, Float cost1, Float cost2) {
	super();
	this.requestId = requestId;
	this.serviceId = serviceId;
	this.cost = cost;
	this.cost1 = cost1;
	this.cost2 = cost2;
}
public Integer getRequestId() {
	return requestId;
}
public void setRequestId(Integer requestId) {
	this.requestId = requestId;
}
public Integer getServiceId() {
	return serviceId;
}
public void setServiceId(Integer serviceId) {
	this.serviceId = serviceId;
}
public Float getCost() {
	return cost;
}
public void setCost(Float cost) {
	this.cost = cost;
}
public Float getCost1() {
	return cost1;
}
public void setCost1(Float cost1) {
	this.cost1 = cost1;
}
public Float getCost2() {
	return cost2;
}
public void setCost2(Float cost2) {
	this.cost2 = cost2;
}
}
