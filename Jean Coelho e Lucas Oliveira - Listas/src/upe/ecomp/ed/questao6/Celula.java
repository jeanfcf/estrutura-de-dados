package upe.ecomp.ed.questao6;

public class Celula<T> {
	
	Celula<T> proxima;
	Celula<T> anterior;
	T elemento;
	
	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public Celula(T e) {
		elemento = e;
	}
}
