<%@include file="topo.jsp" %>
        <h1>Cadastro de Produto</h1>
        <form action="../ControleProduto" method="post">
            <label for="nome_pro">Nome do Produto:</label>
            <br>
            <input type="text" id="nome_pro" name="nome_pro" />
            <br>
            <br>
            <label for="descricao">Descri��o do Produto:</label>
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
                <option value="2">P�es</option>
                <option value="3">Drinks?</option>
                <option value="4">Cus?</option>
            </select>
            <br>
            <br>
            <input type="hidden" name="flag" value="cad_prod" /> 
            <input type="submit" value="Enviar" />
        </form>
<%@include file="footer.jsp" %>