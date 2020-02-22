package upe.ecomp.ed.questao9;

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

	//retorna a profundidade de um no
	private int profundidade(NoBinario<T> no) {
		if (no != null) {
			int [] profundidade = new int[1];
			buscaProfundidade(raiz, no,0,profundidade);
			return profundidade[0];
		} else {
			return -1;
		}
	}
	
	//busca a profundidade de um no
	private void buscaProfundidade(NoBinario<T> raiz, NoBinario<T> no, int profundidade, int[] n) {
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
	
	//retorna a quantidade de nos com profundidade impar
	public int numNosImpares() {
		int [] n = new int [1];
		buscaNo(n,raiz);
		return n[0];
	}
	
	//busca cada no e adiciona +1 no array caso a profundidade seja ímpar
	private void buscaNo(int[] n, NoBinario<T> no) {
		if (no != null) {
			if((profundidade(no)%2)!=0) {
				n[0]+=1;
			}
			buscaNo(n, no.getEsq());
			buscaNo(n, no.getDir());
		}
	}
	
	//retorna a arvore com os elementos de arv1 que nao estao contidos em arv2
	public ArvoreBinaria<T> arvoreDif(ArvoreBinaria<T> arv1, ArvoreBinaria<T> arv2){
		ArvoreBinaria<T> nova = new ArvoreBinaria<T>();
		addArvoreDif(arv1,raiz,arv2,nova);
		return nova;
	}
	
	//adiciona na arvore nova os elementos de arv1 que nao estao contidos em arv2
	private void addArvoreDif(ArvoreBinaria<T> arv1,NoBinario<T> no,ArvoreBinaria<T> arv2, ArvoreBinaria<T> nova) {
		if (no != null) {
			if(!(arv2.contains(arv1.no(no).getInfo()))) {
				nova.inserir(arv1.no(no).getInfo());
			}
			addArvoreDif(arv1,arv1.no(no).getEsq(),arv2,nova);
			addArvoreDif(arv1,arv1.no(no).getDir(),arv2,nova);
		}
	}
	
	//retorna ao no
	private NoBinario<T> no(NoBinario<T> no){
		return no;
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