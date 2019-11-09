package projetoLP2.controladores;

import projetoLP2.classes.Objetivo;
import projetoLP2.classes.Pesquisa;
import projetoLP2.classes.Problema;
import projetoLP2.comparadores.pesquisa.ComparaPorIdPesquisa;
import projetoLP2.comparadores.pesquisa.ComparaPorIdProblema;
import projetoLP2.comparadores.pesquisa.ComparaPorObjetivos;
import projetoLP2.util.Verificador;

import java.util.*;

/**
 * Controlador das pesquisas do sistema
 * @authors Iago Henrique de Souza Silva, Charles Bezerra de Oliveira Júnior
 */
public class ControlePesquisa {
	/**
	 * O mapa de pesquisas, com os codigos como chave
	 */
	private Map<String, Pesquisa> pesquisas;

	/**
	 * Constroi o Controller de pesquisas. Onde o mapa de pesquisas
	 */
	public ControlePesquisa() {
		pesquisas = new HashMap<>();
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
	 * Retorna uma pesquisa
	 *
	 * @param id endereco da pesquisa
	 * @return Pesquisa
	 */
	public Pesquisa getPesquisa(String id){
		if (!this.encontraPesquisa(id))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		return this.pesquisas.get(id);
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

	public boolean associaProblema(String idPesquisa, Problema problema) {
        Verificador.verificaString("Campo idPesquisa nao pode ser vazio ou nulo.", idPesquisa);
	    if (!this.encontraPesquisa(idPesquisa)) throw new IllegalArgumentException("Pesquisa nao encontrada.");
	    return this.pesquisas
                .get(idPesquisa)
                .associaProblema(problema);
	}

	public boolean desassociaProblema(String idPesquisa) {
        Verificador.verificaString("Campo idPesquisa nao pode ser vazio ou nulo.", idPesquisa);
        if (!this.encontraPesquisa(idPesquisa)) throw new IllegalArgumentException("Pesquisa nao encontrada.");
        return this.pesquisas
                .get(idPesquisa)
                .desassociaProblema();
	}

	public boolean associaObjetivo(String idPesquisa, Objetivo objetivo) {
        Verificador.verificaString("Campo idPesquisa nao pode ser nulo ou vazio.", idPesquisa);
        if (!this.encontraPesquisa(idPesquisa)) throw new IllegalArgumentException("Pesquisa nao encontrada.");
        return this.pesquisas
                .get(idPesquisa)
                .associaObjetivo(objetivo);
	}

	public boolean desassociaObjetivo(String idPesquisa, String idObjetivo){
        Verificador.verificaString("Campo idObjetivo nao pode ser nulo ou vazio", idPesquisa);
        if (!this.encontraPesquisa(idPesquisa)) throw new IllegalArgumentException("Pesquisa nao encontrada.");
        return this.pesquisas
                .get(idPesquisa)
                .desassociaObjetivo(idObjetivo);
    }

	public String listaPesquisas(String ordem) {
		List<Pesquisa> pesquisas = new ArrayList<>( this.pesquisas.values() );
		switch (ordem.toUpperCase()){
			case "PROBLEMA":{ pesquisas.sort(new ComparaPorIdProblema()); break;}
			case "OBJETIVO":{ pesquisas.sort(new ComparaPorObjetivos()); break;}
			case "PESQUISA":{ pesquisas.sort(new ComparaPorIdPesquisa()); break;}
			default: throw new IllegalArgumentException("Valor invalido da ordem");
		}

		Iterator<Pesquisa> pesquisaIterator = pesquisas.iterator();
		StringBuilder resultado = new StringBuilder("");

		while (pesquisaIterator.hasNext()){
			resultado.append( pesquisaIterator.next().toString() );
			if (pesquisaIterator.hasNext())
				resultado.append(" | ");
		}

		return resultado.toString();
	}

}
