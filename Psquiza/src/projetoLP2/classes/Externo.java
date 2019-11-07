package projetoLP2.classes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;

public class Externo implements Funcao {
    private TipoFuncao nome;

    public Externo(){
        nome = TipoFuncao.EXTERNO;
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
