package upe.ecomp.ed.questao4;

public class PilhaPilhas {
	private PilhaInteiro[] dados;
	private int qtd;

	public PilhaPilhas() {
		qtd = 0;
		dados = new PilhaInteiro[10];
		for (int i = 0; i < dados.length; i++) {
			dados[i] = new PilhaInteiro();
		}
	}

	public void push(int e) {
		if (!(dados[dados.length-1].isFull())) {
			for (int i = 0; i < dados.length; i++) {
				if (!dados[i].isFull()) {
					if (dados[i].size() == 0) {
						qtd++;
					}
					dados[i].push(e);
					break;
				}
			}
		} else {
			int armazena = somaTudo();
			esvazia();
			push(armazena);
		}
	}
	
	//esvazia a lista
	public void esvazia() {
		int contador;
		for (int j = 0; j < qtd; j++) {
			contador = 0;
			while (contador != dados[j].size()) {
				dados[j].pop();
			}
		}
		qtd=0;
	}
	
	//soma todos os termos
	public int somaTudo() {
		int soma = 0;
		for (int i = 0; i < qtd; i++) {
			soma += dados[i].somaTotal();
		}
		return soma;
	}

	public PilhaInteiro sum() {
		PilhaInteiro nova = new PilhaInteiro();
		for (int i = 0; i < qtd; i++) {
			nova.push(dados[i].somaTotal());
		}
		return nova;
	}

	public int pop() {
		int r = 0;
		if (!isEmpty()) {
			r = dados[qtd-1].pop();
			if(dados[qtd-1].size()==0) {
				qtd--;
			}
		}
		return r;
	}

	public PilhaInteiro top() {
		PilhaInteiro r = null;
		if (!isEmpty()) {
			r = dados[qtd - 1];
		}
		return r;
	}

	public int size() {
		return qtd;
	}

	public boolean isEmpty() {
		return qtd == 0;
	}

	public boolean isFull() {
		return dados[dados.length-1].isFull();
	}

	public String toString() {
		String s = "topo ";
		for (int i = qtd - 1; i >= 0; i--) {
			s += "-> " + dados[i].toString();
		}
		return s;
	}

	public void imprime() {
		System.out.println(this.toString());
	}

}