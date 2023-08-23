<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cabecera {
	font-size: 1.2em;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #08088A;
}

.fila {
	text-align: center;
	background-color: #5882FA;
}

table {
	float: left;
}
</style>
</head>

<body>
	<table>
		<tr>
			<td class="cabecera">Código</td>
			<td class="cabecera">Nombre</td>
			<td class="cabecera">Precio</td>
			<td class="cabecera">Fecha</td>
			<td class="cabecera">País de origen</td>
		</tr>

		<c:forEach var="p" items="${productos}">
			<tr>
				<td class="fila">${p.codigo}</td>
				<td class="fila">${p.nombre}</td>
				<td class="fila">${p.precio}</td>
				<td class="fila">${p.fecha}</td>
				<td class="fila">${p.paisOrigen}</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>