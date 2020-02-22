package upe.ecomp.ed.questao10;

public class Main {


	

	public static void main(String[] args) {
		
		ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();
		ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<Integer>();
		
		arvore.inserir(9);
		arvore.inserir(8);
		arvore.inserir(3);
		arvore.inserir(20);
		arvore.inserir(16);
		arvore.inserir(10);
		arvore.inserir(5);
		
		arvore2.inserir(20);
		arvore2.inserir(16);
		arvore2.inserir(10);

		arvore.imprimir();
		arvore2.imprimir();
		
		arvore.removerArvore(arvore2);
		
		
		arvore.imprimir();
		arvore2.imprimir();

		

		

		;

	}

}