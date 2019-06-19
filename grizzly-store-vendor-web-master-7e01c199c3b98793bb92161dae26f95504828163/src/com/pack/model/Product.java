

package com.pack.model;

public class Product {
private int pid;
private int price;
private String brand,discount;
private int quantity;
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getDiscount() {
	return discount;
}
public void setDiscount(String discount) {
	this.discount = discount;
}
public float getRating() {
	return rating;
}
public void setRating(float rating) {
	this.rating = rating;
}
private float rating;
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
private String category,name,description;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Product() {
	
}
public Product(int pid, String category, String name, String description,int price,int quantity) {
	super();
	this.pid = pid;
	this.category = category;
	this.name = name;

	this.description = description;
this.price=price;
this.quantity=quantity;
}


}
