<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>SmartPass</title>
<link href="/SmartPass/resource/css/bootstrap.css" rel="stylesheet">
<link href="/SmartPass/resource/css/SmartPass.css" rel="stylesheet">
<link href="/SmartPass/resource/css/style.css" rel="stylesheet">
<script src="/SmartPass/resource/js/jquery-2.1.0.min.js"></script>
<script src="/SmartPass/resource/js/jquery.decimalMask.js"></script>
</head>

<body>
	<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
		 	<div class="modal-content">
		    	<div class="modal-header">
		        	<h1 class="text-center">SmartPass Login</h1>
		      	</div>
		      	<div class="modal-body">
		          	<form method="post" action="/SmartPass/login" class="form col-md-12 center-block">
		            	<div class="form-group">
		              		<input type="text" name="user.login" class="form-control input-lg" placeholder="Login">
		            	</div>
		            	<div class="form-group">
		              		<input type="password" name="user.password.password" class="form-control input-lg" placeholder="Senha">
		            	</div>
		            	<div class="form-group">
		              		<button class="btn btn-primary btn-lg btn-block">Entrar</button>
		              		<span class="pull-right"><a href="/SmartPass/newuser">Registrar</a></span>
		            	</div>
		          	</form>
		      	</div>
		      	<div class="modal-footer">
		          	<div class="col-md-12">
          				${message}
          				<ul>
						<c:forEach items="${errors}" var="error">
			 				<li>${error.message}</li>
						</c:forEach>
						</ul>
		          	</div> 
		      	</div>
		  	</div>
	  	</div>
	</div>
	<div class="container navbar navbar-fixed-bottom">
		<hr>
		<footer>
			<h4>2014 - Sistemas de Informação - Segurança em Sistemas de Informação</h4>
		</footer>
    </div>
</body>
</html>
	

