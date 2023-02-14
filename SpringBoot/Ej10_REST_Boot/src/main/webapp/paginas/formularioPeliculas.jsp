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
		Formulario de películas
	</h1>
	
	<form:form name="formulario" action="" method="post" commandName="pelicula">
		<p align="center">
			<input type="submit" 
			       onclick="document.formulario.action='insertarPelicula.htm'" 
			       value="Insertar"/>
			<input type="submit" 
			       onclick="document.formulario.action='modificarPelicula.htm'" 
			       value="Modificar"/>
			<input type="submit" 
			       onclick="document.formulario.action='borrarPelicula.htm'" 
			       value="Borrar"/>
			<input type="submit" 
			       onclick="document.formulario.action='mostrarListadoPeliculas.htm'" 
			       value="Cancelar"/>
		</p>
		
		<form:hidden path="id"/>
	
		<table align="center">
			<tr>
				<td>Titulo</td>
				<td>
					<form:input path="titulo"/>
				</td>			
			</tr>
			<tr>
				<td>Director</td>
				<td>
					<form:input path="director"/>
				</td>			
			</tr>
			<tr>
				<td>Género</td>
				<td>
					<form:input path="genero"/>
				</td>			
			</tr>
			<tr>
				<td>Año</td>
				<td>
					<form:input path="year"/>
				</td>			
			</tr>
		</table>
	
	
	</form:form>	

</body>
</html>












