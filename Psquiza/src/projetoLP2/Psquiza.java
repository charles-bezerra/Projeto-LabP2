package projetoLP2;

import easyaccept.EasyAccept;

public class Psquiza {
	/**
	 * Classe controlodadora da classe Problema e da classe Objetivo.
	 */
	ControleProblemaObjetivo problemaObjetivo = new ControleProblemaObjetivo();
    public static void main(String[] args){
    	args = new String[] {"projetoLP2.Psquiza", "aceitacao_teste/use_case_1.txt", "aceitacao_teste/use_case_2.txt", "aceitacao_teste/use_case_3.txt", "aceitacao_teste/use_case_4.txt"};
		EasyAccept.main(args);
    }
    /**
     * Cadastra um problema no sistema.
     * 
     * @param descricao a descricao do problema
     * @param viabilidade o valor de viabilidade do problema, numero inteiro de 1 a 5
     * @return null
     */
    public String cadastraProblema(String descricao, int viabilidade) {
		return problemaObjetivo.cadastraProblema(descricao, viabilidade);
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
		return problemaObjetivo.cadastraObjetivo(tipo, descricao, aderencia, viabilidade);
	}
    /**
     * Apaga um problema do sistema.
     * 
     * @param codigo o codigo de identificacao do problema
     */
    public void apagarProblema(String codigo) {
		problemaObjetivo.apagarProblema(codigo);
	}
    /**
     * Apaga um objetivo do sistema.
     * 
     * @param codigo o codigo de identificacao do objetivo
     */
    public void apagarObjetivo(String codigo) {
		problemaObjetivo.apagarObjetivo(codigo);
	}
    /**
     * Exibe um problema cadastrado no sistema.
     * 
     * @param codigo o codigo de identificacao do problema
     * @return o codigo de identificacao do problema + a representacao em String de um problema
     */
    public String exibeProblema(String codigo) {
		return problemaObjetivo.exibeProblema(codigo);
	}
    /**
     * Exibe um objetivo cadastrado no sistema.
     * 
     * @param codigo o codigo de identificacao do objetivo
     * @return o codigo de identificacao do objetivo + a representacao em String de um objetivo
     */
    public String exibeObjetivo(String codigo) {
		return problemaObjetivo.exibeObjetivo(codigo);
	}
}