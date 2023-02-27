<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Listado personas</h1>

	<table align="center" border="1">
		<c:forEach var="p" items="${listaPersonas}">
			<tr>
				<td>${p.id}</td>
				<td>${p.nombre}</td>
				<td>${p.direccion}</td>
				<td>${p.telefono}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>