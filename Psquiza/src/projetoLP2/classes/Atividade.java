package projetoLP2.classes;

import java.util.*;

import projetoLP2.enums.Risco; 
import projetoLP2.enums.Status;
import projetoLP2.util.Verificador;

import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que representa uma atividade metodologica
 * @author Charles Bezerra de Oliveira Júnior
 */

public class Atividade implements Comparable<Atividade>{
    /**
     * Contador que auxilia na geracao do codigo da atividade
     */
    private static int contador = 1;

    /**
     * Codigo identificador da atividade no formato A + (Ordem de insercao)
     */
    private String codigo;

    /**
     * Descricao da atividade
     */
    private String descricao;

    /**
     * Risco de realização da atividade
     */
    private Risco risco;

    /**
     * Decrição do risco da atividade
     */
    private String descricaoRisco;

    /**
     * Items da atividade
     */
    private List<Item> items;

    /**
     * Resultados da atividade.
     */
    private List<String> resultados;

    /**
     * Tempo de duracao da atividade.
     */
    private int duracao = 0;

    /**
     * Construtor de atividade metodoligica
     * @param descricao
     * @param nivelRisco
     * @param descricaoRisco
     */
    public Atividade(String descricao, String nivelRisco, String descricaoRisco){
        this.codigo = "A" + contador;
        this.descricao = Verificador.verificaString("Campo Descricao nao pode ser nulo ou vazio.",descricao);

        this.atribuiRisco(nivelRisco);

        this.descricaoRisco = Verificador.verificaString("Campo descricaoRisco nao pode ser nulo ou vazio.", descricaoRisco);
        this.items = new ArrayList<>();
        this.resultados = new ArrayList<>();
        contador++;
    }

    /**
     * Retorna o codifo publicamente
     * @return
     */
    public String getCodigo(){ return this.codigo; }

    /**
     * Atribui o nivel do risco a atividade
     * @param nivelRisco valor do risco (BAIXO, MEDIO, ALTO)
     */
    private void atribuiRisco(String nivelRisco){
        Verificador.verificaString("Campo nivelRisco nao pode ser nulo ou vazio.", nivelRisco);

        nivelRisco = nivelRisco.toUpperCase();

        switch (nivelRisco) {
            case "BAIXO": this.risco = Risco.BAIXO; break;
            case "MEDIO": this.risco = Risco.MEDIO; break;
            case "ALTO": this.risco = Risco.ALTO; break;
            default: throw new IllegalArgumentException("Valor invalido do nivel do risco.");
        }
    }

    /**
     * Cadastra um novo item na atividade
     * @param item item da atividade metodologica
     */
    public void cadastraItem(String item){
        Verificador.verificaString("Item nao pode ser nulo ou vazio.", item);
        this.items.add(new Item(item));
    }

    /**
     * Retorna a quantidade do items com status PENDENTES
     * @return quantidade de items
     */
    public int contaItensPendentes(){
        int cont = 0;
        for (Item item: this.items)
            if (item.getStatus() == Status.PENDENTE) cont++;
        return cont;
    }

    /**
     * Retorna a quantidade do items com status REALIZADO
     * @return quantidade de items
     */
    public int contaItensRealizados(){
        int cont = 0;
        for (Item item: this.items)
            if (item.getStatus() == Status.REALIZADO) cont++;
        return cont;
    }

    /**
     * Realiza um item do sistema.
     *
     * @param item o item a ser realizado
     * @param duracao o tempo que demorou para o item ser realizado
     */
    public void executaAtividade(int item, int duracao) {
        Verificador.verificaInteiro("Item nao pode ser nulo ou negativo.", item);
        Verificador.verificaInteiro("Duracao nao pode ser nula ou negativa.", duracao);
        if(items.size() < item) { throw new IllegalArgumentException("Item nao encontrado."); }
        items.get(item - 1).realizaItem();
        this.duracao += duracao;
    }

    /**
     * Cadastra um resultado no sistema.
     *
     * @param resultado o resultado a ser cadastrado
     * @return o numero do resultado que foi cadastrado
     */
    public int cadastraResultado(String resultado) {
        resultados.add(resultado);
        return resultados.size();
    }

    /**
     * Remove um resultado do sistema.
     *
     * @param numeroResultado o numero do resultado a ser removido
     * @return true e se a operacao for um sucesso
     */
    public boolean removeResultado(int numeroResultado) {
        Verificador.verificaInteiro("numeroResultado nao pode ser nulo ou negativo." ,numeroResultado);
        if(resultados.size() < numeroResultado) { throw new IllegalArgumentException("Resultado nao encontrado."); }
        resultados.remove(numeroResultado - 1);
        return true;
    }

    /**
     * Lista todos os resultados cadastrados nessa atividade.
     *
     * @return a lista de todos os resultados nessa atividade
     */
    public String listaResultados() {
        String todosResultado = "";
        for(String resultado : resultados) {
            todosResultado += resultado + " | ";
        }
        return todosResultado.substring(0, todosResultado.length() - 3);
    }

    /**
     * Retorna a duracao da atividade.
     *
     * @return a duracao da atividade
     */
    public int getDuracao() {return duracao;}


    public String getDescricao() {
        return descricao;
    }

    public String getDescricaoRisco() {
        return descricaoRisco;
    }

    @Override
    public String toString(){
        StringBuilder texto = new StringBuilder(
                this.descricao + " (" +
                this.risco.getRisco() + " - " +
                this.descricaoRisco + ")"
        );
        Iterator<Item> items = this.items.iterator();
        while (items.hasNext()){
            texto.append(" | ").append( items.next().toString() );
        }
        return texto.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Atividade atividade = (Atividade) object;
        return Objects.equals(codigo, atividade.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    /**
     *
     * @param o representa outro objeto para a comparação.
     * @return um inteiro referente a comparação entre os objetos.
     */
    @Override
    public int compareTo(Atividade o) {
        return o.getCodigo().compareTo(this.getCodigo());
    }

}
