package projetoLP2.classes;

import projetoLP2.util.Verificador;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa um problema.
 * @author Lucas Alves Vigolvino
 * @author Charles Bezerra de Oliveria Júnior
 */
public class Problema implements Comparable<Problema>, Serializable {
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
	private static int contador = 1;

	/**
	 * Controi um problema a partir de sua descricao e do seu valor de viabilidade.
	 * @param descricao a descricao do problema
     * @param viabilidade o valor de viabilidade do problema, numero inteiro de 1 a 5
	 */
	public Problema(String descricao, int viabilidade) {
		this.descricao = Verificador.verificaString("Campo descricao nao pode ser nulo ou vazio.", descricao);

		if (1 > viabilidade || viabilidade > 5)
			throw new IllegalArgumentException("Valor invalido de viabilidade.");

		this.viabilidade = viabilidade;
		this.id = "P" + contador;

		contador++;
	}

	/**
	 * Retorna o id do problema.
	 * @return o id do problema
	 */
	public String getId() { return this.id; }

	public String getDescricao() { return descricao; }

	/**
	 * Retorna se este objeto e igual ao outro.
	 *
	 * @param o o objeto a ser comparado
	 * @return a confirmacao se este objeto e igual ao outro
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Problema problema = (Problema) o;
		return Objects.equals(id, problema.id);
	}

	/**
	 * Gera um valor que identifica este problema.
	 *
	 * @return o hashcode do problema.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * Retorna a representacao em String de um problema.
	 * @return uma String que representa um problema
	 */
	@Override
	public String toString() { return id + " - " + descricao + " - " + viabilidade; }

	/**
	 * @param o representa outro objeto para a comparação.
	 * @return um inteiro referente a comparação entre os objetos.
	 */
	@Override
	public int compareTo(Problema o) {
		return o.getId().compareTo(this.getId());
	}
}
