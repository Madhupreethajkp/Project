package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pack.dao.LoginDaoImpl;
import com.pack.service.LoginServiceImpl;

/**
 * Servlet implementation class ManageController
 */
@WebServlet("/ManageController")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
	/*	PrintWriter pw=response.getWriter();
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int vid=Integer.parseInt(request.getParameter("vid"));
		 int i=new LoginServiceImpl().updateQuantity(quantity,vid);
		 
		 RequestDispatcher rd=request.getRequestDispatcher("/VendorController");
		 rd.forward(request, response);
		*/ 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity);
		int vid=Integer.parseInt(request.getParameter("vid"));
		System.out.println(vid);
		 int i=new LoginServiceImpl().updateQuantity(quantity,vid);
		 
		 RequestDispatcher rd=request.getRequestDispatcher("/VendorController");
		 rd.forward(request, response);
		
		
	}

}
