package projetoLP2.controladores;

import projetoLP2.util.Verificador;

import java.util.ArrayList;

/**
 * Controller Geral que gerencia e se comunica com os demais controllers mais especializados
 * @authors Charles Bezerra de Oliveira, Melquisedeque Carvalho Silva...
 */

public class Controle {
    private ControleProblema controleProblema;
    private ControleObjetivo controleObjetivo;
    private ControlePesquisa controlePesquisa;
    private ControleAtividade controleAtividade;
    private ControlePesquisador controlePesquisadores;
    private ControlePesquisaPesquisador controlePesquisaPesquisador;

    public Controle() {
        this.controleProblema = new ControleProblema();
        this.controleObjetivo = new ControleObjetivo();
        this.controlePesquisa = new ControlePesquisa();
        this.controleAtividade = new ControleAtividade();
        this.controlePesquisadores = new ControlePesquisador();
        this.controlePesquisaPesquisador = new ControlePesquisaPesquisador(
                controlePesquisa.getPesquisas(),
                controlePesquisadores.getPesquisadores()
        );
    }

    public String cadastraPesquisa(String descricao, String campoDeInteresse) {
        return controlePesquisa.cadastraPesquisa(descricao, campoDeInteresse);
    }

    public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
        controlePesquisa.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
    }

    public void encerraPesquisa(String codigo, String motivo) {
        controlePesquisa.encerraPesquisa(codigo, motivo);
    }

    public void ativaPesquisa(String codigo) {
        controlePesquisa.ativaPesquisa(codigo);
    }

    public boolean pesquisaEhAtiva(String codigo) {
        return controlePesquisa.pesquisaEhAtiva(codigo);
    }

    public String exibePesquisa(String codigo) {
        return controlePesquisa.exibePesquisa(codigo);
    }

    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String fotoURL){
        controlePesquisadores.cadastraPesquisador(nome, funcao, biografia, email, fotoURL);
    }

    public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data){
        controlePesquisadores.cadastraEspecialidadeProfessor(email, formacao, unidade, data);
    }

    public void cadastraEspecialidadeAluno(String email, String semestre, String IEA){
        controlePesquisadores.cadastraEspecialidadeAluno(email, semestre, IEA);
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

    public String listaPesquisadores(String tipo){ return controlePesquisadores.listaPesquisadores(tipo); }

    public String cadastraProblema(String descricao, int viabilidade) {
        return controleProblema.cadastraProblema(descricao, viabilidade);
    }

    public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
        return controleObjetivo.cadastraObjetivo(tipo, descricao, aderencia, viabilidade);
    }

    public void apagarProblema(String codigo) {
        controleProblema.apagarProblema(codigo);
    }

    public void apagarObjetivo(String codigo) {
        controleObjetivo.apagarObjetivo(codigo);
    }

    public String exibeProblema(String codigo) {
        return controleProblema.exibeProblema(codigo);
    }

    public String exibeObjetivo(String codigo) {
        return controleObjetivo.exibeObjetivo(codigo);
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

    public boolean associaPesquisador(String idPesquisa, String emailPesquisador){
        return controlePesquisaPesquisador.associaPesquisador(idPesquisa, emailPesquisador);
    }

    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador){
        return controlePesquisaPesquisador.desassociaPesquisador(idPesquisa, emailPesquisador);
    }

    public String busca(String termo) {

        Verificador.verificaString("Campo termo nao pode ser nulo ou vazio.", termo);
        ArrayList<String> buscaOrdenada = new ArrayList<String>(buscasOrdenadas(termo));

        String retorno = "";
        int contador = 0;

        for (String atual : buscaOrdenada) {
            if (contador == 0) {
                retorno += atual;
                contador = 1;
            } else {
                retorno += " | " + atual;
            }
        }

        return retorno;

    }
    public String busca(String termo, int numeroDoResultado) {
        Verificador.verificaString("Campo termo nao pode ser nulo ou vazio.", termo);
        Verificador.verificaInteiro("Numero do resultado nao pode ser negativo", numeroDoResultado);

        ArrayList<String> buscaOrdenada = new ArrayList<String>(buscasOrdenadas(termo));
        String retorno = "";
        int contador = 1;

        if (numeroDoResultado > buscaOrdenada.size()) {
            throw new IllegalArgumentException("Entidade nao encontrada.");

        } else {

            for (String atual : buscaOrdenada) {
                if (contador == numeroDoResultado) {
                    retorno += atual;
                }

                contador += 1;
            }
            return retorno;
        }

    }
    public int contaResultadosBusca(String termo) {
        Verificador.verificaString("Campo termo nao pode ser nulo ou vazio.", termo);
        ArrayList<String> buscaOrdenada = new ArrayList<String>(buscasOrdenadas(termo));
        Verificador.verificaInteiro("Nenhum resultado encontrado",buscaOrdenada.size());

        return buscaOrdenada.size();
    }


    private ArrayList<String> buscasOrdenadas(String termo){
        Verificador.verificaString("Campo termo nao pode ser nulo ou vazio.", termo);
        ArrayList<String> buscaOrdenada = new ArrayList<String>();

        buscaOrdenada.addAll(controlePesquisa.ordenaPesquisa(termo));
        buscaOrdenada.addAll(controlePesquisadores.ordenaPesquisador(termo));
        buscaOrdenada.addAll(controleProblema.ordenaProblema(termo));
        buscaOrdenada.addAll(controleObjetivo.ordenaObjetivo(termo));
        buscaOrdenada.addAll(controleAtividade.ordenaAtividade(termo));
        return buscaOrdenada;
    }
}

