package upe.ecomp.ed.questao2;


public class Fila<T> implements TADFila<T>{
	
	private boolean status;
	private No<T> inicio, fim;
	private int qtd;
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean status() {
		return this.status;
	}
	@Override
	public void inserir(T e) {
		No<T> novo = new No<T>(e);
		if (e != null || qtd < 3) {
			if (inicio == null) {
				inicio = novo;
				fim = novo;
			} else {
				fim.setProximo(novo);
				fim = novo;
			}
			qtd++;
		}

	}

	@Override
	public T remover() {
		T r = null;
		if (inicio != null) {
			r = inicio.getInfo();
			inicio = inicio.getProximo();
			if (inicio == null) {
				fim = null;
			}
			qtd--;
		}
		return r;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return qtd;
	}

	@Override
	public void imprimir() {
		System.out.println(toString());
	}

	public String toString() {
		String s = "inicio ->";
		No<T> p = inicio;
		for (int i = 0; i < qtd; i++) {
			s += "->" + p.getInfo();
			p = p.getProximo();
		}
		return s;
	}

	
	public void inverterL(No<T> atual, No<T> anterior) {
		if (atual.getProximo() != null) {
			inverterL(atual.getProximo(), atual);
		}
		atual.setProximo(anterior);
	}

	public void inverter() {
		No<T> p = inicio;
		inverterL(inicio, null);
		inicio = fim;
		fim = p;
	}

	public T getInicio() {
		T r = null;
		
		if(inicio != null)
			r = inicio.getInfo();
		return r;
		}
	@Override
	public boolean isEmpty() {
		if(inicio == null) { 
				return true;
		}
		return false;
	}


}
