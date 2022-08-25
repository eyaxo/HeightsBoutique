<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Listings</title>
	<link rel="stylesheet" type="text/css" href="/css/view.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<div class="container">
<a href="/logout">Logout</a>
<h1>Heights Boutique Listings</h1>

<a href="/listing/new">Create Listing</a>
<a href="/seller">New Seller</a>
<br>
<table>
  <c:forEach items="${listings}" var="listing">
    <tr>
    <td><c:out value="${listing.seller.first_name}"/>'s Listing</td>
    <td><c:out value="${listing.name}"/></td>
    <td><c:out value="${listing.price}"/></td>
    <td><c:out value="${listing.description}"/></td>
   	<td><form action="/listing/${listing.id}/buy" method ="post">
    		<input type="hidden" name="_method" value="buy">
    	<input class="btn" type="submit" value="Buy"></form></td> 
    <tr/>
 </c:forEach>
 </table>
</div>
</body>
</html>