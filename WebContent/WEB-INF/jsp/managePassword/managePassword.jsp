<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
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

		<form method="post" action="managePassword/save" class="form-horizontal" role="form">
    			<div class="form-group">
    				<label class="col-sm-2 control-label" for="password_id">Sistema</label>
    				<div class="col-sm-10">
	    				<input type="text" name="randomPassword" value="${randomPassword}" class="form-control" id="password_id">
    				</div>
    			</div>
	    		
	    		<div class="form-group">
	    			<label class="col-sm-2 control-label" for="password_id">Usuário</label>
    				<div class="col-sm-10">
    					<input type="text" name="randomPassword" value="${randomPassword}" class="form-control" id="password_id">
    				</div>
    			</div>
    			
    			<div class="form-group">
   					<label class="col-sm-2 control-label" for="password_id">Senha</label>
    				<div class="col-sm-10">
	    				<input type="text" name="randomPassword" value="${randomPassword}" class="form-control" id="password_id">
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
  			<c:forEach items="${list}" var="item">
   				<tr>
      				<td>${item}</td>
      				<td>${item}</td>
      				<td>${item}</td>
      				<td>
      					<button type="button" class="btn btn-info">Editar</button>
      					<button type="button" class="btn btn-danger">Excluir</button>
      				</td>
      				
    			</tr>
  			</c:forEach>
		</table>  				
	</div>
		
</body>

</html>

