package beans;

import java.io.Serializable;

public class Telefone implements Serializable{
   private int id_tel;
   private int tipo;
   private int numero;
   private String descricap;
   private int id_fk;

    public Telefone() {
    }

    public int getId_tel() {
        return id_tel;
    }

    public void setId_tel(int id_tel) {
        this.id_tel = id_tel;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricap() {
        return descricap;
    }

    public void setDescricap(String descricap) {
        this.descricap = descricap;
    }

    public int getId_fk() {
        return id_fk;
    }

    public void setId_fk(int id_fk) {
        this.id_fk = id_fk;
    }
    
   
}
