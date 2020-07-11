<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="usuario" action="hacerRegistro"
		method="post">

		<table align="center">
			<tr>
				<td><label>Nombre de usuario</label></td>
				<td><form:input path="username" id="username" /></td>
			</tr>
			<tr>
				<td><label>Contraseña</label></td>
				<td><form:password path="password" id="password" /></td>
			</tr>
			<tr>
				<td><label>Role de usuario</label></td>
				<td><form:input path="role" id="role" /></td>
			</tr>			
			<tr>
				<td><label>Nombre</label></td>
				<td><form:input path="nombre" id="nombre" /></td>
			</tr>
			<tr>
				<td><label>Correo Electrónico</label></td>
				<td><form:input path="correoelectronico" id="correoelectronico" /></td>
			</tr>
			<tr>
				<td><label>Habilitado</label></td>
				<td><form:input path="activado" id="activado" /></td>
			</tr>

			<tr>
				<td></td>
				<td><form:button id="registro">Registrarse</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="index.jsp">Volver a principal</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>