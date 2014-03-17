<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>SmartPass</title>
<link href="/SmartPass/resource/css/bootstrap.css" rel="stylesheet">
<link href="/SmartPass/resource/css/SmartPass.css" rel="stylesheet">
<script src="/SmartPass/resource/js/jquery-2.1.0.min.js"></script>
</head>

<body>
	<div class="book-form">

		<legend>Importar arquivo de credenciais</legend>

		<form method="post" action="importCredentials" class="form-inline" enctype="multipart/form-data">
    		<input type="file" name="inputFile" />
  			<button type="submit" class="btn btn-primary">Importar</button>
  		</form>	
  		
	</div>
</body>

</html>

