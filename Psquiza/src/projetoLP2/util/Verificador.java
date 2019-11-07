package projetoLP2.util;

/**
 * Classe utilitaria usada para verificar se valores sao validos
 * e lancar suas reespectivas excecoes
 *
 * @authors Iago Henrique de Souza Silva, Melquisedeque Carvalho Silva;
 */
public class Verificador {
	/**
	 * Verifica se uma String eh nula ou vazia e, caso seja, lanca uma excecao do tipo
	 * IllegalArgumentException
	 *
	 * @param msg a mensagem a ser exibida na excecao
	 * @param valor o valor a ser verificado
	 * @return valor com a verificacao concluida
	 */
	public static String verificaString(String msg, String valor) {
		if(valor == null || valor.trim().isEmpty())
			throw new IllegalArgumentException(msg);
		return valor;
	}

	/**
	 *
	 * @param msg a mensagem a ser exibida na excecao.
	 * @param valor valor o valor a ser verificado.
	 * @return valor com a verificacao concluida.
	 */
	public static int verificaInteiro(String msg, int valor) {
		if(valor <= 0)
			throw new IllegalArgumentException(msg);
		return valor;
	}


	/**
	 * Verifica se uma String eh valida no formato de data (DD/MM/AAAA) e,
	 * caso nao seja, lanca uma excecao do tipo
	 * IllegalArgumentException
	 *
	 * @param msg a mensagem a ser exibida na excecao
	 * @param data a string a ser verificada
	 * @return valor com a verificacao concluida
	 */
	public static void verificaData(String msg, String data) {
		if(data.split("/")[0].length() != 2) {
			throw new IllegalArgumentException(msg);
		}
		int dia = Integer.parseInt(data.split("/")[0]);
		if( dia > 30 || dia < 1) {
			throw new IllegalArgumentException(msg);
		}

		if(data.split("/")[1].length() != 2) {
			throw new IllegalArgumentException(msg);
		}
		int mes = Integer.parseInt(data.split("/")[1]);
		if( mes > 12 || mes < 1) {
			throw new IllegalArgumentException(msg);
		}

		if(data.split("/")[2].length() != 4) {
			throw new IllegalArgumentException(msg);
		}
		int ano = Integer.parseInt(data.split("/")[2]);
		if( ano > 2019 || ano < 1) {
			throw new IllegalArgumentException(msg);
		}
	}
}