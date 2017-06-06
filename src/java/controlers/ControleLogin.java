package controlers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.LoginDAO;
import utils.Utilidades;


public class ControleLogin extends HttpServlet {

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
        String flag = request.getParameter("flag");
        String mensagem = "";
        Utilidades u = new Utilidades();
        int id_gerada = u.getGeraNumero();
        
        try (PrintWriter out = response.getWriter()) {
            if (flag == null) {
                request.getRequestDispatcher("index.html").
                        forward(request, response);
            } 
            switch (flag) {
                case "login":
                    System.out.print("Controler login");
                    String email = request.getParameter("username");
                    String senha = request.getParameter("password");
                    System.out.print("Email: " +email+ " senha:" + senha);
                    try {
                        System.out.print("ControleCliente, flag login: bora pro dao");
                        LoginDAO loginDAO = new LoginDAO();
                        loginDAO.acessaLogin(email, senha);
                    } catch (Exception e){
                        System.out.print("ControleCliente, flag login: Caiu o catch!");
                    }
//                    página de exemplo, vamos ver depois pra onde vai isso!
                    request.getRequestDispatcher("acesso.jsp").
                            forward(request, response);
                    break;
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
