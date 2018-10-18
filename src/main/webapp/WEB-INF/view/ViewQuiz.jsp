<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var = "title" value = "Ajout des questions" />

<!DOCTYPE html>
<html>
	<%@include file="/WEB-INF/layout/Head.jsp" %>
<body>

	<%@include file="/WEB-INF/layout/Navbar.jsp" %>

    <div class="container">
	
		<div class="row">
		
			<aside class="col-md-4">
				<ul class="list-group">
					<li class="list-group-item"><a href='<c:url value="/professor/view_quiz" />'>Voir le formulaire</a></li>
					<li class="list-group-item"><a href=''>Cloturer le formulaire</a></li>
				</ul>
			</aside>
			
			<div class="col-md-8">
				<h1>${ quiz.name }</h1>

				
				<c:forEach var="question" items="${ quiz.questions }" varStatus="statusQ">
					
					<h3>${ question.titleQuestion }</h3>
					<c:forEach var="response" items="${ question.responses }" varStatus="statusR">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value="Q${ statusQ.index }R${ statusR.index }" id="Q${ statusQ.index }R${ statusR.index }"/>
						<label class="Q${ statusQ.index }R${ statusR.index }">${ response.value }</label>
					</div>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
    </div>
    
    <%@include file="/WEB-INF/layout/Footer.jsp" %>
 
</body>
</html>