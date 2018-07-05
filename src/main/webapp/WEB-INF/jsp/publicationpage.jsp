<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<sec:authorize access="hasRole('ROLE_USER')">
			<sec:authentication property="principal.username" var="username"/>
	</sec:authorize>
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${publication.name}</title>
	<link href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/publication_page.css" />" rel="stylesheet" />
</head>
<body>
	<%@include file="include/nav.jsp" %>
	
	<div class="main">
		<h1>Издание: ${publication.name}</h1><br>
		Тема: ${publication.theme.name}<br>
		Рейтинг: ${publication.rating}<br>
		Тип: ${publication.type.name}
		<div>
			Описание: ${publication.description}
		</div>
		Рейтинг: ${publication.rating}<br>
		Цена: ${publication.price}
	

	<hr>
	
	<c:if test="${username == null}">
		<p><a href="#">Войдите</a> или <a href="#">зарегистрируйтесь</a>, чтобы оформить подписку или оставить отзыв</p>
	</c:if>
	
	<c:if test="${username != null}">
		<a href="${contextPath}/user/prepare_subscription/${publication.id}">Оформить подписку</a>
		<hr>
		<div>
			Ваш отзыв:
			<form:form modelAttribute="review" action="${publication.id}/add_review" method="post">
			
				<form:label path="header">Заголовок</form:label>
	        	<form:input path="header" /><br/>
	        	
	        	<form:label path="mark">Оценка</form:label>
	        	<form:input path="mark" /><br/>
	        	
	        	<form:label path="text" >Текст</form:label><br/>
	        	<form:input path="text" type="text" /><br/>
	        	
	        	<input type="submit" id="submit" value="Оставить отзыв">
			</form:form>			
		</div>
	</c:if>
	
	<hr>
	<div>
		<h2>Отзывы:</h2>
		<c:forEach items="${publication.reviews}" var="review">
				<p>${review.date} <b>${review.user.firstName}</b></p>
				<p>${review.header}</p>
				<p><b>Оценка</b> ${review.mark}</p>
				<p>${review.text}</p>
			</c:forEach>
	</div>
	</div>
</body>
</html>