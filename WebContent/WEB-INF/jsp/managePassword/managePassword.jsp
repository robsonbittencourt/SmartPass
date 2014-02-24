<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>

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

		<legend>Gerenciamento de senhas</legend>

		<form method="post" action="managePassword/save" class="form-inline">
    		<div class="form-group has-feedback">
    			<label class="control-label" for="password_id">Sistema</label>
    			<input type="text" name="randomPassword" value="${randomPassword}" class="form-control" id="password_id" placeholder="Clique no botão">
	    		<div style="clear:both" />
	    		<label class="control-label" for="password_id">Usuário</label>
    			<input type="text" name="randomPassword" value="${randomPassword}" class="form-control" id="password_id" placeholder="Clique no botão">
    			<div style="clear:both" />
    			<label class="control-label" for="password_id">Senha</label>
    			<input type="text" name="randomPassword" value="${randomPassword}" class="form-control" id="password_id" placeholder="Clique no botão">
  			</div>	
  			<button type="submit" class="btn btn-primary">Salvar</button>
  		</form>	
  		
	</div>
		
</body>

</html>

