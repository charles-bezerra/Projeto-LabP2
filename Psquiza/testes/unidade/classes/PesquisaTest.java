package unidade.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.classes.Pesquisa;

import static org.junit.jupiter.api.Assertions.*;

class PesquisaTest {

    private Pesquisa pesquisa1, pesquisa2;

    @BeforeEach
    void criarObjetos(){
        this.pesquisa1 = new Pesquisa("Uma simples pesquisa academica", "Estudo");
        this.pesquisa2 = new Pesquisa("Uma complexa pesquisa academica","Estudo");
    }


    @Test
    void criaComDescricaoNula(){
        try {
            Pesquisa pesquisa = new Pesquisa(null, "Medicina");
        }catch (IllegalArgumentException erro){
            assertEquals("java.lang.IllegalArgumentException: Descricao nao pode ser nula ou vazia.", erro.toString());
        }
    }

    @Test
    void criaComDescricaoVazia(){
        try {
            Pesquisa pesquisa = new Pesquisa("", "Medicina");
        }catch (IllegalArgumentException erro){
            assertEquals("java.lang.IllegalArgumentException: Descricao nao pode ser nula ou vazia.", erro.toString());
        }
    }

    @Test
    void criaComCampoDeInteresseNulo(){
        try {
            Pesquisa pesquisa = new Pesquisa("Um breve estudo sobre o efeito de altas temperaturas em idosos", null);
        }catch (IllegalArgumentException erro){
            assertEquals("java.lang.IllegalArgumentException: Formato do campo de interesse invalido.", erro.toString());
        }
    }

    @Test
    void criaComCampoDeInteresseVazio(){
        try {
            Pesquisa pesquisa = new Pesquisa("Um breve estudo sobre o efeito de altas temperaturas em idosos", "");
        }catch (IllegalArgumentException erro){
            assertEquals("java.lang.IllegalArgumentException: Formato do campo de interesse invalido.", erro.toString());
        }
    }

    @Test
    void setDescricao() {

    }

    @Test
    void setCampoDeInteresse() {
    }

    @Test
    void getEstado() {
    }

    @Test
    void ativaPesquisa() {
    }

    @Test
    void encerraPesquisa() {
    }

    @Test
    void testToString() {
    }
}