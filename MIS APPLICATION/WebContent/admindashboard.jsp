<%@page import="com.misapplication.pojo.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Director | Dashboard</title>
</head>
<body>
      <%
      
      String name=(String)session.getAttribute("name");
		int totalUsers=(Integer)session.getAttribute("totalusers");
      %>
		<%
		ArrayList array=(ArrayList)request.getAttribute("ar");

		
		%>

                                <table>
                                    <tr>
                                      <th>First Name</th>
                                      <th>Last Name</th>
                                      <th>Email</th>
                                      <th>User Role</th>
                                  </tr>
                              <%
                  			for(Object ob:array)
                			{
                				User u=(User)ob;

                              %>
                                <tr>
                                  <td><%=u.getFirstName()%></td>
                                  <td><%=u.getLastName()%></td>
                                  <td><%=u.getUserName()%></td>
								  <td><form action="updaterole">
									<select name="role">
										<option value="<%=u.getRole()%>#<%=u.getUserName()%>"><%=u.getRole()%></option>
										<option value="Hr#<%=u.getUserName()%>">HR</option>
										<option value="Employee#<%=u.getUserName()%>">Employee</option>
										<option value="Client#<%=u.getUserName()%>">Client</option>
										<option value="Consultant#<%=u.getUserName()%>">Consultant</option>
										<option value="Sales BDE#<%=u.getUserName()%>">Sales BDE</option>
									</select>
									<input class="btn btn-success" type="submit" value="UpdateRole">
									  </form></td>
								<td><a class="btn btn-success" href="emailpassword.jsp">Send Mail</a></td>			
								<td><a class="btn btn-success" href="UserDelete?email=<%=u.getUserName()%>">DELETE</a></td>
                              </tr>
                      <%
                			}
                      %>
                      </table>




</body>

</html>