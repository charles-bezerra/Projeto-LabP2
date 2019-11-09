package projetoLP2.comparadores.pesquisa;

import projetoLP2.classes.Pesquisa;

import java.util.Comparator;

public class ComparaPorObjetivos implements Comparator<Pesquisa> {
    @Override
    public int compare(Pesquisa p1, Pesquisa p2){
        if (p1.qtdObjetivos() == p2.qtdObjetivos() && p1.qtdObjetivos() == 0)
            return ( p1.getCod().compareTo(p2.getCod()) > 0 ) ? -1 : 1;
        else if (p1.qtdObjetivos() == p2.qtdObjetivos()) {
            return 0;
        }
        return 0;
    }
}
