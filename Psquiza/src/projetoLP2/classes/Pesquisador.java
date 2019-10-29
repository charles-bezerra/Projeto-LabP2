package projetoLP2.classes;

/**
 * Classe responsavel por representar um pesquisador e guardar seus dados.
 */
public class Pesquisador {
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
     * Constroi os atributos nome, biografia, email, fotoURL, funcao e ativado.
     * @param nome passa o valor contido nele para o atributo nome.
     * @param funcao passa o valor contido nele para o atributo funcao.
     * @param biografia passa o valor contido nele para o atributo biografia.
     * @param email passa o valor contido nele para o atributo email.
     * @param fotoURL passa o valor contido nele para o atributo fotoURL.
     */
    public Pesquisador(String nome, String funcao, String biografia, String email, String fotoURL) {
        this.nome = nome;
        this.biografia = biografia;
        this.email = email;
        this.fotoURL = fotoURL;
        this.funcao = funcao;
        this.ativado = true;
    }

    /**
     * Metodo responsavel por retornar o nome do pesquisador.
     * @return em String o que estiver contido no atributo nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo responsavel pela mudanca do atributo nome, atraves do parametro recebido.
     * @param nome parametro que e atribuido como novo valor do atributo em questao.
     */
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

    /**
     * Metodo responsavel pela mudanca do atributo briografia, atraves do parametro recebido.
     * @param biografia parametro que e atribuido como novo valor do atributo em questao.
     */
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

    /**
     * Metodo responsavel pela mudanca do atributo email, atraves do parametro recebido.
     * @param email parametro que e atribuido como novo valor do atributo em questao.
     */
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

    /**
     * Metodo responsavel pela mudanca do atributo fotoURL, atraves do parametro recebido.
     * @param fotoURL parametro que e atribuido como novo valor do atributo em questao.
     */
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
     * Metodo responsavel pela mudanca do atributo funcao, atraves do parametro recebido.
     * @param funcao parametro que e atribuido como novo valor do atributo em questao.
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * Metodo responsavel por retornar o status de ativacao do pesquisador.
     * @return em boolean, true caso o pesquisador esteja ativado e false caso nao esteja.
     */
    public boolean isAtivado() {
        return ativado;
    }

    /**
     * Metodo responsavel pela mudanca do atributo ativado, atraves do parametro recebido.
     * @param ativado parametro que e atribuido como novo valor do atributo em questao.
     */
    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }

    /**
     * Metódo responsável por retornar as características gerais de um pesquisador.
     * @return representação em String das características gerais de um pesquisador.
     */
    @Override
    public String toString() {
        return nome + " (" + funcao + ") - " + biografia + " - " + email + " - " + fotoURL;
    }
}
