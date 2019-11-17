package unidade.controladores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.controladores.ControlePesquisador;

import static org.junit.jupiter.api.Assertions.*;

class ControlePesquisadorTest {
    private static ControlePesquisador c;
    private Exception e;

    @BeforeEach
    void criaPesquisador() {
        c = new ControlePesquisador();
        c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "https://Cordyceps");
    }

    @Test
    void testCadastraPesquisador() {
        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("", "Estudante",
                "aaa","teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo nome nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador(null, "Estudante",
                "aaa","teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo nome nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "",
                "aaa","teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo funcao nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "","teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo biografia nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                null,"teste@gmail.com", "https://Cordyceps"));
        assertEquals("Campo biografia nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","", "https://Cordyceps"));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa",null, "https://Cordyceps"));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", ""));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", null));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","aa", "https://Cordyceps"));
        assertEquals("Formato de email invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","a@", "https://Cordyceps"));
        assertEquals("Formato de email invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","@a", "https://Cordyceps"));
        assertEquals("Formato de email invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "httpsteste"));
        assertEquals("Formato de foto invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "httpteste"));
        assertEquals("Formato de foto invalido.", e.getMessage());


        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "https://"));
        assertEquals("Formato de foto invalido.", e.getMessage());


        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "http://"));
        assertEquals("Formato de foto invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "teste://teste"));
        assertEquals("Formato de foto invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "://teste"));
        assertEquals("Formato de foto invalido.", e.getMessage());
    }


    @Test
    void testAlteraPesquisador() {
        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("","NOME",
                "Hiago"));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador(null,"NOME",
                "Hiago"));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","",
                "Hiago"));
        assertEquals("Atributo nao pode ser vazio ou nulo.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com",null,
                "Hiago"));
        assertEquals("Atributo nao pode ser vazio ou nulo.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","NOME",
                ""));
        assertEquals("Campo nome nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","NOME",
                null));
        assertEquals("Campo nome nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","FUNCAO",
                ""));
        assertEquals("Campo funcao nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","FUNCAO",
                null));
        assertEquals("Campo funcao nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","BIOGRAFIA",
                ""));
        assertEquals("Campo biografia nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","BIOGRAFIA",
                null));
        assertEquals("Campo biografia nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","EMAIL",
                ""));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","EMAIL",
                null));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","FOTO",
                ""));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","FOTO",
                null));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@outlook.com","NOME",
                "Hiago"));
        assertEquals("Pesquisador nao encontrado", e.getMessage());

        assertEquals("iago (estudante) - aaa - teste@gmail.com - https://Cordyceps",
                c.exibePesquisador("teste@gmail.com"));

        c.alteraPesquisador("teste@gmail.com","NOME", "Hiago");
        c.alteraPesquisador("teste@gmail.com","FUNCAO", "Professor");
        c.alteraPesquisador("teste@gmail.com","BIOGRAFIA", "Fez nada");
        c.alteraPesquisador("teste@gmail.com","EMAIL", "teste@outlook.com");
        c.alteraPesquisador("teste@outlook.com","FOTO", "http://aaa");

        assertEquals("Hiago (professor) - Fez nada - teste@outlook.com - http://aaa",
                c.exibePesquisador("teste@outlook.com"));

        e = assertThrows(IllegalArgumentException.class,()-> c.exibePesquisador("teste@gmail.com"));
        assertEquals("Pesquisador nao encontrado", e.getMessage());
    }


    @Test
    void testPesquisadorEhAtivo() {
        c.desativaPesquisador("teste@gmail.com");
        assertFalse(c.pesquisadorEhAtivo("teste@gmail.com"));
        c.ativaPesquisador("teste@gmail.com");
        assertTrue(c.pesquisadorEhAtivo("teste@gmail.com"));

        e = assertThrows(IllegalArgumentException.class,()-> c.pesquisadorEhAtivo(null));
        assertEquals("Email nao pode ser vazio ou nulo.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.ativaPesquisador(null));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.desativaPesquisador(null));
        assertEquals("Campo email nao pode ser nulo ou vazio.", e.getMessage());


        e = assertThrows(IllegalArgumentException.class,()-> c.ativaPesquisador("teste@gmail.com"));
        assertEquals("Pesquisador ja ativado.", e.getMessage());

        c.desativaPesquisador("teste@gmail.com");
        e = assertThrows(IllegalArgumentException.class,()-> c.desativaPesquisador("teste@gmail.com"));
        assertEquals("Pesquisador inativo.", e.getMessage());

    }

}