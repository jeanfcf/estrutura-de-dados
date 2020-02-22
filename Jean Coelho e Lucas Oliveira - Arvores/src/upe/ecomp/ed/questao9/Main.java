package upe.ecomp.ed.questao9;
public class Main {

	public static void main(String[] args) {
		ArvoreBinaria<String> arvore = new ArvoreBinaria<String>();
		ArvoreBinaria<String> arvore1 = new ArvoreBinaria<String>();

		System.out.println("*****ARVORE 1*****");
		arvore.inserir("a");
		arvore.inserir("b");
		arvore.inserir("c");
		arvore.inserir("d");
		arvore.inserir("j");
		arvore.inserir("k");
		arvore.inserir("i");
		arvore.imprimir();
		System.out.println("A quantidade de nós com profundidade impar é: "+ arvore.numNosImpares());
		System.out.print("---------");
		System.out.println("\n******ARVORE 2******");
		arvore1.inserir("a");
		arvore1.inserir("e");
		arvore1.inserir("j");
		arvore1.inserir("f");
		arvore1.inserir("z");
		arvore1.imprimir();
		System.out.println("A quantidade de nós com profundidade impar é: "+ arvore1.numNosImpares());
		System.out.print("---------");
		System.out.println("\n******NOVA ARVORE******");
		arvore.arvoreDif(arvore, arvore1).imprimir();	
		
	}

}