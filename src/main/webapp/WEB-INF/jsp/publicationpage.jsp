<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		Издание: ${publication.name}<br>
		Тема: ${publication.theme.name}<br>
		Тип: ${publication.type.name}
		<div>
			Описание: ${publication.description}
		</div>
		Рейтинг: ${publication.rating}<br>
		Цена: ${publication.price}
	</div>

	<hr>
	
	<c:if test="${current_user == null}">
		<p><a href="#">Войдите</a> или <a href="#">зарегистрируйтесь</a>, чтобы оформить подписку или оставить отзыв</p>
	</c:if>
	
	<c:if test="${current_user != null}">
		<a href="#">Оформить подписку</a>
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
		<p>Отзывы:</p>
		<c:forEach items="${publication.reviews}" var="review">
				<p>${review.date} <b>${review.user.firstName}</b></p>
				<p>${review.header}</p>
				<p><b>Оценка</b> ${review.mark}</p>
				<p>${review.text}</p>
			</c:forEach>
	</div>
</body>
</html>