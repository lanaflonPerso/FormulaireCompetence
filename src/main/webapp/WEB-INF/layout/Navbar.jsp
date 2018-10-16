<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<a class="navbar-brand" href="#">Navbar</a>

	<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item">
				<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Link</a>
			</li>
			<li class="nav-item">
				<a class="nav-link disabled" href="#">Disabled</a>
			</li>
		</ul>
		
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0 float-right">
			<c:choose>
				<c:when test="${ sessionScope.user != null }">
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/public/deconnection" />" >Déconnection</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/public/connection" />" >Connexion</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/public/inscription" />" >Inscription</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>