<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Asesorias</title>
    <!-- CSS Bootstrap -->
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
    <spring:url value="/resources/css/datatables.css" var="datatablesCSS"/>
    <spring:url value="/resources/css/dataTables.bootstrap4.css" var="datatablesbCSS"/>
    
    <link href="${bootstrapCSS}" rel="stylesheet" />
    <link href="${datatablesCSS}" rel="stylesheet" />
    <link href="${datatablesbCSS}" rel="stylesheet" />
    
    <!-- jQuery, datatable -->
    <spring:url value="/resources/js/jquery-3.5.1.min.js" var="jqueryJS" />
    <spring:url value="/resources/js/jquery.dataTables.js" var="datatablesJS"/>
   	<spring:url value="/resources/js/jquery.dataTables.es.js" var="datatablesEsJS"/>
    
    <script src="${jqueryJS}"></script>
    <script src="${datatablesJS}"></script>
    <script src="${datatablesEsJS}"></script>
</head>
<body style="padding: 10px;">

	<h1>Listado de Asesorias</h1>

<table id="tabla" class="table table-striped table-bordered" style="width: 100%; ">
	<thead>		
	<tr>
		<th>ID Asesoria</th>
		<th>Detalle</th>
		<th>Gestión</th>
		<th>Propuestas</th>
		<th>Fecha</th>
		<th>Especial</th>
		<th>Id Visita </th>
		<th>Acciones</th>
	</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${list}" var="ase">
	<tr>
		<td>${ase.idasesoria}</td> 
		<td>${ase.detalle}</td>
		<td>${ase.gestion}</td>
		<td>${ase.propuestas}</td>
		<td>${ase.fecha}</td>
		<td>${ase.especial}</td>
		<td>${ase.visitas_idvisita}</td>
		<td>
			<a href="deletease/${ase.idasesoria}">Eliminar</a>&nbsp;
			<a href="editase/${ase.idasesoria}">Editar</a>&nbsp;
		</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<br/>
	<a href="aseform">Agregar nueva asesoria </a>&nbsp;&nbsp;
	<a href="index.jsp">Volver al inicio</a>

</body>

</html>