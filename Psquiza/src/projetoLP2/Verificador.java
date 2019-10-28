package projetoLP2;

/**	
* Classe utilitaria usada para verificar se valores sao iguais a nulos ou vazios 
* e lancar suas reespectivas excecoes
*	
* @author Iago Henrique de Souza Silva	
*/
public class Verificador {
	/**
	* Verifica se uma String eh nula ou vazia e, caso seja, lanca uma excecao do tipo
	* IllegalArgumentException
	*
	* @param msg a mensagem a ser exibida na excecao
	* @param valor o valor a ser verificado
	*/
	public static void verificaString(String msg, String valor) {
		if(valor == null || valor.trim().isEmpty()) {
			throw new IllegalArgumentException(msg);
		}
	}
}