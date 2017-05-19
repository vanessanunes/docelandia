/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Variável que receberá o valor da flag enviado pelo formulário
        String flag = request.getParameter("flag");
        
        try (PrintWriter out = response.getWriter()) {
//            if (flag == null) {
//                request.getRequestDispatcher("index.html").
//                        forward(request, response);
//            }
            
            switch (flag) {
                case "login":
                    String usuario = request.getParameter("login");
                    String senha = request.getParameter("senha");
                    System.out.print(("entramos no controller, flag " + flag));
                    System.out.print(("Usuario: " + usuario));
                    System.out.print(("Senha: " + senha));
                    
                    Login login = new Login();
                    login.setLogin(usuario);
                    login.setSenha(senha);
//                    fazer verificação de erro
//                    vai ter que passar pelo DAO
                     // Coloca os dados do cliente VÁLIDO numa session
                    request.setAttribute("user", login);
                    String lg;
                    lg = request.getAttribute("user").toString();
                    System.out.print("login: " + login);
                    System.out.print("lg: " + lg);
                    // Redireciona para a View
                    
                    request.getRequestDispatcher("index.jsp").
                            forward(request, response);
                    
                    
                    
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
