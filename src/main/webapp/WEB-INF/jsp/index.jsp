<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Главная страница</title>
	<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet" />
</head>
<body>
	<%@include file="include/nav.jsp" %>
	
	<div class="publications">
	<div class="row">
                    <div class=col-md-1>
                        Индекс
                    </div>
                    <div class=col-md-5>
                        Название издания
                    </div>
                    <div class=col-md-2>
                        Периодичность
                    </div>
                    <div class=col-md-1>
                        Цена
                    </div>
                    <div class=col-md-1>
                        Рейтинг
                    </div>
                </div>
                <br>
                <hr>
                <br>
	<c:forEach items="${publication_group}" var="publication">
                <a href="<c:url value="publication/${publication.id}" />"><div class="row">
                    <div class=col-md-1>
                        ${publication.id}
                    </div>
                    <div class=col-md-5>
                        ${publication.name}
                    </div>
                    <div class=col-md-2>
                        ${publication.periodicity}
                    </div>
                    <div class=col-md-1>
                        ${publication.price}
                    </div>
                    <div class=col-md-1>
                        ${publication.rating}
                    </div>
                </div></a>
            <hr size="4">
    </c:forEach>
    </div>
</body>
</html>