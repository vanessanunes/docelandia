package models;

import beans.Produto;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
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
    }
}
