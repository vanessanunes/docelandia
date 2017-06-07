package controlers;

import beans.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.FuncionarioDAO;
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
        String status;
        
        String user = request.getParameter("username");
        String senha = request.getParameter("password");
        List<Login> logins;
        
        Utilidades u = new Utilidades();
        int id_gerada = u.getGeraNumero();
        
        try (PrintWriter out = response.getWriter()) {
            if (flag == null) {
                request.getRequestDispatcher("index.html").
                        forward(request, response);
            } 
            
            switch (flag) {
                case "login":
                    try {
                        LoginDAO logDAO = new LoginDAO();
                        logDAO.getLogin(user, senha);
                        Login log = new Login();
                        
                        if(logDAO.getTotalRegistros() >= 1){
                            System.out.print("Login encontrado");
                            logins = logDAO.listar();
                            
                            request.setAttribute("logins", logins);
                            
                            request.getRequestDispatcher("view/lista_logins.jsp").
                                forward(request, response);
                        }
                        else
                            System.out.print("Login não cadastrado");
                        
                    } catch (Exception e){
                        System.out.print("Erro na instancia DAO");
                        response.sendRedirect("view/erro.jsp");
                    }
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
