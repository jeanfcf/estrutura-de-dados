package upe.ecomp.ed.questao7;

public class NoLista<T> {
	public NoLista(T e) {
		info = e;
	}
	T info;
	NoLista<T> proximo;
}