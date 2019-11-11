package projetoLP2.Interfaces;

/**
 * Representa as diversas espcialidades de um pesquisador.
 * @author Iago Henrique de Souza Silva
 */
public interface Funcao {
    /**
     * Metodo responsavel por alterar um atributo especifico de cada funcao
     * @param atributo representa o atributo que determinado pesquisador quer alterar.
     * @param novoValor representa o novo valor para o atributo desejado.
     */
    void alteraEspecialidade(String atributo, String novoValor);


    /**
     * Retorna o nome da funcao
     */
    String getNome();
}
