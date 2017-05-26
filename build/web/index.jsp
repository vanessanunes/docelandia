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
            String lg;
            if (session.getAttribute("user") == null || session.getAttribute("user") == ""){
                out.print("Não está logado - "
                        + "clique para fazer login: <a href='login.jsp'>login</a>");
//                session.setAttribute("user", false);
            } else {
                out.print("Está logado, deseja <a href='view/logout.jsp'>sair?</a>");
                lg = session.getAttribute("user").toString();
                out.print(lg);
                System.out.print("na página index: " + lg);
            }
//            lg = session.getAttribute("user").toString();
//            System.out.print("A session no index é: " + session.getAttribute("user").toString());
        %>
    </body>
</html>
