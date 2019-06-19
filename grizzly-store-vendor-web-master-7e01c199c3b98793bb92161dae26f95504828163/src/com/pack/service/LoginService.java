package com.pack.service;

import java.util.List;

import com.pack.model.Login;
import com.pack.model.Product;
import com.pack.model.Vendor;

public interface LoginService {
	public boolean checkDetails(Login l);
	public int getCountValue(Login l);
	public int incrementCount(Login l,int count);
	public int setZeroCount(Login l);
	public String getUsername(Login l);
	
	public int insertProduct(Product p);
	public List<Product> fetchProducts();
	public Product fetchProduct(String pname);
public float getRating(Login l);
public String getContact(Login l);
public String getAddress(Login l);
public List<Vendor> fetchVendors();
public int updateQuantity(int quantity,int vid);
}
