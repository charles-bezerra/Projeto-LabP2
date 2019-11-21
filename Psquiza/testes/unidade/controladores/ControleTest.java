package unidade.controladores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import projetoLP2.controladores.Controle;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class ControleTest {
    private static Controle c = new Controle();
    private Exception e;

    @BeforeAll
    static void criaObjetos() {
        c.cadastraAtividade("Uma simples atividade", "BAIXO", "E simples, entao e facil.");
        c.cadastraAtividade("Uma atividade complicada", "ALTO", "E dificil, porque nao sei.");
        c.cadastraPesquisa("teste", "TESTE");
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
        c.cadastraPesquisa("Junit e a sociedade ", "pesquisa2");
        c.cadastraPesquisa("Qualquer coisa pra testar", "pesquisa3");
        c.cadastraPesquisa("Junit e a sociedade ", "pesquisa4");
        c.cadastraPesquisa("Qualquer coisa pra testar", "pesquisa5");
        c.cadastraAtividade("Uma simples atividade", "BAIXO", "E simples, entao e facil.");
        c.cadastraAtividade("Uma atividade complicada", "ALTO", "E dificil, porque nao sei.");
        c.cadastraObjetivo("GERAL", "teste para quem esta buscando", 4, 5);
        c.cadastraObjetivo("ESPECIFICO", "teste para me buscarem", 1, 1);
        c.cadastraObjetivo("ESPECIFICO", "eu busco, tu buscas ele busca", 5, 2);
        c.cadastraProblema("precisei fazer mais um", 2);
        c.cadastraProblema("Problema qualquer", 4);
        c.associaProblema("TES1", "P1");
        c.associaProblema("PES3", "P4");
        c.associaObjetivo("TES1", "O1");
        c.associaObjetivo("PES3", "O4");
        c.associaObjetivo("PES5", "03");
        c.associaAtividade("TES1", "A2");
        c.associaAtividade("TES1", "A3");
        c.cadastraItem("A2", "item1");
        c.cadastraItem("A2", "item2");
        c.cadastraItem("A3", "item3");
        c.cadastraItem("A3", "item4");
        c.cadastraResultado("A2", "resultado1");
        c.cadastraResultado("A2", "resultado2");
        c.cadastraResultado("A3", "resultado3");
        c.cadastraResultado("A3", "resultado4");
        c.executaAtividade("A2", 1, 3);
        c.executaAtividade("A2", 2, 5);
        c.executaAtividade("A3", 1, 8);
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

        assertTrue(c.associaAtividade("TES1", "A1"));
        assertFalse(c.associaAtividade("TES1", "A1"));

        c.encerraPesquisa("TES1", "AAAA");

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

        c.associaAtividade("TES1", "A1");
        assertTrue(c.desassociaAtividade("TES1", "A1"));
        assertFalse(c.desassociaAtividade("TES1", "A1"));

        c.encerraPesquisa("TES1", "AAAA");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaAtividade("TES1", "A1"));
        assertEquals("Pesquisa desativada.", e.getMessage());
        c.ativaPesquisa("TES1");
    }

    @org.junit.jupiter.api.Test
    void testExecutaAtividade() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("", 1, 1));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade(null, 1, 1));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        c.cadastraItem("A1", "AAA");
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("A1", 1, 1));
        assertEquals("Atividade sem associacoes com pesquisas.", e.getMessage());

        c.associaAtividade("TES1", "A1");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("A1", -1, 1));
        assertEquals("Item nao pode ser nulo ou negativo.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("A1", 2, 1));
        assertEquals("Item nao encontrado.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.executaAtividade("A1", 1, -1));
        assertEquals("Duracao nao pode ser nula ou negativa.", e.getMessage());

        c.executaAtividade("A1", 1, 2);
        assertEquals(c.getDuracao("A1"), 2);
    }

    @Test
    void testBusca() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.busca(""));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.busca(null));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());
        assertEquals("TES2: teste para o buscador | PES1: teste pra busca | lucas@busca: testador de busca | luarte@busca: testador do buscador | P2: teste para o buscador | P1: teste pra busca | O5: eu busco, tu buscas ele busca | O4: teste para me buscarem | O3: teste para quem esta buscando | O2: teste para o buscador | O1: teste pra busca | A4: teste pra busca | A3: teste para o buscador", c.busca("busca"));

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
                c.busca("busca", 200));
        assertEquals("Entidade nao encontrada.", e.getMessage());

        assertEquals("lucas@busca: testador de busca", c.busca("busca", 3));
    }

    @Test
    void testContaResultadosBusca() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.contaResultadosBusca(""));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.contaResultadosBusca(null));
        assertEquals("Campo termo nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.contaResultadosBusca("abobrinha"));
        assertEquals("Nenhum resultado encontrado", e.getMessage());

        assertEquals(13, c.contaResultadosBusca("busca"));
    }

    @Test
    void testAssociaProblemaTrue() {
        assertTrue(c.associaProblema("PES2", "P4"));

    }

    @Test
    void testAssociaProblemaFalse() {

        assertFalse(c.associaProblema("PES3", "O4"));

    }

    @Test
    void testAssociaPesquisaJaAssociadoComProblema() {

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaProblema("TES1", "P2"));
        assertEquals("Pesquisa ja associada a um problema.", e.getMessage());

    }


    @Test
    void testAssociaProblemaIdPesquisaVazio() {


        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaProblema("", "P2"));
        assertEquals("Campo idPesquisa nao pode ser nulo ou vazio.", e.getMessage());

    }


    @Test
    void testAssociaProblemaIdProblemaVazio() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaProblema("TES1", ""));
        assertEquals("Campo idProblema nao pode ser nulo ou vazio.", e.getMessage());


    }

    @Test
    void testProblemaAssociaPesquisaInexistente() {

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaProblema("HAA1", "P2"));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());


    }

    @Test
    void testProblemaAssociaPesquisaDesativada() {

        c.encerraPesquisa("TES2", "cansei do projeto");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaProblema("TES2", "P2"));
        assertEquals("Pesquisa desativada.", e.getMessage());

    }


    @Test
    void testDesassociaProblemaTrue() {

        assertTrue(c.desassociaProblema("TES1"));
    }

    @Test
    void testDesassociaProblemaFalse() {
        c.desassociaProblema("PES1");
        assertFalse(c.desassociaProblema("PES1"));
    }

    @Test
    void testProblemaDesassociaPesquisaInexistente() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaProblema("KKK1"));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());

    }

    @Test
    void testProblemaDesassociaPesquisaDesativada() {

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaProblema("TES2"));
        assertEquals("Pesquisa desativada.", e.getMessage());

    }

    @Test
    void testAssociaObjetivoTrue() {
        assertTrue(c.associaObjetivo("PES5", "O3"));

    }

    @Test
    void testAssociaObjetivoFalse() {

        assertFalse(c.associaObjetivo("PES3", "O4"));

    }

    @Test
    void testAssociaPesquisaJaAssociadaComObjetivo() {

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaObjetivo("PES3", "O1"));
        assertEquals("Objetivo ja associado a uma pesquisa.", e.getMessage());

    }


    @Test
    void testAssociaObjetivoIdPesquisaVazio() {


        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaObjetivo("", "O2"));
        assertEquals("Campo idPesquisa nao pode ser nulo ou vazio.", e.getMessage());

    }


    @Test
    void testAssociaObjetivoIdProblemaVazio() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaObjetivo("TES1", ""));
        assertEquals("Campo idObjetivo nao pode ser nulo ou vazio.", e.getMessage());


    }

    @Test
    void testObjetivoAssociaPesquisaInexistente() {

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaObjetivo("BBB1", "O2"));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());


    }

    @Test
    void testObjetivoAssociaPesquisaDesativada() {

        c.encerraPesquisa("PES4", "jogabilidade horrivel");
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.associaObjetivo("PES4", "O2"));
        assertEquals("Pesquisa desativada.", e.getMessage());

    }

    @Test
    void testDesassociaObjetivoTrue() {

        assertTrue(c.desassociaObjetivo("TES1", "O1"));
    }

    @Test
    void testDesassociaObjetivoFalse() {
        c.desassociaObjetivo("PES1", "O4");
        assertFalse(c.desassociaObjetivo("PES1", "O4"));
    }

    @Test
    void testObjetivoDesassociaPesquisaInexistente() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaObjetivo("KKK1", "O2"));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());

    }

    @Test
    void testObjetivoDesassociaPesquisaDesativada() {

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.desassociaObjetivo("TES2", "O1"));
        assertEquals("Pesquisa desativada.", e.getMessage());

    }

    @Test
    void testGravarResumo() throws IOException {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.gravarResumo(""));
        assertEquals("Pesquisa nao pode ser nula ou vazia.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.gravarResumo(null));
        assertEquals("Pesquisa nao pode ser nula ou vazia.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.gravarResumo("AAAAA"));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());

        c.gravarResumo("TES1");
    }

    @Test
    void testGravarResultados() throws IOException {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.gravarResultados(""));
        assertEquals("Pesquisa nao pode ser nula ou vazia.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.gravarResultados(null));
        assertEquals("Pesquisa nao pode ser nula ou vazia.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                c.gravarResultados("AAAAA"));
        assertEquals("Pesquisa nao encontrada.", e.getMessage());

        c.gravarResultados("TES1");
    }
}









