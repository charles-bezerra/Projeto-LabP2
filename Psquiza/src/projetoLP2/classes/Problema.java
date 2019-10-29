package projetoLP2.classes;

/**
 * Classe que representa um problema.
 * 
 * @author Lucas Alves Vigolvino
 */
public class Problema {
	/**
	 * Descricao do problema.
	 */
	private String descricao;
	/**
	 * Valor de viabilidade do problema, numero inteiro de 1 a 5
	 */
	private int viabilidade;
	/**
	 * Controi um problema a partir de sua descricao e do seu valor de viabilidade.
	 * 
	 * @param descricao a descricao do problema
     * @param viabilidade o valor de viabilidade do problema, numero inteiro de 1 a 5
	 */
	public Problema(String descricao, int viabilidade) {
		this.descricao = descricao;
		this.viabilidade = viabilidade;
	}
	/**
	 * Retorna a representacao em String de um problema.
	 * 
	 * @return uma String que representa um problema
	 */
	@Override
	public String toString() {
		return descricao + " - " + viabilidade;
	}
}