package projetoLP2.comparadores.atividade;

import projetoLP2.classes.Atividade;

import java.util.Comparator;

public class ComparaAtividadeMenosPendencias implements Comparator<Atividade> {
    @Override
    public int compare(Atividade atividade1, Atividade atividade2) {
        if (atividade1.contaItensPendentes() < atividade2.contaItensPendentes()) {
            return -1;
        } else if (atividade1.contaItensPendentes() > atividade2.contaItensPendentes()) {
            return 1;
        } else {
            return 0;
        }
    }
}
