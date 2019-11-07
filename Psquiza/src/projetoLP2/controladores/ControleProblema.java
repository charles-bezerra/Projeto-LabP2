package projetoLP2.controladores;

import projetoLP2.classes.Problema;
import projetoLP2.util.Verificador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Classe controlodadora da classe Problema e da classe Objetivo.
 *
 * @author Lucas Alves Vigolvino
 */
public class ControleProblema {
    /**
     * Mapa de problemas, as chaves sao codigos gerados pelo programa "P" + id, a partir de 1.
     */
    private HashMap<String, Problema> problemas = new HashMap<>();

    /**
     * Cadastra um problema no sistema.
     *
     * @param descricao a descricao do problema
     * @param viabilidade o valor de viabilidade do problema, numero inteiro de 1 a 5
     * @return null
     */
    public String cadastraProblema(String descricao, int viabilidade) {
        Problema problema = new Problema(descricao, viabilidade);
        problemas.put(problema.getId(), problema);
        return null;
    }

    /**
     * Apaga um problema do sistema.
     *
     * @param codigo o codigo de identificacao do problema
     */
    public void apagarProblema(String codigo) {
        Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
        if(!problemas.containsKey(codigo)) { throw new IllegalArgumentException("Problema nao encontrado");
        } else { problemas.remove(codigo); }
    }

    /**
     * Exibe um problema cadastrado no sistema.
     *
     * @param codigo o codigo de identificacao do problema
     * @return a representacao em String de um problema
     */
    public String exibeProblema(String codigo) {
        Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
        if(!problemas.containsKey(codigo)) { throw new IllegalArgumentException("Problema nao encontrado");
        } else { return problemas.get(codigo).toString(); }
    }

    public ArrayList<String> ordenaProblema(String termo){
        ArrayList<Problema> buscasOrdenadas = new ArrayList<Problema>(this.problemas.values());
        Collections.sort(buscasOrdenadas);
        ArrayList<String> retorno = new ArrayList<>();

        for (Problema problema: buscasOrdenadas){
            if (problema.getDescricao().toLowerCase().contains(termo.toLowerCase())) {
                retorno.add(problema.getId() + ": " + problema.getDescricao());

            }

        }

        return retorno;
    }
}
