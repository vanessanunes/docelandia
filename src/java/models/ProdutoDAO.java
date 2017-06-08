package models;
import beans.Produto;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                stmt.setInt(5, produto.getId_prod());
                
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
    
    public List<Produto> listaTodosProdutos() {
        
        @SuppressWarnings("UnusedAssignment")
        String sql = "select * from produto";

        try {
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            List<Produto> produtos = new ArrayList<>();

            try (PreparedStatement stmt = this.conexao.
                    prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Produto produto = new Produto();
                    produto.setId_prod(rs.getInt("id_prod"));
                    produto.setId_cat(rs.getInt("id_cat"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getFloat("preco"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                    produto.setImagem(rs.getString("imagem"));

                    produtos.add(produto);

                    totalRegistros++;
                }
                rs.close();
                stmt.close();

                return produtos;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public String getCriterios() {
        if (!this.criterios.equals("=")) {
            return ("Dados não localizados para [" + criterios + "]");
        } else {
            return ("Não há registros cadastrados!");
        }
    }
    
    public int getTotalRegistros() {
        return totalRegistros;
    }

}



