package upe.ecomp.ed.questao2;

public class Loja {

	private ListaDinamica<Fila<Cliente>> caixas = new ListaDinamica<Fila<Cliente>>();

	public ListaDinamica<Fila<Cliente>> getCaixas() {
		return caixas;
	}

	public void setCaixas(ListaDinamica<Fila<Cliente>> caixas) {
		this.caixas = caixas;
	}

	public void atendeFila(int n) {
		caixas.procurarIEsimo(n).remover();
	}

	public Fila<Cliente> verificaMenor(ListaDinamica<Fila<Cliente>> lista) {
		int n = 0;
		int y = 0;
		Fila<Cliente> p = null;

		while (n < lista.size()-1) {

			if (lista.procurarIEsimo(y).size() < lista.procurarIEsimo(n + 1).size()) {
				p = lista.procurarIEsimo(y);
			} else {
				p = lista.procurarIEsimo(n + 1);
				y= n+1;
			}

			n++;
		}

		if (p.size() >= 3) {
			p = null;
		}

		return p;

	}

	public void chegaNovo(Cliente c) {

		int n = 0;
		Fila<Cliente> p;
		try {

			n = caixas.indexOf(verificaMenor(caixas));

			p = caixas.procurarIEsimo(n);

			p.inserir(c);
		} catch (NullPointerException e) {
			System.out.println("Filas Cheias");
		}

	}

	public void abreFila(int n) {
		caixas.procurarIEsimo(n).setStatus(true);;
		System.out.println("A fila "+n+"foi aberta");
	}

	public void fechaFila(int n) {
		caixas.procurarIEsimo(n).setStatus(false);;
		System.out.println("A fila "+n+"foi aberta");
	}

}
