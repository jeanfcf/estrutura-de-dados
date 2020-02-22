package upe.ecomp.ed.questao6;

public class Main {

	public static void main(String[] args) {
		ListaDupla<String> nova = new ListaDupla<String>();
		ListaDupla<String> denovo = new ListaDupla<String>();
		
		//add elementos na lista nova
		nova.add("Lucas");
		nova.add("Matheus");
		nova.add("é lindo");
		nova.add(null);
		nova.print();
		
		//add elementos na lista denovo
		denovo.add("Que");
		denovo.add("ingrata");
		denovo.add("solidao");
		denovo.add("Lucas");
		denovo.add("Matheus");
		denovo.add("é lindo");
		denovo.print();
		
		//printa os elementos contidos na posicao x
		System.out.println("O elemento é:"+nova.busca(0));
		System.out.println("O elemento é:"+nova.busca(1));
		System.out.println("O elemento é:"+denovo.busca(2));
		System.out.println("O elemento é:"+denovo.busca(10));
		
		//retorna aos elementos comuns entre as listas
		nova.retornaComum(null, denovo).print();
		denovo.retornaComum(denovo, null).print();
		nova.retornaComum(nova, denovo).print();
		
		//remove os elementos das listas
		nova.remove(null);
		nova.remove("Matheus");
		nova.print();
		denovo.remove("Lucas");
		denovo.remove("Matheus");
		denovo.remove("é lindo");
		denovo.print();
	}

}
