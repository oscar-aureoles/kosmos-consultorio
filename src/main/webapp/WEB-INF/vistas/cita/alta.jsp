<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Lista de Consultorios</title>
    </head>
    <body>
      <c:if test="${altaSuccess}">
          <div>Cita registrada correctamente: ${cita.id}</div>
      </c:if>
      <form:form action = "/cita/alta" method="post" modelAttribute="altaCitaRequest">
          <form:label path="consultorio" >Consultorio: </form:label>
          <form:select path="consultorio">
              <c:forEach items="${listConsultorios}" var="consultorio">
                  <form:option value="${consultorio.id}">${consultorio.numero}</form:option>
              </c:forEach>
          </form:select>

          <form:label path="doctor">Doctor: </form:label>
          <form:select path="doctor">
              <c:forEach items="${listDoctores}" var="doctor">
                  <form:option value="${doctor.id}">${doctor.nombre} ${doctor.apellidoParterno} ${doctor.apellidoMaterno}</form:option>
              </c:forEach>
          </form:select>

          <form:label path="fecha">Fecha: </form:label>
          <form:input type="date" id="fecha" path="fecha"/>

          <form:label path="horaInicio">Hora Inicio: </form:label>
          <form:input type="time" id="horaInicio" path="horaInicio"/>

          <form:label path="horaFin">Hora Fin: </form:label>
          <form:input type="time" id="horaFin" path="horaFin"/>

          <form:label path="nombrePaciente">Nombre Paciente: </form:label>
          <form:input type="text" id="nombrePaciente" path="nombrePaciente"/>

          <form:label path="apPaternoPaciente">Apellido Paterno Paciente: </form:label>
          <form:input type="text" id="apPaternoPaciente" path="apPaternoPaciente" />

          <form:label path="apMaternoPaciente">Apellido Materno Paciente: </form:label>
          <form:input type="text" id="apMaternoPaciente" path="apMaternoPaciente"/>

          <input type="submit" value="agendar"/>
      </form:form>
    </body>
</html>