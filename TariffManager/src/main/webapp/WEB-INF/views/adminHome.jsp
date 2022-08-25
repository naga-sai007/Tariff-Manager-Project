<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="tags"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
<!DOCTYPE html>
<html lang="en" xml:lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<title>AdminPage</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	</head>
	
<body >

	<div style="background-color:blue;">
			<h1 style="display:inline-block;color:white;">TariffManager</h1>
			<tags:url  var="logout" value="/"/>
			<a href ="<c:url value="/logout"/>"  style="display:inline-flex;float:right;color:white ;margin:25px;" >Logout</a>	
	</div>

	<div style="padding:50px 150px 20px 300px;">
		<form:form action="admin/user/search" method="get"  modelAttribute="user">
			<form:input  type="text"   placeholder="Type username to search" path="username" required="true" class="form-control"/>
			<form:button type="submit"  class="btn btn-primary btn-sm">Search</form:button>
		</form:form>	
	</div>

	<div style="float:left;padding:25px;" >
		<table  class="table thead-dark">  
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
			   <c:forEach var="user" items="${userList}">   
				   <tr>  
					   <td>${user.id}</td>  
					   <td>${user.username}</td>  
					   <td>${user.role}</td>  
					   <td>${user.email}</td>  
					   <td>${user.mobileNumber} </td>
					   <td><form action="admin/user/${user.id }" method="post"><button>edit</button></form></td>  
					   <td><form:form action="admin/user/${user.id}" method="get"><button onclick="if(!(confirm('Do you want to delete the user'))) return false">delete</button></form:form></td>  
				   </tr>  
			   </c:forEach>  
	   </table>  
	</div>

	<div style="float:right;color: blue;padding:0px 100px 100px 20px;"class="row mb-3;">
		<form:form modelAttribute="user" >
				<h3 class="text-control">ADD Details</h3><br>
			<form:input type="text" placeholder="Enter Name" path="username" required="true" class="form-control"/>
																									<form:errors path="username" /><br>
			<form:input type="text" placeholder="Enter email" path="email" required="true" class="form-control"/>
																									<form:errors path="email"/><br>
			<form:input type="password" placeholder="Enter Password" path="password" required="true" class="form-control"/>
																									<form:errors path="password"/><br>
			<form:input type="text" placeholder="Enter Mobilenumber" path="mobileNumber" required="true" class="form-control"/>
																									<form:errors path="mobileNumber"/><br>
			<form:radiobuttons  path="role" items="${professionList}" required="true" />
																									<form:errors path="role"/><br><br>	
			<form:button  type="submit"  id="addButton"  formaction="/TariffManager/admin/user/add" class="btn btn-primary">ADD</form:button>
		</form:form>
	</div>
	
</body>
</html>