package upe.ecomp.ed.questao1;

public class NoLista<Clientes> {
	protected NoLista<Clientes> proxima;
	protected Clientes info;

	public NoLista(Clientes info) {
		this.info=info;
	}

}
