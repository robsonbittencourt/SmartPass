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

		<legend>Gere uma senha forte randomicamente</legend>

		<form method="post" action="generatePassword" class="form-horizontal">
    		<label class="control-label" for="password_id">Tamanho</label>
			<div class="form-group">
    			<input type="text" name="length" class="form-control" id="password_id">
    			<button type="submit" class="btn btn-primary">Gerar</button>
  			</div>	
  			<label class="control-label" for="password_id">Senha Gerada</label>
  			<div class="form-group">
  				<input type="text" value="${randomPassword}" class="form-control" id="password_id">
  			</div>
  			
  		</form>	
  		
	</div>
</body>

</html>

