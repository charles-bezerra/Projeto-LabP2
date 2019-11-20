package unidade.controladores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import projetoLP2.controladores.Controle;

import static org.junit.jupiter.api.Assertions.*;


class ControleTest {
    private static Controle c = new Controle();
    private Exception e;

    @BeforeEach
    void criaAtividade() {
        c.cadastraAtividade("Uma simples atividade","BAIXO","E simples, entao e facil.");
        c.cadastraAtividade("Uma atividade complicada","ALTO","E dificil, porque nao sei.");
        c.cadastraPesquisa("teste","TESTE");
    }

    @org.junit.jupiter.api.Test
    void testAssociaAtividade() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade("", "A1"));
        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade(null, "A1"));
        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade("TES1", ""));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade("TES1", null));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade("TES", "A1"));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade("TES1", "A"));
        assertEquals("Atividade nao encontrada", e.getMessage());

        assertTrue(c.associaAtividade("TES1","A1"));
        assertFalse(c.associaAtividade("TES1","A1"));

        c.encerraPesquisa("TES1","AAAA");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaAtividade("TES1", "A1"));
        assertEquals("Pesquisa desativada.", e.getMessage());
        c.ativaPesquisa("TES1");
    }

    @org.junit.jupiter.api.Test
    void testDesassociaAtividade() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("", "A1"));
        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade(null, "A1"));
        assertEquals("Campo codigoPesquisa nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("TES1", ""));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("TES1", null));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("TES", "A1"));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("TES1", "A"));
        assertEquals("Atividade nao encontrada", e.getMessage());

        c.associaAtividade("TES1","A1");
        assertTrue(c.desassociaAtividade("TES1","A1"));
        assertFalse(c.desassociaAtividade("TES1","A1"));

        c.encerraPesquisa("TES1","AAAA");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("TES1", "A1"));
        assertEquals("Pesquisa desativada.", e.getMessage());
        c.ativaPesquisa("TES1");
    }

    @org.junit.jupiter.api.Test
    void testExecutaAtividade() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("",1,1));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade(null,1,1));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        c.cadastraItem("A1","AAA");
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("A1",1,1));
        assertEquals("Atividade sem associacoes com pesquisas.", e.getMessage());

        c.associaAtividade("TES1","A1");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("A1",-1,1));
        assertEquals("Item nao pode ser nulo ou negativo.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("A1",2,1));
        assertEquals("Item nao encontrado.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("A1",1,-1));
        assertEquals("Duracao nao pode ser nula ou negativa.", e.getMessage());

        c.executaAtividade("A1",1,2);
        assertEquals(c.getDuracao("A1"),2);
    }
}



