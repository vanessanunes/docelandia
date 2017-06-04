<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagem</title>
    </head>
    <body>
        <h1>Mensagem:</h1>
        <% 
            String mensagem = "veer como pegar a mensagem do controler nesse caraleo";
            out.print("<p>"+mensagem+"</p>");
        %>
    </body>
</html>
