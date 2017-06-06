<%-- 
    Document   : cadastro_telefone
    Created on : 04/06/2017, 23:03:17
    Author     : Vanessa.Nunes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de telefone - teste</h1>
        <form name="cadastro" action="../ControleCliente" method="post">
            <label for="tipo_tel">Tipo de telefone:</label>
            <select name="tipo">
                <option value="1">Pessoal</option>
                <option value="2">Residencial</option>
                <option value="3">Comercial</option>
                <option value="4">Recado</option>
            </select><br><br>
            <label for="nome">Número:</label>
            <br>
            <!--Só mexi um pouquinho ;p - by Bruno-->
            <input type="text" name="num_tel" id="num_tel" />
            <br>
            <label for="descricao">Descrição:</label><br>
            <input type="text" name="descricao"/>
            <br><br>
            <input type="hidden" name="flag" value="cad_tel"> 
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
