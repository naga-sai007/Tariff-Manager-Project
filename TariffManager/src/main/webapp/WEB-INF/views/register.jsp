<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<header style="background-color: blue; height: 4rem">
	<h3 style="color: white">Tarrif Manager</h3>
</header>
<body>

	<h1 style="size: 6; color: blue; text-align: center;">Sign Up</h1>

	<form:form id="regForm" modelAttribute="user" action="registerProcess"	method="post">
		<table align="center">
			<tr>
				<td><form:input path="email" name="email" id="email" placeholder="Enter email" required="true" />
				 																			<form:errors path="email"></form:errors></td>
			</tr>
			<tr>
				<td><form:input path="username" name="username" id="username" placeholder="Enter Username" required="true" /> 
																							<form:errors path="username"></form:errors></td>
			</tr>
			<tr>
				<td><form:input path="mobileNumber" name="phone" 	placeholder="Enter MobileNumber" required="true" />
				 																		<form:errors path="mobileNumber"></form:errors></td>
			</tr>
			<tr>
				<td><form:password path="password" name="password" id="password" placeholder="Password" required="true" /> 
																						<form:errors path="password"></form:errors></td>
			</tr>
			<tr>
				<td><form:button id="register" name="register">Submit</form:button></td>
			</tr>
			<tr></tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>