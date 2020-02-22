package upe.ecomp.ed.questao9;

public class No {
	private No proximo;
	private Integer info;
	
	public No(Integer info) {
		this.info = info;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}
	
 
}
