<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de productos</title>
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

#contenedorBoton {
	margin-left: 700px;
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
			<td class="cabecera">Modificar</td>
		</tr>

		<c:forEach var="p" items="${productos}">
			<c:url var="link_modificar" value="/ModificarProductoServlet">
				<c:param name="codigo" value="${p.codigo}"></c:param>
			</c:url>

			<tr>
				<td class="fila">${p.codigo}</td>
				<td class="fila">${p.nombre}</td>
				<td class="fila">${p.precio}</td>
				<td class="fila">${p.fecha}</td>
				<td class="fila">${p.paisOrigen}</td>
				<td class="fila"><a href="${link_modificar}">Actualizar</a></td>
			</tr>
		</c:forEach>

	</table>

	<div id="contenedorBoton">
		<input type="button" value="Insertar nuevo producto"
			onclick="window.location.href='RegistroProducto.jsp'" />
	</div>

</body>
</html>