package upe.ecomp.ed.questao2;

public class No {
	private No proximo;
	private Livro info;
	
	public No(Livro info) {
		this.info = info;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public Livro getInfo() {
		return info;
	}
	
	

}
