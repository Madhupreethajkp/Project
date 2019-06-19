package com.pack;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.form.Admin;
import com.pack.form.Center;
import com.pack.form.DeliveryInfo;
import com.pack.form.Request;
import com.pack.form.Status;
import com.pack.form.Type;
import com.pack.form.User;
import com.pack.service.UserService;
@Controller
public class UserController {
	private static final Logger log=Logger.getLogger(UserController.class);	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/redir")
	public String viewForm1()
	{
return "firstpage";
}
	@RequestMapping(value="/use")
	public String viewForm(Map<String,Object> map)
	{
	
		map.put("user", new User());
		return "userRegistration";
}
	@RequestMapping(value="/ad")
	public String viewForm2(Map<String,Object> map)
	{
		
		map.put("admin", new Admin());
		return "adminRegistration";
}

	@RequestMapping(value="/user/add" ,method=RequestMethod.POST)
	public String addUser (@ModelAttribute("user") @Validated User user,BindingResult bindingResult,Model model,HttpServletRequest request,HttpServletResponse response)
	{
		if(bindingResult.hasErrors()) {
			log.info("validation error");
		
			return "userRegistration";
		}
		else
				{
			log.info("add user");
		
			System.out.println(user.getUserId());
			JOptionPane.showMessageDialog(null, "Your details are submitted sucessfully");
			userService.addUser(user);
			
			}
			
		return "redirect:/redir";
	}
	@RequestMapping(value="/admin/add1" ,method=RequestMethod.POST)
	public String addAdmin (@ModelAttribute("admin") @Validated Admin admin,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors()) {
			log.info("validation error");
		
			return "adminRegistration";
		}
		else
				{
			log.info("add admin");
			JOptionPane.showMessageDialog(null, "Your details are submitted sucessfully");
			userService.addAdmin(admin);
			
			}
			
		return "redirect:/redir";
	}
	@RequestMapping(value="/validate")
	public String validateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        
        System.out.println("welcome");
       String userId=request.getParameter("userId");
        String password=request.getParameter("password");
        User u=new User(userId,password);
        System.out.println(u.getUserId()+""+u.getPassword());
       int i= userService.validateUser(u);
       if(i!=0) {
    		HttpSession session=request.getSession();
    		session.setAttribute("userId", userId);
			System.out.println(userId);
    		return "req";
    	     	  
    		}
    	   
   		
       
       else
       {
    	   JOptionPane.showMessageDialog(null, "Please enter valid details");
	return "userlogin";
	}
	
}
	
	@RequestMapping(value="/validate1")
	public String validateAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        
        System.out.println("welcome");
       String adminId=request.getParameter("adminId");
        String password=request.getParameter("password");
        Admin a=new Admin(adminId,password);
        System.out.println(a.getAdminId()+""+a.getPassword());
       int i= userService.validateAdmin(a);
       if(i!=0) {
    	   HttpSession session=request.getSession(); 
   		session.setAttribute("adminId", adminId);
			System.out.println(adminId);
    	          return "adsuccess";
    		}
    	  
       
       else
       {
    	   JOptionPane.showMessageDialog(null, "Please enter valid details");
    	   
	      return "adminlogin";
	}
}
	@RequestMapping(value="/addCenter" ,method=RequestMethod.POST)
	public String addService (Model model,HttpServletRequest request) throws Exception
	{
		Center center=new Center();
		
			if(null==center.getServiceId())
			{
		System.out.println("hiiiiiiiii");
		String dat=request.getParameter("availability");
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		center.setAvailability(sd.parse(dat));
		center.setCenterName(request.getParameter("centerName"));
		System.out.println(request.getParameter("centerName"));
		center.setCost(Float.parseFloat(request.getParameter("cost")));
		center.setCost1(Float.parseFloat(request.getParameter("cost1")));
		center.setCost2(Float.parseFloat(request.getParameter("cost2")));
		center.setRating(Float.parseFloat(request.getParameter("rating")));
		center.setType(request.getParameter("type"));
		System.out.println(center.getAvailability());
			Random r=new Random();
			int n=r.nextInt(90000)+100000;
			center.setServiceId(n);
			System.out.println(center.getServiceId());
			log.info("add service");
			userService.addService(center);
			
			}
			else {
				
			}
			
		return "adsuccess";
	}
	

	


	@RequestMapping(value="/details")
	public String listService(Map<String,Object> map)
	{
		map.put("ser", new Center());
		map.put("serList",userService.listService());
		log.info("Inside list service");
		return "request";
	}

	@RequestMapping("/type")
	   public String addRequestv(@ModelAttribute("ty") @Validated Type ty,Model model,HttpServletRequest req) 
		{
			   String type[]=req.getParameterValues("type");
			   int tcost=0;
			   for(int i=0;i<type.length;i++) {
				   tcost+=Integer.parseInt(type[i]);
			   }
			   int sid=Integer.parseInt(req.getParameter("sid"));
			   System.out.println(tcost+" "+sid);
			    Random r=new Random();
				int n=r.nextInt(90000)+100000;
				ty.setRequestId(n);
				log.info("add type cost");
				userService.addRequest1(ty);
				
			return "request";
		}

	
	@RequestMapping(value="/status/{serviceId}",method=RequestMethod.GET  )
	public String requestGeneration(@PathVariable("serviceId") Integer serviceId,HttpServletRequest request,HttpServletResponse response)
	
	{
		Status s=new Status();
		   
		s.setServiceId(serviceId);
		 Random r=new Random();
			int n=r.nextInt(90000)+100000;
			
			s.setRequestId(n);
			s.setStatus("requested");
			HttpSession session=request.getSession();
    		String s1=(String)session.getAttribute("userId");
			System.out.println(s1);
			s.setUserId(s1);
    		   
			
		log.info("uegwf");
		System.out.println(request.getParameter("amount"));
	    userService.addRequest(s);
	JOptionPane.showMessageDialog(null, "Request Generated "+ " " +"Request id:"+n);
 	   
	     
		
	    return "redirect:/details";
	}
	
	@RequestMapping(value="/viewRequests")
	public String viewRequest(Map<String,Object> map)
	{
		map.put("sta", new Status());
		map.put("serList",userService.listAllRequest());
		log.info("Inside list service");
		return "adminrequests";
	}
	
	@RequestMapping(value="/accept/{requestId}")
	public String acceptRequest(@PathVariable ("requestId") Integer requestId)
	{
		int reqId=requestId;
		userService.acceptRequest(reqId);
		
		return "redirect:/viewRequests";
	}
	@RequestMapping(value="/adminlogin")
	public String login()
	{
		return "adminlogin";
	}
	@RequestMapping(value="/userlogin")
	public String login1()
	{
		return "userlogin";
	}
	@RequestMapping(value="/status")
	public String viewStatus(Map<String,Object> map,HttpServletRequest request)
	{
		map.put("sta", new Status());
     HttpSession session=request.getSession();
     String h=(String)session.getAttribute("userId");
		map.put("ser1List",userService.listRequest(h));
		return "status";
	}
	@RequestMapping(value="/status1")
	public String viewStatus12(Map<String,Object> map)
	{
		System.out.println("status");
		map.put("sta", new Status());
		map.put("ser1List",userService.listStatus());
		return "status1";
	}
	@RequestMapping(value="/reject/{requestId}")
	public String rejectRequest(@PathVariable ("requestId") Integer requestId)
	{
		int reqId=requestId;
		userService.rejectRequest(reqId);
		
		return "redirect:/viewRequests";
	}

	@RequestMapping(value="/adhead" ,method=RequestMethod.GET)
	public String viewHead() {
		return "adsuccess";
	}
	@RequestMapping(value="/drop/{requestId}",method=RequestMethod.GET)
	public String addDelivery(@PathVariable ("requestId") Integer requestId,Map<String,Object> map) {
		map.put("requestId", requestId);
		map.put("deliveryList",userService.deliverylist());
		return "addDelivery";
		
	}
	@RequestMapping(value="/addDeliveryList/{requestId}")
	public String addDeliveryList(@PathVariable("requestId") Integer requestId,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(requestId);
		
		String dname=request.getParameter("delivery");
		request.setAttribute("dname",dname);
		DeliveryInfo d=new DeliveryInfo();
		d.setRequestId(requestId);
		d.setDname(dname);
		try
		{
		userService.addDelivery(d);
		userService.updateStatus(dname);
		JOptionPane.showMessageDialog(null, "Delivery boy assigned");
		return "redirect:/viewRequests";
		}
		catch(Exception e)
		{
			 
		    	   JOptionPane.showMessageDialog(null, "Delivery boy already set");
		    	   
			      return "redirect:/viewRequests";
			
		}
	}
	
	@RequestMapping(value="/viewStatus")
	public String viewStatus1(Map<String,Object> map,HttpServletRequest request)
	{
		map.put("sta", new Status());
		HttpSession session=request.getSession();
		String g=(String)session.getAttribute("userId");
		
		
		map.put("serList",userService.listRequest(g));
		log.info("Inside status service");
		return "statusView";
	}
	
	@RequestMapping(value="/deliveryBoy/{requestId}")
	public String viewDeliveryDetails(@PathVariable ("requestId") Integer requestId,Map<String,Object> map,HttpServletRequest request, HttpServletResponse response)
	{
		
		
		HttpSession session=request.getSession();
		session.setAttribute("requestId", requestId);
		System.out.println();
		log.info("kjgfawd");
		map.put("dname",userService.viewDetails(requestId));
		return "redirect:/detail/{dname}";
		
	}
	@RequestMapping(value="/detail/{dname}")
	public String viewDetails(@PathVariable("dname") String dname,Map<String,Object> map)
	{
		map.put("dname", dname);
		map.put("dList",userService.listDelivery(dname));
		log.info("Inside del list service");
		return "last";
	}
	
	@RequestMapping("/addRequest")
	public String billGenerate(Map<String,Object> map,HttpServletRequest req) {
		log.info("Inside Bill Controller");
		System.out.println(req.getParameter("amount"));
		map.put("ser", new Center());
		map.put("serList",userService.listService());
		log.info("Inside list service");
		return "request"; 
	}
	@RequestMapping(value="/admin/back")
	public String back()
	{
		
		return "adminlogin";
	}
	@RequestMapping(value="/user/back")
	public String back1()
	{
		
		return "userlogin";
	}
	@RequestMapping(value="/back1")
	public String back12()
	{
		
		return "firstpage";
	}
	@RequestMapping(value="/back")
	public String back13()
	{
		
		return "firstpage";
	}
	
	@RequestMapping(value="/confirmRequest/{serviceId}")
	public String viewCenter(@PathVariable("serviceId") Integer serviceId,Map<String,Object> map)
	{
		map.put("serviceId", serviceId);
		map.put("dList",userService.listCenter(serviceId));
		log.info("Inside center list service");
		return "confirm";
	}
	
	@RequestMapping(value="/confirm/{centerName}/{serviceId}",method=RequestMethod.GET)
	public String viewCenter(@PathVariable("centerName") String centerName,@PathVariable("serviceId") Integer serviceId,Model model,HttpServletRequest request) throws Exception
	{
		
		Request r=new Request();
		System.out.println("helloooooo");
		System.out.println(serviceId);
		r.setCenterName(centerName);
		Status st=new Status();
		
String dat=request.getParameter("date");
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		r.setDate((sd.parse(dat)));
		Random ra=new Random();
		int n=ra.nextInt(90000)+100000;
		r.setRequestId(n);
		r.setTotal(Float.parseFloat(request.getParameter("amount")));
	    HttpSession session=request.getSession();
	    r.setUserId((String)(session.getAttribute("userId")));
	    st.setRequestId(n);
	    st.setServiceId(serviceId);
	    st.setStatus("requested");
	    
	    st.setUserId((String)session.getAttribute("userId"));
	    userService.confirmRequest(r);
	    userService.addRequest(st);
	    JOptionPane.showMessageDialog(null, "Request Generated "+ " " +"Request id:"+n);
	    return "redirect:/details";
	    
		
		
		}
		
	
	
	@RequestMapping(value="/billGenerate",method=RequestMethod.GET)
	public String viewBill(Map<String,Object> map,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		Integer requestId=(Integer)session.getAttribute("requestId");
		System.out.println("view" + requestId);
		map.put("dList",userService.billGenearate(requestId));
		log.info("Inside center list service");
		return "bill";
	}
	
	
	
}
