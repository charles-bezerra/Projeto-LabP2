package projetoLP2.Interfaces;

import projetoLP2.excessoes.PesistenciaException;

import java.util.Map;

/**
 * Interface que padroniza metodos que devem ser adicionado em um
 * Controle que pesiste as entidades gravadas nesse crud
 *
 * @author Charles Bezerra de Oliveira Júnior
 */
public interface ControlePesistivel {
    public void salva() throws PesistenciaException;
    public void carrega() throws PesistenciaException;
}
