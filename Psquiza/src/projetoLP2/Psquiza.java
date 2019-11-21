package projetoLP2;

import easyaccept.EasyAccept;

import java.util.Scanner;

public class Psquiza {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("(1) - Testar US1 à US11;");
        System.out.println("(2) - Testar US12;");
        System.out.print("Opção: ");
        int o = sc.nextInt();

        switch (o){
            case 1: testes(); break;
            case 2: testePesistencia(); break;
            default:
                System.out.println("Opção indesponível!");
                break;
        }
    }

    public static void testes(){
        String[] args = new String[] {"projetoLP2.facades.Facade",
                "testes/aceitacao/use_case_1.txt",
                "testes/aceitacao/use_case_2.txt",
                "testes/aceitacao/use_case_3.txt",
                "testes/aceitacao/use_case_4.txt",
                "testes/aceitacao/use_case_5.txt",
                "testes/aceitacao/use_case_6.txt",
                "testes/aceitacao/use_case_7.txt",
                "testes/aceitacao/use_case_8.txt",
                "testes/aceitacao/use_case_9.txt",
                "testes/aceitacao/use_case_10.txt",
                "testes/aceitacao/use_case_11.txt",
        };
        EasyAccept.main(args);
    }

    public static void testePesistencia(){
        String args[] = new String[] {"projetoLP2.facades.Facade",
                "testes/aceitacao/use_case_12SALVAR.txt",
                "testes/aceitacao/use_case_12CARREGAR.txt"
        };
        EasyAccept.main(args);
    }
}
