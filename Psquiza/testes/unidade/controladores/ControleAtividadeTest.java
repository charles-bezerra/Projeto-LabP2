package unidade.controladores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.controladores.ControleAtividade;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControleAtividadeTest {
    static ControleAtividade controle = new ControleAtividade();
    Exception e;
    static boolean only = true;

    @BeforeEach
    void criaAtividade() {
        controle.cadastraAtividade("Uma simples atividade","BAIXO","E simples, entao e facil.");
        controle.cadastraAtividade("Uma atividade complicada","ALTO","E dificil, porque nao sei.");
        if(only) {
            controle.cadastraItem("A1" ,"item 1");
            controle.cadastraItem("A1", "item 2");
            only = false;
        }
    }

    @Test
    void cadastraAtividade() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.cadastraAtividade("", "BAIXO","E nada, entao e facil");
        });
        assertEquals("Campo Descricao nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.cadastraAtividade("nada", "","E nada, entao e facil");
        });
        assertEquals("Campo nivelRisco nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.cadastraAtividade("nada", "BAIXO","");
        });
        assertEquals("Campo descricaoRisco nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.cadastraAtividade("nada", "EXTREMAMENTE BAIXO","E nada, entao e facil");
        });
        assertEquals("Valor invalido do nivel do risco.", e.getMessage());
    }

    @Test
    void apagaAtividade() {
        controle.cadastraAtividade("Uma simples atividade","BAIXO","E simples, entao e facil.");
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.apagaAtividade("");
        });
        assertEquals("Campo codigo nao pode ser nulo ou vazio.", e.getMessage());
        controle.apagaAtividade("A3");
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.apagaAtividade("A3");
        });
        assertEquals("Atividade nao encontrada", e.getMessage());
    }

    @Test
    void cadastraItem() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.cadastraItem("", "item 1");
        });
        assertEquals("Campo codigo nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.cadastraItem("A2", "");
        });
        assertEquals("Item nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.cadastraItem("A", "item 1");
        });
        assertEquals("Atividade nao encontrada", e.getMessage());
    }

    @Test
    void exibeAtividade() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.exibeAtividade("");
        });
        assertEquals("Campo codigo nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.exibeAtividade("A");
        });
        assertEquals("Atividade nao encontrada", e.getMessage());
        assertEquals("Uma simples atividade (BAIXO - E simples, entao e facil.) | PENDENTE - item 1 | PENDENTE - item 2" ,controle.exibeAtividade("A1"));
        assertEquals("Uma atividade complicada (ALTO - E dificil, porque nao sei.)" ,controle.exibeAtividade("A2"));
    }

    @Test
    void contaItensPendentes() {

        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.contaItensPendentes("");
        });
        assertEquals("Campo codigo nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.contaItensPendentes("O3");
        });
        assertEquals("Atividade nao encontrada", e.getMessage());
        assertEquals(2, controle.contaItensPendentes("A1"));
        assertEquals(0, controle.contaItensPendentes("A2"));
    }

    @Test
    void contaItensRealizados() {

        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.contaItensRealizados("");
        });
        assertEquals("Campo codigo nao pode ser nulo ou vazio.", e.getMessage());
        e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controle.contaItensRealizados("O3");
        });
        assertEquals("Atividade nao encontrada", e.getMessage());
        assertEquals(0, controle.contaItensRealizados("A1"));
        assertEquals(0, controle.contaItensRealizados("A2"));
    }


    @org.junit.jupiter.api.Test
    void testExecutaAtividade() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.executaAtividade("",1,1));
        assertEquals("Campo codigo nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.executaAtividade(null,1,1));
        assertEquals("Campo codigo nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.executaAtividade("A1",-1,1));
        assertEquals("Item nao pode ser nulo ou negativo.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.executaAtividade("A1",4,1));
        assertEquals("Item nao encontrado.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.executaAtividade("A1",1,-1));
        assertEquals("Duracao nao pode ser nula ou negativa.", e.getMessage());

        controle.executaAtividade("A1",1,2);
        assertEquals(controle.getDuracao("A1"),2);
    }

    @org.junit.jupiter.api.Test
    void testCadastraResultado() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.cadastraResultado("","aaa"));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.cadastraResultado(null,"aaa"));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.cadastraResultado("A1",""));
        assertEquals("Resultado nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.cadastraResultado("A1",null));
        assertEquals("Resultado nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.cadastraResultado("A","aaa"));
        assertEquals("Atividade nao encontrada", e.getMessage());

        assertEquals(controle.cadastraResultado("A1","bbb"),1);
    }


    @org.junit.jupiter.api.Test
    void testRemoveResultado() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.removeResultado("",1));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.removeResultado(null,1));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.removeResultado("A1",-1));
        assertEquals("numeroResultado nao pode ser nulo ou negativo.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.removeResultado("A1",0));
        assertEquals("numeroResultado nao pode ser nulo ou negativo.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.removeResultado("A",1));
        assertEquals("Atividade nao encontrada", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.removeResultado("A1",10));
        assertEquals("Resultado nao encontrado.", e.getMessage());

        controle.cadastraResultado("A1","aaa");
        assertTrue(controle.removeResultado("A1",1));
    }

    @org.junit.jupiter.api.Test
    void testListaResultados() {
        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.listaResultados(""));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.listaResultados(null));
        assertEquals("Campo codigoAtividade nao pode ser nulo ou vazio.", e.getMessage());

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                controle.listaResultados("A"));
        assertEquals("Atividade nao encontrada", e.getMessage());

        controle.cadastraResultado("A1","aaa");
        assertEquals(controle.listaResultados("A1"),"aaa");
        controle.cadastraResultado("A1","bbb");
        assertEquals(controle.listaResultados("A1"),"aaa | bbb");
        controle.removeResultado("A1",1);
        assertEquals(controle.listaResultados("A1"),"bbb");
        controle.removeResultado("A1",1);
    }
}