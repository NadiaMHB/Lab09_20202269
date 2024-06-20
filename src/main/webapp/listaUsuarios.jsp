<%@page import="java.util.ArrayList" %>
<%@ page import="org.example.lab9_20202269.beans.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("lista"); %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista usuarios operativos</title>
</head>
<body>
<div class='container'>
    <div class="row mb-5 mt-4">
        <div class="col-md-7">
            <h1>Lista de usuarios operativos</h1>
        </div>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Tipo de licencia</th>
            <th>Estado de la licencia</th>
            <th>País de procedencia</th>
            <th>Reservas canceladas</th>

        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            for (Usuario u : lista) {
        %>
        <tr>
            <td><%= i%>
            </td>
            <td><%= u.getNombres()%>
            </td>
            <td><%= u.getApellidos()%>
            </td>
            <td><%= u.getTipoLicencia()%>
            </td>
            <td><%= u.getEstadoLicencia()%>
            </td>
            <td><%= u.getEstadoLicencia()%>
            </td>
            <td><%= u.getPaisProcedencia()%>
            </td>
            <td>
            </td>
            <% } %>
        </tr>
        <%
                i++;
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
