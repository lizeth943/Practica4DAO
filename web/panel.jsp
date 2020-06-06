
<%
    if(session.getAttribute("logueado") != "OK"){
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Panel de administracion</h1>
        <p>Usuario:${sessionScope.usuario}</p>
        <p>Bienvenido </p>
        <br>
        <a href="MainController">Entrar</a>
    </body>
</html>
