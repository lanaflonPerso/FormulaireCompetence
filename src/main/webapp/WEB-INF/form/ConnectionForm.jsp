<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--<c:set var = "title" value = "Page d'inscription" />

<c:choose>
	<c:when test="${ isProfessor }">
		<c:set var = "action" value = "/public/connection/professor" />
	</c:when>
	<c:otherwise>
		<c:set var = "action" value = "/public/connection" />
	</c:otherwise>
</c:choose>-->

<!DOCTYPE html>
<html>
	<%@include file="/WEB-INF/layout/Head.jsp" %>
<body>

	<%@include file="/WEB-INF/layout/Navbar.jsp" %>

	<div class="container">
	
		<div class="row">
			<aside class="col-md-4">
			
			</aside>
			<div class="col-md-8">
				<form method="post" action='<c:url value="${ action }" />'>
					<div class="form-group">
						<label for="email">Email: </label>
						<input type="email" class="form-control" id="email" name="email" value="${ student.email }"/> 
						<small id="emailHelp" class="form-text text-muted text-danger">${ ctrl.msgConnection }</small>
					</div>
					
					<div class="form-group">
						<label for="password">Password: </label>
						<input type="password" class="form-control" id="password" name="password" /> 
					</div>
					
					<button class="btn btn-primary" type="submit">Connexion</button>
				</form>
			</div>
		</div>
	</div>
	
	<%@include file="/WEB-INF/layout/Footer.jsp" %>

</body>
</html>