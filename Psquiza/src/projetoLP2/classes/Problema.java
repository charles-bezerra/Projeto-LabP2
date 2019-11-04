package projetoLP2.classes;

import projetoLP2.util.Verificador;

/**
 * Classe que representa um problema.
 * 
 * @author Lucas Alves Vigolvino
 */
public class Problema {
	/**
	 * Descricao e id do problema.
	 */
	private String descricao, id;
	/**
	 * Valor de viabilidade do problema, numero inteiro de 1 a 5
	 */
	private int viabilidade;
	/**
	 * Contador que ajuda a criar o id do problema.
	 */
	private static int count = 1;
	/**
	 * Controi um problema a partir de sua descricao e do seu valor de viabilidade.
	 * 
	 * @param descricao a descricao do problema
     * @param viabilidade o valor de viabilidade do problema, numero inteiro de 1 a 5
	 */
	public Problema(String descricao, int viabilidade) {
		this.descricao = Verificador.verificaString("Campo descricao nao pode ser nulo ou vazio.", descricao);
		if (1 > viabilidade || viabilidade > 5) { throw new IllegalArgumentException("Valor invalido de viabilidade.");
		} else {
			this.viabilidade = viabilidade;
			this.id = "P" + count;
			count ++;
		}
	}

	/**
	 * Retorna o id do problema.
	 *
	 * @return o id do problema
	 */
	public String getId() { return id; }
	/**
	 * Retorna a representacao em String de um problema.
	 * 
	 * @return uma String que representa um problema
	 */
	@Override
	public String toString() { return id + " - " + descricao + " - " + viabilidade; }
}