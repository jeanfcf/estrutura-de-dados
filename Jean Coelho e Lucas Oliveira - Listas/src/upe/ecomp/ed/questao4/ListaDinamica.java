package upe.ecomp.ed.questao4;

public class ListaDinamica<T> implements TADLista<T> {

	private NoLista<T> inicio;
	private int qtd;

	public ListaDinamica() {
	}

	public void inserir(T e) {
		try {
			if (indexOf(e) == -1) {
				// o elemento nao foi localizado, entao insere
				NoLista<T> novo = new NoLista<T>(e);
				if (inicio == null) {
					inicio = novo;
				} else {
					novo.proximo = inicio;
					inicio = novo;
				}
				qtd++;

			}
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		}

	}

	public String toString() {
		String s = "inicio ";
		NoLista<T> p = inicio;
		for (int i = 0; i < qtd; i++) {
			s += "-> " + p.info;
			p = p.proximo;
		}
		return s;
	}

	public void imprimeLista() {
		System.out.println(this.toString());
	}

	public void esvaziar() {
		inicio = null;
		qtd = 0;
	}

	public void remover(T e) {
		boolean flag = false;
		if (inicio != null) {
			if (inicio.info.equals(e)) {
				// elemento a ser removido está no inicio
				inicio = inicio.proximo;
			} else {
				NoLista<T> p = inicio;
				while (p.proximo != null) {
					if (p.proximo.info.equals(e)) {
						// encontrei o elemento a ser removido
						p.proximo = p.proximo.proximo;
						flag = true;
						break;
					} else {
						p = p.proximo;
					}
				}
				if (flag) {
					qtd--;
				}
			}
		}
	}

	public T procurarIEsimo(int i) {
		T r = null;
		if (i >= 0 && i < qtd) {
			NoLista<T> p = inicio;
			for (int j = 0; j < i; j++) {
				p = p.proximo;
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
			if (o.equals(p.info)) {
				r = i;
				break;
			} else {
				p = p.proximo;
			}
		}
		return r;
	}

	public void inverterL(NoLista<T> atual, NoLista<T> anterior) {
		if (!(atual.proximo == null)) {
			inverterL(atual.proximo, atual);
		}
		atual.proximo = anterior;
	}

	public void inverter() {
		NoLista<T> p = inicio;

		while (p.proximo != null) {
			p = p.proximo;
		}

		inverterL(inicio, null);

		inicio = p;
	}

}
