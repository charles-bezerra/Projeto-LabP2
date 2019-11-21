package projetoLP2.util;

import projetoLP2.excessoes.PesistenciaException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe util responsavel por pesistir objetos de um mapa de um controle.
 *
 * @author Charles Bezerra de Oliveira Júnior
 */
public class Pesistencia {
    /**
     * Endereco do arquivo que guarda a pesistencia do sistema
     */
    private String banco;
    /**
     * Objeto responsavel por processar os objetos sistema para serem pesistidos
     */
    private FileOutputStream arquivoSaida = null;
    /**
     * Objetos que devem ser pesistidos seguidos de sua ordem de insercao
     */
    private ArrayList<Object> objetos;

    /**
     * Constroi uma pesistencia com um arquivo de banco padrao
     */
    public Pesistencia(){
        this.banco = "banco/dados.ser";
        this.objetos = new ArrayList<>();
        this.criaArquivo();
    }

    /**
     * Cria o diretorio se nao existir
     */
    private void criaArquivo(){
        File arquivo = new File(this.banco);
        if (!arquivo.exists())
            new File("banco/").mkdir();
    }

    /**
     * Estabelece um stream com o arquivo que guarda a pesistencia do sistema
     * @throws PesistenciaException
     */
    public void conectar() throws PesistenciaException{
        this.objetos.clear();
        try { arquivoSaida = new FileOutputStream(this.banco); }
        catch (IOException e){ throw new PesistenciaException(e); }
    }

    /**
     * Adiciona um objeto na lista que seram pesistida posteriormente
     *
     *  @param objeto a ser inserido na lista da pesistencia
     */
    public void insere(Object objeto) {
        if (objeto == null) return;
        this.objetos.add(objeto);
    }

    /**
     * Pesiste a lista de objetos adicionados ate o momento
     *
     * @throws PesistenciaException
     */
    public void salva() throws PesistenciaException {
        try {
            @SuppressWarnings("resource")
            ObjectOutputStream oos = new ObjectOutputStream(arquivoSaida);
            oos.writeObject(this.objetos);
            this.objetos.clear();
        }
        catch (IOException e){
            throw new PesistenciaException(e); }
    }

    /**
     * Encerra o stream com o arquivo de pesistencia
     *
     * @throws PesistenciaException
     */
    public void fecha() throws PesistenciaException{
        this.objetos.clear();
        if ( arquivoSaida != null){
            try{
                arquivoSaida.close();
            }
            catch (IOException e){
                throw new PesistenciaException(e);
            }
        }
    }

    /**
     * Retorna uma lista de objetos em ordem de insercao
     *
     * @return lista de objetos
     * @throws PesistenciaException
     */
    public List<Object> carrega() throws PesistenciaException {
        FileInputStream arquivoEntrada;
        try {
            arquivoEntrada = new FileInputStream(this.banco);
            @SuppressWarnings("resource")
            ObjectInputStream ois = new ObjectInputStream(arquivoEntrada);
            return (ArrayList<Object>) ois.readObject();
        }
        catch (Exception e){
            throw new PesistenciaException(e);
        }
    }
}
