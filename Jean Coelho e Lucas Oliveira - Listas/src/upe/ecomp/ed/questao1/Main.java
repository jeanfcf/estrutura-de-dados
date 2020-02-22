package upe.ecomp.ed.questao1;

public class Main {

	public static void main(String[] args) {
		Clientes cliente = new Clientes("Lucas","08752369874");
		Clientes cliente1 = new Clientes("Jean","12778965142");
		Clientes cliente2 = new Clientes("Anthony","08752369874");
		Clientes cliente3 = new Clientes("Lucas","1288547614");
		Clientes cliente4 = new Clientes("Juju","18999459994");
		Clientes cliente5 = new Clientes("Jorge","189558716654");
		Clientes cliente6 = new Clientes("Chama","189558716654");
		Empresa<Clientes> empresa = new Empresa<Clientes>("Yes");
		
		empresa.adicionaCliente(cliente);
		empresa.adicionaCliente(cliente1);
		empresa.adicionaCliente(cliente2);
		empresa.adicionaCliente(cliente3);
		empresa.adicionaCliente(cliente4);
		empresa.adicionaCliente(cliente6);
		empresa.adicionaCliente(null);

		empresa.imprimeDados();
		
		
		System.out.println("O cliente esta cadastrado?"+":"+empresa.verifica(cliente4));
		System.out.println("O cliente esta cadastrado?"+":"+empresa.verifica(cliente3));
		System.out.println("O cliente esta cadastrado?"+":"+empresa.verifica(cliente5));
		System.out.println("O cliente esta cadastrado?"+":"+empresa.verifica(null));
		System.out.println("O cliente esta cadastrado?"+":"+empresa.verifica(cliente2));
	
		empresa.clientesCad();

	}

}
