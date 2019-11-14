package projetoLP2.comparadores.atividade;

import projetoLP2.classes.Atividade;
import projetoLP2.enums.Risco;

import java.util.Comparator;

public class ComparaAtividadeMaiorRisco implements Comparator<Atividade> {
    @Override
    public int compare(Atividade atividade1, Atividade atividade2) {
        if(atividade1.equals(atividade2)) {
            return 0;
        }
        if (atividade1.equals(Risco.ALTO)) {
            return -1;
        } else if (atividade1.equals(Risco.BAIXO)) {
            return 1;
        } else {
            if (atividade2.equals(Risco.ALTO)) {
                return 1;
            } else if (atividade2.equals(Risco.BAIXO)) {
                return -1;
            }
        }
        return 0;
    }
}
