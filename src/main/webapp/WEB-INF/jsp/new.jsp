<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Iniciar Sesión</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="home">TV Shows</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav  ml-auto">
	        <li class="nav-item">
	          <a class="nav-link" href="add">Add a show</a>
	        </li>
	        <li class="nav-item">
	  		   <a class="nav-link"href="<c:url value="/logout" />">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="container">
		<form:form action="add" modelAttribute="show" method="post">
			<h1>Create a new show </h1>
			<label>Show title:</label>
			<input type="text" id="title" name="showTitle"
							placeholder="ShowName" class="form-control" /> 
			<label>Network:</label>
			<input type="text" id="network" name="showNetwork"
							placeholder="Network" class="form-control" />
			<br>				 
			<div class="d-grid gap-2 col-4 mx-auto">
	  			<button class="btn btn-primary me-md-2" name="Submit"
						value="add" type="Submit">Create</button>
			</div>
			<a class = "btn btn-secondary" href = "admin" role = "button">GO BACK</a>
		</form:form>
	</div>
 	
</body>
