package projetoLP2.classes;

import projetoLP2.util.Verificador;

public class PesquisadorAluno extends Pesquisador {
    private int semestre;
    private float IEA;

    /**
     * Constroi os atributos nome, biografia, email, fotoURL, funcao e ativado.
     *
     * @param nome      passa o valor contido nele para o atributo nome.
     * @param funcao    passa o valor contido nele para o atributo funcao.
     * @param biografia passa o valor contido nele para o atributo biografia.
     * @param email     passa o valor contido nele para o atributo email.
     * @param fotoURL   passa o valor contido nele para o atributo fotoURL.
     */
    public PesquisadorAluno(String nome, String funcao, String biografia, String email, String fotoURL) {
        super(nome, funcao, biografia, email, fotoURL);
        semestre = 1;
        IEA = 0;
    }


    public void alteraAtributo(String atributo, String novoValor) {
        Verificador.verificaString("Campo atributo nao pode ser nulo ou vazio.", atributo);
        Verificador.verificaString("Campo " + atributo + " nao pode ser nulo ou vazio.", novoValor);

        if(!isAtivado()){
            throw new IllegalArgumentException("Pesquisador inativo.");
        }

        switch (atributo.toUpperCase()) {
            case "EMAIL":
                verificaEmail(novoValor);
                setEmail(novoValor);
                break;
            case "FOTOURL":
                verificaFoto(novoValor);
                setFotoURL(novoValor);
                break;
            case "NOME":
                setNome(novoValor);
                break;
            case "BIOGRAFIA":
                setBiografia(novoValor);
                break;
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

    private int getSemestre(){
        return semestre;
    }

    private void setSemestre(int semestre){
        this.semestre = semestre;
    }


    private float getIEA(){
        return IEA;
    }

    private void setIEA(float IEA){
        this.IEA = IEA;
    }


    @Override
    public String toString() {
        if(!isAtivado()) {
            throw new IllegalArgumentException("Pesquisador inativo.");
        }

        if(especializado){
            return super.toString() + String.format(" - %do SEMESTRE - %.1f",
                    getSemestre(),getIEA());
        }
        return super.toString();
    }
}
