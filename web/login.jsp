<%-- 
    Document   : login
    Created on : 01-06-2020, 10:39:39 PM
    Author     : Lizet claudia suxo c.i. 13088412
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Administrador</h1>
        <form action="LoginControlador" method="post">
            <label>Usuario</label>
            <input type="text" name="usuario">
            <br>
            <label>Password</label>
            <input type="password" name="password">
            <br><br>
            <input type="submit" value="Ingresar">
        </form>
    </body>
</html>
