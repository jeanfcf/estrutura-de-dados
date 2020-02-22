package upe.ecomp.ed.questao7;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria<String> arvore = new ArvoreBinaria<String>();
		ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<Integer>();
		arvore.inserir("c");
		arvore.inserir("a");
		arvore.inserir("d");
		arvore.inserir("e");
		arvore.inserir("b");
		arvore.inserir("f");

		arvore2.inserir(6);
		arvore2.inserir(2);
		arvore2.inserir(9);
		arvore2.inserir(4);
		arvore2.inserir(3);
		arvore2.inserir(15);
		arvore2.inserir(11);
		arvore2.inserir(12);

		arvore.imprimir();
		System.out.println("A folha mais proxima é: " + arvore.maisProximo());
		System.out.println("A folha mais distante é: " + arvore.maisLonge());
		
		System.out.println("------------------------------------------------");

		arvore2.imprimir();
		System.out.println("A folha mais proxima é: " + arvore2.maisProximo());
		System.out.println("A folha mais distante é: " + arvore2.maisLonge());
	}

}