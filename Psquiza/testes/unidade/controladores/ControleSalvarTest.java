package unidade.controladores;


import org.junit.jupiter.api.*;
import projetoLP2.controladores.Controle;
import projetoLP2.excessoes.PesistenciaException;

import static org.junit.jupiter.api.Assertions.*;


class ControleSalvarTest {
    private static Controle c = new Controle();

    @BeforeAll
    static void cadastraInformacoesParaSalvar(){
        c.cadastraPesquisa("pesquisa1", "pesquisa1");
        c.cadastraAtividade("atividade1", "ALTO", "teste para o buscador");
        c.cadastraObjetivo("GERAL", "teste pra busca", 2, 3);
        c.cadastraProblema("teste pra busca", 3);
        c.cadastraPesquisador(
                "Lucas", "ESTUDANTE", "testador de busca", "lucas@busca", "http://Teste");
        c.cadastraEspecialidadeAluno("lucas@busca", "1", "9.9");

        c.associaAtividade("PES1","A1");
        c.associaObjetivo("PES1","O1");
        c.associaProblema("PES1","P1");
        c.associaPesquisador("PES1","lucas@busca");
    }

    @Test
    void testaListaDePesquisadores(){
        assertEquals("Lucas (estudante) - testador de busca - lucas@busca - http://Teste - 1o SEMESTRE - 9.9",
                c.listaPesquisadores("ESTUDANTE"));
    }

    @Test
    void testaListaDePesquisas(){
        assertEquals("PES1 - pesquisa1 - pesquisa1",
                c.listaPesquisas("PESQUISA"));
    }

    @Test
    void testaAssociacaoProblemaPesquisa(){
        assertFalse(
                c.associaProblema("PES1","P1"));
    }

    @Test
    void testaAssociacaoObjetivoPesquisa(){
        assertFalse(
                c.associaObjetivo("PES1","O1"));
    }

    @Test
    void testaAssociacaoAtividadePesquisa(){
        assertFalse(
                c.associaAtividade("PES1","A1"));
    }

    @Test
    void testaAssociacaoPesquisadorPesquisa(){
        assertFalse(
                c.associaPesquisador("PES1","lucas@busca"));
    }

    @Test
    void salvando() throws PesistenciaException {
        c.salva();
    }
}



