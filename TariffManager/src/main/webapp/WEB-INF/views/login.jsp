<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<header style="background-color:blue;height:4rem"><h3 style="color:white">Tarrif Manager</h3></header>
<body style="background-color:white">
	<center><font size="6" color="blue">Login</font></center>
	
	  <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
         
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                
         </div>
    </c:if>
	
	<form:form id="loginForm" modelAttribute="login" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
		<table align="center">
			<tr>
				<td><form:input path="email" name="email" id="email" placeholder="Enter Email" required="true" /></td>
			</tr>
			<tr>
				<td><form:password path="password" name="password" id="password" placeholder="Enter Password" required="true" /></td>
			</tr>
			<tr>
				<td><p>New User?<a href="signup">Sign Up</a></td>
			</tr>
			<tr>
				<td align="left"><form:button id="login" name="login">Login</form:button></td>
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>

</body>
</html>