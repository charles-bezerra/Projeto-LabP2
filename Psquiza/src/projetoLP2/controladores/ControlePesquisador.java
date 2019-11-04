package projetoLP2.controladores;

import projetoLP2.classes.Pesquisador;
import projetoLP2.util.Verificador;

import java.util.HashMap;

/**
 * Classe responsavel por representar um controle que admnistra pesquisadores.
 */
public class ControlePesquisador {
    /**
     * Atributo que representa um Mapa contendo tipo String e tipo Pesquisador.
     * O tipo String é o email do pesquisador, que serve como identificador.
     */
    private HashMap<String, Pesquisador> pesquisadores;

    /**
     * Constroi o HahsMap pesquisadores.
     */
    public ControlePesquisador(){
        pesquisadores = new HashMap<>();
    }

    /**
     * Metodo responsavel por cadastrar pesquisadores no controle.
     * @param nome representa o nome do pesquisador a ser cadastrado.
     * @param funcao representa a funcao do pesquisador a ser cadastrado.
     * @param biografia representa a biografia do pesquisador a ser cadastrado.
     * @param email representa o email do pesquisador a ser cadastrado.
     * @param fotoURL representa a url da foto do pesquisador a ser cadastrado.
     */
    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String fotoURL){
        Pesquisador p = new Pesquisador(nome, funcao, biografia, email, fotoURL);
        pesquisadores.put(p.getEmail(),p );
    }

    /**
     * Metodo responsavel por alterar dados dos pesquisadores no controle.
     * @param email representa o email do pesquisador
     * @param atributo representa o atributo que determinado pesquisador quer alterar.
     * @param novoValor representa o novo valor para o atributo desejado.
     */
    public void alteraPesquisador(String email, String atributo, String novoValor) {
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        if(! pesquisadores.containsKey(email)) {
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }

        if(atributo.equals("email")){
            Pesquisador p = pesquisadores.get(email);
            p.alteraAtributo(atributo, novoValor);
            pesquisadores.put(p.getEmail(), p);
            pesquisadores.remove(email);
        }else {
            pesquisadores.get(email).alteraAtributo(atributo, novoValor);
        }
    }

    /**
     * Metodo responsavel por desativar pesquisadores no controle.
     * @param email representa o email do pesquisador.
     */
    public void desativaPesquisador(String email){
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
        pesquisadores.get(email).desativaPesquisador();
    }

    /**
     * Metodo responsavel por ativar pesquisadores no controle.
     * @param email representa o email do pesquisador.
     */
    public void ativaPesquisador(String email){
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
        pesquisadores.get(email).ativaPesquisador();
    }

    /**
     * Metodo responsavel por exibir pesquisadores.
     * @param email representa o email do pesquisador.
     * @return representacao em string dos dados do pesquisador.
     */
    public String exibePesquisador(String email) {
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
        return pesquisadores.get(email).toString();
    }

    /**
     * Metodo responsavel por retornar se o pesquisador esta ativo.
     * @param email representa o email do pesquisador.
     * @return representacao em boolean, true para pesquisador ativo e false para pesquisador inativo.
     */
    public boolean pesquisadorEhAtivo(String email){
        Verificador.verificaString("Email nao pode ser vazio ou nulo.", email);
        if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else{
            return pesquisadores.get(email).isAtivado();
        }
    }

}
