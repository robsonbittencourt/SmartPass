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

		<legend>Verifique a força de sua senha</legend>

		<form method="post" action="passwordStrength" class="form-inline" enctype="multipart/form-data">
    		<label class="control-label" for="password_id">Senha</label>
			<div class="form-group has-feedback">
    			<input type="password" name="password.password" class="form-control" id="password_id" placeholder="${password.status}">
    			<span class="glyphicon form-control-feedback"></span>
  			</div>	
  			<button type="submit" class="btn btn-primary">Verificar</button>
  		</form>	
  		
	</div>
</body>


<script type="text/javascript">
	$(function() {
				
		<c:choose>
        	<c:when test="${password.status eq 'Senha forte'}">
        		$(".form-group").addClass("has-success");
        		$(".glyphicon").addClass("glyphicon-ok");
        	</c:when>
        	<c:when test="${password.status eq 'Senha média'}">
	        	$(".form-group").addClass("has-warning");
	    		$(".glyphicon").addClass("glyphicon-warning-sign");
        	</c:when>
        	<c:when test="${password.status eq 'Senha fraca'}">
        		$(".form-group").addClass("has-error");
    			$(".glyphicon").addClass("glyphicon-remove");
    		</c:when>
        </c:choose>
	});
</script>

</html>

