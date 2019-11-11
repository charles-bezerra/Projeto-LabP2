package projetoLP2.classes;

/**
 * Classe responsavel por representar a associacao entre
 * um pesquisador e uma pesquisa.
 * @author Iago Henrique de Souza Silva
 */
public class AssociacaoPesquisaPesquisador {
    /**
     * Representa o controle do ultimo id adicionado a uma associacao
     */
    private static int idControle = 0;
    /**
     * O id da associacao
     */
    private int id;
    /**
     * O id da pesquisa associada.
     */
    private String idPesquisa;
    /**
     * O email do pesquisador associado.
     */
    private String emailPesquisador;


    /**
     * Constroi uma associacao a partir do id da pesquisa e do email do pesquisador.
     * @param idPesquisa O id da pesquisa associada.
     * @param emailPesquisador O email do pesquisador associado.
     */
    public AssociacaoPesquisaPesquisador(String idPesquisa,String emailPesquisador){
        id = geraID();
        this.idPesquisa = idPesquisa;
        this.emailPesquisador = emailPesquisador;
    }


    /**
     * Gera um novo id e o retorna
     */
    private int geraID(){ return idControle++; }


    /**
     * Metodo responsavel por retornar o id da associacao.
     * @return O id da associacao.
     */
    public int getID(){return id;}

    /**
     * Metodo responsavel por retornar o idPesquisa da associacao.
     * @return O idPesquisa da associacao.
     */
    public String getIdPesquisa(){return idPesquisa;}

    /**
     * Metodo responsavel por retornar o emailPesquisador da associacao.
     * @return O emailPesquisador da associacao.
     */
    public String getEmailPesquisador(){return emailPesquisador;}
}
