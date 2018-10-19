<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var = "title" value = "Création d'un formulaire" />

<!DOCTYPE html>
<html>
	<%@include file="/WEB-INF/layout/Head.jsp" %>
<body>

	<%@include file="/WEB-INF/layout/Navbar.jsp" %>

	<div class="container">
	
		<div class="row">
		
			<aside class="col-md-4">
				<%@include file="/WEB-INF/element/QuizProfessor.jsp" %>
			</aside>
			
			<div class="col-md-8">
				<form method="post" action="">
					<div class="form-group">
						<label for="name">Intitulé du formulaire: </label>
						<input type="text" class="form-control" id="name" name="name" />
					</div>
					
					<div class="form-group">
						<label for="competence">Compétence: </label>
						<input type="text" class="form-control" id="competence" name="competence" /> 
					</div>
					
					<div class="form-group">
						<label for="dateDebut">Date de début: </label>
						<input type="date" class="form-control" id="dateDebut" name="dateDebut" /> 
					</div>
					
					<div class="form-group">
						<label for="dateFin">Date de fin: </label>
						<input type="date" class="form-control" id="dateFin" name="dateFin" /> 
					</div>
					
					<button class="btn btn-primary" type="submit">Continuer</button>
				</form>
			</div>
		</div>
	</div>
	
	<%@include file="/WEB-INF/layout/Footer.jsp" %>

</body>
</html>