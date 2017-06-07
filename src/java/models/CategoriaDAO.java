package models;

import beans.Categoria;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDAO {
    private final Connection conexao;
    private String status;
    private int totalRegistros;
    private String criterios;

    public CategoriaDAO() throws Exception {
        this.status = null;
        this.totalRegistros = 0;
        this.criterios = null;
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarCategoria(Categoria categoria){
        String sql = "insert into categoria(id_cat, nome, descricao)"
                + "values (?,?,?)";
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                                
                stmt.setInt(1, categoria.getId_cat());
                stmt.setString(2, categoria.getNome());
                stmt.setString(3, categoria.getDescricao());
                stmt.execute();
                stmt.close();
                status = ("Dados incluídos com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void editarCategoria(Categoria categoria) {
        String sql = "UPDATE categoria SET nome=?, descricao=?"
                + "WHERE id_cat=?";

        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, categoria.getNome());
                stmt.setString(2, categoria.getDescricao());
                stmt.setInt(3, categoria.getId_cat());
                stmt.execute();
                stmt.close();
                status = ("Dados da categoria incluídos com sucesso!");
                System.out.print(status);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    
    public void excluirEndereco(Categoria categoria) {
        String sqlLogin = "delete from categoria where id_cat = ?";

        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sqlLogin)) {
                stmt.setInt(1, categoria.getId_cat());
                stmt.execute();
                stmt.close();
                status = ("Categoria excluído com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    
}
