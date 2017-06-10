package controlers;

import beans.Cliente;
import beans.Funcionario;
import beans.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ClienteDAO;
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
        
        String user = request.getParameter("user");
        String senha = request.getParameter("senha");
        
        Utilidades u = new Utilidades();
        
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
                                               
                        
                        if(logDAO.getTotalRegistros() >= 1){
                            System.out.print("Login encontrado");
                            int tipo = 0;
                            int primaria = 0;
                            
                            List<Login> listaLogin = logDAO.getLogin(user, senha);
                            
                            for(Login login: listaLogin){
                                tipo = login.getTipo_user();
                                primaria = login.getId_user();                             
                            }
                            
                            if (tipo == 1){
                                ClienteDAO clieDAO = new ClienteDAO();
                                String nome="";
                                                             
                                List<Cliente> listaCliente = clieDAO.Pesquisar(primaria);
                                
                                for(Cliente clie: listaCliente){
                                    nome = clie.getNome();
                                }
                         
                                
                            }
                            
                            else if (tipo == 2){                             
                                request.setAttribute("chave", primaria);
                                request.getRequestDispatcher("view/erro.jsp").
                                forward(request, response);
                            }
                            
                        }
                        else
                            System.out.print("Login não encontrado");
                        
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
