package upe.ecomp.ed.questao3;

public class ListaCircular<T> implements TADLista<T> {
	NoLista<T> inicio;
	int qtd;

	@Override
	public void add(T e) {
		if (e != null) {
			NoLista<T> novo = new NoLista<T>(e);
			if (qtd == 0) {
				inicio = novo;
				novo.proximo = inicio;
			} else {
				NoLista<T> aux = inicio;
				while (aux.proximo != inicio) {
					aux = aux.proximo;
				}
				aux.proximo = novo;
				aux.proximo.proximo = inicio;
			}
			qtd++;
		}

	}

	// verifica se a lista está contida na outra
	@Override
	public boolean contains(ListaCircular<T> l1, ListaCircular<T> l2) throws NullPointerException {
		try {
			NoLista<T> p = l1.inicio;
			NoLista<T> q = l2.inicio;

			if (l1.indexOf(q.info) != -1) {
				for (int j = 0; j < l1.indexOf(q.info); j++) {
					p = p.proximo;
				}
				for (int j = 0; j < l2.qtd; j++) {
					if (!(q.info.equals(p.info))) {
						return false;
					}
					q = q.proximo;
					p = p.proximo;
				}
			}
			p = l1.inicio;
			q = l2.inicio;
			if (l1.indexOf(q.info) == -1) {
				return false;
			}
			removerLista(l1, l2);
			return true;
		} catch (NullPointerException e) {
			System.out.print("Erro ao tentar verificar-> ");
		}
		return false;
	}

	@Override
	public ListaCircular<T> addInterc(ListaCircular<T> lista1, ListaCircular<T> lista2) throws NullPointerException {
		try {
				ListaCircular<T> nova = new ListaCircular<T>();
				int cont = 0;
				while (listaMaior(lista1, lista2).busca(cont) != null) {
					if (cont < lista1.qtd) {
						nova.add(lista1.busca(cont));
					}
					if (cont < lista2.qtd) {
						nova.add(lista2.busca(cont));
					}
					cont++;
				}
				return nova;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	// metodos auxiliares
	// remove um elemento contido numa lista
	public void removerElemento(ListaCircular<T> lista, T e) {
		int percorre = 0, size = qtd;
		if (lista.inicio.info.equals(e)) {
			lista.inicio = lista.inicio.proximo;
			lista.qtd--;
		} else {
			NoLista<T> busca = lista.inicio;
			while (percorre != size) {
				if (busca.proximo.info.equals(e)) {
					busca.proximo = busca.proximo.proximo;
					lista.qtd--;
					break;
				} else {
					busca = busca.proximo;
				}
			}
		}
	}

	public void removerLista(ListaCircular<T> lista1, ListaCircular<T> lista2) {
		NoLista<T> aux = lista2.inicio;
		for (int i = 0; i < lista2.qtd; i++) {
			removerElemento(lista1, (T) aux.info);
			aux = aux.proximo;
		}
	}

	// retorna a maior lista
	public ListaCircular<T> listaMaior(ListaCircular<T> lista1, ListaCircular<T> lista2) {
		if (lista1.qtd >= lista2.qtd)
			return lista1;
		else
			return lista2;
	}

	// retorna a um elemento na posicao index
	public T busca(int index) {
		NoLista<T> aux = inicio;
		for (int i = 0; i < index; i++) {
			if (index > qtd) {
				return null;
			} else {
				aux = aux.proximo;
			}
		}
		return (T) aux.info;
	}

	public String toString() {
		String s = "[INICIO] ";
		NoLista<T> p = inicio;
		for (int i = 0; i < qtd; i++) {
			s += "-> " + p.info;
			p = p.proximo;
		}
		s += "-> [INICIO]";
		return s;
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

	public void imprimeLista() {
		System.out.println(this.toString());
	}

}
