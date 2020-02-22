package upe.ecomp.ed.questao10;

public class Lista {
	private NoLista inicio;
	private int qtd;

	public void inserir(Character e) {
		if (e != null) {
			NoLista novo = new NoLista(e);
			if (inicio == null) {
				inicio = novo;
			} else {
				novo.proximo = inicio;
				inicio = novo;
			}
			qtd++;
		}
	}
	
	//remove o ultimo da lista e retorna a ele
	public Character ultimo() {
		NoLista p = inicio;
		Character aux = null;
		if (qtd > 1) {
			while (p.proximo.proximo != null) {
				p = p.proximo;
			}
			aux = p.proximo.info;
			p.proximo = null;
		} else {
			aux = inicio.info;
			p = null;
		}
		qtd--;
		return aux;
	}
	
	//remove o primeiro da lista e retorna a ele
	public Character primeiro() {
		Character aux = null;
		aux = inicio.info;
		if (qtd != 0) {
			inicio = inicio.proximo;
			qtd--;
		}
		return aux;
	}

	public Lista sequenciaOrdem() {
		NoLista aux = inicio;
		Lista nova = new Lista();
		//lista para armazenar os numeros
		Lista numeros = new Lista();
		//lista para armazenar as letras
		Lista letras = new Lista();
		//percorre a lista de numeros
		for (int i = 0; i < qtd; i++) {
			//adiciona em ajuda se for numero
			if (aux.info >= 48 && aux.info <= 57) {
				numeros.inserir(aux.info);
			}
			aux = aux.proximo;
		}
		//adiciona os numeros em ordem inversa
		while (numeros.qtd != 0) {
			nova.inserir(numeros.ultimo());
		}
		
		aux = inicio;
		//percorre a lista de letras
		for (int i = 0; i < qtd; i++) {
			//se for letra adiciona em ajuda 
			if (aux.info >= 65 && aux.info <= 90) {
				letras.inserir(aux.info);
			}
			aux = aux.proximo;
		}
		//adiciona em nova pelo primeiro elemento da lista
		while (letras.qtd != 0) {
			nova.inserir(letras.primeiro());
		}
		return nova;
	}

	public void print() {
		System.out.print("inicio ");
		for (int i = 0; i < qtd; i++) {
			System.out.print("-> "+busca(i));
		}
		System.out.println();
	}
	
	public Character busca(int index) {
		NoLista aux = inicio;
		for (int i = 0; i < index; i++) {
			aux = aux.proximo;
		}
		return aux.info;
	}
}
