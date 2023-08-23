<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Song</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<a href="/dashboard" style="float:right">Dashboard</a>
<div class="d-flex mt-3 col-6">

<form:form action="/songs/new" method="post" modelAttribute="song">
<legend>Add Song</legend>

<div class="mb-3">

<form:label path="title" class="form-label">Title</form:label>
<form:errors path="title" class="text-danger"/>
<form:input path="title" type="text" class= "form-control"/>

<form:label path="artist" class="form-label">Artist</form:label>
<form:errors path="artist" class="text-danger"/>
<form:input path="artist" type="text" class="form-control" />

<form:label path="rating" class="form-label">Rating(1-10)</form:label>
<form:errors path="rating" class="text-danger"/>
<form:input path="rating" type="number" class="form-control" step=".5"/>

<form:label path="description" class="form-label">Description: </form:label>
<form:errors path="description" class="text-danger"/>
<form:textarea path="description" rows="3" class="form-control"></form:textarea><br />


<input type="submit" value="Add Song" class="btn btn-primary mb-3"/>
</div>
</form:form>
</div>
</div>
</body>
</html>

