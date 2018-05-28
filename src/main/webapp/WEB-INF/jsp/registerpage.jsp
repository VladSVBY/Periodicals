<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<meta http-equiv="Content-Type" content="text/html; UTF-8">
		<title>SignUp Page</title>
</head>

<body>
	
	<script type="text/javascript">
		function checkLogin(){
			$.ajax({
				url: '${contextPath}/registration/check_login',
				data: ({login: $('#login').val()}),
				success: function(data){
					$('#login_msg').html(data);
				}
			});
		}
	</script>

	<form:form modelAttribute="user" action="${contextPath}/registration/register_user" method="post">
	    <h1>Sign Up</h1>
	    <fieldset id="inputs">
	    	<form:label path="login">Login</form:label><br/>
	        <form:input path="login" onblur="checkLogin()" /><span id="login_msg"></span><br/>
	        
	        <form:label path="password">Password</form:label><br/>   
	        <form:input path="password" /><br/>
	        
	        <form:label path="login">First Name</form:label><br/>
	        <form:input path="firstName" /><br/>
	        
	        <form:label path="login">Last Name</form:label><br/>
	        <form:input path="lastName" /><br/>
	        
	        <form:label path="login">Email</form:label><br/>
	        <form:input path="email" />
	        
	        <div><c:out value="${fail_msg}"></c:out></div>
	    </fieldset><br/>
	    <fieldset id="actions">
	        <input type="submit" id="submit" value="Sign Up">
	    </fieldset>
	</form:form>
</body>
</html>