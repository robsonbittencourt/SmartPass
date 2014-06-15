<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<div class="form-large">

		<legend>Gerenciamento de senhas</legend>

		<div class="floated-left">
			<form method="post" action="/SmartPass/manageCredential/save" class="form-horizontal" role="form">
				<input type="hidden" name="credential.id" value="${credential.id}" />
    			<div class="form-group">
    				<label class="col-sm-2 control-label" for="system_id">Sistema</label>
    				<div class="col-sm-10">
	    				<input type="text" name="credential.system" value="${credential.system}" class="form-control" id="system_id">
    				</div>
    			</div>
	    		
	    		<div class="form-group">
	    			<label class="col-sm-2 control-label" for="user_id">Usuário</label>
    				<div class="col-sm-10">
    					<input type="text" name="credential.login" value="${credential.login}" class="form-control" id="user_id">
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
      					<button type="submit" class="btn btn-primary">Salvar</button>
    				</div>
  				</div>
	  		</form>	
  		</div>
  		
  		<div class="floated-left scroll-table">
	  		<table class="table table-striped">
	  			<tr>
	      				<td>Sistema</td>
	      				<td>Usuário</td>
	      				<td>Senha</td>
	    		</tr>
	  			<c:forEach items="${credentialList}" var="credential">
	   				<tr>
	      				<td>${credential.system}</td>
	      				<td>${credential.login}</td>
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
	</div>
	
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

<script type="text/javascript">
	$(function() {
		$("#manage-credential").addClass("active");
	});
</script>
