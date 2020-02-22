package upe.ecomp.ed.questao7;

public class NoLista<T> {
	
	NoLista<T> proxima;
	T info;

	public NoLista(T obj) {
		info= obj;
	}
}