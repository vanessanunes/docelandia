package models;

import beans.Produto;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

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
        
        
    }
}
