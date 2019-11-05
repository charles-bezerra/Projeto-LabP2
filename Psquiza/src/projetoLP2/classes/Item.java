package projetoLP2.classes;

import projetoLP2.enums.Status;
import projetoLP2.util.Verificador;

/**
 * Representação de item de uma atividade metodologica
 * @author Charles Bezerra de Oliveira Júnior
 */
public class Item {
    private String item;
    private Status status;

    public Item(String nome){
        this.item = Verificador.verificaString("Item nao pode ser nulo ou vazio.", nome);
        this.status = Status.PENDENTE;
    }

    public Item(String nome, String status) {
        this.item = Verificador.verificaString("Item nao pode ser nulo ou vazio.", nome);
        Verificador.verificaString("Campo status nao pode ser nulo ou vazio.", status);

        switch (status.toUpperCase()){
            case "PENDENTE": this.status = Status.PENDENTE;
            case "REALIZADO": this.status = Status.REALIZADO;
            default: throw new IllegalArgumentException();
        }
    }

    public void realizaItem() { this.status = Status.REALIZADO; }

    public Status getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return this.status.getValor() + " - " + this.item;
    }
}
