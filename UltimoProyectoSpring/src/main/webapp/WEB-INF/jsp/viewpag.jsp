<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Pagos de Clientes</title>
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

	<h1>Listar Pagos de Clientes</h1>

<table id="tabla" class="table table-striped table-bordered" style="width: 100%; ">
	<thead>		
	<tr>
		<th>ID Pago</th>
		<th>Mes/Año</th>
		<th>Monto Regular</th>
		<th>Monto Adicionales</th>
		<th>ID Cliente</th>
		<th>Acciones</th>
	</tr>
	</thead>
	<tbody>
	<!--JSTL para cada campo en la variable items-->
	<c:forEach items="${list}" var="pag">
		<tr>
			<td>${pag.idpago}</td>
			<td>${pag.mesanio}</td>
			<td>$${pag.montoregular}</td>
			<td>$${pag.montoadicionales}</td>
			<td>${pag.cliente_id}</td>
			<td>
				<a href="deletepag/${pag.idpago}">Eliminar</a>&nbsp;
				<a href="editpag/${pag.idpago}">Editar</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<br/>
	<a href="pagform">Agregar nuevo Pago</a>&nbsp;&nbsp;
	<a href="index.jsp">Volver al inicio</a>

</body>
</html>