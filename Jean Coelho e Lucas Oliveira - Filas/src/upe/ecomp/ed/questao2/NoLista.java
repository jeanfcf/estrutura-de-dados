package upe.ecomp.ed.questao2;

public class NoLista<T> {
	public NoLista(T e) {
		info = e;
	}
	T info;
	NoLista<T> proximo;
}