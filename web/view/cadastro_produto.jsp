<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produto</title>
    </head>
    <body>
        <h1>Cadastro de Produto</h1>
        <form action="ControleProduto" method="post">
            <label for="nome_pro">Nome do Produto:</label>
            <br>
            <input type="text" id="nome_pro" name="nome_pro" />
            <br>
            <br>
            <label for="descricao">Descrição do Produto:</label>
            <br>
            <input type="text" id="descricao" name="descricao" />
            <br>
            <br>
            <label for="preco">Preco do Produto:</label>
            <br>
            <input type="text" id="preco" name="preco" />
            <br>
            <br>
            <label for="quantidade">Quantidade do Produto:</label>
            <br>
            <input type="text" id="quantidade" name="quantidade" />
            <br>
            <br>
            <label for="cat_pro">Categoria:</label>
            <select>
                <option value="1">Bolo</option>
                <option value="2">Pães</option>
                <option value="3">Drinks?</option>
                <option value="4">Cus?</option>
            </select>
            <br>
            <br>
            <input type="hidden" name="flag" value="cad_pro" /> 
            <input type="submit" value="Enviar" />
        </form>
        
    </body>
</html>
