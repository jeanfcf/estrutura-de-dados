package upe.ecomp.ed.questao6;

public class NoLista<T> {
	public NoLista(T e) {
		info = e;
	}
	T info;
	NoLista<T> proximo;
}