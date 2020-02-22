package upe.ecomp.ed.questao1;

public class Main {

	public static void main(String[] args) {
		Formigas formiga1 = new Formigas("solidao", 10);
		Formigas formiga2 = new Formigas("ingrata", 5);
		Formigas formiga3 = new Formigas("que", 2);
		TADFilaPrioridade fila = new FilaPrioridade();

		fila.listaEspera(null);
		fila.listaEspera(formiga1);
		fila.listaEspera(formiga2);
		fila.listaEspera(formiga3);
		fila.imprimir();

		System.out.println("\n" + "A quantidade de formigas na fila é: " + fila.filaAlimentacao() + "\n");
		fila.listaPriori();
		System.out.println("\n");

		System.out.println("Removida: " + fila.alimentar().getNome());
		System.out.println("Removida: " + fila.alimentar().getNome());
		System.out.println("Removida: " + fila.alimentar().getNome()+"\n");
		
		fila.imprimir();
		System.out.println("A quantidade de formigas na fila é: " + fila.filaAlimentacao() + "\n");

		fila.listaPriori();
	}

}
