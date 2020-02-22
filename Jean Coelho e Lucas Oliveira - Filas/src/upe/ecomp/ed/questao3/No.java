package upe.ecomp.ed.questao3;

public class No<T> {
	No<T> proximo;
	T e;

	public T getE() {
		return e;
	}

	public No(T e) {
		this.e = e;
	}

}
