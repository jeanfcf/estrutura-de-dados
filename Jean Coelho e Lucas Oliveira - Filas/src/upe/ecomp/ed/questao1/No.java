package upe.ecomp.ed.questao1;

public class No {
	private No proximo;
	private Formigas formiga;
	
	public No(Formigas formiga) {
		this.formiga=formiga;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public Formigas getFormiga() {
		return formiga;
	}

	public void setFormiga(Formigas formiga) {
		this.formiga = formiga;
	}
	
	
}
