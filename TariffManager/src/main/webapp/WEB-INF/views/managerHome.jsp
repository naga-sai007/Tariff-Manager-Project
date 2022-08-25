<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Manager Page</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
<body style="background-color: steelblue">
	<div style="background-color: blue;">
		<h1 align="CENTER" style="display: inline-block; color: GhostWhite;">TARIFF MANAGER</h1>
		<tags:url var="logout" value="/"></tags:url>
		<a href ="<c:url value="/logout"/>" style="display: inline-flex; float: right; color: red; margin: 50px;">Logout</a>
	</div>
	
	<div class="container">
	<div class="row">
	<div class="col" style="float: left; padding: 25px;">
		<div class="container">
		<div class="row">
		<div class="col">
			
		<c:forEach var="expense" items="${expenseList}">
		<div class="card"  style="width:10rem" >
				<p>Bill Date : ${expense.datedOn}</p>
				<p>expense Id : ${expense.expenseId}</p>
				<p>Bill Number : ${expense.billNumber}</p>
				<p>Bill Cost : ${expense.billCost}</p>
				<p>Bill Desc : ${expense.remark}</p>
				<p>Bill Status : ${expense.status}</p>
				<p><form:form action="manager/expense/${expense.expenseId}" method="put"><button>Approve</button></form:form></p>
				<p><form:form action="manager/expense/${expense.expenseId}" method="get"><button>Decline</button></form:form></p>	
		</div>
		</c:forEach>
		
	</div>
		</div>		
		
		</div>
						
	</div>

	<div class="col" style="float: right;padding: 20px 1px 1px 1px;">
		<form:form modelAttribute="expense" class="form-control" method="post">ADD EXPENSES<br>
		<form:input data-date-format='yyyy-mm-dd' path="datedOn" required="true" class="form-control" type="date" /><form:errors path="datedOn"/><br>
		<form:input type="text" path="id" placeholder="Emp id" required="true" class="form-control" /><form:errors path="id"/><br>
		<form:input type="file" accepct="image" placeholder="upload Recipt" path="billImage" required="true" class="form-control" /><form:errors path="billImage"/><br>
		<form:input type="text" placeholder="Enter Bill Number" path="billNumber" required="true" class="form-control" /><form:errors path="billNumber"/><br>
		<form:input type="text" placeholder="Enter Amount" path="billCost" required="true" class="form-control" /><form:errors path="billCost"/><br>
		<form:input type="text" placeholder="Description" path="remark" required="true" class="form-control" /><form:errors path="remark"/><br>
		<h1><form:button type="submit" id="addButton" formaction="manager/expense/add" class="form-control">ADD EXPENSES</form:button></h1>
	</form:form>
	</div>
	</div>	
		</div>
</body>
</html>