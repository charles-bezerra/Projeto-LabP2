package projetoLP2.util;

import projetoLP2.excessoes.PesistenciaException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe util responsavel por pesistir objetos de um mapa de um controle.
 *
 * @author Charles Bezerra de Oliveira Júnior
 */

public class Pesistencia {
    private String diretorio;
    private FileOutputStream arquivoSaida = null;

    public Pesistencia(String diretorio){
        this.diretorio = Verificador
                .verificaString("Campo diretorio nao pode ser vazio ou nulo.", diretorio);
    }

    public void conectar() throws PesistenciaException{
        try {
            arquivoSaida = new FileOutputStream(this.diretorio + ".ser");
        }catch (IOException e){
            throw new PesistenciaException(e);
        }
    }

    public void inseri(Object objetos) throws PesistenciaException {
        try {
            @SuppressWarnings("resource")
            ObjectOutputStream oos = new ObjectOutputStream(arquivoSaida);
            oos.writeObject(objetos);
        }
        catch (IOException e){
            throw new PesistenciaException(e);
        }
    }

    public void fechar() throws PesistenciaException{
        if ( arquivoSaida != null){
            try{ arquivoSaida.close(); }
            catch (IOException e){ throw new PesistenciaException(e); }
        }
    }

    public List<Object> carrega() throws PesistenciaException {
        FileInputStream arquivoEntrada;
        try {
            arquivoEntrada = new FileInputStream(this.diretorio + ".ser");
            @SuppressWarnings("resource")
            ObjectInputStream ois = new ObjectInputStream(arquivoEntrada);
            return (ArrayList<Object>) ois.readObject();
        }
        catch (Exception e){
            throw new PesistenciaException(e);
        }
    }
}
