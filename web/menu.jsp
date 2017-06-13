
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>

<!-- inclui a barra superior -->
<%@include file="topo1.jsp" %>

<%
    try {
        String user = request.getParameter("user");
        String senha = request.getParameter("senha");
        
        if(user.equals("") || senha.equals("")){
            response.sendRedirect("login.jsp");
        }
        else{
            
        }
        
%>

<script type="text/javascript">
    function conta(str)
    {
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function ()
        {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            {
                document.getElementById("totMsg").innerHTML = xmlhttp.responseText;
            }
        };

        xmlhttp.open("GET", "novasMensagens.jsp", true);
        xmlhttp.send();
    }

    conta(); // This will run on page load
    setInterval(function () {
        conta();
    }, 15000);

</script>
<div style="margin-top: 200px"></div>
<div class="container col-md-4 col-md-offset-4">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="panel-title h1"><%= titulo%></h2>
        </div>
        <div class="panel-body">
            <h3>Aqui vai algo</h3>
        </div>                        
    </div>
</div>            
<%
} catch (Exception e) {
%>
<div style="margin-top: 200px"></div>
<div class="container col-md-4 col-md-offset-4">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="panel-title h1">Olá, seja bem vindo a Docêlandia!</h2>
        </div>
        <div class="panel-body">
            <p>Bem vindo a central do usuario de Docelandia.
                Utilize as opções do menu para funcionamento.</p>
        </div>                        
    </div>
</div>
<%
    }
%>
</body>
</html>
