package models;

import beans.Cliente;
import beans.Login;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        String sql = "insert into login(id_log, nome_user, senha, tipo_user, id_user)"
                + "values (?, ?, ?, ?, ?)";
        
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                
                stmt.setInt(1, login.getId_log());
                stmt.setString(2, login.getNome_user());
                stmt.setString(3, login.getSenha());
                stmt.setInt(4, login.getTipo_user());
                stmt.setInt(5, login.getId_user());
                
                stmt.execute();
                stmt.close();
                status = ("Dados do login incluídos com sucesso!");
                System.out.print(status);
            }
        } catch (SQLException e) {
            System.out.print("Caiu no catch do LoginDAO - CadastraLogin");
            System.out.print(e);
            throw new RuntimeException(e);
        }
        
    }
    
    public List<Login> getLogin(String nome_user, String senha) {

        @SuppressWarnings("UnusedAssignment")
        String sql = "select * from login where "
                + " nome_user='" + nome_user
                + "' and senha='" + senha + "'";

        try {
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            List<Login> logins;
            logins = new ArrayList<>();

            try (PreparedStatement stmt = this.conexao.
                    prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Login log = new Login();
                    log.setId_log(rs.getInt("id_log"));
                    log.setNome_user(rs.getString("nome_user"));
                    log.setSenha(rs.getString("senha"));
                    log.setTipo_user(rs.getInt("tipo_user"));
                    log.setTipo_user(rs.getInt("id_user"));

                    logins.add(log);
   
                    totalRegistros++;
                }

                rs.close();
                stmt.close();

                return logins;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<Login> listar() {
        List<Login> logins = new ArrayList<>();
        try {
            String sql = "SELECT * FROM login ORDER BY nome_user";
            try (PreparedStatement ps = conexao.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Login log = new Login();
                    log.setId_log(rs.getInt("id_log"));
                    log.setNome_user(rs.getString("nome_user"));
                    log.setSenha(rs.getString("senha"));
                    log.setTipo_user(rs.getInt("tipo_user"));
                    log.setId_user(rs.getInt("id_user"));
                    

                    logins.add(log);
                }
            }
            return logins;

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar os logins.", ex);
        }
    }
    
    public String getStatus(){
        return status;
    }
    
    public int getTotalRegistros() {
        return totalRegistros;
    }
    
    
}
