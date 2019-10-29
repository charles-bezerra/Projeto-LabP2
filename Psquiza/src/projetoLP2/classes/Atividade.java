package projetoLP2.classes;

import projetoLP2.enums.Risco;
import projetoLP2.enums.Status;
import projetoLP2.util.Verificador;

import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */

public class Atividade {
    private static int cotador = 0;
    private String codigo;
    private String descricao;

    private Period duracao;
    private Risco risco;
    private List<Item> items;

    public Atividade(String descricao, String nivelRisco, String descricaoRisco){
        this.codigo = "A" + ++cotador;
        this.descricao = Verificador.verificaString("Campo Descricao nao pode ser nulo ou vazio.",descricao);
        this.atribuiRisco(nivelRisco, descricaoRisco);

        this.items = new ArrayList<>();
    }

    public String getCodigo(){
        return this.codigo;
    }

    private void atribuiRisco(String nivelRisco, String descricaoRisco){
        Verificador.verificaString("Campo nivelRisco nao pode ser nulo ou vazio.", nivelRisco);
        Verificador.verificaString("Campo descricaoRisco nao pode ser nulo ou vazio.", descricaoRisco);

        nivelRisco = nivelRisco.toUpperCase();

        switch (nivelRisco) {
            case "BAIXO": this.risco = Risco.BAIXO; break;
            case "MEDIO": this.risco = Risco.MEDIO; break;
            case "ALTO": this.risco = Risco.ALTO; break;
            default: throw new IllegalArgumentException("Valor invalido do nivel do risco.");
        }

        this.risco.setDescricao(descricaoRisco);
    }

    public void cadastraItem(String item){
        this.items.add(new Item(item));
    }

    public int contaItensPendentes(){
        int cont = 0;
        for (Item item: this.items)
            if (item.getStatus() == Status.PENDENTE) cont++;
        return cont;
    }

    public int contaItensRealizados(){
        int cont = 0;
        for (Item item: this.items)
            if (item.getStatus() == Status.REALIZADO) cont++;
        return cont;
    }

    @Override
    public String toString(){
        StringBuilder texto = new StringBuilder(
                this.descricao + " (" +
                this.risco.getRisco() + " - " +
                this.risco.getDescricao() + ") "
        );

        Iterator<Item> items = this.items.iterator();
        Item item;

        while (items.hasNext()){
            texto.append(" | ");
            texto.append( items.next().toString() );
        }

        return texto.toString();
    }
}