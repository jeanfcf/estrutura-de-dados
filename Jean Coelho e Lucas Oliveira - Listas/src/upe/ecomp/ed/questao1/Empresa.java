package upe.ecomp.ed.questao1;

public class Empresa<T> implements TADLista {
	private String nomeEmpresa;
	private NoLista<Clientes> inicio;
	private int quant;

	public Empresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	@Override
	public void adicionaCliente(Clientes cliente) {
		if (!verificaClienteCpf(cliente)) {
			NoLista<Clientes> novo = new NoLista<Clientes>(cliente);
			if (quant == 0) {
				inicio = novo;
			} else {
				novo.proxima = inicio;
				inicio = novo;
			}
			quant++;
		}
	}

	@Override
	public void imprimeDados() {
		System.out.print("LISTA ");
		for (int i = 0; i < quant; i++) {
			System.out.print("-> " + busca(i).getNome() + " : " + busca(i).getCpf() + "");
		}
		System.out.println();
	}
	
	@Override
	public boolean verifica(Clientes cliente) {
		if (cliente != null) {
			for (int i = 0; i < quant; i++) {
				if (cliente.getCpf().equals(busca(i).getCpf()) && cliente.getNome().equals(busca(i).getNome())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void clientesCad() {
		System.out.println(quant + " clientes cadastrados;");
	}
	
	//metodos auxiliares
	//metodo para buscar um cliente num dado index
	public Clientes busca(int index) {
		NoLista<Clientes> aux = inicio;
		for (int i = 0; i < index; i++) {
			aux = aux.proxima;
		}
		return aux.info;
	}
	
	//verifica se o cliente está contido pelo Cpf
	public boolean verificaClienteCpf(Clientes cliente) {
		if (cliente != null) {
			for (int i = 0; i < quant; i++) {
				if (cliente.getCpf().equals(busca(i).getCpf())) {
					return true;
				}
			}
		} else if (cliente == null) {
			return true;
		}
		return false;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

}
