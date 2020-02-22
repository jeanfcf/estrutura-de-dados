package upe.ecomp.ed.questao6;

public class ListaDupla<T> implements TADLista {
	private Celula<String> inicio;
	private int qtd;

	@Override
	public void add(String obj) {
		if (obj != null) {
			Celula<String> novo = new Celula<String>(obj);
			if (qtd == 0) {
				this.inicio = novo;
			} else {
				Celula<String> aux = inicio;
				while (aux.proxima != null) {
					aux = aux.proxima;
				}
				aux.proxima = novo;
				novo.anterior = aux;
			}
			qtd++;
		}
	}

	@Override
	public void remove(String obj) {
		if (obj != null) {
			if (inicio != null) {
				if (inicio.getElemento().equals(obj)) {
					inicio = inicio.proxima;
					inicio.anterior = null;
					qtd--;
				} else {
					Celula<String> busca = inicio;
					while (busca.proxima != null) {
						if (busca.proxima.getElemento().equals(obj)) {
							busca.proxima = busca.proxima.proxima;
							qtd--;
							break;
						} else {
							busca = busca.proxima;
						}
					}
				}
			}
		}
	}

	@Override
	public void print() {
		System.out.println(this.toString());
	}

	@Override
	public String busca(int index) {
		Celula<String> aux = inicio;
		for (int i = 0; i < index; i++) {
			if (aux.proxima != null) {
				aux = aux.proxima;
			} else if (index > qtd) {
				return null;
			}
		}
		return aux.getElemento();
	}

	@Override
	public ListaDupla<String> retornaComum(ListaDupla<String> lista1, ListaDupla<String> lista2)
			throws NullPointerException {
		ListaDupla<String> retorna = null;
		try {
			if (lista1 != null || lista2 != null) {
				retorna = new ListaDupla<String>();
				Celula<String> aux1 = lista1.inicio;
				while (aux1 != null) {
					for (int i = 0; i < lista2.qtd; i++) {
						if (aux1.elemento.equals(lista2.busca(i))) {
							retorna.add(lista2.busca(i));
						}
					}
					aux1 = aux1.proxima;
				}
			}
		} catch (NullPointerException e) {
			System.out.print("Erro, uma das listas está vazia ** ");
		}
		return retorna;
	}

	public String toString() {
		String str = "LISTA [";
		Celula<String> inicia = inicio;
		
		if (qtd == 0) 
			str += "]";
		
		for (int i = 0; i < qtd; i++) {
			if (inicia != null) {
				if (inicia.proxima == null) {
					str += inicia.getElemento() + "]";
				} else {
					str += inicia.getElemento() + "-> ";
				}
				inicia = inicia.proxima;
			}
		}
		return str;
	}

}
