<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

	<c:set var="contextPath" value="${pageContext.request.contextPath}" /> 

	<sec:authorize access="hasRole('ROLE_USER')">
		<sec:authentication property="principal.username" var="username"/>
	</sec:authorize>

	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
      <a class="navbar-brand mr-auto mr-lg-0" href="${contextPath}">Издания</a>
      <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          
        </ul>

        
        <ul class="navbar-nav navbar-right">
        	<c:if test="${username != null}">
        		<li class="nav-item active">
            	<a class="nav-link" href="${contextPath}/user/profile">${username}</a>
	         	</li>
	         	<li class="nav-item active">
	            	<a class="nav-link" href="<c:url value='${contextPath}/j_spring_security_logout'/>">Выход</a>
	         	</li>
        	</c:if>
        	<c:if test="${username == null}">
	        	<li class="nav-item active">
	            	<a class="nav-link" href="${contextPath}/login">Вход</a>
	         	</li>
	         	<li class="nav-item active">
	            	<a class="nav-link" href="${contextPath}/registration">Регистрация</a>
	         	</li>
         	</c:if>
        </ul>
      </div>
    </nav>

