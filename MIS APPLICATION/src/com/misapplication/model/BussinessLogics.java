package com.misapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.misapplication.dblogic.DbLogic;


public class BussinessLogics {

	
	static Connection con=	DbLogic.getConnection();

		public static String getName(String userName,String password)
		{
			String name=null;
			try
			{
				PreparedStatement ps=con.prepareStatement("select firstname,lastname from user where username=? and password=?");
				ps.setString(1, userName);
				ps.setString(2, password);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					name=rs.getString(1)+" "+rs.getString(2);
				}
				
			}
			catch(Exception ref)
			{
				ref.printStackTrace();
			}
			
			return name; 
		}
		
		
		public static String adminLogin(String userName,String password)
		{
			System.out.println(userName);
			System.out.println(password);
			
			
			String role=null;
			try
			{
				PreparedStatement ps=con.prepareStatement("select role from user where username=? and password=?");
				ps.setString(1, userName);
				ps.setString(2, password);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					role=rs.getString(1);
				}
			}
			catch(Exception ref)
			{
				ref.printStackTrace();
			}

			return role;
		}
		
		public static int createUser(String firstName,String lastName,String role,String email)
		{
			
			System.out.println("These is createuser Method");
			int i=0;
			
			String firstIndex=lastName.substring(0, 1);
			String password=firstName+firstIndex+"@123";
			
			

			try
			{
				PreparedStatement ps=con.prepareStatement("insert into user(firstname,lastname,username,password,role) values(?,?,?,?,?)");
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setString(3, email);
				ps.setString(4, password);
				ps.setString(5, role);
				
				i=ps.executeUpdate();
				
			}
			catch(Exception ref)
			{
				ref.printStackTrace();
			}
			
			return i;
		}
	
	
		public static ResultSet admindashboard()
		{
			ResultSet rs=null;
			try
			{
				PreparedStatement ps=con.prepareStatement("select * from user where NOT role='admin'");
				rs=ps.executeQuery();
				
			}
			catch(Exception ref)
			{
				ref.printStackTrace();
			}
			
			return rs;
		}
		
		public static ResultSet hrDashBoard(String userName)
		{
			System.out.println("User Name Is"+userName);
			ResultSet rs=null;
			try
			{
				PreparedStatement ps=con.prepareStatement("select * from user where NOT role='admin' and NOT username=?");
				ps.setString(1, userName);
				rs=ps.executeQuery();
				
				
			}
			catch(Exception ref)
			{
				ref.printStackTrace();
			}
			
			return rs;
		}
		
		public static int updateRole(String role,String email)
		{
			int i=0;
			try
			{
				PreparedStatement ps=con.prepareStatement("update user set role=? where username=?");
				ps.setString(1, role);
				ps.setString(2, email);
				
				i=ps.executeUpdate();
			}
			catch(Exception ref)
			{
				ref.printStackTrace();
			}
			
			return i;
		}
		
		
		public static int userDelete(String email)
		{
			int i=0;
			try
			{
				PreparedStatement ps=con.prepareStatement("delete from user where username=?");
				ps.setString(1, email);
				
				i=ps.executeUpdate();
			}
			catch(Exception ref)
			{
				ref.printStackTrace();
			}
			
			return i;
		}
		
		
		public static String getRole(String userName)
		{
			String role=null;
			try
			{
				PreparedStatement ps=con.prepareStatement("select role from user where username=?");
				ps.setString(1, userName);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					role=rs.getString(1);
				}
			}
			catch(Exception ref)
			{
				ref.printStackTrace();
			}
			
			return role;
		}
		
		
		
		public static int getTotalUsers()
		{
			int count=0;
			int totalUsers=0;
			
			try
			{
				PreparedStatement ps=con.prepareStatement("select * from user");
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					do
					{
						count++;
					}while(rs.next());
				}

				totalUsers=count-1;

			}
			catch(Exception ref)
			{
				ref.printStackTrace();
			}
			
			return totalUsers;
		}
		
		
		
		
		
		
		
		
		
		
		
}
