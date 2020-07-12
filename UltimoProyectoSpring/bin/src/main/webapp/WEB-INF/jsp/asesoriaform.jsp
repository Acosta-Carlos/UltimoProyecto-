<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS JS-->
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
    <spring:url value="/resources/js/jquery-3.5.1.min.js" var="jqueryJS" />
    
     <link href="${bootstrapCSS}" rel="stylesheet" />
    <script src="${jqueryJS}"></script>
    <title>Solicitar Asesorias</title>
  </head>
   

  <body>
    <div class="jumbotron">
        <header class="text-center">
            <h2>Solicitar Asesoria </h2>
        </header>
    </div> 
    
     <form:form method="post" action="savease">
      <div class="container">
          <div class="row">
             <label class="col-4">  ID Asesoria:</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>              
              <form:input  class="col-6 input-group" path="idasesoria"/>
          </div>
    	<br><br>
          <div class="row">
              <label class="col-4">  Detalle :</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:input  class="col-6 input-group" path="detalle"/>
          </div>
          <br><br>
          
          
          <div class="row">
              <label class="col-4">  Gestión:</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:input  class="col-6 input-group" path="gestion"/>
          </div>
          <br><br>
          
          
          <div class="row">
              <label class="col-4">  Propuestas:</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:input  class="col-6 input-group" path="propuestas"/>
          </div>
          <br><br>
          
          
          
          <div class="row">
              <label class="col-4">Fecha:</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:input  class="col-6 input-group" path="fecha"/>
          </div>
          <br><br>
          
          
          
          <div class="row">
              <label class="col-4">  Especial:</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:input  class="col-6 input-group" path="especial"/>
          </div>
          <br><br>
    
    
    	<div class="row">
              <label class="col-4">  Visita Id:</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:input  class="col-6 input-group" path="visitas_idvisita"/>
          </div>
          <br><br>
           <c:if test="${ccmensaje != null}">
					<h3><c:out value="${ccmensaje}"></c:out></h3>
				</c:if>
          <br><br><br>
          
          <div class="row">
               <div class="container" style="max-width:55%">
               <input type="submit" class="btn btn-warning col-4" value="Listado de Asesorias" formaction="viewasesoria">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" class="btn btn-warning col-4" value="Agregar Asesoria">
               </div>
           </div>          
        </div>
      </form:form> 
      <div class="container" style="height: 50px;"></div>
    
     <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <spring:url value="/resources/js/jquery-3.5.1.min.js" var="jqueryJS" />
    <spring:url value="/resources/js/popper.min.js" var="popperJS"/>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
    
    <script src="${jqueryJS}"></script>
    <script src="${popperJS}"></script>
    <script src="${bootstrapJS}"></script>
  </body>

</html>