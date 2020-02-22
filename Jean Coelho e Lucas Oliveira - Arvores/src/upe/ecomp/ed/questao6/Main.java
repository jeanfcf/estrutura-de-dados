package upe.ecomp.ed.questao6;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria<Integer> arvoreTeste = new ArvoreBinaria<Integer>();
		ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();
		
		arvoreTeste.inserir(18);
		arvoreTeste.inserir(17);
		arvoreTeste.inserir(19);
		arvoreTeste.inserir(20);
		arvoreTeste.inserir(21);
		
		arvore.inserir(18);
		arvore.inserir(19);
		arvore.inserir(20);
		arvore.inserir(21);
		arvore.inserir(22);
		arvore.inserir(23);
		arvore.inserir(24);
		
		System.out.println("***IMPRIMINDO ARVORE***");
		arvore.imprimir();
		System.out.println();

		System.out.println("**PASSANDO PARA AVL:**");
		//chamei verificaAvl por arvoreTeste pra mostrar que não funciona apenas pro objeto
		arvoreTeste.verificaAvl(arvore);
		arvore.imprimir();
		System.out.println();
		System.out.println();
		
		System.out.println("***IMPRIMINDO ARVORETESTE***");
		arvoreTeste.imprimir();
		System.out.println();
		
		System.out.println("**PASSANDO PARA AVL:**");
		arvoreTeste.verificaAvl(arvoreTeste);
		arvoreTeste.imprimir();
		
	}

}
