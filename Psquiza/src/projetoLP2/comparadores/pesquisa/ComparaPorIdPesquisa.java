package projetoLP2.comparadores.pesquisa;
import projetoLP2.classes.Pesquisa;
import java.util.Comparator;

/**
 * Comparador de pesquisa, a ordem vai do maior id de Pesquisa para o menor
 *
 * @author Charles Bezerra de Oliveira Júnior
 */

public class ComparaPorIdPesquisa implements Comparator<Pesquisa> {
    @Override
    public int compare(Pesquisa p1, Pesquisa p2){
        int pos = p1.compareTo(p2);
        if (pos == 0) return 0;
        return (pos > 0) ? -1 : 1;
    }
}
