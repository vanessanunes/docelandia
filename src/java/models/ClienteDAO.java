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
    
    /***
     * Entre com o objeto cliente para realizar cadastro
     * @param cliente 
     */
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
                status = ("Dados incluídos com sucesso!");
                System.out.print(status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    /***
     * Busca sql e retorna caso login for efetuado com sucesso
     * @param email
     * @param senha
     * @return registro
     */
    public List<Login> getLogin(String email, String senha){
        @SuppressWarnings("UnusedAssignment")
        String sql = "select * from login where nome_user ='"+email+"' and senha='"+senha+"'";
        System.out.println("ClienteDAO, getLogin(): " + sql);
        
        try {
            /* entramos na tabela login e verificamos se está correto,
            Se estiver ele retorna o registo (deve ser APENAS um)            
            */
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            List<Login> clientes;
            clientes = new ArrayList<>();
            try (PreparedStatement stmt = this.conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Login cliente = new Login();
                    cliente.getNome_user();
                    cliente.getSenha();
                    clientes.add(cliente);
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
