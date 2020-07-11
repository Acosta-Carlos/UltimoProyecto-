<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="es">
	<head>		
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Inicio</title>
		
		<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
		<spring:url value="/resources/css/estilos.css" var="estilosCSS" />
	
		<link href="${bootstrapCSS}" rel="stylesheet" />
		<link href="${estilosCSS}" rel="stylesheet" />
	</head>
<body>

	<table align="center">
		<tr>
			<td><a href="login">Login</a></td><br/>
			<td>&nbsp; <a href="registro">Registrarse</a></td>
		</tr>
	</table>
	
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->   
	<spring:url value="/resources/js/jquery-3.5.1.min.js" var="jqueryJS" />
	<spring:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrapbJS" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
    <script src="${jqueryJS}"></script>
    <script src="${bootstrapbJS}"></script>
    <script src="${bootstrapJS}"></script>
</body>
</html>
