package beans;
import models.PedidoDAO;

public class Pedido {
    private int id_ped;
    private int id_clie;
    private int descricao; 
    private int preco;
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



    public int getDescricao( ) {
        return descricao;
    }

    public void setDescricao(int ddescricao) {
        this.descricao = ddescricao;
    }
   
    public int getPreco( ) {
        return preco;
    }

    public void setPreco(int dpreco) {
        this.preco = dpreco;
    }
    
}
