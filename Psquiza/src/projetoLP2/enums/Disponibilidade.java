package projetoLP2.enums;

/**
 * Enumerador que pode representar em um objeto se ele está
 * disponivel ou nao.
 *
 * @author Charles Bezerra de Oliveira Junior
 */
public enum Disponibilidade {
    INDISPONIVEL("INDISPONIVEL"),
    DISPONIVEL("DISPONIVEL");

    private String disponibilidade;

    Disponibilidade(String disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }
}
