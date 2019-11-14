package unidade.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.classes.Pesquisa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PesquisaTest {

    private Pesquisa pesquisa1;

    @BeforeEach
    void criarObjetos(){
        this.pesquisa1 = new Pesquisa("Uma simples pesquisa academica", "Estudo");
    }


    @Test
    void criaComDescricaoNula(){
        try {
            Pesquisa pesquisa = new Pesquisa(null, "Medicina");
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException erro){
            assertEquals("java.lang.IllegalArgumentException: Descricao nao pode ser nula ou vazia.", erro.toString());
        }
    }

    @Test
    void criaComDescricaoVazia(){
        try {
            Pesquisa pesquisa = new Pesquisa("", "Medicina");
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException erro){
            assertEquals("java.lang.IllegalArgumentException: Descricao nao pode ser nula ou vazia.", erro.toString());
        }
    }

    @Test
    void criaComCampoDeInteresseNulo(){
        try {
            Pesquisa pesquisa = new Pesquisa("Um breve estudo sobre o efeito de altas temperaturas em idosos", null);
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException erro){
            assertEquals("java.lang.IllegalArgumentException: Formato do campo de interesse invalido.", erro.toString());
        }
    }

    @Test
    void criaComCampoDeInteresseVazio(){
        try {
            Pesquisa pesquisa = new Pesquisa("Um breve estudo sobre o efeito de altas temperaturas em idosos", "");
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException erro){
            assertEquals("java.lang.IllegalArgumentException: Formato do campo de interesse invalido.", erro.toString());
        }
    }

    @Test
    void setDescricaoNula() {
        try {
            this.pesquisa1.setDescricao(null);
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException erro) {
            assertEquals("java.lang.IllegalArgumentException: Descricao nao pode ser nula ou vazia.", erro.toString());
        }
    }

    @Test
    void setDescricaoInvalida() {
        try {
            this.pesquisa1.setDescricao("");
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException erro) {
            assertEquals("java.lang.IllegalArgumentException: Descricao nao pode ser nula ou vazia.", erro.toString());
        }
    }

    @Test
    void setCampoDeInteresseNulo() {
        try {
            this.pesquisa1.setCampoDeInteresse(null);
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException erro) {
            assertEquals("java.lang.IllegalArgumentException: Formato do campo de interesse invalido.", erro.toString());
        }
    }

    @Test
    void setCampoDeInteresseInvalido() {
        try {
            this.pesquisa1.setCampoDeInteresse("");
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException erro) {
            assertEquals("java.lang.IllegalArgumentException: Formato do campo de interesse invalido.", erro.toString());
        }
    }
}