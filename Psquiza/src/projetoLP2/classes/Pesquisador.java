package projetoLP2.classes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.classes.Funcoes.*;
import projetoLP2.enums.TipoFuncao;
import projetoLP2.util.Verificador;

import java.util.Objects;

/**
 * Classe responsavel por representar um pesquisador e guardar seus dados.
 * @author Melquisedeque Carvalho SIlva, Iago Henrique de Souza Silva
 */
public class Pesquisador implements Comparable<Pesquisador>{
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
    private String email;
    /**
     * Atributo que representa a url da foto de um pesquisador.
     */
    private String fotoURL;
    /**
     * Atributo que representa a funcao de um pesquisador.
     * Variando entre Aluno, Professor e externo.
     */
    private Funcao funcao;
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
        Verificador.verificaString("Campo nome nao pode ser nulo ou vazio.", nome);
        Verificador.verificaString("Campo funcao nao pode ser nulo ou vazio.", funcao);
        Verificador.verificaString("Campo biografia nao pode ser nulo ou vazio.", biografia);
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        Verificador.verificaString("Campo fotoURL nao pode ser nulo ou vazio.", fotoURL);

        switch (funcao.toUpperCase()) {
            case "ESTUDANTE":
                this.funcao = new AlunoSemEspecialidades();
                break;
            case "PROFESSOR":
                this.funcao = new ProfessorSemEspecialidades();
                break;
            case "EXTERNO":
                this.funcao = new Externo();
                break;
            default:
                throw new IllegalArgumentException("Tipo " + funcao + " inexistente");
        }

        verificaEmail(email);
        verificaFoto(fotoURL);

        this.nome = nome;
        this.biografia = biografia;
        this.email = email;
        this.fotoURL = fotoURL;
        this.ativado = true;
    }


    /**
     * Metodo responsavel por alterar um atributo do pesquisador
     * @param atributo representa o atributo que determinado pesquisador quer alterar.
     * @param novoValor representa o novo valor para o atributo desejado.
     */
    public void alteraAtributo(String atributo, String novoValor) {
        Verificador.verificaString("Atributo nao pode ser vazio ou nulo.", atributo);

        if(!isAtivado()){
            throw new IllegalArgumentException("Pesquisador inativo.");
        }
        switch (atributo) {
            case "EMAIL":
                Verificador.verificaString("Campo " + atributo.toLowerCase() + " nao pode ser nulo ou vazio.", novoValor);
                setEmail(novoValor);
                break;
            case "FUNCAO":
                Verificador.verificaString("Campo " + atributo.toLowerCase() + " nao pode ser nulo ou vazio.", novoValor);
                alteraFuncao(novoValor);
                break;
            case "FOTO":
                Verificador.verificaString("Campo fotoURL nao pode ser nulo ou vazio.", novoValor);
                setFotoURL(novoValor);
                break;
            case "NOME":
                Verificador.verificaString("Campo " + atributo.toLowerCase() + " nao pode ser nulo ou vazio.", novoValor);
                setNome(novoValor);
                break;
            case "BIOGRAFIA":
                Verificador.verificaString("Campo " + atributo.toLowerCase() + " nao pode ser nulo ou vazio.", novoValor);
                setBiografia(novoValor);
                break;
            default:
                funcao.alteraEspecialidade(atributo,novoValor);
        }
    }


    /**
     * Verifica se uma string se enquadra nos padroes do email.
     * Tendo pelo menos um caractere antes e depois do @.
     */
    private void verificaEmail(String email){
        if(!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Formato de email invalido.");
        }
    }


    /**
     * Verifica se uma string se enquadra nos padroes de url.
     * Inciando com http:// ou https://, seguido de um endereço
     */
    private void verificaFoto(String url){
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
    private String getNome() {
        return nome;
    }
    /**
     * Troca o nome atual do pesquisador por um novo nome
     * @param nome o novo nome
     */
    private void setNome(String nome) {
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
     * Troca a biografia atual do pesquisador por uma nova biografia
     * @param biografia a nova biografia
     */
    private void setBiografia(String biografia) {
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
     * Troca o email atual do pesquisador por um novo email
     * @param email o novo email
     */
    private void setEmail(String email) {
        verificaEmail(email);
        this.email = email;
    }

    /**
     * Metodo responsavel por retornar a url da foto do pesquisador.
     * @return em String o que estiver contido no atributo fotoURL.
     */
    private String getFotoURL() {
        return fotoURL;
    }
    /**
     * Troca a foto atual do pesquisador por uma nova foto
     * @param fotoURL a nova foto
     */
    private void setFotoURL(String fotoURL) {
        verificaFoto(fotoURL);
        this.fotoURL = fotoURL;
    }

    /**
     * Metodo responsavel por retornar a funcao do pesquisador.
     * @return em String o que estiver contido no atributo funcao.
     */
    public String getFuncao() {
        return funcao.getNome();
    }
    /**
     * Troca a funcao atual do pesquisador por uma nova funcao sem especialidade
     * @param funcao a nova funcao
     */
    private void alteraFuncao(String funcao) {
        switch (funcao.toUpperCase()) {
            case "ESTUDANTE":
                this.funcao = new AlunoSemEspecialidades();
                break;
            case "PROFESSOR":
                this.funcao = new ProfessorSemEspecialidades();
                break;
            case "EXTERNO":
                this.funcao = new Externo();
                break;
            default:
                throw new IllegalArgumentException("Tipo " + funcao + " inexistente");
        }
    }


    /**
     * Cadastra os atributos especificos da funcao professor no pesquisador.
     * @param formacao representa a formacao do pesquisador
     * @param unidade representa a unidade do pesquisador
     * @param data representa a data em que o pesquisador se formou
     */
    public void setEspecialidadeProfessor(String formacao, String unidade, String data){
        if(!getFuncao().toUpperCase().equals(TipoFuncao.PROFESSOR.getFuncao())){
            throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
        }
        this.funcao = new Professor(formacao, unidade, data);
    }


    /**
     * Cadastra os atributos especificos da funcao aluno no pesquisador.
     * @param semestre representa o semestre em que o pesquisador esta
     * @param IEA representa o IEA do pesquisador
     */
    public void setEspecialidadeAluno(String semestre, String IEA){
        if(!getFuncao().toUpperCase().equals(TipoFuncao.ESTUDANTE.getFuncao())){
            throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
        }
        this.funcao = new Aluno(semestre, IEA);
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
        return String.format("%s (%s) - %s - %s - %s",getNome(),getFuncao().toLowerCase(),getBiografia(),getEmail(),getFotoURL())
                + funcao.toString();
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

    /**
     * Compara se este pesquisador eh igual a outro pelo email deles
     *
     * @param o representa outro objeto para a comparação.
     * @return um inteiro referente a comparação entre os objetos.
     */
    @Override
    public int compareTo(Pesquisador o) {
        return o.getEmail().compareTo(this.getEmail());
    }

}
