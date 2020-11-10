<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LISTA DE ESTUDIANTES</h1>
        <p> <a href="Iniciar?action=adicionar"> NUEVO REGISTRO </a></p>
        <table border="2">
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>APELLIDO PATERNO</th>
                <th>APELLIDO MATERNO</th>
                <th>CORREO</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${alumnos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellidoPaterno}</td>
                    <td>${item.apellidoMaterno}</td>
                    <td>${item.correo}</td>
                    <td> <a href="Iniciar?action=editar&id=${item.id}"> EDITAR </a></td>
                    <td> <a href="Iniciar?action=borrar&id=${item.id}"> ELIMINAR </a></td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
