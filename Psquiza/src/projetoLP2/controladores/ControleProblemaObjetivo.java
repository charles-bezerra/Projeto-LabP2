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
	 * Mapa de problemas, as chaves sao codigos gerados pelo programa "P" + id, a partiir de 1.
	 */
	private HashMap<String, Problema> problemas = new HashMap<>();
	/**
	 * Mapa de objetivos, as chaves sao codigos gerados pelo programa "O" + id, a partiir de 1.
	 */
	private HashMap<String, Objetivo> objetivos = new HashMap<>();
	/**
	 * O id dos problemas, gerado a partir de um.
	 */
	private int idProblemas = 1;
	/**
	 * O id dos objetivos, gerado a partir de um.
	 */
	private int idObjetivos = 1;
    /**
     * Cadastra um problema no sistema.
     * 
     * @param descricao a descricao do problema
     * @param viabilidade o valor de viabilidade do problema, numero inteiro de 1 a 5
     * @return null
     */
	public String cadastraProblema(String descricao, int viabilidade) {
		Verificador.verificaString("Campo descricao nao pode ser nulo ou vazio.", descricao);
		if(1 > viabilidade || viabilidade > 5) {
			throw new IllegalArgumentException("Valor invalido de viabilidade.");
		} else {
			problemas.put("P" + idProblemas, new Problema(descricao, viabilidade));
			idProblemas ++;
			return null;
		}
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
    	Verificador.verificaString("Campo tipo nao pode ser nulo ou vazio.", tipo);
    	Verificador.verificaString("Campo descricao nao pode ser nulo ou vazio.", descricao);
		if(!tipo.equals("GERAL") && !tipo.equals("ESPECIFICO")) {
			throw new IllegalArgumentException("Valor invalido de tipo.");
		} else if(1 > aderencia || aderencia > 5) {
			throw new IllegalArgumentException("Valor invalido de aderencia");
		} else if(1 > viabilidade || viabilidade > 5) {
			throw new IllegalArgumentException("Valor invalido de viabilidade.");
		} else {
			objetivos.put("O" + idObjetivos, new Objetivo(tipo, descricao, aderencia, viabilidade));
			idObjetivos ++;
			return null;
		}
	}
    /**
     * Apaga um problema do sistema.
     * 
     * @param codigo o codigo de identificacao do problema
     */
	public void apagarProblema(String codigo) {
		Verificador.verificaString("Campo descricao nao pode ser nulo ou vazio.", codigo);
		if(!problemas.containsKey(codigo)) {
			throw new IllegalArgumentException("Problema nao encontrado");
		} else {
			problemas.remove(codigo);
		}
	}
    /**
     * Apaga um objetivo do sistema.
     * 
     * @param codigo o codigo de identificacao do objetivo
     */
	public void apagarObjetivo(String codigo) {
		Verificador.verificaString("Campo descricao nao pode ser nulo ou vazio.", codigo);
		if(!objetivos.containsKey(codigo)) {
			throw new IllegalArgumentException("Objetivo nao encontrado");
		} else {
			objetivos.remove(codigo);
		}
	}
    /**
     * Exibe um problema cadastrado no sistema.
     * 
     * @param codigo o codigo de identificacao do problema
     * @return o codigo de identificacao do problema + a representacao em String de um problema
     */
	public String exibeProblema(String codigo) {
		Verificador.verificaString("Campo descricao nao pode ser nulo ou vazio.", codigo);
		if(!problemas.containsKey(codigo)) {
			throw new IllegalArgumentException("Problema nao encontrado");
		} else {
			return codigo + " - " + problemas.get(codigo).toString();
		}
	}
    /**
     * Exibe um objetivo cadastrado no sistema.
     * 
     * @param codigo o codigo de identificacao do objetivo
     * @return o codigo de identificacao do objetivo + a representacao em String de um objetivo
     */
	public String exibeObjetivo(String codigo) {
		Verificador.verificaString("Campo descricao nao pode ser nulo ou vazio.", codigo);
		if(!objetivos.containsKey(codigo)) {
			throw new IllegalArgumentException("Objetivo nao encontrado");
		} else {
			return codigo + " - " + objetivos.get(codigo).toString();
		}
	}
}