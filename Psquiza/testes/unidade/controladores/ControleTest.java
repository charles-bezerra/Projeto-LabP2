package unidade.controladores;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @BeforeEach
    void criaObjetosPraBusca() {
        c.cadastraPesquisa("pesquisa1", "teste para o buscador");
        c.cadastraPesquisa("teste pra busca", "pesquisa2");
        c.cadastraAtividade("atividade1", "ALTO", "teste para o buscador");
        c.cadastraAtividade("teste pra busca", "ALTO", "paradoxo");
        c.cadastraObjetivo("GERAL", "teste pra busca", 2, 3);
        c.cadastraObjetivo("ESPECIFICO", "teste para o buscador", 2, 3);
        c.cadastraProblema("teste pra busca", 3);
        c.cadastraProblema("teste para o buscador", 2);
        c.cadastraPesquisador("Lucas", "ESTUDANTE", "testador de busca", "lucas@busca", "http://Teste");
        c.cadastraPesquisador("Luarte", "ESTUDANTE", "testador do buscador", "luarte@busca", "http://Teste");
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

    @Test
    void testBusca() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.busca(""));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.busca(null));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());
        assertEquals("TES2: teste para o buscador | PES1: teste pra busca | lucas@busca: testador de busca | luarte@busca: testador do buscador | P2: teste para o buscador | P1: teste pra busca | O2: teste para o buscador | O1: teste pra busca | A4: teste pra busca | A3: teste para o buscador", c.busca("busca"));

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.busca("", 3));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.busca(null, 3));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.busca("busca", 0));
        assertEquals("Numero do resultado nao pode ser negativo", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.busca("busca", -1));
        assertEquals("Numero do resultado nao pode ser negativo", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.busca("busca", 11));
        assertEquals("Entidade nao encontrada.", e.getMessage());
        assertEquals("lucas@busca: testador de busca", c.busca("busca", 3));
    }

    @Test
    void testContaResultadosBusca() {
        c.cadastraProblema("conta resultado", 4);
        c.cadastraObjetivo("GERAL", "conta resultado", 2, 1);
        c.cadastraPesquisa("conta resultado", "Junit");
        c.cadastraPesquisador("Aeiou", "ESTUDANTE", "contar resultados", "conta@resultado", "http://conta");
        c.cadastraAtividade("conta resultado", "BAIXO", "e facil");
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.contaResultadosBusca(""));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.contaResultadosBusca(null));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.contaResultadosBusca("abobrinha"));
        assertEquals("Nenhum resultado encontrado", e.getMessage());
        assertEquals(5, c.contaResultadosBusca("conta"));
    }
}



