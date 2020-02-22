package upe.ecomp.ed.questao5;

public class NoBinario {
	private Integer info;
	private NoBinario esq, dir;
	
	public NoBinario(Integer e) {
		info = e;
	}
	
	public String toString() {
		return "" + info;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

	public NoBinario getEsq() {
		return esq;
	}

	public void setEsq(NoBinario esq) {
		this.esq = esq;
	}

	public NoBinario getDir() {
		return dir;
	}

	public void setDir(NoBinario dir) {
		this.dir = dir;
	}
}
