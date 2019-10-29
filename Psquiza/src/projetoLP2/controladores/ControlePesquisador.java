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
        Verificador.verificaString("Campo nome nao pode ser nulo ou vazio.", nome);
        Verificador.verificaString("Campo funcao nao pode ser nulo ou vazio.", funcao);
        Verificador.verificaString("Campo biografia nao pode ser nulo ou vazio.", biografia);
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        Verificador.verificaString("Campo fotoURL nao pode ser nulo ou vazio.", fotoURL);

        if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")){
            throw new IllegalArgumentException("Formato de email invalido.");
        }else if(! fotoURL.startsWith("http://") & ! fotoURL.startsWith("https://")){
            throw new IllegalArgumentException("Formato de foto invalido.");
        }else{
            pesquisadores.put(email, new Pesquisador(nome, funcao, biografia, email, fotoURL));
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
        Verificador.verificaString("Campo atributo nao pode ser nulo ou vazio.", atributo);
        Verificador.verificaString("Campo " + atributo + " nao pode ser nulo ou vazio.", novoValor);
        if(atributo.equals("email")){
            if(! novoValor.contains("@") || novoValor.startsWith("@") || novoValor.endsWith("@")) {
                throw new IllegalArgumentException("Formato de email invalido.");
            }else {
                pesquisadores.put(novoValor, new Pesquisador(pesquisadores.get(email).getNome(),pesquisadores.get(email).getFuncao(),pesquisadores.get(email).getBiografia(),novoValor,pesquisadores.get(email).getFotoURL()));
                pesquisadores.remove(email);
            }
        } else if(atributo.equals("fotoURL")) {
            if (! novoValor.startsWith("http://") & !novoValor.startsWith("https://")) {
                throw new IllegalArgumentException("Formato de foto invalido.");
            } else {
                pesquisadores.get(email).setFotoURL(novoValor);
            }
        } else if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else if(pesquisadores.get(email).isAtivado() == false){
            throw new IllegalArgumentException("Pesquisador inativo.");
        } else{
            if (atributo.equals("nome")){
                pesquisadores.get(email).setNome(novoValor);
            }else if(atributo.equals("funcao")){
                pesquisadores.get(email).setFuncao(novoValor);
            }else if(atributo.equals("biografia")){
                pesquisadores.get(email).setBiografia(novoValor);

            }
        }
    }

    /**
     * Metodo responsavel por desativar pesquisadores no controle.
     * @param email representa o email do pesquisador.
     */
    public void desativaPesquisador(String email){
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")){
            throw new IllegalArgumentException("Formato de email invalido.");
        } else if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else if(pesquisadores.get(email).isAtivado() == false){
            throw new IllegalArgumentException("Pesquisador inativo.");
        } else{
            pesquisadores.get(email).setAtivado(false);
        }
    }

    /**
     * Metodo responsavel por ativar pesquisadores no controle.
     * @param email representa o email do pesquisador.
     */
    public void ativaPesquisador(String email){
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Formato de email invalido.");
        } else if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else if(pesquisadores.get(email).isAtivado() == true){
            throw new IllegalArgumentException("Pesquisador ja ativado.");
        } else{
            pesquisadores.get(email).setAtivado(true);
        }
    }

    /**
     * Metodo responsavel por exibir pesquisadores.
     * @param email representa o email do pesquisador.
     * @return representacao em string dos dados do pesquisador.
     */
    public String exibePesquisador(String email) {
        Verificador.verificaString("Campo email nao pode ser nulo ou vazio.", email);
        if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Formato de email invalido.");
        }else if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else if(pesquisadores.get(email).isAtivado() == false){
            throw new IllegalArgumentException("Pesquisador inativo.");
        } else{
            return pesquisadores.get(email).toString();
        }
    }

    /**
     * Metodo responsavel por retornar se o pesquisador esta ativo.
     * @param email representa o email do pesquisador.
     * @return representacao em boolean, true para pesquisador ativo e false para pesquisador inativo.
     */
    public boolean pesquisadorEhAtivo(String email){
        Verificador.verificaString("Email nao pode ser vazio ou nulo.", email);
        if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Formato de email invalido.");
        }else if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else{
            return pesquisadores.get(email).isAtivado();
        }
    }

}
