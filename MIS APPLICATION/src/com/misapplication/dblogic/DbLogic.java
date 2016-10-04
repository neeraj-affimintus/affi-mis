package com.misapplication.dblogic;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbLogic {

	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mis","root","root");
		}
		catch(Exception ref)
		{
			ref.printStackTrace();
		}

		return con;
	}

}
