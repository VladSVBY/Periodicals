<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Page</title>
		<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" /> 
		<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
	</head>
<body>
	<%@include file="include/nav.jsp" %>
	<form action="<c:url value="/j_spring_security_check" />" id="login" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <h1>Log In</h1>
	    <fieldset id="inputs">
	        <input id="username" name="j_login" type="text" placeholder="Username" required autofocus />   
	        <input  id="password" name="j_password" type="password" placeholder="Password" required />
	    </fieldset>
	    <span><c:out value="${error_msg}" /></span>
	    <fieldset id="actions">
	        <input type="submit" id="submit" value="Log in">
	        <input id="remember" name="_spring_security_remember_me" type="checkbox" />
	        <label for="remember">Запомнить</label>
	        <a href="registration">Register</a>
	    </fieldset>
	</form>
</body>
</html>