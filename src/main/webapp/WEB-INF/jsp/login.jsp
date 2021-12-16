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
	    <a class="navbar-brand" href="#">TV Shows</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Login</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="register">Register</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 p-5">
				<form action="login" method="post" class="form-signin">
					<h3 class="form-signin-heading">Credenciales</h3>
					<br /> 
					<input type="text" id="email" name="email"
						placeholder="Email" class="form-control" /> 
						<br /> 
					<input
						type="password" placeholder="Password" id="password"
						name="password" class="form-control" /> 
					<br />
					<div align="center">
					<c:if test="${param.error}">
						<p style="font-size: 20; color: #FF1C19;">Verifica las
							credenciales.</p>
					</c:if>		
					</div>
					<button class="btn btn-lg btn-primary btn-block" name="Submit"
						value="Login" type="Submit" >Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>