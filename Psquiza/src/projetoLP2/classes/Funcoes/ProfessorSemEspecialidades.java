package projetoLP2.classes.Funcoes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;
import projetoLP2.util.Verificador;

public class ProfessorSemEspecialidades implements Funcao {
    private TipoFuncao nome;

    public ProfessorSemEspecialidades(){
        nome = TipoFuncao.PROFESSOR;
    }

    @Override
    public void alteraEspecialidade(String atributo, String novoValor) {
        throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
    }


    @Override
    public String getNome() {
        return nome.getFuncao();
    }


    @Override
    public String toString() {
            return "";
        }
}
