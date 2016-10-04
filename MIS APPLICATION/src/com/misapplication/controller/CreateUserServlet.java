package com.misapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.misapplication.model.BussinessLogics;

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateUserServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		System.out.println("These is User Servlet");
		
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String role=request.getParameter("role");
		String email=request.getParameter("email");
	
		int i=BussinessLogics.createUser(firstName, lastName, role, email);
	
		if(i!=0)
		{
			response.sendRedirect("admindashboard");
		}
		else
		{
			response.sendRedirect("admincreateuser.jsp");
		}
		
	}

}
