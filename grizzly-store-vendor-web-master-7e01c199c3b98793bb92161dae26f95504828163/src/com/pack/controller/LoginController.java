package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.model.Login;
import com.pack.service.LoginServiceImpl;

/**
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int userid=Integer.parseInt(request.getParameter("userid"));
		String password=request.getParameter("password");
		Login l=new Login(userid,password);
		boolean i=new LoginServiceImpl().checkDetails(l);

		if(i) {
            int  count=new LoginServiceImpl().getCountValue(l);
			
          
            if(count==3)
            {
                            pw.println("Attempt locked!!!");
            }
		
		
		
		else {		
		

        int j=new LoginServiceImpl().setZeroCount(l);
      
		}
        String username=new LoginServiceImpl().getUsername(l);
        l.setUsername(username);
        float rating=new LoginServiceImpl().getRating(l);
        l.setRating(rating);
        String contact=new LoginServiceImpl().getContact(l);
        l.setContact(contact);
        String address=new LoginServiceImpl().getAddress(l);
        l.setAddress(address);
        HttpSession hs=request.getSession();
        hs.setAttribute("admin", l);
        hs.setAttribute("username", l.getUsername());
        hs.setAttribute("rating", l.getRating());
        hs.setAttribute("contact", l.getContact());
        hs.setAttribute("address", l.getAddress());
        response.sendRedirect("/grizzly-store-vendor-web/ProductController");
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
