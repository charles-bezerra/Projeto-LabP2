package projetoLP2.classes;

import projetoLP2.enums.Status;
import projetoLP2.util.Verificador;

import java.io.Serializable;

/**
 * Representação de item de uma atividade metodologica
 * @author Charles Bezerra de Oliveira Júnior, Lucas Alves Vigolvino
 */
public class Item implements Serializable {
    /**
     * Nome do item
     */
    private String item;
    /**
     * Status do item REALIZADO|PENDENTE
     */
    private Status status;

    /**
     * Tempo de duracao de cada item.
     */
    private int duracao = 0;


    /**
     * Constroi com status padrao como PENDENTE
     * @param nome nome do item
     */
    public Item(String nome){
        this.item = Verificador.verificaString("Item nao pode ser nulo ou vazio.", nome);
        this.status = Status.PENDENTE;
    }

    /**
     * Constroi o objeto recebendo como parametro nome do item e status do item(String)
     * @param nome String contendo o nome do item
     * @param status status do item em String
     */
    public Item(String nome, String status) {
        this.item = Verificador.verificaString("Item nao pode ser nulo ou vazio.", nome);
        Verificador.verificaString("Campo status nao pode ser nulo ou vazio.", status);

        switch (status.toUpperCase()){
            case "PENDENTE":{ this.status = Status.PENDENTE; break; }
            case "REALIZADO":{ this.status = Status.REALIZADO; break; }
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * Difine status como realizado
     */
    public void realizaItem(int duracao) {
        if(this.status == Status.REALIZADO) { throw new IllegalArgumentException("Item ja executado."); }
        this.status = Status.REALIZADO;
        this.duracao = duracao;
    }


    /**
     * Retorna o objeto status
     * @return Status.(PENDENTE|REALIZADO)
     */
    public Status getStatus(){ return this.status; }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString(){
        return this.status.getValor() + " - " + this.item;
    }
}
