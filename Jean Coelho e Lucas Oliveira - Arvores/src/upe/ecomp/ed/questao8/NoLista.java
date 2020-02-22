package upe.ecomp.ed.questao8;

public class NoLista<T> {
	
	public NoLista<T> proximo;
	public T info;

	public NoLista(T obj) {
		info= obj;
	}
}