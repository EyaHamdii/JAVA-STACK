<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
<button type="button" class="btn btn-danger"><a href="/logout">Logout</a></button>
   <h1>All Libraries 🏢</h1>
   <a href="/books">🏠 Home </a>
   <hr />
<%--    ${libsList } --%>
   <hr />
	<c:forEach items="${libsList }" var="lib">
		<ul>
			<li>${lib.name }</li>		
		</ul>
	</c:forEach>
   <hr />
   
	<form:form action="/libraries" method="post" modelAttribute="library">
		<div class="container">
			<form:errors style="color: red" path="*" />
		</div>
		<p class="form-group">
			<form:label path="name" for="usr">name</form:label>
			<form:input path="name" class="form-control" id="usr"/>
		</p>
		<p class="form-group">
			<form:label path="location" for="usr">location</form:label>
			<form:input path="location" class="form-control" id="usr"/>
		</p>


		<button class="btn btn-outline-primary">Submit</button>
	</form:form>
</div>
</body>
</html>