<html>
    <title>Funcionario</title>
    <body>
        <h1>Cadastro de Funcionário</h1>
        <form name="cadastro" action="ControleFuncionario" method="post">
            <b>Nome de usuario:</b><br>
            <input type="text" name="user"/><br><br>           
            <b>Senha:</b><br>
            <input type="password" name="senha"/><br><br>
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
            <label for="sexo">Sexo: </label><br>
            <input type="text" name="sexo"/>
            <br><br>
            <label for="tipo_tel">Tipo de endereço:</label><br>
            <select name="tipo_end">
                <option value="1">Casa</option>
                <option value="2">Amigo</option>
                <option value="2">Vizinho</option>
                <option value="2">Ricardão</option>
            </select><br><br>
            <b>CEP:</b><br>
            <input type="text" name="cep"/><br><br>
            <b>Lagradouro:</b><br>
            <input type="text" name="lagradouro"/><br><br>
            <b>Numero:</b><br>
            <input type="text" name="numero"/><br><br>
            <b>Bairro:</b><br>
            <input type="text" name="bairro"/><br><br>
            <b>Complemento:</b><br>
            <input type="text" name="complemento"/><br><br>
            <b>Cidade:</b><br>
            <input type="text" name="cidade"/><br><br>
            <b>UF:</b><br>
            <input type="text" name="uf"/><br><br>
            <b>Ponto Referencia:</b><br>
            <input type="text" name="ponto_ref"/><br><br>
            <b>Numero:</b><br>
            <input type="text" name="numero_tel"/><br><br>
            <label for="tipo_tel">Tipo de telefone:</label><br>
            <select name="tipo_tel">
                <option value="1">Pessoal</option>
                <option value="2">Residencial</option>
                <option value="2">Comercial</option>
                <option value="2">Recado</option>
            </select><br><br>
            <b>Descrição do Telefone:</b><br>
            <input type="text" name="descricao"><br><br>                
            <input type="hidden" name="flag" value="cadastro"> 
            <input type="submit" value="Cadastrar"/>
        </form>
        <br><br>
        
    </body>
</html>
