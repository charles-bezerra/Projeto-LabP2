package unidade.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.classes.Atividade;
import projetoLP2.classes.Pesquisa;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PesquisaTest {

    private Pesquisa pesquisa1;
    private Atividade a1;
    private Exception e;

    @BeforeEach
    void criarObjetos(){
        this.pesquisa1 = new Pesquisa("Uma simples pesquisa academica", "Estudo");
        a1 = new Atividade("Uma simples atividade","BAIXO","E simples, entao e facil.");
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

    @Test
    void testAssociaAtividade() {
        assertTrue(pesquisa1.associaAtividade(a1));
        assertFalse(pesquisa1.associaAtividade(a1));

        pesquisa1.encerraPesquisa("AAAA");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                pesquisa1.associaAtividade(a1));
        assertEquals("Pesquisa desativada.", e.getMessage());
    }

    @Test
    void testDesassociaAtividade() {
        pesquisa1.associaAtividade(a1);
        assertTrue(pesquisa1.desassociaAtividade(a1));
        assertFalse(pesquisa1.desassociaAtividade(a1));

        pesquisa1.encerraPesquisa("AAAA");

        e = Assertions.assertThrows(IllegalArgumentException.class, () ->
                pesquisa1.desassociaAtividade(a1));
        assertEquals("Pesquisa desativada.", e.getMessage());
    }
}