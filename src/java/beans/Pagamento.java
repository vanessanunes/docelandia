package beans;

import java.sql.Date;

public class Pagamento {
    private int id_pag;
    private int id_prd;
    private String tipo;
    private Date dt_pag;
    private int pag;
    private int n_par;

    public Pagamento() {
    }

    public int getId_pag() {
        return id_pag;
    }

    public void setId_pag(int id_pag) {
        this.id_pag = id_pag;
    }

    public int getId_prd() {
        return id_prd;
    }

    public void setId_prd(int id_prd) {
        this.id_prd = id_prd;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDt_pag() {
        return dt_pag;
    }

    public void setDt_pag(Date dt_pag) {
        this.dt_pag = dt_pag;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }

    public int getN_par() {
        return n_par;
    }

    public void setN_par(int n_par) {
        this.n_par = n_par;
    }
    
    

}
