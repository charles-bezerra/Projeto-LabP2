package projetoLP2.enums;

/**
 * Enumerador que representa os estados de uma pesquisa.
 * @author Iago Henrique de Souza Silva
 */
public enum Estado {
    ATIVA("ATIVA"),
    DESATIVADA("DESATIVADA");

    /**
     * Descricao do estado atual de uma pesquisa
     */
    private String estado;

    Estado(String estado){
        this.estado = estado;
    }

    public String getEstado(){
        return this.estado;
    }
}
