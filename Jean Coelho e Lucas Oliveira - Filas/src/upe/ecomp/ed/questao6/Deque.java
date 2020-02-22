package upe.ecomp.ed.questao6;

public class Deque<T> {
	private T[] fila;
	private int qtd, inicio, fim;

	public Deque() {
		fila = (T[]) new Object[5];
		inicio = -1;
		qtd = 0;
		fim = -1;
	}

	public void addDir(T e) {
		if (qtd < fila.length && e != null) {
			if (qtd == 0) {
				inicio = 0;
				fim = inicio;
				fila[fim] = e;
			} else {
				fim += 1;
				// caso fim+1 seja maior que os limites da fila
				if (fim + 1 > fila.length) {
					// fim passa a ser zero [fim][1][2][3][4]
					fim = 0;
				}
				// adiciona e na posicao fim
				fila[fim] = e;
			}
			qtd++;
		}
	}

	public void addEsq(T e) {
		if (qtd < fila.length && e != null) {
			// caso nao exista nenhum elemento na fila
			if (qtd == 0) {
				inicio = 0;
				fim = inicio;
				fila[inicio] = e;
			} else {
				if (inicio != 0 && fila[inicio - 1] == null)
					inicio--;
				// caso o inicio seja menor que os limites da fila
				if (inicio - 1 < 0) {
					// inicio passa a ser 4 [0][1][2][3][inicio]
					inicio = fila.length - 1;
				}
				// adiciona na posicao inicio da fila
				fila[inicio] = e;
			}
			qtd++;
		}
	}

	public T popDir() {
		T r = null;
		if (qtd > 0) {
			r = fila[fim];
			fila[fim] = null;
			fim--;
			qtd--;
		}
		return r;
	}

	public T popEsq() {
		T r = null;
		if (qtd > 0) {
			r = fila[inicio];
			fila[inicio] = null;
			inicio += 1;
			qtd--;
		}
		return r;
	}

	public void print() {
		System.out.println(this.toString());
	}

	// metodos auxiliares
	public String toString() {
		String str;
		if (qtd != 0) {
			str = "inicio ";
			for (int i = 0, p = inicio; i < qtd; i++, p++) {
				// caso p+1 seja maior que o limite do array, p=0
				// pois p começa do inicio e nao necessariamente o inicio eh zero
				if (p + 1 > fila.length) {
					p = 0;
				}
				str += "-> " + fila[p];
			}
		} else {
			str = "A fila está vazia";
		}

		return str;
	}

	public int inicio() {
		return inicio;
	}

	public int fim() {
		return fim;
	}

}
