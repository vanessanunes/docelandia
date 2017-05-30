
package models;

import beans.Endereco;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {
    private final Connection conexao;
    private String status;
    private int totalRegistros;
    private String criterios;

    public EnderecoDAO() throws Exception {
        this.status = null;
        this.totalRegistros = 0;
        this.criterios = null;
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    public void cadastraEndereco(Endereco endereco){
        System.out.print("EnderecoDAO - cadastraEndereco()");
        
        String sql = "insert into endereco(id_end, tipo, cep, lagradouro, numero, bairro, complemento, cidade, uf, ponto_ref, id_fk)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.print("sql: " + sql);
        
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                
                stmt.setInt(1, endereco.getId_end());
                stmt.setInt(2, endereco.getTipo());
                stmt.setDouble(3, endereco.getCep());
                stmt.setString(4, endereco.getLagradouro());
                stmt.setInt(5, endereco.getNumero());
                stmt.setString(6, endereco.getBairro());
                stmt.setString(7, endereco.getComplemento());
                stmt.setString(8, endereco.getCidade());
                stmt.setString(9, endereco.getUf());
                stmt.setString(10, endereco.getPonto_ref());
                stmt.setInt(11, endereco.getId_fk());
                
                stmt.execute();
                stmt.close();
                status = ("Dados incluídos com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
}
