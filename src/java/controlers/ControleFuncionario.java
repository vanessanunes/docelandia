/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Endereco;
import beans.Funcionario;
import beans.Login;
import beans.Telefone;
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
import models.TelefoneDAO;
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
            
            // Variavel que recebe o status da conexão
            String status;
            
            // Valores para cadastro de funcionario
            String user = request.getParameter("user");
            String senha = request.getParameter("senha");
            
            String nome = request.getParameter("nome");
            String email = request.getParameter("email"); 
            String cpf = request.getParameter("cpf");             
            String dt_nasc = request.getParameter("dt_nasc"); 
            String sexo = request.getParameter("sexo");
            String funcao = request.getParameter("funcao");
            
            // Valores para cadastro de endereço
            //int tipo_end = Integer.parseInt(request.getParameter("tipo_end"));
            String cep = request.getParameter("cep");
            String lagradouro = request.getParameter("lagradouro");
            String numero = request.getParameter("numero");
            String bairro = request.getParameter("bairro");
            String complemento = request.getParameter("complemento");
            String cidade = request.getParameter("cidade");
            String uf = request.getParameter("uf");
            String ponto_ref = request.getParameter("ponto_ref");
            
            // Valores para cadastro de telefone
            //int tipo_tel = Integer.parseInt(request.getParameter("tipo"));
            String numero_tel = request.getParameter("num_tel");
            String descricao = request.getParameter("descricao");
            
            
            Funcionario funcionario = new Funcionario();
            Login log = new Login();
           
                        
            switch(flag){
                case "cadastro":
                    try{                    
                        Utilidades u = new Utilidades();
                        int id_gerada = u.getGeraNumero();
                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                        LoginDAO logDAO = new LoginDAO();
//                        
                        funcionario.setId_func(id_gerada);
                        funcionario.setNome(nome);
                        funcionario.setEmail(email);
                        funcionario.setCpf(cpf);
                        funcionario.setFuncao(funcao);                    
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        java.sql.Date data = new java.sql.Date(format.parse(dt_nasc).getTime());
                        funcionario.setData_nasc(data);                     
                        funcionario.setSexo(sexo);
                        
                        log.setId_log(id_gerada);
                        log.setNome_user(user);
                        log.setSenha(senha);
                        log.setId_user(funcionario.getId_func());
                        log.setTipo_user(2);
                        
                        logDAO.cadastraLogin(log);
                        funcionarioDAO.cadastraFuncionario(funcionario);
                        
                        status = logDAO.getStatus();
                        System.out.print("Status login: "+ status);
                        status = funcionarioDAO.getStatus();
                        System.out.print("Status funcionario: "+ status);
                        
                    }catch(Exception ex){
                        response.sendRedirect("view/erro.jsp");
                    }
                    break;
                        
                case "cad_endereco":
                    try{
                        Endereco end = new Endereco();
                        EnderecoDAO endDAO = new EnderecoDAO();
                        Utilidades util = new Utilidades();
                        
                        end.setId_end(util.getGeraNumero());
                        //end.setTipo(tipo_end);
                        end.setCep(cep);
                        end.setLagradouro(lagradouro);
                        end.setNumero(numero);
                        end.setBairro(bairro);
                        end.setComplemento(complemento);
                        end.setCidade(cidade);
                        end.setUf(uf);
                        end.setPonto_ref(ponto_ref);
                        end.setId_user(funcionario.getId_func());
                        end.setTipo_user(2);
                        
                        endDAO.cadastraEndereco(end);
                        System.out.print(endDAO.getStatus());
                        
                    } catch(Exception e){
                        System.out.print("Erro no cad_endereco " + e);
                        response.sendRedirect("view/erro.jsp");
                    }
                    break;
                case "cad_tel":
                    try{
                    Telefone tel = new Telefone();
                    TelefoneDAO telDAO = new TelefoneDAO();
                    Utilidades util = new Utilidades();
                    
                    tel.setId_tel(util.getGeraNumero());
                    tel.setNumero(numero_tel);
                    //tel.setTipo(tipo_tel);
                    tel.setDescricao(descricao);
                    tel.setId_user(funcionario.getId_func());
                    tel.setTipo_user(2);
                    
                    telDAO.cadastraTelefone(tel);
                    System.out.print(telDAO.getStatus());
                    
                    } catch(Exception e){
                        System.out.print("Erro " + e);                      
                    }
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


