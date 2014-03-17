<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>

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

		<form method="post" action="/SmartPass/manageCredential/save" class="form-horizontal" role="form">
    			<div class="form-group">
    				<label class="col-sm-2 control-label" for="system_id">Sistema</label>
    				<div class="col-sm-10">
	    				<input type="text" name="credential.system" value="${credential.system}" class="form-control" id="system_id">
    				</div>
    			</div>
	    		
	    		<div class="form-group">
	    			<label class="col-sm-2 control-label" for="user_id">Usuário</label>
    				<div class="col-sm-10">
    					<input type="text" name="credential.user" value="${credential.user}" class="form-control" id="user_id">
    				</div>
    			</div>
    			
    			<div class="form-group">
   					<label class="col-sm-2 control-label" for="password_id">Senha</label>
    				<div class="col-sm-10">
	    				<input type="text" name="credential.password.password" value="${credential.password.password}" class="form-control" id="password_id">
    				</div>
    			</div>
  				<div class="form-group">
    				<div class="col-sm-offset-0 col-sm-5">
      					<button type="submit" class="btn btn-default">Salvar</button>
    				</div>
  				</div>
  		</form>	
  		
  		<table class="table table-striped">
  			<tr>
      				<td>Sistema</td>
      				<td>Usuário</td>
      				<td>Senha</td>
    		</tr>
  			<c:forEach items="${credentialList}" var="credential">
   				<tr>
      				<td>${credential.system}</td>
      				<td>${credential.user}</td>
      				<td>${credential.password.password}</td>
      				<td>
      					<a href="/SmartPass/manageCredential/edit/${credential.id}">
      						<button type="button" class="btn btn-info" >Editar</button>
      					</a>
      					<a href="/SmartPass/manageCredential/delete/${credential.id}">
      						<button type="button" class="btn btn-danger">Excluir</button>
      					</a>
      				</td>
    			</tr>
  			</c:forEach>
		</table>  				
	</div>
		
</body>

</html>

