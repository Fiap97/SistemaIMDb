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
	          <a class="nav-link active" aria-current="page" href="login">Login</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="register">Register</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="container">
		<div class="col-sm-6 p-5">
			<form:form action="register" modelAttribute="usuario" method="POST" >	
				<div align="center">
					<c:if test="${param.exito}">
						<p style="font-size: 20; color: #00b70a;">Se ha registrado exitosamente</p>
					</c:if>		
				</div>
				<div align="center">
					<c:if test="${param.error}">
						<p style="font-size: 20; color: #FF1C19;">Error al registrar el usuario</p>
					</c:if>		
				</div>
				<h3 class="form-signin-heading">Registro!</h3>
				<br /> 
				<label>Username:</label>
				<input type="text" id="username" name="username"
					placeholder="Username" class="form-control" /> 
				<br /> 
				<label>Email:</label>	
				<input type="text" placeholder="Email" id="email"
					name="email" class="form-control" /> 
				<br />
				<label>Password:</label>	
				<input type="password" placeholder="Password" id="password"
					name="pass" class="form-control" /> 
				<br />
				<label>Password Confirmation:</label>	
				<input type="password" placeholder="Password" id="password"
					name="passwordConfirmation" class="form-control" /> 
				<br />
				<label>ROLE:</label>	
				<input type="text" placeholder="Role" id="role"
					name="rol" class="form-control" /> 
				<br />
				<div align="center">
				</div>
				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="Submit" type="Submit" >Register!</button>
			</form:form>
		</div>
	</div>
</body>
</html>