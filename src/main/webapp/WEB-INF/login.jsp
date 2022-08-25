<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
	<link rel="stylesheet" type="text/css" href="/css/login.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<div class="container">
<a href="/logout">Logout</a>
<h1>Create User</h1>

<form:form class="body" action="/register" method="POST" modelAttribute="newUser">
    <p>
        <form:label path="first_name">First Name:</form:label>
        <form:errors path="first_name"/>
        <form:input type="text" path="first_name"/>
    </p>
        <p>
        <form:label path="last_name">Last Name:</form:label>
        <form:errors path="last_name"/>
        <form:input type="text" path="last_name"/>
    </p>
        <p>
        <form:label path="email">Email:</form:label>
        <form:errors path="email"/>
        <form:input type="email" path="email"/>
    </p>
        <p>
        <form:label path="password">Password:</form:label>
        <form:errors path="password"/>     
        <form:input type="password" path="password"/>
    </p> 
        <p>
        <form:label path="confirm">Confirm Password:</form:label>
        <form:errors path="confirm"/>     
        <form:input type="password" path="confirm"/>
    </p>       

    <input type="submit" value="Register"/>
</form:form>

	<h1>Login</h1>
	<form:form class ="bodytwo" action="/login" method="POST" modelAttribute="newLogin">
	        <p>
        <form:label path="email">Email:</form:label>
        <form:errors path="email"/>
        <form:input type="email" path="email"/>
    </p>
        <p>
        <form:label path="password">Password:</form:label>
        <form:errors path="password"/>     
        <form:input  type="password" path="password"/>
    </p>      
    <input type="submit" value="Login"/>
</form:form>
</div>

</body>
</html>