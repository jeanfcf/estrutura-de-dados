package upe.ecomp.ed.questao5;

public class ListaLigada<T> {

	private NoLista<T> inicio;
	private int qtd;

	public void add(T e) {
		if (!contains(e)) {
			// o elemento nao foi localizado, entao insere
			NoLista<T> novo = new NoLista<T>(e);
			if (inicio == null) {
				inicio = novo;
			} else {
				NoLista<T> aux = inicio;
				while (aux.proxima != null) {
					aux = aux.proxima;
				}
				aux.proxima = novo;
			}
			qtd++;
		}
	}

	public String toString() {
		String s = "inicio ";
		NoLista<T> p = inicio;
		for (int i = 0; i < qtd; i++) {
			if(p!=null) {
			s += "-> " + p.info;
			p = p.proxima;
			}
		}
		return s;
	}

	public void print() {
		System.out.println(this.toString());
	}

	public void esvaziar() {
		inicio = null;
		qtd = 0;
	}

	public int size() {
		return qtd;
	}

	public T busca(int i) {
		T r = null;
		if (i >= 0 && i < qtd) {
			NoLista<T> p = inicio;
			for (int j = 0; j < i; j++) {
				p = p.proxima;
			}
			r = p.info;
		}
		return r;
	}

	public boolean contains(Object o) {
		return (indexOf(o) != -1);
	}

	public int indexOf(Object o) {
		int r = -1;
		NoLista<T> p = inicio;
		for (int i = 0; i < qtd; i++) {
			if (p != null) {
				if (o.equals(p.info)) {
					r = i;
					break;
				} else {
					p = p.proxima;
				}
			}
		}
		return r;
	}

}
