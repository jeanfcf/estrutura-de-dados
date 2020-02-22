package upe.ecomp.ed.questao4;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria<Integer> arvore2 = new ArvoreBinaria<Integer>();
		NoBinario<Integer> no = new NoBinario<Integer>(2);
		arvore2.inserir(6);
		arvore2.inserir(2);
		arvore2.inserir(9);
		arvore2.inserir(4);
		arvore2.inserir(3);
		arvore2.inserir(15);
		arvore2.inserir(11);
		arvore2.inserir(10);
		arvore2.inserir(12);
		arvore2.imprimir();
		System.out.println("A quantidade de folhas eh: " + arvore2.nFolhas());
		System.out.println("A quantidade de nós eh: " + arvore2.nNo());
		System.out.println("A profundidade do nó "+ no.getInfo()+" eh: " + arvore2.profundidade(no));
		
	}

}
