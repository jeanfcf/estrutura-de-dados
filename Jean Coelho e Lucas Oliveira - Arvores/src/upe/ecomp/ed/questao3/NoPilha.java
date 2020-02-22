package upe.ecomp.ed.questao3;

public class NoPilha<T> {

	protected T info;
	protected NoPilha<T> proximo;

	public NoPilha(T e) {
		info = e;
	}
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NoPilha<T> getProximo() {
		return proximo;
	}
	public void setProximo(NoPilha<T> proximo) {
		this.proximo = proximo;
	}
	
}
