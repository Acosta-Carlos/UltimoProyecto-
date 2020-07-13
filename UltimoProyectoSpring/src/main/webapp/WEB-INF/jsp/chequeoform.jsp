<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>      
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
    <title>Agregar Chequeo</title>
  </head>
   

  <body>
    <div class="jumbotron">
        <header class="text-center">
            <h2>Agregar Chequeo </h2>
        </header>
    </div> 
    
     <form:form method="post" action="savechequeo">
      <div class="container">
          <div class="row">
             <label class="col-4">  ID Chequeo:</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>              
              <form:input class="col-6 input-group" path="idchequeo"/>
          </div>
    	<br><br>
          <div class="row">
              <label class="col-4">  Detalle :</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:textarea  class="col-6 input-group" path="detalle" rows="5" cols="60" placeholder="Ingresar detalle de la asesoría con un máximo hasta 500 caracteres"/>
          </div>
          <br><br>
          
          
          <div class="row">
              <label class="col-4">  Estado:</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:textarea  class="col-6 input-group" path="estado" rows="5" cols="60" placeholder="Ingresar detalle del estado del chequeo en terreno con un máximo hasta 500 caracteres"/>
              
          </div>
          <br><br>
          
          
          <div class="row">
              <label class="col-4">  Visita ID :</label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:input class="col-6 input-group" path="visitas_idvisita" placeholder="Ingresar ID Visitas"/>
          </div>
          <br><br>
          
          <div class="row">
               <div class="container" style="max-width:55%">
               <a class="btn btn-warning col-4" href="viewchequeo" role="button">Listado de Chequeos</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" class="btn btn-warning col-4" value="Agregar chequeo">
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