 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="tags"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en" xml:lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Page</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	</head>
<body>

	<div style="background-color:blue;">
			<h1 text-align="left" style="display:inline-block;color:white;">TariffManager</h1>
			<tags:url  var="logout" value="/"></tags:url>
			<a href ="<c:url value="/logout"/>"  style="display:inline-flex;float:right;color:white ;margin:25px;" >Logout</a>	
			<a href="home"  style="display:inline-flex;float:right;color:white;margin:25px;">Home</a>	
	</div>

	<div style="align:center;padding:50px;color: blue;">
		<form:form modelAttribute="user" >
				<h1 class="text-control">Edit Details of  ${user.id}</h1><br>
			<form:hidden  path="id" value="${user.id}"/> 
				<p class="text-control">	Enter name to update </p>	
			<form:input type="text"  path="username" class="form-control" required="true" /><br>
				<p class="text-control"> Enter email to update	</p>
			<form:input type="text"  path="email" class="form-control" required="true"/><br>
				<p class="text-control"> Enter mobileNumber to update</p>
			<form:input type="text"  path="mobileNumber" class="form-control" required="true"/><br>
			<form:radiobuttons  path="role" items="${professionList}" required="true" /><br>
				<tags:url value="edit" var="editurl" /><br>
		   <form:button  type="submit"  id="addButton"  formaction="${editurl}" method="post" class="button-control">EDIT USER</form:button>
		</form:form>
	</div>

</body>
</html>