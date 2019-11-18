package projetoLP2.comparadores.atividade;

import projetoLP2.classes.Atividade;

import java.util.Comparator;

/**
 * Classe comparadora de atividade, a ordem e da mais antiga para a menos antiga.
 *
 * @author Lucas Alves Vigolvino
 */
public class ComparaAtividadeMaisAntiga implements Comparator<Atividade> {
    @Override
    public int compare(Atividade atividade1, Atividade atividade2) {
        Integer numero1 = Integer.parseInt(atividade1.getCodigo().substring(1));
        Integer numero2 = Integer.parseInt(atividade2.getCodigo().substring(1));
        if(numero1 > numero2) { return 1; }
        else if(numero1 < numero2) { return -1; }
        else { return 0; }
    }
}
