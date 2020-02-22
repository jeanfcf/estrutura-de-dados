package upe.ecomp.ed.questao1;

public interface TADLista<T> {
	
	public void adicionaCliente(Clientes cliente);
	
	public void imprimeDados();
	
	public boolean verifica(Clientes cliente);
	
	public void clientesCad();
}
