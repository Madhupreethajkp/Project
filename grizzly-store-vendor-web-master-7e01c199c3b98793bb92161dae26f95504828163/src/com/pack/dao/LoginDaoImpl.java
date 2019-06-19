package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pack.JdbcConnection;
import com.pack.model.Login;
import com.pack.model.Product;
import com.pack.model.Vendor;


	
	public class LoginDaoImpl implements LoginDao {

		public boolean checkDetails(Login l) {
			// TODO Auto-generated method stub
			Connection con=null;
			boolean ans=false;
			try {
				System.out.println("hello");
			con=JdbcConnection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select userid,password from admin where userid=? and password=?");
			ps.setInt(1, l.getUserid());
			ps.setString(2, l.getPassword());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				ans=true;
				
				
			}
			}
			catch(Exception e) {
			}
			return ans;
			}
			
			
			public int getCountValue(Login l) {
	            // TODO Auto-generated method stub
	            int count=0;
	            Connection con=null;
	            try
	            {
	                   con=JdbcConnection.getConnection();
	                   PreparedStatement ps=con.prepareStatement("select count from admin where userid=?");
	                   ps.setInt(1,l.getUserid());
	                   ResultSet rs=ps.executeQuery();
	                   if(rs.next())
	                   {
	                         count=rs.getInt(1);
	                   }
	                   
	            }
	            catch(Exception e)
	            {
	                   System.out.println(e);
	            }
	            
	            return count;
	     }


	     public int incrementCount(Login l, int count) {
	            // TODO Auto-generated method stub
	            Connection con=null;
	            int c=0;
	            try
	            {
	                   con=JdbcConnection.getConnection();
	                   PreparedStatement ps=con.prepareStatement("update  admin set count=? where userid=?");
	                   ps.setInt(1,count+1);
	                   ps.setInt(2, l.getUserid());
	                   c=ps.executeUpdate();
	                   
	            }
	            catch(Exception e) {
				
	            }
			return c;
		}
	     public int setZeroCount(Login l) {
	         // TODO Auto-generated method stub
	         Connection con=null;
	         int c=0;
	         try
	         {
	                con=JdbcConnection.getConnection();
	                PreparedStatement ps=con.prepareStatement("update  admin set count=0 where userid=?");
	                ps.setInt(1, l.getUserid());
	                c=ps.executeUpdate();
	                
	         }
	         catch(Exception e)
	         {
	                System.out.println(e);
	         }
	         return c;
	         
	  }


	     public String getUsername(Login l) {
	         // TODO Auto-generated method stub
	         Connection con=null;
	         String username=null;
	         try
	         {
	                         con=JdbcConnection.getConnection();
	                         PreparedStatement ps=con.prepareStatement("select username from profile where userid=?");
	                         ps.setInt(1, l.getUserid());
	                         
	                         ResultSet rs=ps.executeQuery();
	                         if(rs.next())
	                         {
	                                         username=rs.getString(1);
	                         }
	         }
	         catch(Exception e)
	         {
	                         System.out.println(e);
	         }
	         return username;
	 }


	
	


	 public int insertProduct(Product p) {
			// TODO Auto-generated method stub
			
			Connection con=null;
			int i=0;
			try {
				con=JdbcConnection.getConnection();
				
				PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?,?,?,?,?)");
				ps.setInt(1,p.getPid());
				ps.setString(2,p.getCategory());
				ps.setString(3, p.getName());
				ps.setString(4, p.getDescription());
	            ps.setInt(5, p.getPrice());
	            ps.setString(6, "apple");
	            ps.setFloat(7, (float) 4.5);
	            ps.setString(8,"40%");	
	            ps.setInt(9,p.getQuantity());
				i=ps.executeUpdate();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			finally {
				try {
					if(con!=null) 
						con.close();
					
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			return i;
		}


		public List<Product> fetchProducts() {
			// TODO Auto-generated method stub
			
			
			
			Connection con=null;
			List<Product> l=new ArrayList<>();
			try {
			con=JdbcConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select name,brand,category,rating from product");
			
			while(rs.next()) {
				Product p=new Product();
				p.setName(rs.getString(1));
				p.setBrand(rs.getString(2));
				p.setCategory(rs.getString(3));
				p.setRating(rs.getFloat(4));
				l.add(p);
				}
	System.out.println(rs);
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				try {
					if(con!=null)
						con.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}
				}
			

			return l;
		}


		@Override
		public Product fetchProduct(String pname)  {
			// TODO Auto-generated method stub
			Product p=null;
			Connection con=null;
			try {
					con=JdbcConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select name,brand,rating,description,price,discount from product where name=?");
			ps.setString(1, pname);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				p=new Product();
				p.setName(rs.getString(1));
				p.setBrand(rs.getString(2));
			    p.setRating(rs.getFloat(3));
			    p.setDescription(rs.getString(4));
			    p.setPrice(rs.getInt(5));
			p.setDiscount(rs.getString(6));
			}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				try {
					if(con!=null)
						con.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}
				}
			
			
			
			return p;
		}


		public int deleteProduct(String pname) throws Exception {
			// TODO Auto-generated method stub
			
			Connection con=JdbcConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from product where name=?");
			ps.setString(1,pname);
			int i=ps.executeUpdate();
			con.close();
			ps.close();
			return i;
			
		}


		public float getRating(Login l) {
			// TODO Auto-generated method stub
			
			 Connection con=null;
	         float rating=0;
	         try
	         {
	                         con=JdbcConnection.getConnection();
	                         PreparedStatement ps=con.prepareStatement("select rating from profile where userid=?");
	                         ps.setInt(1, l.getUserid());
	                         ResultSet rs=ps.executeQuery();
	                         if(rs.next())
	                         {
	                                         rating=rs.getFloat(1);
	                         }
	         }
	         catch(Exception e)
	         {
	                         System.out.println(e);
	         }
	         return rating;
		}


		@Override
		public String getContact(Login l) {
			// TODO Auto-generated method stub
			 Connection con=null;
	         String contact=null;
	         try
	         {
	                         con=JdbcConnection.getConnection();
	                         PreparedStatement ps=con.prepareStatement("select contact from profile where userid=?");
	                         ps.setInt(1, l.getUserid());
	                         ResultSet rs=ps.executeQuery();
	                         if(rs.next())
	                         {
	                                         contact=rs.getString(1);
	                         }
	         }
	         catch(Exception e)
	         {
	                         System.out.println(e);
	         }
	         return contact;
			
		}


		@Override
		public String getAddress(Login l) {
			// TODO Auto-generated method stub
			 Connection con=null;
	         String address=null;
	         try
	         {
	                         con=JdbcConnection.getConnection();
	                         PreparedStatement ps=con.prepareStatement("select address from profile where userid=?");
	                         ps.setInt(1, l.getUserid());
	                         ResultSet rs=ps.executeQuery();
	                         if(rs.next())
	                         {
	                                         address=rs.getString(1);
	                         }
	         }
	         catch(Exception e)
	         {
	                         System.out.println(e);
	         }
	         return address;
			
		}


		@Override
		public List<Vendor> fetchVendors() {
			// TODO Auto-generated method stub

			Connection con=null;
			List<Vendor> l=new ArrayList<>();
			try {
			con=JdbcConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select stock,req,buffer,pending,vid from vendor");
			
			while(rs.next()) {
				Vendor v=new Vendor();
				v.setStock(rs.getInt(1));
				v.setReq(rs.getInt(2));
				v.setBuffer(rs.getInt(3));
				v.setPending(rs.getInt(4));
				v.setVid(rs.getInt(5));
				l.add(v);
				}
	System.out.println(rs);
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
			finally {
				try {
					if(con!=null)
						con.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}
				}
			

			return l;
			
		}


		@Override
		public int updateQuantity(int quantity,int vid) {
			// TODO Auto-generated method stub
			
				
            Connection con=null;
            int i=0;
            try
            {
                   con=JdbcConnection.getConnection();
                   PreparedStatement ps=con.prepareStatement("update vendor set req=? where vid=?");
                   ps.setInt(1, quantity);
                   ps.setInt(2, vid);
                   i=ps.executeUpdate();
            }
            catch(Exception e)
            {
                   System.out.println(e);
            }
            finally
            {
                   try
                   {
                         if(con!=null)
                                con.close();
                   }
                   catch(Exception e)
                   {
                         System.out.println(e);
                   }
            }
            return i;
     }


		



		

}
