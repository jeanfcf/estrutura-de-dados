package upe.ecomp.ed.questao3;

public class Pilha<T> {
	private NoPilha<T> topo;
	private int qtd;

	public void push(T e) {
		NoPilha<T> novo = new NoPilha<T>(e);
		if (topo == null)
			topo = novo;
		else {
			novo.setProximo(topo);
			topo = novo;
		}
		qtd++;
	}

	public T pop() {
		T r = null;
		if (topo != null) {
			r = topo.getInfo();
			topo = topo.getProximo();
			qtd--;
		}
		return r;
	}
	
	public void esvazia() {
		while(qtd!=0) {
			this.pop();
		}
	}

	public T topo() {
		T r = null;
		if (topo != null)
			r = topo.getInfo();
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
		NoPilha<T> p = topo;
		for (int i = 0; i < qtd; i++) {
			s += "-> " + p.getInfo();
			p = p.getProximo();
		}
		return s;
	}

	public void imprime() {
		System.out.println(this.toString());
	}

}
