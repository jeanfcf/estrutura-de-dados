package upe.ecomp.ed.questao11;

public class Fila {
	private No inicio, fim;
	private int qtd;

	public void add(Aviao e) {
		if (e != null) {
			No novo = new No(e);
			if (qtd == 0) {
				inicio = novo;
				fim = inicio;
			} else {
				fim.setProximo(novo);
				fim = novo;
			}
			qtd++;
		}
	}

	public No getInicio() {
		return inicio;
	}

	public void setInicio(No inicio) {
		this.inicio = inicio;
	}

	public No getFim() {
		return fim;
	}

	public void setFim(No fim) {
		this.fim = fim;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

}
