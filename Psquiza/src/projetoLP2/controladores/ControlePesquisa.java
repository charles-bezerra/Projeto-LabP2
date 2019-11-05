package projetoLP2.controladores;

import projetoLP2.classes.Pesquisa;
import projetoLP2.util.Verificador;

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
	 * O mapa de codigos das pesquisas e o numero de vezes em que cada um foi usado.
	 * A chave representa uma combinacao de tres letras e o valor o numero de vezes em
	 * que aquela combinacao foi usada iniciando em 1
	 */
	private Map<String, Integer> idPesquisas;


	/**
	 * Constroi o Controller de pesquisas. Onde o mapa de pesquisas
	 * e o mapa de codigos eh incializado
	 */
	public ControlePesquisa() {
		pesquisas = new HashMap<>();
		idPesquisas = new HashMap<>();
	}


	/**
	 * Verifica se uma string se enquadra nos padroes do campo
	 * de interesse de uma pesquisa.
	 * Podendo ter até 4 topicos, separados por virgula
	 * e ter até 255 caracteres
	 *
	 * @return retorna se a string eh valida ou nao
	 */
	private boolean verificaCampo(String campo) {
		String[] topicos = campo.split(",");
		if(campo.length() > 255 || topicos.length > 4) {
			return false;
		}
		
		for(String topico : topicos) {
			if (topico.length() < 3 || topico.trim().isEmpty()) {
				return false;
			}
		}	
		return true;
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
		}else {
			idPesquisas.put(cod, 1);
		}	
		return cod + idPesquisas.get(cod);
	}


	/**
	 * Cadastra uma pesquisa no mapa de pesquisas.
	 *
	 * @param descricao a descricao do objetivo
	 * @param campoDeInteresse o campo de interesse da pesquisa
	 * @return o codigo gerado para esta pesquisa
	 */
	public String cadastraPesquisa(String descricao, String campoDeInteresse) {
		Verificador.verificaString("Descricao nao pode ser nula ou vazia.", descricao);
		Verificador.verificaString("Formato do campo de interesse invalido.", campoDeInteresse);
		
		
		if(!verificaCampo(campoDeInteresse)) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		
		String cod = geraCodigo(campoDeInteresse);
		Pesquisa p = new Pesquisa(descricao, campoDeInteresse, cod);
		pesquisas.put(cod, p);
		return cod;
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
		
		if(!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		if(!pesquisaEhAtiva(codigo)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		
		switch (conteudoASerAlterado) {
			case "DESCRICAO":
				Verificador.verificaString("Descricao nao pode ser nula ou vazia.", novoConteudo);
				
				pesquisas.get(codigo).setDescricao(novoConteudo);
				break;
			case "CAMPO":
				if(!verificaCampo(novoConteudo)) {
					throw new IllegalArgumentException("Formato do campo de interesse invalido.");
				}
				
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
		if(!pesquisaEhAtiva(codigo)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
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
		if(pesquisaEhAtiva(codigo)) {
			throw new IllegalArgumentException("Pesquisa ja ativada.");
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
	
}
