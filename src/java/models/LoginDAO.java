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
        
        String sql = "insert into login(id_log, nome_user, senha, id_user, tipo_user)"
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
    
    public List<Login> acessaLogin(String email, String senha){
        System.out.print("LoginDAO - acessaLogin()");
        String sql = "select * from login where 'nome_user' = '"+email+"' and 'senha' = '"+senha+"'";
        try {
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            List<Login> usuarios;
            usuarios = new ArrayList<>();

            try (PreparedStatement stmt = this.conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Login usuario = new Login();
//                    usuario.setId_fk(rs.getInt("id"));
//                    
//                    if (usuario.getId_fk() == 1) {
////                        cliente
////                        Cliente cliente = new Cliente()
//                    } else {
////                        funcionario
//                    }
                    
                    
                    usuarios.add(usuario);

                    totalRegistros++;
                }

                rs.close();
                stmt.close();

                return usuarios;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
