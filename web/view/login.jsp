<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>login</h1>
        <form action="ControleCliente" method="post">
            Login:<br>
            <input type="email" id="email" name="email">
            <br> <br>
            Senha:<br>
            <input type="password" id="senha" name="senha">
            <br><br>
            <input type="hidden" name="flag" value="login"> 
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
