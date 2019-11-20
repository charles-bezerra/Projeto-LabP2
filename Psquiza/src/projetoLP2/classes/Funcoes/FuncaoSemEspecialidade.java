package projetoLP2.classes.Funcoes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;

import java.io.Serializable;

/**
 * Classe abstrata que representa uma funcao que nao possui
 * ou  ainda nao definiu seus atributos especificos.
 * Contendo apenas o seu nome.
 * @author Iago Henrique de Souza Silva
 */
public abstract class FuncaoSemEspecialidade implements Funcao, Serializable {
    /**
     * O nome da funcao
     */
    private TipoFuncao nome;

    /**
     * Constroi uma nova funcao sem especialidade, usando apenas o seu nome.
     * @param nome O nome da funcao
     */
    public FuncaoSemEspecialidade(TipoFuncao nome){
        this.nome = nome;
    }


    /**
     * Metodo que apenas lanca uma excessao, visto que
     * neste tipo de funcao nao existe um atributo a ser
     * alterado
     */
    @Override
    public void alteraEspecialidade(String atributo, String novoValor) {
        throw new IllegalArgumentException("Atributo invalido.");
    }


    /**
     * Captura o nome da especialidade e o retorna.
     * @return o nome da especialidade.
     */
    @Override
    public String getNome() {
        return nome.getFuncao();
    }


    /**
     * Metodo que apenas retorna vazio, visto que
     * neste tipo de funcao nao existe um atributo inicializado
     * para montar a representacao textual da funcao
     *
     * @return  A string "".
     */
    @Override
    public String toString() {
        return "";
    }
}
