package beans;
import java.sql.Date;
import models.PedidoDAO;

public class Pedido {
    private int id_ped;
    private Date dt_pedido;
    private int id_clie;
    private String descricao; 
    
    public Pedido() {
    }

    public int getId_ped() {
        return id_ped;
    }

    public void setId_ped(int id_ped) {
        this.id_ped = id_ped;
    }

    public int getId_clie() {
        return id_clie;
    }

    public void setId_clie(int id_clie) {
        this.id_clie = id_clie;
    }

    public String getDescricao( ) {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDt_pedido() {
        return dt_pedido;
    }

    public void setDt_pedido(Date dt_pedido) {
        this.dt_pedido = dt_pedido;
    }
   
    
    
}
