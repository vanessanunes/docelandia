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

    public void cadastraCliente(Cliente cliente) {

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

    public void editarCliente(Cliente cliente) {

        String sql = "UPDATE cliente"
                + "SET nome = ?, email = ?, cpf = ?, dt_nasc = ?, sexo = ?"
                + "WHERE id_clie = ?";

        
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getEmail());
                stmt.setString(3, cliente.getCpf());
                stmt.setDate(4, cliente.getData_nasc());
                stmt.setString(5, cliente.getSexo());

                stmt.execute();
                stmt.close();
                status = ("Dados do cliente incluídos com sucesso!");
                System.out.print(status);
            
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public void alteraSenha(Login usuario) {
        String sql = "update login set senha=? where id_user = ?";

       
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setString(1, usuario.getSenha());
                stmt.setInt(2, usuario.getId_user());
                stmt.execute();
                stmt.close();

                status = ("Senha alterada com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirCliente(Login usuario) {
        String sqlLogin = "delete from login where id_user = ?";
        
            try (PreparedStatement stmt = conexao.prepareStatement(sqlLogin)) {
                stmt.setInt(1, usuario.getId_user());
                stmt.execute();
                stmt.close();
                status = ("Usuário excluído com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getStatus() {
        return status;
    }
    
    public List<Cliente> getLogin(int id_clie) {
        @SuppressWarnings("UnusedAssignment")
        String sql = "SELECT * FROM `cliente` WHERE `id_clie` = '" + id_clie + "'";
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
        
        return null;
    }
    
    /***
     * Busca sql e retorna o cliente pesquisado
     * @param primary_key
     * @return clientes
     */
    public List<Cliente> Pesquisar(int primary_key) {

        @SuppressWarnings("UnusedAssignment")
        String sql = "select * from cliente where "
                + " id_clie='" + primary_key + "'";

        try {
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            List<Cliente> clientes;
            clientes = new ArrayList<>();

            try (PreparedStatement stmt = this.conexao.
                    prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Cliente clie = new Cliente();
                    clie.setId_clie(rs.getInt("id_clie"));
                    clie.setNome(rs.getString("nome"));
                    clie.setEmail(rs.getString("email"));
                    clie.setCpf(rs.getString("cpf"));
                    clie.setData_nasc(rs.getDate("dt_nasc"));
                    clie.setSexo(rs.getString("sexo"));

                    clientes.add(clie);
   
                    totalRegistros++;
                }

                rs.close();
                stmt.close();

                return clientes;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
