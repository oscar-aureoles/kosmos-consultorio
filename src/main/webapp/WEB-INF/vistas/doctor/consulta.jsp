<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Lista de Doctores</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    <th>Especialidad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listDoctores}" var="doctor">
                    <tr>
                        <td>${doctor.nombre}</td>
                        <td>${doctor.apellidoParterno}</td>
                        <td>${doctor.apellidoMaterno}</td>
                        <td>${doctor.especialidad}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>