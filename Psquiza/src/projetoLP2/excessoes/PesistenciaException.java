package projetoLP2.excessoes;

public class PesistenciaException extends Exception {
    public PesistenciaException(Exception e){
        super(e);
    }
}
