package projetoLP2.enums;

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