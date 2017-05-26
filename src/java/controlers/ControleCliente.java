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
                    String nome = request.getParameter("nome");
                    senha = request.getParameter("senha"); 
                    email = request.getParameter("email"); 
                    String cpf = request.getParameter("cpf"); 
                    String dt_nasc = request.getParameter("dt_nasc"); 
                    String sexo = request.getParameter("sexo");
                    
                    try{
                        ClienteDAO clienteDAO = new ClienteDAO();
                        Cliente cliente = new Cliente();
                        cliente.setNome(nome);
                        cliente.setSenha(senha);
                        cliente.setEmail(email);
                        cliente.setCpf(cpf);
//                        depois ver como converter string para dt nasc
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        java.sql.Date data = new java.sql.Date(format.parse(dt_nasc).getTime());
                        cliente.setData_nasc(data);
                        cliente.setSexo(sexo);
                        clienteDAO.cadastraCliente(cliente);
                        
                    } catch (Exception e){
                        System.out.print("ControleCliente, flag cadastro: Caiu o catch!");
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
