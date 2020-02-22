package upe.ecomp.ed.questao6;

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

	// verifica se a arvore passada é uma avl e se não for a balanceia
	public void verificaAvl(ArvoreBinaria<T> arvore) {
		if (arvore != null) {
			if (!(isBalanceada(arvore.raiz))) {
				balanceiaArvore(arvore.raiz, arvore);
			}
		}
	}

	// metodo recursivo para balancear cada no da arvore caso necessario
	private void balanceiaArvore(NoBinario<T> no, ArvoreBinaria<T> arvore) {
		if (no != null) {
			balanceiaArvore(no.getEsq(), arvore);
			balanceiaArvore(no.getDir(), arvore);
			balanceia(no, arvore);
		}
	}

	// verifica se a arvore está balanceada
	private boolean isBalanceada(NoBinario<T> aux) {
		if (aux != null) {
			if (balanceamento(aux) > 1 || balanceamento(aux) < -1) {
				return false;
			}
			isBalanceada(aux.getEsq());
			isBalanceada(aux.getDir());
		}
		return true;
	}

	// calcula a altura de um no
	private int altura(NoBinario<T> no) {
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

	// retorna ao pai de um no passado como parametro
	private NoBinario<T> getPai(NoBinario<T> no, ArvoreBinaria<T> arvore) {
		if (no != null) {
			// se o no for diferente da raiz ele busca o pai dele
			if (no != arvore.raiz) {
				NoBinario<T> aux = arvore.raiz;
				while (aux != null) {
					if ((aux.getEsq() != null && aux.getEsq().getInfo().equals(no.getInfo()))
							|| (aux.getDir() != null && aux.getDir().getInfo().equals(no.getInfo()))) {
						break;
					} else if (compare(aux.getInfo(), no.getInfo()) < 0) {
						aux = aux.getDir();
					} else {
						aux = aux.getEsq();
					}
				}
				return aux;
				// caso contrario retorna a null, pois a raiz nao tem pai :(
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	// metodo responsavel por balancear a arvore
	private void balanceia(NoBinario<T> no, ArvoreBinaria<T> arvore) {
		// caso o indice do balanceamento for menor que -1 (significa que a esquerda é
		// maior que a direita)
		if (balanceamento(no) < -1) {
			// caso true, realiza a rotacao direita
			if (altura(no.getEsq().getEsq()) >= altura(no.getEsq().getDir())) {
				no = rotacaoDireita(no, arvore);
				// caso false, realiza dupla rotacao esquerda direita
			} else {
				no = duplaRotacaoEsquerdaDireita(no, arvore);
			}
			// caso o indice do balanceamento for maior que 1 (significa que a direita é
			// maior que a esquerda)
		} else if (balanceamento(no) > 1) {
			// caso true, realiza a rotacao para esquerda
			if (altura(no.getDir().getDir()) >= altura(no.getDir().getEsq())) {
				no = rotacaoEsquerda(no, arvore);
				// caso false, realiza dupla rotacao direita esquerda
			} else {
				no = duplaRotacaoDireitaEsquerda(no, arvore);
			}
		}
		if (getPai(no, arvore) != null) {
			balanceia(getPai(no, arvore), arvore);
		} else {
			arvore.raiz = no;

		}
	}

	// retorna ao indice do balanceamento (hDir - hEsq)
	private int balanceamento(NoBinario<T> no) {
		return altura(no.getDir()) - altura(no.getEsq());
	}

	// seta o pai de um no passado como parametro
	private void setPai(NoBinario<T> pai, NoBinario<T> filho) {
		// if para nao dar nullpointer
		if (pai != null && filho != null) {
			// o filho é menor que o pai logo o filho será setado a esquerda
			if (compare(pai.getInfo(), filho.getInfo()) > 0) {
				pai.setEsq(filho);
				// o filho é maior que o pai logo o filho será setado a direita
			} else {
				pai.setDir(filho);
			}
		}
	}

	// rotaciona a esquerda
	private NoBinario<T> rotacaoEsquerda(NoBinario<T> no, ArvoreBinaria<T> arvore) {
		// pega a direita do no
		NoBinario<T> direita = no.getDir();
		// agora o pai do nó passa a apontar para a direita
		setPai(getPai(no, arvore), direita);

		// a direita do nó passa a ser oq estava à esquerda da direita
		no.setDir(direita.getEsq());

		if (no.getDir() != null) {
			setPai(no, no.getDir());
		}
		// o nó passa a ser a esquerda da direita
		direita.setEsq(no);
		// seta a direita como pai do nó
		setPai(direita, no);

		// caso o pai da direita seja diferente de null
		if (getPai(direita, arvore) != null) {
			if (getPai(direita, arvore).getDir() == no) {
				getPai(direita, arvore).setDir(direita);

			} else if (getPai(direita, arvore).getEsq() == no) {
				getPai(direita, arvore).setEsq(direita);
			}
		}

		return direita;
	}

	// rotaciona a direita
	private NoBinario<T> rotacaoDireita(NoBinario<T> no, ArvoreBinaria<T> arvore) {

		NoBinario<T> esquerda = no.getEsq();
		setPai(getPai(no, arvore), esquerda);

		no.setEsq(esquerda.getDir());

		if (no.getEsq() != null) {
			setPai(no, no.getEsq());
		}

		esquerda.setDir(no);
		setPai(esquerda, no);

		if (getPai(esquerda, arvore) != null) {

			if (getPai(esquerda, arvore).getDir() == no) {
				getPai(esquerda, arvore).setDir(esquerda);

			} else if (getPai(esquerda, arvore).getEsq() == no) {
				getPai(esquerda, arvore).setEsq(esquerda);
			}
		}

		return esquerda;
	}

	// rotaciona esquerda direita
	private NoBinario<T> duplaRotacaoEsquerdaDireita(NoBinario<T> no, ArvoreBinaria<T> arvore) {
		no.setEsq(rotacaoEsquerda(no.getEsq(), arvore));
		return rotacaoDireita(no, arvore);
	}

	// rotaciona direita esquerda
	private NoBinario<T> duplaRotacaoDireitaEsquerda(NoBinario<T> no, ArvoreBinaria<T> arvore) {
		no.setDir(rotacaoDireita(no.getDir(), arvore));
		return rotacaoEsquerda(no, arvore);
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
