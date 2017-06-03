
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionario</title>
    </head>
    <body>
        <h1>Cadastro de Funcionário</h1>
        <form name="func" action="../ControleFuncionario" method="post">
            <label for="nome">Nome: </label>
            <br>
            <input name="nome" id="nome" />
            <br>
            <br>
            <label for="funcao">Função: </label>
            <br>
            <input name="funcao" id="funcao" />
            <br>
            <br>
            <label for="cpf">CPF: </label>
            <br>
            <input name="cpf" id="cpf" />
            <br>
            <br>
            <label for="dt_nasc">Data de Nascimento: </label>
            <br>
            <input name="dt_nasc" id="dt_nasc" />
            <br>
            <br>
            <label for="email">Email: </label>
            <br>
            <input name="email" id="email" />
            <br>
            <br>
            <input type="hidden" name="flag" value="cadastro" />
            <input type="submit" value="Enviar" />
            
            
        </form>
    </body>
</html>
