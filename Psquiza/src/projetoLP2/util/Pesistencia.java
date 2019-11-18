package projetoLP2.util;

import projetoLP2.excessoes.PesistenciaException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @param <Objeto>
 */

public class Pesistencia <ID, Objeto> {
    private String diretorio, entidade;

    public Pesistencia(String diretorio, String entidade){
        this.diretorio = Verificador
                .verificaString("Campo diretorio nao pode ser vazio ou nulo.", diretorio);
        this.entidade = Verificador
                .verificaString("Campo entidade nao pode ser vazio ou nulo.", entidade);
    }

    public void salvar(Map<ID, Objeto> objetos) throws PesistenciaException {
        FileOutputStream arquivoSaida = null;

        try {
            arquivoSaida = new FileOutputStream(this.diretorio + File.separator + this.entidade + ".ser");
            @SuppressWarnings("resource")
            ObjectOutputStream oos = new ObjectOutputStream(arquivoSaida);
            oos.writeObject(objetos);
        }

        catch (IOException e){
            throw new PesistenciaException(e);
        }

        finally {
            if ( arquivoSaida != null){
                try{ arquivoSaida.close(); }
                catch (IOException e){ throw new PesistenciaException(e); }
            }
        }
    }

    public void carregar(Map<ID, Objeto> objetos) throws PesistenciaException{
        FileInputStream arquivoEntrada;
        try {
            arquivoEntrada = new FileInputStream(this.diretorio + File.separator + this.entidade + ".ser");
            @SuppressWarnings("resource")
            ObjectInputStream ois = new ObjectInputStream(arquivoEntrada);
            objetos = (Map<ID, Objeto>) ois.readObject();
        }catch (Exception e){
            throw new PesistenciaException(e);
        }
    }
}
