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
    private String risco;

    Risco(String risco){
        this.risco = risco;
    }

    public String getRisco(){
        return this.risco;
    }

}
