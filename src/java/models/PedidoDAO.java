package models;

import beans.Cliente;
import beans.Login;
import java.sql.Connection;
import conexao.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import beans.Pedido;

public class PedidoDAO {

    private final Connection conexao;
    private String status;
    private int totalRegistros;
    private String criterios;

    public PedidoDAO() throws Exception {
        this.status = null;
        this.totalRegistros = 0;
        this.criterios = null;
        this.conexao = new ConnectionFactory().getConnection();

    }
    
    public List<Pedido> consultarPedidos(int idCliente) throws Exception {
        List<Pedido> listaPedidos = new ArrayList<Pedido>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            String sql = "SELECT * FROM Pedido WHERE id_clie = "+idCliente;
            try (PreparedStatement pps = conexao.prepareStatement(sql)) {
                pps.setInt(1, idCliente);
                ResultSet rs = pps.executeQuery();
                while (rs.next()) {
                    Pedido p = new Pedido();
                    p.setId_ped(rs.getInt("id_ped"));
                    p.setDt_pedido(rs.getDate("dt_pedido"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setId_clie(rs.getInt("id_clie"));

                    listaPedidos.add(p);
                }
                return listaPedidos;
            } catch (SQLException e) {
                System.out.println("Erro listar pedidos: " + e.getMessage());
                return listaPedidos;
            }

        } catch (SQLException e) {
            System.out.println("Erro listar pedidos: " + e.getMessage());
            return listaPedidos;
        }
    }

    

}
