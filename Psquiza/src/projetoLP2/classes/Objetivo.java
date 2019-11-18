package projetoLP2.classes;

import projetoLP2.enums.Disponibilidade;
import projetoLP2.enums.Tipo;
import projetoLP2.util.Verificador;

import java.io.Serializable;

/**
 * Classe que representa um objetivo.
 * 
 * @author Lucas Alves Vigolvino
 */
public class Objetivo implements Comparable<Objetivo>, Serializable {
	/**
	 * Descricao e id do objetivo.
	 */
	private String descricao, id;

	/**
	 * Tipo do objetivo, podendo ser GERAL ou ESPECIFICO.
	 */
	private Tipo tipo;

	/**
	 * Valor de aderencia e de viabilidade do objetivo, sedo ambos numeros inteiros de 1 a 5.
	 */
	private int aderencia, viabilidade;

	/**
	 * Contador que ajuda na criação do id do objetivo.
	 */
	private static int contador = 1;

	/**
	 * Enum que representa a disponibilidade do Objetivo
	 */
	private Disponibilidade disponibilidade;

	/**
	 * Controi um objetivo a partir de seu tipo, descricao, valor de aderecia e valor de vibilidade.
	 * 
     * @param tipo o tipo do objetivo, GERAL ou ESPECIFICO
     * @param descricao a descricao do objetivo
     * @param aderencia o valor de aderencia do objetivo, numero inteiro de 1 a 5
     * @param viabilidade o valor de vibilidade do objetivo, numero inteiro de 1 a 5
	 */
	public Objetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		Verificador.verificaString("Campo tipo nao pode ser nulo ou vazio.", tipo);
		this.descricao = Verificador.verificaString("Campo descricao nao pode ser nulo ou vazio.", descricao);

		if(1 > aderencia || aderencia > 5)
			throw new IllegalArgumentException("Valor invalido de aderencia");
		else if(1 > viabilidade || viabilidade > 5)
			throw new IllegalArgumentException("Valor invalido de viabilidade.");

		else {
			this.aderencia = aderencia;
			this.viabilidade = viabilidade;
			this.id = "O" + contador;
			switch(tipo) {
				case "GERAL":{ this.tipo = Tipo.GERAL; break; }
				case "ESPECIFICO":{ this.tipo = Tipo.ESPECIFICO; break; }
				default: throw new IllegalArgumentException("Valor invalido de tipo."); }
			contador++;
		}

		this.disponibilidade = Disponibilidade.DISPONIVEL;
	}

	/**
	 * Retorna o id do objetivo.
	 *
	 * @return o id do objetivo
	 */
	public String getId() { return id; }

	/**
	 * Recupera a disponibilidade do Objetivo
	 *
	 * @return Disponibilidade
	 */
	public boolean getDisponivel() {
	    return this.disponibilidade == Disponibilidade.DISPONIVEL;
	}

	/**
	 * Torna o objetivo disponivel
	 */
	public void tornarDisponivel(){
		this.disponibilidade = Disponibilidade.DISPONIVEL;
	}

	/**
	 * Torna o objetivo indisponivel
	 */
	public void tornarIndisponivel() {
		this.disponibilidade = Disponibilidade.INDISPONIVEL;
	}

	/**
     * Retorna a descricao do objetivo
	 *
     * @return String com a descricao do objetivo
     */
	public String getDescricao() { return descricao; }

	/**
	 * Retorna a representacao em String de um objetivo.
	 * 
	 * @return uma String que representa um objetivo
	 */
	@Override
	public String toString() { return id + " - " + tipo + " - " + descricao + " - " + (aderencia + viabilidade); }

	/**
	 *
	 * @param o representa outro objeto para a comparação.
	 * @return um inteiro referente a comparação entre os objetos.
	 */
	@Override
	public int compareTo(Objetivo o) {
		return o.getId().compareTo(this.getId());
	}

}
