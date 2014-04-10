<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>SmartPass</title>
<link href="/SmartPass/resource/css/bootstrap.css" rel="stylesheet">
<link href="/SmartPass/resource/css/SmartPass.css" rel="stylesheet">
<script src="/SmartPass/resource/js/jquery-2.1.0.min.js"></script>
<script src="/SmartPass/resource/js/jquery.decimalMask.js"></script>
</head>

<body>
	<div class="jumbotron">
		<div class="container">
			<h1>SmartPass</h1>
		</div>

		<div class="container nav-menu">
			<nav class="navbar navbar-inverse">

				<div class="container-fluid">
					<div id="home" class="navbar-header">
						<a class="navbar-brand" href="/SmartPass/index">Home</a>
					</div>

					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li id="verify-strength"><a href="/SmartPass/passwordStrength">Verificar força</a></li>
							<li id="generate-password"><a href="/SmartPass/generatePassword">Gerar senha</a></li>
							<li id="manage-credential"><a href="#">Gerenciar credenciais</a></li>
							<li id="import-credential"><a href="#">Importar Credenciais</a></li>
							<li id="import-credential"><a href="#">Exportar Credenciais</a></li>
						</ul>	
					</div>
					
				</div>
				
			</nav>
		</div>
	</div>