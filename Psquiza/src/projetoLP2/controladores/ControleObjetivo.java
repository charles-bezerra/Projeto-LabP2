package projetoLP2.controladores;

import projetoLP2.classes.Objetivo;
import projetoLP2.util.Verificador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Classe controlodadora da classe Problema e da classe Objetivo.
 *
 * @author Lucas Alves Vigolvino
 */
public class ControleObjetivo {
    /**
     * Mapa de objetivos, as chaves sao codigos gerados pelo programa "O" + id, a partir de 1.
     */
    private HashMap<String, Objetivo> objetivos = new HashMap<>();

    /**
     * Cadastra um objetivo no sistema.
     *
     * @param tipo o tipo do objetivo, GERAL ou ESPECIFICO
     * @param descricao a descricao do objetivo
     * @param aderencia o valor de aderencia do objetivo, numero inteiro de 1 a 5
     * @param viabilidade o valor de vibilidade do objetivo, numero inteiro de 1 a 5
     * @return null
     */
    public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
        Objetivo objetivo = new Objetivo(tipo, descricao, aderencia, viabilidade);
        objetivos.put(objetivo.getId(), objetivo);
        return null;
    }

    /**
     * Apaga um objetivo do sistema.
     *
     * @param codigo o codigo de identificacao do objetivo
     */
    public void apagarObjetivo(String codigo) {
        Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
        if(!objetivos.containsKey(codigo))
            throw new IllegalArgumentException("Objetivo nao encontrado");
        else objetivos.remove(codigo);
    }

    /**
     * Exibe um objetivo cadastrado no sistema.
     *
     * @param codigo o codigo de identificacao do objetivo
     * @return a representacao em String de um objetivo
     */
    public String exibeObjetivo(String codigo) {
        Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
        if(!objetivos.containsKey(codigo))
            throw new IllegalArgumentException("Objetivo nao encontrado");
        else return objetivos.get(codigo).toString();
    }


    public ArrayList<String> ordenaObjetivo(String termo){
        ArrayList<Objetivo> buscasOrdenadas = new ArrayList<Objetivo>(this.objetivos.values());
        Collections.sort(buscasOrdenadas);
        ArrayList<String> retorno = new ArrayList<>();

        for (Objetivo objetivo: buscasOrdenadas)
            if (objetivo.getDescricao().toLowerCase().contains(termo.toLowerCase()))
                retorno.add(objetivo.getId() + ": " + objetivo.getDescricao());
        return retorno;
    }

}
