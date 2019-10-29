package projetoLP2.classes;

/**
 * Classe que representa um objetivo.
 * 
 * @author Lucas Alves Vigolvino
 */
public class Objetivo {
	/**
	 * Tipo e descricao do objetivo, o tipo podendo ser GERAL ou ESPECIFICO.
	 */
	private String tipo, descricao;
	/**
	 * Valor de aderencia e de viabilidade do objetivo, sedo ambos numeros inteiros de 1 a 5.
	 */
	private int aderencia, viabilidade;
	/**
	 * Controi um objetivo a partir de seu tipo, descricao, valor de aderecia e valor de vibilidade.
	 * 
     * @param tipo o tipo do objetivo, GERAL ou ESPECIFICO
     * @param descricao a descricao do objetivo
     * @param aderencia o valor de aderencia do objetivo, numero inteiro de 1 a 5
     * @param viabilidade o valor de vibilidade do objetivo, numero inteiro de 1 a 5
	 */
	public Objetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.aderencia = aderencia;
		this.viabilidade = viabilidade;
	}
	/**
	 * Retorna a representacao em String de um objetivo.
	 * 
	 * @return uma String que representa um objetivo
	 */
	@Override
	public String toString() {
		return tipo + " - " + descricao + " - " + (aderencia + viabilidade);
	}
}