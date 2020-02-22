package upe.ecomp.ed.questao5;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		arvore.inserir(6);
		arvore.inserir(2);
		arvore.inserir(9);
		arvore.inserir(4);
		arvore.inserir(3);
		arvore.inserir(15);
		arvore.inserir(11);
		arvore.inserir(10);
		arvore.inserir(12);
		arvore.imprimir();
		System.out.println("Lista em pre-ordem");
		arvore.listaPreOrdem().print();
		System.out.println("--------");
		System.out.println("Lista em ordem");
		arvore.listaOrdem().print();
		System.out.println("--------");
		System.out.println("Lista em pos-ordem");
		arvore.listaPosOrdem().print();
		System.out.println("--------");
		System.out.println("Lista com elementos de altura e profundidade iguais");
		arvore.retornaLista().print();
		System.out.println("--------");
	}

}
