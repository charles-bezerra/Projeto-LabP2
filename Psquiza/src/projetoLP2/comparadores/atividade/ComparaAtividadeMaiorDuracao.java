package projetoLP2.comparadores.atividade;

import projetoLP2.classes.Atividade;

import java.util.Comparator;

/**
 * Classe comparadora de atividade, a ordem e da maior duracao para a menor duracao
 *
 * @author Lucas Alves Vigolvino
 */
public class ComparaAtividadeMaiorDuracao implements Comparator<Atividade> {
    @Override
    public int compare(Atividade atividade1, Atividade atividade2) {
        if(atividade1.getDuracao() > atividade2.getDuracao()) {
            return -1;
        } else if(atividade1.getDuracao() < atividade2.getDuracao()) {
            return 1;
        }
        return 0;
    }
}
