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
    <title>Editar Empleado</title>
  </head>
  <body>
    <div class="jumbotron">
        <header class="text-center">
            <h2>Editar Empleado</h2>
        </header>
    </div> 
     <form:form method="post" action="/UltimoProyectoSpring/empleditsave">
      <div class="container">
          <div class="row">
             <label class="col-4"><h5>Nombre:</h5></label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>              
              <form:input class="col-6 input-group" path="nombre"/>
          </div>
          <br><br>
          <div class="row">
              <label class="col-4"><h5>Especialidad:</h5></label>
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>></b></span>
              </div>
              <form:input class="col-6 input-group" path="especialidad"/>
          </div>
          <br><br><br>
           <div class="row">
               <div class="container" style="max-width:55%">
               <input type="submit" class="btn btn-warning col-4" value="Volver" name="viewemp"/>
                <form:hidden path="idempleado"/>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" class="btn btn-warning col-4" value="Editar Empleado"/>
               </div>
           </div>          
        </div>
      </form:form> 
      <div class="container" style="height: 50px;"></div>
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Boot strap JS -->
    <spring:url value="/resources/js/jquery-3.5.1.min.js" var="jqueryJS" />
    <spring:url value="/resources/js/popper.min.js" var="popperJS"/>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
    
    <script src="${jqueryJS}"></script>
    <script src="${popperJS}"></script>
    <script src="${bootstrapJS}"></script>
  </body>
</html>