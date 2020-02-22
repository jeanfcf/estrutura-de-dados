package upe.ecomp.ed.questao4;

public interface TADLista<T> {

	public void imprimeLista();

	public void esvaziar();

	public void inserir(T e);

	public void remover(T e);

	public T procurarIEsimo(int i);

	public boolean contains(Object o);

	public int indexOf(Object o);

	public void inverter();

}