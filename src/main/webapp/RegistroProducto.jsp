<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="controlador.RegistroProductoServlet"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro nuevo producto</title>
</head>
<body>

	<h1 style="text-align: center">Insertar nuevo producto</h1>
	<form name="form_nuevo_producto" method="post" action="RegistroProductoServlet" accept-charset="UTF-8">
		<table width="50%" border="0">
			<tr>
				<td width="20%">Código</td>
				<td width="70%"><label for="codigo"></label> <input type="text"
					name="codigo" id="codigo"></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><label for="nombre"></label> <input type="text"
					name="nombre" id="nombre"></td>
			</tr>
			<tr>
				<td>Precio</td>
				<td><label for="precio"></label> <input type="text"
					name="precio" id="precio"></td>
			</tr>
			<tr>
				<td>Fecha</td>
				<td><label for="fecha"></label> <input type="text" name="fecha"
					id="fecha"></td>
			</tr>
			<tr>
				<td>País de origen</td>
				<td><label for="pais_origen"></label> <input type="text"
					name="pais_origen" id="pais_origen"></td>
			</tr>
			<tr>
				<td><input type="submit" name="envio" id="envio" value="Enviar"></td>
				<td><input type="reset" name="borrar" id="borrar"
					value="Restablecer"></td>
			</tr>

		</table>
	</form>

</body>
</html>