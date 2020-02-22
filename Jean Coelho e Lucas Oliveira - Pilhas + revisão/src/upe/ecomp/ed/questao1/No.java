package upe.ecomp.ed.questao1;

public class No {
	private No proximo;
	private String info;
	
	public No(String info) {
		this.info=info;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public String getInfo() {
		return info;
	}
	
}
