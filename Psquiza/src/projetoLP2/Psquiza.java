package projetoLP2;
import easyaccept.EasyAccept;

public class Psquiza {
    public static void main(String[] args){
    	args = new String[] {"projetoLP2.facades.Facade",
			"aceitacao_teste/use_case_1.txt",
			"aceitacao_teste/use_case_2.txt",
			"aceitacao_teste/use_case_3.txt",
			"aceitacao_teste/use_case_4.txt"
    	};
		EasyAccept.main(args);
    }
}