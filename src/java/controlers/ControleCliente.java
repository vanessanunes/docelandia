/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Cliente;
import beans.Endereco;
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
import models.ClienteDAO;
import models.EnderecoDAO;
import models.LoginDAO;
import models.TelefoneDAO;
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
        
        // Variável que receberá o valor da flag enviado pelo formulário
        String flag = request.getParameter("flag");
        String mensagem = "";
        Utilidades u = new Utilidades();
        Cliente cliente = new Cliente();
        
        try (PrintWriter out = response.getWriter()) {
            if (flag == null) {
                request.getRequestDispatcher("index.html").
                        forward(request, response);
            } 
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

                    
               

                    break;
                case "cadastro":

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
            

                    try{
                        int id_cadastro = u.getGeraNumero();
                        ClienteDAO clienteDAO = new ClienteDAO();
                        cliente.setId_clie(id_cadastro);
                        cliente.setNome(nome);
                        cliente.setEmail(email);
                        cliente.setCpf(cpf);
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        java.sql.Date data = new java.sql.Date(format.parse(dt_nasc).getTime());
                        cliente.setData_nasc(data);
                        cliente.setSexo(sexo);
                        clienteDAO.cadastraCliente(cliente);
                        
                    } catch (Exception e){
                        System.out.print("ControleCliente - cliente: catch!");
                        System.out.print(e);
                    }
                     
                    
                    try {
                        int id_login = u.getGeraNumero();
                        Login login = new Login();
                        login.setId_log(id_login);
                        login.setNome_user(email);
                        login.setSenha(senha);
                        login.setTipo_user(1);
                        login.setId_user(cliente.getId_clie());
                        LoginDAO loginDAO = new LoginDAO();
                        loginDAO.cadastraLogin(login);
                    } catch (Exception e){
                        System.out.print("ControleCliente - login: catch!");
                        System.out.print(e);
                    }
                    int tipo_end = Integer.parseInt(request.getParameter("tipo_end"));
                    String cep = request.getParameter("cep");
                    String lagradouro = request.getParameter("lagradouro");
                    String numero = request.getParameter("numero");
                    String complemento = request.getParameter("complemento");
                    String bairro = request.getParameter("bairro");
                    String cidade = request.getParameter("cidade");
                    String uf = request.getParameter("uf");
                    String ponto_ref = request.getParameter("ponto_ref");

                    try {
                        int id_end = u.getGeraNumero();
                        System.out.print("Estamos no endereco do Controle Cliente");
                        Endereco endereco = new Endereco();
                        endereco.setId_end(id_end);
                        endereco.setCep(cep);
                        endereco.setLagradouro(lagradouro);
                        endereco.setNumero(numero);
                        endereco.setBairro(bairro);
                        endereco.setComplemento(complemento);
                        endereco.setCidade(cidade);
                        endereco.setUf(uf);
                        endereco.setPonto_ref(ponto_ref);
                        endereco.setId_user(cliente.getId_clie());
                        endereco.setTipo_user(1);
                        endereco.setTipo(tipo_end);
                        EnderecoDAO enderecoDAO = new EnderecoDAO();
                        enderecoDAO.cadastraEndereco(endereco);
                    } catch (Exception e) {
                        System.out.print("ControleCliente - endereço: catch!");
                        System.out.print(e);
                    }
                    int tipo_tel = Integer.parseInt(request.getParameter("tipo_tel"));
                    String num_tel = request.getParameter("num_tel");
                    String tel_desc = "";
                    System.out.print(tel_desc);
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
                    if (tipo_tel == 0){
                        tel_desc = "None";
                    } 
                    
                    try {
                        int id_tel = u.getGeraNumero();
                        System.out.print("ControleCliente - telefone");
                        Telefone telefone = new Telefone();
                        telefone.setNumero(numero);
                        telefone.setId_tel(id_tel);
                        telefone.setDescricao(tel_desc);
                        telefone.setId_user(cliente.getId_clie());
                        telefone.setTipo_user(1);
                        telefone.setTipo(tipo_tel);
                        
                    } catch (Exception e) {
                        System.out.print("ControleCliente - telefone: catch!");
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
