package unidade.controladores;

import org.junit.jupiter.api.*;
import projetoLP2.controladores.ControleProblema;

import static org.junit.jupiter.api.Assertions.*;

class ControleProblemaTest {

    private ControleProblema controleProblema;

    @BeforeEach
    void inicio(){
        controleProblema = new ControleProblema();
    }

    @Test
    void cadastraProblema() {
        assertEquals(null, controleProblema.cadastraProblema("Qualquer coisa", 4));

    }

    @Test
    void cadastraProblemaDescricaoVazia() {
        try{
            controleProblema.cadastraProblema("", 4);
            fail();
        }catch (IllegalArgumentException er){
            assertEquals(er.getMessage(),"Campo descricao nao pode ser nulo ou vazio.");
        }

    }

    @Test
    void cadastraProblemaViabilidadeInvalidaSuperior() {
        try {
            controleProblema.cadastraProblema("qlqr coisa", 6);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de viabilidade.");
        }

    }

    @Test
    void cadastraProblemaViabilidadeInvalidaInferior() {
        try {
            controleProblema.cadastraProblema("Qualquer coisa", 0);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de viabilidade.");
        }

    }

    @Test
    void apagarProblema() {
        controleProblema.cadastraProblema("Qualquer Coisa", 3);
        controleProblema.apagarProblema("P1");
        try {
            controleProblema.exibeProblema("P1");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Problema nao encontrado");
        }

    }

    @Test
    void apagarProblemaCodigoVazio() {
        try {
            controleProblema.apagarProblema("");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo codigo nao pode ser nulo ou vazio.");
        }

    }

    @Test
    void apagarProblemaProblemaNaoExiste() {
        try {
            controleProblema.apagarProblema("P4");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Problema nao encontrado");
        }

    }

    @Test
    void exibeProblema() {
        controleProblema.cadastraProblema("Qualquer coisa", 2);
        assertEquals("P1 - Qualquer coisa - 2",controleProblema.exibeProblema("P1"));
    }

    @Test
    void exibeProblemaCodigoVazio() {
        try {
            controleProblema.exibeProblema("");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo codigo nao pode ser nulo ou vazio.");
        }
    }

    @Test
    void exibeProblemaNaoExiste() {
        try {
            controleProblema.exibeProblema("P3");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Problema nao encontrado");
        }
    }

}