package unidade.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.classes.Pesquisador;
import projetoLP2.controladores.ControlePesquisador;

import static org.junit.jupiter.api.Assertions.*;

class PesquisadorTest {
    private static Pesquisador p;
    private Exception e;

    @BeforeEach
    void criaPesquisador() {
        p = new Pesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "https://Cordyceps");
    }


    @Test
    void testPesquisador() {
        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("", "Estudante",
                "aaa","teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo nome nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador(null, "Estudante",
                "aaa","teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo nome nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "",
                "aaa","teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo funcao nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "","teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo biografia nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                null,"teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo biografia nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","", "https://Cordyceps"));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa",null, "https://Cordyceps"));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", ""));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", null));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","aa", "https://Cordyceps"));
        assertEquals("Formato de email invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","a@", "https://Cordyceps"));
        assertEquals("Formato de email invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","@a", "https://Cordyceps"));
        assertEquals("Formato de email invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "httpsteste"));
        assertEquals("Formato de foto invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "httpteste"));
        assertEquals("Formato de foto invalido.", e.getMessage());


        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "https://"));
        assertEquals("Formato de foto invalido.", e.getMessage());


        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "http://"));
        assertEquals("Formato de foto invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "teste://teste"));
        assertEquals("Formato de foto invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p = new Pesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "://teste"));
        assertEquals("Formato de foto invalido.", e.getMessage());
    }

    @Test
    void testAlteraAtributo() {
        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("NOME",
                "Hiago"));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("NOME",
                "Hiago"));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("",
                "Hiago"));
        assertEquals("Atributo nao pode ser vazio ou nulo.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo(null,
                "Hiago"));
        assertEquals("Atributo nao pode ser vazio ou nulo.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("NOME",
                ""));
        assertEquals("Campo nome nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("NOME",
                null));
        assertEquals("Campo nome nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("FUNCAO",
                ""));
        assertEquals("Campo funcao nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("FUNCAO",
                null));
        assertEquals("Campo funcao nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("BIOGRAFIA",
                ""));
        assertEquals("Campo biografia nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("BIOGRAFIA",
                null));
        assertEquals("Campo biografia nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("EMAIL",
                ""));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("EMAIL",
                null));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("FOTO",
                ""));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("FOTO",
                null));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> p.alteraAtributo("NOME",
                "Hiago"));
        assertEquals("Pesquisador nao encontrado", e.getMessage());

        assertEquals("iago (estudante) - aaa - teste@gmail.com - https://Cordyceps",
                p.toString());

        p.alteraAtributo("NOME", "Hiago");
        p.alteraAtributo("FUNCAO", "Professor");
        p.alteraAtributo("BIOGRAFIA", "Fez nada");
        p.alteraAtributo("EMAIL", "teste@outlook.com");
        p.alteraAtributo("FOTO", "http://aaa");

        assertEquals("Hiago (professor) - Fez nada - teste@outlook.com - http://aaa",
                p.toString());
    }

    @Test
    void testIsAtivado() {
        p.desativaPesquisador();
        assertFalse(p.isAtivado());
        p.ativaPesquisador();
        assertTrue(p.isAtivado());

        e = assertThrows(IllegalArgumentException.class,()-> p.ativaPesquisador());
        assertEquals("Pesquisador ja ativado.", e.getMessage());

        p.desativaPesquisador();
        e = assertThrows(IllegalArgumentException.class,()->  p.desativaPesquisador());
        assertEquals("Pesquisador inativo.", e.getMessage());
    }
}