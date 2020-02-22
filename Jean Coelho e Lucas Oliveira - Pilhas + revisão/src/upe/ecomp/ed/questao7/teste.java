package upe.ecomp.ed.questao7;


public class teste {
	
public static void main(String[] args) {
	TADPilha<Integer> pilha = new PilhaDinamica<Integer>();
	pilha.push(2);
	pilha.push(1);
	pilha.push(3);
	pilha.push(4);
	pilha.push(2);
	pilha.push(5);
	pilha.imprime();
	System.out.println("Removido -> " + pilha.pop());
	System.out.println("Removido -> " + pilha.pop());
	System.out.println("Removido -> " + pilha.pop());
	pilha.push(9);
	pilha.push(7);
	pilha.imprime();
}

}
