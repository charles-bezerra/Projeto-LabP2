package unidade.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.classes.Atividade;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class AtividadeTest {

    private Atividade atividade1, atividade2;
    private Exception e;

    @BeforeEach
    void criaObjetos(){
        atividade1 = new Atividade("Uma simples atividade","BAIXO","E simples, entao e facil.");
        atividade2 = new Atividade("Uma atividade complicada","ALTO","E dificil, porque nao sei.");
        atividade1.cadastraItem("item 1");
        atividade1.cadastraItem("item 2");
    }

    @Test
    void cadastraItem() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            atividade1.cadastraItem("");
        });
        assertEquals("Item nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            atividade1.cadastraItem(null);
        });
        assertEquals("Item nao pode ser nulo ou vazio.", e.getMessage());
    }

    @Test
    void contaItensPendentes() {
        assertEquals(2, atividade1.contaItensPendentes());
        assertEquals(0, atividade2.contaItensPendentes());
    }

    @Test
    void contaItensRealizados() {
        assertEquals(0, atividade1.contaItensRealizados());
    }

    @Test
    void testToString() {
        assertEquals("Uma simples atividade (BAIXO - E simples, entao e facil.) | PENDENTE - item 1 | PENDENTE - item 2", atividade1.toString());
    }


    @org.junit.jupiter.api.Test
    void testExecutaAtividade() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                atividade1.executaAtividade(-1,1));
        assertEquals("Item nao pode ser nulo ou negativo.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                atividade1.executaAtividade(4,1));
        assertEquals("Item nao encontrado.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                atividade1.executaAtividade(1,-1));
        assertEquals("Duracao nao pode ser nula ou negativa.", e.getMessage());

        atividade1.executaAtividade(1,2);
        assertEquals(atividade1.getDuracao(),2);
    }

    @org.junit.jupiter.api.Test
    void testCadastraResultado() {
        assertEquals(atividade1.cadastraResultado("bbb"),1);
    }


    @org.junit.jupiter.api.Test
    void testRemoveResultado() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                atividade1.removeResultado(-1));
        assertEquals("numeroResultado nao pode ser nulo ou negativo.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                atividade1.removeResultado(0));
        assertEquals("numeroResultado nao pode ser nulo ou negativo.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                atividade1.removeResultado(10));
        assertEquals("Resultado nao encontrado.", e.getMessage());

        atividade1.cadastraResultado("aaa");
        assertTrue(atividade1.removeResultado(1));
    }

    @org.junit.jupiter.api.Test
    void testListaResultados() {
        atividade1.cadastraResultado("aaa");
        assertEquals(atividade1.listaResultados(),"aaa");
        atividade1.cadastraResultado("bbb");
        assertEquals(atividade1.listaResultados(),"aaa | bbb");
        atividade1.removeResultado(1);
        assertEquals(atividade1.listaResultados(),"bbb");
    }
}