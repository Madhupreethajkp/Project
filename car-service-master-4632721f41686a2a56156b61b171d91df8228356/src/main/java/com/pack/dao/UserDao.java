package com.pack.dao;

import java.util.List;

import com.pack.form.Admin;
import com.pack.form.Center;
import com.pack.form.Delivery;
import com.pack.form.DeliveryInfo;
import com.pack.form.Request;
import com.pack.form.Status;
import com.pack.form.Type;
import com.pack.form.User;

public interface UserDao {
public void addUser(User u);
public void addAdmin(Admin a);
public int validateUser(User u);
public int validateAdmin(Admin a);
public void addService(Center ser);
public  List<Center> listService();

public void addRequest1(Type ty);
public void addRequest(Status st);
public List<Status> listRequest(String g);
public void acceptRequest(int reqId);
public List<Status> listStatus();
public void rejectRequest(int reqId);
public List<Delivery> deliverylist();
public void addDelivery(DeliveryInfo d);
public void updateStatus(String dname);
public String viewDetails(Integer requestId);
public List<Delivery> listDelivery(String dname);
public List<Status> listRequest1(Integer RequestId);
public List<Status> listAllRequest();
public List listCenter(Integer serviceId);
public void confirmRequest(Request r);
public List<Request> billGenerate(Integer requestId);

}
