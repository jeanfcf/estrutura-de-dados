package upe.ecomp.ed.questao4;

public class PilhaInteiro {
	private int[] dados;
	private int qtd;

	public PilhaInteiro() {
		dados = new int[10];
	}

	public void push(int e) {
		if (!isFull()) {
			dados[qtd] = e;
			qtd++;
		}
	}
	
	public int pop() {
		int r = 0;
		if (!isEmpty()) {
			qtd--;
			r = dados[qtd];
			dados[qtd] = 0;
		}
		return r;
	}

	public int top() {
		int r = 0;
		if (!isEmpty()) {
			r = dados[qtd - 1];
		}
		return r;
	}

	public int size() {
		return qtd;
	}
	
	public boolean isEmpty() {
		return qtd == 0;
	}

	public boolean isFull() {
		return qtd == dados.length;
	}
	
	public int somaTotal() {
		int soma = 0;
		for(int i=0;i<qtd;i++) {
			soma += dados[i];
		}
		return soma;
	}

	public String toString() {
		String s = "(";
		for (int i = qtd - 1; i >= 0; i--) {
			s += dados[i];
			if (i != 0) {
				s += ",";
			}
		}
		s += ")";
		return s;
	}

	public void imprime() {
		System.out.println(this.toString());
	}
	
}