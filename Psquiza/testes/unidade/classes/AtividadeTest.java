package unidade.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.classes.Atividade;

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
}