<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<div class="form">

		<legend>Gere uma senha forte randomicamente</legend>

		<form method="post" action="generatePassword" class="form-inline">
    		<label class="control-label" for="size_id">Tamanho</label>
			<div class="form-group">
    			<input type="text" size="42" name="length" class="form-control" id="size_id">
    			<button type="submit" class="btn btn-primary">Gerar</button>
  			</div>	
  		</form>	
  		</br>
  		<label class="control-label" for="password_id">Senha Gerada</label>
		<div>
			<textarea readonly rows="3" class="form-control" id="password_id">${randomPassword}</textarea>
		</div>
			
		
	</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

<script type="text/javascript">
	$(function() {
		$("#generate-password").addClass("active");
		$('#size_id').decimalMask('9999999');
	});
</script>
