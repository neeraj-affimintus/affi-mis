package com.misapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.misapplication.model.BussinessLogics;

@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserDelete() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		
		int i=BussinessLogics.userDelete(email);
		if(i!=0)
		{
			response.sendRedirect("admindashboard");
		}
		else
		{
			System.out.println("User Delete");
		}
		
		
		
	}

}
