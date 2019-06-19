package com.pack.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.model.Login;
import com.pack.service.LoginServiceImpl;

import java.io.*
;/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//int att=3;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int userid=Integer.parseInt(request.getParameter("userid"));
		String password=request.getParameter("password");
		Login l=new Login(userid,password);
		boolean i=new LoginServiceImpl().checkDetails(l);

		if(i) {
            int  count=new LoginServiceImpl().getCountValue(l);
			//int k=new LoginServiceImpl().setZeroCount(l);
            //pw.println("Login Success");
		//	RequestDispatcher rd=request.getRequestDispatcher("product.jsp");
			//rd.forward(request, response);
            
          
            if(count==3)
            {
                            pw.println("Attempt locked!!!");
            }
		
		
		
		else {		
		

        int j=new LoginServiceImpl().setZeroCount(l);
        pw.println("setzerocount"+j);

		}
		
		
        String username=new LoginServiceImpl().getUsername(l);
        l.setUsername(username);
        String designation=new LoginServiceImpl().getDesignation(l);
        l.setDesignation(designation);
        String office=new LoginServiceImpl().getOffice(l);
        l.setOffice(office);
        HttpSession hs=request.getSession();
        hs.setAttribute("admin", l);
        hs.setAttribute("username", l.getUsername());
        hs.setAttribute("userid", l.getUserid());
        hs.setAttribute("designation", l.getDesignation());
        hs.setAttribute("office", l.getOffice());
        response.sendRedirect("/grizzly-store-admin-web/ProductController");
}

		
		
		else
		{
		
            int count=new LoginServiceImpl().getCountValue(l);
            if(count==3)
            {
                  pw.println("Account Locked");
            }
            else
            {
                  int j=new LoginServiceImpl().incrementCount(l,count);
                
                  RequestDispatcher rd=request.getRequestDispatcher("/login.html");
                  rd.include(request,response);
                  
            }


			
		}
	}
}
	


