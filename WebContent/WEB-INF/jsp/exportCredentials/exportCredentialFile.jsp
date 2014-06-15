<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	
	<div class="form-large">
		
		<form id="form_credentials" action="/SmartPass/exportCredential/export" method="post">
			
			<div class="floated-left" >
				<legend>Informe a chave pública do destinatário</legend>
				<label class="control-label" for="public_key_id">Chave Pública (separadas por vírgula)</label>
				<div>
					<textarea name="destinyPublicKey" rows="4" class="form-control" id="password_id"></textarea>
				</div>
			</div>
				
			<div class="floated-left scroll-table">
				<legend>
					Selecione as credenciais
					<button id="save_button" style="float:right" type="submit" class="btn btn-primary">Exportar</button>		
	  			</legend>
				
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
				
				<input type="hidden" name="credentialsIds" id="credentialsIds" />
			</div>		
		</form>
			
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
