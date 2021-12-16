<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Iniciar Sesión</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
 	<!--<h1>Bienvenido Admin</h1>  -->
 	
 	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">TV Shows</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav  ml-auto">
	        <li class="nav-item">
	          <a class="nav-link" href="addUsers">Add a show</a>
	        </li>
	        <li class="nav-item">
	           <a class="nav-link"href="<c:url value="/logout" />">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="container">
		<h1>Welcome,<c:out value ="${usuario}" /></h1>
		<table border="1" class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Show</th>
					<th scope="col">Network</th>
					<th scope="col"></th>	
				</tr>
			</thead>
			<tbody class="tbody-dark">
				<c:forEach items="${shows}" var="show">
					<tr>
						<td>${show.showTitle}</td>
						<td>${show.showNetwork}</td>
						<td><a href="mostrarUsers?id=${show.getId()}"
							class="btn btn-primary btn-sm">Ver</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</body>
