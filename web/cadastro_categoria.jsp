<%@include file="topo.jsp" %>
        <h1>Cadastro de Categoria</h1>
        
        <form action="../ControleProduto" method="post">
            <label for="nome_cat">Nome da Categoria</label>
            <br>
            <input type="text" id="nome_cat" name="nome_cat" />
            <br>
            <br>
            <label for="descricao">Descri��o da Categoria:</label>
            <br>
            <input type="text" id="descricao" name="descricao" />
            <br>
            <br>
            <input type="hidden" name="flag" value="cad_cat" /> 
            <input type="submit" value="Enviar" />
        </form>

        <%@include file="footer.jsp" %>