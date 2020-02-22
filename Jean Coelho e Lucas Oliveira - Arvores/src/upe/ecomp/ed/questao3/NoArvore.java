package upe.ecomp.ed.questao3;

public class NoArvore {
	private String info;
	private NoArvore esq, dir;
	
	public NoArvore(String e) {
		info = e;
	}
	
	public String toString() {
		return "" + info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public NoArvore getEsq() {
		return esq;
	}

	public void setEsq(NoArvore esq) {
		this.esq = esq;
	}

	public NoArvore getDir() {
		return dir;
	}

	public void setDir(NoArvore dir) {
		this.dir = dir;
	}
}