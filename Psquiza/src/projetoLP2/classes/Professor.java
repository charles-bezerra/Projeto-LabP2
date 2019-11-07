package projetoLP2.classes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;
import projetoLP2.util.Verificador;

public class Professor implements Funcao {
    private TipoFuncao nome;
    private String formacao;
    private String unidade;
    private String data;

    public Professor(){
        nome = TipoFuncao.PROFESSOR;
        formacao = "";
        unidade = "";
        data = "";
    }

    @Override
    public void alteraEspecialidade(String atributo, String novoValor) {
        switch (atributo.toUpperCase()) {
            case "FORMACAO":
                setFormacao(novoValor);
                break;
            case "UNIDADE":
                setUnidade(novoValor);
                break;
            case "DATA":
                Verificador.verificaData("Atributo data com formato invalido.", novoValor);
                setData(novoValor);
                break;
            default:
                throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
        }
    }


    private void setFormacao(String formacao){
        this.formacao = formacao;
    }

    private void setUnidade(String unidade){
        this.unidade = unidade;
    }

    private void setData(String data){
        this.data = data;
    }

    @Override
    public String getNome() {
        return nome.getFuncao();
    }


    @Override
    public String toString() {
        if(formacao == "" || unidade == "" || data == ""){
            return "";
        }
        return String.format(" - %s - %s - %s",
                formacao,unidade,data);
    }
}
