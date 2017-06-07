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
                stmt.setInt(4, login.getId_user());
                stmt.setInt(5, login.getTipo_user());
                
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
    
    public List<Login> getLogin(String email, String senha) {
        @SuppressWarnings("UnusedAssignment")
        String sql = "SELECT * FROM `login` WHERE `nome_user` like '"+email+"' and `senha` = '"+senha+"'";
                
        try {
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            List<Login> usuarios = new ArrayList<>();

            try (PreparedStatement stmt = this.conexao.
                    prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Login usuario = new Login();
                    usuario.setId_log(rs.getInt("id_log"));
                    usuario.setId_user(rs.getInt("id_user"));
                    usuario.setTipo_user(rs.getInt("tipo_user"));
                    usuario.setNome_user(rs.getString("nome_user"));
                    usuario.setSenha(rs.getString("senha"));
                    System.out.print(usuario.getId_log());
                    System.out.print(usuario.getId_user());
                    System.out.print(usuario.getTipo_user());
                    System.out.print(usuario.getNome_user());
                    System.out.print(usuario.getSenha());
                    usuarios.add(usuario);

                    if (usuario.getTipo_user() == 1) {
                        System.out.print("Tipo user: Cliente "+ usuario.getTipo_user());
                        try {
                            ClienteDAO clienteDAO = new ClienteDAO();
                            Cliente cliente = new Cliente();
                            cliente.setId_clie(usuario.getId_user());
                            clienteDAO.getLogin(cliente.getId_clie());
                        } catch (Exception e){
                            System.out.print(e);
                        }
                        
                    } else {
                        System.out.print("Tipo user: usuário " + usuario.getTipo_user());
//                        funcionario
                    }
                    usuarios.add(usuario);
                    totalRegistros++;
                }
                rs.close();
                stmt.close();
                return usuarios;
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
    
    
}
