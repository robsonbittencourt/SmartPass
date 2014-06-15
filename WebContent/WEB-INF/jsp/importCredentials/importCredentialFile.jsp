<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<div class="form-large">
		
		<form action="importCredential" method="post" enctype="multipart/form-data">
		    		
			<div class="floated-left" >
				<legend>Informe a chave pública do remetente</legend>
				<label class="control-label" for="public_key_id">Chave Pública (separadas por vírgula)</label>
				<div>
					<textarea name="senderPublicKey" rows="4" class="form-control" id="public_key_id"></textarea>
				</div>
			</div>
				
			<div class="floated-right">
				<legend>Selecione o arquivo de credenciais</legend>
				<input type="file" name="inputFile" />
		  		<button type="submit" class="btn btn-primary">Importar</button>
			</div>		
			
		</form>	
			
	</div>
	
	
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

<script type="text/javascript">
	$(function() {
		$("#import-credential").addClass("active");
	});
</script>
