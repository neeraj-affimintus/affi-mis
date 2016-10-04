package com.misapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.misapplication.model.BussinessLogics;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		String userName=request.getParameter("email");
		String password=request.getParameter("password");
		
		System.out.println(userName);
		System.out.println(password);
		
		
		String role=BussinessLogics.adminLogin(userName, password);
		String name=BussinessLogics.getName(userName, password);
		int totalUsers=BussinessLogics.getTotalUsers();
		
		//Create Session Object And Set UserName.

		HttpSession hs=request.getSession();
		System.out.println(role);

		if(role==null)
		{
			//Set Login Failure Message
			
			hs.setAttribute("loginmessage", "Invalid UserId Or Password");
			response.sendRedirect("index.jsp");
		}
		
		else
		{
			//Set user name On Session
			hs.setAttribute("totalusers", totalUsers);
			hs.setAttribute("name", name);
			hs.setAttribute("username", userName);
			
			if(role.equals("admin"))
			{
			
				response.sendRedirect("admindashboard");
			}

			if(role.equals("HR"))
			{
				response.sendRedirect("hrhome.jsp");
			}

			if(role.equals("Employee"))
			{
				response.sendRedirect("employeehome.jsp");
			}

			if(role.equals("Client"))
			{
				response.sendRedirect("clienthome.jsp");
			}
	
			if(role.equals("Sales Consultant"))
			{
				response.sendRedirect("salesconsultanthome.jsp");
			}
	
			if(role.equals("Sales BDE"))
			{
				response.sendRedirect("salesbdehome.jsp");
			}

		}	
	
	}

}
