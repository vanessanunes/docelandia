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

  
       
    
   // public void cadastroPedido(Pedido pedido) throws Exception{
        
   // }
        public List<Pedido> consultarPedidos(int idCliente) throws Exception{
            
		List<Pedido> listaPedidos = null;
                
        try(Connection conexao = new ConnectionFactory().getConnection()){
           
    String sql = "SELECT * FROM Pedido WHERE id_clie = ";
  
			try(PreparedStatement pps = conexao.prepareStatement (sql) ){
                            
                            
				pps.setInt(1, idCliente);
                                
				ResultSet rs = pps.executeQuery();

                                listaPedidos = new ArrayList<Pedido>();
				
                                
                                while(rs.next()){
                                    
					Pedido p = new Pedido();
					p.setId_ped(rs.getInt("idPedido"));
					
					//Calendar dataPedido = Calendar.getInstance();
					dataPedido.setTime(rs.getDate("dataPedido"));
					
                                        
                                        
                                        
                                        
                                        
                                        
                                        /////////////   EXEMPLO Q PEGUEI NA NET 
					p.setDt_pedido(dataPedido);
					p.setValorTotal(rs.getDouble("valorTotal"));
					p.getCliente().setIdCliente(rs.getInt("idCliente"));
					p.setIdPagamento(rs.getInt("idPagamento"));
					p.setPrazoEntrega(rs.getInt("prazoEntrega"));
					p.setDataEntrega(rs.getDate("dataEntrega"));
					p.setFrete(rs.getDouble("frete"));
					
					listaPedidos.add(p);
				}
				return listaPedidos;
			}catch (SQLException e) {
				System.out.println("Erro listar pedidos: "+ e.getMessage());
				return listaPedidos;
			}
			
		}catch (SQLException e) {
			System.out.println("Erro listar pedidos: "+ e.getMessage());
			return listaPedidos;
		}
	}

	public boolean confirmarPedido(Pedido pedido) {
		boolean resultado = false;
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			String sql = "INSERT INTO pedido (";
			//TODO TERMINAR A QUERY
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, pedido.getIdPedido());
			return resultado;
		}catch (SQLException e) {
			e.printStackTrace();
			return resultado;
		}
		
	}

	
}
