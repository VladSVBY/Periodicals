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
	</head>
<body>
	<form:form modelAttribute="user" action="${contextPath}/login/login_user" id="login">
	    <h1>Log In</h1>
	    <fieldset id="inputs">
	        <form:input path="login" id="username" type="text" placeholder="Username" />   
	        <form:input path="password" id="password" type="password" placeholder="Password" />
	    </fieldset>
	    <span><c:out value="${fail_msg}" /></span>
	    <fieldset id="actions">
	        <input type="submit" id="submit" value="Log in">
	        <a href="registration">Register</a>
	    </fieldset>
	</form:form>
</body>
</html>