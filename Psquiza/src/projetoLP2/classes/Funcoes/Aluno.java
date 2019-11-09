package projetoLP2.classes.Funcoes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;
import projetoLP2.util.Verificador;

public class Aluno implements Funcao {
    private TipoFuncao nome;
    private int semestre;
    private float IEA;

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

    @Override
    public void alteraEspecialidade(String atributo, String novoValor) {
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
                throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
        }
    }

    private void setSemestre(int semestre){
        this.semestre = semestre;
    }

    private void setIEA(float IEA){
        this.IEA = IEA;
    }

    @Override
    public String getNome() {
        return nome.getFuncao();
    }


    @Override
    public String toString() {
        return String.format(" - %do SEMESTRE - %s",
                semestre,String.format("%.1f",IEA).replace(",","."));
    }
}
