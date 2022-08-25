<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Expense Page</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
<body style="background-color: white">
	<div style="background-color: blue;">
		<h1 align="CENTER" style="display: inline-block; color: GhostWhite;">TARIFF MANAGER</h1>
		<tags:url var="logout" value="/"></tags:url>
		<a href ="<c:url value="/logout"/>" style="display: inline-flex; float: right; color: red; margin: 30px;">Logout</a>
		<a href="${home}" style="display: inline-flex; float: right; color: red; margin: 30px;">Home</a>
	</div>
	<div style="float: left; padding: 25px;">
		<table class="table">		
			<tr>
				<th>Date</th>
				<th>Expense id</th>
				<th>RECIPT NO</th>
				<th>AMOUNT</th>
				<th>Remark</th>
				<th>Status</th>
			</tr>			
		<c:forEach var="expense" items="${expenseList}">
			<tr>
				<td>${expense.datedOn}</td>
				<td>${expense.expenseId}</td>
				<td>${expense.billNumber}</td>
				<td>${expense.billCost}</td>
				<td>${expense.remark}</td>
				<td>${expense.status}</td>
			 <%--   <td><form:form action="expense/${expense.expenseId}" method="put"><button>Edit</button></form:form></td>
				<td><form:form action="employee/expense/${expense.expenseId}" method="get"><button onclick="if(!(confirm('Do you want to delete the user'))) return false">Delete</button></form:form></td> --%>
			</tr>	
		</c:forEach>
		</table>				
	</div>

	<div style="float: right;padding: 20px 1px 1px 1px;">
		<form:form modelAttribute="expense" class="form-control" method="post">ADD EXPENSES<br>
		<form:input data-date-format='yyyy-mm-dd' path="datedOn" required="true" class="form-control" type="date" /><form:errors path="datedOn"/><br>
	    <form:hidden value="${id}" path="id" required="true" class="form-control" /><br>
		<form:input type="file" accepct="image" placeholder="upload Recipt" path="billImage" required="true" class="form-control" /><form:errors path="billImage"/><br>
		<form:input type="text" placeholder="Enter Bill Number" path="billNumber"  class="form-control" required="true" /><form:errors path="billNumber" /><form:errors path="billNumber"/><br>
		<form:input type="text" placeholder="Enter Amount" path="billCost" required="true" class="form-control" /><form:errors path="billCost"/><br>
		<form:input type="text" placeholder="Description" path="remark" required="true" class="form-control" /><form:errors path="remark"/><br>
		<h1><form:button type="submit" id="addButton" formaction="/TariffManager/employee/expense/add" class="form-control">ADD EXPENSES</form:button></h1>
	</form:form>
	</div>
</body>
</html>