package beans;

import java.io.Serializable;

public class Telefone implements Serializable{
    private int telefone_res;
    private int telefone_com;
    private int telefone_celular1;
    private int telefone_celular2;

    public Telefone() {
    }

    public int getTelefone_res() {
        return telefone_res;
    }

    public void setTelefone_res(int telefone_res) {
        this.telefone_res = telefone_res;
    }

    public int getTelefone_com() {
        return telefone_com;
    }

    public void setTelefone_com(int telefone_com) {
        this.telefone_com = telefone_com;
    }

    public int getTelefone_celular1() {
        return telefone_celular1;
    }

    public void setTelefone_celular1(int telefone_celular1) {
        this.telefone_celular1 = telefone_celular1;
    }

    public int getTelefone_celular2() {
        return telefone_celular2;
    }

    public void setTelefone_celular2(int telefone_celular2) {
        this.telefone_celular2 = telefone_celular2;
    }
    
    
    
}
