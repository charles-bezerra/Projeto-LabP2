package projetoLP2.util;

import projetoLP2.excessoes.PesistenciaException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @param <Objeto>
 */

public class Pesistencia <Objeto> {
    private String diretorio;

    public Pesistencia(String diretorio){
        this.diretorio = Verificador.verificaString("Campo diretorio nao pode ser vazio ou nulo", diretorio);
    }

    public void salvar(List<Objeto> objetos) throws PesistenciaException {
        FileOutputStream arquivoSaida = null;
        try {
            arquivoSaida = new FileOutputStream(this.diretorio + File.separator + Objeto.getNameClass());

            @SuppressWarnings("resource")
            ObjectOutputStream oos = new ObjectOutputStream(arquivoSaida);

            for (Objeto obj: objetos)
                oos.writeObject(obj);
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

    public void carregar(){

    }
}
