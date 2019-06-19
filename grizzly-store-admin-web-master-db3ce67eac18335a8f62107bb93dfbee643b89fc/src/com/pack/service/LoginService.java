package com.pack.service;

import java.util.List;

import com.pack.model.Login;
import com.pack.model.Product;

public interface LoginService {
	
public boolean checkDetails(Login l);
public int getCountValue(Login l);
public int incrementCount(Login l,int count);
public int setZeroCount(Login l);
public int insertProduct(Product p);
public List<Product> fetchProducts();
public Product fetchProduct(String pname);
public String getUsername(Login l);
public String getDesignation(Login l);
public String getOffice(Login l);
}
