package unidade;

import org.junit.jupiter.api.BeforeEach;
import projetoLP2.classes.Problema;
import projetoLP2.controladores.ControleProblemaObjetivo;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ControleProblemaObjetivoTest {

    private ControleProblemaObjetivo problemasEObjetivos;

    @BeforeEach
    void inicio(){
        problemasEObjetivos = new ControleProblemaObjetivo();

    }

    @org.junit.jupiter.api.Test
    void cadastraProblema() {
        assertEquals(null, problemasEObjetivos.cadastraProblema("Qualquer coisa", 4));

    }

    @org.junit.jupiter.api.Test
    void cadastraProblemaDescricaoVazia() {
        try{
            problemasEObjetivos.cadastraProblema("", 4);
            fail();
        }catch (IllegalArgumentException er){
            assertEquals(er.getMessage(),"Campo descricao nao pode ser nulo ou vazio.");
        }

    }

    @org.junit.jupiter.api.Test
    void cadastraProblemaViabilidadeInvalidaSuperior() {
        try {
            problemasEObjetivos.cadastraProblema("qlqr coisa", 6);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de viabilidade.");
        }

    }

    @org.junit.jupiter.api.Test
    void cadastraProblemaViabilidadeInvalidaInferior() {
        try {
            problemasEObjetivos.cadastraProblema("Qualquer coisa", 0);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de viabilidade.");
        }

    }

    @org.junit.jupiter.api.Test
    void cadastraObjetivo() {
        assertEquals(null, problemasEObjetivos.cadastraObjetivo("ESPECIFICO", "Qualquer Coisa", 3,3));
    }

    @org.junit.jupiter.api.Test
    void cadastraObjetivoTipoVazio() {
        try {
            problemasEObjetivos.cadastraObjetivo("","Qualquer coisa",4,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo tipo nao pode ser nulo ou vazio.");
        }
    }

    @org.junit.jupiter.api.Test
    void cadastraObjetivoDescricaoVazia() {
        try {
            problemasEObjetivos.cadastraObjetivo("GERAL","",4,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo descricao nao pode ser nulo ou vazio.");
        }
    }

    @org.junit.jupiter.api.Test
    void cadastraObjetivoTipoInvalido() {
        try {
            problemasEObjetivos.cadastraObjetivo("Indefinido","Qualquer coisa",4,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de tipo.");
        }
    }

    @org.junit.jupiter.api.Test
    void cadastraObjetivoAderenciaInvalidaInferior() {
        try {
            problemasEObjetivos.cadastraObjetivo("GERAL","Qualquer coisa",0,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de aderencia");
        }
    }

    @org.junit.jupiter.api.Test
    void cadastraObjetivoAderenciaInvalidaSuperior() {
        try {
            problemasEObjetivos.cadastraObjetivo("GERAL","Qualquer coisa",6,4);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de aderencia");
        }
    }

    @org.junit.jupiter.api.Test
    void cadastraObjetivoViabilidadeInvalidaInferior() {
        try {
            problemasEObjetivos.cadastraObjetivo("GERAL","Qualquer coisa",4,0);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de viabilidade.");
        }
    }

    @org.junit.jupiter.api.Test
    void cadastraObjetivoViabilidadeInvalidaSuperior() {
        try {
            problemasEObjetivos.cadastraObjetivo("GERAL","Qualquer coisa",4,6);
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Valor invalido de viabilidade.");
        }
    }

    @org.junit.jupiter.api.Test
    void apagarProblema() {
        problemasEObjetivos.cadastraProblema("Qualquer Coisa", 3);
        problemasEObjetivos.apagarProblema("P1");
        try {
            problemasEObjetivos.exibeProblema("P1");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Problema nao encontrado");
        }

    }

    @org.junit.jupiter.api.Test
    void apagarProblemaCodigoVazio() {
        try {
            problemasEObjetivos.apagarProblema("");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo codigo nao pode ser nulo ou vazio.");
        }

    }

    @org.junit.jupiter.api.Test
    void apagarProblemaProblemaNaoExiste() {
        try {
            problemasEObjetivos.apagarProblema("P4");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Problema nao encontrado");
        }

    }

    @org.junit.jupiter.api.Test
    void apagarObjetivo() {
        problemasEObjetivos.cadastraObjetivo("ESPECIFICO", "Qualquer coisa", 3, 3);
        problemasEObjetivos.apagarObjetivo("O1");
        try {
            problemasEObjetivos.exibeObjetivo("O1");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Objetivo nao encontrado");
        }

    }

    @org.junit.jupiter.api.Test
    void apagarObjetivoCodigoVazio() {
        try {
            problemasEObjetivos.apagarObjetivo("");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo codigo nao pode ser nulo ou vazio.");
        }
    }

    @org.junit.jupiter.api.Test
    void apagarObjetivoObjetivoNaoExiste() {
        try {
            problemasEObjetivos.apagarObjetivo("P4");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Objetivo nao encontrado");
        }

    }

    @org.junit.jupiter.api.Test
    void exibeProblema() {
        problemasEObjetivos.cadastraProblema("Qualquer coisa", 2);
        assertEquals("P1 - Qualquer coisa - 2",problemasEObjetivos.exibeProblema("P1"));
    }

    @org.junit.jupiter.api.Test
    void exibeProblemaCodigoVazio() {
        try {
            problemasEObjetivos.exibeProblema("");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo codigo nao pode ser nulo ou vazio.");
        }
    }

    @org.junit.jupiter.api.Test
    void exibeProblemaNaoExiste() {
        try {
            problemasEObjetivos.exibeProblema("P3");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Problema nao encontrado");
        }
    }

    @org.junit.jupiter.api.Test
    void exibeObjetivo() {
        problemasEObjetivos.cadastraObjetivo("ESPECIFICO", "Qualquer coisa", 2,1);
        assertEquals("O1 - ESPECIFICO - Qualquer coisa - 3",problemasEObjetivos.exibeObjetivo("O1"));

    }

    @org.junit.jupiter.api.Test
    void exibeObjetivoCodigoVazio() {
        try {
            problemasEObjetivos.exibeObjetivo("");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Campo codigo nao pode ser nulo ou vazio.");
        }
    }

    @org.junit.jupiter.api.Test
    void exibeObjetivoNaoExiste() {
        try {
            problemasEObjetivos.exibeObjetivo("P3");
            fail();
        } catch (IllegalArgumentException er) {
            assertEquals(er.getMessage(), "Objetivo nao encontrado");
        }
    }
}