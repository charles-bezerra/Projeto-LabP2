package projetoLP2.Interfaces;

import projetoLP2.excessoes.PesistenciaException;

/**
 * Interface que padroniza metodos que devem ser adicionado em um
 * Controle que pesiste as entidades gravadas nesse crud
 *
 * @author Charles Bezerra de Oliveira Júnior
 */
public interface ControlePesistivel {
    /**
     * Metodo de salvar
     * @throws PesistenciaException
     */
    void salva() throws PesistenciaException;

    /**
     * Metodo para carregars
     * @throws PesistenciaException
     */
    void carrega() throws PesistenciaException;
}
