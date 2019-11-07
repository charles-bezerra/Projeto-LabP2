package unidade.controladores;

import org.junit.jupiter.api.*;
import projetoLP2.controladores.ControleObjetivo;

import static org.junit.jupiter.api.Assertions.*;

class ControleObjetivoTest {

    private ControleObjetivo controleObjetivo;

    @BeforeEach
    void inicio(){
        controleObjetivo = new ControleObjetivo();
    }


    @Test
    void cadastraObjetivo() {
        assertEquals(null, controleObjetivo.cadastraObjetivo("ESPECIFICO", "Qualquer Coisa", 3,3));
    }

    @Test
    void cadastraObjetivoTipoVazio() {
        try {
            controleObjetivo.cadastraObjetivo("","Qualquer coisa",4,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo tipo nao pode ser nulo ou vazio.");
        }
    }

    @Test
    void cadastraObjetivoDescricaoVazia() {
        try {
            controleObjetivo.cadastraObjetivo("GERAL","",4,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo descricao nao pode ser nulo ou vazio.");
        }
    }

    @Test
    void cadastraObjetivoTipoInvalido() {
        try {
            controleObjetivo.cadastraObjetivo("Indefinido","Qualquer coisa",4,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de tipo.");
        }
    }

    @Test
    void cadastraObjetivoAderenciaInvalidaInferior() {
        try {
            controleObjetivo.cadastraObjetivo("GERAL","Qualquer coisa",0,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de aderencia");
        }
    }

    @Test
    void cadastraObjetivoAderenciaInvalidaSuperior() {
        try {
            controleObjetivo.cadastraObjetivo("GERAL","Qualquer coisa",6,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de aderencia");
        }
    }

    @Test
    void cadastraObjetivoViabilidadeInvalidaInferior() {
        try {
            controleObjetivo.cadastraObjetivo("GERAL","Qualquer coisa",4,0);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de viabilidade.");
        }
    }

    @Test
    void cadastraObjetivoViabilidadeInvalidaSuperior() {
        try {
            controleObjetivo.cadastraObjetivo("GERAL","Qualquer coisa",4,6);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de viabilidade.");
        }
    }

    @Test
    void apagarObjetivo() {
        controleObjetivo.cadastraObjetivo("ESPECIFICO", "Qualquer coisa", 3, 3);
        controleObjetivo.apagarObjetivo("O1");
        try {
            controleObjetivo.exibeObjetivo("O1");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Objetivo nao encontrado");
        }

    }

    @Test
    void apagarObjetivoCodigoVazio() {
        try {
            controleObjetivo.apagarObjetivo("");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo codigo nao pode ser nulo ou vazio.");
        }
    }

    @Test
    void apagarObjetivoObjetivoNaoExiste() {
        try {
            controleObjetivo.apagarObjetivo("P4");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Objetivo nao encontrado");
        }

    }

    @Test
    void exibeObjetivo() {
        controleObjetivo.cadastraObjetivo("ESPECIFICO", "Qualquer coisa", 2,1);
        assertEquals("O1 - ESPECIFICO - Qualquer coisa - 3", controleObjetivo.exibeObjetivo("O1"));

    }

    @Test
    void exibeObjetivoCodigoVazio() {
        try {
            controleObjetivo.exibeObjetivo("");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo codigo nao pode ser nulo ou vazio.");
        }
    }

    @Test
    void exibeObjetivoNaoExiste() {
        try {
            controleObjetivo.exibeObjetivo("P3");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Objetivo nao encontrado");
        }
    }
}