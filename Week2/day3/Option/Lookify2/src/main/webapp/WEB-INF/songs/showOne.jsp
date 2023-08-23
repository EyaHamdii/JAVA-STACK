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
<title>Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="col-lg-6 m-5">
<a href="/dashboard">Dashboard</a>
<div class="mt-5">
<table class="table table-bordered">
    <tr>
        <td>Title</td>
        <td><c:out value="${oneSong.title}"></c:out></td>
    </tr>
      <tr>
        <td>Artist</td>
        <td><c:out value="${oneSong.artist}"></c:out></td>
    </tr>
      <tr>
        <td>Rating</td>
        <td><c:out value="${oneSong.rating}"></c:out></td>
    </tr>
      <tr>
        <td>Description</td>
        <td><c:out value="${oneSong.description}"></c:out></td>
    </tr>
    

</table>
</div>
</div>
</body>
</html>

