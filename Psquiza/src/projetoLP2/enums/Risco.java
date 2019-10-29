package projetoLP2.enums;

/**
 * Enumerado que representa os níveis dos riscos de uma atividade.
 * @author Charles Bezerra de Oliveira Júnior
 */
public enum Risco {
    BAIXO("BAIXO"),
    MEDIO("MEDIO"),
    ALTO("ALTO");

    /**
     * Descricao do nível de dificuldade de uma atividade.
     */
    private String risco, descricao;

    Risco(String risco){
        this.risco = risco;
    }

    public String getRisco(){
        return this.risco;
    }

    /**
     * Retorna a descricao
     * @return descricao do risco selecionado
     */
    public String getDescricao(){
        return this.descricao;
    }

    /**
     * Altera a descricao do risco
     * @param descricao
     */
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
