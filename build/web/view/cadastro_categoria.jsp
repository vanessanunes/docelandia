<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Categoria</title>
    </head>
    <body>
        <h1>Cadastro de Categoria</h1>
        
        <form action="../ControleProduto" method="post">
            <label for="nome_cat">Nome da Categoria</label>
            <br>
            <input type="text" id="nome_cat" name="nome_cat" />
            <br>
            <br>
            <label for="descricao">Descrição da Categoria:</label>
            <br>
            <input type="text" id="descricao" name="descricao" />
            <br>
            <br>
            <input type="hidden" name="flag" value="cad_cat" /> 
            <input type="submit" value="Enviar" />
        </form>
    </body>
    
</html>
