package upe.ecomp.ed.questao9;

public class Lista {
	private No inicio;
	private int qtd;

	public Lista listaNova(Lista lista) {
		if (lista != null) {
			Lista nova = new Lista();
			int i = 0;
			while (i != lista.qtd) {
				if (!(nova.contains(lista.procurarIEsimo(i)))) {
					nova.inserir(lista.procurarIEsimo(i));
				}
				i++;
			}
			return nova;
		} else {
			return null;
		}
	}

	public void inserir(Integer e) {
		// o elemento nao foi localizado, entao insere
		No novo = new No(e);
		if (inicio == null) {
			inicio = novo;
		} else {
			novo.setProximo(inicio);
			inicio = novo;
		}
		qtd++;
	}

	public String toString() {
		String s = "inicio ";
		No p = inicio;
		for (int i = 0; i < qtd; i++) {
			s += "-> " + p.getInfo();
			p = p.getProximo();
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

	public void remover(Integer e) {
		if (inicio != null) {
			if (inicio.getInfo().equals(e)) {
				// elemento a ser removido está no inicio
				inicio = inicio.getProximo();
			} else {
				No p = inicio;
				while (p.getProximo() != null) {
					if (p.getProximo().getInfo().equals(e)) {
						// encontrei o elemento a ser removido
						p.getProximo().setProximo(p.getProximo().getProximo());
						break;
					} else {
						p = p.getProximo();
					}
				}
				qtd--;
			}
		}
	}

	public Integer procurarIEsimo(int i) {
		Integer r = null;
		if (i >= 0 && i < qtd) {
			No p = inicio;
			for (int j = 0; j < i; j++) {
				p = p.getProximo();
			}
			r = p.getInfo();
		}
		return r;
	}

	public boolean contains(Object o) {
		return (indexOf(o) != -1);
	}

	public int indexOf(Object o) {
		int r = -1;
		No p = inicio;
		for (int i = 0; i < qtd; i++) {
			if (o.equals(p.getInfo())) {
				r = i;
				break;
			} else {
				p = p.getProximo();
			}
		}
		return r;
	}

}
