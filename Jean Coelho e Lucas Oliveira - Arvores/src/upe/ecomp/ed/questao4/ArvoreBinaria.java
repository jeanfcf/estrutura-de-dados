package upe.ecomp.ed.questao4;

public class ArvoreBinaria<T> {
	private NoBinario<T> raiz;

	public void imprimir() {
		System.out.println("Imprimindo elementos em pre-ordem:");
		percursoPreOrdem(raiz);
		System.out.println("\n---------");
		System.out.println("Imprimindo elementos em ordem:");
		percursoEmOrdem(raiz);
		System.out.println("\n---------");
		System.out.println("Imprimindo elementos em ordem decrescente:");
		percursoEmOrdemDec(raiz);
		System.out.println("\n---------");
		System.out.println("Imprimindo elementos em pos-ordem:");
		percursoPosOrdem(raiz);
		System.out.println("\n---------");
	}

	public void esvaziar() {
		raiz = null;
	}

	//retorna a quantidade de folhas
	public int nFolhas() {
		int [] folhas = new int[1];
		buscaFolha(folhas, raiz);
		return folhas[0];
	}
	
	//retorna a quantidade de no
	public int nNo() {
		int [] nNo = new int[1];
		buscaNo(nNo, raiz);
		return nNo[0];
	}
	
	//retorna a profundidade de um no
	public int profundidade(NoBinario<T> no) {
		if (no != null) {
			int [] profundidade = new int[1];
			buscaProfundidade(raiz, no,0,profundidade);
			return profundidade[0];
		} else {
			return -1;
		}
	}
	
	//busca a profundidade de um no
	public void buscaProfundidade(NoBinario<T> raiz, NoBinario<T> no, int profundidade, int[] n) {
		if (raiz != null) {
			if (raiz.getInfo().equals(no.getInfo())) {
				n[0]=profundidade;
				return;
			} else if (compare(raiz.getInfo(), no.getInfo()) < 0) {
				buscaProfundidade(raiz.getDir(), no, profundidade + 1, n);
			} else {
				buscaProfundidade(raiz.getEsq(), no, profundidade + 1, n);
			}
		}
	}
	
	//busca cada no e adiciona +1 no array
	private void buscaNo(int[] n, NoBinario<T> no) {
		if (no != null) {
			n[0]+=1;
			buscaNo(n, no.getEsq());
			buscaNo(n, no.getDir());
		}
	}

	// metodo recursivo para buscar a quantidade de folhas
	private void buscaFolha(int [] n, NoBinario<T> no) {
		if (no != null) {
			buscaFolha(n, no.getEsq());
			buscaFolha(n, no.getDir());
			// caso seja uma folha, adiciona +1 no array
			if (no.getEsq() == null && no.getDir() == null) {
				n[0]+=1;
			}
		}
	}


	// se a < b retorna valor negativo
	// se a > b retorna valor positivo
	// caso contrario retorna 0
	private int compare(T a, T b) {
		int r = -1;
		if (a instanceof Comparable) {
			r = ((Comparable) a).compareTo(b);
		}
		return r;
	}

	public boolean contains(T e) {
		boolean r = false;
		NoBinario<T> aux = raiz;
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

	public void inserir(T e) {
		if (!contains(e)) {
			NoBinario<T> novo = new NoBinario<T>(e);
			if (raiz == null) {
				raiz = novo;
			} else {
				NoBinario<T> aux = raiz;
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

	private void percursoPreOrdem(NoBinario<T> no) {
		if (no != null) {
			System.out.print(no.getInfo() + " ");
			percursoPreOrdem(no.getEsq());
			percursoPreOrdem(no.getDir());
		}
	}

	private void percursoPosOrdem(NoBinario<T> no) {
		if (no != null) {
			percursoPosOrdem(no.getEsq());
			percursoPosOrdem(no.getDir());
			System.out.print(no.getInfo() + " ");
		}
	}

	private void percursoEmOrdem(NoBinario<T> no) {
		if (no != null) {
			percursoEmOrdem(no.getEsq());
			System.out.print(no.getInfo() + " ");
			percursoEmOrdem(no.getDir());
		}
	}

	private void percursoEmOrdemDec(NoBinario<T> no) {
		if (no != null) {
			percursoEmOrdemDec(no.getDir());
			System.out.print(no.getInfo() + " ");
			percursoEmOrdemDec(no.getEsq());
		}
	}
}
