package projetoLP2.enums;

public enum Funcao {
    EXTERNO("EXTERNO"),
    ESTUDANTE("ESTUDANTE"),
    PROFESSOR("PROFESSOR");

    /**
     * Descricao do estado atual de uma pesquisa
     */
    private String funcao;

    Funcao(String funcao){
        this.funcao = funcao;
    }

    public String getFuncao(){
        return this.funcao;
    }
}
