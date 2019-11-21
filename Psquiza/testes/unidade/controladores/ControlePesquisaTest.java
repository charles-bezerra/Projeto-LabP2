package unidade.controladores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import projetoLP2.classes.Atividade;

import projetoLP2.classes.Pesquisa;
import projetoLP2.controladores.ControlePesquisa;

import static org.junit.jupiter.api.Assertions.*;

class ControlePesquisaTest {
    private Atividade a1, a2, a3, a4, a5;
    private Exception e;

    private ControlePesquisa pesquisas;
    //private String pesquisa1;
    private Pesquisa p1, p2;

    @BeforeEach
    void criaObjetos() {
        this.pesquisas = new ControlePesquisa();


        a1 = new Atividade("Uma simples atividade", "BAIXO", "E simples, entao e facil.");
        a2 = new Atividade("Uma atividade complicada", "ALTO", "E dificil, porque nao sei.");
        a3 = new Atividade("Atividade boa", "ALTO", "boa, mas nem tanto");
        a4 = new Atividade("Boa atividade", "MEDIO", "ate que da");
        a5 = new Atividade("Mais ou menos", "BAIXO", "pensando bem");

        p1 = new Pesquisa("teste", "TESTE");
        p2 = new Pesquisa("testando", "junit");

        a3.cadastraItem("O meu primeiro item");
        a3.cadastraItem("O meu segundo item");
        a3.executaAtividade(1, 10);
        a3.executaAtividade(2,15);
        a3.cadastraResultado("Deu certo");
        a3.cadastraResultado("não deu muito certo");
    }

    @Test
    void cadastraPesquisa() {
        assertEquals(
                "COM1",
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
        } catch (IllegalArgumentException e) {
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
        } catch (IllegalArgumentException e) {
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
    void associaAtividadeTrue() {
        assertTrue(p2.associaAtividade(a1));
        assertTrue(p2.associaAtividade(a2));
        assertTrue(p2.associaAtividade(a3));

    }

    @Test
    void cadastraItem() {
        a1.cadastraItem("O meu primeiro item");
        a2.cadastraItem("O meu segundo item");
    }

    @Test
    void cadastraItemVazioOuNulo() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            a1.cadastraItem(null);
        });
        assertEquals("Item nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            a1.cadastraItem("");
        });
        assertEquals("Item nao pode ser nulo ou vazio.", e.getMessage());
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

        pesquisas.cadastraPesquisa(p1.getDescricao(), p1.getCampoDeInteresse());
        assertTrue(p1.associaAtividade(a1));
        assertFalse(p1.associaAtividade(a1));

        p1.encerraPesquisa(p1.getCod());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                p1.associaAtividade(a1));

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

        p1.associaAtividade(a1);

        assertTrue(p1.desassociaAtividade(a1));

        assertFalse(p1.desassociaAtividade(a1));

        p1.encerraPesquisa("AAAA");

        e = assertThrows(IllegalArgumentException.class, () ->
                p1.desassociaAtividade(a1));

        assertEquals(
                "Pesquisa desativada.",
                e.getMessage()
        );

        p1.ativaPesquisa();
    }

    @Test
    void associaPesquisador() {
    }

    @Test
    void desassociaPesquisador() {
    }
}