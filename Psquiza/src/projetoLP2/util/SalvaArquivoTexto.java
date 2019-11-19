package projetoLP2.util;

import projetoLP2.classes.*;

import java.io.*;

public class SalvaArquivoTexto {

    public void gravarResultados(Pesquisa pesquisa) {

        try {
            File file = new File(pesquisa.getCod() + "-Resultados.txt");
            FileWriter writer = new FileWriter(file, false);
            writer.write(pesquisa.retornaDadosResultados());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void gravarResumo(Pesquisa pesquisa) {

        try {

            File file = new File("_" + pesquisa.getCod() + ".txt");
            FileWriter writer = new FileWriter(file, false);
            writer.write(pesquisa.retornaDadosResumo());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
