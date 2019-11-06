package projetoLP2.controladores;

import projetoLP2.classes.Objetivo;
import projetoLP2.classes.Problema;
import projetoLP2.util.Verificador;

import java.util.HashMap;

/**
 * Classe controlodadora da classe Problema e da classe Objetivo.
 * 
 * @author Lucas Alves Vigolvino
 */
public class ControleProblemaObjetivo {
	/**
	 * Mapa de problemas, as chaves sao codigos gerados pelo programa "P" + id, a partir de 1.
	 */
	private HashMap<String, Problema> problemas = new HashMap<>();
	/**
	 * Mapa de objetivos, as chaves sao codigos gerados pelo programa "O" + id, a partir de 1.
	 */
	private HashMap<String, Objetivo> objetivos = new HashMap<>();
    /**
     * Cadastra um problema no sistema.
     * 
     * @param descricao a descricao do problema
     * @param viabilidade o valor de viabilidade do problema, numero inteiro de 1 a 5
     * @return null
     */
	public String cadastraProblema(String descricao, int viabilidade) {
		Problema problema = new Problema(descricao, viabilidade);
		problemas.put(problema.getId(), problema);
			return null;
	}
    /**
     * Cadastra um objetivo no sistema.
     * 
     * @param tipo o tipo do objetivo, GERAL ou ESPECIFICO
     * @param descricao a descricao do objetivo
     * @param aderencia o valor de aderencia do objetivo, numero inteiro de 1 a 5
     * @param viabilidade o valor de vibilidade do objetivo, numero inteiro de 1 a 5
     * @return null
     */
    public String cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
    	Objetivo objetivo = new Objetivo(tipo, descricao, aderencia, viabilidade);
    	objetivos.put(objetivo.getId(), objetivo);
    	return null;
	}
    /**
     * Apaga um problema do sistema.
     * 
     * @param codigo o codigo de identificacao do problema
     */
	public void apagarProblema(String codigo) {
		Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
		if(!problemas.containsKey(codigo)) { throw new IllegalArgumentException("Problema nao encontrado");
		} else { problemas.remove(codigo); }
	}
    /**
     * Apaga um objetivo do sistema.
     * 
     * @param codigo o codigo de identificacao do objetivo
     */
	public void apagarObjetivo(String codigo) {
		Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
		if(!objetivos.containsKey(codigo)) { throw new IllegalArgumentException("Objetivo nao encontrado");
		} else { objetivos.remove(codigo); }
	}
    /**
     * Exibe um problema cadastrado no sistema.
     * 
     * @param codigo o codigo de identificacao do problema
     * @return a representacao em String de um problema
     */
	public String exibeProblema(String codigo) {
		Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
		if(!problemas.containsKey(codigo)) { throw new IllegalArgumentException("Problema nao encontrado");
		} else { return problemas.get(codigo).toString(); }
	}
    /**
     * Exibe um objetivo cadastrado no sistema.
     * 
     * @param codigo o codigo de identificacao do objetivo
     * @return a representacao em String de um objetivo
     */
	public String exibeObjetivo(String codigo) {
		Verificador.verificaString("Campo codigo nao pode ser nulo ou vazio.", codigo);
		if(!objetivos.containsKey(codigo)) { throw new IllegalArgumentException("Objetivo nao encontrado");
		} else { return objetivos.get(codigo).toString(); }
	}
}
