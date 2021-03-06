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
<div class="container-md text-center" >
  <h1 class="display-4">Pagina Inicio </h1>
  <p class="lead">�Qu� acci�n deseas realizar?</p>
  <hr class="my-4">
</div>

<div class= "container" id="cont">
<h2>Cliente</h2>

	<div class="list-group text-center">
	<a href="c_aseform" class="list-group-item list-group-item-action list-group-item-light">Solicitar Asesoria </a>
 	<a href="r_accform" class="list-group-item list-group-item-action list-group-item-dark"> Reportar Accidente</a>
	</div>
</div>

<br/>
<br/>

<div class= "container" id="cont">

	<h2>Profesional</h2>

	<div class="list-group text-center">
	<a href="viewcli" class="list-group-item list-group-item-action list-group-item-light">Administrar Clientes</a>
	<a href="viewemp" class="list-group-item list-group-item-action list-group-item-dark">Administrar Empleados</a>
	<a href="viewcap" class="list-group-item list-group-item-action list-group-item-light">Gestionar Capacitaciones</a>
	<a href="viewacc" class="list-group-item list-group-item-action list-group-item-dark">Gestionar Accidentes</a>
	<a href="viewase" class="list-group-item list-group-item-action list-group-item-light">Gestionar Asesorias</a>
	<a href="viewmej" class="list-group-item list-group-item-action list-group-item-dark">Gestionar Actividades de Mejoras</a>
	<a href="viewpag" class="list-group-item list-group-item-action list-group-item-light">Gestionar Pagos</a>
	<a href="viewvisita" class="list-group-item list-group-item-action list-group-item-dark">Gestionar Visitas</a>
	<a href="viewchequeo" class="list-group-item list-group-item-action list-group-item-light">Gestionar Chequeos</a>
	</div>
</div>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->   
	<spring:url value="/resources/js/jquery-3.5.1.min.js" var="jqueryJS" />
	<spring:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrapbJS" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
    <script src="${jqueryJS}"></script>
    <script src="${bootstrapbJS}"></script>
    <script src="${bootstrapJS}"></script>
</body>
</html>
