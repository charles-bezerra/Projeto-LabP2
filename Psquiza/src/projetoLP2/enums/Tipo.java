package projetoLP2.enums;

/**
 * Enumera o tipo de um objetivo.
 *
 * @author Lucas Alves Vigolvino
 */
public enum Tipo {
    GERAL("GERAL"),
    ESPECIFICO("ESPECIFICO");
    /**
     * tipo de um objetivo.
     */
    private String tipo;

    Tipo(String tipo) { this.tipo = tipo; }
    public String getTipo() { return tipo; }
}
