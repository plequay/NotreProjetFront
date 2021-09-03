<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>PageJeu</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

<style>
.box {
	border: solid black;
	background-color: white;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	margin: 2px
}

.form-select {
	display: inline-block;
}
</style>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img src="logo.png" alt=""
					width="30" height="24">
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Dropdown </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link disabled" href="#"
							tabindex="-1" aria-disabled="true">Disabled</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
	</header>

	<main>

		<div class="container">
			<div class="row" style="-bs-gutter-y: 20px;">

				<div class="col-6"
					style="padding-top: calc(var(- -bs-gutter-x)* .5); padding-bottom: calc(var(- -bs-gutter-x)* .5);">
					Pseudo du joueur1
					<%-- 					${session.compte.surname} --%>
					<table class="table table-striped">
						<tr>
							<th><img height="40px" width="40px"
								src="https://www.bois-brazeco.com/content/uploads/2019/08/buches-de-bois-sec-40cm-3-380x380.jpg"
								alt=" bois"> :0</th>
							<th><img height="40px" width="40px"
								src="http://produitsversailles.com/wp-content/uploads/2018/06/pierre-polie-semi-grise-_105643-red-copy-300x300.png"
								alt="pierre">:0</th>
							<th><img height="40px" width="40px"
								src="http://www.a3m-asso.fr/wp-content/uploads/2016/07/ERAMET-Minerai-300x200.jpg"
								alt="minerais">:0</th>
							<th><img height="40px" width="40px"
								src="https://blog.arpp.org/wp-content/uploads/sites/5/2019/09/or-.jpg"
								alt="or">:0</th>
							<th><img height="40px" width="40px"
								src="https://www.corse-epoxy.fr/wp-content/uploads/2016/09/profil-acier-720x340.jpg"
								alt="fer">:0</th>
							<th><img height="40px" width="40px"
								src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/220px-NatCopper.jpg"
								alt="cuivre">:0</th>
						</tr>
					</table>
					<table class="table table-striped">
						<tr>
							<th>Batiment</th>
							<th>Attaque</th>
							<th>Défense</th>
							<th>Niveau</th>
						</tr>
						<c:set var="totalAtt" value="0"></c:set>
						<c:set var="totalDef" value="0"></c:set>
						<c:forEach items="${batiments}" var="batiment">
							<tr>
								<td>${batiment.nom}</td>
								<td>${batiment.att}</td>
								<td>${batiment.def}</td>
								<td>${batiment.level}</td>
							</tr>
							<c:set var="totalAtt" value="${totalAtt + batiment.att }"></c:set>
							<c:set var="totalDef" value="${totalDef + batiment.def }"></c:set>
						</c:forEach>
					</table>
					<table class="table table-striped">
						<tr>
							<th>Total</th>
							<th>Attaque: ${totalAtt}</th>
							<th>Défense: ${totalDef}</th>
					</table>

					<div>
						<button type="button" class="btn btn-primary"
							onclick="clickConstruction()">Construire</button>
						<button type="submit" class="btn btn-success"
							onclick="clickAmelioration()">Améliorer</button>
						<button type="button" class="btn btn-warning"
							onclick="clickTransformation()">Transformer</button>
						<button type="submit" class="btn btn-danger"
							onclick="clickAttaque()">Attaquer</button>
						<button type="button" class="btn btn-dark">Fin du tour</button>
					</div>


					<div id="fenetreConstruction">
						<h3>Construction</h3>
						<select class="form-select" aria-label="Default select example"
							style="width: 48%;">
							<option>blablablaConstru</option>
							<%-- 							<form:options items="${batimentsConstructibles}" itemValue="id" --%>
							<%-- 								itemLabel="${batiment.nom}"></form:options> --%>
							<!--                   			Ajouter le cout des batiments -->
						</select>
						<button type="submit" class="btn btn-outline-success">Valider</button>
					</div>



					<div id="fenetreAmelioration">
						<h3>Amélioration</h3>
						<select class="form-select" aria-label="Default select example"
							style="width: 48%;">
							<option>blablablaAméliorer</option>
							<%-- 							<form:options items="${batimentsAmeliorables}" itemValue="id" --%>
							<%-- 								itemLabel="${batiment.nom}"></form:options> --%>
							<!--                   			Ajouter le cout des amélioration -->
						</select>
						<button type="submit" class="btn btn-outline-success">Valider</button>
					</div>



					<div id="fenetreTransformation">
						<h3>Transformation</h3>
						<select class="form-select" aria-label="Default select example"
							style="width: 48%;">
							<option>blablablaTrans</option>
							<%-- 							<form:options items="${ressourcesTransformables}" itemValue="id" --%>
							<%-- 								itemLabel="${batiment.nom}"></form:options> --%>
							<!--                   			Ajouter le cout des amélioration -->
						</select> <input type="number" max="">
						<button type="submit" class="btn btn-outline-success">Valider</button>
					</div>



					<div id="fenetreAttaque">
						<h3>Attaque</h3>
						<select class="form-select" aria-label="Default select example"
							style="width: 48%;">
							<option>Attaquer avec tous mes batiments</option>
							<option>Batiments d'attaque</option>
							<%-- 							<form:options items="${ressourcesTransformables}" itemValue="id" --%>
							<%-- 								itemLabel="${batiment.nom}"></form:options> --%>
							<!--                   			Ajouter le cout des amélioration -->
						</select> <select class="form-select" aria-label="Default select example"
							style="width: 48%;">
							<option>joueurs</option>
							<%-- 							<form:options items="${ressourcesTransformables}" itemValue="id" --%>
							<%-- 								itemLabel="${batiment.nom}"></form:options> --%>
							<!--                   			Ajouter le cout des amélioration -->
						</select> <select class="form-select" aria-label="Default select example"
							style="width: 48%;">
							<option>Tous les batiments</option>
							<option>Liste des batiments du joueur selectionné</option>
							<%-- 							<form:options items="${ressourcesTransformables}" itemValue="id" --%>
							<%-- 								itemLabel="${batiment.nom}"></form:options> --%>
							<!--                   			Ajouter le cout des amélioration -->
						</select>
						<button type="submit" class="btn btn-outline-success">Attaquer
							!</button>
					</div>


					<script type="text/javascript">
						fenetreAttaque.style.display = "none";
						fenetreTransformation.style.display = "none";
						fenetreConstruction.style.display = "none";
						fenetreAmelioration.style.display = "none";

						function clickAttaque() {
							fenetreAttaque.style.display = "block";
							fenetreTransformation.style.display = "none";
							fenetreConstruction.style.display = "none";
							fenetreAmelioration.style.display = "none";

						}
						function clickAmelioration() {
							fenetreAttaque.style.display = "none";
							fenetreTransformation.style.display = "none";
							fenetreConstruction.style.display = "none";
							fenetreAmelioration.style.display = "block";

						}
						function clickTransformation() {
							fenetreAttaque.style.display = "none";
							fenetreTransformation.style.display = "block";
							fenetreConstruction.style.display = "none";
							fenetreAmelioration.style.display = "none";

						}
						function clickConstruction() {
							fenetreAttaque.style.display = "none";
							fenetreTransformation.style.display = "none";
							fenetreConstruction.style.display = "block";
							fenetreAmelioration.style.display = "none";

						}
					</script>

				</div>


				<div class="col-6">
					<div class="row">
						Pseudo du joueur2
						<%-- 					${session.compte.surname} --%>
						<table class="table table-striped">
							<tr>
								<th><img height="40px" width="40px"
									src="https://www.bois-brazeco.com/content/uploads/2019/08/buches-de-bois-sec-40cm-3-380x380.jpg"
									alt=" bois"> :0</th>
								<th><img height="40px" width="40px"
									src="http://produitsversailles.com/wp-content/uploads/2018/06/pierre-polie-semi-grise-_105643-red-copy-300x300.png"
									alt="pierre">:0</th>
								<th><img height="40px" width="40px"
									src="http://www.a3m-asso.fr/wp-content/uploads/2016/07/ERAMET-Minerai-300x200.jpg"
									alt="minerais">:0</th>
								<th><img height="40px" width="40px"
									src="https://blog.arpp.org/wp-content/uploads/sites/5/2019/09/or-.jpg"
									alt="or">:0</th>
								<th><img height="40px" width="40px"
									src="https://www.corse-epoxy.fr/wp-content/uploads/2016/09/profil-acier-720x340.jpg"
									alt="fer">:0</th>
								<th><img height="40px" width="40px"
									src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/220px-NatCopper.jpg"
									alt="cuivre">:0</th>
							</tr>
						</table>
						<table class="table table-striped">
							<tr>
								<th>Batiment</th>
								<th>Attaque</th>
								<th>Défense</th>
								<th>Niveau</th>
							</tr>
							<c:set var="totalAtt" value="0"></c:set>
							<c:set var="totalDef" value="0"></c:set>
							<c:forEach items="${batiments}" var="batiment">
								<tr>
									<td>${batiment.nom}</td>
									<td>${batiment.att}</td>
									<td>${batiment.def}</td>
									<td>${batiment.level}</td>
								</tr>
								<c:set var="totalAtt" value="${totalAtt + batiment.att }"></c:set>
								<c:set var="totalDef" value="${totalDef + batiment.def }"></c:set>
							</c:forEach>
						</table>
						<table class="table table-striped">
							<tr>
								<th>Total</th>
								<th>Attaque: ${totalAtt}</th>
								<th>Défense: ${totalDef}</th>
						</table>
					</div>




					<div class="row">
						Pseudo du joueur3
						<%-- 					${session.compte.surname} --%>
						<table class="table table-striped">
							<tr>
								<th><img height="40px" width="40px"
									src="https://www.bois-brazeco.com/content/uploads/2019/08/buches-de-bois-sec-40cm-3-380x380.jpg"
									alt=" bois"> :0</th>
								<th><img height="40px" width="40px"
									src="http://produitsversailles.com/wp-content/uploads/2018/06/pierre-polie-semi-grise-_105643-red-copy-300x300.png"
									alt="pierre">:0</th>
								<th><img height="40px" width="40px"
									src="http://www.a3m-asso.fr/wp-content/uploads/2016/07/ERAMET-Minerai-300x200.jpg"
									alt="minerais">:0</th>
								<th><img height="40px" width="40px"
									src="https://blog.arpp.org/wp-content/uploads/sites/5/2019/09/or-.jpg"
									alt="or">:0</th>
								<th><img height="40px" width="40px"
									src="https://www.corse-epoxy.fr/wp-content/uploads/2016/09/profil-acier-720x340.jpg"
									alt="fer">:0</th>
								<th><img height="40px" width="40px"
									src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/220px-NatCopper.jpg"
									alt="cuivre">:0</th>
							</tr>
						</table>
						<table class="table table-striped">
							<tr>
								<th>Batiment</th>
								<th>Attaque</th>
								<th>Défense</th>
								<th>Niveau</th>
							</tr>
							<c:set var="totalAtt" value="0"></c:set>
							<c:set var="totalDef" value="0"></c:set>
							<c:forEach items="${batiments}" var="batiment">
								<tr>
									<td>${batiment.nom}</td>
									<td>${batiment.att}</td>
									<td>${batiment.def}</td>
									<td>${batiment.level}</td>
								</tr>
								<c:set var="totalAtt" value="${totalAtt + batiment.att }"></c:set>
								<c:set var="totalDef" value="${totalDef + batiment.def }"></c:set>
							</c:forEach>
						</table>
						<table class="table table-striped">
							<tr>
								<th>Total</th>
								<th>Attaque: ${totalAtt}</th>
								<th>Défense: ${totalDef}</th>
						</table>
					</div>
				</div>

			</div>
		</div>




	</main>
	<footer> </footer>
</body>





</html>
