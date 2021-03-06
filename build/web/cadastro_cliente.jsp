<%@include file="topo.jsp" %>
<html lang="pt-br">
        <script type="text/javascript">

            function buscaCep(varCep) {
                // Verifica se o campo CEP foi preenchido
                if (varCep.length == 0) {
                    // N�o realiza a busca
                    console.log('Busca n�o realizada');
                    return;
                }
                // Verifica se o recurso est� dispon�vel
                if (window.XMLHttpRequest) {
                    // C�digo para IE7+, Firefox, Chrome, Opera, Safari, etc
                    // Se estiver, cria um novo objeto XMLHttpRequest
                    xmlhttp = new XMLHttpRequest();
                } else {
                    // C�digo para IE6, IE5
                    // Cria��o do objeto baseado em ActiveX
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                // Coloca o m�todo em estado de "aten��o", ou seja, 
                // fica aguardando uma a��o
                xmlhttp.onreadystatechange = function ()
                {
                    // Verifica se o status da requisi��o est� funcionando
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        // Declara uma vari�vel para receber a resposta da requisi��o
                        var resposta = JSON.parse(xmlhttp.responseText);
                        // Verifica se o endere�o existe para o CEP informado
                        if (resposta.resultado != 0){
                            // Abaixo s�o configurados os elementos <span> 
                            // para receber os dados originados da requisi��o
                            var lagradouro = resposta.tipo_logradouro + " " + resposta.logradouro;
//                            document.getElementById("tipo_logradouro").innerHTML = resposta.tipo_logradouro;
                            document.getElementById("lagradouro").value = lagradouro;
                            document.getElementById("bairro").value = resposta.bairro;
                            document.getElementById("cidade").value = resposta.cidade;
                            document.getElementById("estado").value = resposta.uf;
                            // Limpa o campo de erro, caso ele esteja preenchido
                            document.getElementById("erro").innerHTML = "";

                        } else {
                            // Emite uma mensagem de erro caso o endere�o relacionado ao CEP n�o existir
                            document.getElementById("erro").innerHTML = "CEP n�o localizado!";
                            // Limpa os campos de exibi��o, caso haja algum valor neles
                            document.getElementById("tipo_logradouro").value = "";
                            document.getElementById("lagradouro").value = "";
                            document.getElementById("bairro").value = "";
                            document.getElementById("cidade").value = "";
                            document.getElementById("estado").value = "";
                        }
                    }
                }
                // Realiza a montagem da URL requisitada, concatenando o valor a ser procurado, passado como par�metro
                xmlhttp.open("GET", "http://cep.republicavirtual.com.br/web_cep.php?formato=json&cep=" + varCep, true);
                // Executa a requisi��o AJAX
                xmlhttp.send();
            }

        </script>
        
        
              
</head>

    <h2> Cadastro Cliente</h2>
    <form class="form-horizontal" name="cadastro" action="ControleCliente" method="post">
<fieldset>

    <link href="css/cadastro.css" rel="stylesheet" type="text/css"/>

 
        <div class="form-group">
  <label class="col-md-4 control-label" for="nome">Nome:</label>  
  <div class="col-md-4">
  <input id="nome" name="nome" type="text" placeholder="Nome Completo" class="form-control input-md">

  </div>
</div>

<!-- E-mail-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">E-mail</label>  
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md">
   </div>
</div>

<!-- Senha -->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">Senha</label>  
  <div class="col-md-4">
      <input id="senha" name="senha" type="password" placeholder="senha" class="form-control input-md">
 
  </div>
</div>

<!-- CPF-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">CPF</label>  
  <div class="col-md-4">
  <input id="cpf" name="cpf" type="text" placeholder="CPF" class="form-control input-md">
 
  </div>
</div>

<!-- Data de nascimento-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">Data de Nascimento</label>  
  <div class="col-md-4">
  <input id="dt_nasc" name="dt_nasc" type="date" placeholder="Data de Nascimento" class="form-control input-md">
  
  </div>
</div>
<!--CEP -->
<div class="form-group">
  <label class="col-md-4 control-label" for="cep">CEP</label>  
  <div class="col-md-4">
      
      <input id="cep" name="cep" type="text" class="form-control input-md" onchange="buscaCep(this.value);" >&nbsp;
      <a href="#">Pesquisar</a><br><br>
            <span id="erro"></span>
            
 
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="lagradouro">Logradouro</label>  
  <div class="col-md-4">
      <input id="lagradouro" name="lagradouro" type="text" placeholder="CEP"class="form-control input-md" value="">
    
            
 
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="numero">Numero</label>  
  <div class="col-md-4">
      <input id="numero" name="numero" type="text" placeholder="Numero" class="form-control input-md">
    
           
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="numero">Complemento</label>  
  <div class="col-md-4">
      <input id="complemento" name="complemento" type="text" placeholder="complemento" class="form-control input-md">
    
            
 
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="bairro">Bairro</label>  
  <div class="col-md-4">
      <input id="bairro" name="bairro" type="text" placeholder="bairro" class="form-control input-md">
    
            
 
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="cidade">Cidade</label>  
  <div class="col-md-4">
      <input id="estado" name="cidade" type="text" placeholder="cidade" class="form-control input-md">
    
            
 
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="estado">Estado</label>  
  <div class="col-md-4">
      <input id="estado" name="estado" type="text" placeholder="estado" class="form-control input-md">
    
            
 
  </div>
</div>





<div class="form-group">
  <label class="col-md-4 control-label" for="nome">Sexo</label>
  <div class="col-md-4">
  <div class="radio">
    <label for="nome">
      <input type="radio" name="sexo" id="sexo" value="m" >
     Homem
    </label>
	</div>
  <div class="radio">
    <label for="nome">
      <input type="radio" name="sexo" id="sexo" value="f">
      Mulher
    </label>
	</div>
  </div>
</div>
        
        
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" >Enviar</label>
  <div class="col-md-4">
      <input type="hidden" name="flag" value="cadastro">
    <button type="submit" name="flag" class="btn btn-primary">Enviar</button>
  </div>
</div>





</fieldset>
</form>



</body>
</html>


