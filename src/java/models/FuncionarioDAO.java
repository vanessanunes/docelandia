package models;

import beans.Cliente;
import beans.Funcionario;
import beans.Login;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FuncionarioDAO {
    private final Connection conexao;
    private String status;
    private int totalRegistros;
    private String criterios;

    public FuncionarioDAO() throws Exception {
        this.status = null;
        this.totalRegistros = 0;
        this.criterios = null;
        this.conexao = new ConnectionFactory().getConnection();
    }
    
    /***
     * Entre com o objeto cliente para realizar cadastro
     * @param cliente 
     */
    public void cadastraFuncionario(Funcionario funcionario){
        
        String sql = "insert into funcionario(id_func, nome, cargo, cpf, dt_nasc, sexo)"
                + "values (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                java.sql.Date dataAtual = new java.sql.Date(
                        Calendar.getInstance().getTimeInMillis());
                
                stmt.setInt(1, funcionario.getId_func());
                stmt.setString(2, funcionario.getNome());
                stmt.setString(3, funcionario.getEmail());
                stmt.setString(4, funcionario.getCpf());
                stmt.setDate(5, funcionario.getData_nasc());
                stmt.setString(6, funcionario.getSexo());
                
                stmt.execute();
                stmt.close();
                status = ("Dados incluídos com sucesso!");
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
        
        try {
            /* entramos na tabela login e verificamos se está correto,
            Se estiver ele retorna o registo (deve ser APENAS um)            
            */
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            List<Login> funcionarios;
            funcionarios = new ArrayList<>();
            try (PreparedStatement stmt = this.conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Login funcionario = new Login();
                    funcionario.getNome_user();
                    funcionario.getSenha();
                    funcionarios.add(funcionario);
                    totalRegistros++;
                }
                rs.close();
                stmt.close();
                return funcionarios;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}