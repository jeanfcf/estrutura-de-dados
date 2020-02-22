package upe.ecomp.ed.questao11;

public class No {
	private No proximo;
	private Aviao info;

	public No(Aviao info) {
		this.info = info;
	}

	public No getProximo() {
		return this.proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public Aviao getInfo() {
		return this.info;
	}
}
