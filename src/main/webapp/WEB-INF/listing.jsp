<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listing Details</title>
	<link rel="stylesheet" type="text/css" href="/css/listing.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<div class="container">

		<a href="/logout">Logout</a>
<h1>Create Listing</h1>
<h3>Listing Details</h3>


			<a href="/listing/view/all">Home</a>
			<a href="/seller">New Seller</a>

<div class="body">
<form:form action="/listing/create" modelAttribute="listing" method="POST">
	<form:label path="seller"> Seller Information:</form:label>
		<br>
 		<form:errors path="seller"/>
		<form:select path="seller">
 			<c:forEach items="${sellers}" var="seller"> 
 				<option value="${seller.id}">${seller.first_name}</option>
 			</c:forEach>
 		</form:select>   
 		<br>
 		<form:label path="name"> Name:</form:label>
 		<form:errors path="name"/>
 		<form:input path="name"/>
 		<br>
 		<form:label path="price"> Price:</form:label>
 		<form:errors path="price"/>
 		<form:input path="price"/>
 		<br>
  		<form:label path="description">Description:</form:label>
 		<form:errors path="description"/>
 		<form:input path="description"/>
 		<br>
 		<button class="btn">Create Listing</button>
    </form:form> 
  </div>  
</div>
</body>
</html>