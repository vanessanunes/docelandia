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
    
    public void editarProduto(Produto produto){
        String sql = "UPDATE produto"
                + "SET nome = ?, descricao = ?, preco = ?, quantidade = ?, id_cat = ?"
                + "WHERE id_prod = ?";
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                
                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getDescricao());
                stmt.setDouble(3, produto.getPreco());
                stmt.setInt(4, produto.getQuantidade());
                stmt.setInt(5, produto.getId_cat());
                
                stmt.execute();
                stmt.close();
                status = ("Dados incluídos com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        
    public void excluirProduto(Produto produto) {
        String sqlLogin = "delete from produto where id_prod = ?";

        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sqlLogin)) {
                stmt.setInt(1, produto.getId_prod());
                stmt.execute();
                stmt.close();
                status = ("Produto excluído com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getStatus() {
        return status;
    }
    
}



