<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App</title>
<!-- linking CSS and JS files -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/dashboard">Lookify</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse d-flex"
				id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="/songs/new">Add Song</a></li>
					<li class="nav-item"><a class="nav-link" href="/search/topTen">Top
							Songs</a></li>
				</ul>
				<form class="d-flex" action="/search">
					<input class="form-control me-2" name="artist" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-light me-3 search-btn" type="submit">Search
						Artist</button>
				</form>
			</div>
		</div>
	</nav>
	<table class="table align-middle  mb-0 bg-white">
		<thead class="bg-light">
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="s" items="${songs}">
			<tr>
				<td class="col-sm-3">
					<div class="d-flex align-items-center">
						<img
							src="https://seeklogo.com/images/Y/youtube-music-logo-50422973B2-seeklogo.com.png"
							alt="" style="width: 45px; height: 45px" class="rounded-circle" />
						<div class="ms-3">
							<p class="fw-bold mb-1"><a href="/songs/${s.id}">${s.title}</a></p>
							<p class="text-muted mb-0 myDIV">${s.artist}</p>
							<div class="hide">${s.description}</div>
						</div>
					</div>
				</td>

				<td class="col-sm-3">${s.rating}</td>
				<td class="col-sm-3">NEW</td>
				<td class="col-sm-3">
				<form action="/songs/${s.id}/delete" method="post" style="Display:inline-block">
				<input type="hidden" name="_method" value="delete">
				 <input type="submit" value="Delete" class="btn btn-outline-danger">
			</form></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

