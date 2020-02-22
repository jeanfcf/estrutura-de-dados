package upe.ecomp.ed.questao6;

public class teste {
	
	
	public static Fila<String> removeImpares(PilhaDinamica<String> pilha){
		
		PilhaDinamica<String> aux = new PilhaDinamica<String>();
		Fila<String> fila = new Fila<String>();
		
		int tamanho = pilha.size();
		
		for (int i = 0; i < tamanho; i++) {
			
			if(i%2 != 0) {
				fila.inserir(pilha.pop());
				
			}else {
				aux.push(pilha.pop());
			}
			
		}
		
		tamanho = aux.size();
		
		for (int i = 0; i < tamanho; i++) {
			
			pilha.push(aux.pop());
			
		}
		
		return fila;
		
	}
	
	public static void main(String[] args) {
		
		PilhaDinamica<String> pilha = new PilhaDinamica<String>();
		pilha.push("a");
		pilha.push("b");
		pilha.push("a");
		pilha.push("b");
		pilha.push("a");
		pilha.push("b");
		pilha.push("a");
		pilha.push("b");
		pilha.push("a");
		pilha.push("b");
		
		
		removeImpares(pilha).imprimir();;
		pilha.imprime();
		
		
		
		
		
		
	}

}
