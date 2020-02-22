package upe.ecomp.ed.questao1;

import java.util.StringTokenizer;

public class ArvoreExp {
	
	private NoArvore raiz;

	public ArvoreExp(String e) {
		montarArvore(e);
	}

	public NoArvore getRaiz() {
		return raiz;
	}

	public void add(String e) {
		if (!contains(e)) {
			NoArvore novo = new NoArvore(e);
			if (raiz == null) {
				raiz = novo;
			} else {
				NoArvore aux = raiz;
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

	public boolean contains(String e) {
		boolean r = false;
		NoArvore aux = raiz;
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

	// se a < b retorna valor negativo
	// se a > b retorna valor positivo
	// caso contrario retorna 0
	private int compare(String a, String b) {
		int r = -1;
		if (a instanceof Comparable) {
			r = ((Comparable) a).compareTo(b);
		}
		return r;
	}

	public void montarArvore(String e) {
		Pilha<NoArvore> operador = new Pilha<NoArvore>();
		Pilha<NoArvore> valor = new Pilha<NoArvore>();
		Pilha<String> parenteses = new Pilha<String>();
		StringTokenizer teste = new StringTokenizer(e, " ");
		while (teste.hasMoreTokens()) {
			String temp = teste.nextToken();
			if (temp.equals("+") || temp.equals("-") || temp.equals("/") || temp.equals("*")) {
				operador.push(new NoArvore(temp));
			} else if (temp.equals("(")) {
				parenteses.push(temp);
			} else if (temp.equals(")")) {
				parenteses.pop();
				operador.topo().setDir(valor.pop());
				operador.topo().setEsq(valor.pop());
				valor.push(operador.pop());
			} else {
				valor.push(new NoArvore(temp));
			}

		}
		this.raiz = valor.topo();
	}
	
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

	private void percursoPreOrdem(NoArvore no) {
		if (no != null) {
			System.out.print(no.getInfo() + " ");
			percursoPreOrdem(no.getEsq());
			percursoPreOrdem(no.getDir());
		}
	}

	private void percursoPosOrdem(NoArvore no) {
		if (no != null) {
			percursoPosOrdem(no.getEsq());
			percursoPosOrdem(no.getDir());
			System.out.print(no.getInfo() + " ");
		}
	}

	private void percursoEmOrdem(NoArvore no) {
		if (no != null) {
			percursoEmOrdem(no.getEsq());
			System.out.print(no.getInfo() + " ");
			percursoEmOrdem(no.getDir());
		}
	}

	private void percursoEmOrdemDec(NoArvore no) {
		if (no != null) {
			percursoEmOrdemDec(no.getDir());
			System.out.print(no.getInfo() + " ");
			percursoEmOrdemDec(no.getEsq());
		}
	}

}