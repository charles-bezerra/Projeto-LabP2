package projetoLP2.util;

import projetoLP2.classes.*;

import java.io.*;

/**
 * Classe responsavel por salvar os arquivos txt;
 * @author Melquisedeque Carvalho Silva
 */
public class SalvaArquivoTexto {
    /**
     * Metodo resposanvel por salvar o arquivo txt no formato resultado, solicitado
     * @param pesquisa a pesquisa que ira ceder os dados a serem salvos no arquivo txt
     * @throws IOException excecao caso haja falha ao gravar arquivo.
     */
    public void gravarResultados(Pesquisa pesquisa) throws IOException {
        String nomeArquivo = pesquisa.getCod() + "-Resultados.txt";
        String dadosDoTxt = pesquisa.retornaDadosResultados();


    }

    /**
     * Metodo resposanvel por salvar o arquivo txt no formato resumo, solicitado
     * @param pesquisa a pesquisa que ira ceder os dados a serem salvos no arquivo txt
     * @throws IOException excecao caso haja falha ao gravar arquivo.
     */
    public void gravarResumo(Pesquisa pesquisa) throws IOException {
        String nomeArquivo = "_" + pesquisa.getCod() + ".txt";
        String dadosDoTxt = pesquisa.retornaDadosResumo();
        gravar(nomeArquivo, dadosDoTxt);
    }

    /**
     *
     * @param nomeArquivo o nome que sera dado ao arquivo
     * @param dadosDoTxt String com o resumo ou o resultado, que sera salvo no arquivo txt.
     * @throws IOException excecao caso haja falha ao gravar arquivo.
     */
    private void gravar(String nomeArquivo, String dadosDoTxt) throws IOException {
        File file = null;
        FileWriter writer = null;
        try {

            file = new File(nomeArquivo);
            writer = new FileWriter(file, false);
            writer.write(dadosDoTxt);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
