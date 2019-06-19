package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack.model.Product;
import com.pack.model.Vendor;
import com.pack.service.LoginServiceImpl;

/**
 * Servlet implementation class VendorController
 */
@WebServlet("/VendorController")
public class VendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		List<Vendor> vendorList=new LoginServiceImpl().fetchVendors();
		
		request.setAttribute("vendList", vendorList);
		RequestDispatcher rd=request.getRequestDispatcher("/vendor.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.setContentType("text/html");
		//PrintWriter pw=response.getWriter();
		//List<Vendor> vendorList=new LoginServiceImpl().fetchVendors();
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		List<Vendor> vendorList=new LoginServiceImpl().fetchVendors();
		
		request.setAttribute("vendList", vendorList);
		RequestDispatcher rd=request.getRequestDispatcher("/vendor.jsp");
		rd.forward(request, response);
		
	}

}
