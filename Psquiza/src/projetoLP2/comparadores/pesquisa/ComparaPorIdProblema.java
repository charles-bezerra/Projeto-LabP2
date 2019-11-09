package projetoLP2.comparadores.pesquisa;

import projetoLP2.classes.Pesquisa;

import java.util.Comparator;

public class ComparaPorIdProblema implements Comparator<Pesquisa> {
    @Override
    public int compare(Pesquisa p1, Pesquisa p2){
        int pos = p1
                .getProblema()
                .getId()
                .compareTo( p2.getProblema().getId() );
        if (pos == 0) return 0;
        return (pos > 0) ? -1 : 1;
    }
}
