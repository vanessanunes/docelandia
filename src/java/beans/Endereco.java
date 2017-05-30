package beans;

import java.io.Serializable;

public class Endereco implements Serializable{
    private int id_end;
    private int tipo;
    private Double cep;
    private String lagradouro;
    private int numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;
    private String ponto_ref;
    private int id_fk;

    public Endereco() {
    }

    public int getId_end() {
        return id_end;
    }

    public void setId_end(int id_end) {
        this.id_end = id_end;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId_fk() {
        return id_fk;
    }

    public void setId_fk(int id_fk) {
        this.id_fk = id_fk;
    }

    public Double getCep() {
        return cep;
    }

    public void setCep(Double cep) {
        this.cep = cep;
    }


    public String getLagradouro() {
        return lagradouro;
    }

    public void setLagradouro(String lagradouro) {
        this.lagradouro = lagradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPonto_ref() {
        return ponto_ref;
    }

    public void setPonto_ref(String ponto_ref) {
        this.ponto_ref = ponto_ref;
    }
    
}
