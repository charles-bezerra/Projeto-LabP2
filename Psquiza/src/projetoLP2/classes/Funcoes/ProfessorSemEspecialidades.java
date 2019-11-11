package projetoLP2.classes.Funcoes;

import projetoLP2.enums.TipoFuncao;
/**
 * Classe de marcacao. Que representa
 * a escialidade Professor de um pesquisador
 * que ainda nao teve seus aatributo iniciados.
 * @author Iago Henrique de Souza Silva
 */
public class ProfessorSemEspecialidades extends FuncaoSemEspecialidade{
    /**
     * Constroi um novo Professor sem especialidade. Definindo O nome da funcao
     * como PROFESSOR.
     */
    public ProfessorSemEspecialidades(){
        super(TipoFuncao.PROFESSOR);
    }
}
