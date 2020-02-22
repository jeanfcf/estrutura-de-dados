package upe.ecomp.ed.questao1;

public class Pilha {
	private No topo;
	private int qtd;

	public void push(String e) {
		if (e != null) {
			No novo;
			if (topo == null) {
				novo = new No(e);
				topo = novo;
			} else {
				novo = new No(topo.getInfo() + e);
				novo.setProximo(topo);
				topo = novo;
			}
			qtd++;
		}
	}

	public String desfazer() {
		String str = null;
		if (topo != null) {
			str = topo.getInfo();
			topo = topo.getProximo();
			qtd--;
		}
		return str;
	}

	public void listar() {
		if (topo != null) {
			No aux = topo;
			for (int i = 0; i < qtd; i++) {
				if (i == 0) {
					System.out.print("topo");
				}
				if (aux != null) {
					System.out.print(" -> " + aux.getInfo());
				}
				aux = aux.getProximo();
			}
			System.out.println();
		}
	}

	public int alterSalva() {
		return qtd;
	}
}
