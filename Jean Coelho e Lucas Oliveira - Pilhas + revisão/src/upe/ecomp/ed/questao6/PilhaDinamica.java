package upe.ecomp.ed.questao6;


public class PilhaDinamica<T> implements TADPilha<T> {

	private NoLista<T> topo;
	private int qtd;
	
	public void push(T e) {
		NoLista<T> novo = new NoLista<T>(e);
		if (topo == null) 
			topo = novo;
		else {
			novo.proximo=topo;
			topo = novo;
		}
		qtd++;
	}

	public T pop() {
		T r = null;
		if (topo != null) {
			r = topo.info;
			topo = topo.proximo;
			qtd--;
		}
		return r;
	}

	public T top() {
		T r = null;
		if (topo != null) 
			r = topo.info;
		return r;
	}

	public int size() {
		return qtd;
	}

	public boolean isEmpty() {
		return topo == null;
	}

	public boolean isFull() {
		return false;
	}

	public String toString() {
		String s = "topo ";
		NoLista<T> p = topo;
		for (int i = 0; i < qtd; i++) {
			s += "-> " + p.info;
			p = p.proximo;
		}
		return s;
	}
	
	public void imprime() {
		System.out.println(this.toString());
	}

}