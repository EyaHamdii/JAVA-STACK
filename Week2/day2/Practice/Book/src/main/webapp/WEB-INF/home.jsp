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
    <title>Le JAVA</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<style>
.cont{
display: flex;
}
</style>
<div class="container">
   <h1>List of Books 📚</h1>
   <button  type="button" class="btn btn-outline-warning"><a href="/books/new">Create Book 📝</a></button> 
   <button  type="button" class="btn btn-outline-warning"><a href="/libraries">Create Library 📝</a></button>
   <button type="button" class="btn btn-danger"><a href="/logout">Logout</a></button>
   <hr />
   <table class="table">
   <thead>
   <tr>
   <th>Title</th>
   <th>Author</th>
   <th>Pages</th>
   <th>Release Date</th>
   <th>Library</th>
   <th>Actions</th>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${booksList }" var="oneBook" >
   <tr>
   <td>${oneBook.title}</td>
   <td>${oneBook.author.userName}</td>
   <td>${oneBook.pages}</td>
   <td>${oneBook.createdAt}</td>
   <td><a href="/libraries/${oneBook.library.id }">${oneBook.library.name }</a></td>
   <c:if test= "${user_id == oneBook.author.id}">
   <td>
   <div class="cont">
   	<button class="btn btn-outline-success"><a href="/books/${oneBook.id }/edit">Edit</a></button>
   	<form action="/books/${oneBook.id }" method="post">
   	<input  type="hidden" name="_method" value="delete">
    <input type="submit" class="btn btn-outline-danger" value="Delete">
   	</form></div>
   </td>
   </c:if>
   </tr>
   </c:forEach>
   </tbody>
   </table>
</div>
</body>
</html>