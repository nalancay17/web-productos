<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="controlador.ModificarProductoServlet"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar producto</title>
</head>
<body>

	<h1 style="text-align: center">Modificar producto</h1>
	<form name="form_nuevo_producto" method="post"
		action="ModificarProductoServlet" accept-charset="UTF-8">

		<input type="hidden" name="codigo" value="${producto.codigo}">

		<table width="50%" border="0">
			<tr>
				<td>Nombre</td>
				<td><label for="nombre"></label> <input type="text"
					name="nombre" id="nombre" value="${producto.nombre}"></td>
			</tr>
			<tr>
				<td>Precio</td>
				<td><label for="precio"></label> <input type="text"
					name="precio" id="precio" value="${producto.precio}"></td>
			</tr>
			<tr>
				<td>Fecha</td>
				<td><label for="fecha"></label> <input type="text" name="fecha"
					id="fecha" value="${producto.fecha}"></td>
			</tr>
			<tr>
				<td>País de origen</td>
				<td><label for="pais_origen"></label> <input type="text"
					name="pais_origen" id="pais_origen" value="${producto.paisOrigen}"></td>
			</tr>
			<tr>
				<td><input type="submit" name="envio" id="envio" value="Actualizar"></td>
				<td><input type="reset" name="borrar" id="borrar"
					value="Restablecer"></td>
			</tr>
		</table>
	</form>

</body>
</html>