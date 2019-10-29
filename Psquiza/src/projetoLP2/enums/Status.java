package projetoLP2.enums;

/**
 * Enumera o status de um item de uma atividade metodologica
 * @author Charles Bezerra de Oliveira Junior
 */
public enum Status {
    PENDENTE("PENDENTE"),
    REALIZADO("REALIZADO");

    private String valor;

    Status(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }
}