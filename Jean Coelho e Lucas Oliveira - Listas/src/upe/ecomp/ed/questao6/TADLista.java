package upe.ecomp.ed.questao6;

public interface TADLista{
	
	public void add(String obj);
	
	public void remove(String obj);
	
	public void print();
	
	public String busca(int index);
	
	public ListaDupla<String> retornaComum(ListaDupla<String> lista1,ListaDupla<String> lista2);
	
}
