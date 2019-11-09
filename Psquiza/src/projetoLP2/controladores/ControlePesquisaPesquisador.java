package projetoLP2.controladores;

import projetoLP2.classes.AssociacaoPesquisaPesquisador;
import projetoLP2.classes.Pesquisa;
import projetoLP2.classes.Pesquisador;
import projetoLP2.enums.Estado;
import projetoLP2.util.Verificador;

import java.util.HashMap;
import java.util.Map;
/**
 * Controlador das associacoes do sistema, onde suas funcionalidades estao agrupadas.
 * @authors Iago Henrique de Souza Silva
 */
public class ControlePesquisaPesquisador {
    /**
     * O mapa de associacoes, com os ids como chave
     */
    private Map<Integer, AssociacaoPesquisaPesquisador> associacoes;
    /**
     * O mapa de pesquisas, com os codigos como chave
     */
    private Map<String, Pesquisa> pesquisas;
    /**
     * O mapa de pesquisadores, com os emails como chave
     */
    private Map<String, Pesquisador> pesquisadores;


    /**
     * Constroi o Controller de pesquisas. Onde o mapa de pesquisas,
     * o mapa de pesquisadores e o mapa de associacoes sao inicializados.
     *
     * @param pesquisas O mapa de pesquisas do sistema
     * @param pesquisadores O mapa de pesquisadores do sistema
     */
    public ControlePesquisaPesquisador(Map<String, Pesquisa> pesquisas, Map<String, Pesquisador> pesquisadores){
        associacoes = new HashMap<>();
        this.pesquisas = pesquisas;
        this.pesquisadores = pesquisadores;
    }


    /**
     * Cria uma nova AssociacaoPesquisaPesquisador e a adiciona no mapa de associacoes.
     *
     * @param idPesquisa O id da pesquisa associada.
     * @param emailPesquisador O email do pesquisador associado.
     */
    public boolean associaPesquisador(String idPesquisa, String emailPesquisador){
        Verificador.verificaString("Campo idPesquisa nao pode ser nulo ou vazio.", idPesquisa);
        Verificador.verificaString("Campo emailPesquisador nao pode ser nulo ou vazio.", emailPesquisador);

        if(!pesquisas.containsKey(idPesquisa)){
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }

        if(pesquisas.get(idPesquisa).getEstado().equals("DESATIVADA")){
            throw new IllegalArgumentException("Pesquisa desativada.");
        }

        for(AssociacaoPesquisaPesquisador a : associacoes.values()){
            if(a.getIdPesquisa().equals(idPesquisa) && a.getEmailPesquisador().equals(emailPesquisador)){
                return false;
            }
        }

        AssociacaoPesquisaPesquisador a = new AssociacaoPesquisaPesquisador(
                pesquisas.get(idPesquisa).getCod(),
                pesquisadores.get(emailPesquisador).getEmail());
        associacoes.put(a.getID(),a);
        return true;
    }


    /**
     * Remove alguma AssociacaoPesquisaPesquisador do mapa de associacoes.
     *
     * @param idPesquisa O id da pesquisa desassociada.
     * @param emailPesquisador O email do pesquisador desassociado.
     */
    public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador){
        Verificador.verificaString("Campo idPesquisa nao pode ser nulo ou vazio.", idPesquisa);
        Verificador.verificaString("Campo emailPesquisador nao pode ser nulo ou vazio.", emailPesquisador);

        if(!pesquisas.containsKey(idPesquisa)){
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }

        if(pesquisas.get(idPesquisa).getEstado().equals(Estado.DESATIVADA.getEstado())){
            throw new IllegalArgumentException("Pesquisa desativada.");
        }

        for(AssociacaoPesquisaPesquisador a : associacoes.values()){
            if(a.getIdPesquisa().equals(idPesquisa) && a.getEmailPesquisador().equals(emailPesquisador)){
                associacoes.remove(a.getID());
                return true;
            }
        }
        return false;
    }
}
