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
<title>Top 10 Songs</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container ">
<a href="/dashboard">Dashboard</a>
<h1 class="text-danger mt-3">Top 10 BillBoard</h1>

<table class="table table-striped border mt-3">
  <thead>
    <tr>
      <th scope="col">Title</th>
      <th scope="col">Artist</th>
       <th scope="col">Rating</th>
        <th scope="col">Description</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var ="item" items="${topTen}">
  <tr>
      <td><c:out value="${item.title}"></c:out></td>
      <td><c:out value="${item.artist}"></c:out></td>
      <td><c:out value="${item.rating}"></c:out></td>
      <td><c:out value="${item.description}"></c:out></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</div>
</body>
</html>

