<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
	<link rel="stylesheet" type="text/css" href="/css/display.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>

<div class="container">
<a href="/logout">Logout</a>
<a href="/listing/view/all">Home</a>
<h1><c:out value="${seller.first_name}"/>'s Listing</h1>
<table>
  <tr>
    <th>Name</th>
    <th>Price</th> 
    <th>Description</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <tr>

  <c:forEach items="${seller.listings}" var="listing">
    <tr>
    <td><c:out value="${listing.name}"/></td>
    <td><c:out value="${listing.price}"/></td>
    <td><c:out value="${listing.description}"/></td>
    <td><a href="/listing/${listing.id}">Edit</a></td>
   	<td><form action="/listing/${listing.id}/delete" method ="post">
    		<input type="hidden" name="_method" value="delete">
    	<input class="btn" type="submit" value="Delete"></form></td> 
    <tr/>
 </c:forEach>
</table>
</div>
</body>
</html>