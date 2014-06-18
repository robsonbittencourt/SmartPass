<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	
	<div class="form-large">
		
		<form action="backup/backupCredentials" method="post">
			
			<div class="floated-left" >
				<legend>Fazer backup de todas as senhas</legend>
				<button type="submit" class="btn btn-primary">Backup</button>
			</div>
			
		</form>	
		
		<form action="backup/restoreCredentials" method="post" enctype="multipart/form-data">
			
			<div class="floated-right">
				<legend>Selecione o arquivo a ser restaurado</legend>
				<div style="float:left">
					<input type="file" name="inputFile" />
	  			</div>
	  			<div style="float:right">
	  				<button type="submit" class="btn btn-primary">Restaurar</button>
	  			</div>
			</div>	
				
		</form>	
		
	</div>
	
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

<script type="text/javascript">
	$(function() {
		$("#backup").addClass("active");
  	});
</script>
