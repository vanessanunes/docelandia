/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Endereco;
import beans.Funcionario;
import beans.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.EnderecoDAO;
import models.FuncionarioDAO;
import models.LoginDAO;
import utils.Utilidades;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "ControleFuncionario", urlPatterns = {"/ControleFuncionario"})
public class ControleFuncionario extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {
            // Variável que receberá o valor da flag enviado pelo formulário
            String flag = request.getParameter("flag");
            String status;
                        
            String nome = request.getParameter("nome");
            String email = request.getParameter("email"); 
            String cpf = request.getParameter("cpf"); 
            String senha = request.getParameter("senha"); 
            String dt_nasc = request.getParameter("dt_nasc"); 
            String sexo = request.getParameter("sexo");
            String funcao = request.getParameter("funcao");
            
            String cep = request.getParameter("cep");
            String lagradouro = request.getParameter("lagradouro");
            String numero = request.getParameter("numero");
            String bairro = request.getParameter("bairro");
            String complemento = request.getParameter("complemento");
            String cidade = request.getParameter("cidade");
            String uf = request.getParameter("uf");
            String ponto_ref = request.getParameter("ponto_ref");
           
                        
            switch(flag){
                case "cadastro":
                    try{                    
                        Utilidades u = new Utilidades();
                        int id_gerada = u.getGeraNumero();
                        Funcionario funcionario = new Funcionario();
                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
//                        
                        funcionario.setId_func(id_gerada);
                        funcionario.setNome(nome);
                        funcionario.setEmail(email);
                        funcionario.setCpf(cpf);
                        funcionario.setFuncao(funcao);
                        try{
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        java.sql.Date data = new java.sql.Date(format.parse(dt_nasc).getTime());
                        funcionario.setData_nasc(dt_nasc);
                        }catch(Exception e){
                            response.sendRedirect("cadastro_cliente.jsp");
                        }
                        funcionario.setSexo(sexo);
                        
                        funcionarioDAO.cadastraFuncionario(funcionario);
                        status = funcionarioDAO.getStatus();
                        
                        request.setAttribute("status", status);
                        //response.sendRedirect("cadastro_funcionario.jsp");
                        
                    }catch(Exception ex){
                        Logger.getLogger(ControleFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
           
//        // Variável que receberá o valor da flag enviado pelo formulário
//        String flag = request.getParameter("flag");
//        String status = null;
//        
//        Funcionario funcionario = new Funcionario();
//        request.setAttribute("status", "estou aqui?");
//            switch (flag) {
//                case "login":
//                    String email = request.getParameter("email");
//                        String senha = request.getParameter("senha");
//                    try {
//                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
//                        funcionarioDAO.getLogin(email, senha);
//                        
//                    } catch (Exception e){
//                        System.out.print("Erro na instancia DAO");
//                    }
//                  
//                    
//                    break;
//                case "cadastro":
//                    request.setAttribute("status", "estou aqui?2");
//                    String nome = request.getParameter("nome");
//                    email = request.getParameter("email"); 
//                    String cpf = request.getParameter("cpf"); 
//                    senha = request.getParameter("senha"); 
//                    String dt_nasc = request.getParameter("dt_nasc"); 
//                    String sexo = request.getParameter("sexo");
//                    String funcao = request.getParameter("funcao");
//                    
//                    Utilidades u = new Utilidades();
//                    int id_gerada = u.getGeraNumero();
//                    
//                    try{
//                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
//                        
//                        funcionario.setId_func(id_gerada);
//                        funcionario.setNome(nome);
//                        funcionario.setEmail(email);
//                        funcionario.setCpf(cpf);
//                        funcionario.setFuncao(funcao);
//                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                        java.sql.Date data = new java.sql.Date(format.parse(dt_nasc).getTime());
//                        funcionario.setData_nasc(data);
//                        funcionario.setSexo(sexo);
//                        
//                        funcionarioDAO.cadastraFuncionario(funcionario);
//                        status = funcionarioDAO.getStatus();
//                        request.setAttribute("status", status);
//                        response.sendRedirect("cadastro_funcionario.jsp");
//                        
//                    } catch (Exception e){
//                        System.out.print("Erro no cadastro");
//                    }
//                    
//                    try {
//                        
//                        Login login = new Login();
//                        login.setId_log(id_gerada);
//                        login.setNome_user(email);
//                        login.setSenha(senha);
//                        login.setId_user(funcionario.getId_func());
//                        login.setTipo_user(2);
//                        
//                        LoginDAO loginDAO = new LoginDAO();
//                        loginDAO.cadastraLogin(login);
//                        
//                    } catch (Exception e){
//                        System.out.print("Cadastro de login falhou");
//                    }
//                    
//                    try{
//                        EnderecoDAO endDAO = new EnderecoDAO();
//                        Endereco end = new Endereco();
//                        
//                        end.setId_end(u.getGeraNumero());
//                        String cep = request.getParameter("cep");
//                        String lagradouro = request.getParameter("lagradouro");
//                        String numero = request.getParameter("numero");
//                        String bairro = request.getParameter("bairro");
//                        String complemento = request.getParameter("complemento");
//                        String cidade = request.getParameter("cidade");
//                        String uf = request.getParameter("uf");
//                        String ponto_ref = request.getParameter("ponto_ref");
//                        
//                                         
//                        end.setCep(cep);
//                        end.setLagradouro(lagradouro);
//                        end.setNumero(numero);
//                        end.setBairro(bairro);
//                        end.setComplemento(complemento);
//                        end.setCidade(cidade);
//                        end.setUf(uf);
//                        end.setPonto_ref(ponto_ref);
//                        end.setId_user(funcionario.getId_func());
//                        end.setTipo(2);
//                        
//                        endDAO.cadastraEndereco(end);
//                        status = endDAO.getStatus();
//                        request.setAttribute("status", status);
//                        response.sendRedirect("cadastro_funcionario.jsp");
//                        
//                        
//                        
//                    }catch(Exception e){
//                        System.out.println("Erro ao cadastrar endereco cliente");
//                    }
//                    
//            }
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


