package projetoLP2.classes;

import projetoLP2.enums.Status;
import projetoLP2.util.Verificador;

/**
 * Representação de item de uma atividade metodologica
 * @author Charles Bezerra de Oliveira Júnior
 */
public class Item {
    /**
     * Nome do item
     */
    private String item;
    /**
     * Enumerador com o status do item (PENDENTE, REALIZADO)
     */
    private Status status;

    /**
     * Construtor padrao com argumento unico que atribui o nome do item
     * e atribui por padrao this.status como PENDENTE
     * @param nome do item
     */
    public Item(String nome){
        this.item = Verificador.verificaString("Item nao pode ser nulo ou vazio.", nome);
        this.status = Status.PENDENTE;
    }

    /**
     * Construtor segundario
     * @param nome nome do item
     * @param status status do item
     */
    public Item(String nome, String status){
        this(nome);
        Verificador.verificaString("Campo status nao pode ser nulo ou vazio.", status);
        switch (status.toUpperCase()){
            case "PENDENTE":{ this.status = Status.PENDENTE; break;}
            case "REALIZADO":{ this.status = Status.REALIZADO; break;}
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * Retorna o status atual do item
     * @return Status
     */
    public Status getStatus(){ return this.status; }

    @Override
    public String toString(){
        return String.format("%s - %s", this.status.getValor(), this.item );
    }
}
