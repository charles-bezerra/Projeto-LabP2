package projetoLP2.controladores;

import projetoLP2.classes.AssociacaoPesquisaPesquisador;
import projetoLP2.classes.Pesquisa;
import projetoLP2.classes.Pesquisador;
import projetoLP2.enums.Estado;
import projetoLP2.util.Verificador;

import java.util.HashMap;
import java.util.Map;

public class ControlePesquisaPesquisador {
    private Map<Integer, AssociacaoPesquisaPesquisador> associacoes;
    private Map<String, Pesquisa> pesquisas;
    private Map<String, Pesquisador> pesquisadores;

    public ControlePesquisaPesquisador(Map<String, Pesquisa> pesquisas, Map<String, Pesquisador> pesquisadores){
        associacoes = new HashMap<>();
        this.pesquisas = pesquisas;
        this.pesquisadores = pesquisadores;
    }

    public boolean associaPesquisador(String idPesquisa, String emailPesquisador){
        Verificador.verificaString("Campo idPesquisa nao pode ser nulo ou vazio.", idPesquisa);
        Verificador.verificaString("Campo emailPesquisador nao pode ser nulo ou vazio.", emailPesquisador);

        if(!pesquisas.containsKey(idPesquisa)){
            throw new IllegalArgumentException("Pesquisa nao encontrada.");
        }

        if(pesquisas.get(idPesquisa).getEstado().equals("DESATIVADA")){
            throw new IllegalArgumentException("Pesquisa desativada.");
        }

        AssociacaoPesquisaPesquisador a = new AssociacaoPesquisaPesquisador(
                pesquisas.get(idPesquisa).getCod(),
                pesquisadores.get(emailPesquisador).getEmail());
        associacoes.put(a.getID(),a);
        return true;
    }


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