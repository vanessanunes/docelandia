/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Cliente;
import beans.Endereco;
import beans.Funcionario;
import beans.Login;
import beans.Telefone;
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
import models.FuncionarioDAO;
import models.LoginDAO;
import utils.Utilidades;


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
        
        // Variável que receberá o valor da flag enviado pelo formulário
        String flag = request.getParameter("flag");
        Utilidades u = new Utilidades();
        
        try (PrintWriter out = response.getWriter()) {

            switch (flag) {
                case "login":
                    String email = request.getParameter("email");
                    String senha = request.getParameter("senha");
                    try {
                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                        funcionarioDAO.getLogin(email, senha);
                    } catch (Exception e){
                        System.out.print("Erro na instancia DAO");
                    }
                  
                    break;
                case "cadastro":
                    System.out.print("ClienteControle");
                    String nome = request.getParameter("nome");
                    email = request.getParameter("email"); 
                    String cpf = request.getParameter("cpf"); 
                    senha = request.getParameter("senha"); 
                    String dt_nasc = request.getParameter("dt_nasc"); 
                    String sexo = request.getParameter("sexo");
                    String funcao = request.getParameter("funcao");
                   
                    int id_gerada = u.getGeraNumero();
                    try{
                        System.out.print("ControleFunc - cadastro");
                        Funcionario func = new Funcionario();
                        func.setId_func(u.getGeraNumero());
                        func.setNome(nome);
                        func.setFuncao(funcao);
                        func.setCpf(cpf);
                        
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        java.util.Date dataFormatada = formato.parse(dt_nasc);
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        java.sql.Date data = new java.sql.Date(format.parse(dt_nasc).getTime());
                        
                        func.setDt_nasc(data);
                        func.setEmail(email);
                        FuncionarioDAO funcDAO = new FuncionarioDAO();
                        funcDAO.cadastraFuncionario(func);
                        
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
                        System.out.print("Cadastro de login falhou");
                    }
                    String tipo = request.getParameter("tipo_end");
                    Double cep = Double.parseDouble(request.getParameter("cep"));
                    String lagradouro = request.getParameter("lagradouro");
                    int numero = Integer.parseInt(request.getParameter("numero"));
                    String bairro = request.getParameter("bairro");
                    String complemento = request.getParameter("complemento");
                    String cidade = request.getParameter("cidade");
                    String uf = request.getParameter("uf");
                    String ponto_ref = request.getParameter("ponto_ref");
//                    String id_fk = request.getParameter("sexo");
                    try {
                        System.out.print("Estamos no endereco do Controle Cliente");
                        
                        Endereco endereco = new Endereco();
                        endereco.setId_end(id_gerada);
                        endereco.setCep(cep);
                        endereco.setLagradouro(lagradouro);
                        endereco.setNumero(numero);
                        endereco.setBairro(bairro);
                        endereco.setComplemento(complemento);
                        endereco.setUf(uf);
                        endereco.setPonto_ref(ponto_ref);
                        endereco.setId_fk(id_gerada);
                    } catch (Exception e) {
                        System.out.print("Cadastro de endereco fahou");
                    }
                    int tipo_tel = Integer.parseInt(request.getParameter("tipo_tel"));
                    String num_tel = request.getParameter("num_tel");
                    String tel_desc = "";
                    if (tipo_tel == 1){
                        tel_desc = "Pessoal";
                    }
                    if (tipo_tel == 2){
                        tel_desc = "Residencial";
                    }
                    if (tipo_tel == 3){
                        tel_desc = "Comercial";
                    }
                    if (tipo_tel == 4){
                        tel_desc = "Recado";
                    }
                    
                    try {
                        System.out.print("Estamos no telefne do Controle Cliente");
                        Telefone telefone = new Telefone();
//                        telefone.setId_tel(??);
                        telefone.setId_fk(id_gerada);
                        telefone.setNumero(numero);
                        telefone.setTipo(tipo_tel);
                        telefone.setDescricap(tel_desc);
                    } catch (Exception e) {
                        System.out.print("Cadastro de telefone fahou");
                    }
                    /*Setando valores*/
                    try {
                        
                    } catch(Exception e){
                        System.out.print(e);
                    }

                    
//                    mensagem = "Cadastro de cliente";
//                    response.sendRedirect("view/mensagem.jsp");
//                    break;
                    
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
