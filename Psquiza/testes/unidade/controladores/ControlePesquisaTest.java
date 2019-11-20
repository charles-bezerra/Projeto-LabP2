package unidade.controladores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.controladores.ControlePesquisa;

import static org.junit.jupiter.api.Assertions.*;

class ControlePesquisaTest {

    private ControlePesquisa pesquisas;
    private String pesquisa1;

    @BeforeEach
    void criaObjetos(){
        this.pesquisas = new ControlePesquisa();
        this.pesquisa1 = this.pesquisas
                .cadastraPesquisa(
                        "Estuda da atmosfera brasileira.",
                        "Computação"
                );
    }

    @Test
    void cadastraPesquisa(){
        assertEquals(
                "COM2",
                this.pesquisas
                        .cadastraPesquisa(
                                "Estuda de computação",
                                "Computação")
        );
        assertEquals(
                "CIE1",
                this.pesquisas
                        .cadastraPesquisa(
                                "Estuda da ciência",
                                "Ciencia")
        );
    }

    @Test
    void cadastraPesquisaComDescricaoNula() {
        try {
            this.pesquisas.cadastraPesquisa(
                    null,
                    "Computação"
            );
        }
        catch (IllegalArgumentException e){
            assertEquals("java.lang.IllegalArgumentException: Descricao nao pode ser nula ou vazia.",
                    e.toString());
        }
    }

    @Test
    void cadastraPesquisaComDescricaoInvalida() {
        try {
            this.pesquisas.cadastraPesquisa(
                    "",
                    "Computação"
            );
        }
        catch (IllegalArgumentException e){
            assertEquals(
                    "java.lang.IllegalArgumentException: Descricao nao pode ser nula ou vazia.",
                    e.toString()
            );
        }
    }

    @Test
    void alteraPesquisa() {

    }

    @Test
    void encerraPesquisa() {
    }

    @Test
    void ativaPesquisa() {
    }

    @Test
    void pesquisaEhAtiva() {
    }

    @Test
    void exibePesquisa() {
    }

    @Test
    void getPesquisas() {
    }

    @Test
    void ordenaPesquisa() {
    }

    @Test
    void associaProblema() {
    }

    @Test
    void desassociaProblema() {
    }

    @Test
    void associaObjetivo() {
    }

    @Test
    void desassociaObjetivo() {
    }

    @Test
    void listaPesquisas() {
    }

    @Test
    void associaAtividade() {
    }

    @Test
    void desassociaAtividade() {
    }

    @Test
    void associaPesquisador() {
    }

    @Test
    void desassociaPesquisador() {
    }
}