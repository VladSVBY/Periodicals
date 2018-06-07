<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello
	<table border="1" >
		<tr>
			<th>Название издания</th>
			<th>Периодичьность</th>
			<th>Рейтинг</th>
			<th>Цена</th>
		</tr>
		<tbody>
			<c:forEach items="${publication_group}" var="publication">
				<tr>
					<td><a href="publication/${publication.id}">${publication.name}</a></td>
					<td>${publication.periodicity}</td>
					<td>${publication.rating}</td>
					<td>${publication.price}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>