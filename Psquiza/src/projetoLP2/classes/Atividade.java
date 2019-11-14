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
 * @author Charles Bezerra de Oliveira Júnior, Iago Henrique de Souza Silva
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
     * A atividade subsequente a esta na ordem de execucao
     */
    private Atividade prox;

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

    public Risco getRisco() { return risco; }

    /**
     * Retorna a sua subsequente.
     *
     * @return a subsequente
     */
    public Atividade getProx() {
        return prox;
    }

    /**
     * Define a atividade subsequente a esta na ordem de execucao
     *
     * @param atv A atividade subsequente
     */
    public void addProx(Atividade atv){
        if(prox == null){
            prox = atv;
        }else {
            throw new IllegalArgumentException("Atividade ja possui uma subsequente.");
        }
    }

    /**
     * Retira a atividade subsequente a esta na ordem de execucao
     */
    public void tiraProx(){
        if(prox != null){
            prox = null;
        }
    }

    /**
     * Verifica se uma atividade especifica esta na lista de proximos desta atividade
     *
     * @param cod O ocodigo da atividade que queremos encontrar
     * @return Se a atividade esta ou nao entre os proximos desta atividade
     */
    public boolean contemProx(String cod){
        if(prox == null){
            return false;
        }
        if(prox.getCodigo() == cod){
            return true;
        }
        return prox.contemProx(cod);
    }

    /**
     * Conta quantas atividades estao na lista de proximos desta atividade
     *
     * @return O numero de proximos desta atividade
     */
    public int contaProx(){
        if(prox == null){
            return 0;
        }
        return 1 + prox.contaProx();
    }

    /**
     * Retorna o codigo da enesima atividade na lista de proximos
     *
     * @param index O indice da enesima atividade na lista
     * @return O codigo da enesima atividade
     */
    public String pegaProx(int index){
        if(prox == null){
            throw new IllegalArgumentException("Atividade inexistente.");
        }
        if(index == 1){
            return prox.getCodigo();
        }
        return prox.pegaProx(index - 1);
    }

    /**
     * Verifica se um Risco eh maior que outro
     *
     * @param r1 O primeiro valor de Risco
     * @param r2 O segundo valor de Risco
     * @return Se r1 eh maior que r2
     */
    public boolean verificaMaiorRisco(Risco r1, Risco r2) {
        if (r1.equals(r2)) {
            return true;
        }

        if (r1.equals(Risco.ALTO)) {
            return true;
        } else if (r1.equals(Risco.BAIXO)) {
            return false;
        } else {
            if (r2.equals(Risco.ALTO)) {
                return false;
            } else if (r2.equals(Risco.BAIXO)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Encontra a atividade com o maior risco na lista de proximos de uma atividade
     *
     * @param codMaior O codigo da atividade com o maior risco
     * @param MaiorRisco O risco da atividade com o maior risco
     * @return O codigo da atividade com o maior risco
     */
    public String pegaMaiorRisco(String codMaior, Risco MaiorRisco){
        if(verificaMaiorRisco(this.risco,MaiorRisco)){
            codMaior = this.codigo;
            MaiorRisco = this.risco;
        }
        if(prox == null){
            return codMaior;
        }
        return prox.pegaMaiorRisco(codMaior, MaiorRisco);
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
