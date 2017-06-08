<%@include file="topo.jsp" %>  
<link href="css/style.css" rel="stylesheet" type="text/css"/>
        	<div id="top_header">
                    <h3>Docelândia</h3>
                    .
          		<h5>Faça seu login Docelândia.</h5>
        	</div>
        
        <div id="inputs">
        	<form id='login' action='' method='post' accept-charset='UTF-8' style="margin-left:6px;">
				
				<input type='hidden' name='submitted' id='submitted' value='1'/>

				<div class='container'>
					<input type='text' name='username' id='username' value='' maxlength="50" size="30" placeholder="Usuario"/><br/>
				</div>
				
				<div class='container'>
					<input type='password' name='password' id='password' maxlength="50" size="30" placeholder="Senha" /><br/>
				</div>
				
				<div class='container'>
					<input type='submit' name='Submit' value='Login' />
				</div>

			</form>

	        <div id="bottom">
	         
                  <a href="cadastro_cliente.jsp">Crie sua conta</a>
	          <a class="right_a" href="#">Esqueçeu sua senha?</a>
	        </div>
        </div>
    
<%@include file="footer.jsp" %> 