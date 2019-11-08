package projetoLP2.controladores;

import projetoLP2.classes.Atividade;
import projetoLP2.util.Verificador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador das atividades do sistema
 * @author Charles Bezerra de Oliveira Junior
 */
public class ControleAtividade {
    /**
     *
     */
    private Map<String, Atividade> atividades;

    public ControleAtividade(){
        this.atividades = new HashMap<>();
    }

    private boolean encontraAtividade(String codigo){
        Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
        return this.atividades.containsKey(codigo);
    }

    public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco){
        Atividade atividade = new Atividade(descricao, nivelRisco, descricaoRisco);
        this.atividades.put(atividade.getCodigo(), atividade);
        return atividade.getCodigo();
    }

    public void apagaAtividade(String codigo){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        this.atividades.remove(codigo);
    }

    public void cadastraItem(String codigo, String item){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        this.atividades.get(codigo).cadastraItem(item);
    }

    public String exibeAtividade(String codigo){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        return this.atividades.get(codigo).toString();
    }

    public int contaItensPendentes(String codigo){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        return this.atividades.get(codigo).contaItensPendentes();
    }

    public int contaItensRealizados(String codigo){
        if (!encontraAtividade(codigo))
            throw new IllegalArgumentException("Atividade nao encontrada");
        return this.atividades.get(codigo).contaItensRealizados();
    }

    /**
     * Metodo responsavel por adicionar a um Arraylist de forma ordenada todas as atividades que possuem o termo.
     * @param termo o termo a ser buscado nas atividades.
     * @return um ArrayList de Strings com todas as atividades que possuem o termo.
     */
    public ArrayList<String> ordenaAtividade(String termo) {
        ArrayList<Atividade> buscasOrdenadas = new ArrayList<Atividade>(atividades.values());
        Collections.sort(buscasOrdenadas);
        ArrayList<String> retorno = new ArrayList<>();

        for (Atividade atividade : buscasOrdenadas) {
            if (atividade.getDescricao().toLowerCase().contains(termo.toLowerCase()))
                retorno.add(atividade.getCodigo() + ": " + atividade.getDescricao());
            if (atividade.getDescricaoRisco().toLowerCase().contains(termo.toLowerCase()))
                retorno.add(atividade.getCodigo() + ": " + atividade.getDescricaoRisco());
        }
        return retorno;
    }

}
