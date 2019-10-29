package unidade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.classes.Atividade;

import static org.junit.jupiter.api.Assertions.*;

class AtividadeTest {

    private Atividade atividade1, atividade2;

    @BeforeEach
    void criarObejetos(){
        atividade1 = new Atividade("Uma simples atividade","BAIXO","E simples, entao e facil.");
        atividade2 = new Atividade("Uma atividade complicada","ALTO","E dificil, porque nao sei..");
    }

    @Test
    void getCodigo() {
        assertEquals("A1", atividade1.getCodigo());
        assertEquals("A2", atividade2.getCodigo());
    }

    @Test
    void cadastraItem() {
    }

    @Test
    void contaItensPendentes() {
    }

    @Test
    void contaItensRealizados() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
    }
}