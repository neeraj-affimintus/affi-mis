package com.misapplication.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.misapplication.model.BussinessLogics;

@WebServlet("/updaterole")
public class updaterole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updaterole() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String string=request.getParameter("role");
		String array[]=string.split("#");

		String role=array[0];
		String email=array[1];
	
		int i=BussinessLogics.updateRole(role, email);
		
		if(i!=0)
		{
			response.sendRedirect("admindashboard");
		}
		else
		{
			System.out.println("Not Update");
		}
	
	}

}
