package unidade.controladores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.controladores.ControleAtividade;

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
}