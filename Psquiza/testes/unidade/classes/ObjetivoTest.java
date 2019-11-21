package unidade.classes;

import org.junit.jupiter.api.Test;
import projetoLP2.classes.Objetivo;


import static org.junit.jupiter.api.Assertions.*;

class ObjetivoTest {
    private Objetivo objetivo;


    @Test
    void criaAderenciaAbaixo(){

        try {
            objetivo = new Objetivo("ESPECIFICO", "testando Junit", 0, 2);
            fail();
        }catch (IllegalArgumentException erro){
            assertEquals("Valor invalido de aderencia", erro.getMessage());
        }
    }

    @Test
    void criaAderenciaAcima() {
        try {
            objetivo = new Objetivo("GERAL", "testando Junit", 6, 2);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Valor invalido de aderencia", erro.getMessage());
        }
    }
    @Test
    void criaViabilidadeAbaixo(){
        try {
            objetivo = new Objetivo("ESPECIFICO", "testando Junit", 4, 0);
            fail();
        }catch (IllegalArgumentException erro){
            assertEquals("Valor invalido de viabilidade.", erro.getMessage());
        }
    }

    @Test
    void criaViabilidadeAcima() {
        try {
            objetivo = new Objetivo("GERAL", "testando Junit", 4, 6);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Valor invalido de viabilidade.", erro.getMessage());
        }
    }
    @Test
    void criaTipoVazio(){
        try {
            objetivo = new Objetivo("", "testando Junit", 4, 3);
            fail();
        }catch (IllegalArgumentException erro){
            assertEquals("Campo tipo nao pode ser nulo ou vazio.", erro.getMessage());
        }
    }

    @Test
    void criaTipoNulo(){
        try {
            objetivo = new Objetivo(null, "testando Junit", 4, 3);
            fail();
        }catch (IllegalArgumentException erro){
            assertEquals("Campo tipo nao pode ser nulo ou vazio.", erro.getMessage());
        }
    }

    @Test
    void criaDescricaoNula(){
        try {
            objetivo = new Objetivo("GERAL", null, 4, 3);
            fail();
        }catch (IllegalArgumentException erro){
            assertEquals("Campo descricao nao pode ser nulo ou vazio.", erro.getMessage());
        }
    }

    @Test
    void criaDescricaoVazia(){
        try {
            objetivo = new Objetivo("GERAL", "", 4, 3);
            fail();
        }catch (IllegalArgumentException erro){
            assertEquals("Campo descricao nao pode ser nulo ou vazio.", erro.getMessage());
        }
    }

}


