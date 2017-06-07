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
        String sql = "insert into funcionario(id_func, nome, funcao, cpf, dt_nasc, email, sexo)"
                + "values (?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, funcionario.getId_func());
                stmt.setString(2, funcionario.getNome());
                stmt.setString(3, funcionario.getEmail());
                stmt.setString(4, funcionario.getCpf());
                stmt.setDate(5, funcionario.getData_nasc());
                stmt.setString(6, funcionario.getEmail());
                stmt.setString(7, funcionario.getSexo());
                stmt.execute();
                stmt.close();
                status = ("Dados incluídos com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
<<<<<<< HEAD
    public void pesquisa(){}
=======
    public void editarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE funcionario"
                + "SET nome = ?, funcao = ?, cpf = ?, dt_nasc = ?, email = ?, sexo = ?"
                + "WHERE id_func = ?";

        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getFuncao());
                stmt.setString(3, funcionario.getCpf());
                stmt.setDate(4, funcionario.getData_nasc());
                stmt.setString(5, funcionario.getEmail());
                stmt.setString(6, funcionario.getSexo());
                stmt.setInt(7, funcionario.getId_func());

                stmt.execute();
                stmt.close();
                status = ("Dados do cliente incluídos com sucesso!");
                System.out.print(status);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    
    public void alteraSenha(Login usuario) {
        String sql = "update login set senha=? where id_user = ?";

        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setString(1, usuario.getSenha());
                stmt.setInt(2, usuario.getId_user());
                stmt.execute();
                stmt.close();

                status = ("Senha alterada com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirFuncionario(Login usuario) {
        String sqlLogin = "delete from login where id_user = ?";

        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sqlLogin)) {
                stmt.setInt(1, usuario.getId_user());
                stmt.execute();
                stmt.close();
                status = ("Usuário excluído com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getStatus() {
        return status;
    }
>>>>>>> 09115f767f1d112218fb2036644ffd6d77107f61
    
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