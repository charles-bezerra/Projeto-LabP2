package projetoLP2;

import java.util.HashMap;
import java.util.Map;

public class ControlePesquisa {
	public Map<String, Pesquisa> pesquisas;
	
	public Map<String, Integer> idPesquisas;
	
	public ControlePesquisa() {
		pesquisas = new HashMap<>();
		idPesquisas = new HashMap<>();
	}
	
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
	
	
	boolean pesquisaEhAtiva(String codigo) {
		Verificador.verificaString("Codigo nao pode ser nulo ou vazio.", codigo);
		
		if(!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		return pesquisas.get(codigo).getEstado();
	}
	
	
	public String exibePesquisa(String codigo) {
		Verificador.verificaString("Codigo nao pode ser nulo ou vazio.", codigo);
		
		if(!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		return pesquisas.get(codigo).toString();
	}
	
}
