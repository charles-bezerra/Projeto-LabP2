package projetoLP2.controladores;

import easyaccept.EasyAccept;
import projetoLP2.util.Verificador;

import java.util.ArrayList;

/**
 * Controller Geral que gerencia e se comunica com os demais controllers mais especializados
 * @authors Charles Bezerra de Oliveira, Melquisedeque Carvalho Silva...
 */

public class Controle {
    private ControleProblemaObjetivo problemaObjetivo;
    private ControlePesquisa pesquisaControle;
    private ControleAtividade controleAtividade;
    private ControlePesquisador controlePesquisadores;
    private ControlePesquisaPesquisador controlePesquisaPesquisador;

    public Controle() {
        this.problemaObjetivo = new ControleProblemaObjetivo();
        this.pesquisaControle = new ControlePesquisa();
        this.controleAtividade = new ControleAtividade();
        this.controlePesquisadores = new ControlePesquisador();
        this.controlePesquisaPesquisador = new ControlePesquisaPesquisador(
                pesquisaControle.getPesquisas(),
                controlePesquisadores.getPesquisadores());
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

    public boolean associaPesquisador(String idPesquisa, String emailPesquisador){
        return controlePesquisaPesquisador.associaPesquisador(idPesquisa, emailPesquisador);
    }

    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador){
        return controlePesquisaPesquisador.desassociaPesquisador(idPesquisa, emailPesquisador);
    }

    public String busca(String termo) {

        Verificador.verificaString("Campo termo nao pode ser nulo ou vazio.", termo);
        ArrayList<String> buscaOrdenada = new ArrayList<String>();
        buscaOrdenada.addAll(pesquisaControle.ordenaPesquisa(termo));
        buscaOrdenada.addAll(controlePesquisadores.ordenaPesquisador(termo));
        buscaOrdenada.addAll(problemaObjetivo.ordenaProblema(termo));
        buscaOrdenada.addAll(problemaObjetivo.ordenaObjetivo(termo));
        buscaOrdenada.addAll(controleAtividade.ordenaAtividade(termo));

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

        ArrayList<String> buscaOrdenada = new ArrayList<String>();
        buscaOrdenada.addAll(pesquisaControle.ordenaPesquisa(termo));
        buscaOrdenada.addAll(controlePesquisadores.ordenaPesquisador(termo));
        buscaOrdenada.addAll(problemaObjetivo.ordenaProblema(termo));
        buscaOrdenada.addAll(problemaObjetivo.ordenaObjetivo(termo));
        buscaOrdenada.addAll(controleAtividade.ordenaAtividade(termo));
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
        ArrayList<String> buscaOrdenada = new ArrayList<String>();
        buscaOrdenada.addAll(pesquisaControle.ordenaPesquisa(termo));
        buscaOrdenada.addAll(controlePesquisadores.ordenaPesquisador(termo));
        buscaOrdenada.addAll(problemaObjetivo.ordenaProblema(termo));
        buscaOrdenada.addAll(problemaObjetivo.ordenaObjetivo(termo));
        buscaOrdenada.addAll(controleAtividade.ordenaAtividade(termo));
        Verificador.verificaInteiro("Nenhum resultado encontrado",buscaOrdenada.size());

        return buscaOrdenada.size();


    }


    public static void main(String[] args){
        args = new String[] {"projetoLP2.facades.Facade",
                "testes/aceitacao/use_case_1.txt",
                "testes/aceitacao/use_case_2.txt",
                "testes/aceitacao/use_case_3.txt",
                "testes/aceitacao/use_case_4.txt",
                "testes/aceitacao/use_case_5.txt",
                "testes/aceitacao/use_case_6.txt",
                "testes/aceitacao/use_case_7.txt",
                "testes/aceitacao/use_case_8.txt"
        };
        EasyAccept.main(args);
    }
}

