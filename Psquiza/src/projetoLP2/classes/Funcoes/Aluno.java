package projetoLP2.classes.Funcoes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;
import projetoLP2.util.Verificador;
/**
 * Representa a escialidade Aluno de um pesquisador.
 * Contendo as características da função 'Estudante'
 * de um pesquisador.
 * @author Iago Henrique de Souza Silva
 */
public class Aluno implements Funcao {
    /**
     * O nome da função, contante como 'ESTUDANTE'
     */
    private TipoFuncao nome;
    /**
     * O semestre em que o estudante esta
     */
    private int semestre;
    /**
     * O IEA do estudante
     */
    private float IEA;


    /**
     * Constroi as características do aluno.
     * @param semestre O semestre em que o estudante esta
     * @param IEA O IEA do estudante
     */
    public Aluno(String semestre, String IEA){
        Verificador.verificaString("Campo semestre nao pode ser nulo ou vazio.", semestre);
        Verificador.verificaString("Campo IEA nao pode ser nulo ou vazio.", IEA);

        if(Integer.parseInt(semestre) < 1){
            throw new IllegalArgumentException("Atributo semestre com formato invalido.");
        }

        if(Float.parseFloat(IEA) < 0.0 || Float.parseFloat(IEA) > 10.0){
            throw new IllegalArgumentException("Atributo IEA com formato invalido.");
        }

        nome = TipoFuncao.ESTUDANTE;
        this.semestre = Integer.parseInt(semestre);
        this.IEA = Float.parseFloat(IEA);
    }


    /**
     * Metodo responsavel por alterar um atributo do aluno
     * @param atributo representa o atributo que determinado aluno quer alterar.
     * @param novoValor representa o novo valor para o atributo desejado.
     */
    @Override
    public void alteraEspecialidade(String atributo, String novoValor) {
        Verificador.verificaString("Campo " + atributo.toLowerCase() + " nao pode ser nulo ou vazio.", novoValor);
        switch (atributo.toUpperCase()) {
            case "SEMESTRE":
                if(Integer.parseInt(novoValor) < 1){
                    throw new IllegalArgumentException("Atributo semestre com formato invalido.");
                }
                setSemestre(Integer.parseInt(novoValor));
                break;
            case "IEA":
                if(Double.parseDouble(novoValor) < 0.0 || Double.parseDouble(novoValor) > 10.0){
                    throw new IllegalArgumentException("Atributo IEA com formato invalido.");
                }
                setIEA(Float.parseFloat(novoValor));
                break;
            default:
                throw new IllegalArgumentException("Atributo invalido.");
        }
    }

    /**
     * Troca o semestre atual do aluno por um novo semestre
     * @param semestre o novo semestre
     */
    private void setSemestre(int semestre){
        this.semestre = semestre;
    }

    /**
     * Troca o IEA atual do aluno por um novo IEA
     * @param IEA o novo IEA
     */
    private void setIEA(float IEA){
        this.IEA = IEA;
    }


    /**
     * Captura o nome desta especialidade e o retorna.
     * @return o nome desta especialidade.
     */
    @Override
    public String getNome() {
        return nome.getFuncao();
    }


    /**
     * Retorna a representacao textual da funcao aluno
     * @return a represetacao textual no formato " - 'semestre'o  SEMESTRE - 'IEA'".
     */
    @Override
    public String toString() {
        return String.format(" - %do SEMESTRE - %s",
                semestre,String.format("%.1f",IEA).replace(",","."));
    }
}
