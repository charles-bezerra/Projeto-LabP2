package projetoLP2.controladores;

import projetoLP2.classes.Pesquisa;
import projetoLP2.util.Verificador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * Controlador das pesquisas do sistema
 * @author Iago Henrique de Souza Silva
 */
public class ControlePesquisa {
	/**
	 * O mapa de clientes, com os codigos como chave
	 */
	private Map<String, Pesquisa> pesquisas;

	/**
	 * Constroi o Controller de pesquisas. Onde o mapa de pesquisas
	 * e o mapa de codigos eh incializado
	 */
	public ControlePesquisa() {
		pesquisas = new HashMap<>();
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

		if(!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}

		switch (conteudoASerAlterado) {
			case "DESCRICAO":
				pesquisas.get(codigo).setDescricao(novoConteudo);
				break;
			case "CAMPO":
				pesquisas.get(codigo).setCampoDeInteresse(novoConteudo);
				break;
			default:
				throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
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
		
		if(!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}

		pesquisas.get(codigo).encerraPesquisa(motivo);
	}


	/**
	 * Altera o estado de uma pesquisa para ATIVA
	 *
	 * @param codigo o codigo da pesquisa a ser ativada
	 */
	public void ativaPesquisa(String codigo) {	
		Verificador.verificaString("Codigo nao pode ser nulo ou vazio.", codigo);
		
		if(!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		
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
		
		if(!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}

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
		
		if(!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		return pesquisas.get(codigo).toString();
	}


	public Map<String,Pesquisa> getPesquisas(){
		return pesquisas;
	}

	/**
	 * Metodo responsavel por
	 * @param termo o termo a ser buscado
	 * @return
	 */
	public ArrayList<String> ordenaPesquisa(String termo){
		ArrayList<Pesquisa> buscasOrdenadas = new ArrayList<Pesquisa>(pesquisas.values());
		Collections.sort(buscasOrdenadas);
		ArrayList<String> retorno = new ArrayList<>();

		for (Pesquisa pesquisa: buscasOrdenadas){
			if (pesquisa.getDescricao().toLowerCase().contains(termo.toLowerCase())) {
				retorno.add(pesquisa.getCod() + ": " + pesquisa.getDescricao());


			}
			if(pesquisa.getCampoDeInteresse().toLowerCase().contains(termo.toLowerCase())){
                retorno.add(pesquisa.getCod() + ": " + pesquisa.getCampoDeInteresse());

			}

		}

		return retorno;
	}


}
