<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Оформление подписки</title>
	<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/publication_page.css" />" rel="stylesheet" />
</head>
<body>
	<%@include file="../include/nav.jsp" %>
	
	<div class="main">
		<h2>Оформление подписки на издание : ${publication.name }</h2>
		<form method="post" action="">
			С месяца: <input name="start_date" type="month" /><br>
			По месяц:<input name="end_date" type="month" /><br>
			<input type="submit" value="Оформить"/>
	</div>
</body>
</html>