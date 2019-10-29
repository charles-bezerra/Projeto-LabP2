package projetoLP2.classes;

import projetoLP2.enums.Estado;
/**
 * Classe que representa uma pesquisa
 * @author Iago Henrique de Souza Silva
 */
public class Pesquisa {
	/**
	 * Descricao da pesquisa
	 */
	private String descricao;
	/**
	 * Um marcador da area ou tema da pesquisa.
	 * Pode ter até 4 topicos, separados por virgula e ter até 255 caracteres
	 */
	private String campoDeInteresse;
	/**
	 * Codigo identificador da pesquisa.
	 * Representado pelas primeiras tres letras do campo de interesse
	 * mais um valor inteiro
	 */
	private String cod;
	/**
	 * Estado da pesquisa, varindo entre ATIVA ou DESATIVADA
	 */
	private Estado estado;
	/**
	 * Motivo de desativacao da pesquisa
	 */
	private String motivo;


	/**
	 * Constroi uma pesquisa a partir da descricao, campo de interesse
	 * e seu codigo. Seu estado comeca como 'ATIVA' e seu motivo vazio
	 *
	 * @param descricao a descricao da pesquisaa
	 * @param campoDeInteresse seus temas
	 * @param cod o indentificador da pesquisa
	 */
	public Pesquisa(String descricao, String campoDeInteresse, String cod) {
		this.descricao = descricao;
		this.campoDeInteresse = campoDeInteresse;
		this.cod = cod;
		estado = Estado.ATIVA;
		motivo = "";
	}

	/**
	 * Altera a descricao da pesquisa
	 *
	 * @param descricao a nova descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Altera o campo de interesse da pesquisa
	 *
	 * @param campoDeInteresse o novo campo de interesse
	 */
	public void setCampoDeInteresse(String campoDeInteresse) {
		this.campoDeInteresse = campoDeInteresse;
	}

	/**
	 * Captura o estado da pesquisa e o retorna
	 *
	 * @return o estado da pesquisa
	 */
	public String getEstado() {
		return estado.getEstado();
	}

	/**
	 * Altera o estado da pesquisa para ATIVA
	 */
	public void ativaPesquisa() {
		estado = Estado.ATIVA;
	}

	/**
	 * Altera o estado da pesquisa para DESATIVADA
	 */
	public void encerraPesquisa(String motivo) {
		this.motivo = motivo;
		estado = Estado.DESATIVADA;
	}


	/**
	 * Retorna uma representaçao textual com as informacoes de uma pesquisa
	 *
	 * @return a representaçao textual da pesquisa no formato 'codigo - descricao - campo de interesse'
	 */
	@Override
	public String toString() {
		return String.format("%s - %s - %s", this.cod,this.descricao,this.campoDeInteresse);
	}

}
