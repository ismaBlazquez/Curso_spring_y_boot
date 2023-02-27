<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">
		Listado de películas
	</h1>
	
	<form:form name="formulario" action="" method="get">
		<p align="center">
			<input type="submit" 
			       onclick="document.formulario.action='nuevaPelicula.htm'" 
			       value="Nuevo"/>
		</p>
	</form:form>	

	<table align="center" border="1">
		<tr>
			<th>Título</th>
			<th>Director</th>
			<th>Genero</th>
			<th>Año</th>
		</tr>	
		<c:forEach var="p" items="${listaPeliculas}">
			<tr>
				<td>
					<c:url var="url" value="seleccionarPelicula.htm">
						<c:param name="id" value="${p.id}"/>
					</c:url>
					<a href="${url}">${p.titulo}</a>
				</td>
				<td>${p.director}</td>
				<td>${p.genero}</td>
				<td>${p.year}</td>
			</tr>		
		</c:forEach>	
	</table>

</body>
</html>












