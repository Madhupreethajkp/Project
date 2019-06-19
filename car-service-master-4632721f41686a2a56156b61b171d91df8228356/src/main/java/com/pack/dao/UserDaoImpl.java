package com.pack.dao;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.pack.form.Admin;
import com.pack.form.Center;
import com.pack.form.Delivery;
import com.pack.form.DeliveryInfo;
import com.pack.form.Request;
import com.pack.form.Status;
import com.pack.form.Type;
import com.pack.form.User;
@Repository
public class UserDaoImpl implements UserDao {
	private static Logger log=Logger.getLogger(UserDaoImpl.class);
	public void addUser(User u) {
		
		// TODO Auto-generated method stub
		log.info("dao add");
		sessionFactory.getCurrentSession().save(u);
		
		
	}
	private SessionFactory sessionFactory;
	

	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addAdmin(Admin a) {
		// TODO Auto-generated method stub
		log.info("dao add");
		sessionFactory.getCurrentSession().save(a);
		
	}
	public int validateUser(User u) {
		System.out.println("above query");
		Query q=sessionFactory.getCurrentSession().createQuery("from User u where u.userId=:userId and u.password=:password");
		
		q.setParameter("userId",u.getUserId());
		q.setParameter("password", u.getPassword());
		System.out.println("above query");
		User u1=(User)q.uniqueResult();
		//List l=q.list();
		//System.out.println(l);
		if(u1!=null)
			{
			System.out.println("login success");
			
			return 1;
			}
		else 
			return 0;
	    
	    }
	public int validateAdmin(Admin a) {
		System.out.println("above query");
		Query q=sessionFactory.getCurrentSession().createQuery("from Admin a where a.adminId=:adminId and a.password=:password");
		
		q.setParameter("adminId",a.getAdminId());
		q.setParameter("password", a.getPassword());
		System.out.println("above query");
		Admin u1=(Admin)q.uniqueResult();
		//List l=q.list();
		//System.out.println(l);
		if(u1!=null)
			{
			System.out.println("login success");
			
			return 1;
			}
		else 
			return 0;
	    
	    }

	public void addService(Center ser) {
		// TODO Auto-generated method stub
	//SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
	//ser.setAvailability(sd.parse(ser.getAvailability()));
		log.info("dao add service"+ser.getAvailability()+""+ser.getType());
		
		sessionFactory.getCurrentSession().save(ser);
		
		
	}

	public List<Center> listService() {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("from Center");
		List l=q.list();
		return l;
		
	}

	public void addRequest1(Type ty) {
		// TODO Auto-generated method stub
		log.info("type inside");
		sessionFactory.getCurrentSession().save(ty);
		
	}

	public void addRequest(Status st) {
		// TODO Auto-generated method stub
		log.info("type inside");
		sessionFactory.getCurrentSession().save(st);
		
		
	}

	public List<Status> listRequest(String userId) {
       System.out.println(userId);
		Query q=sessionFactory.getCurrentSession().createQuery("from Status s where s.userId=:userId");
	
		q.setParameter("userId", userId);
		List l=q.list();
		 System.out.println(userId);
		return l;
	}

	public void acceptRequest(int reqId) {
		String s="accepted";
		System.out.println(reqId);
		
		Query q=sessionFactory.getCurrentSession().createQuery("update Status s set s.status=:status where s.requestId=:requestId");
		
		q.setParameter("requestId", reqId);
		
		q.setParameter("status", s);
		q.executeUpdate();
		
	
	}

	public List<Status> listStatus() {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("from Status");
		List l=q.list();
		return l;
	
	}

	public void rejectRequest(int reqId) {
		// TODO Auto-generated method stub
		String s="rejected";
		System.out.println(reqId);
		
		Query q=sessionFactory.getCurrentSession().createQuery("update Status s set s.status=:status where s.requestId=:requestId");
		
		q.setParameter("requestId", reqId);
		
		q.setParameter("status", s);
		q.executeUpdate();
		
		
	
		
	}

	public List<Delivery> deliverylist() {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("from Delivery d where d.status=:status");
		q.setParameter("status", "NotAssigned");
		List l=q.list();
		return l;
	}

	public void addDelivery(DeliveryInfo d) {
		// TODO Auto-generated method stub
		log.info("inside add delivery");
		sessionFactory.getCurrentSession().save(d);
	}

	public void updateStatus(String dname) {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("update Delivery d set d.status=:status where d.dname=:dname");
		q.setParameter("status","Assigned");
		q.setParameter("dname", dname);
		q.executeUpdate();
		System.out.println("updated");
	}

	public String viewDetails(Integer requestId) {
		
		Query q=sessionFactory.getCurrentSession().createQuery("select d.dname from DeliveryInfo d where d.requestId=:requestId");
	
		q.setParameter("requestId", requestId);
		log.info("haii");
		String l=(String)q.uniqueResult();
		return l;
		
		
	}

	public List<Delivery> listDelivery(String dname) {
		Query q=sessionFactory.getCurrentSession().createQuery("from Delivery d where d.dname=:dname");
		
		q.setParameter("dname",dname);
		log.info("haii");
		List l=q.list();
		return l;
	}

	public List<Status> listRequest1(Integer requestId) {
		Query q=sessionFactory.getCurrentSession().createQuery("from Status s where s.requestId=:requestId");
		q.setParameter("requestId", requestId);
		System.out.println(requestId);
		List l=q.list();
		return l;
	}

	public List<Status> listAllRequest() {
		Query q=sessionFactory.getCurrentSession().createQuery("from Status");
		List l=q.list();
		return l;
		
	}

	public List listCenter(Integer serviceId) {
		Query q=sessionFactory.getCurrentSession().createQuery("from Center c where c.serviceId=:serviceId");
		q.setParameter("serviceId", serviceId);
		
		List l=q.list();
		return l;
	}

	public void confirmRequest(Request r) {
		sessionFactory.getCurrentSession().save(r);
		
	}

	public List<Request> billGenerate(Integer requestId) {
		Query q=sessionFactory.getCurrentSession().createQuery("from Request r where r.requestId=:requestId");
		q.setParameter("requestId",requestId);
		
		List l=q.list();
		return l;
		
	}

	

	

	
	

	
}