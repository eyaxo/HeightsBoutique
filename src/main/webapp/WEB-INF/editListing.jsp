<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 


<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
	<link rel="stylesheet" type="text/css" href="/css/edit.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>

<div class="container">
<a href="/logout">Logout</a>
<h1>Edit Listing</h1>
			<a href="/listing/view/all">Home</a>
<form:form action="/listing/${listing.id}/edit" method="POST" modelAttribute="listing">

    <p>
        <form:label path="name">Listing</form:label>
        <form:errors path="name"/>
        <form:input path="name" value="${listing.name}"/>
    </p>
    <p>
        <form:label path="price">Price</form:label>
        <form:errors path="price"/>
        <form:input path="price" value="${listing.price}"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:input path="description" value="${listing.description}"/>
    </p>     
    <input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>