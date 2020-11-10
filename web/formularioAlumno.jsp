<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP formulario alumno</title>
    </head>
    <body>
        <h1>
            <c:if test="${alumno.id == 0}" >NUEVO</c:if>
            <c:if test="${alumno.id != 0}" >EDITAR</c:if>
            
                REGISTRO        
            </h1> 
            <form action="Iniciar" method="POST">

            <input type="hidden" name="id" value="${alumno.id}" />

            <label>NOMBRE:</label>
            <input type="text" name="nombre" value="${alumno.nombre}" />
            <br>

            <label>PATERNO:</label>
            <input type="text" name="apellidoPaterno" value="${alumno.apellidoPaterno}" />
            <br>

            <label>MATERNO:</label>
            <input type="text" name="apellidoMaterno" value="${alumno.apellidoMaterno}" />
            <br>

            <label>CORREO:</label>
            <input type="text" name="correo" value="${alumno.correo}" />
            <br>
            
            <input type="submit" value="ENVIAR"  />
            
        </form>     
    </body>
</html>
