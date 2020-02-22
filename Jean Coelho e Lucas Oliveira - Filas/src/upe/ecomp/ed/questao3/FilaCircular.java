package upe.ecomp.ed.questao3;

public class FilaCircular<T> {
	private No<T> inicio;
	private No<T> fim;
	private int qtd;

	public T getInicio() {
		return inicio.getE();
	}

	public T getFim() {
		return fim.getE();
	}

	public void enqueue(T e) {
		No<T> novo = new No<T>(e);
		if (qtd == 0) {
			inicio = novo;
			fim = inicio;
			inicio.proximo = fim;
		} else {
			fim.proximo = novo;
			novo.proximo = inicio;
			fim=novo;
		}
		qtd++;
	}

	public T dequeue() {
		T aux = null;
		if (qtd != 0) {
			aux = inicio.getE();
			inicio = inicio.proximo;
			fim.proximo = inicio;
			qtd--;
			if (inicio == null) {
				fim = null;
			}
		}
		return aux;
	}

	public int size() {
		return qtd;
	}

	public void imprimir() {
		System.out.println(this.toString());
	}

	public String toString() {
		String r = "inicio ";
		No<T> aux = inicio;
		for (int i = 0; i < qtd; i++) {
			r += "-> " + aux.e;
			aux = aux.proximo;
		}
		return r;
	}
}
