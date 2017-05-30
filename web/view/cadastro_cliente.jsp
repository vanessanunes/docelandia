<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Cadastro</title>
        <!-- Criação de uma função em JavaScript -->

        <script type="text/javascript">

            function buscaCep(varCep) {
                // Verifica se o campo CEP foi preenchido
                if (varCep.length == 0) {
                    // Não realiza a busca
                    console.log('Busca não realizada');
                    return;
                }
                // Verifica se o recurso está disponível
                if (window.XMLHttpRequest) {
                    // Código para IE7+, Firefox, Chrome, Opera, Safari, etc
                    // Se estiver, cria um novo objeto XMLHttpRequest
                    xmlhttp = new XMLHttpRequest();
                } else {
                    // Código para IE6, IE5
                    // Criação do objeto baseado em ActiveX
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                // Coloca o método em estado de "atenção", ou seja, 
                // fica aguardando uma ação
                xmlhttp.onreadystatechange = function ()
                {
                    // Verifica se o status da requisição está funcionando
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        // Declara uma variável para receber a resposta da requisição
                        var resposta = JSON.parse(xmlhttp.responseText);
                        // Verifica se o endereço existe para o CEP informado
                        if (resposta.resultado != 0){
                            // Abaixo são configurados os elementos <span> 
                            // para receber os dados originados da requisição
                            var lagradouro = resposta.tipo_logradouro + " " + resposta.logradouro;
//                            document.getElementById("tipo_logradouro").innerHTML = resposta.tipo_logradouro;
                            document.getElementById("lagradouro").value = lagradouro;
                            document.getElementById("bairro").value = resposta.bairro;
                            document.getElementById("cidade").value = resposta.cidade;
                            document.getElementById("estado").value = resposta.uf;
                            // Limpa o campo de erro, caso ele esteja preenchido
                            document.getElementById("erro").innerHTML = "";

                        } else {
                            // Emite uma mensagem de erro caso o endereço relacionado ao CEP não existir
                            document.getElementById("erro").innerHTML = "CEP não localizado!";
                            // Limpa os campos de exibição, caso haja algum valor neles
                            document.getElementById("tipo_logradouro").value = "";
                            document.getElementById("logradouro").value = "";
                            document.getElementById("bairro").value = "";
                            document.getElementById("cidade").value = "";
                            document.getElementById("estado").value = "";
                        }
                    }
                }
                // Realiza a montagem da URL requisitada, concatenando o valor a ser procurado, passado como parâmetro
                xmlhttp.open("GET", "http://cep.republicavirtual.com.br/web_cep.php?formato=json&cep=" + varCep, true);
                // Executa a requisição AJAX
                xmlhttp.send();
            }

        </script>
    </head>
    <body>
        <h1>Cadastro:</h1>
        <form name="cadastro" action="../ControleCliente" method="post">
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


            <label for="cep">CEP:</label>
            <br>
            <input type="text" id="cep" name="cep" onchange="buscaCep(this.value);">&nbsp;
            <a href="#">Pesquisar</a><br><br>
            <span id="erro"></span>
            
            <br>
            <label for="lagradouro">Lagradouro: </label>
            <br>
            <input type="text" name="lagradouro" id="lagradouro" value=""/>
            <br><br>
            <label for="numero">Número: </label>
            <br>
            <input type="text" name="numero" id="numero" />
            <br><br>
            <label for="numero">Complemento: </label>
            <br>
            <input type="text" name="complemento" id="complemento" />
            <br> <br>
            <label for="bairro">Bairro: </label>
            <br>
            <input type="text" name="bairro" id="bairro" />
            <br> <br>
            <label for="cidade">Cidade: </label>
            <br>
            <input type="text" name="cidade" id="cidade" />
            <br> <br>
            <label for="estado">Estado: </label>
            <br>
            <input type="text" name="estado" id="estado" />
            <br><br>
            <label for="numero">Ponto de Referência: </label>
            <br>
            <input type="text" name="numero" id="numero" />


        </form>
        <%
            System.out.print("cadastro.jsp");
        %>
    </body>
</html>
