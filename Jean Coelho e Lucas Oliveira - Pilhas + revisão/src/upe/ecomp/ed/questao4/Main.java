package upe.ecomp.ed.questao4;

public class Main<T>{
	
	public static void main(String[] args) {
		PilhaPilhas teste = new PilhaPilhas();
		//variavel pra ser adicionada na pilha
		int i=1;
		//loop auxiliar para adicionar na pilha até ela ficar cheia
		while(!(teste.isFull())) {
			teste.push(i);
			i++;
		}
		teste.imprime();
		
		//imprime a pilha das somas
		System.out.print("A pilha das somas eh: ");
		teste.sum().imprime();
		
		//tenta adicionar na pilha cheia
		teste.push(2);
		//imprime a nova pilha
		System.out.print("a nova pilha eh: ");
		teste.imprime();
		
		//imprime a soma da nova pilha
		System.out.print("A pilha das somas eh: ");
		teste.sum().imprime();
		
		//remove um elemento da pilha e printa a mesma
		System.out.println("O elemento removido foi: "+ teste.pop());
		teste.imprime();
		
		//loop auxiliar para adicionar na pilha até ela ficar cheia
		i=0;
		while(!(teste.isFull())) {
			teste.push(i);
			i++;
		}
		teste.imprime();
		
		//loop auxiliar para remover 12 elementos da pilha
		for(int j=0;j<12;j++) {
		System.out.println("O elemento removido foi: "+ teste.pop());
		}
		
		//imprime a lista com os elementos removidos
		teste.imprime();

	}

}