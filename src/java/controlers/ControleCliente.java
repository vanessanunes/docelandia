/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Cliente;
import beans.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ClienteDAO;
import models.LoginDAO;
import utils.Utilidades;

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
                    String email = request.getParameter("email");
                    String senha = request.getParameter("senha");
                    try {
                        ClienteDAO clienteDAO = new ClienteDAO();
                        clienteDAO.getLogin(email, senha);
                    } catch (Exception e){
                        System.out.print("ControleCliente, flag login: Caiu o catch!");
                    }
//                    página de exemplo, vamos ver depois pra onde vai isso!
                    request.getRequestDispatcher("acesso.jsp").
                            forward(request, response);
                case "cadastro":
                    System.out.print("ClienteControle");
                    String nome = request.getParameter("nome");
                    email = request.getParameter("email"); 
                    String cpf = request.getParameter("cpf"); 
                    senha = request.getParameter("senha"); 
                    String dt_nasc = request.getParameter("dt_nasc"); 
                    String sexo = request.getParameter("sexo");
                    System.out.print("Dados: \n"
                        +"nome: " +nome+
                            "\nemail: " + email +
                            "\ndt_nasc: " + dt_nasc +
                            "\nsexo: " + sexo);
                    Utilidades u = new Utilidades();
                    int id_gerada = u.geraNumero();
                    try{
                        ClienteDAO clienteDAO = new ClienteDAO();
                        Cliente cliente = new Cliente();
                        cliente.setId_clie(id_gerada);
                        cliente.setNome(nome);
                        cliente.setEmail(email);
                        cliente.setCpf(cpf);
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        java.sql.Date data = new java.sql.Date(format.parse(dt_nasc).getTime());
                        cliente.setData_nasc(data);
                        cliente.setSexo(sexo);
                        clienteDAO.cadastraCliente(cliente);
                        
                    } catch (Exception e){
                        System.out.print("ControleCliente, flag cadastro: Caiu o catch!");
                        System.out.print(e);
                    }
                    
                    try {
                        System.out.print("Estamos no login do Controle Cliente");
                        
                        Login login = new Login();
                        login.setId_log(id_gerada);
                        login.setNome_user(email);
                        login.setSenha(senha);
                        login.setTipo(1);
                        login.setId_fk(id_gerada);
                        
                        LoginDAO loginDAO = new LoginDAO();
                        loginDAO.cadastraLogin(login);
                    } catch (Exception e){
                        
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
