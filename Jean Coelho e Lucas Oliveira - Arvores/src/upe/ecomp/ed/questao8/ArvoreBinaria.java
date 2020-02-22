package upe.ecomp.ed.questao8;

public class ArvoreBinaria<T> {

	public NoBinario<T> raiz;

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

	public void remover(T e) {
		int c = compare(raiz.getInfo(), e);
		if (c == 0) {
			// o elemento a ser removido é a raiz
			if (raiz.getEsq() == null) {
				raiz = raiz.getDir();
			} else if (raiz.getDir() == null) {
				raiz = raiz.getEsq();
			} else {
				removerRaizSubArvore(raiz);
			}
		} else {
			// o elemento a ser removido não é a raiz
			// procura o elemento na arvore
			NoBinario<T> p = raiz;
			while (p != null) {
				c = compare(p.getInfo(), e);
				if (c < 0) {
					// o elemento a ser removido pode estar à direita
					if (p.getDir() != null && p.getDir().getInfo().equals(e)) {
						// encontrei o elemento que deve ser removido
						if (p.getDir().getEsq() == null) {
							p.setDir(p.getDir().getDir());
						} else if (p.getDir().getDir() == null) {
							p.setDir(p.getDir().getEsq());
						} else {
							// o elemento a ser removido nao é folha
							removerRaizSubArvore(p.getDir());
						}
						break;
					} else {
						// desce na árvore em busca do elemento
						p = p.getDir();
					}
				} else {
					// o elemento a ser removido pode estar à esquerda
					if (p.getEsq() != null && p.getEsq().getInfo().equals(e)) {
						// encontrei o elemento que deve ser removido
						if (p.getEsq().getEsq() == null) {
							p.setEsq(p.getEsq().getDir());
						} else if (p.getEsq().getDir() == null) {
							p.setEsq(p.getEsq().getEsq());
						} else {
							// o elemento a ser removido nao é folha
							removerRaizSubArvore(p.getEsq());
						}
						break;
					} else {
						// desce na árvore em busca do elemento
						p = p.getEsq();
					}
				}
			}
		}
	}

	// metodo recursivo para buscar as folhas
	private void buscaFolha(ListaLigada<Integer> n1, ListaLigada<NoBinario<T>> n, NoBinario<T> no, int tamanho) {
		if (no != null) {
			buscaFolha(n1, n, no.getEsq(), tamanho + 1);
			buscaFolha(n1, n, no.getDir(), tamanho + 1);
			// caso seja uma folha, adiciona na lista e adiciona tmb o tamanho
			if (no.getEsq() == null && no.getDir() == null) {
				n.add(no);
				n1.add(tamanho);
			}
		}
	}

	// passa por cada elemento e soma no vetor na posicao de seu nivel
	public void buscaNivel(int[] n1, NoBinario<Integer> no, int tamanho) {
		if (no != null) {
			buscaNivel(n1, no.getEsq(), tamanho + 1);
			buscaNivel(n1, no.getDir(), tamanho + 1);
			n1[tamanho] = n1[tamanho] + no.getInfo();
		} 
	}

	// retorna a profundidade da arvore
	public int profundidade() {

		ListaLigada<NoBinario<T>> nova = new ListaLigada<NoBinario<T>>();
		ListaLigada<Integer> n = new ListaLigada<Integer>();
		buscaFolha(n, nova, raiz, 0);
		int maior =-1;
		// acha a profundidade da maior folha
		if (n.size() != 0) {
			maior = n.busca(0);
			for (int i = 0, j = i + 1; i < n.size() && j < n.size(); i++, j++) {

				if (n.busca(j) > n.busca(i)) {
					if (n.busca(j) > maior) {
						maior = n.busca(j);
					}

				} else {
					if (n.busca(i) > maior) {
						maior = n.busca(i);
					}
				}

			}

		}

		return maior;

	}

	private void removerRaizSubArvore(NoBinario<T> raiz) {
		// a raiz não é uma folha!
		if (raiz.getEsq().getDir() == null) {
			raiz.setInfo(raiz.getEsq().getInfo());
			raiz.setEsq(raiz.getEsq().getEsq());
		} else {
			// localiza o maior elemento da subarvore esquerda
			NoBinario<T> q = raiz.getEsq();
			while (q.getDir().getDir() != null) {
				q = q.getDir();
			}
			raiz.setInfo(q.getDir().getInfo());
			q.setDir(q.getDir().getEsq());
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
