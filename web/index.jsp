<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Blog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
List<Blog> lista = (List<Blog>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>BLOG </h1>
        </font>
        <style type="text/css">
	
        </style>
        <nav>
		<ul>
			<li><a href="MainController?op=nuevo">Nueva entrada</a></li>
			<li><a href="LoginControlador?action=logout">Administrador</a></li>
		</ul>
	 </nav>
        
        <section> 
            
            <article>
                <c:forEach var="blog" items="${lista}">
                
                    
                    <p>${blog.fecha}</p>
                    <h2>${blog.titulo}</h2>
                    <h4>${blog.contenido}</h4>
                    
                 
 <p ><a href="#">Leer</a></p>                  
 <p ><a href="MainController?op=editar&id=${blog.id}">Editar</a></p>
 <p ><a href="MainController?op=eliminar&id=${blog.id}"onclick="return(confirm('esta seguro??'))">Eliminar</a></p>

                
             </article>  
         <hr>
        </section>
       </c:forEach>
           </font>
    </body>
</html>
