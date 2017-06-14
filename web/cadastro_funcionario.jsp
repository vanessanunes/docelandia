<html>
    <%@include file="topo.jsp" %>
    <title>Funcionario</title>
  
    <body>
        
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
                            document.getElementById("lagradouro").value = "";
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
        
        
        
    </body>

    <br><br>
        <h1>Funcionário</h1>
        
      
        <form class="form-horizontal"  name="cadastro" action="ControleFuncionario" method="post">
           

    
               <div class="form-group">
  <label class="col-md-4 control-label" for="nome">Nome</label>  
  <div class="col-md-4">
  <input id="nome" name="nome" type="text" placeholder="Nome Completo" class="form-control input-md">

  </div>
</div
            
    
          <!-- Senha -->
<div class="form-group">
  <label class="col-md-4 control-label" for="senha">Senha</label>  
  <div class="col-md-4">
      <input id="senha" name="senha" type="password" placeholder="senha" class="form-control input-md">
 
  </div>
</div>
         
     

  <!-- Usuario -->
<div class="form-group">
  <label class="col-md-4 control-label" for="funcao">Função</label>  
  <div class="col-md-4">
  <input id="funcao" name="funcao" type="text" placeholder="funcao" class="form-control input-md">
   </div>
</div>
  
  
          
         <!-- CPF-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cpf">CPF</label>  
  <div class="col-md-4">
  <input id="cpf" name="cpf" type="text" placeholder="CPF" class="form-control input-md">
 
  </div>
</div>
         
         <!-- Data de nascimento-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">Data de Nascimento</label>  
  <div class="col-md-4">
  <input id="dt_nasc" name="dt_nasc" type="date" placeholder="Data de Nascimento" class="form-control input-md">

  </div></div>
  
<!-- E-mail-->
<div class="form-group">
  <label class="col-md-4 control-label" for="nome">E-mail</label>  
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md">
   </div>
</div>


<!-- E-mail-->
<div class="form-group">
  <label class="col-md-4 control-label" for="sexo">sexo</label>  
  <div class="col-md-4">
  <input id="sexo" name="sexo" type="text" placeholder="sexo" class="form-control input-md">
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
      <input id="lagradouro" name="lagradouro" type="text" placeholder="lagradouro"class="form-control input-md" value="">
    
            
 
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
      <input id="estado" name="uf" type="text" placeholder="estado" class="form-control input-md">
          
 
  </div>
</div>

<div class="form-group">

    <label for="tipo_end" class="col-md-4 control-label">Tipo endereço </label>
    <div class="col-md-4">
    <select class="form-control" id="tipo_end" name="tipo_end" required=""> 
        <option value="0"> --- </option> 
        <option value="1"> Casa </option> 
        <option value="2"> Amigo </option> 
        <option value="3"> Vizinho </option>
        <option value="4"> Recado </option> 
    </select> </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="numero_tel">Numero tel:</label>  
  <div class="col-md-4">
      <input id="numero_tel" name="numero_tel" type="text" placeholder="numero" class="form-control input-md">
          
 
  </div>
</div>
      

<div class="form-group">

    <label for="tipo_tel" class="col-md-4 control-label">Tipo tel </label>
    <div class="col-md-4">
    <select class="form-control" id="tipo_tel" name="tipo_tel" required=""> 
        <option value="0"> --- </option> 
        <option value="1"> Pessoal</option> 
        <option value="2"> Residencia </option> 
        <option value="3"> Comercial </option>
        <option value="4"> Recado </option> 
    </select> </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="descricao">Descrição</label>  
  <div class="col-md-4">
      <input id="descricao" name="descricao" type="text" placeholder="descricao" class="form-control input-md" >
    
            
 
  </div>
</div>



<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" >---</label>
  <div class="col-md-4">
      <input type="hidden" name="flag" value="cadastro">
    <button type="submit" name="flag" class="btn btn-primary">Enviar</button>
  </div>
</div>
         </form>
        </div>        
    </body>
</html>
