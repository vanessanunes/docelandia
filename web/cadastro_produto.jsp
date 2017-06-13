<html>

    <head>
        
        
                <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  
        
      <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Painel de administracao </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="cadastro_produto.jsp">Produto</a></li>
                       <li><a href="">Gerenciar dados </a></li>
          

          </ul>

          </form>
        </div>
      </div>
    </nav>
    
    
    
    </head>
    <br><br>
    <body>
        <h1>Cadastro de Produto</h1>
        <form action="../ControleProduto" method="post">

                
            
            
<div class="form-group">
<label for="nome_pro">Nome do Produto</label> <input class="form-control" id="nome_pro" name="nome_pro" placeholder="Informe o nome do produto" required="" type="text" /> </div>

<div class="row">
<div class="col-md-3">
<div class="form-group">
<label for="descricao">Descrição do Produto</label> <input class="form-control" id="descricao" name="descricao" placeholder="Informe a descricao" required="" type="text" /> </div>
</div>
<div class="col-md-7">
<div class="form-group">
<label for="preco">Preço do Produto</label> <input class="form-control" id="preco" name="preco" placeholder="Informe o preço" required="" type="text" /> </div>
</div>

<div class="col-md-2">
<label for="cat_pro">Categoria </label> <select class="form-control"> <option value="0"> --- </option> <option value="1"> Bolo </option> <option value="2"> Paes </option> <option value="3"> drinks </option>  <option value="4"> nada </option> </select> </div>
</div>
<div class="row">
<div class="col-md-6">
<div class="form-group">
<label for="quantidade">Quantidade do Produto</label> <input class="form-control" id="quantidade" name="quantidade" placeholder="Informe a quantidade" required="" type="text" /> </div>
</div>
</div>
            
            <!-- Button -->
<div class="form-group">
  
      <input type="hidden" name="flag" value="cad_prod">
    <button type="submit" name="flag" class="btn btn-primary">Enviar</button>
  </div>
            
            
        </form>

</body>
</html>