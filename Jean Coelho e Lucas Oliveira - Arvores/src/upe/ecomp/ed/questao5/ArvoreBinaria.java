package upe.ecomp.ed.questao5;

public class ArvoreBinaria {
	private NoBinario raiz;

	public void imprimir() {
		System.out.println("Imprimindo elementos em pre-ordem:");
		percursoPreOrdem(raiz);
		System.out.println("\n---------");
	}

	public void esvaziar() {
		raiz = null;
	}

	// metodos para adicionar na lista de acordo com a ordem
	public void addPosOrdem(ListaLigada<Integer> lista, NoBinario no) {
		if (no != null) {
			addPosOrdem(lista, no.getEsq());
			addPosOrdem(lista, no.getDir());
			lista.add(no.getInfo());
		}
	}

	public void addOrdem(ListaLigada<Integer> lista, NoBinario no) {
		if (no != null) {
			addOrdem(lista, no.getEsq());
			lista.add(no.getInfo());
			addOrdem(lista, no.getDir());
		}
	}

	public void addPreOrdem(ListaLigada<Integer> lista, NoBinario no) {
		if (no != null) {
			lista.add(no.getInfo());
			addPreOrdem(lista, no.getEsq());
			addPreOrdem(lista, no.getDir());
		}
	}

	// metodos que chamam os metodos de add na lista e retornam a lista
	public ListaLigada<Integer> listaPreOrdem() {
		ListaLigada<Integer> lista = new ListaLigada<Integer>();
		addPreOrdem(lista, raiz);
		return lista;
	}

	public ListaLigada<Integer> listaOrdem() {
		ListaLigada<Integer> lista = new ListaLigada<Integer>();
		addOrdem(lista, raiz);
		return lista;
	}

	public ListaLigada<Integer> listaPosOrdem() {
		ListaLigada<Integer> lista = new ListaLigada<Integer>();
		addPosOrdem(lista, raiz);
		return lista;
	}
	
	//retorna uma lista de inteiros com os valores que tem mesma profundidade e mesma altura
	public ListaLigada<Integer> retornaLista() {
		ListaLigada<Integer> lista = new ListaLigada<Integer>();
		addListaAltProf(raiz, lista);
		return lista;
	}
	
	//adiciona na lista os valores com mesma profundidade e mesma altura
	private void addListaAltProf(NoBinario no, ListaLigada<Integer> lista) {
		if (no != null) {
			if (profundidade(no) == altura(no)) {
				lista.add(no.getInfo());
			}
			addListaAltProf(no.getEsq(), lista);
			addListaAltProf(no.getDir(), lista);
		}
	}
	
	//retorna a profundidade de um no
	private int profundidade(NoBinario no) {
		if (no != null) {
			//armazenei num array porque nao consegui pensar numa maneira mais viavel
			int[] profundidade = new int[1];
			buscaProfundidade(raiz, no, 0, profundidade);
			return profundidade[0];
		} else {
			return -1;
		}
	}
	
	//busca a profundidade do no
	private void buscaProfundidade(NoBinario raiz, NoBinario no, int profundidade, int[] n) {
		if (raiz != null) {
			if (raiz.getInfo().equals(no.getInfo())) {
				n[0] = profundidade;
				return;
			} else if (compare(raiz.getInfo(), no.getInfo()) < 0) {
				buscaProfundidade(raiz.getDir(), no, profundidade + 1, n);
			} else {
				buscaProfundidade(raiz.getEsq(), no, profundidade + 1, n);
			}
		}
	}

	// calcula a altura de um no
	private int altura(NoBinario no) {
		if (no == null) {
			return -1;
		} else {
			int hEsq = altura(no.getEsq());
			int hDir = altura(no.getDir());
			if (hDir < hEsq) {
				return hEsq + 1;
			} else {
				return hDir + 1;
			}
		}
	}

	// se a < b retorna valor negativo
	// se a > b retorna valor positivo
	// caso contrario retorna 0
	private int compare(Integer a, Integer b) {
		int r = -1;
		if (a instanceof Comparable) {
			r = ((Comparable) a).compareTo(b);
		}
		return r;
	}

	public boolean contains(Integer e) {
		boolean r = false;
		NoBinario aux = raiz;
		while (aux != null) {
			if (aux.getInfo().equals(e)) {
				r = true;
				break;
			} else if (compare(aux.getInfo(), e) < 0) {
				aux = aux.getDir();
			} else {
				aux = aux.getEsq();
			}
		}
		return r;
	}

	public void inserir(Integer e) {
		if (!contains(e)) {
			NoBinario novo = new NoBinario(e);
			if (raiz == null) {
				raiz = novo;
			} else {
				NoBinario aux = raiz;
				while (aux != null) {
					if (compare(aux.getInfo(), e) < 0) {
						if (aux.getDir() == null) {
							aux.setDir(novo);
							break;
						} else {
							aux = aux.getDir();
						}
					} else {
						if (aux.getEsq() == null) {
							aux.setEsq(novo);
							break;
						} else {
							aux = aux.getEsq();
						}
					}
				}
			}
		}
	}

	private void percursoPreOrdem(NoBinario no) {
		if (no != null) {
			System.out.print(no.getInfo() + " ");
			percursoPreOrdem(no.getEsq());
			percursoPreOrdem(no.getDir());
		}
	}

	

}
