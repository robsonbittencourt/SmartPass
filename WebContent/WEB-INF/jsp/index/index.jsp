<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<div class="container">
		<h3>Regras para uma senha forte:</h3>
		<h4>
			1 - Tamanho da senha - acima de 8 caracteres</br></br>
			2 - Tipos de caracteres - no mínimo: 1 letra maiúscula, 1 letra minúscula, 1 dígito numérico, 1 sinal de pontuação ou símbolo especial</br></br>
			3 - Dicionário - não consta no dicionário</br></br>
			4 - Sequências e repetições alfanuméricas - contém sequência ou repetição de no máximo 2 caracteres em qualquer parte da senha</br></br>
			5 - Datas - não contém padrão de data numérico</br></br>
		</h4>
	</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />

