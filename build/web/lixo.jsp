<%-- 
    Document   : lixo
    Created on : 03/06/2017, 22:00:54
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
            out.print(request.getAttribute("erro").toString());
        %>
    </body>
</html>
