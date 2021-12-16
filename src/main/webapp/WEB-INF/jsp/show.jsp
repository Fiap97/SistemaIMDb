<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
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
		
		<h1>Title: <c:out value ="${show.showTitle}" /></h1>
		<h2>Network: <c:out value ="${show.showNetwork}" /></h2>	
		<h3>Users who rated this show</h3>	
		<table border="1" class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Rating</th>
				</tr>
			</thead>
			<tbody class="tbody-dark">
				<c:forEach items="${usuariosShow}" var="usuarioShow">
					<tr>
						<c:if test="${usuarioShow.show.id == show.id }">
							<td>  ${usuarioShow.usuario.email}</td>
							<td> ${usuarioShow.rating.rating}</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form action="mostrar" modelAttribute="usuarioShow" method="post">	
			<div style="display: none">
				<input type="text" id="show" name="show"
							placeholder="show" class="show" value="${show.id }" /> 	
				<input type="text" id="usuario" name="usuario"
					placeholder="usuario" class="form-control" /> 
			<br /> 										
			</div>
			<label>Leave a rating: </label>
			<input type="number" id="rating" name="rating"
							placeholder="rating" class="rating" value=3/> 
			<button class="btn btn-primary" name="Submit"
							value="mostrar" type="Submit" >Rate!</button>
			
		</form:form>			
		<br /> 
		<a href="edit?id=${show.getId()}"
							class="btn btn-info">Edit</a>
		<br /> 
		<br />
		<a class = "btn btn-secondary" href = "admin" role = "button">GO BACK</a>
	</div>
</body>
</html>