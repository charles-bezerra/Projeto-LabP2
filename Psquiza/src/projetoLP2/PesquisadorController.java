package projetoLP2;

import java.util.HashMap;

public class PesquisadorController {
    private HashMap<String, Pesquisador > pesquisadores;

    public PesquisadorController(){
        pesquisadores = new HashMap<>();
    }

    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String fotoURL){
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("Campo nome nao pode ser nulo ou vazio.");
        }else if(funcao == null || funcao.isEmpty()){
            throw new IllegalArgumentException("Campo funcao nao pode ser nulo ou vazio.");
        }else if(biografia == null || biografia.isEmpty()){
            throw new IllegalArgumentException("Campo biografia nao pode ser nulo ou vazio.");
        }else if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Campo email nao pode ser nulo ou vazio.");
        }else if(fotoURL == null || fotoURL.isEmpty()){
            throw new IllegalArgumentException("Campo fotoURL nao pode ser nulo ou vazio.");
        }else if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")){
            throw new IllegalArgumentException("Formato de email invalido.");
        }else if(! fotoURL.startsWith("http://") & ! fotoURL.startsWith("https://")){
            throw new IllegalArgumentException("Formato de foto invalido.");
        }else if(pesquisadores.containsKey(email)){
            throw new IllegalArgumentException();
        }else{
            pesquisadores.put(email, new Pesquisador(nome, funcao, biografia, email, fotoURL ));
        }
    }

    public void alteraPesquisador(String email, String atributo, String novoValor){
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Campo email nao pode ser nulo ou vazio.");
        } else if(atributo == null || atributo.isEmpty()){
            throw new IllegalArgumentException("Campo atributo nao pode ser nulo ou vazio.");
        } else if(novoValor == null || novoValor.isEmpty()){
            throw new IllegalArgumentException("Campo " + atributo + " nao pode ser nulo ou vazio.");
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
            }else if(atributo.equals("email")){
                if(! novoValor.contains("@") || novoValor.startsWith("@") || novoValor.endsWith("@")){
                    throw new IllegalArgumentException("Formato de email invalido.");
                }else{
                    pesquisadores.get(email).setEmail(novoValor);
                }
            }else if(atributo.equals("fotoURL")){
                if(! novoValor.startsWith("http://") & ! novoValor.startsWith("https://")){
                    throw new IllegalArgumentException("Formato de foto invalido.");
                }else{
                    pesquisadores.get(email).setFotoURL(novoValor);
                }
            }
        }
    }


    public void desativaPesquisador(String email){
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Campo email nao pode ser nulo ou vazio.");
        } else if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")){
            throw new IllegalArgumentException("Formato de email invalido.");
        } else if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else if(pesquisadores.get(email).isAtivado() == false){
            throw new IllegalArgumentException("Pesquisador inativo.");
        } else{
            pesquisadores.get(email).setAtivado(false);
        }
    }
    public void ativaPesquisador(String email){
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Campo email nao pode ser nulo ou vazio.");
        } else if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Formato de email invalido.");
        } else if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else if(pesquisadores.get(email).isAtivado() == true){
            throw new IllegalArgumentException("Pesquisador ja ativado.");
        } else{
            pesquisadores.get(email).setAtivado(true);
        }
    }
    public String exibePesquisador(String email) {
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Campo email nao pode ser nulo ou vazio.");
        } else if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Formato de email invalido.");
        }else if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else if(pesquisadores.get(email).isAtivado() == false){
            throw new IllegalArgumentException("Pesquisador inativo.");
        } else{
            return pesquisadores.get(email).toString();
        }
    }
    public boolean pesquisadorEhAtivo(String email){
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("Campo email nao pode ser nulo ou vazio.");
        } else if(! email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException("Formato de email invalido.");
        }else if(! pesquisadores.containsKey(email)){
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        } else{
            return pesquisadores.get(email).isAtivado();
        }
    }

}