<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Cadastro</title>
    </head>
    <body>
        <h1>Cadastro:</h1>
        <form name="cadastro" action="ControleCliente" method="post">
            <label for="nome">Nome: </label>
            <br>
            <input type="text" name="nome" id="nome" />
            <br><br>
            <label for="nome">Email: </label>
            <br>
            <input type="email" name="email" id="email" />
            <br><br>
            <label for="nome">Senha: </label>
            <br>
            <input type="password" name="senha" id="senha" />
            <br><br>
            
            <label for="nome">CPF: </label>
            <br>
            <input type="text" name="cpf" id="cpf" />
            <br><br>

            <label for="nome">Data de NascimentO; </label>
            <br>
            <input type="text" name="dt_nasc" id="dt_nasc" />
            <br><br>

            <label for="nome">Sexo; </label>
            <br>
            <input type="radio" name="sexo" value="m"> Homi<br>
            <input type="radio" name="sexo" value="f"> Muié<br>
            <br><br>
            <input type="hidden" name="flag" value="cadastro"> 
            <input type="submit" value="Enviar"/>
        </form>
        <%
            System.out.print("cadastro.jsp");
        %>
    </body>
</html>
