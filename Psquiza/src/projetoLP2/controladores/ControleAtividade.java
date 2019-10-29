package projetoLP2.controladores;

import projetoLP2.classes.Atividade;
import projetoLP2.util.Verificador;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador das atividades do sistema
 * @author Charles Bezerra de Oliveira Junior
 */
public class ControleAtividade {
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
}
