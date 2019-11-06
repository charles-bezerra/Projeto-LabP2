package projetoLP2.controladores;

import projetoLP2.classes.*;
import projetoLP2.enums.TipoFuncao;
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
        Verificador.verificaString("Campo funcao nao pode ser nulo ou vazio.", funcao);
        Pesquisador p;
        Funcao f;
        switch (funcao.toUpperCase()) {
            case "ESTUDANTE":
                f = new Aluno();
                p = new Pesquisador(nome, f, biografia, email, fotoURL);
                pesquisadores.put(p.getEmail(),p );
                break;
            case "PROFESSOR":
                f = new Professor();
                p = new Pesquisador(nome, f, biografia, email, fotoURL);
                pesquisadores.put(p.getEmail(),p );
                break;
            case "EXTERNO":
                f = new Externo();
                p = new Pesquisador(nome, f, biografia, email, fotoURL);
                pesquisadores.put(p.getEmail(),p );
                break;
            default:
                throw new IllegalArgumentException("Tipo " + funcao + " inexistente");
        }
    }

    /**
     * Metodo responsavel por alterar dados dos pesquisadores no controle.
     * @param email representa o email do pesquisador
     * @param atributo representa o atributo que determinado pesquisador quer alterar.
     * @param novoValor representa o novo valor para o atributo desejado.
     */
    public void alteraPesquisador(String email, String atributo, String novoValor) {
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        Verificador.verificaString("Campo " + atributo + " nao pode ser nulo ou vazio.", novoValor);
        if(! pesquisadores.containsKey(email)) {
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }

        switch (atributo.toUpperCase()) {
            case "EMAIL":
                Pesquisador p = pesquisadores.get(email);
                p.alteraAtributo(atributo, novoValor);
                pesquisadores.put(p.getEmail(), p);
                pesquisadores.remove(email);
                break;
            case "FUNCAO":
                switch (novoValor.toUpperCase()) {
                    case "ESTUDANTE":
                        pesquisadores.get(email).setFuncao(new Aluno());
                        break;
                    case "PROFESSOR":
                        pesquisadores.get(email).setFuncao(new Professor());
                        break;
                    case "EXTERNO":
                        pesquisadores.get(email).setFuncao(new Externo());
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo " + novoValor + " inexistente");
                }
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

        if(!pesquisadores.get(email).getFuncao().toUpperCase().equals("PROFESSOR")){
            throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
        }
        pesquisadores.get(email).alteraAtributo("formacao",formacao);
        pesquisadores.get(email).alteraAtributo("unidade",unidade);
        pesquisadores.get(email).alteraAtributo("data",data);
    }


    public void cadastraEspecialidadeAluno(String email, String semestre, String IEA){
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);

        if(!pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisadora nao encontrada.");
        }

        if(!pesquisadores.get(email).getFuncao().toUpperCase().equals("ESTUDANTE")){
            throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
        }
        pesquisadores.get(email).alteraAtributo("semestre",semestre);
        pesquisadores.get(email).alteraAtributo("IEA",IEA);
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

        if(!pesquisadorEhAtivo(email)){
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

}
