package projetoLP2.classes;

import projetoLP2.Interfaces.Funcao;
import projetoLP2.enums.TipoFuncao;

public class Aluno implements Funcao {
    private TipoFuncao nome;
    private int semestre;
    private float IEA;

    public Aluno(){
        nome = TipoFuncao.ESTUDANTE;
        semestre = -1;
        IEA = -1;
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
        if(semestre == -1 || IEA == -1){
            return "";
        }
        return String.format(" - %do SEMESTRE - %s",
                semestre,String.format("%.1f",IEA).replace(",","."));
    }
}
