<%@page import="com.misapplication.pojo.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
		<%
ArrayList array=(ArrayList)request.getAttribute("ar");
		
		
		%>
	<table border="2">
		<tr>
			<td align="center">First Name</td>
			<td align="center">Last Name</td>
			<td align="center">Email</td>
			<td align="center">User Role</td>
		</tr>
		
		<%
			for(Object ob:array)
			{
				User u=(User)ob;
				
		%>
		<tr>
			<td align="center"><%=u.getFirstName()%></td>
			
			<td align="center"><%=u.getLastName()%></td>
			
			<td align="center"><%=u.getUserName()%></td>
			
			<td align="center"><form action="updaterole">
			<select name="role">
				<option value="<%=u.getRole()%>#<%=u.getUserName()%>"><%=u.getRole()%></option>
				<option value="Hr#<%=u.getUserName()%>">HR</option>
				<option value="Employee#<%=u.getUserName()%>">Employee</option>
				<option value="Client#<%=u.getUserName()%>">Client</option>
				<option value="Consultant#<%=u.getUserName()%>">Consultant</option>
				<option value="Sales BDE#<%=u.getUserName()%>">Sales BDE</option>
			</select>
			<input class="btn btn-success" type="submit" value="UpdateRole">
			</form>
			</td>
			<td><a class="btn btn-success" href="emailpassword.jsp">Send Mail</a></td>						
			<td><a class="btn btn-success" href="UserDelete?email=<%=u.getUserName()%>">DELETE</a></td>
		</tr>
				
		<%
			}
		%>
	</table>
	
	
</body>
</html>