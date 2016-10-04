<%@ include file="admindash.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="CreateUserServlet">
		<table>	
			<tr>
				<td><input type="text" value="First Name" name="firstname"></td>
				<td><input type="text" value="Last Name" name="lastname"></td>
			</tr>
			<tr>
				<td><select name="role">
					<option value="HR">HR</option>
					<option value="Employee">Employee</option>
					<option value="Client">Client</option>
					<option value="Sales Consultant">Sales Consultant</option>
					<option value="Sales BDE">Sales BDE</option>
				</select>
				</td>
				<td><input type="text" value="email" name="email"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create"></td>
			</tr>
		</table>
	</form>
</body>
</html>