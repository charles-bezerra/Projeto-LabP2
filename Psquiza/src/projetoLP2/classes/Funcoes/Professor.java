package projetoLP2.classes.Funcoes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;
import projetoLP2.util.Verificador;

public class Professor implements Funcao {
    private TipoFuncao nome;
    private String formacao;
    private String unidade;
    private String data;

    public Professor(String formacao, String unidade, String data){
        Verificador.verificaString("Campo formacao nao pode ser nulo ou vazio.", formacao);
        Verificador.verificaString("Campo unidade nao pode ser nulo ou vazio.", unidade);
        Verificador.verificaString("Campo data nao pode ser nulo ou vazio.", data);
        Verificador.verificaData("Atributo data com formato invalido.", data);

        nome = TipoFuncao.PROFESSOR;
        this.formacao = formacao;
        this.unidade = unidade;
        this.data = data;
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
        return String.format(" - %s - %s - %s",
                formacao,unidade,data);
    }
}
