package upe.ecomp.ed.questao1;

public class FilaPrioridade implements TADFilaPrioridade {
	public No inicio, fim;
	public int qtd;

	@Override
	public Formigas alimentar() {
		Formigas r = null;
		if (qtd != 0) {
			r = inicio.getFormiga();
			inicio = inicio.getProximo();
			if (inicio == null) {
				fim = inicio;
			}
			qtd--;
		}
		return r;
	}

	@Override
	public int filaAlimentacao() {
		return qtd;
	}

	@Override
	public void listaPriori() {
		if (inicio != null) {
			// variavel para armazenar a primeira ocorrencia de uma prioridade
			int a;
			for (int i = inicio.getFormiga().getPrioridade(); i <= fim.getFormiga().getPrioridade(); i++) {
				No aux = inicio;
				a = 0;
				while (aux != null) {
					if (aux.getFormiga().getPrioridade() == i) {
						if (a == 0) {
							System.out.print("Prioridade " + i);
						}
						System.out.print("-> " + aux.getFormiga().getNome());
						a = 1;
						if (aux.getProximo() != null
								&& aux.getProximo().getFormiga().getPrioridade() != aux.getFormiga().getPrioridade()) {
							System.out.println();
						}
					}
					aux = aux.getProximo();
				}
			}
		}
	}

	@Override
	public void listaEspera(Formigas formiga) {
		if (formiga != null) {
			No novo = new No(formiga);
			if (qtd == 0) {
				inicio = novo;
				fim = novo;
			} else {
				No aux = inicio;
				No recebe;
				while (aux.getFormiga().getPrioridade() <= formiga.getPrioridade()) {
					if (aux.getProximo() == null) {
						aux.setProximo(novo);
						fim = aux.getProximo();
						qtd++;
						return;
					} else if (aux.getProximo().getFormiga().getPrioridade() > formiga.getPrioridade()) {
						recebe = aux.getProximo();
						novo.setProximo(recebe);
						aux.setProximo(novo);
						qtd++;
						return;
					}
					aux = aux.getProximo();
				}
				recebe = inicio;
				novo.setProximo(recebe);
				fim = novo.getProximo().getProximo();
				inicio = novo;
			}
			qtd++;
		}
	}

	public String toString() {
		String s = "inicio ";
		No p = inicio;
		for (int i = 0; i < qtd; i++) {
			s += "-> " + p.getFormiga().getNome() + "," + p.getFormiga().getPrioridade();
			p = p.getProximo();
		}
		return s;
	}

	public void imprimir() {
		System.out.println(this.toString());
	}

}
