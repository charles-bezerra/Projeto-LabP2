package projetoLP2;

public class Pesquisador {
    private String nome;
    private String biografia;
    private String email; //id
    private String fotoURL;
    private String funcao;
    private boolean ativado;

    public Pesquisador(String nome, String funcao, String biografia, String email, String fotoURL) {
        this.nome = nome;
        this.biografia = biografia;
        this.email = email;
        this.fotoURL = fotoURL;
        this.funcao = funcao;
        this.ativado = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }

    @Override
    public String toString() {
        return nome + " (" + funcao + ") - " + biografia + " - " + email + " - " + fotoURL;
    }
}