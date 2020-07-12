<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checklist</title>
<!-- CSS Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<h1 class="display-4 p-2 font">Formulario de Chequeo en Terreno</h1>
<c:if test="${ccmensaje != null}">
	<h3><c:out value="${ccmensaje}"></c:out></h3>
</c:if>

  <form action="CrearChecklist" method="post" class="form pt-3">
  	<table class="table-bordered"> 
       	<tr > 
            <td  class="p-3"> <!-- class="title text-center" -->
            <label>ID Chequeo:</label>
            <input type="number" name="idchequeo" placeholder="Ingresar ID Asesoría">&nbsp;
            <label>Fecha: </label>
			<input id="fecha" type="text" name="fecha" placeholder="dd-mm-aaaa"/>
            <br><br>
            <label>ID Visita:</label>
            <input type="number" name="visitaid" placeholder="Ingresar ID Visitas">
            <br><br> 
            <label>Detalle: </label><br>
            <textarea name="detalle" rows="5" cols="60" placeholder="Ingresar detalle de la asesoría con un máximo hasta 500 caracteres"></textarea>
            <br>
            <label>Estado: </label><br>
            <textarea name="estado" rows="5" cols="60" placeholder="Ingresar detalle del estado del chequeo en terreno con un máximo hasta 500 caracteres"></textarea>
            <br><br>
			<div id="cf-submit">
            <button type="submit" class="btn btn-transparent" id="contact-submit"> Enviar</button>
            </div>                    
        </tr>
    </table>
    
      <a href="${pageContext.request.contextPath}/ListadoAsesoria">Volver al Listado de Checklist </a>
    	<br><br />
  </form>
</body>
</html>