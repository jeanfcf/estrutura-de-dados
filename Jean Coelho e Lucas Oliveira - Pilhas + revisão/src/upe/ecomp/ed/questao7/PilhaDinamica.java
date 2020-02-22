package upe.ecomp.ed.questao7;


public class PilhaDinamica<T> implements TADPilha<T> {

	private Fila<T> dados = new Fila<T>();
	private int qtd;

	public void push(T e) {
		if(e != null) {
		dados.inserir(e);
		qtd++;
		}
	}

	public T pop() {
		T r =null;
		dados.inverter();
		if(dados.getInicio() != null) {
		r = dados.remover();
		qtd--;
		}
		dados.inverter();
		
		return r;
	}

	public T top() {
		T r = null;
		dados.inverter();
		if (dados.getInicio() != null) {
			r = dados.getInicio();
		}
			dados.inverter();
		return r;
	}

	public int size() {
		return qtd;
	}

	public boolean isEmpty() {
		boolean flag = false;
		dados.inverter();
		if(dados.getInicio() == null) {
			flag = true;
		}
		dados.inverter();
		return  flag;
	}

	public boolean isFull() {
		return false;
	}

	public String toString() {
		String s = "topo ";
		dados.inverter();
		s = s + dados.toString();
		dados.inverter();
		return s;
	}

	public void imprime() {
		System.out.println(this.toString());
	}
	

	
	
	
	
}
