package projetoLP2.classes;

import projetoLP2.util.Verificador;

import java.util.Objects;

/**
 * Classe responsavel por representar um pesquisador e guardar seus dados.
 */
public abstract class Pesquisador {
    /**
     * Atributo que representa o nome de um pesquisador.
     */
    private String nome;
    /**
     * Atributo que representa a biografia de um pesquisador.
     */
    private String biografia;
    /**
     * Atributo que representa o email de um pesquisador.
     */
    private String email; //id
    /**
     * Atributo que representa a url da foto de um pesquisador.
     */
    private String fotoURL;
    /**
     * Atributo que representa a funcao de um pesquisador.
     */
    private String funcao;
    /**
     * Atributo que representa o status de ativacao de um pesquisador.
     */
    private boolean ativado;
    /**
     * Atributo que representa se os atributos especificos das classes filhas foram inicializados
     */
    protected boolean especializado;


    /**
     * Constroi os atributos nome, biografia, email, fotoURL, funcao e ativado.
     * @param nome passa o valor contido nele para o atributo nome.
     * @param funcao passa o valor contido nele para o atributo funcao.
     * @param biografia passa o valor contido nele para o atributo biografia.
     * @param email passa o valor contido nele para o atributo email.
     * @param fotoURL passa o valor contido nele para o atributo fotoURL.
     */
    public Pesquisador(String nome, String funcao, String biografia, String email, String fotoURL) {
        Verificador.verificaString("Campo nome nao pode ser nulo ou vazio.", nome);
        Verificador.verificaString("Campo funcao nao pode ser nulo ou vazio.", funcao);
        Verificador.verificaString("Campo biografia nao pode ser nulo ou vazio.", biografia);
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        Verificador.verificaString("Campo fotoURL nao pode ser nulo ou vazio.", fotoURL);

        verificaEmail(email);
        verificaFoto(fotoURL);

        this.nome = nome;
        this.biografia = biografia;
        this.email = email;
        this.fotoURL = fotoURL;
        this.funcao = funcao;
        this.ativado = true;
        this.especializado = false;
    }


    public abstract void alteraAtributo(String atributo, String novoValor);


    /**
     * Verifica se uma string se enquadra nos padroes do email.
     * Tendo pelo menos um caractere antes e depois do @.
     */
    protected void verificaEmail(String email){
        if(!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Formato de email invalido.");
        }
    }


    /**
     * Verifica se uma string se enquadra nos padroes de url.
     * Inciando com http:// ou https://, seguido de um endereço
     */
    protected void verificaFoto(String url){
        if (!url.startsWith("http://") & !url.startsWith("https://")){
            throw new IllegalArgumentException("Formato de foto invalido.");
        }else if(url.split("://").length == 1){
            throw new IllegalArgumentException("Formato de foto invalido.");
        }
    }


    /**
     * Metodo responsavel por retornar o nome do pesquisador.
     * @return em String o que estiver contido no atributo nome.
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo responsavel por retornar a biografia do pesquisador.
     * @return em String o que estiver contido no atributo briografia.
     */
    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    /**
     * Metodo responsavel por retornar o email do pesquisador.
     * @return em String o que estiver contido no atributo email.
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo responsavel por retornar a url da foto do pesquisador.
     * @return em String o que estiver contido no atributo fotoURL.
     */
    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    /**
     * Metodo responsavel por retornar a funcao do pesquisador.
     * @return em String o que estiver contido no atributo funcao.
     */
    public String getFuncao() {
        return funcao;
    }


    /**
     * Metodo responsavel por retornar o status de ativacao do pesquisador.
     * @return em boolean, true caso o pesquisador esteja ativado e false caso nao esteja.
     */
    public boolean isAtivado() {
        return ativado;
    }

    /**
     * Metodo responsavel pela mudanca do atributo ativado para true.
     */
    public void ativaPesquisador() {
        if(isAtivado()) {
            throw new IllegalArgumentException("Pesquisador ja ativado.");
        }
        this.ativado = true;
    }
    /**
     * Metodo responsavel pela mudanca do atributo ativado para false.
     */
    public void desativaPesquisador() {
        if(!isAtivado()) {
            throw new IllegalArgumentException("Pesquisador inativo.");
        }
        this.ativado = false;
    }


    /**
     * Metódo responsável por retornar as características gerais de um pesquisador.
     * @return representação em String das características gerais de um pesquisador.
     */
    @Override
    public String toString() {
        if(!isAtivado()) {
            throw new IllegalArgumentException("Pesquisador inativo.");
        }
        return String.format("%s (%s) - %s - %s - %s",getNome(),getFuncao(),getBiografia(),getEmail(),getFotoURL());
    }


    /**
     * Retorna se este objeto eh igual a um outro.
     *
     * @param o o objeto a ser comparado
     *
     * @return a confirmacao se este objeto e igual ao outro
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pesquisador)) return false;
        Pesquisador that = (Pesquisador) o;
        return getEmail().equals(that.getEmail());
    }


    /**
     * Gera um valor que identifica este pesquisador.
     *
     * @return o hashcode do pesquisador.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}
