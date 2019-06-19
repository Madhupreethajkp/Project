package com.pack.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="service",schema="project")
public class Center {
	@Id
	private Integer serviceId;
	private String centerName;
	private String type;
	@DateTimeFormat(pattern="MM/dd/YYYY")
	@Temporal(TemporalType.DATE)
	private Date availability;
	
	private Float cost;
	
	private Float cost1;

	private Float cost2;
	public Center(Integer serviceId, String centerName, String type, Date availability, Float cost, Float cost1,
			Float cost2, Float rating) {
		super();
		this.serviceId = serviceId;
		this.centerName = centerName;
		this.type = type;
		this.availability = availability;
		this.cost = cost;
		this.cost1 = cost1;
		this.cost2 = cost2;
		this.rating = rating;
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
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public Center() {
		super();
	}
	
	private Float rating;
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getAvailability() {
		return availability;
	}
	public void setAvailability(Date availability) {
		this.availability = availability;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}

}
