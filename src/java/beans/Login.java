package beans;

public class Login {
    private int id_log;
    private String nome_user;
    private String senha;
    private int tipo;
    private int id_fk; // não sei se precisa

    public Login() {
    }

    public int getId_log() {
        return id_log;
    }

    public void setId_log(int id_log) {
        this.id_log = id_log;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
    
}
