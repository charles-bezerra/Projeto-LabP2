package projetoLP2.facades;

import easyaccept.EasyAccept;
import projetoLP2.controladores.ControleAtividade;
import projetoLP2.controladores.ControlePesquisa;
import projetoLP2.controladores.ControlePesquisador;
import projetoLP2.controladores.ControleProblemaObjetivo;

public class Facade {
    /**
     * Classe controlodadora da classe Problema e da classe Objetivo.
     */
    ControleProblemaObjetivo problemaObjetivo;
    ControlePesquisa pesquisaControle;
    ControleAtividade controleAtividade;
    ControlePesquisador controlePesquisadores;


    public Facade() {
        problemaObjetivo = new ControleProblemaObjetivo();
        pesquisaControle = new ControlePesquisa();
        controleAtividade = new ControleAtividade();
        controlePesquisadores = new ControlePesquisador();
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


    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String fotoURL){
        controlePesquisadores.cadastraPesquisador(nome, funcao, biografia, email, fotoURL);
    }

    public void alteraPesquisador(String email, String atributo, String novoValor){
        controlePesquisadores.alteraPesquisador(email, atributo, novoValor);
    }

    public void desativaPesquisador(String email){
        controlePesquisadores.desativaPesquisador(email);
    }

    public void ativaPesquisador(String email){
        controlePesquisadores.ativaPesquisador(email);
    }

    public String exibePesquisador(String email){
        return controlePesquisadores.exibePesquisador(email);
    }

    public boolean pesquisadorEhAtivo(String email){
        return controlePesquisadores.pesquisadorEhAtivo(email);
    }


    public String cadastraProblema(String descricao, int viabilidade) {
        return problemaObjetivo.cadastraProblema(descricao, viabilidade);
    }

    public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
        return problemaObjetivo.cadastraObjetivo(tipo, descricao, aderencia, viabilidade);
    }

    public void apagarProblema(String codigo) {
        problemaObjetivo.apagarProblema(codigo);
    }

    public void apagarObjetivo(String codigo) {
        problemaObjetivo.apagarObjetivo(codigo);
    }

    public String exibeProblema(String codigo) {
        return problemaObjetivo.exibeProblema(codigo);
    }

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
    public static void main(String[] args){
    	args = new String[] {"projetoLP2.facades.Facade",
			"Psquiza/aceitacao_teste/use_case_1.txt",
			"Psquiza/aceitacao_teste/use_case_2.txt",
			"Psquiza/aceitacao_teste/use_case_3.txt",
			"Psquiza/aceitacao_teste/use_case_4.txt"
    	};
		EasyAccept.main(args);
    }
}
