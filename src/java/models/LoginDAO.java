package models;

import beans.Login;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class LoginDAO {
    private final Connection conexao;
    private String status;
    private int totalRegistros;
    private String criterios;

    public LoginDAO() throws Exception {
        this.status = null;
        this.totalRegistros = 0;
        this.criterios = null;
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    public void cadastraLogin(Login login){
        System.out.print("LoginDAO - cadastraLoginCliente()");
        
        String sql = "insert into login(id_log, nome_user, senha, tipo)"
                + "values (?, ?, ?, ?)";
        System.out.print("sql: " + sql);
        
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                
                stmt.setInt(1, login.getId_log());
                stmt.setString(2, login.getNome_user());
                stmt.setString(3, login.getSenha());
                stmt.setInt(4, login.getTipo());
                
                stmt.execute();
                stmt.close();
                status = ("Dados incluídos com sucesso!");
            }
        } catch (SQLException e) {
            System.out.print("Caiu no catch do LoginDAO - CadastraLogin");
            System.out.print(e);
            throw new RuntimeException(e);
        }
        
    }
    
}
