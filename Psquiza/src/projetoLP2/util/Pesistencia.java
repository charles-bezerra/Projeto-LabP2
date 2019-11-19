package projetoLP2.util;

import projetoLP2.excessoes.PesistenciaException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe util responsavel por pesistir objetos de um mapa de um controle.
 * @param <Chave> tipo chave do mapa pesistido
 * @param <Objeto> tipo do valor do objeto do mapa pesistido
 * @author Charles Bezerra de Oliveira Júnior
 */

public class Pesistencia <Chave, Objeto> {
    private String diretorio, entidade;

    public Pesistencia(String diretorio, String entidade){
        this.diretorio = Verificador
                .verificaString("Campo diretorio nao pode ser vazio ou nulo.", diretorio);
        this.entidade = Verificador
                .verificaString("Campo entidade nao pode ser vazio ou nulo.", entidade);
    }

    public void salva(Map<Chave, Objeto> objetos) throws PesistenciaException {
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

    public void carrega(Map<Chave, Objeto> objetos) throws PesistenciaException {
        FileInputStream arquivoEntrada;
        try {
            arquivoEntrada = new FileInputStream(this.diretorio + File.separator + this.entidade + ".ser");
            @SuppressWarnings("resource")
            ObjectInputStream ois = new ObjectInputStream(arquivoEntrada);
            Map<Chave, Objeto> objetosCarregados = (HashMap<Chave, Objeto>) ois.readObject();
            objetos.clear();
            objetos.putAll( objetosCarregados );
        }
        catch (Exception e){
            throw new PesistenciaException(e);
        }
    }
}
