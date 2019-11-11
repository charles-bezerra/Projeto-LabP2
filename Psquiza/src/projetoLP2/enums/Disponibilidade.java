package projetoLP2.enums;

public enum Disponibilidade {
    INDISPONIVEL("INDISPONIVEL"), DISPONIVEL("DISPONIVEL");

    private String disponibilidade;

    Disponibilidade(String disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }
}
