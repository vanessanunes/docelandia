package beans;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Date;

public class Carrinho implements Serializable{
    private int id;
    private int id_cliente;
    private Array ids_produtos;
    private Date data_compra;

    public Carrinho() {
    }

    public int getId_carrinho() {
        return id;
    }

    public void setId_carrinho(int id_carrinho) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Array getIds_produtos() {
        return ids_produtos;
    }

    public void setIds_produtos(Array ids_produtos) {
        this.ids_produtos = ids_produtos;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }
    
    
}
