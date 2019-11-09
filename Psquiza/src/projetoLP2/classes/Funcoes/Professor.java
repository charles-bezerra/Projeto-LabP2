package projetoLP2.classes.Funcoes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;
import projetoLP2.util.Verificador;
/**
 * Representa a escialidade Professor de um pesquisador.
 * Contendo as características da função 'professor'
 * de um pesquisador.
 * @author Iago Henrique de Souza Silva
 */
public class Professor implements Funcao {
    /**
     * O nome da função, contante como 'PROFESSOR'
     */
    private TipoFuncao nome;
    /**
     * A formação do professor
     */
    private String formacao;
    /**
     * A unidade em que o professor se formou
     */
    private String unidade;
    /**
     * A data em que o professor se formou
     */
    private String data;


    /**
     * Constroi as características do professor.
     * @param data A data em que o pesquisador se formou
     * @param unidade A unidade em que o pesquisador se formou
     */
    public Professor(String formacao, String unidade, String data){
        Verificador.verificaString("Campo formacao nao pode ser nulo ou vazio.", formacao);
        Verificador.verificaString("Campo unidade nao pode ser nulo ou vazio.", unidade);
        Verificador.verificaString("Campo data nao pode ser nulo ou vazio.", data);
        Verificador.verificaData("Atributo data com formato invalido.", data);

        nome = TipoFuncao.PROFESSOR;
        this.formacao = formacao;
        this.unidade = unidade;
        this.data = data;
    }


    /**
     * Metodo responsavel por alterar um atributo do professor
     * @param atributo representa o atributo que determinado professor quer alterar.
     * @param novoValor representa o novo valor para o atributo desejado.
     */
    @Override
    public void alteraEspecialidade(String atributo, String novoValor) {
        Verificador.verificaString("Campo " + atributo.toLowerCase() + " nao pode ser nulo ou vazio.", novoValor);
        switch (atributo.toUpperCase()) {
            case "FORMACAO":
                setFormacao(novoValor);
                break;
            case "UNIDADE":
                setUnidade(novoValor);
                break;
            case "DATA":
                Verificador.verificaData("Atributo data com formato invalido.", novoValor);
                setData(novoValor);
                break;
            default:
                throw new IllegalArgumentException("Atributo invalido.");
        }
    }

    /**
     * Troca a formacao atual do professor por uma nova formacao
     * @param formacao a nova formacao
     */
    private void setFormacao(String formacao){
        this.formacao = formacao;
    }

    /**
     * Troca a unidade atual do professor por uma nova unidade
     * @param unidade a nova unidade
     */
    private void setUnidade(String unidade){
        this.unidade = unidade;
    }

    /**
     * Troca a data atual do professor por uma nova data
     * @param data a nova data
     */
    private void setData(String data){
        this.data = data;
    }

    /**
     * Captura o nome desta especialidade e o retorna.
     * @return o nome desta especialidade.
     */
    @Override
    public String getNome() {
        return nome.getFuncao();
    }


    /**
     * Retorna a representacao textual da funcao professor
     * @return a represetacao textual no formato ' - formacao - unidade - data'.
     */
    @Override
    public String toString() {
        return String.format(" - %s - %s - %s",
                formacao,unidade,data);
    }
}
