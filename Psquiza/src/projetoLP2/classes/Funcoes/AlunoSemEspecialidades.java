package projetoLP2.classes.Funcoes;

import projetoLP2.enums.TipoFuncao;
/**
 * Classe de marcacao. Que representa
 * a escialidade Aluno de um pesquisador
 * que ainda nao teve seus aatributo iniciados.
 * @author Iago Henrique de Souza Silva
 */
public class AlunoSemEspecialidades extends FuncaoSemEspecialidade {
    /**
     * Constroi um novo aluno sem especialidade. Definindo O nome da funcao
     * como ESTUDANTE.
     */
    public AlunoSemEspecialidades(){
        super(TipoFuncao.ESTUDANTE);
    }
}
