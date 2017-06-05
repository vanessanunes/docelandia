package models;

import beans.Telefone;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelefoneDAO {
    private final Connection conexao;
    private String status;
    private int totalRegistros;
    private String criterios;

    public TelefoneDAO() throws Exception {
        this.status = null;
        this.totalRegistros = 0;
        this.criterios = null;
        this.conexao = new ConnectionFactory().getConnection();
    }
    
     public void cadastraTelefone(Telefone telefone){
        String sql = "insert into telefone(id_tel, numero, descricao, tipo_user, id_user, tipo)"
                + "values (?, ?, ?, ?, ?, ?)";
        
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                
                stmt.setInt(1, telefone.getId_tel());
                stmt.setString(2, telefone.getNumero());
                stmt.setString(3, telefone.getDescricao());
                stmt.setInt(4, telefone.getTipo_user());
                stmt.setFloat(5, telefone.getId_user());
                stmt.setInt(6, telefone.getTipo());
                
                stmt.execute();
                stmt.close();
                status = ("Dados incluídos com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
