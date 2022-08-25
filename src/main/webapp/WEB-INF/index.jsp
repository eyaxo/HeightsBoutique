<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seller Information</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>

<title>Listing</title>
<body>

<div class="container">
<a href="/logout">Logout</a>
<h1>Create Listing</h1>

<h3>Seller Information</h3>

<a href="/listing/view/all">Home</a>
<div class="body">
<form:form action="/seller" modelAttribute="seller" method="POST">
 		<form:label path="first_name">First Name:</form:label>
 		<form:errors path="first_name"/>
 		<form:input path="first_name"/>
 		<br>
 		<form:label path="last_name">Last Name:</form:label>
 		<form:errors path="last_name"/>
 		<form:input path="last_name"/>
 		<br>
 		<button class="btn">Submit</button>
    </form:form>
    </div>
</div> 
</body>
</html>