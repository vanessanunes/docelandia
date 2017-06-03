package beans;

import java.io.Serializable;

public class Telefone implements Serializable{
   private int id_tel;
   private int numero;
   private String descricap;
   private int id_user;
   private int tipo_user;
   private int tipo;

    public Telefone() {
    }

    public int getId_tel() {
        return id_tel;
    }

    public void setId_tel(int id_tel) {
        this.id_tel = id_tel;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(int tipo_user) {
        this.tipo_user = tipo_user;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

   
    
   
}
