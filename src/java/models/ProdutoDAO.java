package models;

import beans.Produto;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
<<<<<<< HEAD

    private String status;
    private int totalRegisto;
    private String criterios;
    private final Connection conexao;

    /**
     *
     * Conexão com cadastro do produto
     */
    public ProdutoDAO() throws Exception {
        this.status = null;
        this.totalRegisto = 0;
        this.criterios = null;
        this.conexao = new ConnectionFactory().getConnection();

    }
    
    public void cadastroProduto(Produto produto) throws SQLException{
        String sql = "insert into Produto (id_prod, nome, descricao,preco,quantidade)"
                + ("?, ?, ?, ? ,?");
        System.out.println("Produto" + sql);
        
        
=======
    private final Connection conexao;
    private String status;
    private int totalRegistros;
    private String criterios;

    public ProdutoDAO() throws Exception {
        this.status = null;
        this.totalRegistros = 0;
        this.criterios = null;
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    public void cadastraProduto(Produto produto){
        String sql = "insert into produto(id_prod, id_cat, nome, descricao, preco, quantidade)"
                + "values (?, ?, ?, ?, ?, ?)";
        
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                
                stmt.setInt(1, produto.getId_prod());
                stmt.setInt(2, produto.getId_cat());
                stmt.setString(3, produto.getNome());
                stmt.setString(4, produto.getDescricao());
                stmt.setFloat(5, produto.getPreco());
//                stmt.setInt(6, produto.getQuantidade());
                
                stmt.execute();
                stmt.close();
                status = ("Dados incluídos com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
>>>>>>> a41e8e5ea297bde48ee1bb21a8e2e28301538b8d
    }
}
