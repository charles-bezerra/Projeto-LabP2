package projetoLP2.classes;

import projetoLP2.util.Verificador;

public class AssociacaoPesquisaPesquisador {
    private static int idControle = 1;
    private int id;
    private String idPesquisa;
    private String emailPesquisador;

    public AssociacaoPesquisaPesquisador(String idPesquisa,String emailPesquisador){
        id = geraID();
        this.idPesquisa = idPesquisa;
        this.emailPesquisador = emailPesquisador;
    }


    private int geraID(){ return idControle++ -1; }

    public int getID(){return id;}

    public String getIdPesquisa(){return idPesquisa;}

    public String getEmailPesquisador(){return emailPesquisador;}
}
