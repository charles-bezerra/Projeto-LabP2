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
	 * Mapa de atividade associadas a essa pesquisa.
	 */
	private Map<String, Atividade> atividades;


	/**
	 * Mapa de pesquisadores associados a essa pesquisa.
	 */
	private Map<String, Pesquisador> pesquisadores;

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
		this.atividades = new HashMap<>();
		this.pesquisadores = new HashMap<>();
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

	/**
	 * Retorna se a pesquisa esta ativa
	 * @return boolean
	 */
	private boolean ehAtiva(){
		return this.estado == Estado.ATIVA;
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

	/**
	 * Funcao que retorna a descricao da pesquisa
	 * @return String com a descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Funcao para retorna o campo de interesse da pesquisa
	 * @return String com o campo de interesse
	 */
	public String getCampoDeInteresse() {
		return campoDeInteresse;
	}

	/**
	 * Funcao para retorna o problema da pesquisa
	 * @return Um objeto do tipo Problema
	 */
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
	 * Associa uma atividade a uma pesquisa.
	 *
	 * @param atividade a atividade a ser associada
	 * @return true se a operacao foi um sucesso e false se nao foi
	 */
	public boolean associaAtividade(Atividade atividade) {
		if(!this.ehAtiva()) { throw new IllegalArgumentException("Pesquisa desativada."); }
		if(atividades.containsKey(atividade.getCodigo())) {return false; }
		atividades.put(atividade.getCodigo(), atividade);
		return true;
	}

	/**
	 * Desassocia uma atividade a uma pesquisa.
	 *
	 * @param atividade a atividade a ser desassociada
	 * @return true se a operacao foi um sucesso e false se nao foi
	 */
	public boolean desassociaAtividade(Atividade atividade) {
		if(!this.ehAtiva()) { throw new IllegalArgumentException("Pesquisa desativada."); }
		if(!atividades.containsKey(atividade.getCodigo())) {return false; }
		atividades.remove(atividade.getCodigo());
		return true;
	}

	/**
	 * Testa se uma atividade está associada a essa pesquisa.
	 *
	 * @param codigoAtividade o codigo da atividade a ser testada.
	 * @return true se estiver associada e false se nao estiver
	 */
	public boolean encontrAtividade(String codigoAtividade) {
		return atividades.containsKey(codigoAtividade);
	}

	/**
	 * Associa um problema a pesquisa
	 * @param problema objeto Problema que esta sendo associado a pesquisa
	 * @return sucesso da associacao do problema
	 */
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

	/**
	 * Desassocia o problema existente na pesquisa
	 * @return sucesso da desassociacao
	 */
	public boolean desassociaProblema(){
		if (!this.ehAtiva())
			throw new IllegalArgumentException("Pesquisa desativada.");
		if (this.problema == null)
			return false;
		this.problema = null;
		return true;
	}

	/**
	 * Associa um objetivo a pesquisa
	 * @param objetivo objeto do tipo Objetivo que esta sendo associado a pesquisa
	 * @return sucesso da associacao
	 */
	public boolean associaObjetivo(Objetivo objetivo){
		if (!this.ehAtiva())
			throw new IllegalArgumentException("Pesquisa desativada.");
		if (this.objetivos.containsKey(objetivo.getId()))
			return false;
		if (!objetivo.getDisponivel())
			throw new IllegalArgumentException("Objetivo ja associado a uma pesquisa.");

		objetivo.tornarIndisponivel();

		this.objetivos.put(objetivo.getId(), objetivo);
		return true;
	}

	/**
	 * Desassocia um obejtivo da pesquisa
	 * @param idObjetivo String que consiste no endereco do objetivo
	 * @return sucesso da desassociacao do objetivo
	 */
	public boolean desassociaObjetivo(String idObjetivo){
		Verificador.verificaString("Campo idObjetivo nao pode ser nulo ou vazio.", idObjetivo);
		if (!this.ehAtiva())
			throw new IllegalArgumentException("Pesquisa desativada.");
		if (!this.objetivos.containsKey(idObjetivo))
			return false;
		this.objetivos.get(idObjetivo).tornarDisponivel();
		this.objetivos.remove(idObjetivo);
		return true;
	}

	/**
	 * Retorna a quantidade de objetivos da pesquisa
	 * @return int da quantidade dos objetivos da pesquisa
	 */
	public int qtdObjetivos(){
		return this.objetivos.size();
	}

	/**
	 * Associa um pesquisador a uma pesquisa.
	 *
	 * @param pesquisador o pesquisador a ser associado
	 * @return true se a operacao foi um sucesso e false se nao foi
	 */
	public boolean associaPesquisador(Pesquisador pesquisador) {
		if(!this.ehAtiva()) { throw new IllegalArgumentException("Pesquisa desativada."); }
		if(pesquisadores.containsKey(pesquisador.getEmail())) {return false; }
		pesquisadores.put(pesquisador.getEmail(), pesquisador);
		return true;
	}

	/**
	 * Desassocia um pesquisador a uma pesquisa.
	 *
	 * @param pesquisador o pesquisador a ser desassociado
	 * @return true se a operacao foi um sucesso e false se nao foi
	 */
	public boolean desassociaPesquisador(Pesquisador pesquisador) {
		if(!this.ehAtiva()) { throw new IllegalArgumentException("Pesquisa desativada."); }
		if(!pesquisadores.containsKey(pesquisador.getEmail())) {return false; }
		pesquisadores.remove(pesquisador.getEmail());
		return true;
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
