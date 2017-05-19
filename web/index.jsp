<%@page import="beans.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>pagina index</h1>
        A pessoa está logada?
        <br>
        <%
//            Login lg = new Login();
//            String lg;
//            lg = session.getAttribute("user").toString();
//            out.print(lg);
            if (session.getAttribute("user") == null || session.getAttribute("user") == ""){
                out.print("Não está logado - "
                        + "clique para fazer login: <a href='login.jsp'>login</a>");
                session.setAttribute("user", false);
            } else {
                out.print("Está logado, deseja <a href='sair.jsp'>sair?</a>");
                String lg;
                lg = session.getAttribute("user").toString();
                out.print(lg);
            }
            
            System.out.print("A session: " + session.getAttribute("user").toString());
        %>
    </body>
</html>
