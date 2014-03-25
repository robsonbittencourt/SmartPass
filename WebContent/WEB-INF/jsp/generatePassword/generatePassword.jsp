<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<div class="book-form">

		<legend>Gere uma senha forte randomicamente</legend>

		<form method="post" action="generatePassword" class="form-horizontal">
    		<label class="control-label" for="password_id">Tamanho</label>
			<div class="form-group">
    			<input type="text" name="length" class="form-control" id="password_id">
    			<button type="submit" class="btn btn-primary">Gerar</button>
  			</div>	
  			<label class="control-label" for="password_id">Senha Gerada</label>
  			<div class="form-group">
  				<input type="text" value="${randomPassword}" class="form-control" id="password_id">
  			</div>
  			
  		</form>	
  		
	</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
