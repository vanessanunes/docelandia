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
        <form action="../ControleLogin" method="post">
            <b>Username:</b><br>
            <input type="text" name="user"/><br><br>
            <b>Senha:</b><br>
            <input type="password" name="senha"/><br><br>
            <input type="submit" value="Entrar"/>
            <input type="hidden" name="flag" value="login">
        </form>
    </body>
</html>
