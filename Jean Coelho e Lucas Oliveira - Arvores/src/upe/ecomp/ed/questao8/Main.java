package upe.ecomp.ed.questao8;

public class Main {

	public static ListaLigada<Integer> somaNivel(ArvoreBinaria<Integer> arvore) {

		ListaLigada<Integer> lista = new ListaLigada<Integer>();
		int[] n1 = new int[arvore.profundidade() + 1];


		arvore.buscaNivel(n1, arvore.raiz, 0);

		// adiciona os elementos do vetor na lista
		for (int i = (n1.length - 1); i >= 0; i--)
			lista.add(n1[i]);

		return lista;
	}

	public static void main(String[] args) {
		ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();

		arvore.inserir(15);
		arvore.inserir(14);
		arvore.inserir(35);
		arvore.inserir(12);
		arvore.inserir(9);
		arvore.inserir(5);
		arvore.inserir(10);
		arvore.inserir(13);
		arvore.inserir(24);
		arvore.inserir(22);
		arvore.inserir(36);
		arvore.inserir(40);
		arvore.inserir(39);
		arvore.inserir(38);
		arvore.inserir(42);
		arvore.inserir(45);
		arvore.inserir(41);
		arvore.inserir(43);
		arvore.inserir(44);

		arvore.imprimir();
		somaNivel(arvore).imprimeLista();
		;

	}

}