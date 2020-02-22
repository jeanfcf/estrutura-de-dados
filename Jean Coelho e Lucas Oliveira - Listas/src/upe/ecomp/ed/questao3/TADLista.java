package upe.ecomp.ed.questao3;

public interface TADLista<T>{
	
	public void add(T e);
	
	public ListaCircular<T> addInterc(ListaCircular<T> lista1, ListaCircular<T> lista2);
	
	boolean contains(ListaCircular<T> l1, ListaCircular<T> l2) throws NullPointerException;
}
