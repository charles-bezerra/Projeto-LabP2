package projetoLP2.comparadores.atividade;

import projetoLP2.classes.Atividade;
import projetoLP2.enums.Risco;

import java.util.Comparator;

/**
 * Classe comparadora de atividade, a ordem e do maior para o menor risco.
 *
 * @author Lucas Alves Vigolvino
 */
public class ComparaAtividadeMaiorRisco implements Comparator<Atividade> {
    @Override
    public int compare(Atividade atividade1, Atividade atividade2) {
        if(atividade1.getRisco().equals(atividade2.getRisco())) {
            Integer numero1 = Integer.parseInt(atividade1.getCodigo().substring(1));
            Integer numero2 = Integer.parseInt(atividade2.getCodigo().substring(1));
            if(numero1 > numero2) { return 1; }
            else if(numero1 < numero2) { return -1; }
            else { return 0; }
        }
        if (atividade1.getRisco().equals(Risco.ALTO)) {
            return -1;
        } else if (atividade1.getRisco().equals(Risco.BAIXO)) {
            return 1;
        } else {
            if (atividade2.getRisco().equals(Risco.ALTO)) {
                return 1;
            } else if (atividade2.getRisco().equals(Risco.BAIXO)) {
                return -1;
            }
        }
        return 0;
    }
}
