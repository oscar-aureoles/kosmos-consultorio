<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Lista de Consultorios</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Número</th>
                    <th>Piso</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listConsultorios}" var="consultorio">
                    <tr>
                        <td>${consultorio.numero}</td>
                        <td>${consultorio.piso}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>