package upe.ecomp.ed.questao2;

public class Pilha implements TADPilha {
	private No topo;
	private int qtd;

	public Livro remover(Livro e) {
		Pilha nova = new Pilha();
		Livro aux = null;
		int j = indexOf(e);
		for (int i = 0; i < j; i++) {
			aux = pop();
			nova.push(aux);
		}
		aux = pop();
		while (nova.qtd != 0) {
			push(nova.pop());
		}
		return aux;
	}

	public int indexOf(Livro e) {
		int r = -1;
		No aux = topo;
		for (int i = 0; i < qtd; i++) {
			if (aux.getInfo().equals(e)) {
				r = i;
				break;
			} else {
				aux = aux.getProximo();
			}
		}
		return r;
	}

	public Livro procurarIesimo(int n) {
		No aux = topo;
		for (int i = 0; i < n; i++) {
			aux = aux.getProximo();
		}
		return aux.getInfo();
	}

	@Override
	public void push(Livro e) {
		No novo = new No(e);
		if (topo == null) {
			topo = novo;
		} else {
			novo.setProximo(topo);
			topo = novo;
		}
		qtd++;
	}

	@Override
	public Livro pop() {
		Livro r = null;
		if (topo != null) {
			r = topo.getInfo();
			topo = topo.getProximo();
			qtd--;
		}
		return r;
	}

	@Override
	public Livro top() {
		Livro r = null;
		if (topo != null)
			r = topo.getInfo();
		return r;
	}

	@Override
	public int size() {
		return qtd;
	}

	@Override
	public boolean isEmpty() {
		return topo == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void imprime() {
		System.out.println(this.toString());
	}

	public String toString() {
		String s = "topo";
		No p = topo;
		for (int i = 0; i < qtd; i++) {
			s += "-> " + p.getInfo().getNome() + "," + p.getInfo().getAnoDeLancamento();
			p = p.getProximo();
		}
		return s;
	}
}
