<%-- 
    Document   : lista_logins
    Created on : 06/06/2017, 23:50:38
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Logins</title>
    </head>
    <body>
        <table>
            <h1>Alunos Cadastrados</h1>
            <thead>
                <tr>
                    <th>ID Login</th>
                    <th>Nome de usuario</th>
                    <th>Senha</th>
                    <th>Tipo de usuario</th>
                    <th>ID do usuario</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="logins" items="${logins}">
                    <tr>
                        <td>${log.id_log}</td>
                        <td>${log.nome_user}</td>
                        <td>${log.senha}</td>
                        <td>${log.tipo_user}</td>
                        <td>${log.id_user}</td>                    
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
