package com.pack.form;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delivery_info",schema="project")
public class DeliveryInfo {
@Id
private Integer requestId;
public Integer getRequestId() {
	return requestId;
}
public void setRequestId(Integer requestId) {
	this.requestId = requestId;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
private String dname;
}
