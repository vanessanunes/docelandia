package beans;

import java.io.Serializable;
import java.sql.Date;


public class Funcionario extends Endereco implements Serializable {
    private int id_func;
    private String nome;
    private String funcao;
    private String cpf;
    private Date data_nasc;
    private String email;
    private String sexo;
    private String data_nasc_n;

    public String getData_nasc_n() {
        return data_nasc_n;
    }

    public void setData_nasc_n(String dt_nasc_n) {
        this.data_nasc_n = dt_nasc_n;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Funcionario() {
    }  

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date dt_nasc) {
        this.data_nasc = dt_nasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    
    
}