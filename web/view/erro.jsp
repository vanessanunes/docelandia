<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.FuncionarioDAO"%>
<%@page import="beans.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste</title>
    </head>
    <body>
        <% 
            try{          
            String primaria;
            primaria = request.getAttribute("chave").toString();
            
            FuncionarioDAO funcDAO = new FuncionarioDAO();
            List<Funcionario> listaFuncionario = funcDAO.Pesquisar(Integer.parseInt(primaria));
            
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                                
        %>
        <h1>Tetando os redirecionamento: </h1><br><br>
        <table border="1px">
            <tr>
                <td><b>ID</b></td>
                <td><b>Nome</b></td>
                <td><b>Data de nascimento</b></td>
            </tr>
            <% for(Funcionario func: listaFuncionario){%>
            <tr>
                <td><%= func.getId_func() %></td>
                <td><%= func.getNome() %></td>
                <td><%= fmt.format(func.getData_nasc().getTime()) %></td>
            </tr>
        <%
            }
        }catch(Exception e){
            out.print("<b>Erro: </b>" + e + "<br>");
        }
        %>
        </table>
    </body>
</html>
