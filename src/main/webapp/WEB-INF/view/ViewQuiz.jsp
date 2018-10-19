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
				<%@include file="/WEB-INF/element/QuizProfessor.jsp" %>
			</aside>
			
			<div class="col-md-8">
				<h1>${ quiz.name }</h1>

				<c:forEach var="question" items="${ quiz.questions }">
					
					<h3>${ question.titleQuestion }</h3>
					<c:forEach var="response" items="${ question.responses }">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value="Q${ question.id }-R${ response.id }" id="Q${ question.id }-R${ response.id }"/>
						<label class="Q${ question.id }-R${ response.id }">${ response.value }</label>
					</div>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
    </div>
    
    <%@include file="/WEB-INF/layout/Footer.jsp" %>
 
</body>
</html>