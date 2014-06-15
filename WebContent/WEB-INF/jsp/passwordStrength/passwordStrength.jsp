<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<div class="form">

		<legend>Verifique a força de sua senha</legend>

		<form method="post" action="passwordStrength" class="form-inline">
    		<label class="control-label" for="password_id">Senha</label>
			<div class="form-group has-feedback">
    			<input type="password" size="38" name="password.password" class="form-control" id="password_id" placeholder="${message}">
    			<span class="glyphicon form-control-feedback"></span>
  			</div>	
  			<button type="submit" class="btn btn-primary">Verificar</button>
  			
  			<div class="box">
  				Sua senha é:</br>
  				${password.weakWeight}% fraca</br>
	  			${password.mediumWeight}% média</br>
	  			${password.strongWeight}% forte</br>
			</div>
  		</form>	
  	  		
	</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

<script type="text/javascript">
	$(function() {
		$("#verify-strength").addClass("active");
				
		<c:choose>
        	<c:when test="${message eq 'Senha forte'}">
        		$(".form-group").addClass("has-success");
        		$(".glyphicon").addClass("glyphicon-ok");
        	</c:when>
        	<c:when test="${message eq 'Senha média'}">
	        	$(".form-group").addClass("has-warning");
	    		$(".glyphicon").addClass("glyphicon-warning-sign");
        	</c:when>
        	<c:when test="${message eq 'Senha fraca'}">
        		$(".form-group").addClass("has-error");
    			$(".glyphicon").addClass("glyphicon-remove");
    		</c:when>
        </c:choose>
	});
	
</script>



