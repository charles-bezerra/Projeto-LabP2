package unidade.controladores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import projetoLP2.classes.Atividade;

import projetoLP2.controladores.ControlePesquisa;

import static org.junit.jupiter.api.Assertions.*;

class ControlePesquisaTest {
    private Atividade a1, a2;
    private Exception e;

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

        a1 = new Atividade(
                "Uma simples atividade",
                "BAIXO",
                "E simples, entao e facil."
        );

        a2 = new Atividade(
                "Uma atividade complicada",
                "ALTO",
                "E dificil, porque nao sei.");

        pesquisas.cadastraPesquisa(
                "teste",
                "TESTE");
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
            fail();
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
            fail();
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
    void testAssociaAtividade() {
        e = assertThrows(IllegalArgumentException.class, () ->
                pesquisas.associaAtividade("", a1) );

        assertEquals(
                "Campo codigoPesquisa nao pode ser nulo ou vazio.",
                e.getMessage()
        );

        e = assertThrows(IllegalArgumentException.class, () ->
                pesquisas.associaAtividade(null, a1)
        );

        assertEquals(
                "Campo codigoPesquisa nao pode ser nulo ou vazio.",
                e.getMessage()
        );

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                pesquisas.associaAtividade("TES", a1)
        );

        assertEquals(
                "Pesquisa nao encontrada.",
                e.getMessage()
        );


        assertTrue(pesquisas.associaAtividade("TES1",a1));
        assertFalse(pesquisas.associaAtividade("TES1",a1));

        pesquisas.encerraPesquisa("TES1","AAAA");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                pesquisas.associaAtividade("TES1", a1));

        assertEquals("Pesquisa desativada.", e.getMessage());
    }

    @Test
    void testDesassociaAtividade() {
        e = assertThrows(IllegalArgumentException.class, () ->
                pesquisas.desassociaAtividade("", a1));

        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () ->
                pesquisas.desassociaAtividade(null, a1));

        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () ->
                pesquisas.desassociaAtividade("TES", a1));

        assertEquals("Pesquisa nao encontrada.", e.getMessage());

        pesquisas.associaAtividade("TES1",a1);

        assertTrue(pesquisas.desassociaAtividade("TES1",a1));

        assertFalse(pesquisas.desassociaAtividade("TES1",a1));

        pesquisas.encerraPesquisa("TES1","AAAA");

        e = assertThrows(IllegalArgumentException.class, () ->
                pesquisas.desassociaAtividade("TES1", a1));

        assertEquals(
                "Pesquisa desativada.",
                e.getMessage()
        );

        pesquisas.ativaPesquisa("TES1");
    }

    @Test
    void associaPesquisador() {
    }

    @Test
    void desassociaPesquisador() {
    }
}