package projetoLP2.controladores;

import projetoLP2.classes.*;
import projetoLP2.comparadores.pesquisa.ComparaPorIdPesquisa;
import projetoLP2.comparadores.pesquisa.ComparaPorIdProblema;
import projetoLP2.comparadores.pesquisa.ComparaPorObjetivos;
import projetoLP2.util.Verificador;

import java.util.*;

/**
 * Controlador das pesquisas do sistema
 * @author Iago Henrique de Souza Silva
 * @author Charles Bezerra de Oliveira Júnior
 * @author Lucas Alves Vigolvino
 */
public class ControlePesquisa {
	/**
	 * O mapa de pesquisas, com os codigos como chave
	 */
	private Map<String, Pesquisa> pesquisas;

	/**
	 * A estrategia que será usada para ordenar as atividade, por padrao e pela mais antiga cadastrada.
	 */
	private String estrategiaOrdemAtividade;

	/**
	 * O contador de atividades passadas como proximas.
	 */
	private int contaAtividade;

	/**
	 * Constroi o Controller de pesquisas. Onde o mapa de pesquisas
	 */
	public ControlePesquisa() {
		pesquisas = new HashMap<>();
		estrategiaOrdemAtividade = "MAIS_ANTIGA";
		contaAtividade = 0;
	}

	/**
	 * Verifica se existe uma pesquisa
	 *
	 * @param id endenreco da pesquisa
	 * @return boolean
	 */
	private boolean encontraPesquisa(String id){
		return this.pesquisas.containsKey(id);
	}

	/**
	 * Cadastra uma pesquisa no mapa de pesquisas.
	 *
	 * @param descricao a descricao do objetivo
	 * @param campoDeInteresse o campo de interesse da pesquisa
	 * @return o codigo gerado para esta pesquisa
	 */
	public String cadastraPesquisa(String descricao, String campoDeInteresse) {
		Pesquisa p = new Pesquisa(descricao, campoDeInteresse);
		pesquisas.put(p.getCod(), p);
		return p.getCod();
	}

	/**
	 * Altera um atributo de um cliente
	 *
	 * @param codigo o codigo da pesquisa a ser editada
	 * @param conteudoASerAlterado o atributo a ser editado
	 * @param novoConteudo o novo valor do atributo
	 */
	public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
		Verificador.verificaString("Codigo nao pode ser nulo ou vazio.", codigo);
		Verificador.verificaString("Conteudo a ser alterado nao pode ser nulo ou vazio.", conteudoASerAlterado);

		if(!this.encontraPesquisa(codigo))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");

		switch (conteudoASerAlterado) {
			case "DESCRICAO":{ pesquisas.get(codigo).setDescricao(novoConteudo); break; }
			case "CAMPO":{ pesquisas.get(codigo).setCampoDeInteresse(novoConteudo); break; }
			default: throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
		}
	}



	/**
	 * Altera o estado de uma pesquisa para DESATIVADA
	 *
	 * @param codigo o codigo da pesquisa a ser desativada
	 * @param motivo o motivo da desativacao
	 */
	public void encerraPesquisa(String codigo, String motivo) {
		Verificador.verificaString("Codigo nao pode ser nulo ou vazio.", codigo);
		if(!this.encontraPesquisa(codigo))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		pesquisas.get(codigo).encerraPesquisa(motivo);
	}


	/**
	 * Altera o estado de uma pesquisa para ATIVA
	 *
	 * @param codigo o codigo da pesquisa a ser ativada
	 */
	public void ativaPesquisa(String codigo) {	
		Verificador.verificaString("Codigo nao pode ser nulo ou vazio.", codigo);
		if(!this.encontraPesquisa(codigo))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		pesquisas.get(codigo).ativaPesquisa();
	}


	/**
	 * Verifica se uma pesquisa eh ativa ou nao
	 *
	 * @param codigo o codigo da pesquisa a ser verificada
	 * @return se o estado da pesquisa eh igual a 'ATIVA'
	 */
	public boolean pesquisaEhAtiva(String codigo) {
		Verificador.verificaString("Codigo nao pode ser nulo ou vazio.", codigo);
		if(!this.encontraPesquisa(codigo))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		return pesquisas.get(codigo).getEstado().equals("ATIVA");
	}


	/**
	 * Retorna uma representacao textual com as informacoes de uma pesquisa.
	 *
	 * @param codigo o codigo da pesquisa a ser retornada
	 *
	 * @return a representacao textual da pesquisa
	 */
	public String exibePesquisa(String codigo) {
		Verificador.verificaString("Codigo nao pode ser nulo ou vazio.", codigo);
		if(!this.encontraPesquisa(codigo))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		return pesquisas.get(codigo).toString();
	}


	/**
	 * Captura todas as pesuisasdo sistema e as retornam
	 * @return o mapa de pesquisas
	 */
	public Map<String,Pesquisa> getPesquisas(){ return pesquisas; }

	/**
	 * Metodo responsavel por adicionar a um Arraylist de forma ordenada todas as pesquisas que possuem o termo.
	 *
	 * @param termo o termo a ser buscado nas pesquisas.
	 * @return um ArrayList de Strings com todas as pesquisas que possuem o termo.
	 */
	public ArrayList<String> ordenaPesquisa(String termo){
		ArrayList<Pesquisa> buscasOrdenadas = new ArrayList<Pesquisa>(pesquisas.values());
		Collections.sort(buscasOrdenadas);
		ArrayList<String> retorno = new ArrayList<>();

		for (Pesquisa pesquisa: buscasOrdenadas){
			if ( pesquisa.getDescricao()
					.toLowerCase()
					.contains(termo.toLowerCase()) )
				retorno.add(pesquisa.getCod() + ": " + pesquisa.getDescricao());

			if ( pesquisa.getCampoDeInteresse()
					.toLowerCase()
					.contains(termo.toLowerCase()) )
				retorno.add(pesquisa.getCod() + ": " + pesquisa.getCampoDeInteresse());
		}
		return retorno;
	}

	/**
	 * Associa um problema a uma pesquisa
	 * @param idPesquisa endereco da pesquisa que esta sendo associada
	 * @param problema objeto Problema que esta sendo associado a pesquisa
	 * @return sucesso da associacao do problema
	 */
	public boolean associaProblema(String idPesquisa, Problema problema) {
        Verificador.verificaString("Campo idPesquisa nao pode ser nulo ou vazio.", idPesquisa);
	    if (!this.encontraPesquisa(idPesquisa))
	    	throw new IllegalArgumentException("Pesquisa nao encontrada.");
	    return this.pesquisas
                .get(idPesquisa)
                .associaProblema(problema);
	}

	/**
	 * Desassocia o problema existente em uma pesquisa
	 * @param idPesquisa endereco da pesquisa que esta sendo desassociada
	 * @return sucesso da desassociacao
	 */
	public boolean desassociaProblema(String idPesquisa) {
        Verificador.verificaString("Campo idPesquisa nao pode ser nulo ou vazio.", idPesquisa);
        if (!this.encontraPesquisa(idPesquisa))
        	throw new IllegalArgumentException("Pesquisa nao encontrada.");
        return this.pesquisas
                .get(idPesquisa)
                .desassociaProblema();
	}

	/**
	 * Associa um objetivo de uma pesquisa
	 * @param idPesquisa endereco da pesquisa que esta sendo associada
	 * @param objetivo objeto do tipo Objetivo que esta sendo associado a pesquisa
	 * @return sucesso da associacao
	 */
	public boolean associaObjetivo(String idPesquisa, Objetivo objetivo) {
        Verificador.verificaString("Campo idPesquisa nao pode ser nulo ou vazio.", idPesquisa);
        if (!this.encontraPesquisa(idPesquisa)) throw new IllegalArgumentException("Pesquisa nao encontrada.");
        return this.pesquisas
                .get(idPesquisa)
                .associaObjetivo(objetivo);
	}

	/**
	 * Desassocia um obejtivo de uma pesquisa
	 * @param idPesquisa endereco da pesquisa que esta sendo desassociada
	 * @param idObjetivo String que consiste no endereco do objetivo
	 * @return sucesso da desassociacao do objetivo
	 */
	public boolean desassociaObjetivo(String idPesquisa, String idObjetivo){
        Verificador.verificaString("Campo idObjetivo nao pode ser nulo ou vazio.", idPesquisa);
        if (!this.encontraPesquisa(idPesquisa))
        	throw new IllegalArgumentException("Pesquisa nao encontrada.");
        return this.pesquisas
                .get(idPesquisa)
                .desassociaObjetivo(idObjetivo);
    }

	/**
	 * Lista a pesquisas existentes de acorde com um criterio
	 * @param ordem criterio de ordenacao de listagem (PESQUISA, PROBLEMA, OBJETIVOS)
	 * @return String contendo a listagem
	 */
	public String listaPesquisas(String ordem) {
		Verificador.verificaString("Valor invalido da ordem", ordem);
		List<Pesquisa> pesquisas = new ArrayList<>( this.pesquisas.values() );
		StringBuilder resultado = new StringBuilder("");

		switch (ordem.toUpperCase()) {
			case "PROBLEMA": { pesquisas.sort(new ComparaPorIdProblema()); break; }
			case "OBJETIVOS": { pesquisas.sort(new ComparaPorObjetivos()); break; }
			case "PESQUISA": { pesquisas.sort(new ComparaPorIdPesquisa()); break; }
			default: throw new IllegalArgumentException("Valor invalido da ordem");
		}

		Iterator<Pesquisa> pesquisaIterator = pesquisas.iterator();

		while (pesquisaIterator.hasNext()) {
			resultado.append(pesquisaIterator.next().toString());
			if (pesquisaIterator.hasNext())
				resultado.append(" | ");
		}
		return resultado.toString();
	}

	/**
	 * Associa uma atividade a uma pesquisa.
	 *
	 * @param codigoPesquisa o codigo da pesquisa a ser associada
	 * @param atividade a atividade a ser associada
	 * @return true se a operacao foi um sucesso e false se nao foi
	 */
	public boolean associaAtividade(String codigoPesquisa, Atividade atividade) {
		Verificador.verificaString("Campo codigoPesquisa nao pode ser nulo ou vazio.", codigoPesquisa);
		if(!this.encontraPesquisa(codigoPesquisa))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		return pesquisas
				.get(codigoPesquisa)
				.associaAtividade(atividade);
	}

	/**
	 * Desassocia uma atividade a uma pesquisa.
	 *
	 * @param codigoPesquisa o codigo da pesquisa a ser desassociada
	 * @param atividade a atividade a ser desassociada
	 * @return true se a operacao foi um sucesso e false se nao foi
	 */
	public boolean desassociaAtividade(String codigoPesquisa, Atividade atividade) {
		Verificador.verificaString("Campo codigoPesquisa nao pode ser nulo ou vazio.", codigoPesquisa);
		if(!this.encontraPesquisa(codigoPesquisa))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		return pesquisas
				.get(codigoPesquisa)
				.desassociaAtividade(atividade);
	}

	/**
	 * Testa se uma atividade está associada a alguma pesquisa.
	 *
	 * @param atividade a atividade a ser testada.
	 * @return true se estiver associada e false se nao estiver
	 */
	public boolean encontraAtividade(Atividade atividade) {
		for(Pesquisa pesquisa : pesquisas.values()) {
			if (pesquisa.encontrAtividade(atividade.getCodigo()))
				return true;
		}
		return false;
	}

	/**
	 * Associa um pesquisador a uma pesquisa.
	 *
	 * @param codigoPesquisa o codigo da pesquisa a ser associada
	 * @param pesquisador o pesquisador a ser associado
	 * @return true se a operacao foi um sucesso e false se nao foi
	 */
	public boolean associaPesquisador(String codigoPesquisa, Pesquisador pesquisador) {
		Verificador.verificaString("Campo idPesquisa nao pode ser nulo ou vazio.", codigoPesquisa);
		if(!this.encontraPesquisa(codigoPesquisa)) { throw new IllegalArgumentException("Pesquisa nao encontrada."); }
		return pesquisas
				.get(codigoPesquisa)
				.associaPesquisador(pesquisador);
	}

	/**
	 * Desassocia um pesquisador a uma pesquisa.
	 *
	 * @param codigoPesquisa o codigo da pesquisa a ser desassociada
	 * @param pesquisador o pesquisador a ser desassociado
	 * @return true se a operacao foi um sucesso e false se nao foi
	 */
	public boolean desassociaPesquisador(String codigoPesquisa, Pesquisador pesquisador) {
		Verificador.verificaString("Campo idPesquisa nao pode ser nulo ou vazio.", codigoPesquisa);
		if(!this.encontraPesquisa(codigoPesquisa)) { throw new IllegalArgumentException("Pesquisa nao encontrada."); }
		return pesquisas
				.get(codigoPesquisa)
				.desassociaPesquisador(pesquisador);
	}

	/**
	 * Cadastra uma nova estrategia de ordenacao de atividade, substituindo a anterior.
	 *
	 * @param estrategia a nova estrategia de ordenacao de atividade
	 */
	public void setEstrategiaOrdemAtividade(String estrategia) {
		Verificador.verificaString("Estrategia nao pode ser nula ou vazia.", estrategia);
		if(!estrategia.equals("MAIS_ANTIGA") && !estrategia.equals("MENOS_PENDENCIAS") && !estrategia.equals("MAIOR_RISCO") && !estrategia.equals("MAIOR_DURACAO")) {
			throw new IllegalArgumentException("Valor invalido da estrategia");
		}
		this.estrategiaOrdemAtividade = estrategia;
		contaAtividade = 0;
	}

	/**
	 * Retorna o id da proxima atividade, de acordo com a estrategia de ordenacao cadastrada.
	 *
	 * @param codigoPesquisa o codigo da pesquisa que se deseja saber a proxima atividade
	 * @return a id da proxima atividade
	 */
	public String proximaAtividade(String codigoPesquisa) {
		Verificador.verificaString("Pesquisa nao pode ser nula ou vazia.", codigoPesquisa);
		if(!this.encontraPesquisa(codigoPesquisa)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		List<Atividade> atividades = pesquisas.get(codigoPesquisa).ordenaAtividades(estrategiaOrdemAtividade);
		contaAtividade ++;
		return atividades.get(contaAtividade - 1).getCodigo();
	}
}
