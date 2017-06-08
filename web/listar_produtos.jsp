<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.ProdutoDAO"%>
<%@page import="beans.Produto"%>
<%@include file="topo.jsp" %>

<h1>Lista de produto</h1>
<%
    try{
        ProdutoDAO proDAO = new ProdutoDAO();
        List<Produto> produtos = proDAO.listaTodosProdutos();
        %>

<h2 class="panel-title h1">Total de Produtos Cadastrados: <%= proDAO.getTotalRegistros()%></h2>

<% 
        if (proDAO.getTotalRegistros() < 1) {
            out.print(proDAO.getCriterios());
        } else {
            for (Produto produto : produtos) {
%>
<h2><%= produto.getNome()%></h2>
    <img src="<%= produto.getImagem()%>" />
    <br>
    <%= produto.getDescricao() %>
    <br>
    R$ <%= produto.getPreco() %>
    
    <br><br>
<%
    }
        }
    } catch (Exception e) {
    }
%>



        
        
<%@include file="footer.jsp" %>
