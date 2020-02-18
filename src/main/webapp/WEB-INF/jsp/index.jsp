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
<style>
body {
    background-image: url("img/background2.jpg");
}
</style>
</head>
<body>

	<form:form action="insert" method="post" modelAttribute="entrenador">
		<img src="img/logo2.png" id="trainer">
		<br></br>
		<span>Trainer name:</span>
		<form:input type="text" path="name" />
		<input type="submit" value="Save entrenador name" />
	</form:form>
	<br />
	<br />
	The name of the trainer is <span><c:out value="${entrenador.name}" /></span>
	<br />
	<br />
	<br />

	<form:form action="insert" method="post" modelAttribute="entrenador">
		<span>Field "type" instructions.
		      Enter "pokemon" to add it to your team.
			  Enter "active" to add it directly to your active pokemon</span>
			  <br></br>
		<span>New Pokemon:</span>
		<span>Name:</span>
		<form:input type="text" path="pokemon.name" />
		<span>Level:</span>
		<form:input type="text" path="pokemon.level" />
		<span>Type:</span>
		<form:input type="text" path="pokemon.type" />
		<input type="submit" value="save pokemon" />
		
		<br></br>
	</form:form>
		<table border="1">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>level</td>
				<td>tipo</td>
				<td>hp</td>
				<td>attack power</td>
				<td>Race type</td>
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
					<td><c:out value="${pokemon.race}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form:form action="switchActive" method="post" modelAttribute="entrenador">
		<form:select path="aux">
			<c:set var = "count" scope = "page" value = "0"/>
			<c:forEach var="item" items="${entrenador.team.pokemons}">
				<form:option value="${count}"><c:out value="${item.name} #${count + 1}"/></form:option>
				<c:set var="count" value="${count + 1}" scope="page"/>
			</c:forEach>
		</form:select>
		<input type="submit" value="Change active pokemon" />
	</form:form>
	
	<form:form action="deletePokemon" method="post" modelAttribute="entrenador">
					<form:select path="aux2">
						<c:set var = "count" scope = "page" value = "0"/>
						<c:forEach var="item" items="${entrenador.team.pokemons}">
							<form:option value="${count}"><c:out value="${item.name} #${count + 1}"/></form:option>
							<c:set var="count" value="${count + 1}" scope="page"/>
						</c:forEach>
					</form:select>
					<input type="submit" value="Delete Pokemon"/>
				</form:form>
	
	<form:form action="createEnemy" method="post" modelAttribute="entrenador">
		<input type="submit" value="Generate an enemy"/>
	</form:form>

	<br />
	<img src="img/ally.png" id="trainer">
	<br />
<%-- 	<a>Active Pokemon</a><br/><c:out value="${entrenador.primary.name}"/> --%>
<%-- 	<c:out value="${entrenador.primary.status}"/> Nivel:  --%>
<%-- 	<c:out value="${entrenador.primary.level}"/> Vida:  --%>
<%-- 	<c:out value="${entrenador.primary.HP}"/>  --%>
<%-- 	<c:out value="${entrenador.primary.vidaMaxima}"/> Ataque:  --%>
<%-- 	<c:out value="${entrenador.primary.attackPower}"/> --%>
	
	<table border="1">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>status</td>
				<td>level</td>
				<td>hp</td>
				<td>Max hp</td>
				<td>attack power</td>
				<td>Race type</td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${entrenador.primary.name}" /></td>
					<td><c:out value="${entrenador.primary.status}" /></td>
					<td><c:out value="${entrenador.primary.level}" /></td>
					<td><c:out value="${entrenador.primary.HP}" /></td>
					<td><c:out value="${entrenador.primary.vidaMaxima}" /></td>
					<td><c:out value="${entrenador.primary.attackPower}" /></td>
					<td><c:out value="${entrenador.primary.race}" /></td>
				</tr>
		</tbody>
	</table>
	<br/>
	
	<img src="img/enemy.gif" id="trainer">
	<br />
<%-- 	<a>Enemy Pokemon</a><br/><c:out value="${entrenador.wild.name}"/> --%>
<%-- 	<c:out value="${entrenador.wild.status}"/> Nivel:  --%>
<%-- 	<c:out value="${entrenador.wild.level}"/> Vida:  --%>
<%-- 	<c:out value="${entrenador.wild.HP}"/>  --%>
<%-- 	<c:out value="${entrenador.wild.vidaMaxima}"/> Ataque:  --%>
<%-- 	<c:out value="${entrenador.wild.attackPower}"/> --%>
	
	<table border="1">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>status</td>
				<td>level</td>
				<td>hp</td>
				<td>Max hp</td>
				<td>attack power</td>
				<td>Race type</td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${entrenador.wild.name}" /></td>
					<td><c:out value="${entrenador.wild.status}" /></td>
					<td><c:out value="${entrenador.wild.level}" /></td>
					<td><c:out value="${entrenador.wild.HP}" /></td>
					<td><c:out value="${entrenador.wild.vidaMaxima}" /></td>
					<td><c:out value="${entrenador.wild.attackPower}" /></td>
					<td><c:out value="${entrenador.wild.race}" /></td>
				</tr>
		</tbody>
	</table>

<br />
			<form:form action="combat" method="post" modelAttribute="entrenador">
				<input type="submit" value="Attack!"/>
			</form:form>
			<form:form action="capture" method="post" modelAttribute="entrenador">
				<input type="submit" value="Use pokeball"/>
			</form:form>
			<form:form action="heal" method="post" modelAttribute="entrenador">
				<input type="submit" value="Heal"/>
			</form:form>
			<br />
			<img src="img/thanks.gif" id="trainer">
</body>
</html>