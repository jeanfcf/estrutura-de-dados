package upe.ecomp.ed.questao9;

public class Main {

	public static void main(String[] args) {
		Lista teste = new Lista();
		teste.inserir(8);
		teste.inserir(1);
		teste.inserir(12);
		teste.inserir(9);
		teste.inserir(5);
		teste.inserir(8);
		teste.inserir(-7);
		teste.inserir(5);
		teste.inserir(12);
		teste.imprimeLista();
		System.out.println();
		teste.listaNova(teste).imprimeLista();

	}

}
