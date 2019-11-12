package projetoLP2.comparadores.pesquisa;

import projetoLP2.classes.Pesquisa;

import java.util.Comparator;

/**
 * Comparador de pesquisa, onde a maior quantidade de objetivos tem prioridade. Caso, os
 * dois objetos que estão sendo comparados estejam sem objetivos e comparado qual maior id da pesquisa
 *
 * @author Charles Bezerra de Oliveira Junior
 */

public class ComparaPorObjetivos implements Comparator<Pesquisa> {
    @Override
    public int compare(Pesquisa p1, Pesquisa p2){
        if (p1.qtdObjetivos() == p2.qtdObjetivos())
            return ( p1.getCod().compareTo(p2.getCod()) > 0 ) ? -1 : 1;
        else if ( p1.getCod().compareTo(p2.getCod()) == 0)
            return 0;
        return ( p1.qtdObjetivos() > p2.qtdObjetivos() ) ? -1 : 1;
    }
}
