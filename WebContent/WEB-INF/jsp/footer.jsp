<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<div class="container navbar navbar-fixed-bottom">
			<ul>
			<c:forEach items="${errors}" var="error">
			  <li>${error.message}</li>
			</c:forEach>
			</ul>
			<hr>
			<footer>
				<h4>2014 - Sistemas de Informa��o - Seguran�a em Sistemas de Informa��o</h4>
			</footer>
    	</div>
	</body>
</html>
