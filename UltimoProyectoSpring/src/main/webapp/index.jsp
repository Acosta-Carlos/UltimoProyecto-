<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
	<head>		
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Inicio</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/estilos.css" />
	</head>
	<body>

<div class="container-md text-center" >
  <h1 class="display-4">Pagina Inicio </h1>
  <p class="lead">¿Qué acción deseas realizar?</p>
  <hr class="my-4">
 
</div>

<div class= "container" id="cont">

<h2>Cliente</h2>

<div class="list-group text-center">
	<a href="${pageContext.request.contextPath}/SolicitarAsesoria" class="list-group-item list-group-item-action list-group-item-light">Solicitar Asesoria </a>
 	<a href="${pageContext.request.contextPath}/AgregarAccidente" class="list-group-item list-group-item-action list-group-item-dark"> Reportar Accidente</a>
  
</div>
</div>
<br/>
<br/>

<div class= "container" id="cont">

<h2>Profesional</h2>

<div class="list-group text-center">
<a href="${pageContext.request.contextPath}/ListadoClientes" class="list-group-item list-group-item-action list-group-item-light">Administrar Clientes</a>
<a href="${pageContext.request.contextPath}/ListadoEmpleados" class="list-group-item list-group-item-action list-group-item-dark">Administrar Empleados</a>
<a href="${pageContext.request.contextPath}/ListarCapacitacion" class="list-group-item list-group-item-action list-group-item-light">Gestionar Capacitaciones</a>
<a href="${pageContext.request.contextPath}/ListadoAccidente" class="list-group-item list-group-item-action list-group-item-dark">Gestionar Accidentes</a>
<a href="${pageContext.request.contextPath}/ListadoAsesoria" class="list-group-item list-group-item-action list-group-item-light">Gestionar Asesorias</a>
<a href="${pageContext.request.contextPath}/ListadoMejoras" class="list-group-item list-group-item-action list-group-item-dark">Gestionar Actividades de Mejoras</a>
<a href="${pageContext.request.contextPath}/ListarPago" class="list-group-item list-group-item-action list-group-item-light">Gestionar Pagos</a>

</div>
</div>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>