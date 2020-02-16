<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<form:form action="insert" method="post" modelAttribute="entrenador">
		<img src="img/trainer.png" id="trainer">
		<span>Entrenador name:</span>
		<form:input type="text" path="name" />
		<input type="submit" value="Save entrenador name" />
	</form:form>
	<br />
	<br />
	The name of the entrenador is <span><c:out value="${entrenador.name}" /></span>
	<br />
	<br />
	<br />

	<form:form action="insert" method="post" modelAttribute="entrenador">
		<span>nuevo pokemon:</span>
		<span>nombre:</span>
		<form:input type="text" path="pokemon.name" />
		<span>level:</span>
		<form:input type="text" path="pokemon.level" />
		<span>tipo:</span>
		<form:input type="text" path="pokemon.type" />
		<input type="submit" value="guardar pokemon" />
	</form:form>
		<table border="1">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>level</td>
				<td>tipo</td>
				<td>hp</td>
				<td>attack power</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pokemon" items="${entrenador.team.pokemons}">
				<tr>
					<td><c:out value="${pokemon.name}" /></td>
					<td><c:out value="${pokemon.level}" /></td>
					<td><c:out value="${pokemon.type}" /></td>
					<td><c:out value="${pokemon.HP}" /></td>
					<td><c:out value="${pokemon.attackPower}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form:form action="createEnemy" method="post" modelAttribute="entrenador">
		<input type="submit" value="Entrar a la hierba alta"/>
	</form:form>

	<a>Pokemon Activo</a><br/><c:out value="${entrenador.primary.name}"/> &#8212;
	<c:out value="${entrenador.primary.status}"/>&#8212; Nivel: &nbsp;
	<c:out value="${entrenador.primary.level}"/> Vida: &nbsp;
	<c:out value="${entrenador.primary.HP}"/> &#47;
	<c:out value="${entrenador.primary.vidaMaxima}"/> Ataque: &nbsp;
	<c:out value="${entrenador.primary.attackPower}"/>
	<br/>
	<a>Pokemon Enemigo</a><br/><c:out value="${entrenador.wild.name}"/> &#8212;
	<c:out value="${entrenador.wild.status}"/>&#8212; Nivel: &nbsp;
	<c:out value="${entrenador.wild.level}"/> Vida: &nbsp;
	<c:out value="${entrenador.wild.HP}"/> &#47;
	<c:out value="${entrenador.wild.vidaMaxima}"/> Ataque: &nbsp;
	<c:out value="${entrenador.wild.attackPower}"/>
	<img src="img/charizard.png" id="charizard">

<!-- 		<table border="1"> -->
<!-- 		<thead> -->
<!-- 			<tr> -->
<!-- 				<td>ataques disponibles</td> -->
<!-- 			</tr> -->
<!-- 		</thead> -->
<!-- 		<tbody> -->
<!-- 			<tr> -->
<!-- 				primaria -->
<%-- 				<td>primaria: <c:out value="${entrenador.primary.name}" /></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				secundaria -->
<%-- 				<td><c:out value="${entrenador.secondary.name}" /></td> --%>
<!-- 			</tr> -->
<!-- 		</tbody> -->
<!-- 	</table> -->
<!-- 	<br /> -->
<!-- 	<br /> -->
<!-- 	<table border="1"> -->
<!-- 		<thead> -->
<!-- 			<tr> -->
<!-- 				<td>primary customization</td> -->
<!-- 			</tr> -->
<!-- 		</thead> -->
<!-- 		<tbody> -->
<%-- 			<c:forEach var="pokemon" items="${entrenador.primary.pokemons}"> --%>
<!-- 				<tr> -->
<%-- 					<td><c:out value="${pokemon.name}" /></td> --%>
<%-- 					<td><c:out value="${pokemon.level}" /></td> --%>
<%-- 					<td><c:out value="${pokemon.type}" /></td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</tbody> -->
<!-- 	</table> -->
<!-- 	<br /> -->


<!-- 	<table border="1"> -->
<!-- 		<thead> -->
<!-- 			<tr> -->
<!-- 				<td>secundary customization</td> -->
<!-- 			</tr> -->
<!-- 		</thead> -->
<!-- 		<tbody> -->
<%-- 			<c:forEach var="pokemon" items="${entrenador.secondary.pokemons}"> --%>
<!-- 				<tr> -->
<%--                     <td><c:out value="${pokemon.name}" /></td> --%>
<%--                     <td><c:out value="${pokemon.level}" /></td> --%>
<%--                     <td><c:out value="${pokemon.type}" /></td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 		</tbody> -->
<!-- 	</table> -->


	<form:form action="switchActive" method="post">
		<input type="submit" value="Change active pokemon" />
	</form:form>
	
</body>
</html>