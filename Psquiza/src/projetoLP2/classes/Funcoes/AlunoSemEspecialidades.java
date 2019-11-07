package projetoLP2.classes.Funcoes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;

public class AlunoSemEspecialidades implements Funcao {
    private TipoFuncao nome;

    public AlunoSemEspecialidades(){
        nome = TipoFuncao.ESTUDANTE;
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
