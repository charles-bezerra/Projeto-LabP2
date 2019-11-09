package projetoLP2.classes;

import projetoLP2.enums.Estado;
import projetoLP2.util.Verificador;

import java.util.*;

/**
 * Classe que representa uma pesquisa
 * @author Iago Henrique de Souza Silva
 */
public class Pesquisa implements Comparable<Pesquisa>{
	/**
	 * O mapa de codigos das pesquisas e o numero de vezes em que cada um foi usado.
	 * A chave representa uma combinacao de tres letras e o valor o numero de vezes em
	 * que aquela combinacao foi usada iniciando em 1
	 */
	private static Map<String, Integer> idPesquisas = new HashMap<>();
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

	private Map<String, Objetivo> objetivos;

	private Problema problema;

	/**
	 * Constroi uma pesquisa a partir da descricao, campo de interesse
	 * e seu codigo. Seu estado comeca como 'ATIVA' e seu motivo vazio
	 *
	 * @param descricao a descricao da pesquisaa
	 * @param campoDeInteresse seus temas
	 */
	public Pesquisa(String descricao, String campoDeInteresse) {
		Verificador.verificaString("Descricao nao pode ser nula ou vazia.", descricao);
		verificaCampo(campoDeInteresse);

		this.descricao = descricao;
		this.campoDeInteresse = campoDeInteresse;
		this.cod = geraCodigo(campoDeInteresse);

		this.estado = Estado.ATIVA;
		this.motivo = "";
		this.objetivos = new HashMap<>();
		this.problema = null;
	}


	/**
	 * Verifica se uma string se enquadra nos padroes do campo
	 * de interesse de uma pesquisa.
	 * Podendo ter até 4 topicos, separados por virgula
	 * e ter até 255 caracteres
	 */
	private void verificaCampo(String campo) {
		Verificador.verificaString("Formato do campo de interesse invalido.", campo);
		String[] topicos = campo.split(",");
		if(campo.length() > 255 || topicos.length > 4)
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		for(String topico : topicos)
			if (topico.length() < 3 || topico.trim().isEmpty())
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
	}

	/**
	 * Gera um novo codigo unico para uma pesquisa.
	 * Este código é gerado automaticamente pelas primeiras três letras do campo de interesse
	 * mais um valor inteiro começando em 1.
	 *
	 * @param campo o campo de interesse da pesquisa
	 * @return retorna o codigo gerado
	 */
	private String geraCodigo(String campo) {
		String cod = campo.substring(0, 3).toUpperCase();
		if(idPesquisas.containsKey(cod)){
			int i = idPesquisas.get(cod) + 1;
			idPesquisas.replace(cod, i);
		} else{
			idPesquisas.put(cod, 1);
		}
		return cod + idPesquisas.get(cod);
	}

	private boolean ehAtiva(){
		return this.estado == Estado.ATIVA;
	}

	public boolean associaProblema(Problema problema){
		if (!this.ehAtiva())
			throw new IllegalArgumentException("Pesquisa desativada.");
		if (this.problema != null && this.problema.equals(problema))
			return false;
		if (this.problema != null)
			throw new IllegalArgumentException("Pesquisa ja associada a um problema.");
		this.problema = problema;
		return true;
	}

	public boolean desassociaProblema(){
		if (!this.ehAtiva())
			throw new IllegalArgumentException("Pesquisa desativada.");
		if (this.problema == null)
			return false;
		this.problema = null;
		return true;
	}

	public boolean associaObjetivo(Objetivo objetivo){
		if (!this.ehAtiva())
			throw new IllegalArgumentException("Pesquisa desativada.");
		if (this.objetivos.containsKey(objetivo.getId()))
			throw new IllegalArgumentException("Objetivo ja associado a uma pesquisa.");
		this.objetivos.put(objetivo.getId(), objetivo);
		return true;
	}

	public boolean desassociaObjetivo(String idObjetivo){
		Verificador.verificaString("Campo idObjetivo nao pode ser vazio ou nulo", idObjetivo);
		if (!this.ehAtiva())
			throw new IllegalArgumentException("Pesquisa desativada.");
		if (!this.objetivos.containsKey(idObjetivo))
			return false;
		this.objetivos.remove(idObjetivo);
		return true;
	}

	public int qtdObjetivos(){
		return this.objetivos.size();
	}

	/**
	 * Altera a descricao da pesquisa
	 *
	 * @param descricao a nova descricao
	 */
	public void setDescricao(String descricao) {
		if(getEstado().equals("DESATIVADA"))
			throw new IllegalArgumentException("Pesquisa desativada.");
		Verificador.verificaString("Descricao nao pode ser nula ou vazia.", descricao);
		this.descricao = descricao;
	}

	/**
	 * Altera o campo de interesse da pesquisa
	 *
	 * @param campoDeInteresse o novo campo de interesse
	 */
	public void setCampoDeInteresse(String campoDeInteresse) {
		if(getEstado().equals("DESATIVADA"))
			throw new IllegalArgumentException("Pesquisa desativada.");

		Verificador.verificaString("Campo de interesse nao pode ser nulo ou vazio.", descricao);
		verificaCampo(campoDeInteresse);
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
	 * Captura o codigo da pesquisa e o retorna
	 *
	 * @return o codigo da pesquisa
	 */
	public String getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCampoDeInteresse() {
		return campoDeInteresse;
	}



	public Problema getProblema(){ return this.problema; }

	/**
	 * Altera o estado da pesquisa para ATIVA
	 */
	public void ativaPesquisa() {
		if(getEstado().equals("ATIVA"))
			throw new IllegalArgumentException("Pesquisa ja ativada.");
		estado = Estado.ATIVA;
	}

	/**
	 * Altera o estado da pesquisa para DESATIVADA
	 */
	public void encerraPesquisa(String motivo) {
		if(getEstado().equals("DESATIVADA"))
			throw new IllegalArgumentException("Pesquisa desativada.");
		Verificador.verificaString("Motivo nao pode ser nulo ou vazio.", motivo);
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


	/**
	 * Retorna se este objeto eh igual a um outro.
	 *
	 * @param o o objeto a ser comparado
	 *
	 * @return a confirmacao se este objeto e igual ao outro
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pesquisa)) return false;
		Pesquisa pesquisa = (Pesquisa) o;
		return getCod().equals(pesquisa.getCod());
	}


	/**
	 * Gera um valor que identifica esta pesquisa.
	 *
	 * @return o hashcode da pesquisa.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getCod());
	}

	/**
	 *
	 * @param o representa outro objeto para a comparação.
	 * @return um inteiro referente a comparação entre os objetos.
	 */
	@Override
	public int compareTo(Pesquisa o) {
		return o.getCod().compareTo(this.getCod());
	}
}
