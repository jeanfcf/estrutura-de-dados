package upe.ecomp.ed.questao4;

public class NoLista<T> {
	public NoLista(T e) {
		info = e;
	}
	T info;
	NoLista<T> proximo;
}