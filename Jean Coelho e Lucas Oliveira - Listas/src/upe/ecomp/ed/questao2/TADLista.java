package upe.ecomp.ed.questao2;


public interface TADLista<T> {
	
	public void add(T obj);
	
	public void remove(T obj);
	
	public int size();
	
	public void print();
	
	public void removeAll(T obj);
	
	public void troca(T obj1,T obj2);
	
	public void concatenar(ListaEstatica<T> obj);
}
