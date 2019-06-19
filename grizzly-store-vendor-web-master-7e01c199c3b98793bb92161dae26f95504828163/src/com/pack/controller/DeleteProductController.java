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

//import com.pack.model.Customer;
import com.pack.model.Product;
//import com.pack.service.CustomerServiceImpl;
import com.pack.service.LoginServiceImpl;

/**
 * Servlet implementation class DeleteProductController
 */
@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String pname=request.getParameter("pname");
		int i=0;
		try {
			i=new LoginServiceImpl().deleteProduct(pname);
		}
		catch(Exception e) {}
		if(i!=0) {
			List<Product> l=new LoginServiceImpl().fetchProducts();
			request.setAttribute("prodList", l);
			RequestDispatcher rd=request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
	}
	}
}

