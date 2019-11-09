package projetoLP2.classes.Funcoes;

import projetoLP2.enums.TipoFuncao;
/**
 * Classe de marcacao. Que representa
 * a escialidade Externo de um pesquisador.
 * @author Iago Henrique de Souza Silva
 */
public class Externo extends FuncaoSemEspecialidade {
    /**
     * Constroi um novo Externo. Definindo O nome da funcao
     * como EXTERNO.
     */
    public Externo(){
        super(TipoFuncao.EXTERNO);
    }
}
