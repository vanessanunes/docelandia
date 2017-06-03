/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Utilidades;
import models.CategoriaDAO;

/**
 *
 * @author Vanessa.Nunes
 */
public class ControleProduto extends HttpServlet {

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
        
        /*Variacel flag*/
        String flag = request.getParameter("flag");
        String mensagem = "";
        
        Utilidades util = new Utilidades();
        
        try (PrintWriter out = response.getWriter()) {
  
            switch (flag){
                case "cad_cat":
                    System.out.print("Entramos no ControleProduto");
                    /*Setando valores*/
                    String nome = request.getParameter("nome_cat");
                    String desc = request.getParameter("descricao");
                    try{
                        Categoria categoria = new Categoria();
                        int cod_cat = util.getGeraNumero();
                        categoria.setId_cat(cod_cat);
                        categoria.setNome(nome);
                        categoria.setDescricao(desc);
                        CategoriaDAO categoriaDAO = new CategoriaDAO();
                        categoriaDAO.cadastrarCategoria(categoria);
                    } catch (Exception e) {
                        System.out.print("ControleProduto, falha em cadastrar categoria");
                    }
//                    mensagem = "Categoria cadastrada com sucesso";
//                    request.getRequestDispatcher("view/mensagem.jsp").forward(request, response);
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
