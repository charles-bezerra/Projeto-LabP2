package projetoLP2.facades;

import easyaccept.EasyAccept;

import projetoLP2.controladores.*;
import projetoLP2.excessoes.PesistenciaException;

public class Facade {
    private Controle controle;

    public Facade() {
        this.controle = new Controle();

    }
    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        return controle.cadastraPesquisa(descricao, campoDeInteresse);
    }

    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        controle.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
    }

    public void encerraPesquisa(String codigo, String motivo) {
        controle.encerraPesquisa(codigo, motivo);
    }

    public void ativaPesquisa(String codigo) {
        controle.ativaPesquisa(codigo);
    }

    public boolean pesquisaEhAtiva(String codigo) {
        return controle.pesquisaEhAtiva(codigo);
    }

    public String exibePesquisa(String codigo) {
        return controle.exibePesquisa(codigo);
    }

    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String fotoURL){
        controle.cadastraPesquisador(nome, funcao, biografia, email, fotoURL);
    }

    public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data){
        controle.cadastraEspecialidadeProfessor(email, formacao, unidade, data);
    }

    public void cadastraEspecialidadeAluno(String email, String semestre, String IEA){
        controle.cadastraEspecialidadeAluno(email, semestre, IEA);
    }

    public void alteraPesquisador(String email, String atributo, String novoValor){
        controle.alteraPesquisador(email, atributo, novoValor);
    }

    public void desativaPesquisador(String email){
        controle.desativaPesquisador(email);
    }

    public void ativaPesquisador(String email){
        controle.ativaPesquisador(email);
    }

    public String exibePesquisador(String email){
        return controle.exibePesquisador(email);
    }

    public boolean pesquisadorEhAtivo(String email){
        return controle.pesquisadorEhAtivo(email);
    }

    public String listaPesquisadores(String tipo){ return controle.listaPesquisadores(tipo); }

    public String cadastraProblema(String descricao, int viabilidade) {
        return controle.cadastraProblema(descricao, viabilidade);
    }

    public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
        return controle.cadastraObjetivo(tipo, descricao, aderencia, viabilidade);
    }

    public void apagarProblema(String codigo) {
        controle.apagarProblema(codigo);
    }

    public void apagarObjetivo(String codigo) {
        controle.apagarObjetivo(codigo);
    }

    public String exibeProblema(String codigo) {
        return controle.exibeProblema(codigo);
    }

    public String exibeObjetivo(String codigo) {
        return controle.exibeObjetivo(codigo);
    }


    public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco){
        return this.controle.cadastraAtividade(descricao, nivelRisco, descricaoRisco);
    }

    public void apagaAtividade(String codigo){
        this.controle.apagaAtividade(codigo);
    }

    public void cadastraItem(String codigo, String item){
        this.controle.cadastraItem(codigo, item);
    }

    public String exibeAtividade(String codigo){
        return this.controle.exibeAtividade(codigo);
    }

    public int contaItensPendentes(String codigo){
        return this.controle.contaItensPendentes(codigo);
    }

    public int contaItensRealizados(String codigo){
        return this.controle.contaItensRealizados(codigo);
    }

    public boolean associaPesquisador(String idPesquisa, String emailPesquisador){
        return controle.associaPesquisador(idPesquisa, emailPesquisador);
    }

    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador){
        return controle.desassociaPesquisador(idPesquisa, emailPesquisador);
    }

    public String busca(String termo){
        return this.controle.busca(termo);
    }

    public String busca(String termo, int numeroDoResultado){
        return this.controle.busca(termo, numeroDoResultado);
    }

    public boolean associaProblema(String idPesquisa, String idProblema) {
        return this.controle.associaProblema(idPesquisa, idProblema);
    }

    public boolean desassociaProblema(String idPesquisa) {
        return this.controle.desassociaProblema(idPesquisa);
    }

    public boolean associaObjetivo(String idPesquisa, String idObjetivo) {
        return this.controle.associaObjetivo(idPesquisa, idObjetivo);
    }

    public boolean desassociaObjetivo(String idPesquisa, String idObjetivo){
        return this.controle.desassociaObjetivo(idPesquisa, idObjetivo);
    }

    public String listaPesquisas(String ordem) {
        return this.controle.listaPesquisas(ordem);
    }

    public int contaResultadosBusca(String termo){
        return this.controle.contaResultadosBusca(termo);
    }

    public boolean associaAtividade(String codigoPesquisa, String codigoAtividade) { return this.controle.associaAtividade(codigoPesquisa, codigoAtividade); }

    public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) { return this.controle.desassociaAtividade(codigoPesquisa, codigoAtividade); }

    public void executaAtividade(String codigoAtividade, int item, int duracao) { this.controle.executaAtividade(codigoAtividade, item, duracao); }

    public int cadastraResultado(String codigoAtividade, String resultado) { return this.controle.cadastraResultado(codigoAtividade, resultado); }

    public boolean removeResultado(String codigoAtividade, int numeroResultado) { return this.controle.removeResultado(codigoAtividade, numeroResultado); }

    public String listaResultados(String codigoAtividade) { return this.controle.listaResultados(codigoAtividade); }

    public int getDuracao(String codigoAtividade) { return this.controle.getDuracao(codigoAtividade); }

    public void defineProximaAtividade(String idPrecedente, String idSubsquente){controle.defineProximaAtividade(idPrecedente, idSubsquente); }

    public void tiraProximaAtividade(String idPrecedente){controle.tiraProximaAtividade(idPrecedente);}

    public int contaProximos(String idPrecedente){ return controle.contaProximos(idPrecedente); }

    public String pegaProximo(String idAtividade, int enesimaAtividade){return controle.pegaProximo(idAtividade, enesimaAtividade);}

    public String pegaMaiorRiscoAtividades(String idAtividade){return controle.pegaMaiorRiscoAtividades(idAtividade);}

    public void configuraEstrategia(String estrategia) { controle.configuraEstrategia(estrategia); }

    public String proximaAtividade(String codigoPesquisa) { return controle.proximaAtividade(codigoPesquisa); }

    public void gravarResumo(String codigoPesquisa){
        controle.gravarResumo(codigoPesquisa);
    }
    public void gravarResultados(String codigoPesquisa) {
        controle.gravarResultados(codigoPesquisa);
    }

    public void salvar() throws PesistenciaException{
        this.controle.salva();
    }

    public void carregar() throws PesistenciaException {
        this.controle.carrega();
    }
}