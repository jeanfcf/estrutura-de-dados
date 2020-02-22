package upe.ecomp.ed.questao2;

public class ListaEstatica<T> implements TADLista<T> {

	private T[] array;
	private int quant;

	public ListaEstatica() {
		array = (T[]) new Object[10];
	}

	@Override
	public void add(T obj) {
		if(obj!=null) {
		if (quant < array.length) {
			array[quant] = obj;
			quant++;
		} else {
			T[] novoArray = (T[]) new Object[quant * 2];
			for (int i = 0; i < quant; i++) {
				novoArray[i] = array[i];
			}
			array = novoArray;
			add(obj);
		}}
	}
	
	//remove a primeira ocorrencia do elemento
	@Override
	public void remove(T obj) {
		if(obj!=null) {
		for (int i = 0; i < quant; i++) {
			if (array[i].equals(obj)) {
				array[i] = array[quant - 1];
				array[quant - 1] = null;
				quant--;
				break;
			}
		}
		}
	}

	@Override
	public int size() {
		int armazena=0;
		for(int i=1;array[i-1]!=null;i++) {
			armazena=i;
		}
		return armazena;
	}

	@Override
	public void print() {
		System.out.print("[");
		for (int i = 0; i < quant; i++) {
			if (i == quant - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.println("]"+"\n");
	}
	
	//remove todas as ocorrencias do elemento
	@Override
	public void removeAll(T obj) {
		do {
			remove(obj);
		} while (existe(obj));
	}

	@Override
	public void troca(T obj1, T obj2) {
		int armazena1=indice(obj1);
		int armazena2=indice(obj2);
		if(existe(obj1) && existe(obj2)) {
			array[armazena1]=array[armazena2];
			array[armazena2]=obj1;
		}
	}
	
	@Override
	public void concatenar(ListaEstatica<T> lista) {
		for(int i=0; i<lista.quant;i++) {
			this.add(lista.getArray(i));
		}
	}
	
	
	//metodos auxiliares 
	public T getArray(int i) {
		return this.array[i];
	}
	
	
	public int indice(T obj) {
		for(int i=0;i<quant;i++) {
			if(array[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean existe(T obj) {
		for (int i = 0; i < quant; i++) {
			if (array[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}


}
