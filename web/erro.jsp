<%@include file="topo.jsp" %>

        <h1>Tela inutil que mosta se tem erro ;p</h1>
        <%
            out.print(request.getAttribute("erro"));
        %>
<%@include file="footer.jsp" %>