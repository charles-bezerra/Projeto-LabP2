package projetoLP2.controladores;

import projetoLP2.classes.*;
import projetoLP2.enums.TipoFuncao;
import projetoLP2.util.Verificador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsavel por representar um controle que admnistra pesquisadores.
 * @author Melquisedeque Carvalho Silva
 */
public class ControlePesquisador {
    /**
     * Atributo que representa um Mapa contendo tipo String e tipo Pesquisador.
     * O tipo String é o email do pesquisador, que serve como identificador.
     */
    private Map<String, Pesquisador> pesquisadores;

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
        Verificador.verificaString("Atributo nao pode ser vazio ou nulo.", atributo);

        if(! pesquisadores.containsKey(email)) {
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }

        switch (atributo.toUpperCase()) {
            case "EMAIL":
                Verificador.verificaString("Campo " + atributo.toLowerCase() + " nao pode ser nulo ou vazio.", novoValor);
                Pesquisador p = pesquisadores.get(email);
                p.alteraAtributo(atributo, novoValor);
                pesquisadores.put(p.getEmail(), p);
                pesquisadores.remove(email);
                break;
            default:
                pesquisadores.get(email).alteraAtributo(atributo, novoValor);
        }
    }


    public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data){
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        if(!pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisadora nao encontrada.");
        }
        pesquisadores.get(email).setEspecialidadeProfessor(formacao, unidade, data);
    }


    public void cadastraEspecialidadeAluno(String email, String semestre, String IEA){
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        if(!pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisadora nao encontrada.");
        }
        pesquisadores.get(email).setEspecialidadeAluno(semestre, IEA);
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
        if(!pesquisadorEhAtivo(email)) {
            throw new IllegalArgumentException("Pesquisador inativo.");
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


    public String listaPesquisadores(String tipo){
        Verificador.verificaString("Campo tipo nao pode ser nulo ou vazio.", tipo);

        TipoFuncao[] arr = TipoFuncao.values();
        boolean contem = false;
        for(TipoFuncao f : arr){
            if(f.toString().equals(tipo.toUpperCase())){
                contem = true;
                break;
            }
        }
        if(!contem){
            throw new IllegalArgumentException("Tipo " + tipo + " inexistente.");
        }

        String saida = "";

        for (Pesquisador p : pesquisadores.values()) {
            if(p.getFuncao().toUpperCase().equals(tipo.toUpperCase())) {
                saida += p.toString() + " | ";
            }
        }
        if (saida.length() > 0){
            saida = saida.substring(0,saida.length() - 3 );
        }
        return saida;
    }


    public Map<String,Pesquisador> getPesquisadores(){
        return pesquisadores;
    }


    /**
     * Metodo responsavel por adicionar a um Arraylist de forma ordenada todos os pesquisadores que possuem o termo.
     * @param termo o termo a ser buscado nos pesquisadores.
     * @return um ArrayList de Strings com todos os pesquisadores que possuem o termo.
     */
    public ArrayList<String> ordenaPesquisador(String termo){
        ArrayList<Pesquisador> buscasOrdenadas = new ArrayList<Pesquisador>(pesquisadores.values());
        Collections.sort(buscasOrdenadas);
        ArrayList<String> retorno = new ArrayList<>();

        for (Pesquisador pesquisador: buscasOrdenadas){
            if (pesquisador.getBiografia().toLowerCase().contains(termo.toLowerCase())) {
                retorno.add(pesquisador.getEmail() + ": " + pesquisador.getBiografia());

            }

        }

        return retorno;
    }

}
