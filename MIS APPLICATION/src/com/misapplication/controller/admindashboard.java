package com.misapplication.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.misapplication.model.BussinessLogics;
import com.misapplication.pojo.User;

@WebServlet("/admindashboard")
public class admindashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public admindashboard() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s=request.getSession();
		String userName=(String)s.getAttribute("username");
		
		if(userName==null)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			
			String role=BussinessLogics.getRole(userName);

			if(role.equals("admin"))
			{
				ResultSet rs=BussinessLogics.admindashboard();
				try
				{
					ArrayList<User> ar=new ArrayList<User>();
				
					if(rs.next())
					{
						do
						{
							User u=new User();
							u.setFirstName(rs.getString(2));
							u.setLastName(rs.getString(3));
							u.setUserName(rs.getString(4));
							u.setRole(rs.getString(6));
						
							ar.add(u);
						}
						while(rs.next());
					
									
						request.setAttribute("ar", ar);
						RequestDispatcher rd=request.getRequestDispatcher("admindashboard.jsp");
						rd.forward(request, response);
					
					}
					else
					{
					
					}
				}
				catch(Exception ref)
				{
					ref.printStackTrace();
				}
				
			}
			
			if(role.equals("HR"))
			{
				ResultSet rs=BussinessLogics.hrDashBoard(userName);
				try
				{
					ArrayList<User> ar=new ArrayList<User>();
				
					if(rs.next())
					{
						do
						{
							User u=new User();
							u.setFirstName(rs.getString(2));
							u.setLastName(rs.getString(3));
							u.setUserName(rs.getString(4));
							u.setRole(rs.getString(6));
						
							ar.add(u);
						}
						while(rs.next());
					
						request.setAttribute("ar", ar);
						RequestDispatcher rd=request.getRequestDispatcher("hrdashboard.jsp");
						rd.forward(request, response);
					}
					else
					{
					
					}
				}
				catch(Exception ref)
				{
					ref.printStackTrace();
				}
				
			}
		}
	}

}
