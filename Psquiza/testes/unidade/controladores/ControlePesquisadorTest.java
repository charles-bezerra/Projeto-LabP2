package unidade.controladores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.controladores.ControlePesquisador;

import static org.junit.jupiter.api.Assertions.*;

class ControlePesquisadorTest {
    private static ControlePesquisador c;
    private Exception e;

    @BeforeEach
    void criaAtividade() {
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


       /* e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "https://"));
        assertEquals("Formato de foto invalido.", e.getMessage());*/


        /*e = assertThrows(IllegalArgumentException.class,()-> c.cadastraPesquisador("iago", "Estudante",
                "aaa","teste@gmail.com", "http://"));
        assertEquals("Formato de foto invalido.", e.getMessage());*/

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
        assertEquals("Campo atributo nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com",null,
                "Hiago"));
        assertEquals("Campo atributo nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","NOME",
                ""));
        assertEquals("Campo NOME nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","NOME",
                null));
        assertEquals("Campo NOME nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","FUNCAO",
                ""));
        assertEquals("Campo FUNCAO nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","FUNCAO",
                null));
        assertEquals("Campo FUNCAO nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","BIOGRAFRIA",
                ""));
        assertEquals("Campo BIOGRAFRIA nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","BIOGRAFRIA",
                null));
        assertEquals("Campo BIOGRAFRIA nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","EMAIL",
                ""));
        assertEquals("Campo EMAIL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","EMAIL",
                null));
        assertEquals("Campo EMAIL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","fotoURL",
                ""));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","fotoURL",
                null));
        assertEquals("Campo fotoURL nao pode ser nulo ou vazio.", e.getMessage());


        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","fotoURL",
                "httpsteste"));
        assertEquals("Formato de foto invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","fotoURL",
                "httpteste"));
        assertEquals("Formato de foto invalido.", e.getMessage());


        /*e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","fotoURL",
                "https://"));
        assertEquals("Formato de foto invalido.", e.getMessage());*/


        /*e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","fotoURL",
                "http://"));
        assertEquals("Formato de foto invalido.", e.getMessage());*/

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","email",
                "aa"));
        assertEquals("Formato de email invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","email",
                "@a"));
        assertEquals("Formato de email invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@gmail.com","email",
                "a@"));
        assertEquals("Formato de email invalido.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,()-> c.alteraPesquisador("teste@outlook.com","nome",
                "Hiago"));
        assertEquals("Pesquisador nao encontrado", e.getMessage());

        assertEquals("iago (Estudante) - aaa - teste@gmail.com - https://Cordyceps",
                c.exibePesquisador("teste@gmail.com"));

        c.alteraPesquisador("teste@gmail.com","nome", "Hiago");
        c.alteraPesquisador("teste@gmail.com","funcao", "Professor");
        c.alteraPesquisador("teste@gmail.com","biografia", "Fez nada");
        c.alteraPesquisador("teste@gmail.com","email", "teste@outlook.com");
        c.alteraPesquisador("teste@outlook.com","fotoURL", "http://aaa");

        assertEquals("Hiago (Professor) - Fez nada - teste@outlook.com - http://aaa",
                c.exibePesquisador("teste@outlook.com"));
    }

}