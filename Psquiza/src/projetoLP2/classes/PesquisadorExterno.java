package projetoLP2.classes;

import projetoLP2.util.Verificador;

public class PesquisadorExterno extends Pesquisador {

    /**
     * Constroi os atributos nome, biografia, email, fotoURL, funcao e ativado.
     *
     * @param nome      passa o valor contido nele para o atributo nome.
     * @param funcao    passa o valor contido nele para o atributo funcao.
     * @param biografia passa o valor contido nele para o atributo biografia.
     * @param email     passa o valor contido nele para o atributo email.
     * @param fotoURL   passa o valor contido nele para o atributo fotoURL.
     */
    public PesquisadorExterno(String nome, String funcao, String biografia, String email, String fotoURL) {
        super(nome, funcao, biografia, email, fotoURL);
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
            default:
                throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
        }
    }

}
