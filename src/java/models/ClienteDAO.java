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

public class ClienteDAO {
    private final Connection conexao;
    private String status;
    private int totalRegistros;
    private String criterios;

    public ClienteDAO() throws Exception {
        this.status = null;
        this.totalRegistros = 0;
        this.criterios = null;
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void cadastraCliente(Cliente cliente){
        
        String sql = "insert into cliente(id_clie, nome, email, cpf, dt_nasc, sexo)"
                + "values (?, ?, ?, ?, ?, ?)";
        
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, cliente.getId_clie());
                stmt.setString(2, cliente.getNome());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getCpf());
                stmt.setDate(5, cliente.getData_nasc());
                stmt.setString(6, cliente.getSexo());
                
                stmt.execute();
                stmt.close();
                status = ("Dados do cliente incluídos com sucesso!");
                System.out.print(status);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public List<Cliente> getLogin(int id_clie){
        @SuppressWarnings("UnusedAssignment")
        String sql = "SELECT * FROM `cliente` WHERE `id_clie` = '"+id_clie+"'";
        System.out.println("ClienteDAO, getLogin(): " + sql);
//        System.out.print(cliente.getId_clie());
        
        try {
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            List<Cliente> clientes = new ArrayList<>();
            try (PreparedStatement stmt = this.conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId_clie(rs.getInt("id_clie"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setData_nasc(rs.getDate("dt_nasc"));
                    cliente.setSexo(rs.getString("sexo"));
                    
                    clientes.add(cliente);
                    totalRegistros++;
                }
                rs.close();
                stmt.close();
                return clientes;
            }
            
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
    
}
