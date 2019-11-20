package unidade.controladores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.classes.Atividade;

import projetoLP2.controladores.ControlePesquisa;

import static org.junit.jupiter.api.Assertions.*;

class ControlePesquisaTest {
    private static ControlePesquisa c = new ControlePesquisa();
    private Atividade a1,a2;
    private Exception e;

    @BeforeEach
    void criaAtividade() {
        a1 = new Atividade("Uma simples atividade","BAIXO","E simples, entao e facil.");
        a2 = new Atividade("Uma atividade complicada","ALTO","E dificil, porque nao sei.");
        c.cadastraPesquisa("teste","TESTE");
    }

    @Test
    void getPesquisa() {
    }

    @Test
    void cadastraPesquisa() {
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
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade("", a1));
        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade(null, a1));
        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade("TES", a1));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());


        assertTrue(c.associaAtividade("TES1",a1));
        assertFalse(c.associaAtividade("TES1",a1));

        c.encerraPesquisa("TES1","AAAA");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade("TES1", a1));
        assertEquals("Pesquisa desativada.", e.getMessage());
    }

    @Test
    void testDesassociaAtividade() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("", a1));
        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade(null, a1));
        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("TES", a1));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());

        c.associaAtividade("TES1",a1);
        assertTrue(c.desassociaAtividade("TES1",a1));
        assertFalse(c.desassociaAtividade("TES1",a1));

        c.encerraPesquisa("TES1","AAAA");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("TES1", a1));
        assertEquals("Pesquisa desativada.", e.getMessage());
        c.ativaPesquisa("TES1");
    }

    @Test
    void encontraAtividade() {
    }

    @Test
    void associaPesquisador() {
    }

    @Test
    void desassociaPesquisador() {
    }
}