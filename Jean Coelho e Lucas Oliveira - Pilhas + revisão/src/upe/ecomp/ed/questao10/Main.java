package upe.ecomp.ed.questao10;

public class Main {

	public static void main(String[] args) {
		Lista teste = new Lista();
		
		teste.inserir('G');
		teste.inserir('8');
		teste.inserir('W');
		teste.inserir('7');
		teste.inserir('T');
		teste.inserir('5');
		teste.inserir('E');
		teste.inserir('1');
		teste.inserir('A');
	
		teste.print();
		
		teste.sequenciaOrdem().print();

	}

}
