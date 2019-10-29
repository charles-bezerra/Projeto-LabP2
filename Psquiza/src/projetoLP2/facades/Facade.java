package projetoLP2.facades;

import projetoLP2.controladores.ControleAtividade;
import projetoLP2.controladores.ControlePesquisa;
import projetoLP2.controladores.ControleProblemaObjetivo;

public class Facade {
    /**
     * Classe controlodadora da classe Problema e da classe Objetivo.
     */
    ControleProblemaObjetivo problemaObjetivo;
    ControlePesquisa pesquisaControle;
    ControleAtividade controleAtividade;


    public Facade() {
        problemaObjetivo = new ControleProblemaObjetivo();
        pesquisaControle = new ControlePesquisa();
        controleAtividade = new ControleAtividade();
    }

    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        return pesquisaControle.cadastraPesquisa(descricao, campoDeInteresse);
    }

    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        pesquisaControle.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
    }


    public void encerraPesquisa(String codigo, String motivo) {
        pesquisaControle.encerraPesquisa(codigo, motivo);
    }


    public void ativaPesquisa(String codigo) {
        pesquisaControle.ativaPesquisa(codigo);
    }


    public boolean pesquisaEhAtiva(String codigo) {
        return pesquisaControle.pesquisaEhAtiva(codigo);
    }


    public String exibePesquisa(String codigo) {
        return pesquisaControle.exibePesquisa(codigo);
    }


    /**
     * Cadastra um problema no sistema.
     *
     * @param descricao a descricao do problema
     * @param viabilidade o valor de viabilidade do problema, numero inteiro de 1 a 5
     * @return null
     */
    public String cadastraProblema(String descricao, int viabilidade) {
        return problemaObjetivo.cadastraProblema(descricao, viabilidade);
    }
    /**
     * Cadastra um objetivo no sistema.
     *
     * @param tipo o tipo do objetivo, GERAL ou ESPECIFICO
     * @param descricao a descricao do objetivo
     * @param aderencia o valor de aderencia do objetivo, numero inteiro de 1 a 5
     * @param viabilidade o valor de vibilidade do objetivo, numero inteiro de 1 a 5
     * @return null
     */
    public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
        return problemaObjetivo.cadastraObjetivo(tipo, descricao, aderencia, viabilidade);
    }
    /**
     * Apaga um problema do sistema.
     *
     * @param codigo o codigo de identificacao do problema
     */
    public void apagarProblema(String codigo) {
        problemaObjetivo.apagarProblema(codigo);
    }
    /**
     * Apaga um objetivo do sistema.
     *
     * @param codigo o codigo de identificacao do objetivo
     */
    public void apagarObjetivo(String codigo) {
        problemaObjetivo.apagarObjetivo(codigo);
    }
    /**
     * Exibe um problema cadastrado no sistema.
     *
     * @param codigo o codigo de identificacao do problema
     * @return o codigo de identificacao do problema + a representacao em String de um problema
     */
    public String exibeProblema(String codigo) {
        return problemaObjetivo.exibeProblema(codigo);
    }
    /**
     * Exibe um objetivo cadastrado no sistema.
     *
     * @param codigo o codigo de identificacao do objetivo
     * @return o codigo de identificacao do objetivo + a representacao em String de um objetivo
     */
    public String exibeObjetivo(String codigo) {
        return problemaObjetivo.exibeObjetivo(codigo);
    }


    public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco){
        return this.controleAtividade.cadastraAtividade(descricao, nivelRisco, descricaoRisco);
    }

    public void apagaAtividade(String codigo){
        this.controleAtividade.apagaAtividade(codigo);
    }

    public void cadastraItem(String codigo, String item){
        this.controleAtividade.cadastraItem(codigo, item);
    }

    public String exibeAtividade(String codigo){
        return this.controleAtividade.exibeAtividade(codigo);
    }

    public int contaItensPendentes(String codigo){
        return this.controleAtividade.contaItensPendentes(codigo);
    }

    public int contaItensRealizados(String codigo){
        return this.controleAtividade.contaItensRealizados(codigo);
    }
}
