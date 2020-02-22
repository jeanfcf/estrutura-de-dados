package upe.ecomp.ed.questao2;

public interface TADPilha {
	
	public Livro remover(Livro e);
	
	public int indexOf(Livro e);
	
	public void push(Livro e);
	
	public Livro pop();
	
	public Livro top();
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public void imprime();
	
}
