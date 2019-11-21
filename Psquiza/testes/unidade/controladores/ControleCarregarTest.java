package unidade.controladores;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoLP2.controladores.Controle;
import projetoLP2.excessoes.PesistenciaException;

import static org.junit.jupiter.api.Assertions.*;


class ControleCarregarTest {
    private static Controle c = new Controle();

    //Obs: Executar anteriormente a classe 'ControleSalvarTest'
    @BeforeAll
    static void carregandoInformacoesSalvas() throws PesistenciaException {
        c.carrega();
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
}



