package projetoLP2.controladores;

import projetoLP2.classes.Atividade;
import projetoLP2.util.Verificador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador das atividades do sistema
 * @author Charles Bezerra de Oliveira Junior
 */
public class ControleAtividade {
    /**
     * Mapa contendo todas as atividades cadastradas e seu id
     */
    private Map<String, Atividade> atividades;

    /**
     * Constroi o controle e atribui o mapa de atividades com HashMap
     */
    public ControleAtividade(){
        this.atividades = new HashMap<>();
    }

    /**
     * Verifica se existe uma determinada pesquisa
     * @param codigo endereco e identificacao da atividade
     * @return boolean atestando se existe a atividade ou nao
     */
    private boolean encontraAtividade(String codigo){
        Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
        return this.atividades.containsKey(codigo);
    }

    /**
     * Cadastra uma atividade no controle
     * @param descricao descricao da atividade
     * @param nivelRisco nivel do risco da realizacao da atividade
     * @param descricaoRisco descricao do risco envolvido
     * @return retorna o codigo da tividade gerado automaticamente (A + Inteiro)
     */
    public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco){
        Atividade atividade = new Atividade(descricao, nivelRisco, descricaoRisco);
        this.atividades.put(atividade.getCodigo(), atividade);
        return atividade.getCodigo();
    }

    /**
     * Apaga uma atividade
     * @param codigo endereco e identificacao da atividade
     */
    public void apagaAtividade(String codigo){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        this.atividades.remove(codigo);
    }

    /**
     * Cadastra ou adiciona um Item no sistema
     * @param codigo endereco e identificacao da atividade
     * @param item item a ser adicionado ao controle
     */
    public void cadastraItem(String codigo, String item){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        this.atividades.get(codigo).cadastraItem(item);
    }

    /**
     * Retorna uma exibicao de uma atividade
     * @param codigo endereco e identificacao da atividade
     * @return retorna um String com a represantacao da atividade
     */
    public String exibeAtividade(String codigo){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        return this.atividades.get(codigo).toString();
    }

    /**
     * Retorna a quantidade do items com status PENDENTES de uma atividade
     * @param codigo endereco e identificacao da atividade
     * @return quantidade de items
     */
    public int contaItensPendentes(String codigo){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        return this.atividades.get(codigo).contaItensPendentes();
    }

    /**
     * Retorna a quantidade do items com status REALIZADO de uma atividade
     * @param codigo endereco e identificacao da atividade
     * @return quantidade de items
     */
    public int contaItensRealizados(String codigo){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        return this.atividades.get(codigo).contaItensRealizados();
    }

    /**
     * Metodo responsavel por adicionar a um Arraylist de forma ordenada todas as atividades que possuem o termo.
     * @param termo o termo a ser buscado nas atividades.
     * @return um ArrayList de Strings com todas as atividades que possuem o termo.
     */
    public ArrayList<String> ordenaAtividade(String termo) {
        ArrayList<Atividade> buscasOrdenadas = new ArrayList<Atividade>(atividades.values());
        Collections.sort(buscasOrdenadas);
        ArrayList<String> retorno = new ArrayList<>();

        for (Atividade atividade : buscasOrdenadas) {
            if (atividade.getDescricao().toLowerCase().contains(termo.toLowerCase()))
                retorno.add(atividade.getCodigo() + ": " + atividade.getDescricao());
            if (atividade.getDescricaoRisco().toLowerCase().contains(termo.toLowerCase()))
                retorno.add(atividade.getCodigo() + ": " + atividade.getDescricaoRisco());
        }
        return retorno;
    }

    /**
     * Retorna uma atividade.
     *
     * @param codigoAtividade o codigo da atividade a ser retornada
     * @return uma atividade
     */
    public Atividade getAtividade(String codigoAtividade) {
        Verificador.verificaString("Campo codigoAtividade nao pode ser nulo ou vazio.", codigoAtividade);
        if(!this.encontraAtividade(codigoAtividade))
            throw new IllegalArgumentException("Atividade nao encontrada");
        return atividades.get(codigoAtividade);
    }

    /**
     * Executa um item de uma atividade.
     *
     * @param codigoAtividade o codigo da atividade a qual o item pertence
     * @param item o numero item a ser executado
     * @param duracao o tempo que demorou para o item ser executado
     */
    public void executaAtividade(String codigoAtividade, int item, int duracao) {
        if(!this.encontraAtividade(codigoAtividade))
            throw new IllegalArgumentException("Atividade nao encontrada");
        atividades.get(codigoAtividade)
                .executaAtividade(item, duracao);
    }

    /**
     * Cadastra um resultado no sistema.
     *
     * @param codigoAtividade o codigo da atividade na qual o resultao sera cadastrado
     * @param resultado o reesultado que sera castrado
     * @return o numero do resultado cadastrado
     */
    public int cadastraResultado(String codigoAtividade, String resultado) {
        Verificador.verificaString("Campo codigoAtividade nao pode ser nulo ou vazio.", codigoAtividade);
        Verificador.verificaString("Resultado nao pode ser nulo ou vazio.", resultado);
        if(!this.encontraAtividade(codigoAtividade))
            throw new IllegalArgumentException("Atividade nao encontrada");
        return atividades.get(codigoAtividade).cadastraResultado(resultado);
    }

    /**
     * Remove um resultado do sistema.
     *
     * @param codigoAtividade o codigo da atividade na qual o resultado esta cadastrado
     * @param numeroResultado o numero do resultado a ser exclluido
     * @return true se a operacao foi um sucesso
     */
    public boolean removeResultado(String codigoAtividade, int numeroResultado) {
        Verificador.verificaString("Campo codigoAtividade nao pode ser nulo ou vazio.", codigoAtividade);
        if(!this.encontraAtividade(codigoAtividade)) { throw new IllegalArgumentException("Atividade nao encontrada"); }
        return atividades.get(codigoAtividade).removeResultado(numeroResultado);
    }

    /**
     * Lista todos os resultados de uma atividade.
     *
     * @param codigoAtividade o codigo da atividade que tera seus resultados listados
     * @return a lista de todoas os resultados de uma atividade
     */
    public String listaResultados(String codigoAtividade) {
        Verificador.verificaString("Campo codigoAtividade nao pode ser nulo ou vazio.", codigoAtividade);
        if(!this.encontraAtividade(codigoAtividade)) { throw new IllegalArgumentException("Atividade nao encontrada"); }
        return atividades.get(codigoAtividade).listaResultados();
    }

    /**
     * Retorna a duracao de uma atividade.
     *
     * @param codigoAtividade o codigo da atividade que se deseja saber a duracao
     * @return a duracao de uma atividade
     */
    public int getDuracao(String codigoAtividade) {
        Verificador.verificaString("Campo codigoAtividade nao pode ser nulo ou vazio.", codigoAtividade);
        if(!this.encontraAtividade(codigoAtividade)) { throw new IllegalArgumentException("Atividade nao encontrada"); }
        return atividades.get(codigoAtividade).getDuracao();
    }
}
