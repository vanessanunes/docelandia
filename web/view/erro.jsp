<%-- 
    Document   : erro.jsp
    Created on : 05/06/2017, 21:42:00
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>
        <h1>Tela inutil que mosta se tem erro ;p</h1>
        <%
            out.print(request.getAttribute("erro"));
        %>
    </body>
</html>
