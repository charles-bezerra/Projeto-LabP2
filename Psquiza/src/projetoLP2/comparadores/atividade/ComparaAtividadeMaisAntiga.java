package projetoLP2.comparadores.atividade;

import projetoLP2.classes.Atividade;

import java.util.Comparator;

public class ComparaAtividadeMaisAntiga implements Comparator<Atividade> {
    @Override
    public int compare(Atividade atividade1, Atividade atividade2) { return atividade1.getCodigo().compareTo(atividade2.getCodigo()); }
}
