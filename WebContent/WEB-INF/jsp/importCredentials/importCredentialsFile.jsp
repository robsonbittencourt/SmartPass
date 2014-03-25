<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<div class="book-form">

		<legend>Importar arquivo de credenciais</legend>

		<form method="post" action="importCredentials" class="form-inline" enctype="multipart/form-data">
    		<input type="file" name="inputFile" />
  			<button type="submit" class="btn btn-primary">Importar</button>
  		</form>	
  		
	</div>
	
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

