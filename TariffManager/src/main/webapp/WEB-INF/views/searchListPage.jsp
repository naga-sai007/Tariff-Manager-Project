<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="tags"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SearchList</title>
	</head>
<body>

	<div style="background-color:blue;">
			<h1  style="display:inline-block;color:white;">TariffManager</h1>
			<a href="home"  style="display:inline-flex;float:right;color:white;margin:25px;">Home</a>
	</div>	

	<div style="float:left;padding:25px;" >
		<table  class="table table-striped">  
			<caption class="text-control">Users List</caption>
				<tr>
					<th id="id">S No</th>
					<th id="name">Name</th>
					<th id="role">Role</th>
					<th id="email">Email</th>
					<th id="mobileNumber">Mobile Number</th>
					<th id="edit">Edit</th>
					<th id="delete">Delete</th>
				</tr>  
			   <c:forEach var="user" items="${searchList}">   
				   <tr>  
					   <td>${user.id}</td>  
					   <td>${user.username}</td>  
					   <td>${user.role}</td>  
					   <td>${user.email}</td>  
					   <td>${user.mobileNumber} </td>
					   <td><form action="/TariffManager/admin/user/${user.id }" method="post"><button>edit</button></form></td>  
					   <td><form:form action="/TariffManager/admin/user/${user.id}" method="get"><button onclick="if(!(confirm('Do you want to delete the user'))) return false">delete</button></form:form></td>  
				   </tr>  
			   </c:forEach>  
	   </table>  
	</div>
</body>
</html>