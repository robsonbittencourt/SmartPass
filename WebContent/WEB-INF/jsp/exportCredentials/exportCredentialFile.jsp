<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<div class="form">

		<legend>Exportar arquivo de credenciais</legend>

		<div class="floated scroll-table">
	  		<table class="table table-striped">
	  			<tr>
	  				<td>Exportar</td>
	      			<td>Sistema</td>
	      			<td>Usuário</td>
	      			<td>Senha</td>
	    		</tr>
	  			<c:forEach items="${credentialList}" var="credential">
	   				<tr>
	   					<td><input type="checkbox" name="credentialCheck" data-credentialId="${credential.id}"/></td>
	      				<td>${credential.system}</td>
	      				<td>${credential.login}</td>
	      				<td>${credential.password.password}</td>
	    			</tr>
	  			</c:forEach>
			</table>  	
			<form id="form_credentials" action="/SmartPass/exportCredential/export" method="post">
				<input type="hidden" name="credentialsIds" id="credentialsIds" />
			</form>
			<button id="save_button" type="submit" class="btn btn-default">Salvar</button>
		</div>				
  		
	</div>
	
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

<script type="text/javascript">
	$(function() {
		$("#export-credential").addClass("active");

		$('#save_button').bind('click', function (){
        	var credentials = [];
			$('input[name=credentialCheck]:checked').each(function (){
				credentials.push($(this).attr('data-credentialId'));
			});
	                
			$('#form_credentials [name="credentialsIds"]').val(credentials.join(','));
			$('#form_credentials').trigger('submit');
		});
  	});
</script>
