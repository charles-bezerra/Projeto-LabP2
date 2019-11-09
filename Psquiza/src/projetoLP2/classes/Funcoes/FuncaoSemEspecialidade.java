package projetoLP2.classes.Funcoes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;

public abstract class FuncaoSemEspecialidade implements Funcao {
    private TipoFuncao nome;

    public FuncaoSemEspecialidade(TipoFuncao nome){
        this.nome = nome;
    }

    @Override
    public void alteraEspecialidade(String atributo, String novoValor) {
        throw new IllegalArgumentException("Atributo invalido.");
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
